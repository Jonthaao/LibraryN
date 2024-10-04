package com.ads4.hexagonal.adapters.databaseadapter.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private Date dataInicio;
    private Date dataDevolucao;
    private Boolean statusDevolucao;
    private Double multa;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private UsuarioEntity usuarioEntity;


    public PedidoEntity(){

    };

    public PedidoEntity(int id, Date dataInicio, Date dataDevolucao, Boolean statusDevolucao, Double multa){

        this.id = id;
        this.dataInicio = dataInicio;
        this.dataDevolucao = dataDevolucao;
        this.statusDevolucao = statusDevolucao;
        this.multa = multa;
    }
}
