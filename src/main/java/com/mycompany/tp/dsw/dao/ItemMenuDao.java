package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Vendedor;

public interface ItemMenuDao { //CRUD
    void crearItemMenu(ItemMenu itemMenu);
    List<ItemMenu> buscarItemMenuPorNombre(String nombre);
    void modificarItemMenu(ItemMenu itemMenu);
    void eliminarItemMenu(Integer id);
    List<ItemMenu> obtenerTodosLosItemMenu();
    List<ItemMenu> filtrarPorVendedor(Vendedor vendedor) throws VendedorNoEncontradoException;
    
}
