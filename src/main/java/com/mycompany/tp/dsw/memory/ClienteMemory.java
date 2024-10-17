package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.ClienteDao;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;

public class ClienteMemory implements ClienteDao {

    List<Cliente> clientes = new ArrayList<>();
    private int currentID = 0;
    @Override
    public void crearCliente(Cliente cliente) {
        cliente.setId(currentID++); // Seteo ID unicos
        clientes.add(cliente);
        System.out.println("Se creo un nuevo Cliente con ID: " + cliente.getId());
    }

    @Override
    public List<Cliente> buscarClientePorNombre(String nombre) throws ClienteNoEncontradoException {
        List<Cliente> clienteBuscado = clientes.stream()
            .filter(c -> c.getNombre().toLowerCase().equals(nombre.toLowerCase()))
            .toList(); 

        if (clienteBuscado.isEmpty()){
            throw new ClienteNoEncontradoException("No se encontro un Cliente con el Nombre: " + nombre);
        }  
        return clienteBuscado;
    }

    @Override
    public void modificarCliente(Cliente clienteModificado) throws ClienteNoEncontradoException{
        //Buscar si existe el vendedor
        Cliente existeCliente = clientes.stream()
            .filter(c -> c.getId().equals(clienteModificado.getId()))
            .findFirst()
            .orElseThrow( () -> new ClienteNoEncontradoException("No se encontro el cliente con ID: " + clienteModificado.getId()));

        // Los restantes atributos no tiene sentido modificarlos
        String nombreModificado = clienteModificado.getNombre().trim();
        String cuitModificado = clienteModificado.getCuit();
        String emailModificado = clienteModificado.getEmail();

        // Modificarlos solamente si no son null
        if (nombreModificado != null) existeCliente.setNombre(nombreModificado);
        if (cuitModificado != null) existeCliente.setCuit(cuitModificado);
        if (emailModificado != null) existeCliente.setEmail(emailModificado);
        System.out.println(" modificado correctamente." + "Cliente con ID : " + clienteModificado.getId());
    }

    @Override
    public Cliente buscarClientePorId(Integer id) throws ClienteNoEncontradoException{
        return clientes.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ClienteNoEncontradoException("No se ah encontrado un cliente con ID: " + id));
    }

    @Override
    public void eliminarCliente(Integer id) throws ClienteNoEncontradoException {
        // removeIf devuelve true si pudo borrar el cliente, sino false
        boolean clienteEliminado = clientes.removeIf(c -> c.getId().equals(id));

        // Si no pudo borrar el cliente, lanzar un error que no encontro el cliente
        if (!clienteEliminado){
            throw new ClienteNoEncontradoException("No se encontro el cliente con ID: " + id);
        } else {
            System.out.println("Cliente con ID: " + id + " borrado correctamente.");
        }
    }

    @Override
    public List<Cliente> getAllCliente() {
        return new ArrayList<>(clientes);
    }

}
