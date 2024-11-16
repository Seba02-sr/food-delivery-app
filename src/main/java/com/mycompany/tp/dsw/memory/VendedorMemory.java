package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Coordenada;
import com.mycompany.tp.dsw.model.Vendedor;

public class VendedorMemory {

    private VendedorDao vendedorDao;

    public VendedorMemory() {
        vendedorDao = new VendedorDao();
    }

    /**
     * Crea y persiste un restaurante
     * - Manejo de id unicos con currentId
     * - El parametro es del tipo VendedorDto, no Vendedor
     * 
     * @param vendedorDto El objeto 'Vendedor' a persistir
     */
    public void registrarVendedor(VendedorDto vendedorDto) {
        Vendedor vendedor = parseVendedor(vendedorDto);
        vendedorDao.add(vendedor);
    }

    /**
     * Obtiene un restaurante, filtrado por su nombre
     * - Los nombres son unicos, ya que son restaurantes
     * 
     * @param nombre El nombre del restaurante a buscar
     * @return Los restaurante que contengan en su nombre el parametro
     */
    public List<Vendedor> buscarVendedorPorNombre(String nombre) {
        return vendedorDao.findByNombre(nombre);
    }

    /**
     * Modifica los datos de un restaurante especifico
     * - Del objeto vendedor pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param vendedorModificado El restaurante con los datos a modificar
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    public void modificarVendedor(VendedorDto vendedorDto) throws VendedorNoEncontradoException {

        Vendedor vendedor = parseVendedor(vendedorDto);
        vendedorDao.update(vendedor);
    }

    /**
     * Obtiene un restaurante, filtrando por su id
     * - El restaurante debe estar activo ( No borrado logicamente )
     * 
     * @param id El id del restaurante a buscar
     * @return El restaurante con id del @param, caso no encontrar NULL
     */
    public Vendedor buscarVendedorPorId(Integer id) {
        return vendedorDao.findById(id);
    }

    /**
     * Elimina un restaurante del sistema
     * - Eliminacion logica, es decir se marca como inactivo solamente
     * 
     * @param id El id del restaurante a por eliminar
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    public void eliminarVendedor(Integer id) throws VendedorNoEncontradoException {
        vendedorDao.delete(id);
    }

    /**
     * Obtiene una lista de todos los restaurantes del sistema
     * 
     * @return Lista de todos los restaurantes
     */
    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorDao.findAll();
    }

    /**
     * Realiza la creacion del objeto 'Vendedor' a partir de su DTO
     * 
     * @param vendedorDto El DTO que se quiere crear Vendedor
     * @return El objeto 'Vendedor'
     */
    public static Vendedor parseVendedor(VendedorDto vendedorDto) {
        String id = vendedorDto.getIdText();
        if (!esNullOrBlank(id)) {
            vendedorDto.setId(Integer.parseInt(id));
        }

        String longitudText = vendedorDto.getLongitud();
        Double longitud = null;
        if (!esNullOrBlank(longitudText)) {
            longitud = Double.parseDouble(longitudText);
        }

        String latitudText = vendedorDto.getLatitud();
        Double latitud = null;
        if (!esNullOrBlank(latitudText)) {
            latitud = Double.parseDouble(latitudText);
        }

        if (latitud != null && longitud != null) {
            vendedorDto.setCoordenada(new Coordenada(latitud, longitud));
        }

        return new Vendedor(vendedorDto);
    }

    private static Boolean esNullOrBlank(String palabra) {
        return palabra == null || palabra.isBlank();
    }

}
