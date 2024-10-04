package com.ads4.hexagonal.core.ports.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ads4.hexagonal.core.domain.Usuario;
import com.ads4.hexagonal.core.ports.UsuarioRepositoryPort;
import com.ads4.hexagonal.core.ports.UsuarioServicePort;

public class UsuarioService implements UsuarioServicePort {


    @Autowired
    private UsuarioRepositoryPort usuarioRepositoryPort;


    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepositoryPort.create(usuario);
    }


    @Override
    public List<Usuario> listar() {
        return usuarioRepositoryPort.listar();
    }

}
