/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.tp.dsw.dto.ClienteDto;

public class ValidarCliente {
    
    public static Map<String,String> esGuardarValido(ClienteDto clienteDto){
        Map<String, String> errores = new HashMap<>();
        
        String nombre = clienteDto.getNombre();
        String cuit = clienteDto.getCuit();
        String direccion = clienteDto.getDireccion();
        String email = clienteDto.getEmail();
        String latitudTexto = clienteDto.getLatitud();
        String longitudTexto = clienteDto.getLongitud();
        
        nombreValido(nombre, errores);
        cuitValido(cuit, errores);
        direccionValida(direccion, errores);
        emailValido(email, errores);
        latitudValida(latitudTexto, errores);
        longitudValida(longitudTexto,errores);
        
        return errores;
        
    }
    
    
    public static Map<String, String> esEliminarValido(String id) {
        Map<String, String> errores = new HashMap<>();

        idValido(id, errores);

        return errores;
    }
    
    public static Map<String, String> esModificarValido(ClienteDto clientedto){
        Map<String, String> errores = new HashMap<>();
        
        String idText = clientedto.getIdText();
        String nombre = clientedto.getNombre();
        String cuit = clientedto.getCuit();
        String direccion = clientedto.getDireccion();
        String email = clientedto.getEmail();
        String latitudTexto = clientedto.getLatitud();
        String longitudTexto = clientedto.getLongitud();
        
        Boolean direccionEsNula = esNullOrEmpty(direccion);
        Boolean latitudEsNula = esNullOrEmpty(latitudTexto);
        Boolean longitudEsNula = esNullOrEmpty(longitudTexto);
        
        if (validarRelacionDireccionCoordenadas(direccionEsNula, latitudEsNula, longitudEsNula, errores)
                && !(direccionEsNula && latitudEsNula && longitudEsNula)) {
            // Caso de relleno total, validar la sintaxis
            if (!letrasNumeros(direccion)) {
                errores.put("direccion", "La dirección solo puede contener letras y números");
            }
            if (!soloNumeroCuit(cuit)) {
            errores.put("cuit", "El cuit 01 solo puede contener números y -");
            }
            if (!numeroConDecimales(latitudTexto)) {
                errores.put("latitud", "La latitud debe ser un número válido");
            }
            if (!numeroConDecimales(longitudTexto)) {
                errores.put("longitud", "La longitud debe ser un número válido");
            }
            if(!esMail(email)){
                errores.put("email", "La direccion de email debe terminar con el dominio @gmail, hotmail u outlook");
            }
        }
        
        
        return errores;
    }
    
    
    private static Boolean validarRelacionDireccionCoordenadas(Boolean direccionEsNula, Boolean latitudEsNula,
            Boolean longitudEsNula,
            Map<String, String> errores) {

        // Si alguno es nulo y los otros no, es inválido
        if ((direccionEsNula && latitudEsNula && longitudEsNula)
                || (!direccionEsNula && !latitudEsNula && !longitudEsNula)) {
            return true;
        }

        errores.put("global", "Si alguno de los campos (Latitud, Longitud o Direccion) es nulo, todos deben serlo.");
        return false;

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
    
    public static void direccionValida(String direccion, Map<String, String> errores) {
        if (esNullOrEmpty(direccion)) {
            errores.put("direccion", "La dirección no puede estar vacía");
        } else if (!letrasNumeros(direccion)) {
            errores.put("direccion", "La dirección solo puede contener letras y números");
        }
    }
    
    public static void emailValido(String email, Map<String, String> errores) {
        if (esNullOrEmpty(email)) {
            errores.put("email", "La dirección de email no puede estar vacía");
        } else if (!letrasNumerosYCaracteresMail(email)) {
            errores.put("email", "La dirección de email solo puede contener letras, números y caracteres especiales como (@._-+)");
        } else if (!esMail(email)){
            errores.put("email", "La direccion de email debe terminar con el dominio @gmail, hotmail u outlook");
        }
    }
    
    public static void cuitValido(String cuit, Map<String, String> errores) {
        if (esNullOrEmpty(cuit)) {
            errores.put("cuit", "El cuit no puede estar vacía");
        } else if (!soloNumeroCuit(cuit)) {
            errores.put("cuit", "El numero de cuit 02 solo puede contener números y -");
        }
    }
    
    public static void latitudValida(String latitudTexto, Map<String, String> errores) {
        if (esNullOrEmpty(latitudTexto)) {
            errores.put("latitud", "La latitud no puede estar vacía");
        } else if (!numeroConDecimales(latitudTexto)) {
            errores.put("latitud", "La latitud debe ser un número válido");
        }
    }
    
    public static void longitudValida(String longitudTexto, Map<String, String> errores) {
        if (esNullOrEmpty(longitudTexto)) {
            errores.put("longitud", "La longitud no puede estar vacía");
        } else if (!numeroConDecimales(longitudTexto)) {
            errores.put("longitud", "La longitud debe ser un número válido");
        }
    }
    
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

    
    private static Boolean esMail(String palabra){
        if(palabra.endsWith("@gmail.com") || palabra.endsWith("@outlook.com") || palabra.endsWith("@hotmail.com")){
            return true;
        }
        
        return false;
    }
    
    private static Boolean numeroConDecimales(String numero) {
        return numero.matches("^-?\\d+(\\.\\d+)?$");
    }
    
    
    
    
}
