package com.ads4.hexagonal.adapters.webadapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.hexagonal.adapters.converter.PedidoConverter;
import com.ads4.hexagonal.adapters.webadapter.dto.PedidoDto;
import com.ads4.hexagonal.core.ports.PedidoServicePort;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    PedidoServicePort pedidoServicePort;

    @Autowired
    PedidoConverter pedidoConverter;


    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoDto create(@RequestBody PedidoDto pedidoDto) {
        return pedidoConverter.toDto(pedidoServicePort.createPedido(pedidoConverter.toDomain(pedidoDto)));
    }


}
