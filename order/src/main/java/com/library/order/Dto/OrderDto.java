package com.library.order.Dto;

import java.util.Date;

import com.library.order.Entities.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Date start_date;
    private Date devolution_date;
    private Boolean status_devolution;
    private Double multa;

    public OrderDto(Order order) {
        this.start_date = order.getStart_date();
        this.devolution_date = order.getDevolution_date();
        this.status_devolution = order.getStatus_devolution();
        this.multa = order.getMulta();
    }

    
    
}
