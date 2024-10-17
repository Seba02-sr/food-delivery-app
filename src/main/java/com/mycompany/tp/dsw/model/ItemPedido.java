/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

/**
 *
 * @author User
 */
public class ItemPedido { // Item pedido por un cliente, dentro de pedido class

    private Integer id;
    private Integer cantidad;
    private ItemMenu itemMenu; // plato o bebida
    private Pedido pedido;

    public ItemPedido(Integer id, Integer cantidad, ItemMenu itemMenu, Pedido pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.itemMenu = itemMenu;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Item: " +itemMenu.getNombre() +" precio: " + itemMenu.getPrecio() + " cantidad: " + cantidad;
    }
}
