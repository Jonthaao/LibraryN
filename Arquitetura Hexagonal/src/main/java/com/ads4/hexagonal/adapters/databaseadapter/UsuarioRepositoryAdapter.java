package com.ads4.hexagonal.adapters.databaseadapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ads4.hexagonal.adapters.converter.UsuarioConverter;
import com.ads4.hexagonal.adapters.databaseadapter.entities.UsuarioEntity;
import com.ads4.hexagonal.adapters.databaseadapter.repository.UsuarioRepository;
import com.ads4.hexagonal.core.domain.Usuario;
import com.ads4.hexagonal.core.ports.UsuarioRepositoryPort;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioConverter converter;

    @Override
    public Usuario create(Usuario usuario) {
        UsuarioEntity entity = converter.toEntity(usuario);
        return converter.toDomain(repository.save(entity));

    }

    @Override
    public List<Usuario> listar() {

        return converter.toDomainList(repository.findAll());
    }
}
