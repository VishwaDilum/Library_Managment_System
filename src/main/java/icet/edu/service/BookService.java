package icet.edu.service;

import icet.edu.dto.Book;
import icet.edu.entity.BookEntity;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<BookEntity> getBooks();
    boolean deleteBook(Long id);
    Book getBookById(Long id);
}
