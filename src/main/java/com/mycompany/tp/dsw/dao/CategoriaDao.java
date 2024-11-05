package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.model.Categoria;

public interface CategoriaDao {
    Categoria obtenerCategoriaPorNombre(String nombre);

    List<Categoria> getAllCategoria();
}
