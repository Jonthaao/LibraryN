package com.library.library.Entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    public static final boolean getisActive = false;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tittle;
    private String synopsis;
    private boolean Active;
    private Date publishDate;
    private int quantitie;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Genre genres;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Author author;
}
