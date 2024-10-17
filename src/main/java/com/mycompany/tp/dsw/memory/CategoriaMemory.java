package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.model.Categoria;

public class CategoriaMemory implements CategoriaDao {
    List<Categoria> categorias;

    public CategoriaMemory() {
        this.categorias = new ArrayList<>();
    }

    @Override
    public void crearCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorNombre(String nombre) throws CategoriaNoEncontradaException {
        return categorias.stream()
            .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .orElseThrow(() -> new CategoriaNoEncontradaException("No se ah encontrado una categoria con el nombre: " + nombre));
    }



}
