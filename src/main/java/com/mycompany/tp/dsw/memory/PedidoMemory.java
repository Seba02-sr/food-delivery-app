package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.tp.dsw.dao.PedidoDao;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.Pedido;

public class PedidoMemory implements PedidoDao {

    List<Pedido> pedidos = new ArrayList<>();
    private int currentID = 0;

    /**
     * Crea y persiste un pedido
     * - Manejo de id unicos con currentID
     * 
     * @param pedido El pedido a persistir
     */
    @Override
    public void crearPedido(Pedido pedido) {
        pedido.setId(currentID++);
        pedidos.add(pedido);
        System.out.println("Se creo un nuevo Pedido");
    }

    /**
     * Obtiene los pedidos, filtrados por cliente
     * 
     * @param clienteId El cliente al que se quiere buscar los pedidos
     * @return Lista de los pedidos del cliente del @param
     * @throws ClienteNoEncontradoException Si no encuentra el cliente
     */
    @Override
    public List<Pedido> filtrarPedidosPorCliente(Integer clienteId) throws ClienteNoEncontradoException {
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getCliente().getId().equals(clienteId))
                .toList();
        if (pedidosCliente.isEmpty()) {
            throw new ClienteNoEncontradoException("No se encontraron pedidos del cliente con ID:" + clienteId);
        }
        return pedidosCliente;
    }

    /**
     * Obtiene los pedidos, filtrados por estado
     * - Estados: RECIBIDO, ACEPTADO, PREPARADO, ENVIADO, ENTREGADO
     * 
     * @param estado El estado a por filtrar
     * @return Lista de pedidos que permanecen en el estado del @param
     */
    @Override
    public List<Pedido> filtrarPedidoPorEstado(Estado estado) {
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getEstado().equals(estado))
                .toList();
        return pedidosCliente;
    }

    /**
     * Modifica los datos de un pedido
     * - Del objeto pedido pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param pedidoModificado El objeto pedido con los datos modificados
     */
    @Override
    public void modificarPedido(Pedido pedidoModificado) {
        Optional<Pedido> existePedido = pedidos.stream().filter(p -> p.getId().equals(pedidoModificado.getId()))
                .findFirst();
        Estado estadoModificado = pedidoModificado.getEstado();
        List<ItemPedido> itemsPedidoModificado = pedidoModificado.getItems();

        existePedido.ifPresent(v -> {
            if (estadoModificado != null)
                v.setEstado(estadoModificado);
            if (itemsPedidoModificado != null)
                v.setItems(itemsPedidoModificado);
        });

    }

    /**
     * Elimina un pedido, segun el id
     * 
     * @param id
     */
    @Override
    public void eliminarPedido(Integer id) {
        pedidos.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Obtiene una lista de todos los pedidos del sistema
     * 
     * @return Lista de los pedidos del sistema
     */
    @Override
    public List<Pedido> getAllPedido() {
        return new ArrayList<>(pedidos);
    }

    /**
     * Obtiene los pedidos, filtrados por id
     * 
     * @param id El id del pedido a buscar
     * @return El pedido correspondiente al id
     * @throws PedidoNoEncontradoException Si no encuentra el pedido
     */
    @Override
    public Pedido buscarPedidoPorId(Integer id) throws PedidoNoEncontradoException {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PedidoNoEncontradoException("No se ha encontrado pedido con ID: " + id));
    }

    /**
     * Obtiene los pedidos, filtrados por restaurante
     * 
     * @param idVendedor El id del restaurante a buscar sus pedidos
     * @return Lista de los pedidos del restaurante del @param
     */
    @Override
    public List<Pedido> buscarPedidoPorVendedor(Integer idVendedor) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equals(Estado.RECIBIDO) &&
                        !p.getItems().isEmpty() &&
                        p.getItems().get(0).getItemMenu().getVendedor().getId().equals(idVendedor))
                .toList();
    }
}
