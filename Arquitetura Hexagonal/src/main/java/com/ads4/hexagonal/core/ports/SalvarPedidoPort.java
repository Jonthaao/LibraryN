package com.ads4.hexagonal.core.ports;

import com.ads4.hexagonal.core.domain.Pedido;

public interface SalvarPedidoPort { //porta de saída para fora do core

//Interface -> Contrato, manual ou planta... Vai definir como um classe deve ser, quem implementar a minha interface precisa se preocupar em como implementar o método Salvar.
    void salvar(Pedido pedido);
    
}
