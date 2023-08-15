package com.example.bookStore.web.conrollers;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.model.entities.Book;
import com.example.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<BookDto>findAllBooks(){
        return this.bookService.getBooks();
    }
    @GetMapping("/book")
    public BookDto findBookById(@RequestParam Integer id){
        return this.bookService.getBookById(id);
    }
    @PostMapping("/add-book")
    public BookDto addBook(@RequestBody BookDto bookdto){
        return this.bookService.addBook(bookdto);
    }
    @DeleteMapping("/delete-book/{id}")
    public void deleteBookById(@PathVariable Integer id){
        this.bookService.deleteById(id);
    }
//    @GetMapping("/books/byAuthor")
//    public List<BookDto> getBooksByAuthor(@RequestParam("author") String author){
//        return this.bookService.findBooksByAuthor(author);
//    }

    @GetMapping("/books/byTitle")
    public BookDto getBookByTitle(@RequestParam("title") String title){
        return this.bookService.findBookByTitle(title);
    }
}
