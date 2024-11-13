package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.model.Plato;

public interface PlatoDao extends ItemMenuDao {
    List<Plato> obtenerTodosLosPlatos();

    void crearPlato(Plato plato);

    List<Plato> obtenerPlatoPorIdVendedor(Integer id);

    void modificarPlato(Plato platoModificado, Plato plato);

}
