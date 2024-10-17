package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Vendedor;

public class VendedorMemory implements VendedorDao {
    List<Vendedor> vendedores = new ArrayList<>();
    private int currentId = 0;
    
    @Override
    public void crearVendedor(Vendedor vendedor) {
        vendedor.setId(currentId++); // Seteo un ID unico
        vendedores.add(vendedor);
        System.out.println("Se creo un nuevo Vendedor con ID: " + vendedor.getId());
    }

    @Override
    public Vendedor buscarVendedorPorNombre(String nombre) throws VendedorNoEncontradoException{
        //Buscar el vendedor con el nombre, si no existe lanzar una excepcion
        // El nombre deberia ser unico. Un vendedor es un restaurante
        Vendedor vendedor = vendedores.stream()
            .filter(v -> v.getNombre().toLowerCase().equals(nombre.toLowerCase()))
            .findFirst()
            .orElseThrow(() -> new VendedorNoEncontradoException ("No se encontraron vendedores con el nombre: " + nombre));
            
        return vendedor;
    }

    @Override
    public void modificarVendedor(Vendedor vendedorModificado) throws VendedorNoEncontradoException {
        //Buscar si existe el vendedor, sino lanzar una excepcion
        Vendedor existeVendedor = buscarVendedorPorId(vendedorModificado.getId());
        
        // Los demas atributos no tiene sentido modificarlos
        String nombreModificado = vendedorModificado.getNombre().trim();
        List<ItemMenu> itemsMenuModificado = vendedorModificado.getItemsMenu();

        // Modifcar los valores del vendedor pasado que no sean null
        if (nombreModificado != null) existeVendedor.setNombre(nombreModificado);
        if (itemsMenuModificado != null) existeVendedor.setItemsMenu(itemsMenuModificado);
        System.out.println("Vendedor con ID: " + vendedorModificado.getId() + " modificado correctamente.");
            
    }

    @Override
    public Vendedor buscarVendedorPorId(Integer id) throws VendedorNoEncontradoException{
        return vendedores.stream()
            .filter(v -> Objects.equals(v.getId(), id))
            .findFirst()
            .orElseThrow(() -> new VendedorNoEncontradoException("No se ah encontrado un vendedor con el ID: " + id));
    }

    @Override
    public void eliminarVendedor(Integer id) throws VendedorNoEncontradoException {
        //RemoveIf devuelve boolean, true si pudo eliminarlo, false si no 
        boolean vendedorEliminado = vendedores.removeIf(v -> v.getId().equals(id));

        if (!vendedorEliminado){
             throw new VendedorNoEncontradoException("No se encontro el vendedor con el ID:" + id);
        } else {
            System.out.println("Vendedor con ID:" + id + " eliminado correctamente.");
        }
    }

    @Override
    public List<Vendedor> getAllVendedor() {
        return new ArrayList<>(vendedores);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();


        for (Vendedor vendedor : vendedores) {
            ret.append(vendedor.toString()).append("\n");
        }

        return ret.toString();
    }



}
