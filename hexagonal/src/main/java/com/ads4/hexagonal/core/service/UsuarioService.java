package com.ads4.hexagonal.core.service;


import com.ads4.hexagonal.core.domain.Usuario;
import com.ads4.hexagonal.core.ports.UsuarioServicePort;

public class UsuarioService implements UsuarioServicePort{

    @Override
    public Usuario createUsuario(Usuario usuario) {
    
       return usuario;
    }
    
}
