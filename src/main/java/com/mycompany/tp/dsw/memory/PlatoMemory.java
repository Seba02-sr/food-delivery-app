package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.model.Plato;

public class PlatoMemory extends ItemMenuMemory implements PlatoDao {
    @Override
    /**
     * Obtiene una lista de todos los platos disponibles del sistema
     * 
     * @return Lista de platos
     */
    public List<Plato> obtenerTodosLosPlatos() {
        return items.stream()
                .filter(i -> i instanceof Plato)
                .map(i -> (Plato) i)
                .toList();
    }

    /**
     * Crea un plato y lo persiste
     * - Bebidas y Plato estan en una misma lista, ambos subclases de ItemMenu
     * 
     * @param plato El plato a persistir
     */
    @Override
    public void crearPlato(Plato plato) {
        super.crearItemMenu(plato);
    }
}
