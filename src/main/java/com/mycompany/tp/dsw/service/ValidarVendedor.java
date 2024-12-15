package com.mycompany.tp.dsw.service;

import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.NoValidarException;

public class ValidarVendedor {

    public static void esGuardarValido(VendedorDto vendedorDto) throws NoValidarException {
        nombreValido(vendedorDto.getNombre());
        direccionValida(vendedorDto.getDireccion());
        latitudValida(vendedorDto.getLatitud());
        longitudValida(vendedorDto.getLongitud());
    }

    public static void esModificarValido(VendedorDto vendedorDto) throws NoValidarException {
        idValido(vendedorDto.getIdText());
        nombreValido(vendedorDto.getNombre());
        direccionValida(vendedorDto.getDireccion());
        latitudValida(vendedorDto.getLatitud());
        longitudValida(vendedorDto.getLongitud());
    }

    public static void esEliminarValido(String id) throws NoValidarException {
        idValido(id);
    }

    private static void idValido(String id) throws NoValidarException {
        if (esNullOrEmpty(id)) {
            throw new NoValidarException("Error: El id no puede estar vacío");
        }
        if (!soloNumero(id)) {
            throw new NoValidarException("Error: El id solo puede contener números");
        }
    }

    private static void nombreValido(String nombre) throws NoValidarException {
        if (esNullOrEmpty(nombre)) {
            throw new NoValidarException("Error: El nombre no puede estar vacío");
        }
        if (!soloLetras(nombre)) {
            throw new NoValidarException("Error: El nombre solo puede contener letras");
        }
    }

    private static void direccionValida(String direccion) throws NoValidarException {
        if (esNullOrEmpty(direccion)) {
            throw new NoValidarException("Error: La dirección no puede estar vacía");
        }
        if (!letrasNumeros(direccion)) {
            throw new NoValidarException("Error: La dirección solo puede contener letras y números");
        }
    }

    private static void latitudValida(String latitud) throws NoValidarException {
        if (esNullOrEmpty(latitud)) {
            throw new NoValidarException("Error: La latitud no puede estar vacía");
        }
        if (!numeroConDecimales(latitud)) {
            throw new NoValidarException("Error: La latitud debe ser un número válido");
        }
    }

    private static void longitudValida(String longitud) throws NoValidarException {
        if (esNullOrEmpty(longitud)) {
            throw new NoValidarException("Error: La longitud no puede estar vacía");
        }
        if (!numeroConDecimales(longitud)) {
            throw new NoValidarException("Error: La longitud debe ser un número válido");
        }
    }

    // Métodos auxiliares de validación
    public static Boolean esNullOrEmpty(String palabra) {
        return (palabra == null || palabra.trim().isEmpty());
    }

    private static Boolean soloNumero(String numero) {
        return numero.matches("^\\d+$");
    }

    private static Boolean soloLetras(String palabra) {
        return palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    private static Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.]+$");
    }

    private static Boolean numeroConDecimales(String numero) {
        return numero.matches("^-?\\d+(\\.\\d+)?$");
    }
}
