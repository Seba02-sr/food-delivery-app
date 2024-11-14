package com.mycompany.tp.dsw.service;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.tp.dsw.dto.VendedorDto;

public class ValidarVendedor {

    /**
     * Validar que los datos ingresados por pantalla sean correctos para la
     * persistencia
     * - No Nulos
     * - Nombre -> Solo letras.
     * - Direccion -> Letras y numeros.
     * - Coordenada -> Numeros y decimales.
     * 
     * @param vendedorDto
     * @return Map con clave nombre del campo que genero error y valor un mensaje.
     */
    public static Map<String, String> esGuardarValido(VendedorDto vendedorDto) {
        Map<String, String> errores = new HashMap<>();

        String nombre = vendedorDto.getNombre();
        String direccion = vendedorDto.getDireccion();
        String latitudTexto = vendedorDto.getLatitud();
        String longitudTexto = vendedorDto.getLongitud();

        // Validacion de Nombre, Direccion y Coordenada.
        nombreValido(nombre, errores);
        direccionValida(direccion, errores);
        latitudValida(latitudTexto, errores);
        longitudValida(longitudTexto, errores);

        return errores;

    }

    public static Map<String, String> esEliminarValido(String id) {
        Map<String, String> errores = new HashMap<>();

        idValido(id, errores);

        return errores;
    }

    public static Map<String, String> esModificarValido(VendedorDto vendedorDto) {
        Map<String, String> errores = new HashMap<>();

        String idText = vendedorDto.getIdText();
        String nombre = vendedorDto.getNombre();
        String direccion = vendedorDto.getDireccion();
        String latitudTexto = vendedorDto.getLatitud();
        String longitudTexto = vendedorDto.getLongitud();

        Boolean direccionEsNula = esNullOrEmpty(direccion);
        Boolean latitudEsNula = esNullOrEmpty(latitudTexto);
        Boolean longitudEsNula = esNullOrEmpty(longitudTexto);

        // Validar nularidad total o relleno total entre:
        // Direccion, Longitud y Latitud
        if (validarRelacionDireccionCoordenadas(direccionEsNula, latitudEsNula, longitudEsNula, errores)
                && !(direccionEsNula && latitudEsNula && longitudEsNula)) {
            // Caso de relleno total, validar la sintaxis
            if (!letrasNumeros(direccion)) {
                errores.put("direccion", "La dirección solo puede contener letras y números");
            }
            if (!numeroConDecimales(latitudTexto)) {
                errores.put("latitud", "La latitud debe ser un número válido");
            }
            if (!numeroConDecimales(longitudTexto)) {
                errores.put("longitud", "La longitud debe ser un número válido");
            }
        }

        // Validacion de Id y Nombre.
        idValido(idText, errores);
        nombreValido(nombre, errores);

        return errores;

    }

    private static Boolean validarRelacionDireccionCoordenadas(Boolean direccionEsNula, Boolean latitudEsNula,
            Boolean longitudEsNula,
            Map<String, String> errores) {

        // Si alguno es nulo y los otros no, es no valido
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

    /** */
    private static Boolean soloNumero(String numero) {
        return numero.matches("^\\d+$");
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
     * Verifica que la palabra solo contenga:
     * - Letras.
     * - Numeros.
     * - El caracter '.'(punto).
     * 
     * @param palabra
     * @return True si es correcta, False en otro caso.
     */
    private static Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.]+$");
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
