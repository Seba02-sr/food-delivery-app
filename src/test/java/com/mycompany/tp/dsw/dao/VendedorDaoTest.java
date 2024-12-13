package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mycompany.tp.dsw.model.Vendedor;

public class VendedorDaoTest {

    private VendedorDao vendedorDao = new VendedorDao();

    @Test
    void testFindActiveByNombre() {
        List<Vendedor> vendedor = vendedorDao.findActiveByNombre("a");

    }
}
