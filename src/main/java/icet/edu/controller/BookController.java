package icet.edu.controller;

import icet.edu.dto.Book;
import icet.edu.entity.BookEntity;
import icet.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<BookEntity> getBooks(){
        return bookService.getBooks();
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        if(bookService.deleteBook(id)){
            return "Deleted";
        }else{
            return "Not Deleted";
        }
    }
    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
}
