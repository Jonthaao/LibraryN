package com.ads4.hexagonal.core.ports;

import com.ads4.hexagonal.core.domain.Usuario;

public interface UsuarioServicePort {

    Usuario createUsuario(Usuario usuario);
};