package com.mycompany.tp.dsw.dto;

import com.mycompany.tp.dsw.model.Coordenada;

public class ClienteDto {
    private Integer id;
    private String nombre;
    private String cuit;
    private String direccion;
    private String email;
    private Coordenada coordenada;

    /**
     * Atributos para el manejo de los errores.
     * - Un string es mas facil manejar y permite null.
     * - El parseo de un null a Double no se puede.
     * - Idem con Integer
     * 
     * Al asegurarse que no contengan NULL, se parsea a Double/Integer
     * Luego setear el atributo
     */
    private String longitud;
    private String latitud;
    private String IdText;

    // Constructor para modificar
    public ClienteDto(String idText, String nombre, String cuit, String direccion, String email, String latitud,
            String longitud) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
        this.longitud = longitud;
        this.latitud = latitud;
        this.IdText = idText;
    }

    // Constructor para crear
    public ClienteDto(String nombre, String cuit, String direccion, String email, String latitud, String longitud) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
        this.longitud = longitud;
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Coordenada getCoordenada() {
        return coordenada;
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

    public String getIdText() {
        return IdText;
    }

    public void setIdText(String idText) {
        IdText = idText;
    }

}
