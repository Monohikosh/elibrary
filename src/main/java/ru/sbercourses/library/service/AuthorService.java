package ru.sbercourses.library.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sbercourses.library.dto.AuthorDto;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService extends GenericService<Author> {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository repository) {
        super(repository);
        this.authorRepository = repository;
    }

    public List<Author> searchByAuthorFIO(String fio) {
        return authorRepository.findAllByAuthorFIO(fio);
    }

    public Page<Author> listAllPaginated(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

}
