package com.mycompany.tp.dsw.controller;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.PlatoDto;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.memory.CategoriaMemory;
import com.mycompany.tp.dsw.memory.PlatoMemory;
import com.mycompany.tp.dsw.memory.VendedorMemory;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.service.MemoryManager;

public class ItemMenuController {

    private final MemoryManager memoryManager;
    private final CategoriaMemory categoriaMemory;
    private final PlatoMemory platoMemory;
    private final BebidaMemory bebidaMemory;
    private final VendedorMemory vendedorMemory;

    public ItemMenuController() {
        memoryManager = MemoryManager.getInstance();
        categoriaMemory = memoryManager.getCategoriaMemory();

        platoMemory = memoryManager.getPlatoMemory();
        bebidaMemory = memoryManager.getBebidaMemory();
        vendedorMemory = memoryManager.getVendedorMemory();
    }

    public void guardarItemMenu(ItemMenuDto item, String tipoCategoria) {
        switch (tipoCategoria) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) item;
                platoMemory.registrarPlato(platoDto);
                break;
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) item;
                bebidaMemory.registrarBebida(bebidaDto);
                break;
            default:
                break;
        }
    }

    public void eliminarItemMenu(String idText, String tipoCategoria) {
        Integer id = Integer.parseInt(idText);
        switch (tipoCategoria) {
            case "Plato":
                platoMemory.eliminarItemMenu(id);
                break;
            case "Bebida":
                bebidaMemory.eliminarItemMenu(id);
                break;
        }
    }

    public void modificarItemMenu(ItemMenuDto item, String tipoCategoria) {
        switch (tipoCategoria) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) item;
                platoMemory.modificarPlato(platoDto);
                break;
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) item;
                bebidaMemory.modificarBebida(bebidaDto);
                break;
            default:
                break;
        }
    }

    public Vendedor obtenerVendedor(String idText) {
        Integer id = Integer.parseInt(idText);
        return vendedorMemory.buscarVendedorPorId(id);
    }

    public List<String> getValoresComboBoxCategoria(String tipoCategoria) {
        if (tipoCategoria.equals("Plato")) {
            tipoCategoria = "Comida";
        }
        List<Categoria> categorias = categoriaMemory.buscarPorTipoCategoria(tipoCategoria);
        List<String> categoriasString = new ArrayList<>();
        for (Categoria cat : categorias) {
            String nombre = cat.getNombre();
            categoriasString.add(nombre);
        }
        return categoriasString;
    }

    public List<Plato> obtenerPlatoPorIdVendedor(VendedorDto vendedorDto) {
        Integer id = Integer.parseInt(vendedorDto.getIdText());
        return platoMemory.obtenerPlatoPorIdVendedor(id);
    }

    public List<Bebida> obtenerBebidaPorIdVendedor(VendedorDto vendedorDto) {
        Integer id = Integer.parseInt(vendedorDto.getIdText());
        return bebidaMemory.obtenerBebidaPorIdVendedor(id);
    }
    
    public List<ItemMenu> obtenerItemMenuPorIdVendedor(Integer id){
        List<ItemMenu> retItems = new ArrayList<>();
        retItems.addAll(platoMemory.obtenerPlatoPorIdVendedor(id));
        retItems.addAll(bebidaMemory.obtenerBebidaPorIdVendedor(id));
        
        return retItems;
    }

    public ItemMenu obtenerItemPorId(String idText) {
        Integer id = Integer.parseInt(idText);
        return platoMemory.filtrarPorId(id);
    }

    public List<ItemMenu> buscarItemPorNombre(String nombre) {
        List<ItemMenu> items = platoMemory.buscarItemMenuPorNombre(nombre);
        return items;
    }

}
