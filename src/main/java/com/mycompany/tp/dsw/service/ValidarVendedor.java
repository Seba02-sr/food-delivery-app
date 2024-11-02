package com.mycompany.tp.dsw.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.tp.dsw.dto.VendedorDto;

public class ValidarVendedor {

    /**
     * Validar que los datos ingresados por pantalla sean correctos
     * - No Nulos
     * - Nombre -> Solo letras.
     * - Direccion -> Letras y numeros.
     * - Coordenada -> Numeros y decimales.
     * 
     * @param vendedorDto
     * @return
     */
    public static Map<String, String> esValido(VendedorDto vendedorDto) {
        Map<String, String> errores = new HashMap<>();

        // Pasando todo a string para mejor manejo de las comprobaciones.
        String nombre = vendedorDto.getNombre();
        String direccion = vendedorDto.getDireccion();
        String latitudTexto = String.valueOf(vendedorDto.getLatitud());
        String longitudTexto = String.valueOf(vendedorDto.getLongitud());

        // Validacion de Nombre.
        if (nombre == null || nombre.trim().isEmpty()) {
            errores.put("nombre", "El nombre no puede estar vacío");
        } else if (!soloLetras(nombre)) {
            errores.put("nombre", "El nombre solo puede contener letras");
        }

        // Validacion de Direccion.
        if (direccion == null || direccion.trim().isEmpty()) {
            errores.put("direccion", "La dirección no puede estar vacía");
        } else if (!letrasNumeros(direccion)) {
            errores.put("direccion", "La dirección solo puede contener letras y números");
        }

        // Validacion de la Coordenada.
        if (latitudTexto == null || latitudTexto.trim().isEmpty()) {
            errores.put("latitud", "La latitud no puede estar vacía");
        } else if (!numeroConDecimales(latitudTexto)) {
            errores.put("latitud", "La latitud debe ser un número válido");
        }

        if (longitudTexto == null || longitudTexto.trim().isEmpty()) {
            errores.put("longitud", "La longitud no puede estar vacía");
        } else if (!numeroConDecimales(longitudTexto)) {
            errores.put("longitud", "La longitud debe ser un número válido");
        }

        return errores;

    }

    /**
     * Verifica que la palabra solo contenga letras.
     * 
     * @param palabra
     * @return True si es correcta, False en otro caso.
     */
    private static Boolean soloLetras(String palabra) {
        return palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    /**
     * Verifica que la palabra solo contenga letras y numeros.
     * 
     * @param palabra
     * @return True si es correcta, False en otro caso.
     */
    private static Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    /**
     * Verifica que el campo contenga numero.
     * - Admite decimales.
     * 
     * @param numero
     * @return True si es correcto, False en otro caso.
     */
    private static Boolean numeroConDecimales(String numero) {
        return numero.matches("^-?\\d+(\\.\\d+)?$");
    }
}
