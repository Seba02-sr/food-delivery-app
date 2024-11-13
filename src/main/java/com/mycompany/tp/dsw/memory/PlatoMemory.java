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

    @Override
    public List<Plato> obtenerPlatoPorIdVendedor(Integer id) {
        List<Plato> platos = obtenerTodosLosPlatos();

        return platos.stream()
                .filter(p -> p.getVendedor().getId().equals(id))
                .toList();

    }

    @Override
    public void modificarPlato(Plato platoModificado, Plato plato) {

        Double caloriasModificado = platoModificado.getCalorias();
        Boolean aptoCeliacoModificado = platoModificado.getAptoCeliaco();
        Boolean aptoVegetarianoModificado = platoModificado.getAptoVegetariano();
        Boolean aptoVeganoModificado = platoModificado.getAptoVegano();
        Double pesoModificado = platoModificado.getPeso();

        plato.setCalorias(caloriasModificado);
        plato.setAptoCeliaco(aptoCeliacoModificado);
        plato.setAptoVegano(aptoVeganoModificado);
        plato.setAptoVegetariano(aptoVegetarianoModificado);
        plato.setPeso(pesoModificado);

    }
}
