/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "coordenadas")
public class Coordenada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    public Coordenada(Double lat, Double lng) {
        this.latitud = lat;
        this.longitud = lng;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double lat) {
        this.latitud = lat;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double lng) {
        this.longitud = lng;
    }

    @Override
    public String toString() {
        return "Coordenada [latitud=" + latitud + ", longitud=" + longitud + "]";
    }

}
