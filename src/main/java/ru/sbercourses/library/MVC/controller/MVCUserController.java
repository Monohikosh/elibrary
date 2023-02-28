package ru.sbercourses.library.MVC.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.dto.UserDto;
import ru.sbercourses.library.mapper.UserMapper;
import ru.sbercourses.library.service.UserService;

@Slf4j
@Hidden
@Controller
@RequestMapping("/users")
public class MVCUserController {

    private final UserService service;
    private final UserMapper mapper;

    public MVCUserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping ("/registration")
    public String registration(@ModelAttribute("userForm") UserDto userDto) {
        service.create(mapper.toEntity(userDto));
        return "redirect:/login";
    }

}
