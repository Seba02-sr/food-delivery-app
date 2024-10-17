package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;

public class Transferencia implements Pago {

    private String cbu;
    private String cuit;

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

    @Override
    public BigDecimal pagar(BigDecimal monto) {
        return monto.multiply(new BigDecimal(1.02));
    }

}
