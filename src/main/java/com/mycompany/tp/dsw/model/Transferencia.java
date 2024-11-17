package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class Transferencia extends Pago {

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

    /**
     * Calcula el monto total a pagar aplicando un recargo del 2%.
     * 
     * @param monto El monto base sobre el cual se aplicará el recargo.
     * @return El monto total a pagar con el recargo incluido.
     */
    public BigDecimal pagar(BigDecimal monto) {
        return monto.multiply(new BigDecimal(1.02));
    }

}
