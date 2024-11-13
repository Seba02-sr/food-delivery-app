package com.mycompany.tp.dsw.memory;

import java.time.LocalDate;
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
    private List<Vendedor> vendedores;

    private int currentId = 0;

    public VendedorMemory() {
        vendedores = new ArrayList<>();
        valoresInciales();
    }

    /**
     * Metodo para valores iniciales en la base de datos en memoria
     * - Comentar si no se usa
     */
    public void valoresInciales() {
        VendedorDto vendedorDto1 = new VendedorDto("La Tienda de Ana", "Av. San Martín 1234", null, null);
        vendedorDto1.setCoordenada(new Coordenada(-34.6037, -58.3816));
        vendedorDto1.setId(101);

        VendedorDto vendedorDto2 = new VendedorDto("El Rincón Gourmet", "Calle Falsa 123", null, null);
        vendedorDto2.setCoordenada(new Coordenada(40.7128, -74.0060));
        vendedorDto2.setId(102);

        VendedorDto vendedorDto3 = new VendedorDto("Mercado Central", "Plaza Mayor, Madrid", null, null);
        vendedorDto3.setCoordenada(new Coordenada(40.4168, -3.7038));
        vendedorDto3.setId(103);

        VendedorDto vendedorDto4 = new VendedorDto("Sabores del Mundo", "Av. Córdoba 5555", null, null);
        vendedorDto4.setCoordenada(new Coordenada(-34.5885, -58.4333));
        vendedorDto4.setId(104);

        VendedorDto vendedorDto5 = new VendedorDto("Bazar de Antonia", "Las Heras 980", null, null);
        vendedorDto5.setCoordenada(new Coordenada(-33.4691, -70.641));
        vendedorDto5.setId(105);

        vendedores.add(new Vendedor(vendedorDto1));
        vendedores.add(new Vendedor(vendedorDto2));
        vendedores.add(new Vendedor(vendedorDto3));
        vendedores.add(new Vendedor(vendedorDto4));
        vendedores.add(new Vendedor(vendedorDto5));

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
                .filter(v -> v.getNombre().toLowerCase().contains(nombre.toLowerCase()))
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
            vendedorEliminado.setFechaEliminacion(LocalDate.now());
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
