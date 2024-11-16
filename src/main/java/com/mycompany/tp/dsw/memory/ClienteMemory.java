package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.ClienteDao;
import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Coordenada;

public class ClienteMemory {

    private ClienteDao clienteDao;

    public ClienteMemory() {
        clienteDao = new ClienteDao();
    }

    /**
     * Crea y persiste un cliente
     * - Menejo de id unicos con currentID
     * 
     * @param clientedto El cliente a persistir
     */
    public void registrarCliente(ClienteDto clientedto) {
        // 1. Crear la instancia Cliente
        Cliente cliente = parseCliente(clientedto);

        // 2. Persistir el dato
        clienteDao.add(cliente);
    }

    /**
     * Busca clientes filtrado por el nombre
     * - Ignora mayusculas y minusculas
     * 
     * @param nombre
     * @return Lista de clientes que coinciden con el @param
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    public List<Cliente> buscarClientePorNombre(String nombre) {
        return clienteDao.findByNombre(nombre);
    }

    /**
     * Modifica los datos de un cliente especifico
     * - Del objeto cliente pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param clienteDto El objeto 'ClienteDTO' con los datos modificados
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    public void modificarCliente(ClienteDto clienteDto) throws ClienteNoEncontradoException {
        // 1. Crear la instancia cliente
        Cliente cliente = parseCliente(clienteDto);

        // 2. Persistir el cambio
        clienteDao.update(cliente);
    }

    /**
     * Busca un cliente segun el id
     * 
     * @param id
     * @return El cliente que corresponde al @param
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    public Cliente buscarClientePorId(Integer id) {
        return clienteDao.findById(id);
    }

    /**
     * Elimina un cliente, segun el id
     * 
     * @param id
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    public void eliminarCliente(Integer id) throws ClienteNoEncontradoException {
        clienteDao.delete(id);
    }

    /**
     * Obtiene una lista de todos los clientes del sistema.
     * 
     * @return Lista de los clientes del sistema.
     */
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDao.findAll();
    }

    /**
     * Realiza la creacion del objeto 'Cliente' a partir de su DTO
     * 
     * @param clienteDto El DTO que se quiere crear cliente
     * @return El objeto cliente
     */
    private Cliente parseCliente(ClienteDto clienteDto) {

        String id = clienteDto.getIdText();
        if (!esNullOrBlank(id)) {
            clienteDto.setId(Integer.valueOf(id));
        }

        String latitudText = clienteDto.getLatitud();
        Double latitud = null;
        if (!esNullOrBlank(latitudText)) {
            latitud = Double.parseDouble(latitudText);
        }

        String longitudText = clienteDto.getLongitud();
        Double longitud = null;
        if (!esNullOrBlank(longitudText)) {
            longitud = Double.parseDouble(longitudText);
        }

        if (latitud != null && longitud != null) {
            clienteDto.setCoordenada(new Coordenada(latitud, longitud));
        }

        return new Cliente(clienteDto);
    }

    private static Boolean esNullOrBlank(String palabra) {
        return palabra == null || palabra.isBlank();
    }

}
