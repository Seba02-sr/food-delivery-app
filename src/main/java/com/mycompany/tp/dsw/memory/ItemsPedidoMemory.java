/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.memory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.ItemsPedidoDao;
import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.exception.ItemNoEncontradoException;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.Vendedor;

/**
 *
 * @author User
 */
public class ItemsPedidoMemory implements ItemsPedidoDao {
    private List<ItemPedido> itemsPedido;
    private final VendedorDao vendedorDao;
    private int currentID = 0;

    // Constructor
    public ItemsPedidoMemory(VendedorDao vendedorDao) {
        this.itemsPedido = new ArrayList<>();
        this.vendedorDao = vendedorDao;
    }

    /**
     * Busca los item ya pedidos, segun un restaurante
     * - Restaurante = Vendedor
     * 
     * @param id Id del Restaurante
     * @return Lista de los item pedidos del restaurante
     * @throws ItemNoEncontradoException Si no se encontro items en el sistema
     */
    @Override
    public List<ItemPedido> buscarPorRestaurante(Integer id) throws ItemNoEncontradoException {
        List<ItemPedido> result = new ArrayList<>();
        try {
            // Busca el vendedor usando el DAO
            Vendedor vendedor = vendedorDao.getAllVendedor().stream()
                    .filter(v -> v.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new VendedorNoEncontradoException("No se encontró el vendedor con ID: " + id));

            // Filtra los items de pedido por los ítems de menú del vendedor
            result = itemsPedido.stream()
                    .filter(item -> vendedor.getItemsMenu().contains(item.getItemMenu()))
                    .toList();
        } catch (VendedorNoEncontradoException e) {
            throw new ItemNoEncontradoException("No se encontraron items de pedido para el restaurante con id: " + id);
        }

        if (result.isEmpty()) {
            throw new ItemNoEncontradoException("No se encontraron items de pedido para el restaurante con id: " + id);
        }
        return result;
    }

    /**
     * Obtiene una lista de los item, ordenados por precio
     * - Ordenar teniendo en cuenta el precio del ItemMenu,
     * - no del ItemPedido (cantidad * precio)
     * 
     * @return Lista de los item del pedido, ordenados
     * @throws ItemNoEncontradoException Si no encuentra el item
     */
    @Override
    public List<ItemPedido> ordenPorPrecio() throws ItemNoEncontradoException {
        List<ItemPedido> result = itemsPedido.stream()
                .sorted((item1, item2) -> item1.getItemMenu().getPrecio().compareTo(item2.getItemMenu().getPrecio()))
                .toList();
        if (result.isEmpty()) {
            throw new ItemNoEncontradoException("No se encontraron items de pedido para ordenar por precio");
        }
        return result;
    }

    /**
     * Obtiene una lista con los itemPedido filtrado por precio
     * - En un rango [min, max]
     * 
     * @param min Precio minimo a filtrar
     * @param max Precio maximo a filtrar
     * @return Lista de item pedidos cuyo precio este en el rango
     * @throws ItemNoEncontradoException Si no encuenta items
     */
    @Override
    public List<ItemPedido> buscarPorPrecios(BigDecimal min, BigDecimal max) throws ItemNoEncontradoException {
        List<ItemPedido> result = itemsPedido.stream().filter(item -> item.getItemMenu().getPrecio().compareTo(min) >= 0
                && item.getItemMenu().getPrecio().compareTo(max) <= 0).toList();
        if (result.isEmpty()) {
            throw new ItemNoEncontradoException(
                    "No se encontraron items de pedido para el rango de precios: " + min + " - " + max);
        }
        return result;

    }

    /**
     * Obtiene una lista de los item pedidos, filtrado por restaurante
     * - El filtrado se realiza mediante el nombre del restaurante
     * 
     * @param nombreVendedor El nombre del restaurante a buscar los item pedidos
     * @return Lista de los items pedidos del restaurante
     * @throws ItemNoEncontradoException Si no encuentra item pedidos
     */
    @Override
    public List<ItemPedido> filtrarPorVendedor(String nombreVendedor) throws ItemNoEncontradoException {
        List<ItemPedido> result = new ArrayList<>();
        try {
            Vendedor vendedor = vendedorDao.buscarVendedorPorNombre(nombreVendedor);
            result = itemsPedido.stream()
                    .filter(item -> vendedor.getItemsMenu().contains(item.getItemMenu()))
                    .toList();
        } catch (VendedorNoEncontradoException e) {
            throw new ItemNoEncontradoException(
                    "No se encontraron items de pedido para el vendedor: " + nombreVendedor);
        }
        if (result.isEmpty()) {
            throw new ItemNoEncontradoException(
                    "No se encontraron items de pedido para el vendedor: " + nombreVendedor);
        }
        return result;
    }

    @Override
    public void setItemsPedido(List<ItemPedido> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    /**
     * Obtiene una lista con todos los item pedido del sistema
     * - OJO que no es de un restaurante en especifico
     * - Mirar filtrarPorVendeor()
     */
    @Override
    public List<ItemPedido> getAllItemsPedido() {
        return new ArrayList<>(itemsPedido);
    }

    /**
     * Crea y persiste un item pedido
     * - Manejo de id unicos con currentID
     * 
     * @param itemPedido El item pedido a persistir
     */
    @Override
    public void crearItemPedido(ItemPedido itemPedido) {
        itemPedido.setId(currentID++);
        itemsPedido.add(itemPedido);
    }

}
