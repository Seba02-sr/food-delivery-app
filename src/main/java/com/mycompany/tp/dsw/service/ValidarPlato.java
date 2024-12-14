/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.tp.dsw.dto.PlatoDto;

/**
 *
 * @author admin
 */
public class ValidarPlato {

    public static Map<String, String> esGuardarValido(PlatoDto platoDto) {
        Map<String, String> errores = new HashMap<>();

        String nombre = platoDto.getNombre();
        String precio = platoDto.getPrecioText();
        String descripcion = platoDto.getDescripcion();
        String calorias = platoDto.getCaloriasText();
        String peso = platoDto.getPesoText();
        Boolean celiaco = platoDto.getAptoCeliaco();
        Boolean vegano = platoDto.getAptoVegano();
        Boolean vegetariano = platoDto.getAptoVegetariano();

        nombreValido(nombre, errores);
        precioValido(precio, errores);
        descripcionValido(descripcion, errores);
        caloriasValido(calorias, errores);
        pesoValido(peso, errores);

        return errores;
    }

    public static Map<String, String> esModificarValido(PlatoDto platoDto) {
        Map<String, String> errores = new HashMap<>();

        String id = platoDto.getIdText();
        String nombre = platoDto.getNombre();
        String precio = platoDto.getPrecioText();
        String descripcion = platoDto.getDescripcion();
        String calorias = platoDto.getCaloriasText();
        String peso = platoDto.getPesoText();
        Boolean celiaco = platoDto.getAptoCeliaco();
        Boolean vegano = platoDto.getAptoVegano();
        Boolean vegetariano = platoDto.getAptoVegetariano();

        idValido(id, errores);
        nombreValido(nombre, errores);
        precioValido(precio, errores);
        descripcionValido(descripcion, errores);
        caloriasValido(calorias, errores);
        pesoValido(peso, errores);

        return errores;
    }

    public static Map<String, String> esEliminarValido(String id) {

        Map<String, String> errores = new HashMap<>();

        idValido(id, errores);

        return errores;
    }

    public static void idValido(String idText, Map<String, String> errores) {
        if (esNullOrEmpty(idText)) {
            errores.put("id", "El id no puede estar vacío");
        } else if (!soloNumero(idText)) {
            errores.put("id", "El id solo puede contener numeros");
        }
    }

    public static void nombreValido(String nombre, Map<String, String> errores) {
        if (esNullOrEmpty(nombre)) {
            errores.put("nombre", "El nombre no puede estar vacío");
        } else if (!soloLetras(nombre)) {
            errores.put("nombre", "El nombre solo puede contener letras");
        }
    }

    public static void precioValido(String precio, Map<String, String> errores) {
        if (esNullOrEmpty(precio)) {
            errores.put("precio", "El precio no puede estar vacío");
        } else if (!numeroConDecimales(precio)) {
            errores.put("precio", "El precio solo puede contener numeros decimales");
        }
    }

    public static void descripcionValido(String descripcion, Map<String, String> errores) {
        if (esNullOrEmpty(descripcion)) {
            errores.put("descripcion", "La descripcion no puede estar vacía");
        } else if (!letrasNumeros(descripcion)) {
            errores.put("descripcion", "La descripcion solo puede contener letras y/o numeros");
        }
    }

    public static void caloriasValido(String calorias, Map<String, String> errores) {
        if (esNullOrEmpty(calorias)) {
            errores.put("calorias", "El compo calorias no puede estar vacío");
        } else if (!numeroConDecimales(calorias)) {
            errores.put("calorias", "Las calorias solo puede contener numeros decimales");
        }
    }

    public static void pesoValido(String peso, Map<String, String> errores) {
        if (esNullOrEmpty(peso)) {
            errores.put("peso", "El peso no puede estar vacío");
        } else if (!numeroConDecimales(peso)) {
            errores.put("peso", "El peso solo puede contener numeros decimales");
        }
    }

    private static Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.,]+$");
    }

    private static Boolean numeroConDecimales(String numero) {
        return numero.matches("^-?\\d+(\\.\\d+)?$");
    }

    private static Boolean soloLetras(String palabra) {
        return palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    public static Boolean esNullOrEmpty(String palabra) {
        return (palabra == null || palabra.trim().isEmpty());
    }

    private static Boolean soloNumero(String numero) {
        return numero.matches("^\\d+$");
    }

}
