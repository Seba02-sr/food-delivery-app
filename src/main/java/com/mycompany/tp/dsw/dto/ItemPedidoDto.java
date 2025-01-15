package com.mycompany.tp.dsw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ItemPedidoDto {

    private Integer id;
    private Integer cantidad;
    private ItemMenuDto itemMenuDto;

}
