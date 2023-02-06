package ru.sbercourses.library.service;

import org.springframework.stereotype.Service;
import ru.sbercourses.library.model.Publish;
import ru.sbercourses.library.repository.GenericRepository;
import ru.sbercourses.library.repository.PublishRepository;

@Service
public class PublishService extends GenericService<Publish> {

    protected PublishService(GenericRepository<Publish> repository) {
        super(repository);
    }

}
