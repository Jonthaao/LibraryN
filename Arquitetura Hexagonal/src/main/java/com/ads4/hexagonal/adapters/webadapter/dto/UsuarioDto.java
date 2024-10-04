package com.ads4.hexagonal.adapters.webadapter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioDto(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDto() {
    }
    
}
