/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;

import com.mycompany.tp.dsw.dto.BebidaDto;

/**
 *
 * @author Cristian
 */
public class Bebida extends ItemMenu {
    private Double graduacionAlcoholica;
    private Double tamano;
    private Double volumen;

    // Constructor para agregar Bebida
    public Bebida(BebidaDto bebidaDto) {
        super(bebidaDto.getId(),
                bebidaDto.getNombre(),
                bebidaDto.getDescripcion(),
                bebidaDto.getPrecio(),
                bebidaDto.getCategoria(),
                bebidaDto.getVendedor());
        this.graduacionAlcoholica = bebidaDto.getGraduacionAlcoholica();
        this.tamano = bebidaDto.getTamano();
        this.volumen = bebidaDto.getVolumen();
    }

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
        return "Bebida [graduacionAlcoholica=" + graduacionAlcoholica + ", tamano=" + tamano + ", volumen=" + volumen
                + ", getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPrecio()="
                + getPrecio() + ", getCategoria()=" + getCategoria() + "]";
    }

}
