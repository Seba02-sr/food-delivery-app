package com.mycompany.tp.dsw.dao;

import com.mycompany.tp.dsw.model.Categoria;

public interface CategoriaDao {
    Categoria obtenerCategoriaPorNombre(String nombre);
}
