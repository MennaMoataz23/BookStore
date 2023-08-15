package com.example.bookStore.mapper;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.model.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto entityToDto(Book book);
    Book dtoToEntity(BookDto bookDto);
}
