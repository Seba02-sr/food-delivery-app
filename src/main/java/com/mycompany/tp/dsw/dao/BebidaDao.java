package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.model.Bebida;

public interface BebidaDao extends ItemMenuDao {
    //Metodos especificas de bebida
    List<Bebida> obtenerTodasLasBebidas();
    void crearBebida(Bebida bebida);
}
