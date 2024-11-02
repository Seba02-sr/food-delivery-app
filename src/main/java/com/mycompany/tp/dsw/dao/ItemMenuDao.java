package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Vendedor;

public interface ItemMenuDao {

    void crearItemMenu(ItemMenu itemMenu);

    List<ItemMenu> buscarItemMenuPorNombre(String nombre);

    void modificarItemMenu(ItemMenu itemMenu);

    void eliminarItemMenu(Integer id);

    /**
     * OJO, no es obtener los item de un restaurante
     * - Obtiene todos los items del sistema
     * - Mirar filtrarPorVendedor()
     * 
     * @return Lista de todos los item del sistema
     */
    List<ItemMenu> obtenerTodosLosItemMenu();

    /**
     * Obtiene los item de un restaurante
     * 
     * @param vendedor Restaurante a obtener sus items
     * @return Lista de items de un estaurante
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    List<ItemMenu> filtrarPorVendedor(Vendedor vendedor) throws VendedorNoEncontradoException;

}
