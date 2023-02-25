package ru.sbercourses.library.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sbercourses.library.dto.PublishDto;
import ru.sbercourses.library.model.GenericModel;
import ru.sbercourses.library.model.Publish;
import ru.sbercourses.library.repository.BookRepository;
import ru.sbercourses.library.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PublishMapper extends GenericMapper<Publish, PublishDto> {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    protected PublishMapper(ModelMapper mapper, BookRepository bookRepository, UserRepository userRepository) {
        super(mapper, Publish.class, PublishDto.class);
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setupMapper() {
        super.mapper.createTypeMap(Publish.class, PublishDto.class)
                .addMappings(m -> m.skip(PublishDto::setUserID)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(PublishDto::setBookID)).setPostConverter(toDtoConverter());
        super.mapper.createTypeMap(PublishDto.class, Publish.class)
                .addMappings(m -> m.skip(Publish::setUser)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Publish::setBook)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Publish source, PublishDto destination) {
        destination.setUserID(source.getUser().getId());
        destination.setBookID(source.getBook().getId());
    }

    @Override
    void mapSpecificFields(PublishDto source, Publish destination) {
        destination.setBook(bookRepository.findById(source.getBookID()).orElseThrow());
        destination.setUser(userRepository.findById(source.getUserID()).orElseThrow());
    }
}
