package com.ads4.hexagonal.adapters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.hexagonal.adapters.converter.UsuarioConverter;
import com.ads4.hexagonal.adapters.dto.UsuarioDto;
import com.ads4.hexagonal.core.ports.UsuarioServicePort;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioServicePort usuarioServicePort;

    @Autowired
    UsuarioConverter usuarioConverter;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto){
        
        return usuarioConverter.toDto(usuarioServicePort.createUsuario(usuarioConverter.toDomain(usuarioDto)));

    }
};
