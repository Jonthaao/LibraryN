package com.ads4.hexagonal.adapters.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private int id;
    private String nome;
    private String email;

    public UsuarioDto(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UsuarioDto() {
    }

}
