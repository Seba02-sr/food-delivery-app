package com.mycompany.tp.dsw.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.TipoCategoria;

public class CategoriaMemoryTest {

    private CategoriaDao categoriaMemory;

    @BeforeEach
    public void setUp() {
        categoriaMemory = new CategoriaMemory();
    }

    @Test
    public void testFindByTipoCategoriaComida() {
        // Ejecuta el método con el tipo "COMIDA"
        List<Categoria> resultado = categoriaMemory.findByTipoCategoria("bebida");

        // Verifica que el tamaño del resultado es el esperado
        assertEquals(3, resultado.size(), "Debería haber 3 categorías de tipo COMIDA");

        // Verifica que todas las categorías encontradas son de tipo COMIDA
        resultado.forEach(categoria -> assertEquals(TipoCategoria.BEBIDA, categoria.getTipo()));
    }
}
