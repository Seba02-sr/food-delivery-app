package com.mycompany.tp.dsw.memory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Vendedor;

public class ItemMenuMemory implements ItemMenuDao {

    protected static final List<ItemMenu> items = new ArrayList<>();
    private static int currentID = 0;

    @Override
    public void crearItemMenu(ItemMenu itemMenu) {
        //Controlar los id duplicados
        //System.out.println("Se ha creado un ItemMenu ID: " + currentID);
        itemMenu.setId(currentID++);
        items.add(itemMenu);
        
    }

    @Override
    public List<ItemMenu> buscarItemMenuPorNombre(String nombre) {
        return items.stream().
            filter(i -> i.getNombre().equalsIgnoreCase(nombre))
            .toList();
    }

    @Override
    public void modificarItemMenu(ItemMenu itemMenuModificado) {
        Optional<ItemMenu> existeItem = items.stream()
            .filter(i -> i.getId().equals(itemMenuModificado.getId())).findFirst();
        String nombreModificado = itemMenuModificado.getNombre();
        String descripcionModificado = itemMenuModificado.getDescripcion();
        BigDecimal precioModificado = itemMenuModificado.getPrecio();

        existeItem.ifPresent(i ->{
            if (nombreModificado != null) i.setNombre(nombreModificado);
            if (descripcionModificado != null) i.setDescripcion(descripcionModificado);
            if (precioModificado != null) i.setPrecio(precioModificado);
        });
         
    }

    @Override
    public void eliminarItemMenu(Integer id) {
        items.removeIf(i -> i.getId().equals(id));
    }

    @Override
    public List<ItemMenu> obtenerTodosLosItemMenu() {
        return new ArrayList<>(items);
    }

    @Override
    public List<ItemMenu> filtrarPorVendedor(Vendedor vendedor) throws VendedorNoEncontradoException {
        Integer id = vendedor.getId();
        System.out.println("ID bucado: " + id);
        List<ItemMenu> itemsVendedor =  items.stream()
            .filter(i -> i.getVendedor().getId().equals(id))
            .toList();
        if (itemsVendedor.isEmpty()){
            throw new VendedorNoEncontradoException("No se ah encontrado un vendedor con ID: " + vendedor.getId());
        }
        return itemsVendedor;
    }

    @Override
    public String toString() {
        StringBuilder listaItemString = new StringBuilder();

        for (ItemMenu itemMenu : items) {
            listaItemString.append(itemMenu.toString()).append(" \n");
        }

        return listaItemString.toString();
    }

    

    

    




}
