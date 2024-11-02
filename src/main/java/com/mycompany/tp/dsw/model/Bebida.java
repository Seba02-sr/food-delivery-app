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
    private Double graduacionAlcoholica;
    private Double tamano;
    private Double volumen;

    public Bebida(String nombre, Double graduacionAlcoholica, Double tamano, Double volumen,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria, Vendedor vendedor) {
        super(id, nombre, descripcion, precio, categoria, vendedor);
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamano = tamano;
        this.volumen = volumen;
    }

    public Bebida(String nombre, Double graduacionAlcoholica, Double tamano, Double volumen,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria) {
        super(id, nombre, descripcion, precio, categoria);
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamano = tamano;
        this.volumen = volumen;
    }

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

    /**
     * Calcula el peso de la bebida considerando su volumen, tipo y 20% por envases.
     * - Bebida con alcohol: 0.99
     * - Bebida gaseosa: 1.04
     * 
     * Formula -> Volumen * <Factor Tipo> * 1.2
     */
    @Override
    public Double peso() {
        if (this.graduacionAlcoholica > 0) {
            return this.volumen * 0.99 * 1.2;
        } else {
            return this.volumen * 1.04 * 1.2;
        }
    }

    @Override
    public boolean esComida() {
        return false;
    }

    @Override
    public boolean esBebida() {
        return true;
    }

    @Override
    public boolean aptoVegano() {
        return false;
    }

    @Override
    public String toString() {
        return "ItemMenu [id=" + this.getId() + ", nombre=" + this.getNombre() + ", vendedor="
                + this.getVendedor().getId() + "]";
    }
}
