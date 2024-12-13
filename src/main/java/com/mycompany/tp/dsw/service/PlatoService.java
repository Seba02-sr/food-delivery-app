package com.mycompany.tp.dsw.service;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.dto.PlatoDto;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Plato;

public class PlatoService extends ItemMenuService {

    private PlatoDao platoDao;

    public PlatoService() {
        platoDao = new PlatoDao();
    }

    /**
     * Obtiene una lista de todos los platos disponibles del sistema
     * 
     * @return Lista de platos
     */
    public List<Plato> obtenerTodosLosPlatos() {
        List<ItemMenu> items = platoDao.findAllActive();

        // Parsear los items a bebidas

        List<Plato> platos = new ArrayList<>();
        for (ItemMenu item : items) {
            if (item instanceof Plato) {
                platos.add((Plato) item);
            }
        }

        return platos;
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
        List<Plato> platos = platoDao.findActiveByIdVendedor(id);
        return platos;
    }

    public List<Plato> buscarPlatoPorNombre(String nombre) {
        List<ItemMenu> items = buscarItemMenuPorNombre(nombre);

        List<Plato> platos = new ArrayList<>();
        for (ItemMenu itemMenu : items) {
            if (itemMenu instanceof Plato) {
                platos.add((Plato) itemMenu);
            }
        }

        return platos;
    }

    public ItemMenu buscarPlatoPorId(Integer id) {
        ItemMenu item = buscarPorId(id);
        if (item instanceof Plato) {
            return item;
        } else {
            return null;
        }

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
        return palabra == null || palabra.isBlank();
    }
}
