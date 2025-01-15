package com.mycompany.tp.dsw.controller;

import com.mycompany.tp.dsw.dto.MercadoPagoDto;
import com.mycompany.tp.dsw.dto.TransferenciaDto;

public class PagoController {

    public PagoController() {

    }

    /**
     * Crea un objeto MercadoPagoDto con el alias proporcionado.
     *
     * @param alias El alias a asociar con el objeto MercadoPagoDto.
     * @return Un objeto MercadoPagoDto con el alias proporcionado.
     */
    public MercadoPagoDto crearMercadoPagoDto(String alias) {
        return MercadoPagoDto.builder()
                .alias(alias)
                .build();
    }

    /**
     * Crea un objeto TransferenciaDto con el CBU y el CUIT proporcionados.
     *
     * @param cbu  El CBU asociado con el objeto TransferenciaDto.
     * @param cuit El CUIT asociado con el objeto TransferenciaDto.
     * @return Un objeto TransferenciaDto con el CBU y el CUIT proporcionados.
     */
    public TransferenciaDto crearTrasnferenciaDto(String cbu, String cuit) {
        return TransferenciaDto.builder()
                .cbu(cbu)
                .cuit(cuit)
                .build();
    }

}
