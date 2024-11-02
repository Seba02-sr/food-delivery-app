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

    /**
     * Crea y persiste un restaurante
     * - Manejo de id unicos con currentId
     * 
     * @param vendedor El objeto 'Vendedor' a persistir
     */
    @Override
    public void crearVendedor(Vendedor vendedor) {
        vendedor.setId(currentId++);
        vendedores.add(vendedor);
        System.out.println("Se creo un nuevo Vendedor con ID: " + vendedor.getId());
    }

    /**
     * Obtiene un restaurante, filtrado por su nombre
     * - Los nombres son unicos, ya que son restaurantes
     * 
     * @param nombre El nombre del restaurante a buscar
     * @return El restaurante buscado
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    @Override
    public Vendedor buscarVendedorPorNombre(String nombre) throws VendedorNoEncontradoException {
        Vendedor vendedor = vendedores.stream()
                .filter(v -> v.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new VendedorNoEncontradoException(
                        "No se encontraron vendedores con el nombre: " + nombre));
        return vendedor;
    }

    /**
     * Modifica los datos de un restaurante especifico
     * - Del objeto vendedor pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param vendedorModificado El restaurante con los datos a modificar
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    @Override
    public void modificarVendedor(Vendedor vendedorModificado) throws VendedorNoEncontradoException {
        Vendedor existeVendedor = buscarVendedorPorId(vendedorModificado.getId());

        String nombreModificado = vendedorModificado.getNombre().trim();
        List<ItemMenu> itemsMenuModificado = vendedorModificado.getItemsMenu();

        if (nombreModificado != null)
            existeVendedor.setNombre(nombreModificado);
        if (itemsMenuModificado != null)
            existeVendedor.setItemsMenu(itemsMenuModificado);
        System.out.println("Vendedor con ID: " + vendedorModificado.getId() + " modificado correctamente.");

    }

    /**
     * Obtiene un restaurante, filtrando por su id
     * 
     * @param id El id del restaurante a buscar
     * @return El restaurante con id del @param
     */
    @Override
    public Vendedor buscarVendedorPorId(Integer id) throws VendedorNoEncontradoException {
        return vendedores.stream()
                .filter(v -> Objects.equals(v.getId(), id))
                .findFirst()
                .orElseThrow(
                        () -> new VendedorNoEncontradoException("No se ah encontrado un vendedor con el ID: " + id));
    }

    /**
     * Elimina un restaurante del sistema
     * 
     * @param id El id del restaurante a por eliminar
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    @Override
    public void eliminarVendedor(Integer id) throws VendedorNoEncontradoException {
        // RemoveIf devuelve boolean, true si pudo eliminarlo, false si no
        boolean vendedorEliminado = vendedores.removeIf(v -> v.getId().equals(id));

        if (!vendedorEliminado) {
            throw new VendedorNoEncontradoException("No se encontro el vendedor con el ID:" + id);
        } else {
            System.out.println("Vendedor con ID:" + id + " eliminado correctamente.");
        }
    }

    /**
     * Obtiene una lista de todos los restaurantes del sistema
     * 
     * @return Lista de todos los restaurantes
     */
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
