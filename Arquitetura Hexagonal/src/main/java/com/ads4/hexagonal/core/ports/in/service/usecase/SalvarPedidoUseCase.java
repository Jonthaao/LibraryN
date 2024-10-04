package com.ads4.hexagonal.core.ports.in.service.usecase;

import com.ads4.hexagonal.core.domain.Pedido;

public interface SalvarPedidoUseCase { //entrada dos dados de fora(chega dos adapters) - > PedidoUseCaseService

    Pedido salvar(Pedido pedido);

    
};