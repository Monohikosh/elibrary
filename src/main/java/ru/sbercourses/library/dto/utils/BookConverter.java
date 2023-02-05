package ru.sbercourses.library.dto.utils;

import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.AuthorDto;
import ru.sbercourses.library.dto.BookDto;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.Genre;

import java.util.function.Function;

@Component
public class BookConverter extends Converter<Book, BookDto> {

    public BookConverter() {
        super(BookConverter::convertToEntity, BookConverter::convertToDto);
    }

    private static BookDto convertToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .downloadLink(book.getDownloadLink())
                .title(book.getTitle())
                .genre(book.getGenre())
                .storagePlace(book.getStoragePlace())
                .amount(book.getAmount())
                .publishYear(book.getPublishYear())
                .build();
    }

    private static Book convertToEntity(BookDto bookDto) {
        if (bookDto.getId() == null) {
            return Book.builder()
                    .downloadLink(bookDto.getDownloadLink())
                    .title(bookDto.getTitle())
                    .genre(bookDto.getGenre())
                    .storagePlace(bookDto.getStoragePlace())
                    .amount(bookDto.getAmount())
                    .publishYear(bookDto.getPublishYear())
                    .build();
        } else {
            return Book.builder()
                    .id(bookDto.getId())
                    .downloadLink(bookDto.getDownloadLink())
                    .title(bookDto.getTitle())
                    .genre(bookDto.getGenre())
                    .storagePlace(bookDto.getStoragePlace())
                    .amount(bookDto.getAmount())
                    .publishYear(bookDto.getPublishYear())
                    .build();
        }
    }

}
