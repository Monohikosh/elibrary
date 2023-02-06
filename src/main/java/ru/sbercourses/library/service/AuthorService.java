package ru.sbercourses.library.service;

import org.springframework.stereotype.Service;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.repository.AuthorRepository;

@Service
public class AuthorService extends GenericService<Author> {

    public AuthorService(AuthorRepository repository) {
        super(repository);
    }

}
