package com.mycompany.tp.dsw.service;

import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.exception.NoValidarException;

public class ValidarCliente {

    public static void esGuardarValido(ClienteDto clienteDto) throws NoValidarException {
        nombreValido(clienteDto.getNombre());
        cuitValido(clienteDto.getCuit());
        direccionValida(clienteDto.getDireccion());
        emailValido(clienteDto.getEmail());
        latitudValida(clienteDto.getLatitud());
        longitudValida(clienteDto.getLongitud());
    }

    public static void esModificarValido(ClienteDto clienteDto) throws NoValidarException {
        idValido(clienteDto.getIdText());
        nombreValido(clienteDto.getNombre());
        cuitValido(clienteDto.getCuit());
        direccionValida(clienteDto.getDireccion());
        emailValido(clienteDto.getEmail());
        latitudValida(clienteDto.getLatitud());
        longitudValida(clienteDto.getLongitud());
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

    private static void emailValido(String email) throws NoValidarException {
        if (esNullOrEmpty(email)) {
            throw new NoValidarException("Error: La dirección de email no puede estar vacía");
        }
        if (!letrasNumerosYCaracteresMail(email)) {
            throw new NoValidarException("Error: El email solo puede contener letras, números y caracteres (@._-+)");
        }
        if (!esMail(email)) {
            throw new NoValidarException("Error: El email debe terminar con @gmail.com, @outlook.com o @hotmail.com");
        }
    }

    private static void cuitValido(String cuit) throws NoValidarException {
        if (esNullOrEmpty(cuit)) {
            throw new NoValidarException("Error: El CUIT no puede estar vacío");
        }
        if (!soloNumeroCuit(cuit)) {
            throw new NoValidarException("Error: El CUIT solo puede contener números y guiones (-)");
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

    // Métodos de validación auxiliares
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
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    private static Boolean letrasNumerosYCaracteresMail(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ@._\\-+]+$");
    }

    private static Boolean soloNumeroCuit(String numero) {
        return numero.matches("^[\\d-]+$");
    }

    private static Boolean esMail(String palabra) {
        return palabra.endsWith("@gmail.com") || palabra.endsWith("@outlook.com") || palabra.endsWith("@hotmail.com");
    }

    private static Boolean numeroConDecimales(String numero) {
        return numero.matches("^-?\\d+(\\.\\d+)?$");
    }
}
