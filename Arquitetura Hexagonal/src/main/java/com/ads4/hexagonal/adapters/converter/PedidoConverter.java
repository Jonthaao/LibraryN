package com.ads4.hexagonal.adapters.converter;

import org.springframework.stereotype.Component;

import com.ads4.hexagonal.adapters.databaseadapter.entities.PedidoEntity;
import com.ads4.hexagonal.adapters.webadapter.dto.PedidoDto;
import com.ads4.hexagonal.core.domain.Pedido;


@Component
public class PedidoConverter {

    public Pedido toDomain(PedidoDto dto){
        return new Pedido(dto.getId(), dto.getDataInicio(), dto.getDataDevolucao(), dto.getStatusDevolucao(), dto.getMulta());
    }

    public PedidoDto toDto(Pedido pedido){
        return new PedidoDto(pedido.getId(),pedido.getDataInicio(), pedido.getDataDevolucao(), pedido.getStatusDevolucao(), pedido.getMulta());
    }

    public PedidoEntity toEntity(Pedido entity){
        return new PedidoEntity(entity.getId(), entity.getDataInicio(), entity.getDataDevolucao(), entity.getStatusDevolucao(), entity.getMulta());
    }

    public Pedido toDomain(PedidoEntity entity){
        return new Pedido(entity.getId(), entity.getDataInicio(), entity.getDataDevolucao(), entity.getStatusDevolucao(), entity.getMulta());
    }
    
    
}
