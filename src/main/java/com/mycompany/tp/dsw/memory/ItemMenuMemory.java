package com.mycompany.tp.dsw.memory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.Vendedor;

public class ItemMenuMemory implements ItemMenuDao {

    protected static List<ItemMenu> items;
    private static int currentID = 0;
    private CategoriaDao categoriaDao;
    private VendedorDao vendedorDao;

    public ItemMenuMemory() {
        items = new ArrayList<>();
        categoriaDao = new CategoriaMemory();
        vendedorDao = new VendedorMemory();
        valoresInciales();
    }

    public void valoresInciales() {
        Plato platoEjemplo = new Plato(
                "Milanesa con Papas Fritas",
                850.0,
                true,
                true,
                false,
                500.0,
                1,
                new BigDecimal("12.50"),
                "Clásico plato argentino",
                categoriaDao.obtenerCategoriaPorNombre("Comida Clasica"),
                vendedorDao.buscarVendedorPorId(101));
        items.add(platoEjemplo);
    }

    /**
     * Crea y persiste un ItemMenu
     * - ItemMenu = Plato o Bebida
     * - Manejo de id unicos con currentID
     * 
     * @param itemMenu
     */
    @Override
    public void crearItemMenu(ItemMenu itemMenu) {
        itemMenu.setId(currentID++);
        items.add(itemMenu);
    }

    /**
     * Busca el item filtrado por el nombre
     * - Ignora mayusculas y minusculas
     * 
     * @param nombre
     * @return Lista de los items que coincide con el @param
     */
    @Override
    public List<ItemMenu> buscarItemMenuPorNombre(String nombre) {
        return items.stream().filter(i -> i.getNombre().equalsIgnoreCase(nombre))
                .toList();
    }

    /**
     * Modifica los datos de un item especifico
     * - Del objeto itemMenu pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param itemMenu El objeto item con los datos modificados
     */
    @Override
    public void modificarItemMenu(ItemMenu itemMenuModificado) {
        Optional<ItemMenu> existeItem = items.stream()
                .filter(i -> i.getId().equals(itemMenuModificado.getId())).findFirst();
        String nombreModificado = itemMenuModificado.getNombre();
        String descripcionModificado = itemMenuModificado.getDescripcion();
        BigDecimal precioModificado = itemMenuModificado.getPrecio();

        existeItem.ifPresent(i -> {
            if (nombreModificado != null)
                i.setNombre(nombreModificado);
            if (descripcionModificado != null)
                i.setDescripcion(descripcionModificado);
            if (precioModificado != null)
                i.setPrecio(precioModificado);

            switch (itemMenuModificado.getClass().getSimpleName()) {
                case "Plato":
                    PlatoDao platoDao = new PlatoMemory();
                    platoDao.modificarPlato((Plato) itemMenuModificado, (Plato) i);
                    break;
                case "Bebida":
                    BebidaDao bebidaDao = new BebidaMemory();
                    bebidaDao.modificarBebida((Bebida) itemMenuModificado, (Bebida) i);
                    break;
                default:
                    break;
            }
        });

    }

    /**
     * Elimina un item del restaurante, segun el id
     * 
     * @param id
     */
    @Override
    public void eliminarItemMenu(Integer id) {
        items.removeIf(i -> i.getId().equals(id));
    }

    /**
     * Obtiene una lista de todos los item del sistema
     * - OJO no son los item de un restaurante
     * - Mirar metodo filtrarPorVendedor()
     * 
     * @return Lista con los items
     */
    @Override
    public List<ItemMenu> obtenerTodosLosItemMenu() {
        return new ArrayList<>(items);
    }

    /**
     * Busca los item segun un Restaurante
     * 
     * @param vendedor El restaurante a buscar los item
     * @return Lista de item que tiene el restaurante
     * @throws VendedorNoEncontradoException Si no encuentra el Restaurante
     */
    @Override
    public List<ItemMenu> filtrarPorVendedor(Vendedor vendedor) throws VendedorNoEncontradoException {
        Integer id = vendedor.getId();
        System.out.println("ID bucado: " + id);
        List<ItemMenu> itemsVendedor = items.stream()
                .filter(i -> i.getVendedor().getId().equals(id))
                .toList();
        if (itemsVendedor.isEmpty()) {
            throw new VendedorNoEncontradoException("No se ah encontrado un vendedor con ID: " + vendedor.getId());
        }
        return itemsVendedor;
    }

    @Override
    public String toString() {
        StringBuilder listaItemString = new StringBuilder();

        for (ItemMenu itemMenu : items) {
            listaItemString.append(itemMenu.toString()).append(" \n");
        }

        return listaItemString.toString();
    }

    @Override
    public ItemMenu filtrarPorId(Integer id) {
        return items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
