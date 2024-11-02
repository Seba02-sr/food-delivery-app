package com.mycompany.tp.dsw.dao;

import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.model.Categoria;

public interface CategoriaDao {

    void crearCategoria(Categoria categoria);

    Categoria obtenerCategoriaPorNombre(String nombre) throws CategoriaNoEncontradaException;
}
