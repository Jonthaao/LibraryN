package com.ads4.hexagonal.core.ports;

import java.util.List;

import com.ads4.hexagonal.core.domain.Usuario;

public interface UsuarioServicePort {

    Usuario createUsuario(Usuario usuario);

    List<Usuario> listar();
        
    

}

// Service = port in;