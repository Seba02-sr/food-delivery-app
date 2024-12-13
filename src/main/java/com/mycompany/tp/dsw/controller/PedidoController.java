/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mycompany.tp.dsw.dto.ItemPedidoDto;
import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.service.ClienteService;
import com.mycompany.tp.dsw.service.ItemPedidoService;
import com.mycompany.tp.dsw.service.PedidoService;
import com.mycompany.tp.dsw.model.Pedido;
import com.mycompany.tp.dsw.service.ServiceManager;
import com.mycompany.tp.dsw.model.ItemPedido;
import java.util.ArrayList;

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

    public Pedido generarPedido(String idCliente) {

        PedidoDto pedidoDto = new PedidoDto(idCliente);
        return pedidoService.registrarPedido(pedidoDto);
    }

    /*
     * public List<ItemPedido> generarItemPedido(List<ItemPedidoDto>
     * listaItemPedidoDto, Integer idPedido) {
     * List<ItemPedido> itemsPedidos = new ArrayList<>();
     * Pedido pedido = pedidoService.buscarPedidoPorId(idPedido);
     * List<ItemPedido> items = pedido.getItems();
     * for (ItemPedidoDto itemPedidoDto : listaItemPedidoDto) {
     * ItemPedido itemPedido = itemPedidoService.registrarItemPedido(itemPedidoDto);
     * itemPedido.setPedido(pedido);
     * items.add(itemPedido);
     * itemsPedidos.add(itemPedido);
     * }
     * return itemsPedidos;
     * 
     * }
     */

    public List<ItemPedidoDto> generarItemPedidoDto(Map<String, List<Double>> productosYCantidad) {
        return productosYCantidad.entrySet().stream().map(entry -> {
            ItemPedidoDto itemPedidoDto = new ItemPedidoDto();
            double cantidad = entry.getValue().get(0); // Tomamos el primer valor de la lista
            itemPedidoDto.setCantidad((int) cantidad);
            itemPedidoDto.setItemMenuText(entry.getKey());

            return itemPedidoDto;
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
