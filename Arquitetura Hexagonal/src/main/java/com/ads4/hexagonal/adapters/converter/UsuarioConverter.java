package com.ads4.hexagonal.adapters.converter;

import org.springframework.stereotype.Component;

import java.util.List;

import com.ads4.hexagonal.adapters.databaseadapter.entities.UsuarioEntity;
import com.ads4.hexagonal.adapters.webadapter.dto.UsuarioDto;
import com.ads4.hexagonal.core.domain.Usuario;

@Component
public class UsuarioConverter {

    public Usuario toDomain(UsuarioDto dto) {
        return new Usuario(dto.getId(), dto.getNome(), dto.getEmail(), dto.getSenha());
    }

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }

    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(entity.getId(), entity.getNome(), entity.getEmail(), entity.getSenha());
    }

    public List<Usuario> toDomainList(List<UsuarioEntity> all){
        return all.stream().map(this::toDomain).toList();
    }

    public List<UsuarioDto> ToDtoList(List<Usuario> all){
        return all.stream().map(this::toDto).toList();
    }
}
