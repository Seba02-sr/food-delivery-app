package com.mycompany.tp.dsw.memory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Coordenada;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.service.ValidarVendedor;

public class VendedorMemory implements VendedorDao {
    List<Vendedor> vendedores = new ArrayList<>();

    private int currentId = 0;

    public VendedorMemory() {
        VendedorDto vendedorDto = new VendedorDto("Hola", "Iturraspe 2447", null, null);
        vendedorDto.setCoordenada(new Coordenada(20.0, 20.0));
        vendedorDto.setId(1);
        vendedores.add(new Vendedor(vendedorDto));
    }

    /**
     * Crea y persiste un restaurante
     * - Manejo de id unicos con currentId
     * - El parametro es del tipo VendedorDto, no Vendedor
     * 
     * @param vendedorDto El objeto 'Vendedor' a persistir
     */
    @Override
    public void crearVendedor(VendedorDto vendedorDto) {
        Vendedor vendedor = new Vendedor(vendedorDto);
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
     */
    @Override
    public List<Vendedor> buscarVendedorPorNombre(String nombre) {
        List<Vendedor> vendedor = vendedores.stream()
                .filter(v -> v.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                .toList();
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
    public void modificarVendedor(VendedorDto vendedorModificado) throws VendedorNoEncontradoException {
        Integer id = Integer.parseInt(vendedorModificado.getIdText());
        Vendedor existeVendedor = buscarVendedorPorId(id);
        if (existeVendedor == null) {
            throw new VendedorNoEncontradoException("No se ha encontrado un vendedor con el ID:" + id);
        }

        String nombreModificado = vendedorModificado.getNombre().trim();
        String direccionModificada = vendedorModificado.getDireccion().trim();
        Double latitud = null;
        Double longitud = null;

        if (!ValidarVendedor.esNullOrEmpty(direccionModificada)) {
            // Si la direccion no se modifico, no se modifica la Coordenada Y visceversa
            // Precondicion al metodo:
            // - Coordenada (latitud y longitud) no nulo
            // - Y Direccion no nulo
            latitud = Double.parseDouble(vendedorModificado.getLatitud().trim());
            longitud = Double.parseDouble(vendedorModificado.getLongitud().trim());
            existeVendedor.setDireccion(direccionModificada);

            Coordenada coordenadaModificada = new Coordenada(latitud, longitud);
            existeVendedor.setCoordenada(coordenadaModificada);
        }

        if (nombreModificado != null)
            existeVendedor.setNombre(nombreModificado);
        System.out.println("Vendedor con ID: " + vendedorModificado.getId() + " modificado correctamente.");
        System.out.println(existeVendedor);

    }

    /**
     * Obtiene un restaurante, filtrando por su id
     * - El restaurante debe estar activo ( No borrado logicamente )
     * 
     * @param id El id del restaurante a buscar
     * @return El restaurante con id del @param
     */
    @Override
    public Vendedor buscarVendedorPorId(Integer id) {
        return vendedores.stream()
                .filter(v -> Objects.equals(v.getId(), id) && v.getActivo().equals(true))
                .findFirst()
                .orElse(null); 
    }

    /**
     * Elimina un restaurante del sistema
     * - Eliminacion logica, es decir se marca como inactivo solamente
     * 
     * @param id El id del restaurante a por eliminar
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    @Override
    public void eliminarVendedor(Integer id) throws VendedorNoEncontradoException {
        Vendedor vendedorEliminado = buscarVendedorPorId(id);
        if (vendedorEliminado != null) {
            vendedorEliminado.setActivo(false);
            vendedorEliminado.setFechaEliminacion(LocalDateTime.now());
            System.out.println("Vendedor con ID:" + id + " eliminado correctamente.");
            System.out.println(vendedorEliminado);
        } else {
            throw new VendedorNoEncontradoException("No se ha encontrado un vendedor con el ID: " + id);
        }

    }

    /**
     * Obtiene una lista de todos los restaurantes del sistema
     * 
     * @return Lista de todos los restaurantes
     */
    @Override
    public List<Vendedor> getAllVendedor() {
        if (!vendedores.isEmpty()) {
            return vendedores.stream()
                    .filter(v -> v.getActivo().equals(true))
                    .toList();
        }
        return null;
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
