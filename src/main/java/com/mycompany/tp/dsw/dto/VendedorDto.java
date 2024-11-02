package com.mycompany.tp.dsw.dto;

import com.mycompany.tp.dsw.model.Coordenada;

/**
 * Clase Data Transfer Object (DTO)
 * - Usada para la creacion de un vendedor
 */

public class VendedorDto {

    private Integer id;
    private String nombre;
    private String direccion;
    private Coordenada coordenada;

    /**
     * Atributos para el manejo de los errores.
     * - Un string es mas facil manejar y permite null.
     * - El parseo de un null a Double no se puede.
     * 
     * Al asegurarse que no contengan NULL, se parsea a Double y setea coordenada
     */
    private String longitud;
    private String latitud;

    public VendedorDto(Integer id, String nombre, String direccion, String latitud, String longitud) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}