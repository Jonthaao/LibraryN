package com.library.library.services;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Entities.Book;
import com.library.library.Dto.BookDto;
import com.library.library.Repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public String register(Book book) {
        repository.save(book);

        return "Successfully registered!";
    }

    public List<BookDto> showList() {
        List<Book> books = repository.findAll();
        return books.stream().map(x -> new BookDto(x)).collect(Collectors.toList());
    }

    public String delete(int id) {
        Book book = repository.findById(id).orElse(null);

        if (book != null) {
            repository.delete(book);
            return new String("Successfully deleted!");
        }

        return new String("Record not found.");
    }

    public String edit(Book newbook, int id) {
        Book book = repository.findById(id).orElse(null);

        book.setTittle(newbook.getTittle());
        book.setAuthor(newbook.getAuthor());
        book.setGenres(newbook.getGenres());
        book.setPublishDate(newbook.getPublishDate());
        book.setSynopsis(newbook.getSynopsis());
        book.setStock(newbook.getStock());
        book.setActive(newbook.isActive()); //Testar esse campo 

        repository.save(book);

        return new String("Book updated successfully!");
    }

}
