package com.library.order.Services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.library.order.Dto.OrderDto;
import com.library.order.Entities.Order;
import com.library.order.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public String register(Order order) {
        repository.save(order);
        return "Cadastrado com sucesso!";
    }

    public List<OrderDto> showlist() {
        List<Order> orders = repository.findAll();
        return orders.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
    }

    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Order order = repository.findById(id).orElse(null);

        if (order != null) {
            repository.delete(order);
            return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Nao encontrado!", HttpStatus.NOT_FOUND);

    }

    //calculo da multa viculado por reserva
    public double calculateFine(int orderId) {
        Order order = repository.findById(orderId).orElse(null);

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
