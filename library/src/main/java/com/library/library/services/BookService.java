package com.library.library.services;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;
import com.library.library.Entities.Book;
import com.library.library.Exception.BookIdNotFoundException;
import com.library.library.Exception.RegisterNotFoundException;
import com.library.library.Dto.BookDto;
import com.library.library.Repositories.BookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional //Só vai enviar para o banco se todas as operações dentro desse método derem certo... Caso dê erro, ele não joga para dentro do banco.
    public Book register(Book book) {
        bookRepository.save(book);

        return book;
    }

    public List<BookDto> showList() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(x -> new BookDto(x)).collect(Collectors.toList());
    }

    public int delete(int id) throws RegisterNotFoundException{//como o erro não é global, é necessário informar que o método pode jogar esse erro!
        Book book = bookRepository.findById(id).orElseThrow(()-> new RegisterNotFoundException("Registro não encontrado!"));//No caso aqui ele ele gera um ERRO de 404 ao não encontrar o livro
            bookRepository.delete(book);
            return id;
    }

    public String edit(Book newbook, int id) throws BookIdNotFoundException{
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookIdNotFoundException("Id do livro não encontrado!"));

        book.setTittle(newbook.getTittle());
        book.setAuthor(newbook.getAuthor());
        book.setGenres(newbook.getGenres());
        book.setPublishDate(newbook.getPublishDate());
        book.setSynopsis(newbook.getSynopsis());
        book.setActive(newbook.isActive()); //Testar esse campo 
        book.setQuantitie(newbook.getQuantitie());

        bookRepository.save(book);

        return new String("Book updated successfully!");
    }

}
