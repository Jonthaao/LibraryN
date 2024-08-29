package com.library.order.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.order.Entities.User;
import com.library.order.Exception.RegisterNotFoundException;
import com.library.order.Exception.UserIdNotFoundException;
import com.library.order.Services.UserService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    
private final UserService userService;
    
        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathParam("id") int id) {
            try {
                userService.delete(id);
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
                userService.edit(null, id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (UserIdNotFoundException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            } catch (Exception a) {
                return new ResponseEntity<>(a.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
    
        }
    
        @PostMapping("/register")
        public ResponseEntity<?> register(User user) {
            try {
                userService.register(user);
                return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
        @GetMapping("/list")
        public ResponseEntity<?> list() {
            try {
                return new ResponseEntity<>(userService.showList(), HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
}
