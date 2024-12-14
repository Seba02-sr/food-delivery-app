package com.mycompany.tp.dsw.controller;

import java.util.List;

import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.service.ClienteService;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.service.ServiceManager;
import com.mycompany.tp.dsw.service.ValidarCliente;

public class ClienteController {

    ServiceManager serviceManager;
    ClienteService clienteService;

    public ClienteController() {
        serviceManager = ServiceManager.getInstance();
        clienteService = serviceManager.getClienteService();
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    public void guardarCliente(ClienteDto clienteDto) throws NoValidarException {
        ValidarCliente.esGuardarValido(clienteDto);
        clienteService.registrarCliente(clienteDto);
    }

    public void modificarCliente(ClienteDto clienteDto) throws NoValidarException {
        ValidarCliente.esModificarValido(clienteDto);
        clienteService.modificarCliente(clienteDto);
    }

    public void eliminarCliente(String idText) throws NoValidarException {
        ValidarCliente.esEliminarValido(idText);
        Integer id = Integer.parseInt(idText);
        clienteService.eliminarCliente(id);
    }

    public List<Cliente> buscarClientesPorNombre(String nombre) {
        List<Cliente> clientes = clienteService.buscarClientePorNombre(nombre);
        return clientes;
    }

    public Cliente buscarClientePorId(String idText) {
        Integer id = Integer.parseInt(idText);
        return clienteService.buscarClientePorId(id);
    }

}
