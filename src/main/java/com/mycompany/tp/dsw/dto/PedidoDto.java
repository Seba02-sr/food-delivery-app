package com.mycompany.tp.dsw.dto;

import com.mycompany.tp.dsw.model.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDto {

    private Integer clienteId;
    private Integer id;
    // private List<Integer> pedidoItemPedidosIds;
    private Estado estado;
    private PagoDto formaPagoDto;

}
