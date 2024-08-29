package com.library.order.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.order.Entities.Order;
import com.library.order.Exception.OrderIdNotFoundException;
import com.library.order.Exception.RegisterNotFoundException;
import com.library.order.Services.OrderService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;
    
        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathParam("id") int id) {
            try {
                orderService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (RegisterNotFoundException e) { // capturando o erro específico do service!
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            } catch (Exception a) { // Erro interno do Banco, por exemplo.
                return new ResponseEntity<>(a.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<?> edit(@PathParam("id") int id) {
            try {
                orderService.edit(null, id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (OrderIdNotFoundException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            } catch (Exception a) {
                return new ResponseEntity<>(a.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
    
        }
    
        @PostMapping("/register")
        public ResponseEntity<?> register(Order order) {
            try {
                orderService.register(order);
                return new ResponseEntity<>("Pedido cadastrado com sucesso!", HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
        @GetMapping("/list")
        public ResponseEntity<?> list() {
            try {
                return new ResponseEntity<>(orderService.showList(), HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
}
