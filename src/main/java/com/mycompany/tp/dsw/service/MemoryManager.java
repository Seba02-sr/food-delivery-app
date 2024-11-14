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

    // Instancias únicas de todas las clases Memory
    private static MemoryManager instance;

    private BebidaMemory bebidaMemory;
    private CategoriaMemory categoriaMemory;
    private ClienteMemory clienteMemory;
    private ItemMenuMemory itemMenuMemory;
    private ItemPedidoMemory itemPedidoMemory;
    private PedidoMemory pedidoMemory;
    private PlatoMemory platoMemory;
    private VendedorMemory vendedorMemory;

    // Constructor privado
    private MemoryManager() {
        bebidaMemory = new BebidaMemory();
        categoriaMemory = new CategoriaMemory();
        clienteMemory = new ClienteMemory();
        itemMenuMemory = new ItemMenuMemory();
        itemPedidoMemory = new ItemPedidoMemory();
        pedidoMemory = new PedidoMemory();
        platoMemory = new PlatoMemory();
        vendedorMemory = new VendedorMemory();
    }

    // Método para obtener la instancia única
    public static MemoryManager getInstance() {
        if (instance == null) {
            instance = new MemoryManager();
        }
        return instance;
    }

    // Métodos getter para acceder a las instancias de cada Memory
    public BebidaMemory getBebidaMemory() {
        return bebidaMemory;
    }

    public CategoriaMemory getCategoriaMemory() {
        return categoriaMemory;
    }

    public ClienteMemory getClienteMemory() {
        return clienteMemory;
    }

    public ItemMenuMemory getItemMenuMemory() {
        return itemMenuMemory;
    }

    public ItemPedidoMemory getItemPedidoMemory() {
        return itemPedidoMemory;
    }

    public PedidoMemory getPedidoMemory() {
        return pedidoMemory;
    }

    public PlatoMemory getPlatoMemory() {
        return platoMemory;
    }

    public VendedorMemory getVendedorMemory() {
        return vendedorMemory;
    }
}
