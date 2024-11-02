package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia implements Pago {

    private String cbu;
    private String cuit;
    private LocalDate fecha;
    private BigDecimal monto;

    public Transferencia(String cbu, String cuit) {
        this.cbu = cbu;
        this.cuit = cuit;
    }

    public String getCbu() {
        return cbu;
    }

    public String getCuit() {
        return cuit;
    }

    /**
     * Calcula el monto total a pagar aplicando un recargo del 2%.
     * 
     * @param monto El monto base sobre el cual se aplicará el recargo.
     * @return El monto total a pagar con el recargo incluido.
     */
    @Override
    public BigDecimal pagar(BigDecimal monto) {
        return monto.multiply(new BigDecimal(1.02));
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

}
