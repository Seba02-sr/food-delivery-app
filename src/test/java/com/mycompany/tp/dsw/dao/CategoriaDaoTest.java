package com.mycompany.tp.dsw.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.model.Categoria;

public class CategoriaDaoTest {

    private CategoriaDao categoriaDAO = new CategoriaDao();

    @Test
    void findByTipoCategoria_CategoriaEncontrada() throws CategoriaNoEncontradaException {
        // Arrange
        String tipo = "Comida";

        // Act
        List<Categoria> resultado = categoriaDAO.findByTipoCategoria(tipo);

        // Assert
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals("COMIDA", resultado.get(0).getTipo().name());
    }

    @Test
    void findByTipoCategoria_CategoriaNoEncontrada() {
        // Arrange
        String tipo = "INVALIDO";

        // Act & Assert
        CategoriaNoEncontradaException exception = assertThrows(CategoriaNoEncontradaException.class, () -> {
            categoriaDAO.findByTipoCategoria(tipo);
        });
        assertEquals("Tipo de categoría no válido: " + tipo, exception.getMessage());
    }
}
