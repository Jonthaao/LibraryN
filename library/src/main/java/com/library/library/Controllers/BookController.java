package com.library.library.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Exception.RegisterNotFoundException;
import com.library.library.services.BookService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathParam ("id") int id){
        try {
            bookService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RegisterNotFoundException e) {       //capturando o erro específico do service!
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch(Exception a){ //Erro interno do Banco, por exemplo.
            return new ResponseEntity<>(a.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }     
    }

}
