/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

/**
 *
 * @author Cristian
 */
public class Cliente {
    
    private Integer id;
    private String nombre;
    private String cuit;
    private String direccion;
    private String email;
    private Coordenada coordenada;

    public Cliente(int id, String nombre, String cuit, String direccion, String email, Coordenada coordenada) {
        this.id = id;
        this.nombre = nombre;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
        this.coordenada = coordenada;
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

    public void setNombre(String nommbre) {
        this.nombre = nommbre;
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
}
