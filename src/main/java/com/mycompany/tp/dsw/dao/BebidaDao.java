package com.mycompany.tp.dsw.dao;

import java.math.BigDecimal;
import java.util.List;

import com.mycompany.tp.dsw.model.Bebida;

public class BebidaDao extends ItemMenuDao {

    public List<Bebida> getBebidas() {
        List<Bebida> bebidas = items.stream()
                .filter(i -> i instanceof Bebida)
                .map(i -> (Bebida) i)
                .toList();
        return bebidas;
    }

    public Bebida findBebidaById(Integer id) {
        Bebida bebida = getBebidas().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
        return bebida;
    }

    public List<Bebida> findByIdVendedor(Integer id) {
        return getBebidas().stream()
                .filter(b -> b.getVendedor().getId().equals(id))
                .toList();
    }

    public void update(Bebida bebida) {
        Bebida existeBebida = findBebidaById(bebida.getId());
        if (existeBebida != null) {
            String nombre = bebida.getNombre().trim();
            String descripcion = bebida.getDescripcion().trim();
            BigDecimal precio = bebida.getPrecio();
            Double graduacionAlcoholica = bebida.getGraduacionAlcoholica();
            Double tamano = bebida.getTamano();
            Double volumen = bebida.getVolumen();

            if (nombre != null) {
                existeBebida.setNombre(nombre);
            }
            if (descripcion != null) {
                existeBebida.setDescripcion(descripcion);
            }
            if (precio != null) {
                existeBebida.setPrecio(precio);
            }
            if (graduacionAlcoholica != null) {
                existeBebida.setGraduacionAlcoholica(graduacionAlcoholica);
            }
            if (tamano != null) {
                existeBebida.setTamano(tamano);
            }
            if (volumen != null) {
                existeBebida.setVolumen(volumen);
            }
        }

    }

}
