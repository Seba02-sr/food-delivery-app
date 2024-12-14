package com.mycompany.tp.dsw.controller;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.mycompany.tp.dsw.dto.ClienteDto;
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

    public void guardarCliente(ClienteDto clienteDto) {
        Map<String, String> errores = ValidarCliente.esGuardarValido(clienteDto);

        if (errores.isEmpty()) {
            clienteService.registrarCliente(clienteDto);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente");
        } else {

        }

    }

    public void modificarCliente(ClienteDto clienteDto) {
        clienteService.modificarCliente(clienteDto);
    }

    public void eliminarCliente(String idText) {
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
