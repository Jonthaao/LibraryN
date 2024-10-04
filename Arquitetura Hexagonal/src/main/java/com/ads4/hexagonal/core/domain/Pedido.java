package com.ads4.hexagonal.core.domain;

import java.util.Date;

public class Pedido {

    private int id;

    private Date dataInicio;
    private Date dataDevolucao;
    private Boolean statusDevolucao;
    private Double multa;

    public Pedido() {
    }

    public Pedido(int id, Date dataInicio, Date dataDevolucao, Boolean statusDevolucao, Double multa) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataDevolucao = dataDevolucao;
        this.statusDevolucao = statusDevolucao;
        this.multa = multa;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Boolean getStatusDevolucao() {
        return statusDevolucao;
    }

    public void setStatusDevolucao(Boolean statusDevolucao) {
        this.statusDevolucao = statusDevolucao;
    }

    public Double getMulta() {
        return multa;
    }

    public void setMulta(Double multa) {
        this.multa = multa;
    }

 

}
