package com.mycompany.tp.dsw.service;

import com.mycompany.tp.dsw.dao.ItemsPedidoDao;

public class PedidoItemPedidoService {

    private PedidoItemPedidoService pedidoItemPedidoService;

    public PedidoItemPedidoService() {
        pedidoItemPedidoService = new PedidoItemPedidoDao();
    }
}
