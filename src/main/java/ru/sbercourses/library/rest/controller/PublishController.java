package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbercourses.library.dto.PublishDto;
import ru.sbercourses.library.mapper.PublishMapper;
import ru.sbercourses.library.model.Publish;
import ru.sbercourses.library.service.GenericService;

@Slf4j
@RestController
@RequestMapping("/rest/publish")
public class PublishController extends GenericController<Publish, PublishDto> {

    protected PublishController(GenericService<Publish> service, PublishMapper mapper) {
        super(service, mapper);
    }

}
