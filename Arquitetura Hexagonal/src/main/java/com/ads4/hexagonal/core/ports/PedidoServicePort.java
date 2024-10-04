package com.ads4.hexagonal.core.ports;

import com.ads4.hexagonal.core.domain.Pedido;

public interface PedidoServicePort {

    Pedido createPedido(Pedido pedido);
}
