package com.mycompany.tp.dsw.controller;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.PlatoDto;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.service.BebidaService;
import com.mycompany.tp.dsw.service.CategoriaService;
import com.mycompany.tp.dsw.service.PlatoService;
import com.mycompany.tp.dsw.service.VendedorService;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.service.ServiceManager;

public class ItemMenuController {

    private final ServiceManager serviceManager;
    private final CategoriaService categoriaService;
    private final PlatoService platoService;
    private final BebidaService bebidaService;
    private final VendedorService vendedorService;

    public ItemMenuController() {
        serviceManager = ServiceManager.getInstance();
        categoriaService = serviceManager.getCategoriaService();

        platoService = serviceManager.getPlatoService();
        bebidaService = serviceManager.getBebidaService();
        vendedorService = serviceManager.getVendedorService();
    }

    public void guardarItemMenu(ItemMenuDto item, String tipoCategoria) {
        switch (tipoCategoria) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) item;
                platoService.registrarPlato(platoDto);
                break;
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) item;
                bebidaService.registrarBebida(bebidaDto);
                break;
            default:
                break;
        }
    }

    public void eliminarItemMenu(String idText, String tipoCategoria) {
        Integer id = Integer.parseInt(idText);
        switch (tipoCategoria) {
            case "Plato":
                platoService.eliminarItemMenu(id);
                break;
            case "Bebida":
                bebidaService.eliminarItemMenu(id);
                break;
        }
    }

    public void modificarItemMenu(ItemMenuDto item, String tipoCategoria) {
        switch (tipoCategoria) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) item;
                platoService.modificarPlato(platoDto);
                break;
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) item;
                bebidaService.modificarBebida(bebidaDto);
                break;
            default:
                break;
        }
    }

    public Vendedor obtenerVendedor(String idText) {
        Integer id = Integer.parseInt(idText);
        return vendedorService.buscarVendedorPorId(id);
    }

    public List<String> getValoresComboBoxCategoria(String tipoCategoria) throws CategoriaNoEncontradaException {
        if (tipoCategoria.equals("Plato")) {
            tipoCategoria = "Comida";
        }
        List<Categoria> categorias;
        try {
            categorias = categoriaService.buscarPorTipoCategoria(tipoCategoria);
            List<String> categoriasString = new ArrayList<>();
            for (Categoria cat : categorias) {
                String nombre = cat.getNombre();
                categoriasString.add(nombre);
            }
            return categoriasString;
        } catch (CategoriaNoEncontradaException e) {
            throw e;
        }

    }

    public List<Plato> obtenerPlatoPorIdVendedor(VendedorDto vendedorDto) {
        Integer id = Integer.parseInt(vendedorDto.getIdText());
        return platoService.obtenerPlatoPorIdVendedor(id);
    }

    public List<Bebida> obtenerBebidaPorIdVendedor(VendedorDto vendedorDto) {
        Integer id = Integer.parseInt(vendedorDto.getIdText());
        return bebidaService.obtenerBebidaPorIdVendedor(id);
    }

    public List<ItemMenu> obtenerItemMenuPorIdVendedor(Integer id) {
        List<ItemMenu> retItems = new ArrayList<>();
        retItems.addAll(platoService.obtenerPlatoPorIdVendedor(id));
        retItems.addAll(bebidaService.obtenerBebidaPorIdVendedor(id));

        return retItems;
    }

    public ItemMenu obtenerPlatoVendedorPorId(String idPlatoText, VendedorDto vendedorDto) {
        List<Plato> platos = obtenerPlatoPorIdVendedor(vendedorDto);
        Integer idPlato = Integer.parseInt(idPlatoText);
        for (Plato plato : platos) {
            if (plato.getId().equals(idPlato)) {
                return plato;
            }
        }
        return null;
    }

    public ItemMenu obtenerBebidaVendedorPorId(String idText, VendedorDto vendedorDto) {

        Integer idBebida = Integer.parseInt(idText);
        Integer idVendedor = Integer.parseInt(vendedorDto.getIdText());
        return bebidaService.buscarBebidaPorId(idBebida, idVendedor);
    }

    public ItemMenu obtenerItemPorId(String idText) {
        Integer id = Integer.parseInt(idText);
        return platoService.buscarPorId(id);
    }

    public List<? extends ItemMenu> buscarPlatoPorNombreYVendedor(String nombre, String idText) {
        Integer id = Integer.parseInt(idText);
        List<? extends ItemMenu> items = platoService.buscarPlatoPorNombreYVendedor(nombre, id);
        return items;
    }

    public List<? extends ItemMenu> buscarBebidaPorNombreYVendedor(String nombre, String idText) {
        Integer id = Integer.parseInt(idText);
        List<? extends ItemMenu> items = bebidaService.buscarBebidaPorNombreYVendedor(nombre, id);
        return items;
    }

}
