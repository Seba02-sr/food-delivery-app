package com.mycompany.tp.dsw.service;

import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.memory.CategoriaMemory;
import com.mycompany.tp.dsw.memory.ClienteMemory;
import com.mycompany.tp.dsw.memory.ItemMenuMemory;
import com.mycompany.tp.dsw.memory.ItemPedidoMemory;
import com.mycompany.tp.dsw.memory.PedidoMemory;
import com.mycompany.tp.dsw.memory.PlatoMemory;
import com.mycompany.tp.dsw.memory.VendedorMemory;

/**
 * Implementacion de syngleton para todos los memory
 * 
 */
public class MemoryManager {

    private static MemoryManager instance;

    private BebidaMemory bebidaMemory;
    private CategoriaMemory categoriaMemory;
    private ClienteMemory clienteMemory;
    private ItemMenuMemory itemMenuMemory;
    private ItemPedidoMemory itemPedidoMemory;
    private PedidoMemory pedidoMemory;
    private PlatoMemory platoMemory;
    private VendedorMemory vendedorMemory;

    private MemoryManager() {
    }

    public static MemoryManager getInstance() {
        if (instance == null) {
            instance = new MemoryManager();
        }
        return instance;
    }

    // Lazy initialization para cada clase Memory
    public BebidaMemory getBebidaMemory() {
        if (bebidaMemory == null) {
            bebidaMemory = new BebidaMemory();
        }
        return bebidaMemory;
    }

    public CategoriaMemory getCategoriaMemory() {
        if (categoriaMemory == null) {
            categoriaMemory = new CategoriaMemory();
        }
        return categoriaMemory;
    }

    public ClienteMemory getClienteMemory() {
        if (clienteMemory == null) {
            clienteMemory = new ClienteMemory();
        }
        return clienteMemory;
    }

    public ItemMenuMemory getItemMenuMemory() {
        if (itemMenuMemory == null) {
            itemMenuMemory = new ItemMenuMemory();
        }
        return itemMenuMemory;
    }

    public ItemPedidoMemory getItemPedidoMemory() {
        if (itemPedidoMemory == null) {
            itemPedidoMemory = new ItemPedidoMemory();
        }
        return itemPedidoMemory;
    }

    public PedidoMemory getPedidoMemory() {
        if (pedidoMemory == null) {
            pedidoMemory = new PedidoMemory();
        }
        return pedidoMemory;
    }

    public PlatoMemory getPlatoMemory() {
        if (platoMemory == null) {
            platoMemory = new PlatoMemory();
        }
        return platoMemory;
    }

    public VendedorMemory getVendedorMemory() {
        if (vendedorMemory == null) {
            vendedorMemory = new VendedorMemory();
        }
        return vendedorMemory;
    }
}
