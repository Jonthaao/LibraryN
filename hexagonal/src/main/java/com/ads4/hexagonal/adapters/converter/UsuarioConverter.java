package com.ads4.hexagonal.adapters.converter;

import org.springframework.stereotype.Component;

import com.ads4.hexagonal.adapters.dto.UsuarioDto;
import com.ads4.hexagonal.core.domain.Usuario;

@Component
public class UsuarioConverter {

    public Usuario toDomain(UsuarioDto dto){

        return new Usuario(dto.getId(),dto.getNome(), dto.getEmail());
    }

    public UsuarioDto toDto(Usuario usuario){

        return new UsuarioDto(usuario.getId(),usuario.getNome(), usuario.getEmail());
    }
    
}
