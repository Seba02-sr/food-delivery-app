package com.mycompany.tp.dsw.service;

import java.util.List;

import com.mycompany.tp.dsw.dao.PedidoDao;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.ItemPedidoDto;
import com.mycompany.tp.dsw.dto.MercadoPagoDto;
import com.mycompany.tp.dsw.dto.PagoDto;
import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.dto.PedidoItemPedidoDto;
import com.mycompany.tp.dsw.dto.TransferenciaDto;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.MercadoPago;
import com.mycompany.tp.dsw.model.Pago;
import com.mycompany.tp.dsw.model.Pedido;
import com.mycompany.tp.dsw.model.Transferencia;
import com.mycompany.tp.dsw.model.relacion.PedidoItemPedido;

public class PedidoService {

    private PedidoDao pedidoDao;
    private ClienteService clienteService;
    private ServiceManager serviceManager;
    private ItemMenuService itemMenuService;

    public PedidoService() {
        serviceManager = ServiceManager.getInstance();
        clienteService = serviceManager.getClienteService();
        itemMenuService = serviceManager.getItemMenuService();
        pedidoDao = new PedidoDao();
    }

    /**
     * Crea y persiste un pedido
     * - Manejo de id unicos con currentID
     * 
     * @param pedido El pedido a persistir
     */
    public Pedido registrarPedido(PedidoDto pedidoDto) {
        Pedido pedido = parsePedido(pedidoDto);
        pedidoDao.save(pedido);
        return pedido;
    }

    public void guardarPedido(PedidoDto pedidoDto, List<PedidoItemPedidoDto> pedidoItemPedidoDtos) {
        // Mapear PedidoDto a Pedido (modelo)
        Pedido pedido = mapToPedidoModel(pedidoDto, pedidoItemPedidoDtos);

        // Guardar el Pedido en la base de datos
        pedidoDao.save(pedido);
    }

    private Pedido mapToPedidoModel(PedidoDto pedidoDto, List<PedidoItemPedidoDto> pedidoItemPedidoDtos) {
        // Mapear PedidoDto a Pedido
        Pedido pedido = Pedido.builder()
                .id(pedidoDto.getId()) // Si es nuevo, este valor será null
                .estado(pedidoDto.getEstado())
                .cliente(mapToCliente(pedidoDto.getClienteId()))
                .formaPago(mapToPago(pedidoDto.getFormaPagoDto()))
                .build();

        // Mapear cada PedidoItemPedidoDto a PedidoItemPedido y agregar al Pedido
        List<PedidoItemPedido> pedidoItemPedidos = pedidoItemPedidoDtos.stream()
                .map(this::mapToPedidoItemPedidoModel)
                .peek(pedidoItem -> pedidoItem.setPedido(pedido)) // Establecer la relación bidireccional
                .toList();

        pedido.setPedidoItemPedidos(pedidoItemPedidos);
        return pedido;
    }

    private Cliente mapToCliente(Integer id) {
        return clienteService.buscarClientePorId(id);
    }

    private Pago mapToPago(PagoDto pagoDto) {
        switch (pagoDto.getClass().getSimpleName().toLowerCase()) {
            case "mercadopago":
                MercadoPagoDto mp = (MercadoPagoDto) pagoDto;
                return MercadoPago.builder()
                        .alias(mp.getAlias())
                        .id(mp.getId())
                        .fechaPago(mp.getFechaPago())
                        .monto(mp.getMonto())
                        .build();
            case "transferencia":
                TransferenciaDto t = (TransferenciaDto) pagoDto;
                return Transferencia.builder()
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

    private PedidoItemPedido mapToPedidoItemPedidoModel(PedidoItemPedidoDto pedidoItemPedidoDto) {
        return PedidoItemPedido.builder()
                .id(pedidoItemPedidoDto.getId()) // Si es nuevo, este valor será null
                .itemPedido(mapToItemPedidoModel(pedidoItemPedidoDto.getItemPedidoDto()))
                .build();
    }

    private ItemPedido mapToItemPedidoModel(ItemPedidoDto itemPedidoDto) {
        return ItemPedido.builder()
                .cantidad(itemPedidoDto.getCantidad())
                .itemMenu(mapToItemMenuModel(itemPedidoDto.getItemMenuDto()))
                .build();
    }

    private ItemMenu mapToItemMenuModel(ItemMenuDto itemMenuDto) {
        // Aquí necesitarás un mecanismo para obtener el `ItemMenu` desde la base de
        // datos o crear uno nuevo

        List<ItemMenu> itemMenus = itemMenuService.buscarItemMenuPorNombreYVendedor(itemMenuDto.getNombre(),
                itemMenuDto.getIdVendedor());

        if (itemMenus != null) {
            return itemMenus.get(0);
        } else {
            return null;
        }
    }

    /**
     * Obtiene los pedidos, filtrados por cliente
     * 
     * @param clienteId El cliente al que se quiere buscar los pedidos
     * @return Lista de los pedidos del cliente del @param
     * @throws ClienteNoEncontradoException Si no encuentra el cliente
     */

    public List<Pedido> filtrarPedidosPorCliente(Integer clienteId) throws ClienteNoEncontradoException {
        return pedidoDao.findByCliente(clienteId);
    }

    /**
     * Obtiene los pedidos, filtrados por estado
     * - Estados: RECIBIDO, ACEPTADO, PREPARADO, ENVIADO, ENTREGADO
     * 
     * @param estado El estado a por filtrar
     * @return Lista de pedidos que permanecen en el estado del @param
     */

    public List<Pedido> filtrarPedidoPorEstado(Estado estado) {
        return pedidoDao.findByEstado(estado);
    }

    /**
     * Modifica los datos de un pedido
     * - Del objeto pedido pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param pedido El objeto pedido con los datos modificados
     * @throws PedidoNoEncontradoException
     */

    public void modificarPedido(Pedido pedido) throws PedidoNoEncontradoException {
        pedidoDao.update(pedido);
    }

    /**
     * Elimina un pedido, segun el id
     * 
     * @param id
     */

    public void eliminarPedido(Integer id) {
        Pedido pedido = pedidoDao.findById(id);
        pedidoDao.delete(pedido);
    }

    /**
     * Obtiene una lista de todos los pedidos del sistema
     * 
     * @return Lista de los pedidos del sistema
     */

    public List<Pedido> getAllPedido() {
        return pedidoDao.findAll();
    }

    /**
     * Obtiene los pedidos, filtrados por id
     * 
     * @param id El id del pedido a buscar
     * @return El pedido correspondiente al id
     * @throws PedidoNoEncontradoException Si no encuentra el pedido
     */

    public Pedido buscarPedidoPorId(Integer id) throws PedidoNoEncontradoException {
        return pedidoDao.findPedidoByIdWithItem(id);
    }

    /**
     * Obtiene los pedidos, filtrados por restaurante
     * 
     * @param idVendedor El id del restaurante a buscar sus pedidos
     * @return Lista de los pedidos del restaurante del @param
     * @throws PedidoNoEncontradoException
     */

    public List<Pedido> buscarPedidoPorVendedor(Integer idVendedor) throws PedidoNoEncontradoException {
        try {
            return pedidoDao.findByIdVendedor(idVendedor);
        } catch (PedidoNoEncontradoException e) {
            throw e;
        }
    }

    private Pedido parsePedido(PedidoDto pedidoDto) {

        Cliente cliente = clienteService.buscarClientePorId(pedidoDto.getId());

        return Pedido.builder()
                .cliente(cliente)
                .estado(Estado.ACEPTADO)
                .build();
    }
}
