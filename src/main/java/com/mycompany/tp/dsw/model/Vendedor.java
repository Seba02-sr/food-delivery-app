/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class Vendedor {

    private Integer id;
    private String nombre; // vendedor = resurante
    private String direccion;
    private Coordenada coordenada;
    private List<ItemMenu> itemsMenu;

    public Vendedor(int id, String nombre, String direccion, Coordenada coordenada) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenada = coordenada;
        this.itemsMenu = new ArrayList<>();
    }

    public Vendedor(Integer id, String nombre, String direccion, Coordenada coordenada, List<ItemMenu> itemsMenu) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenada = coordenada;
        this.itemsMenu = itemsMenu;
    }

    public List<ItemMenu> getItemsMenu() {
        return itemsMenu;
    }

    public void setItemsMenu(List<ItemMenu> itemsMenu) {
        this.itemsMenu = itemsMenu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Double distancia(Cliente cliente) {
        final int R = 6371; //radio de la tierra en km

        Double latV = this.getCoordenada().getLatitud();
        Double lngV = this.getCoordenada().getLongitud();
        Double latC = cliente.getCoordenada().getLatitud();
        Double lngC = cliente.getCoordenada().getLongitud();

        Double latDistance = Math.toRadians(latV - latC);
        Double lonDistance = Math.toRadians(lngV - lngC);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latV)) * Math.cos(Math.toRadians(latC))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    public List<ItemMenu> getItemBebidas() {
        List<ItemMenu> listaBebidas = new ArrayList<>();
        for (ItemMenu item : this.itemsMenu) {
            if (item.getCategoria().getTipo() == TipoCategoria.BEBIDA) {
                listaBebidas.add(item);
            }
        }
        return listaBebidas;
    }

    public List<ItemMenu> getItemComidas() {
        List<ItemMenu> listaComidas = new ArrayList<>();
        for (ItemMenu item : this.itemsMenu) {
            if (item.getCategoria().getTipo() == TipoCategoria.COMIDA) {
                listaComidas.add(item);
            }
        }
        return listaComidas;
    }

    public List<ItemMenu> getItemComidasVeganas(){
        List<ItemMenu> listaComidasVeganas = new ArrayList<>();
        for (ItemMenu item : this.itemsMenu) {
            if (item.getCategoria().getTipo() == TipoCategoria.COMIDA && ((Plato)item).aptoVegano()) {
                listaComidasVeganas.add(item);
            }
        }
        return listaComidasVeganas;
    }

    public List<ItemMenu> getItemBebidasSinAlcohol() {
        List<ItemMenu> listaBebidasSinAlcohol = new ArrayList<>();
        for (ItemMenu item : this.itemsMenu) {
            if (item.getCategoria().getTipo() == TipoCategoria.BEBIDA
                    && ((Bebida) item).getGraduacionAlcoholica() == 0) {
                listaBebidasSinAlcohol.add(item);
            }
        }
        return listaBebidasSinAlcohol;
    }

    @Override
    public String toString() {
        StringBuilder listaItemString = new StringBuilder();

        for (ItemMenu itemMenu : itemsMenu) {
            listaItemString.append(itemMenu.toString()).append(" \n");
        }
        return "Vendedor [id=" + id + ", nombre=" + nombre + ", items="+ listaItemString.toString() + "]";
    }
    

}
