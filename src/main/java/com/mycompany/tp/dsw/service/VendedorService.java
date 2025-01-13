package com.mycompany.tp.dsw.service;

import java.util.List;

import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Coordenada;
import com.mycompany.tp.dsw.model.Vendedor;

public class VendedorService {

    private VendedorDao vendedorDao;

    public VendedorService() {
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
        vendedorDao.save(vendedor);
    }

    /**
     * Obtiene un restaurante ACTIVO, filtrado por su nombre
     * - Los nombres son unicos, ya que son restaurantes
     * 
     * @param nombre El nombre del restaurante a buscar
     * @return Los restaurante que contengan en su nombre el parametro
     * @throws VendedorNoEncontradoException
     */
    public List<Vendedor> buscarVendedorPorNombre(String nombre) {
        return vendedorDao.findActiveByNombre(nombre);
    }

    public Vendedor buscarPorIdConListaItem(Integer id) {
        return vendedorDao.findActiveByIdWithItemsMenu(id);
    }

    /**
     * Modifica los datos de un restaurante especifico
     * - Del objeto vendedor pasado como parametro
     * - Solo los datos a modificar permanecen no nulos
     * 
     * @param vendedorModificado El restaurante con los datos a modificar
     */
    public void modificarVendedor(VendedorDto vendedorDto) {

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
        return vendedorDao.findByIdAndActive(id);
    }

    /**
     * Elimina un restaurante del sistema
     * - Eliminacion logica, es decir se marca como inactivo solamente
     * 
     * @param id El id del restaurante a por eliminar
     * @throws VendedorNoEncontradoException Si no encuentra el restaurante
     */
    public void eliminarVendedor(Integer id) {
        Vendedor vendedor = buscarVendedorPorId(id);
        vendedorDao.deleteLogico(vendedor);
    }

    /**
     * Obtiene una lista de todos los restaurantes ACTIVOS del sistema
     * 
     * @return Lista de todos los restaurantes
     */
    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorDao.findAllActive();
    }

    /**
     * Realiza la creacion del objeto 'Vendedor' a partir de su DTO
     * 
     * @param vendedorDto El DTO que se quiere crear Vendedor
     * @return El objeto 'Vendedor'
     */
    public static Vendedor parseVendedor(VendedorDto vendedorDto) {

        Coordenada coordenada = Coordenada.builder()
                .latitud(vendedorDto.getCoordenadaDto().getLatitud())
                .longitud(vendedorDto.getCoordenadaDto().getLongitud())
                .build();

        return Vendedor.builder()
                .id(vendedorDto.getId())
                .nombre(vendedorDto.getNombre())
                .direccion(vendedorDto.getDireccion())
                .coordenada(coordenada)
                .build();
    }

}
