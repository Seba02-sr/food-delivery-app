package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.model.Plato;

public class PlatoMemory extends ItemMenuMemory implements PlatoDao {
    @Override
    public List<Plato> obtenerTodosLosPlatos() {
        return items.stream()
            .filter(i -> i instanceof Plato)
            .map(i -> (Plato) i)
            .toList();
    }

    @Override
    public void crearPlato(Plato plato) {
        super.crearItemMenu(plato);
    }
}
