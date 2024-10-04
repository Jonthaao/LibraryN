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
import com.ads4.hexagonal.core.domain.Pedido;
import com.ads4.hexagonal.core.ports.in.service.usecase.SalvarPedidoUseCase;

@RestController
@RequestMapping("/pedido")
public class SalvarPedidoController {

    @Autowired
    SalvarPedidoUseCase salvarPedidoUseCase;

    @Autowired
    PedidoConverter pedidoConverter;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)

    public PedidoDto create(@RequestBody PedidoDto pedidoDto) {

        var pedido = pedidoConverter.toDomain(pedidoDto);

        Pedido pedidoSalvo = salvarPedidoUseCase.salvar(pedido);

        return pedidoConverter.toDto(pedidoSalvo);
    }

}
