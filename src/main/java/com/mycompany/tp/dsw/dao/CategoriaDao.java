package com.mycompany.tp.dsw.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.TipoCategoria;

public class CategoriaDao {
        private static List<Categoria> categorias;

        static {
                categorias = new ArrayList<>();
                datosIniciales();
        }

        public CategoriaDao() {

        }

        public static void datosIniciales() {
                System.out.println("categoria Dao");
                categorias.add(new Categoria(
                                1,
                                "Comida Vegana",
                                "Esta comida es vegana",
                                TipoCategoria.COMIDA));
                categorias.add(new Categoria(
                                2,
                                "Comida Vegetariana",
                                "Esta comida es vegetariana, no apta veganos",
                                TipoCategoria.COMIDA));
                categorias.add(new Categoria(
                                3,
                                "Comida Clasica",
                                "Esta comida no es apta para vegetarianos, ni apta para veganos",
                                TipoCategoria.COMIDA));
                categorias.add(new Categoria(
                                4,
                                "Bebida Sin Alcohol",
                                "Esta bebida es sin alcohol",
                                TipoCategoria.BEBIDA));
                categorias.add(new Categoria(
                                5,
                                "Bebida Con Alcohol",
                                "Esta bebida es con alcohol, prohibido consumo en menores",
                                TipoCategoria.BEBIDA));
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
