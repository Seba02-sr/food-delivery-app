package com.mycompany.tp.dsw.memory;

import java.util.List;

import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.model.Categoria;

public class CategoriaService {

        CategoriaDao categoriaDao;

        public CategoriaService() {
                categoriaDao = new CategoriaDao();
        }

        /**
         * Obtiene una categoria basada en su nombre.
         * - No hay posibilidad de error por no encontrar categoria
         * - Tenido en cuenta en la interfaz
         * 
         * @param nombre El nombre que se desea obtener
         * @return La categoria correspondiente al nombre
         */
        public Categoria obtenerCategoriaPorNombre(String nombre) {
                return categoriaDao.findByNombre(nombre);
        }

        /**
         * Obtiene todas las categorias persistidas
         * 
         * @return
         */
        public List<Categoria> obtenerTodasLasCategorias() {
                return categoriaDao.findAll();
        }

        public List<Categoria> buscarPorTipoCategoria(String tipo) {
                return categoriaDao.findByTipoCategoria(tipo);
        }

}
