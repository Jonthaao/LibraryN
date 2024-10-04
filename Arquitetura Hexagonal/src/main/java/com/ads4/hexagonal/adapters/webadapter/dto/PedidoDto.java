package com.ads4.hexagonal.adapters.webadapter.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PedidoDto {
    
    private int id;
    private Date dataInicio;
    private Date dataDevolucao;
    private Boolean statusDevolucao;
    private Double multa;

    

    public PedidoDto() {
    }



    public PedidoDto(int id, Date dataInicio, Date dataDevolucao, Boolean statusDevolucao, Double multa) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataDevolucao = dataDevolucao;
        this.statusDevolucao = statusDevolucao;
        this.multa = multa;
    }

}
