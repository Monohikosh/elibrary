package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbercourses.library.model.Publish;
import ru.sbercourses.library.repository.GenericRepository;
import ru.sbercourses.library.service.GenericService;
import ru.sbercourses.library.service.PublishService;

@Slf4j
@RestController
@RequestMapping("/rest/publish")
public class PublishController extends GenericController<Publish> {

    protected PublishController(GenericService<Publish> service) {
        super(service);
    }

}
