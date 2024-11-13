package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.model.Bebida;

public class BebidaMemory extends ItemMenuMemory {

    private BebidaDao bebidaDao;

    public BebidaMemory() {
        bebidaDao = new BebidaDao();
    }

    /**
     * Obtiene una lista de todas las bebidas disponibles del sistema.
     * 
     * @return Lista de bebidas
     */
    public List<Bebida> obtenerTodasLasBebidas() {
        return bebidaDao.findAllBebida();
    }

    public List<Bebida> obtenerBebidaPorIdVendedor(Integer id) {
        return bebidaDao.findByIdVendedor(id);
    }

    public void registrarBebida(Bebida bebida) {
        super.registrarItemMenu(bebida);
    }

}
