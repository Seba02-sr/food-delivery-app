/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tp.dsw.dao;

import java.math.BigDecimal;
import java.util.List;

import com.mycompany.tp.dsw.exception.ItemNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemPedido;

/**
 *
 * @author User
 */
public interface ItemsPedidoDao {// Hacer el CRUD y borrar setItemsPedido
    
    List<ItemPedido> buscarPorRestaurante(Integer id) throws ItemNoEncontradoException; // los restaurante son vendedores
    List<ItemPedido> ordenPorPrecio() throws ItemNoEncontradoException; // ordena los itemsPedido por precio 
    List<ItemPedido> buscarPorPrecios(BigDecimal min, BigDecimal max) throws ItemNoEncontradoException; 
    List<ItemPedido> filtrarPorVendedor(String nombreVendedor) throws ItemNoEncontradoException; // le pasamos el nombre del Vendedor
    void setItemsPedido(List<ItemPedido> itemsPedido);
    List<ItemPedido> getAllItemsPedido();
    void crearItemPedido(ItemPedido itemPedido);
}
