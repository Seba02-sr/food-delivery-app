package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.dto.PlatoDto;
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
        return platoDao.getPlatos();
    }

    /**
     * Crea un plato y lo persiste
     * - Bebidas y Plato estan en una misma lista, ambos subclases de ItemMenu
     * 
     * @param plato El plato a persistir
     */
    public void registrarPlato(PlatoDto platoDto) {
        parsePlatoDto(platoDto);
        super.registrarItemMenu(platoDto);
    }

    /**
     * Obtiene todos los platos del restaurante en particular
     * 
     * @param id El id del restaurante a buscar los platos
     * @return Lista de platos del restaurante, cuyo id es el parametro
     */
    public List<Plato> obtenerPlatoPorIdVendedor(Integer id) {
        List<Plato> platos = platoDao.findByIdVendedor(id);
        System.out.println("Platos en memory: " + platos.toString());
        return platos;
    }

    public void modificarPlato(PlatoDto platoDto) {
        parsePlatoDto(platoDto);
        super.modificarItemMenu(platoDto);
    }

    public void parsePlatoDto(PlatoDto platoDto) {

        String calorias = platoDto.getCaloriasText();
        if (!esNullOrBlank(calorias)) {
            platoDto.setCalorias(Double.parseDouble(calorias));
        }

        String peso = platoDto.getPesoText();
        if (!esNullOrBlank(peso)) {
            platoDto.setPeso(Double.parseDouble(peso));
        }
    }

    private Boolean esNullOrBlank(String palabra) {
        return palabra.trim() == null || palabra.isBlank();
    }
}
