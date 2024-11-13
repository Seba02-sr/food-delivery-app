package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.model.Plato;

public class PlatoMemory extends ItemMenuMemory {

    private PlatoDao platoDao;

    public PlatoMemory() {
        platoDao = new PlatoDao();
    }

    /**
     * Obtiene una lista de todos los platos disponibles del sistema
     * 
     * @return Lista de platos
     */
    public List<Plato> obtenerTodosLosPlatos() {
        return platoDao.findAllPlato();
    }

    /**
     * Crea un plato y lo persiste
     * - Bebidas y Plato estan en una misma lista, ambos subclases de ItemMenu
     * 
     * @param plato El plato a persistir
     */
    public void registrarPlato(Plato plato) {
        super.registrarItemMenu(plato);
    }

    /**
     * Obtiene todos los platos del restaurante en particular
     * 
     * @param id El id del restaurante a buscar los platos
     * @return Lista de platos del restaurante, cuyo id es el parametro
     */
    public List<Plato> obtenerPlatosPorIdVendedor(Integer id) {
        return platoDao.findByIdVendedor(id);
    }
}
