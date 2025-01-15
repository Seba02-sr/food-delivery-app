package com.mycompany.tp.dsw.dao;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.service.PlatoService;

public class PlatoDaoTest {

    private PlatoService platoService = new PlatoService();
    private static final Logger logger = Logger.getLogger(PlatoDaoTest.class.getName());

    @Test
    void testFindActiveByIdVendedor() {
        Integer vendedorId = 1;

        List<Plato> platos = platoService.obtenerPlatoPorIdVendedor(vendedorId);

        logger.info("Platos encontrados: " + platos);

    }
}
