package com.mycompany.tp.dsw.memory;

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

public class ItemMenuMemory {

    private CategoriaDao categoriaDao;
    private VendedorMemory vendedorMemory;
    private ItemMenuDao itemMenuDao;

    public ItemMenuMemory() {
        itemMenuDao = new ItemMenuDao();
        categoriaDao = new CategoriaDao();
        vendedorMemory = new VendedorMemory();

    }

    /**
     * Crea y persiste un ItemMenu
     * - ItemMenu = Plato o Bebida
     * - Manejo de id unicos con currentID
     * 
     * @param itemMenu
     */
    public void registrarItemMenu(ItemMenu itemMenu) {
        itemMenuDao.add(itemMenu);
    }

    /**
     * Busca el item filtrado por el nombre
     * - Ignora mayusculas y minusculas
     * 
     * @param nombre
     * @return Lista de los items que coincide con el @param
     */
    public List<ItemMenu> buscarItemMenuPorNombre(String nombre) {
        return itemMenuDao.findByNombre(nombre);
    }

    /**
     * Modifica los datos de un item especifico
     * - Del objeto itemMenu pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param itemMenu El objeto item con los datos modificados
     */
    public void modificarItemMenu(ItemMenuDto itemMenuDto) {
        // 1. Parsear los datos del ItemMenu, incluyendo los de la subclase
        ItemMenu itemMenu = parseItemMenu(itemMenuDto);

        // 2. Persistir el dato
        itemMenuDao.update(itemMenu);
    }

    /**
     * Elimina un item del restaurante, segun el id
     * 
     * @param id
     */
    public void eliminarItemMenu(Integer id) {
        itemMenuDao.delete(id);
    }

    /**
     * Obtiene una lista de todos los item del sistema
     * - OJO no son los item de un restaurante
     * - Mirar metodo filtrarPorVendedor()
     * 
     * @return Lista con los items
     */
    public List<ItemMenu> obtenerTodosLosItemMenu() {
        return itemMenuDao.findAll();
    }

    /**
     * Busca los item segun un Restaurante
     * 
     * @param vendedor El restaurante a buscar los item
     * @return Lista de item que tiene el restaurante
     * @throws VendedorNoEncontradoException Si no encuentra el Restaurante
     */
    public List<ItemMenu> filtrarPorVendedor(VendedorDto vendedorDto) throws VendedorNoEncontradoException {
        Vendedor vendedor = vendedorMemory.parseVendedor(vendedorDto);
        return itemMenuDao.findByVendedor(vendedor);
    }

    public ItemMenu filtrarPorId(Integer id) {
        return itemMenuDao.findById(id);
    }

    private ItemMenu parseItemMenu(ItemMenuDto itemMenuDto) {
        // 1. Parsear los datos del ItemMenu
        itemMenuDto.setId(Integer.parseInt(itemMenuDto.getIdText()));
        itemMenuDto.setPrecio(new BigDecimal(itemMenuDto.getPrecioText()));

        itemMenuDto.setCategoria(categoriaDao.findByNombre(itemMenuDto.getCategoriaText()));

        // 2. Parsear los datos de la subclase -> Plato o Bebida
        switch (itemMenuDto.getClass().getSimpleName()) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) itemMenuDto;
                platoDto.setCalorias(Double.parseDouble(platoDto.getCaloriasText()));
                platoDto.setPeso(Double.parseDouble(platoDto.getPesoText()));

                return new Plato(platoDto);
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) itemMenuDto;
                bebidaDto.setGraduacionAlcoholica(Double.parseDouble(bebidaDto.getGraduacionAlcoholicaText()));
                bebidaDto.setTamano(Double.parseDouble(bebidaDto.getTamanoText()));
                bebidaDto.setVolumen(Double.parseDouble(bebidaDto.getVolumenText()));

                return new Bebida(bebidaDto);
            default:
                return null;
        }

    }

}
