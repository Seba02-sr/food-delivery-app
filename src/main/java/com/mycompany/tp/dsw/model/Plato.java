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
public class Plato extends ItemMenu {

    //private String nombre;
    private Double calorias;
    private Boolean aptoCeliaco;
    private Boolean aptoVegetariano;
    private Boolean aptoVegano;
    private Double peso;

    public Plato(String nombre, Double calorias, Boolean aptoCeliaco, Boolean aptoVegetariano, Boolean aptoVegano, Double peso,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria, Vendedor vendedor) { //
        super(id, nombre, descripcion, precio, categoria, vendedor); //
        //this.nombre = nombre;
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.aptoVegetariano = aptoVegetariano;
        this.aptoVegano = aptoVegano;
        this.peso = peso;
    }

    public Plato(String nombre, Double calorias, Boolean aptoCeliaco, Boolean aptoVegetariano, Boolean aptoVegano, Double peso,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria) { //
        super(id, nombre, descripcion, precio, categoria); //
        //this.nombre = nombre;
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.aptoVegetariano = aptoVegetariano;
        this.aptoVegano = aptoVegano;
        this.peso = peso;
    }

   /* public Plato(Integer id, String nombre, String descripcion, BigDecimal precio, Categoria categoria,
            Boolean aptoVegano, Vendedor vendedor) { //, Vendedor vendedor
        super(id, nombre, descripcion, precio, categoria, vendedor); //, vendedor
        this.aptoVegano = aptoVegano;
    }*/

    /* @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Boolean getAptoVegetariano() {
        return aptoVegetariano;
    }

    public void setAptoVegetariano(Boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
        //si no es aptoVegetarioano, no va a ser aptoVegano
        if (!aptoVegetariano) {
            this.aptoVegano = false;
        }
    }

    public Double getPeso() {
        //devuelve el valor del atributo, NO EL CALCULO SEGUN REGLA DE NEGOCIO --> ver metodo peso()
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getAptoCeliaco() {
        return aptoCeliaco;
    }

    public void setAptoCeliaco(Boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }

    public void setAptoVegano(Boolean aptoVegano) {
        this.aptoVegano = aptoVegano;
        //Si el plato es vegano entonces tambien es vegetariano
        if (aptoVegano) {
            this.aptoVegetariano = true;
        }
    }

    @Override
    public Double peso() {
        //devuelve el peso del plato + 10% por envase
        return this.peso * 1.1; 
    }

    @Override
    public boolean esComida() {
        return true; 
    }

    @Override
    public boolean esBebida() {
        return false; 
    }

    @Override
    public boolean aptoVegano() { 
        //es como tener getAptoVegano
        return aptoVegano;
    }

    /*@Override
    public String toString() {
        return "{ Plato: " + super.getNombre() + ". Es apto Celiaco? " + aptoCeliaco + ". Es apto vegetariano? " + aptoVegetariano
                + ". Es apto vegano? " + aptoVegano + ". Precio:" + this.getPrecio() + " }";
        
    }*/

    @Override
    public String toString() {
        return "ItemMenu [id=" + this.getId() + ", nombre=" + this.getNombre() +", vendedor=" + this.getVendedor().getId() + "]";
    }

}
