package icet.edu.service.impl;

import icet.edu.dto.Book;
import icet.edu.entity.BookEntity;
import icet.edu.repository.BookRepository;
import icet.edu.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    ModelMapper mappper;
    @Bean
    public void setup(){
        this.mappper = new ModelMapper();
    }
    @Override
    public void addBook(Book book) {
        bookRepository.save(mappper.map(book, BookEntity.class));
    }

    @Override
    public List<BookEntity> getBooks() {

        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
    return false;
    }

    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        Book map = mappper.map(byId, Book.class);
        return map;
    }
}
