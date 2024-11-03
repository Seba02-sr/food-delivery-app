package com.mycompany.tp.dsw.dao;

import java.util.List;

import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Vendedor;

public interface VendedorDao {
    void crearVendedor(VendedorDto vendedor);

    Vendedor buscarVendedorPorNombre(String nombre) throws VendedorNoEncontradoException;

    void modificarVendedor(VendedorDto vendedor) throws VendedorNoEncontradoException;

    void eliminarVendedor(Integer id) throws VendedorNoEncontradoException;

    List<Vendedor> getAllVendedor();

    Vendedor buscarVendedorPorId(Integer id) throws VendedorNoEncontradoException;
}
