package com.mycompany.tp.dsw.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;

public class ClienteDao {

    private static List<Cliente> clientes = new ArrayList<>();
    private static int currentID = 0;

    public void add(Cliente cliente) {
        cliente.setId(currentID++);
        clientes.add(cliente);
    }

    public List<Cliente> findByNombre(String nombre) throws ClienteNoEncontradoException {
        List<Cliente> clienteBuscado = clientes.stream()
                .filter(c -> c.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                .toList();
        if (clienteBuscado.isEmpty()) {
            throw new ClienteNoEncontradoException("No se encontro un Cliente con el Nombre: " + nombre);
        }
        return clienteBuscado;
    }

    public void update(Cliente cliente) throws ClienteNoEncontradoException {

        Cliente existeCliente = findById(cliente.getId());

        if (existeCliente == null) {
            throw new ClienteNoEncontradoException("Cliente con ID " + cliente.getId() + " no encontrado.");
        }

        String nombreModificado = cliente.getNombre().trim();
        String cuitModificado = cliente.getCuit();
        String emailModificado = cliente.getEmail();

        if (nombreModificado != null)
            existeCliente.setNombre(nombreModificado);
        if (cuitModificado != null)
            existeCliente.setCuit(cuitModificado);
        if (emailModificado != null)
            existeCliente.setEmail(emailModificado);
    }

    public void delete(Integer id) throws ClienteNoEncontradoException {
        boolean clienteEliminado = clientes.removeIf(c -> c.getId().equals(id));

        if (!clienteEliminado) {
            throw new ClienteNoEncontradoException("No se encontro el cliente con ID: " + id);
        } else {
            System.out.println("Cliente con ID: " + id + " borrado correctamente.");
        }
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    public Cliente findById(Integer id) throws ClienteNoEncontradoException {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ClienteNoEncontradoException("No se ah encontrado un cliente con ID: " + id));
    }

}
