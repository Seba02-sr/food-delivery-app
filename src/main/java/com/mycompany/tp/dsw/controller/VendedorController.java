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

    /**
     * Persiste un nuevo vendedor en el sistema.
     * 
     * @param vendedorDto El DTO del vendedor a guardar.
     * @throws NoValidarException Si hay un error de validacion.
     */
    public void guardarVendedor(VendedorDto vendedorDto) throws NoValidarException {
        vendedorService.registrarVendedor(vendedorDto);
    }

    /**
     * Modifica un vendedor existente en el sistema.
     * 
     * @param vendedorDto El DTO del vendedor a modificar.
     * @throws NoValidarException Si hay un error de validacion.
     */
    public void modificarVendedor(VendedorDto vendedorDto) throws NoValidarException {
        vendedorService.modificarVendedor(vendedorDto);
    }

    /**
     * Elimina logicamente un vendedor del sistema.
     * 
     * @param idText El id del vendedor a eliminar.
     * @throws NoValidarException Si el id no es valido.
     */
    public void eliminarVendedor(String idText) throws NoValidarException {
        Integer id = idValido(idText);
        vendedorService.eliminarVendedor(id);
    }

    /**
     * Busca un vendedor por su id.
     * 
     * @param idText El id del vendedor a buscar.
     * @return El DTO del vendedor encontrado.
     * @throws NoValidarException Si el id no es valido.
     */
    public VendedorDto buscarVendedorPorId(String idText) throws NoValidarException {
        Integer id = idValido(idText);
        Vendedor vendedor = vendedorService.buscarVendedorPorId(id);
        return mapToDto(vendedor);
    }

    /**
     * Busca vendedores por su nombre.
     * 
     * @param nombre El nombre del vendedor a buscar.
     * @return Lista de DTOs de vendedores encontrados.
     */
    public List<VendedorDto> buscarVendedorPorNombre(String nombre) {
        List<Vendedor> listaVendedores = vendedorService.buscarVendedorPorNombre(nombre);
        return listaVendedores.stream().map(this::mapToDto).toList();
    }

    /**
     * Obtiene todos los vendedores del sistema.
     * 
     * @return Lista de DTOs de todos los vendedores.
     */
    public List<VendedorDto> obtenerTodosLosVendedores() {
        List<Vendedor> vendedores = vendedorService.obtenerTodosLosVendedores();
        return vendedores.stream().map(this::mapToDto).toList();
    }

    /**
     * Crea un VendedorDto a partir de los parametros proporcionados.
     * 
     * @return El DTO del vendedor creado.
     * @throws NoValidarException Si hay un error de validacion.
     */
    public VendedorDto crearVendedorDto(String idText, String nombre, String direccion, String latitudText,
            String longitudText) throws NoValidarException {
        Integer id = null;
        Double latitud = null;
        Double longitud = null;

        if (latitudText != null) {
            latitud = latitudValida(latitudText);
        }
        if (longitudText != null) {
            longitud = longitudValida(longitudText);
        }

        if (idText != null) {
            id = idValido(idText);
        }

        if (nombre != null) {
            nombreValido(nombre);
        }

        if (direccion != null) {
            direccionValida(direccion);
        }

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

    // Validaciones de los atributos para realizar la creacion de un Vendedor.
    private Double longitudValida(String longitudText) throws NoValidarException {
        try {
            if (isEmpty(longitudText)) {
                throw new NoValidarException("Error: La longitud no puede estar vacía");
            }
            return Double.parseDouble(longitudText);

        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: La longitud debe ser un número válido");
        }
    }

    private Double latitudValida(String latitudText) throws NoValidarException {
        try {

            if (isEmpty(latitudText)) {
                throw new NoValidarException("Error: La latitud no puede estar vacía");
            }
            return Double.parseDouble(latitudText);

        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: La latitud debe ser un número válido");
        }
    }

    private Integer idValido(String idText) throws NoValidarException {
        try {
            if (isEmpty(idText)) {
                throw new NoValidarException("Error: El id no puede estar vacío");
            }
            return Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El id solo puede contener números");
        }
    }

    private void nombreValido(String nombre) throws NoValidarException {
        if (isEmpty(nombre)) {
            throw new NoValidarException("Error: El nombre no puede estar vacío");
        }
        if (!soloLetras(nombre)) {
            throw new NoValidarException("Error: El nombre solo puede contener letras");
        }
    }

    private void direccionValida(String direccion) throws NoValidarException {
        if (isEmpty(direccion)) {
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

    public static Boolean isEmpty(String palabra) {
        return (palabra.trim().isEmpty());
    }

    /**
     * Mapea un Vendedor a su DTO correspondiente.
     * 
     * @param vendedor El vendedor a mapear.
     * @return El DTO del vendedor.
     */
    private VendedorDto mapToDto(Vendedor vendedor) {
        return VendedorDto.builder()
                .id(vendedor.getId())
                .nombre(vendedor.getNombre())
                .direccion(vendedor.getDireccion())
                .coordenadaDto(mapToDto(vendedor.getCoordenada()))
                .build();
    }

    /**
     * Mapea una Coordenada a su DTO correspondiente.
     * 
     * @param coordenada La coordenada a mapear.
     * @return El DTO de la coordenada.
     */
    private CoordenadaDto mapToDto(Coordenada coordenada) {
        return CoordenadaDto.builder()
                .Id(coordenada.getId())
                .latitud(coordenada.getLatitud())
                .longitud(coordenada.getLongitud())
                .build();
    }
}
