package com.mycompany.tp.dsw.service;

/**
 * Implementacion de syngleton para todos los Service
 * 
 */
public class ServiceManager {

    private static ServiceManager instance;

    private BebidaService bebidaService;
    private CategoriaService categoriaService;
    private ClienteService clienteService;
    private ItemMenuService itemMenuService;
    private ItemPedidoService itemPedidoService;
    private PedidoService pedidoService;
    private PlatoService platoService;
    private VendedorService vendedorService;

    private ServiceManager() {
    }

    public static ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    // Lazy initialization para cada clase Service
    public BebidaService getBebidaService() {
        if (bebidaService == null) {
            bebidaService = new BebidaService();
        }
        return bebidaService;
    }

    public CategoriaService getCategoriaService() {
        if (categoriaService == null) {
            categoriaService = new CategoriaService();
        }
        return categoriaService;
    }

    public ClienteService getClienteService() {
        if (clienteService == null) {
            clienteService = new ClienteService();
        }
        return clienteService;
    }

    public ItemMenuService getItemMenuService() {
        if (itemMenuService == null) {
            itemMenuService = new ItemMenuService();
        }
        return itemMenuService;
    }

    public ItemPedidoService getItemPedidoService() {
        if (itemPedidoService == null) {
            itemPedidoService = new ItemPedidoService();
        }
        return itemPedidoService;
    }

    public PedidoService getPedidoService() {
        if (pedidoService == null) {
            pedidoService = new PedidoService();
        }
        return pedidoService;
    }

    public PlatoService getPlatoService() {
        if (platoService == null) {
            platoService = new PlatoService();
        }
        return platoService;
    }

    public VendedorService getVendedorService() {
        if (vendedorService == null) {
            vendedorService = new VendedorService();
        }
        return vendedorService;
    }
}
