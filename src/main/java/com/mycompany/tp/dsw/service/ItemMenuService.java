package com.mycompany.tp.dsw.service;

import java.math.BigDecimal;
import java.util.List;

import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.PlatoDto;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.Vendedor;

public class ItemMenuService {

    private CategoriaDao categoriaDao;
    private ItemMenuDao itemMenuDao;
    private VendedorService vendedorService;
    private ServiceManager serviceManager;

    public ItemMenuService() {
        itemMenuDao = new ItemMenuDao();
        categoriaDao = new CategoriaDao();
        serviceManager = ServiceManager.getInstance();
        vendedorService = serviceManager.getVendedorService();

    }

    /**
     * Crea y persiste un ItemMenu.
     * - ItemMenu = Plato o Bebida.
     * - Manejo de id unicos con currentID.
     * - Parseo Solo los atributos de ItemMenu.
     * - Los de la subclase en su respectivo service.
     * 
     * @param itemMenu
     */
    protected void registrarItemMenu(ItemMenuDto itemMenuDto) {

        Vendedor vendedor = vendedorService.buscarPorIdConListaItem(itemMenuDto.getIdVendedor());
        ItemMenu itemMenu = parseItemMenu(itemMenuDto, vendedor);
        vendedor.getItemsMenu().add(itemMenu);
        itemMenuDao.save(itemMenu);
    }

    /**
     * Busca el item filtrado por el nombre.
     * - Ignora mayusculas y minusculas.
     * 
     * @param nombre
     * @return Lista de los items que coincide con el @param.
     */
    public List<ItemMenu> buscarItemMenuPorNombreYVendedor(String nombre, Integer id) {
        return itemMenuDao.findActiveByNombre(nombre, id);
    }

    /**
     * Modifica los datos de un item especifico.
     * - Del objeto itemMenu pasado como parametro.
     * - Solo los datos a modificar permanecen no nulos.
     * - Parseo solo los atributos de Item Menu.
     * - Los de la subclase en su respectivo service.
     * 
     * @param itemMenu El objeto item con los datos modificados.
     */
    protected void modificarItemMenu(ItemMenuDto itemMenuDto) {
        Vendedor vendedor = vendedorService.buscarPorIdConListaItem(itemMenuDto.getIdVendedor());
        ItemMenu itemMenu = parseItemMenu(itemMenuDto, vendedor); // ver si puede ser null el vendedor
        vendedor.getItemsMenu().add(itemMenu);
        itemMenuDao.update(itemMenu);
    }

    /**
     * Elimina un item del restaurante, segun el id.
     * - Eliminar = setear atributo activo a false.
     * 
     * @param id
     */
    public void eliminarItemMenu(Integer id) {
        ItemMenu item = itemMenuDao.findByIdAndActive(id);
        itemMenuDao.deleteLogico(item);
    }

    /**
     * Obtiene una lista de todos los item ACTIVOS del sistema
     * - OJO no son los item de un restaurante
     * - Mirar metodo filtrarPorVendedor()
     * 
     * @return Lista con los items
     */
    public List<ItemMenu> obtenerTodosLosItemMenu() {
        return itemMenuDao.findAllActive();
    }

    /**
     * Busca los item segun un Restaurante
     * 
     * @param vendedor El restaurante a buscar los item
     * @return Lista de item que tiene el restaurante
     * @throws VendedorNoEncontradoException Si no encuentra el Restaurante
     */
    public List<ItemMenu> filtrarPorVendedor(VendedorDto vendedorDto) throws VendedorNoEncontradoException {
        return itemMenuDao.findByVendedorId(vendedorDto.getId());
    }

    public ItemMenu buscarPorId(Integer idItem) {
        return itemMenuDao.findById(idItem);
    }

    private ItemMenu parseItemMenu(ItemMenuDto itemMenuDto, Vendedor vendedor) {
        // 1. Parsear los datos del ItemMenu

        String id = itemMenuDto.getIdText();
        if (!esNullOrBlank(id)) {
            itemMenuDto.setId(Integer.valueOf(id));
        }

        String precio = itemMenuDto.getPrecioText();
        if (!esNullOrBlank(precio)) {
            itemMenuDto.setPrecio(new BigDecimal(precio));
        }

        String categoria = itemMenuDto.getCategoriaText();
        if (!esNullOrBlank(categoria)) {
            itemMenuDto.setCategoria(categoriaDao.findByNombre(categoria));
        }

        // 2. Crear el objeto
        switch (itemMenuDto.getClass().getSimpleName()) {
            case "PlatoDto":
                PlatoDto platoDto = (PlatoDto) itemMenuDto;
                return new Plato(platoDto, vendedor);
            case "BebidaDto":
                BebidaDto bebidaDto = (BebidaDto) itemMenuDto;
                Bebida bebida = new Bebida(bebidaDto, vendedor);
                return bebida;

            default:
                return null;
        }
    }

    private Boolean esNullOrBlank(String palabra) {
        return palabra == null || palabra.isBlank();
    }

}
