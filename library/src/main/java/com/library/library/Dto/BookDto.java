package com.library.library.Dto;

import java.util.Date;

import com.library.library.Entities.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    private String tittle;
    private boolean isActive;
    private int stock;
    private Date publishDate;
    private int quantitie;
    private String Author;
    
    

    public BookDto(Book book) {
        this.tittle = book.getTittle();
        this.isActive = book.isActive();
        this.publishDate = book.getPublishDate();
        this.quantitie = book.getQuantitie();
        this.Author = book.getAuthor().getName();
    }
}