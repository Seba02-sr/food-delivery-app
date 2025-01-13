package com.mycompany.tp.dsw.controller;

import java.util.List;

import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.dto.CoordenadaDto;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.service.ClienteService;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Coordenada;
import com.mycompany.tp.dsw.service.ServiceManager;

public class ClienteController {

    ServiceManager serviceManager;
    ClienteService clienteService;

    public ClienteController() {
        serviceManager = ServiceManager.getInstance();
        clienteService = serviceManager.getClienteService();
    }

    public List<ClienteDto> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return clientes.stream().map(this::mapToDto).toList();
    }

    public void guardarCliente(ClienteDto clienteDto) throws NoValidarException {
        // ValidarCliente.esGuardarValido(clienteDto);
        clienteService.registrarCliente(clienteDto);
    }

    public void modificarCliente(ClienteDto clienteDto) throws NoValidarException {
        clienteService.modificarCliente(clienteDto);
    }

    public void eliminarCliente(String idText) throws NoValidarException {
        Integer id = idValido(idText);
        clienteService.eliminarCliente(id);
    }

    public List<ClienteDto> buscarClientesPorNombre(String nombre) {
        List<Cliente> clientes = clienteService.buscarClientePorNombre(nombre);
        return clientes.stream().map(this::mapToDto).toList();
    }

    public ClienteDto buscarClientePorId(String idText) throws NoValidarException {
        Integer id = idValido(idText);
        Cliente cliente = clienteService.buscarClientePorId(id);
        return mapToDto(cliente);
    }

    public ClienteDto buscarClientePorId(Integer id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return mapToDto(cliente);
    }

    private ClienteDto mapToDto(Cliente cliente) {
        return ClienteDto.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .cuit(cliente.getCuit())
                .direccion(cliente.getDireccion())
                .email(cliente.getEmail())
                .coordenadaDto(mapToDto(cliente.getCoordenada()))
                .build();
    }

    private CoordenadaDto mapToDto(Coordenada coordenada) {
        return CoordenadaDto.builder()
                .Id(coordenada.getId())
                .latitud(coordenada.getLatitud())
                .longitud(coordenada.getLongitud())
                .build();
    }

    public ClienteDto crearClienteDto(String idText, String nombre, String cuit, String direccion, String email,
            String latitud,
            String longitud) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        nombreValido(nombre);
        cuitValido(cuit);
        direccionValida(direccion);
        emailValido(email);

        return ClienteDto.builder()
                .id(id)
                .nombre(nombre)
                .cuit(cuit)
                .direccion(direccion)
                .email(email)
                .coordenadaDto(armarCoordenadaDto(latitud, longitud))
                .build();
    }

    private void direccionValida(String direccion) throws NoValidarException {
        if (esNullOrEmpty(direccion)) {
            throw new NoValidarException("Error: La dirección no puede estar vacía");
        }
        if (!letrasNumeros(direccion)) {
            throw new NoValidarException("Error: La dirección solo puede contener letras y números");
        }
    }

    private void emailValido(String email) throws NoValidarException {
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

    private void cuitValido(String cuit) throws NoValidarException {
        if (esNullOrEmpty(cuit)) {
            throw new NoValidarException("Error: El CUIT no puede estar vacío");
        }
        if (!soloNumeroCuit(cuit)) {
            throw new NoValidarException("Error: El CUIT solo puede contener números y guiones (-)");
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

    public Boolean esNullOrEmpty(String palabra) {
        return (palabra.trim().isEmpty()); // palabra == null ||
    }

    private Boolean soloLetras(String palabra) {
        return palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    private Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    private Boolean letrasNumerosYCaracteresMail(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ@._\\-+]+$");
    }

    private Boolean soloNumeroCuit(String numero) {
        return numero.matches("^[\\d-]+$");
    }

    private Boolean esMail(String palabra) {
        return palabra.endsWith("@gmail.com") || palabra.endsWith("@outlook.com") || palabra.endsWith("@hotmail.com");
    }

    private CoordenadaDto armarCoordenadaDto(String latitudText, String longitudText) throws NoValidarException {
        Double latitud = latitudValida(latitudText);
        Double longitud = longitudValida(longitudText);

        return CoordenadaDto.builder().latitud(latitud).longitud(longitud).build();

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

}
