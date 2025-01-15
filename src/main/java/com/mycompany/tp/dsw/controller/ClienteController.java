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

    /**
     * Obtiene todos los clientes registrados en el sistema.
     * Convierte la lista de objetos Cliente a objetos ClienteDto para su
     * representación.
     *
     * @return Lista de objetos ClienteDto que representan todos los clientes en el
     *         sistema.
     */
    public List<ClienteDto> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return clientes.stream().map(this::mapToDto).toList();
    }

    /**
     * Persiste un nuevo cliente en el sistema.
     * Los datos del cliente son validados antes de ser registrados.
     *
     * @param clienteDto El objeto ClienteDto a registrar.
     * @throws NoValidarException Si los datos del cliente no son válidos.
     */
    public void guardarCliente(ClienteDto clienteDto) throws NoValidarException {
        clienteService.registrarCliente(clienteDto);
    }

    /**
     * Modifica los datos de un cliente existente en el sistema.
     * Los datos del cliente son validados antes de ser modificados.
     *
     * @param clienteDto El objeto ClienteDto que contiene los nuevos datos del
     *                   cliente.
     * @throws NoValidarException Si los datos del cliente no son válidos.
     */
    public void modificarCliente(ClienteDto clienteDto) throws NoValidarException {
        clienteService.modificarCliente(clienteDto);
    }

    /**
     * Elimina un cliente del sistema dado su identificador.
     * El ID del cliente es validado antes de proceder con la eliminación.
     *
     * @param idText El identificador del cliente a eliminar, en formato de texto.
     * @throws NoValidarException Si el ID proporcionado no es válido.
     */
    public void eliminarCliente(String idText) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        clienteService.eliminarCliente(id);
    }

    /**
     * Busca clientes por su nombre en el sistema.
     *
     * @param nombre El nombre a buscar en el sistema.
     * @return Lista de objetos ClienteDto que representan los clientes encontrados.
     */
    public List<ClienteDto> buscarClientesPorNombre(String nombre) {
        List<Cliente> clientes = clienteService.buscarClientePorNombre(nombre);
        return clientes.stream().map(this::mapToDto).toList();
    }

    /**
     * Busca un cliente por su ID en el sistema.
     * El ID es validado antes de realizar la búsqueda.
     *
     * @param idText El ID del cliente a buscar, en formato de texto.
     * @return El objeto ClienteDto que representa al cliente encontrado.
     * @throws NoValidarException Si el ID proporcionado no es válido.
     */
    public ClienteDto buscarClientePorId(String idText) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        Cliente cliente = clienteService.buscarClientePorId(id);
        return mapToDto(cliente);
    }

    /**
     * Busca un cliente por su ID en el sistema.
     *
     * @param id El ID del cliente a buscar, en formato numérico.
     * @return El objeto ClienteDto que representa al cliente encontrado.
     */
    public ClienteDto buscarClientePorId(Integer id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return mapToDto(cliente);
    }

    /**
     * Mapeo de un objeto Cliente en su correspondiente ClienteDto.
     *
     * @param cliente El objeto Cliente a convertir.
     * @return El objeto ClienteDto que representa al cliente.
     */
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

    /**
     * Convierte un objeto Coordenada en su correspondiente CoordenadaDto.
     *
     * @param coordenada El objeto Coordenada a convertir.
     * @return El objeto CoordenadaDto que representa las coordenadas.
     */
    private CoordenadaDto mapToDto(Coordenada coordenada) {
        return CoordenadaDto.builder()
                .Id(coordenada.getId())
                .latitud(coordenada.getLatitud())
                .longitud(coordenada.getLongitud())
                .build();
    }

    /**
     * Crea un nuevo ClienteDto a partir de los parámetros proporcionados.
     * Valida los parámetros antes de crear el objeto ClienteDto.
     *
     * @param idText    El ID del cliente en formato de texto.
     * @param nombre    El nombre del cliente.
     * @param cuit      El CUIT del cliente.
     * @param direccion La dirección del cliente.
     * @param email     La dirección de correo electrónico del cliente.
     * @param latitud   La latitud de las coordenadas del cliente.
     * @param longitud  La longitud de las coordenadas del cliente.
     * @return El objeto ClienteDto creado a partir de los parámetros
     *         proporcionados.
     * @throws NoValidarException Si alguno de los parámetros no es válido.
     */
    public ClienteDto crearClienteDto(String idText, String nombre, String cuit, String direccion, String email,
            String latitud,
            String longitud) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        if (nombre != null) {
            nombreValido(nombre);
        }

        if (direccion != null) {
            direccionValida(direccion);
        }

        if (cuit != null) {
            cuitValido(cuit);
        }

        if (email != null) {
            emailValido(email);
        }

        return ClienteDto.builder()
                .id(id)
                .nombre(nombre)
                .cuit(cuit)
                .direccion(direccion)
                .email(email)
                .coordenadaDto(armarCoordenadaDto(latitud, longitud))
                .build();
    }

    // Validaciones de los atributos para realizar la creacion de un Cliente.
    private void direccionValida(String direccion) throws NoValidarException {
        if (isEmpty(direccion)) {
            throw new NoValidarException("Error: La dirección no puede estar vacía");
        }
        if (!letrasNumeros(direccion)) {
            throw new NoValidarException("Error: La dirección solo puede contener letras y números");
        }
    }

    private void emailValido(String email) throws NoValidarException {
        if (isEmpty(email)) {
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
        if (isEmpty(cuit)) {
            throw new NoValidarException("Error: El CUIT no puede estar vacío");
        }
        if (!soloNumeroCuit(cuit)) {
            throw new NoValidarException("Error: El CUIT solo puede contener números y guiones (-)");
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

    public Boolean isEmpty(String palabra) {
        return (palabra.trim().isEmpty());
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

        Double latitud = null;
        Double longitud = null;

        if (latitudText != null) {
            latitud = latitudValida(latitudText);
        }
        if (longitudText != null) {
            longitud = longitudValida(longitudText);
        }
        return CoordenadaDto.builder().latitud(latitud).longitud(longitud).build();

    }

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

}
