package ru.sbercourses.library.dto.utils;

import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.AuthorDto;
import ru.sbercourses.library.model.Author;

@Component
public class AuthorConverter extends Converter<Author, AuthorDto> {

    public AuthorConverter() {
        super(AuthorConverter::convertToEntity, AuthorConverter::convertToDto);
    }

    private static AuthorDto convertToDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .authorFIO(author.getAuthorFIO())
                .description(author.getDescription())
                .lifePeriod(author.getLifePeriod())
                .build();
    }

    private static Author convertToEntity(AuthorDto authorDto) {
        return Author.builder()
                .id(authorDto.getId())
                .authorFIO(authorDto.getAuthorFIO())
                .description(authorDto.getDescription())
                .lifePeriod(authorDto.getLifePeriod())
                .build();
    }

}
