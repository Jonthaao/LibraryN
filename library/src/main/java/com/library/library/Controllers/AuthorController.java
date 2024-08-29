package com.library.library.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Entities.Author;
import com.library.library.Exception.AuthorIdNotFoundException;
import com.library.library.Exception.RegisterNotFoundException;
import com.library.library.services.AuthorService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathParam("id") int id) {
        try {
            authorService.delete(id);
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
            authorService.edit(null, id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AuthorIdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception a) {
            return new ResponseEntity<>(a.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(Author author) {
        try {
            authorService.register(author);
            return new ResponseEntity<>("Autor cadastrado com sucesso!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        try {
            return new ResponseEntity<>(authorService.showList(), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
