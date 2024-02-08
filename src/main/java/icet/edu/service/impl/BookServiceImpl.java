package icet.edu.service.impl;

import icet.edu.dto.Book;
import icet.edu.entity.BookEntity;
import icet.edu.repository.BookRepository;
import icet.edu.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
}
