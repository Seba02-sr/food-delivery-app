package com.mycompany.tp.dsw.service;

import java.util.List;

import com.mycompany.tp.dsw.dao.ClienteDao;
import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Coordenada;

public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService() {
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
        clienteDao.save(cliente);
    }

    /**
     * Busca clientes filtrado por el nombre
     * - Ignora mayusculas y minusculas
     * 
     * @param nombre
     * @return Lista de clientes que coinciden con el @param
     */
    public List<Cliente> buscarClientePorNombre(String nombre) {
        return clienteDao.findActiveByNombre(nombre);
    }

    /**
     * Modifica los datos de un cliente especifico
     * 
     * @param clienteDto El objeto 'ClienteDTO' con los datos modificados
     */
    public void modificarCliente(ClienteDto clienteDto) {
        // 1. Crear la instancia cliente
        Cliente cliente = parseCliente(clienteDto);

        // 2. Persistir el cambio
        clienteDao.update(cliente);
    }

    /**
     * Busca un cliente ACTIVO segun el id
     * 
     * @param id
     * @return El cliente que corresponde al @param
     */
    public Cliente buscarClientePorId(Integer id) {
        return clienteDao.findByIdAndActive(id);
    }

    /**
     * Elimina LOGICAMENTE un cliente, segun el id.
     * - seteando ACTIVO en false.
     * 
     * @param id
     */
    public void eliminarCliente(Integer id) {
        Cliente cliente = clienteDao.findById(id);
        clienteDao.deleteLogico(cliente);
    }

    /**
     * Obtiene una lista de todos los clientes ACTIVOS del sistema.
     * 
     * @return Lista de los clientes del sistema.
     */
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDao.findAllActive();
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
            clienteDto.setCoordenada(Coordenada.builder().latitud(latitud).longitud(longitud).build());
        }

        return new Cliente(clienteDto);
    }

    private static Boolean esNullOrBlank(String palabra) {
        return palabra == null || palabra.isBlank();
    }

}
