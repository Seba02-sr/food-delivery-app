/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.service.ClienteService;
import com.mycompany.tp.dsw.service.ItemPedidoService;
import com.mycompany.tp.dsw.service.PedidoService;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.Pedido;
import com.mycompany.tp.dsw.service.ServiceManager;

/**
 *
 * @author Usuario
 */
public class PedidoController {
    ServiceManager serviceManager;
    PedidoService pedidoService;
    ClienteService clienteService;
    ItemMenuController itemMenuController;
    ItemPedidoService itemPedidoService;

    public PedidoController() {
        serviceManager = ServiceManager.getInstance();
        pedidoService = serviceManager.getPedidoService();
        clienteService = serviceManager.getClienteService();
        itemMenuController = new ItemMenuController();
        itemPedidoService = serviceManager.getItemPedidoService();
    }

    public void guardarPedido(Pedido pedido) {
        pedidoService.guardarPedido(pedido);
    }

    public void actualizarPedido(Pedido pedido) throws PedidoNoEncontradoException {
        pedidoService.modificarPedido(pedido);
    }

    public Pedido generarPedido(String idCliente) {

        PedidoDto pedidoDto = PedidoDto.builder().idCliente(idCliente).build();
        return pedidoService.registrarPedido(pedidoDto);
    }

    public List<ItemPedido> generarItemPedido(Map<String, List<Integer>> productosYCantidad) {
        return productosYCantidad.entrySet().stream().map(entry -> {
            ItemPedido itemPedido = ItemPedido.builder().build();
            Integer cantidad = entry.getValue().get(0); // Tomamos el primer valor de la lista
            itemPedido.setCantidad(cantidad);
            ItemMenu itemMenu = itemMenuController.buscarPorNombre(entry.getKey()).get(0);
            itemPedido.setItemMenu(itemMenu);
            return itemPedido;
        }).collect(Collectors.toList()); // Usamos collect para recolectar los resultados en una lista
    }

    public List<Pedido> obtenerPedidosPorCliente(String idCliente) throws ClienteNoEncontradoException {
        Integer id = Integer.parseInt(idCliente);
        return pedidoService.filtrarPedidosPorCliente(id);
    }

    public Pedido obtenerPedidoPorId(String idPedido) {
        Integer id = Integer.parseInt(idPedido);

        try {
            return pedidoService.buscarPedidoPorId(id);
        } catch (PedidoNoEncontradoException e) {
            throw null;
        }
    }

    public List<Pedido> obtenerPedidoPorIdVendedor(String idVendedor) {
        Integer id = Integer.parseInt(idVendedor);
        try {
            return pedidoService.buscarPedidoPorVendedor(id);
        } catch (PedidoNoEncontradoException e) {
            return null;
        }
    }

}
