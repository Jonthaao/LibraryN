package com.ads4.hexagonal.adapters.databaseadapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.ads4.hexagonal.adapters.converter.PedidoConverter;
import com.ads4.hexagonal.adapters.databaseadapter.repository.PedidoRepository;
import com.ads4.hexagonal.core.domain.Pedido;
import com.ads4.hexagonal.core.ports.SalvarPedidoPort;


public class PedidoRepositoryPortAdapter  implements SalvarPedidoPort{ //Função, converter os dados da regra de negócio para as entidades do banco! 

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoConverter pedidoConverter;

    @Override
    public void salvar(Pedido pedido) {
        var pedidoEntity = pedidoConverter.toEntity(pedido);//Convertendo o que estou recebendo para a linguagem que o banco de dados conhece.
        
        pedidoRepository.save(pedidoEntity);
    }


    
}
