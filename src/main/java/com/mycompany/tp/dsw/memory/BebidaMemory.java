package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.dto.BebidaDto;
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

    public void registrarBebida(BebidaDto bebidaDto) {
        parseBebidaDto(bebidaDto);
        super.registrarItemMenu(bebidaDto);
    }

    public void modificarBebida(BebidaDto bebidaDto) {
        parseBebidaDto(bebidaDto);
        super.modificarItemMenu(bebidaDto);
    }

    public void parseBebidaDto(BebidaDto bebidaDto) {
        String graduacionAlcoholica = bebidaDto.getGraduacionAlcoholicaText();
        if (!esNullOrBlank(graduacionAlcoholica)) {
            bebidaDto.setGraduacionAlcoholica(Double.parseDouble(graduacionAlcoholica));
        }

        String tamano = bebidaDto.getTamanoText();
        if (!esNullOrBlank(tamano)) {
            bebidaDto.setTamano(Double.parseDouble(tamano));
        }

        String volumen = bebidaDto.getVolumenText();
        if (!esNullOrBlank(volumen)) {
            bebidaDto.setVolumen(Double.parseDouble(volumen));
        }

    }

    private Boolean esNullOrBlank(String palabra) {
        return palabra.trim() == null || palabra.isBlank();
    }

}
