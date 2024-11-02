package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.ClienteDao;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;

public class ClienteMemory implements ClienteDao {

    List<Cliente> clientes = new ArrayList<>();
    private int currentID = 0;

    /**
     * Crea y persiste un cliente
     * - Menejo de id unicos con currentID
     * 
     * @param cliente El cliente a persistir
     */
    @Override
    public void crearCliente(Cliente cliente) {
        cliente.setId(currentID++);
        clientes.add(cliente);
        System.out.println("Se creo un nuevo Cliente con ID: " + cliente.getId());
    }

    /**
     * Busca clientes filtrado por el nombre
     * - Ignora mayusculas y minusculas
     * 
     * @param nombre
     * @return Lista de clientes que coinciden con el @param
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    @Override
    public List<Cliente> buscarClientePorNombre(String nombre) throws ClienteNoEncontradoException {
        List<Cliente> clienteBuscado = clientes.stream()
                .filter(c -> c.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                .toList();

        if (clienteBuscado.isEmpty()) {
            throw new ClienteNoEncontradoException("No se encontro un Cliente con el Nombre: " + nombre);
        }
        return clienteBuscado;
    }

    /**
     * Modifica los datos de un cliente especifico
     * - Del objeto cliente pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param cliente El objeto 'Cliente' con los datos modificados
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    @Override
    public void modificarCliente(Cliente clienteModificado) throws ClienteNoEncontradoException {
        Cliente existeCliente = clientes.stream()
                .filter(c -> c.getId().equals(clienteModificado.getId()))
                .findFirst()
                .orElseThrow(() -> new ClienteNoEncontradoException(
                        "No se encontro el cliente con ID: " + clienteModificado.getId()));

        String nombreModificado = clienteModificado.getNombre().trim();
        String cuitModificado = clienteModificado.getCuit();
        String emailModificado = clienteModificado.getEmail();

        if (nombreModificado != null)
            existeCliente.setNombre(nombreModificado);
        if (cuitModificado != null)
            existeCliente.setCuit(cuitModificado);
        if (emailModificado != null)
            existeCliente.setEmail(emailModificado);
        System.out.println(" modificado correctamente." + "Cliente con ID : " + clienteModificado.getId());
    }

    /**
     * Busca un cliente segun el id
     * 
     * @param id
     * @return El cliente que corresponde al @param
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    @Override
    public Cliente buscarClientePorId(Integer id) throws ClienteNoEncontradoException {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ClienteNoEncontradoException("No se ah encontrado un cliente con ID: " + id));
    }

    /**
     * Elimina un cliente, segun el id
     * 
     * @param id
     * @throws ClienteNoEncontradoException Si el cliente no se encuentra
     */
    @Override
    public void eliminarCliente(Integer id) throws ClienteNoEncontradoException {
        boolean clienteEliminado = clientes.removeIf(c -> c.getId().equals(id));

        if (!clienteEliminado) {
            throw new ClienteNoEncontradoException("No se encontro el cliente con ID: " + id);
        } else {
            System.out.println("Cliente con ID: " + id + " borrado correctamente.");
        }
    }

    /**
     * Obtiene una lista de todos los clientes del sistema.
     * 
     * @return Lista de los clientes del sistema.
     */
    @Override
    public List<Cliente> getAllCliente() {
        return new ArrayList<>(clientes);
    }

}
