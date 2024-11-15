package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.ItemMenu;

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
        return bebidaDao.getBebidas();
    }

    public List<Bebida> obtenerBebidaPorIdVendedor(Integer id) {
        return bebidaDao.findByIdVendedor(id);
    }

    public List<Bebida> buscarBebidaPorNombre(String nombre) {
        List<ItemMenu> items = buscarItemMenuPorNombre(nombre);
        List<Bebida> bebidas = new ArrayList<>();
        for (ItemMenu itemMenu : items) {
            if (itemMenu instanceof Bebida) {
                bebidas.add((Bebida) itemMenu);
            }
        }
        return bebidas;
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
