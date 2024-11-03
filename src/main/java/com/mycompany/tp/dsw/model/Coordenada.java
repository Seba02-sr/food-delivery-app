/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

/**
 *
 * @author Cristian
 */
public class Coordenada {

    private Double latitud;
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
