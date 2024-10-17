/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;

/**
 *
 * @author Cristian
 */
public class Bebida extends ItemMenu {
    //private String nombre;
    private Double graduacionAlcoholica;
    private Double tamano;
    private Double volumen;


    public Bebida(String nombre, Double graduacionAlcoholica, Double tamano, Double volumen,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria, Vendedor vendedor) { //
        super(id, nombre, descripcion, precio, categoria, vendedor); //
        //this.nombre = nombre;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamano = tamano;
        this.volumen = volumen;
    }

    public Bebida(String nombre, Double graduacionAlcoholica, Double tamano, Double volumen,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria) { //
        super(id, nombre, descripcion, precio, categoria); //
        //this.nombre = nombre;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamano = tamano;
        this.volumen = volumen;
    }
   /*  @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/

    public Double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(Double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }
    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    @Override
    public Double peso() {
        // En las bebidas se calcula como el producto del volumen en ml por 0.99 si es una bebida con alcohol
        // y 1.04 si es una bebida gaseosa.
        // Además, se le suma un 20% de peso por envases
        if (this.graduacionAlcoholica > 0) {
            return this.volumen * 0.99 * 1.2;
        } else {
            return this.volumen * 1.04 * 1.2;
        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esComida() {
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esBebida() {
        return true; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean aptoVegano() {
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*@Override
    public String toString() {
        return "{ Bebida: " + super.getNombre() + ". Graduacion Alcoholica: " + this.graduacionAlcoholica + ". Peso: " + this.peso() + ". Precio: " + this.getPrecio() + " }"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }*/

    @Override
    public String toString() {
        return "ItemMenu [id=" + this.getId() + ", nombre=" + this.getNombre() +", vendedor=" + this.getVendedor().getId() + "]";
    }
}
