package com.mycompany.tp.dsw.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.service.VendedorService;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.service.ServiceManager;
import com.mycompany.tp.dsw.service.ValidarVendedor;

public class VendedorController {

    ServiceManager serviceManager;
    VendedorService vendedorService;

    public VendedorController() {
        serviceManager = ServiceManager.getInstance();
        vendedorService = serviceManager.getVendedorService();
    }

    public void guardarVendedor(VendedorDto vendedorDto) throws NoValidarException {
        ValidarVendedor.esGuardarValido(vendedorDto);

        vendedorService.registrarVendedor(vendedorDto);

    }

    public void modificarVendedor(VendedorDto vendedorDto) throws NoValidarException {
        ValidarVendedor.esModificarValido(vendedorDto);

        vendedorService.modificarVendedor(vendedorDto);

    }

    public void eliminarVendedor(String idText) throws NoValidarException {
        ValidarVendedor.esEliminarValido(idText);

        Integer id = Integer.parseInt(idText);
        vendedorService.eliminarVendedor(id);

    }

    public Vendedor buscarVendedorPorId(String idText) throws NumberFormatException {

        Integer id = Integer.parseInt(idText);
        Vendedor vendedor = vendedorService.buscarVendedorPorId(id);

        return vendedor;
        // JOptionPane.showMessageDialog(null, "El ID debe ser un número entero
        // válido.", "Error",
        // JOptionPane.ERROR_MESSAGE);

    }

    public List<Vendedor> buscarVendedorPorNombre(String nombre) {

        List<Vendedor> listaVendedores = vendedorService.buscarVendedorPorNombre(nombre);
        return listaVendedores;
    }

    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorService.obtenerTodosLosVendedores();
    }
}
