/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.ItemPedidoDto;
import com.mycompany.tp.dsw.dto.MercadoPagoDto;
import com.mycompany.tp.dsw.dto.PagoDto;
import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.dto.PedidoItemPedidoDto;
import com.mycompany.tp.dsw.dto.TransferenciaDto;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.service.ClienteService;
import com.mycompany.tp.dsw.service.PedidoService;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.MercadoPago;
import com.mycompany.tp.dsw.model.Pago;
import com.mycompany.tp.dsw.model.Pedido;
import com.mycompany.tp.dsw.model.Transferencia;
import com.mycompany.tp.dsw.service.ServiceManager;

/**
 *
 * @author Usuario
 */
public class PedidoController {
    private ServiceManager serviceManager;
    private PedidoService pedidoService;
    private ClienteService clienteService;
    private ItemMenuController itemMenuController;

    public PedidoController() {
        serviceManager = ServiceManager.getInstance();
        pedidoService = serviceManager.getPedidoService();
        clienteService = serviceManager.getClienteService();
        itemMenuController = new ItemMenuController();
    }

    public void guardarPedido(PedidoDto pedidoDto, List<ItemPedidoDto> listaItemPedido) { // ACA
        // Genera el itemPedido y agregarlo al pedido
        List<PedidoItemPedidoDto> pedidoItemPedidoDtos = new ArrayList<>();

        for (ItemPedidoDto itemPedidoDto : listaItemPedido) {
            PedidoItemPedidoDto pedidoItemPedidoDto = PedidoItemPedidoDto.builder()
                    .pedidoDto(pedidoDto)
                    .itemPedidoDto(itemPedidoDto)
                    .build();

            pedidoItemPedidoDtos.add(pedidoItemPedidoDto);
            // pedidoDto.getPedidoItemPedidosDto().add(pedidoItemPedidoDto);
        }

        pedidoService.guardarPedido(pedidoDto, pedidoItemPedidoDtos);
    }

    public void actualizarEstadoPedido(PedidoDto pedidoDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        pedido.setEstado(pedidoDto.getEstado());

        pedidoService.modificarPedido(pedido);
    }

    public PedidoDto generarPedido(String idCliente) {
        Integer id = Integer.parseInt(idCliente);

        PedidoDto pedidoDto = PedidoDto.builder().clienteId(id).build();
        Pedido pedido = pedidoService.registrarPedido(pedidoDto);
        return mapToDto(pedido);
    }

    public BigDecimal calcularTotalSinRecargo(PedidoDto pedidoDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        return pedido.totalSinRecargo();
    }

    public List<ItemPedidoDto> generarItemPedidoDto(Map<String, List<Integer>> productosYCantidad) {
        return productosYCantidad.entrySet().stream().map(entry -> {
            ItemPedidoDto itemPedido = ItemPedidoDto.builder().build();
            Integer cantidad = entry.getValue().get(0); // Tomamos el primer valor de la lista
            itemPedido.setCantidad(cantidad);
            ItemMenuDto itemMenu = itemMenuController.buscarPorNombre(entry.getKey()).get(0);
            itemPedido.setItemMenuDto(itemMenu);
            return itemPedido;
        }).collect(Collectors.toList()); // Usamos collect para recolectar los resultados en una lista
    }

    public List<PedidoDto> obtenerPedidosPorCliente(String idCliente)
            throws ClienteNoEncontradoException, NoValidarException {
        Integer id = idValido(idCliente);
        List<Pedido> pedidos = pedidoService.filtrarPedidosPorCliente(id);
        return pedidos.stream().map(this::mapToDto).toList();
    }

    public PedidoDto obtenerPedidoPorId(String idPedido) throws NoValidarException {
        Integer id = idValido(idPedido);

        try {
            Pedido pedido = pedidoService.buscarPedidoPorId(id);
            return mapToDto(pedido);
        } catch (PedidoNoEncontradoException e) {
            throw null;
        }
    }

    public List<PedidoDto> obtenerPedidoPorIdVendedor(String idVendedor) {
        Integer id = Integer.parseInt(idVendedor);
        try {
            List<Pedido> pedidos = pedidoService.buscarPedidoPorVendedor(id);
            return pedidos.stream().map(this::mapToDto).toList();
        } catch (PedidoNoEncontradoException e) {
            return null;
        }
    }

    private PedidoDto mapToDto(Pedido pedido) {
        return PedidoDto.builder()
                .clienteId(pedido.getCliente().getId())
                .id(pedido.getId())
                .estado(pedido.getEstado())
                .formaPagoDto(mapToDto(pedido.getFormaPago()))
                .build();
    }

    private PagoDto mapToDto(Pago pago) {
        switch (pago.getClass().getName().toLowerCase()) {
            case "mercadopago":
                MercadoPago mp = (MercadoPago) pago;
                return MercadoPagoDto.builder()
                        .alias(mp.getAlias())
                        .id(mp.getId())
                        .fechaPago(mp.getFechaPago())
                        .monto(mp.getMonto())
                        .build();
            case "transferencia":
                Transferencia t = (Transferencia) pago;
                return TransferenciaDto.builder()
                        .cbu(t.getCbu())
                        .cuit(t.getCuit())
                        .id(t.getId())
                        .fechaPago(t.getFechaPago())
                        .monto(t.getMonto())
                        .build();
            default:
                return null;
        }
    }

    private Integer idValido(String idText) throws NoValidarException {
        try {
            if (esNullOrEmpty(idText)) {
                throw new NoValidarException("Error: El id no puede estar vacío");
            }
            return Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El id solo puede contener números");
        }
    }

    public Boolean esNullOrEmpty(String palabra) {
        return (palabra == null || palabra.trim().isEmpty());
    }

    public void actualizarPedido(PedidoDto pedidoDto, ClienteDto clienteDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        Cliente cliente = clienteService.buscarClientePorId(clienteDto.getId());
        pedido.addObserver(cliente);
        pedido.setEstado(Estado.PAGADO);

    }

    public BigDecimal calcularTotalAPagar(PedidoDto pedidoDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        return pedido.total();
    }

    public List<ItemPedidoDto> obtenerItemPedidosPorPedido(PedidoDto pedidoDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        List<ItemPedido> itemPedidos = pedido.getItems();

        return itemPedidos.stream().map(this::mapToDto).toList();
    }

    private ItemPedidoDto mapToDto(ItemPedido itemPedido) {
        return ItemPedidoDto.builder()
                .id(itemPedido.getId())
                .cantidad(itemPedido.getCantidad())
                .itemMenuDto(itemMenuController.mapToDto(itemPedido.getItemMenu()))
                .build();

    }

    public Object obtenerNombreVendedor(PedidoDto pedidoDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        return pedido.obtenerVendedor().getNombre();
    }

    public Object obtenerCantidadItems(PedidoDto pedidoDto) throws PedidoNoEncontradoException {
        Pedido pedido = pedidoService.buscarPedidoPorId(pedidoDto.getId());
        return pedido.cantidadItems();
    }
}
