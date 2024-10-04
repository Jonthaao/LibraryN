package com.ads4.hexagonal.adapters.databaseadapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ads4.hexagonal.adapters.converter.PedidoConverter;
import com.ads4.hexagonal.adapters.databaseadapter.entities.PedidoEntity;
import com.ads4.hexagonal.adapters.databaseadapter.repository.PedidoRepository;
import com.ads4.hexagonal.core.domain.Pedido;
import com.ads4.hexagonal.core.ports.PedidoRepositoryPort;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort{

    @Autowired
    PedidoRepository repository;
    @Autowired
    PedidoConverter converter;
    
    
    @Override
    public Pedido create(Pedido pedido) {
        PedidoEntity entity = converter.toEntity(pedido);
        return converter.toDomain(repository.save(entity));
    }
    

}