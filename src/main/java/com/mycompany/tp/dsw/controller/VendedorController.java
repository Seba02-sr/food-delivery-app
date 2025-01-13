package com.mycompany.tp.dsw.controller;

import java.util.List;

import com.mycompany.tp.dsw.dto.CoordenadaDto;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.service.VendedorService;
import com.mycompany.tp.dsw.model.Coordenada;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.service.ServiceManager;

public class VendedorController {

    ServiceManager serviceManager;
    VendedorService vendedorService;

    public VendedorController() {
        serviceManager = ServiceManager.getInstance();
        vendedorService = serviceManager.getVendedorService();
    }

    public void guardarVendedor(VendedorDto vendedorDto) throws NoValidarException {

        vendedorService.registrarVendedor(vendedorDto);

    }

    public void modificarVendedor(VendedorDto vendedorDto) throws NoValidarException {

        vendedorService.modificarVendedor(vendedorDto);

    }

    public void eliminarVendedor(String idText) throws NoValidarException {

        Integer id = idValido(idText);
        vendedorService.eliminarVendedor(id);

    }

    public VendedorDto buscarVendedorPorId(String idText) throws NoValidarException {

        Integer id = idValido(idText);
        Vendedor vendedor = vendedorService.buscarVendedorPorId(id);

        return mapToDto(vendedor);

    }

    public List<VendedorDto> buscarVendedorPorNombre(String nombre) {

        List<Vendedor> listaVendedores = vendedorService.buscarVendedorPorNombre(nombre);
        return listaVendedores.stream().map(this::mapToDto).toList();
    }

    public List<VendedorDto> obtenerTodosLosVendedores() {
        List<Vendedor> vendedores = vendedorService.obtenerTodosLosVendedores();
        return vendedores.stream().map(this::mapToDto).toList();
    }

    public VendedorDto crearVendedorDto(String idText, String nombre, String direccion, String latitudText,
            String longitudText) throws NoValidarException {

        Double latitud = latitudValida(latitudText);
        Double longitud = longitudValida(longitudText);
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }

        nombreValido(nombre);
        direccionValida(direccion);

        CoordenadaDto coordenadaDto = CoordenadaDto.builder()
                .latitud(latitud)
                .longitud(longitud)
                .build();

        return VendedorDto.builder()
                .id(id)
                .nombre(nombre)
                .direccion(direccion)
                .coordenadaDto(coordenadaDto)
                .build();
    }

    private Double longitudValida(String longitudText) throws NoValidarException {
        try {
            if (esNullOrEmpty(longitudText)) {
                throw new NoValidarException("Error: La longitud no puede estar vacía");
            }
            return Double.parseDouble(longitudText);

        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: La longitud debe ser un número válido");
        }

    }

    private Double latitudValida(String latitudText) throws NoValidarException {
        try {

            if (esNullOrEmpty(latitudText)) {
                throw new NoValidarException("Error: La latitud no puede estar vacía");
            }
            return Double.parseDouble(latitudText);

        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: La latitud debe ser un número válido");
        }
    }

    private Integer idValido(String idText) throws NoValidarException {
        try {
            if (esNullOrEmpty(idText)) {
                throw new NoValidarException("Error: El id no puede estar vacío");
            }
            return Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El id solo puede contener números");
        }
    }

    private void nombreValido(String nombre) throws NoValidarException {
        if (esNullOrEmpty(nombre)) {
            throw new NoValidarException("Error: El nombre no puede estar vacío");
        }
        if (!soloLetras(nombre)) {
            throw new NoValidarException("Error: El nombre solo puede contener letras");
        }
    }

    private void direccionValida(String direccion) throws NoValidarException {
        if (esNullOrEmpty(direccion)) {
            throw new NoValidarException("Error: La dirección no puede estar vacía");
        }
        if (!letrasNumeros(direccion)) {
            throw new NoValidarException("Error: La dirección solo puede contener letras y números");
        }
    }

    private Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.]+$");
    }

    private static Boolean soloLetras(String palabra) {
        return palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    public static Boolean esNullOrEmpty(String palabra) {
        return (palabra.trim().isEmpty()); // palabra == null ||
    }

    private VendedorDto mapToDto(Vendedor vendedor) {
        return VendedorDto.builder()
                .id(vendedor.getId())
                .nombre(vendedor.getNombre())
                .direccion(vendedor.getDireccion())
                .coordenadaDto(mapToDto(vendedor.getCoordenada()))
                .build();
    }

    private CoordenadaDto mapToDto(Coordenada coordenada) {
        return CoordenadaDto.builder()
                .Id(coordenada.getId())
                .latitud(coordenada.getLatitud())
                .longitud(coordenada.getLongitud())
                .build();
    }
}
