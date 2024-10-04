package com.ads4.hexagonal.core.ports.in.service;

import com.ads4.hexagonal.core.domain.Pedido;
import com.ads4.hexagonal.core.ports.SalvarPedidoPort;
import com.ads4.hexagonal.core.ports.in.service.usecase.SalvarPedidoUseCase;

public class PedidoUseCaseService implements SalvarPedidoUseCase { //implementação da regra de negócio

    private SalvarPedidoPort salvarPedidoPort;

    @Override
    public Pedido salvar(Pedido pedido) {
        salvarPedidoPort.salvar(pedido);
        return pedido;
    };

}
