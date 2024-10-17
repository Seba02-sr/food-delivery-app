package com.mycompany.tp.dsw;

import java.math.BigDecimal;

import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Pago;

public class ServicioPago {
    private Pago estrategia;

    public ServicioPago(){}

    public ServicioPago(Pago estrategia) {
        this.estrategia = estrategia;
    }

    public BigDecimal realizarPago(Cliente cliente){
        
        if (this.estrategia != null){
            //estrategia.pagar(monto);
        }
        return new BigDecimal(0);
    }

    
}
