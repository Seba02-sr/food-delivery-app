/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.tp.dsw.dto.BebidaDto;

/**
 *
 * @author admin
 */
public class ValidarBebida {
    
    public static Map<String, String> esGuardarValido(BebidaDto bebidaDto){
        Map<String, String> errores = new HashMap<>();
        
        String nombre = bebidaDto.getNombre();
        String descripcion = bebidaDto.getDescripcion();
        String precio = bebidaDto.getPrecioText();
        String graduacionAlcoholica = bebidaDto.getGraduacionAlcoholicaText();
        String tamano = bebidaDto.getTamanoText();
        String volumnen = bebidaDto.getVolumenText();
        
        //validar gradAlcohol, tamano y volumen
        nombreValido(nombre, errores);
        descripcionValido(descripcion, errores);
        precioValido(precio, errores);
        graduacionAlcoholicaValida(graduacionAlcoholica, errores);
        tamanoValido(tamano, errores);
        volumenValido(volumnen, errores);
         
        
        return errores;
    }
    
    public static Map<String, String> esModificarValido(BebidaDto bebidaDto){
        Map<String, String> errores = new HashMap<>();
        
        String idTxt = bebidaDto.getIdText();
        String nombre = bebidaDto.getNombre();
        String descripcion = bebidaDto.getDescripcion();
        String precio = bebidaDto.getPrecioText();
        String graduacionAlcoholica = bebidaDto.getGraduacionAlcoholicaText();
        String tamano = bebidaDto.getTamanoText();
        String volumnen = bebidaDto.getVolumenText();
        
        //validar gradAlcohol, tamano y volumen
        idValido(idTxt, errores);
        nombreValido(nombre, errores);
        descripcionValido(descripcion, errores);
        precioValido(precio, errores);
        graduacionAlcoholicaValida(graduacionAlcoholica, errores);
        tamanoValido(tamano, errores);
        volumenValido(volumnen, errores);
        
        return errores;
    }
    
    public static Map<String, String> esEliminarValido(String id){
        
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
    
    public static void nombreValido(String nombre, Map<String, String> errores){
        
        if(esNullOrEmpty(nombre)){
            errores.put("nombre", "El campo de nombre no puede estar vacio");
        }
        else if(!letrasNumeros(nombre)){
            errores.put("nombre", "El nombre debe ser una combinacion de letras y/o numeros");
        }
    }
    
    public static void descripcionValido(String descripcion, Map<String, String> errores){
        
        if(esNullOrEmpty(descripcion)){
            errores.put("descripcion", "El campo de descripcion no puede estar vacio");
        }
        else if(!letrasNumeros(descripcion)){
            errores.put("descripcion", "El campo descripcion debe ser una combinacion de letras y/o numeros");
        }
    }
    
    public static void precioValido(String precio, Map<String, String> errores){
        
        if(esNullOrEmpty(precio)){
            errores.put("precio", "El campo de precio no puede estar vacio");
        }
        else if(!numeroConDecimales(precio)){
            errores.put("precio", "La precio debe ser un numero valido");
        }
    }
    
    public static void graduacionAlcoholicaValida(String graduacionAlcoholica, Map<String, String> errores){
        if(esNullOrEmpty(graduacionAlcoholica)){
            errores.put("graduacion Alcoholica", "El campo de graduacion alcoholica no puede estar vacio");
        }
        else if(!soloNumero(graduacionAlcoholica)){
            errores.put("graduacion Alcoholica", "La graduacion alcoholica debe ser un numero valido");
        }
        else if(!estaEnRango(graduacionAlcoholica)){
            errores.put("graduacion Alcoholica", "La graduacion alcoholica debe ser un numero entre 0 y 100");
        }
    }
    
    public static void tamanoValido(String tamano, Map<String, String> errores){
        
        if(esNullOrEmpty(tamano)){
            errores.put("tamano", "El campo de tamano no puede estar vacio");
        }
        else if(!numeroConDecimales(tamano)){
            errores.put("tamano", "La tamano debe ser un numero valido");
        }
        
    }
    
    public static void volumenValido(String volumen, Map<String, String> errores){
        
        if(esNullOrEmpty(volumen)){
            errores.put("volumen", "El campo de volumen no puede estar vacio");
        }
        else if(!numeroConDecimales(volumen)){
            errores.put("volumen", "La volumen debe ser un numero valido");
        }
        
    }
    
    public static Boolean esNullOrEmpty(String palabra) {
        return (palabra == null || palabra.trim().isEmpty());
    } 
    
    private static Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.,]+$");
    }

    
    private static Boolean numeroConDecimales(String numero) {
        return numero.matches("^-?\\d+(\\.\\d+)?$");
    }
    
    private static Boolean soloNumero(String numero) {
        return numero.matches("^\\d+$");
    }
    
    public static Boolean estaEnRango(String numero) {
        int num = Integer.parseInt(numero);
        if(num>= 0 && num<= 100){
            return true;
        }
        else{
            return false;
        }
    } 

}
