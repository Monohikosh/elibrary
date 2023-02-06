package ru.sbercourses.library.service;

import org.springframework.stereotype.Service;
import ru.sbercourses.library.model.User;
import ru.sbercourses.library.repository.GenericRepository;

@Service
public class UserService extends GenericService<User> {

    protected UserService(GenericRepository<User> repository) {
        super(repository);
    }

}
