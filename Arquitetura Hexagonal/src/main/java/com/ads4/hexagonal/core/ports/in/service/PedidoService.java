package com.ads4.hexagonal.core.ports.in.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ads4.hexagonal.core.domain.Pedido;
import com.ads4.hexagonal.core.ports.PedidoRepositoryPort;
import com.ads4.hexagonal.core.ports.PedidoServicePort;

public class PedidoService implements PedidoServicePort{

    @Autowired
    private PedidoRepositoryPort pedidoRepositoryPort;
    
    public Pedido createPedido(Pedido pedido){
        return pedidoRepositoryPort.create(pedido);
    }
    
}
