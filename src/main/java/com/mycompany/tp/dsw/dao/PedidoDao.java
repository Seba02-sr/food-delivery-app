package com.mycompany.tp.dsw.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.Pedido;

public class PedidoDao {

    List<Pedido> pedidos;
    private int currentID;

    public PedidoDao() {
        pedidos = new ArrayList<>();
        currentID = 0;
    }

    public void add(Pedido pedido) {
        pedido.setId(currentID++);
        pedidos.add(pedido);
    }

    public List<Pedido> findByCliente(Integer clienteId) throws ClienteNoEncontradoException {
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getCliente().getId().equals(clienteId))
                .toList();
        if (pedidosCliente.isEmpty()) {
            throw new ClienteNoEncontradoException("No se encontraron pedidos del cliente con ID:" + clienteId);
        }
        return pedidosCliente;
    }

    public List<Pedido> findByEstado(Estado estado) {
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getEstado().equals(estado))
                .toList();
        return pedidosCliente;
    }

    public void update(Pedido pedido) throws PedidoNoEncontradoException {
        Pedido existePedido = findById(pedido.getId());
        if (existePedido != null) {
            Estado estado = pedido.getEstado();
            List<ItemPedido> itemsPedido = pedido.getItems();

            if (estado != null) {
                existePedido.setEstado(estado);
            }
            if (itemsPedido != null) {
                existePedido.setItems(itemsPedido);
            }
        }
    }

    public void delete(Integer id) {
        pedidos.removeIf(p -> p.getId().equals(id));
    }

    public List<Pedido> findAll() {
        return pedidos;
    }

    public Pedido findById(Integer id) throws PedidoNoEncontradoException {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PedidoNoEncontradoException("No se ha encontrado pedido con ID: " + id));
    }

    public List<Pedido> findByVendedor(Integer idVendedor) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equals(Estado.RECIBIDO) &&
                        !p.getItems().isEmpty() &&
                        p.getItems().get(0).getItemMenu().getVendedor().getId().equals(idVendedor))
                .toList();
    }
}
