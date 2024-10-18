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

    @Override
    public void crearPedido(Pedido pedido) {
        pedido.setId(currentID++);
        pedidos.add(pedido);
        System.out.println("Se creo un nuevo Pedido");
    }

    @Override
    public List<Pedido> filtrarPedidosPorCliente(Integer clienteId) throws ClienteNoEncontradoException {
        // Buscar un cliente con el id, si no se encuentra lanzar una excepcion
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getCliente().getId().equals(clienteId))
                .toList();
        if (pedidosCliente.isEmpty()) {
            throw new ClienteNoEncontradoException("No se encontraron pedidos del cliente con ID:" + clienteId);
        }
        return pedidosCliente;
    }

    @Override
    public List<Pedido> filtrarPedidoPorEstado(Estado estado) {
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getEstado().equals(estado))
                .toList();
        return pedidosCliente;
    }

    @Override
    public void modificarPedido(Pedido pedidoModificado) {
        // Buscar si existe el pedido
        Optional<Pedido> existePedido = pedidos.stream().filter(p -> p.getId().equals(pedidoModificado.getId()))
                .findFirst();

        // Los demas atributos no tiene sentido modificarlos
        Estado estadoModificado = pedidoModificado.getEstado();
        List<ItemPedido> itemsPedidoModificado = pedidoModificado.getItems();

        // Se modifica solamente si no son null
        // Ahorra tener que pasar un Pedido completo y solamente el id y los parametros
        // a modificar
        existePedido.ifPresent(v -> {
            if (estadoModificado != null)
                v.setEstado(estadoModificado);
            if (itemsPedidoModificado != null)
                v.setItems(itemsPedidoModificado);
        });

    }

    @Override
    public void eliminarPedido(Integer id) {
        pedidos.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Pedido> getAllPedido() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public Pedido buscarPedidoPorId(Integer id) throws PedidoNoEncontradoException {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PedidoNoEncontradoException("No se ha encontrado pedido con ID: " + id));
    }

    @Override
    public List<Pedido> buscarPedidoPorVendedor(Integer idVendedor) throws PedidoNoEncontradoException {
        return pedidos.stream()
                .filter(p -> p.getEstado().equals(Estado.RECIBIDO) &&
                        !p.getItems().isEmpty() &&
                        p.getItems().get(0).getItemMenu().getVendedor().getId().equals(idVendedor))
                .toList();
    }
}
