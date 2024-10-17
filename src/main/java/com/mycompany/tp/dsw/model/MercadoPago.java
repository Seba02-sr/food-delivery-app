package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;

public class MercadoPago implements Pago {

    private String alias;

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

}
