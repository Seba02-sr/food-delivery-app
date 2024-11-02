package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.model.Categoria;

public class CategoriaMemory implements CategoriaDao {
    List<Categoria> categorias;

    // Constructor
    public CategoriaMemory() {
        this.categorias = new ArrayList<>();
    }

    /**
     * Crea y persiste una categoria
     * 
     * @param categoria La categoria a persistir
     */
    @Override
    public void crearCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    /**
     * Obitene una categoria basada en su nombre.
     * 
     * @param nombre El nombre que se desea obtener
     * @return La categoria correspondiente al nombre
     * @throws CategoriaNoEncontradaException Retorno si no encuentra la categoria
     */
    @Override
    public Categoria obtenerCategoriaPorNombre(String nombre) throws CategoriaNoEncontradaException {
        return categorias.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new CategoriaNoEncontradaException(
                        "No se ah encontrado una categoria con el nombre: " + nombre));
    }

}
