package com.mycompany.tp.dsw.dao;

import java.math.BigDecimal;
import java.util.List;

import com.mycompany.tp.dsw.model.Plato;

public class PlatoDao extends ItemMenuDao {

    private List<Plato> platos;

    public PlatoDao() {
        platos = findAllPlato();
    }

    public Plato findPlatoById(Integer id) {
        return platos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Plato> findAllPlato() {
        return items.stream()
                .filter(i -> i instanceof Plato)
                .map(i -> (Plato) i)
                .toList();
    }

    public List<Plato> findByIdVendedor(Integer id) {

        return platos.stream()
                .filter(p -> p.getVendedor().getId().equals(id))
                .toList();
    }

    public void update(Plato plato) {

        Plato existePlato = findPlatoById(plato.getId());
        System.out.println(plato.getId());
        if (existePlato != null) {
            System.out.println("EXISTE EL FUCKING PLATO");
            String nombre = plato.getNombre().trim();
            String descripcion = plato.getDescripcion().trim();
            BigDecimal precio = plato.getPrecio();
            Double calorias = plato.getCalorias();
            Double peso = plato.getPeso();

            if (nombre != null) {
                existePlato.setNombre(nombre);
            }
            if (descripcion != null) {
                existePlato.setDescripcion(descripcion);
            }
            if (precio != null) {
                existePlato.setPrecio(precio);
            }
            if (calorias != null) {
                existePlato.setCalorias(calorias);
            }
            if (peso != null) {
                existePlato.setPeso(peso);
            }
        }
        System.out.println("NOOOOOOOOOOOOOO");

    }

}
