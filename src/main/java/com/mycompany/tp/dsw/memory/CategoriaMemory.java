package com.mycompany.tp.dsw.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.TipoCategoria;

public class CategoriaMemory implements CategoriaDao {
        List<Categoria> categorias;

        // Constructor
        public CategoriaMemory() {
                this.categorias = new ArrayList<>();
                datosIniciales();
        }

        void datosIniciales() {
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

        /**
         * Obtiene una categoria basada en su nombre.
         * - No hay posibilidad de error por no encontrar categoria
         * - Tenido en cuenta en la interfaz
         * 
         * @param nombre El nombre que se desea obtener
         * @return La categoria correspondiente al nombre
         */
        @Override
        public Categoria obtenerCategoriaPorNombre(String nombre) {
                return categorias.stream()
                                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                                .findFirst()
                                .orElse(null);
        }

        @Override
        public List<Categoria> getAllCategoria() {
                return categorias;
        }

}
