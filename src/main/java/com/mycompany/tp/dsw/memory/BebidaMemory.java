package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.model.Bebida;

public class BebidaMemory extends ItemMenuMemory implements BebidaDao {

    /**
     * Obtiene una lista de todas las bebidas disponibles del sistema.
     * 
     * @return Lista de bebidas
     */
    @Override
    public List<Bebida> obtenerTodasLasBebidas() {
        return items.stream()
                .filter(i -> i instanceof Bebida)
                .map(i -> (Bebida) i)
                .toList();
    }

    /**
     * Crea una bebida y la persiste
     * - Bebidas y Plato estan en una misma lista, ambos subclases de ItemMenu
     * 
     * @param bebida La bebida a persistir
     */
    @Override
    public void crearBebida(Bebida bebida) {
        super.crearItemMenu(bebida);
    }

    @Override
    public List<Bebida> obtenerBebidaPorIdVendedor(Integer id) {
        List<Bebida> bebida = obtenerTodasLasBebidas();

        return bebida.stream()
                .filter(b -> b.getVendedor().getId().equals(id))
                .toList();

    }

    @Override
    public void modificarBebida(Bebida bebidaModificada, Bebida bebida) {
        Double graduacionAlcoholicaModificado = bebidaModificada.getGraduacionAlcoholica();
        Double tamanoModificado = bebidaModificada.getTamano();
        Double volumenModificado = bebidaModificada.getVolumen();

        bebida.setGraduacionAlcoholica(graduacionAlcoholicaModificado);
        bebida.setTamano(tamanoModificado);
        bebida.setVolumen(volumenModificado);

    }

}
