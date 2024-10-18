package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MercadoPago implements Pago {

    private String alias;
    private LocalDate fecha;
    private BigDecimal monto;

    public MercadoPago(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public BigDecimal pagar(BigDecimal monto) {
        return monto.multiply(new BigDecimal(1.04));
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

}
