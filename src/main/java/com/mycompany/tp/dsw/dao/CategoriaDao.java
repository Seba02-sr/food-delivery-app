package com.mycompany.tp.dsw.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.model.Categoria;

public class CategoriaDao {
        private static List<Categoria> categorias;

        static {
                categorias = new ArrayList<>();
        }

        public CategoriaDao() {

        }

        public Categoria findByNombre(String nombre) {
                return categorias.stream()
                                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                                .findFirst()
                                .orElse(null);
        }

        public List<Categoria> findAll() {
                return categorias;
        }

        public List<Categoria> findByTipoCategoria(String tipo) {
                return categorias.stream()
                                .filter(c -> c.getTipo().name().equalsIgnoreCase(tipo))
                                .toList();
        }
}
