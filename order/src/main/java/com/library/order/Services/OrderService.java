package com.library.order.Services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.library.order.Dto.OrderDto;
import com.library.order.Entities.Order;
import com.library.order.Exception.OrderIdNotFoundException;
import com.library.order.Exception.RegisterNotFoundException;
import com.library.order.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public String register(Order order) {
        orderRepository.save(order);
        return "Cadastrado com sucesso!";
    }

    public List<OrderDto> showList() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
    }

    public int delete(@PathVariable("id") int id) throws RegisterNotFoundException{
        Order order = orderRepository.findById(id).orElseThrow(()-> new RegisterNotFoundException("Registro de pedido não encontrado!"));
        orderRepository.delete(order);
        return id;

    }

     public String edit(Order neworder, int id) throws OrderIdNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderIdNotFoundException("Código de pedido não encontrada!"));

        order.setStart_date(neworder.getStart_date());
        order.setDevolution_date(neworder.getDevolution_date());
        order.setStatus_devolution(neworder.getStatus_devolution());
        order.setMulta(neworder.getMulta());

        orderRepository.save(order);

        return new String("Pedido atualizado com sucesso!");
    }


    //calculo da multa viculado por reserva
    public double calculateFine(int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order != null) {
            Date today = new Date(); // data atual
            if (today.after(order.getDevolution_date())) {
                long diffInMillies = Math.abs(today.getTime() - order.getDevolution_date().getTime());
                long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                return diffInDays * 2.0; // R$2 por dia de atraso
            }
        }
        return 0.0; // Sem multa se não houver atraso
    }
    
}
