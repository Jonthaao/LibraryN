package com.ads4.hexagonal.core.ports;

import java.util.List;

import com.ads4.hexagonal.core.domain.Usuario;

public interface UsuarioRepositoryPort {

    Usuario create(Usuario usuario);

    List<Usuario> listar();

}

// repository = port out;