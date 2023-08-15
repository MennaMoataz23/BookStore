package com.example.bookStore.service;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.exception.BadEntryException;
import com.example.bookStore.exception.NotFoundException;
import com.example.bookStore.mapper.BookMapper;
import com.example.bookStore.model.constants.enums.Error;
import com.example.bookStore.model.entities.Book;
import com.example.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(book -> bookDtos.add(bookMapper.entityToDto(book)));
        return bookDtos;
    }

    public BookDto getBookById(Integer id) throws NotFoundException {
        Optional<Book> book = this.bookRepository.findById(id);
        if (book.isPresent()){
            return bookMapper.entityToDto(book.get());
        }
        else {
            throw new NotFoundException(Error.NOTFOUND_ERROR.getMessage());
        }
    }
    @Override
    public BookDto addBook(BookDto bookDto) {
        Book savedBook = this.bookRepository.save(Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .description(bookDto.getDescription())
                .price(bookDto.getPrice()).build());
        return BookDto.builder().title(savedBook.getTitle())
                .author(savedBook.getAuthor())
                .description(savedBook.getDescription())
                .price(savedBook.getPrice())
                .id(savedBook.getId()).build();
    }

    public void updateBook(BookDto bookDto)
    {
        Book book = bookMapper.dtoToEntity(bookDto);
        bookRepository.save(book);
    }
    public void deleteById(Integer id)
    {
        bookRepository.deleteById(id);
    }

    public BookDto findBookByTitle(String title)
    {
        Book book = bookRepository.findByTitle(title);
        return bookMapper.entityToDto(book);
    }
    public List<Book> findBooksByAuthor(String author)
    {
        List<Book> book = bookRepository.findByAuthor(author);
        return book;
    }
}
