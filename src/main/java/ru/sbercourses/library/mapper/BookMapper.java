package ru.sbercourses.library.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.AuthorDto;
import ru.sbercourses.library.dto.BookDto;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.GenericModel;
import ru.sbercourses.library.repository.AuthorRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookMapper extends GenericMapper<Book, BookDto> {

    private final ModelMapper mapper;
    private final AuthorRepository authorRepository;

    protected BookMapper(ModelMapper mapper, AuthorRepository authorRepository) {
        super(mapper, Book.class, BookDto.class);
        this.mapper = mapper;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Book.class, BookDto.class)
                .addMappings(m -> m.skip(BookDto::setAuthorsIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(BookDto.class, Book.class)
                .addMappings(m -> m.skip(Book::setAuthors)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Book source, BookDto destination) {
        destination.setAuthorsIds(getIds(source));
    }

    private Set<Long> getIds(Book book) {
        return Objects.isNull(book) || Objects.isNull(book.getId())
                ? null
                : book.getAuthors().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet());
    }

    @Override
    void mapSpecificFields(BookDto source, Book destination) {
        destination.setAuthors(authorRepository.findAllByIdIn(source.getAuthorsIds()));
    }
}
