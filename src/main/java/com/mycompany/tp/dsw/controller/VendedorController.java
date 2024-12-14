package com.mycompany.tp.dsw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.mycompany.tp.dsw.dto.VendedorDto;
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

    public void guardarVendedor(VendedorDto vendedorDto) {
        Map<String, String> errores = ValidarVendedor.esGuardarValido(vendedorDto);

        if (errores.isEmpty()) {
            vendedorService.registrarVendedor(vendedorDto);
            JOptionPane.showMessageDialog(null, "Vendedor creado exitosamente");
        } else {
            errores.forEach((campo, mensaje) -> JOptionPane.showMessageDialog(null, mensaje, "Error en " + campo,
                    JOptionPane.ERROR_MESSAGE));
        }
    }

    public Map<String, String> modificarVendedor(VendedorDto vendedorDto) {
        Map<String, String> errores = ValidarVendedor.esModificarValido(vendedorDto);

        if (errores.isEmpty()) {
            vendedorService.modificarVendedor(vendedorDto);
        }
        return errores;
    }

    public Map<String, String> eliminarVendedor(String idText) {
        Map<String, String> errores = ValidarVendedor.esEliminarValido(idText);
        if (errores.isEmpty()) {
            Integer id = Integer.parseInt(idText);
            vendedorService.eliminarVendedor(id);
        }
        return errores;
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
