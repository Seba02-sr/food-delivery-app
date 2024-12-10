package com.mycompany.tp.dsw.dto;

import com.mycompany.tp.dsw.model.Coordenada;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

}
