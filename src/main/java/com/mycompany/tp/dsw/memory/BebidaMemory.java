package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.model.Bebida;

public class BebidaMemory extends ItemMenuMemory implements BebidaDao {

    @Override
    public List<Bebida> obtenerTodasLasBebidas() {
        return items.stream()
            .filter(i -> i instanceof Bebida)
            .map(i -> (Bebida) i)
            .toList();
    }

    @Override
    public void crearBebida(Bebida bebida) {
        super.crearItemMenu(bebida);
    }

}
