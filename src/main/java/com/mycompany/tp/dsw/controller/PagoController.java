package com.mycompany.tp.dsw.controller;

import com.mycompany.tp.dsw.dto.MercadoPagoDto;
import com.mycompany.tp.dsw.dto.TransferenciaDto;

public class PagoController {

    public PagoController() {

    }

    public MercadoPagoDto crearMercadoPagoDto(String alias) {
        return MercadoPagoDto.builder()
                .alias(alias)
                .build();
    }

    public TransferenciaDto crearTrasnferenciaDto(String cbu, String cuit) {
        return TransferenciaDto.builder()
                .cbu(cbu)
                .cuit(cuit)
                .build();
    }

}
