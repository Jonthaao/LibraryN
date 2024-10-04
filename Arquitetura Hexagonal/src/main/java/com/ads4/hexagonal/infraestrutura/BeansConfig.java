package com.ads4.hexagonal.infraestrutura;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ads4.hexagonal.core.ports.PedidoServicePort;
import com.ads4.hexagonal.core.ports.UsuarioServicePort;
import com.ads4.hexagonal.core.ports.in.service.PedidoService;
import com.ads4.hexagonal.core.ports.in.service.UsuarioService;

@Configuration
public class BeansConfig {

    @Bean
    public UsuarioServicePort usuarioServicePortImpl() {
        return new UsuarioService();
    }

    @Bean
    public PedidoServicePort pedidoServicePortImpl(){
        return new PedidoService();
    }

    
}
