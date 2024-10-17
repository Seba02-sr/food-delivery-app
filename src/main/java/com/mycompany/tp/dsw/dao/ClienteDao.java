package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;

public interface ClienteDao { // CRUD
    void crearCliente(Cliente cliente);
    List<Cliente> buscarClientePorNombre(String nombre) throws ClienteNoEncontradoException;
    void modificarCliente(Cliente cliente) throws ClienteNoEncontradoException;
    void eliminarCliente(Integer id) throws ClienteNoEncontradoException;   
    List<Cliente> getAllCliente();
    Cliente buscarClientePorId(Integer id) throws ClienteNoEncontradoException;

}
