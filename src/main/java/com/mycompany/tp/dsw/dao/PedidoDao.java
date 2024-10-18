package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.Pedido;

public interface PedidoDao { // CRUD
    void crearPedido(Pedido pedido);

    List<Pedido> filtrarPedidosPorCliente(Integer clienteId) throws ClienteNoEncontradoException;

    List<Pedido> filtrarPedidoPorEstado(Estado estado);

    void modificarPedido(Pedido pedido);

    void eliminarPedido(Integer id);

    List<Pedido> getAllPedido();

    Pedido buscarPedidoPorId(Integer id) throws PedidoNoEncontradoException;

    List<Pedido> buscarPedidoPorVendedor(Integer idVendedor) throws PedidoNoEncontradoException;
}
