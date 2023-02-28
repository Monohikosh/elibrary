package ru.sbercourses.library.MVC.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.dto.AuthorDto;
import ru.sbercourses.library.mapper.AuthorMapper;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.service.AuthorService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/authors")
public class MVCAuthorController {

    private final AuthorService service;
    private final AuthorMapper mapper;

    public MVCAuthorController(AuthorService service, AuthorMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("")
    public String getAll(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int pageSize,
            Model model) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.ASC, "authorFIO"));
        Page<Author> authorPage = service.listAllPaginated(pageRequest);
        List<AuthorDto> authorDtos = authorPage
                .stream()
                .map(mapper::toDto)
                .toList();
        model.addAttribute("authors",
                new PageImpl<>(authorDtos, pageRequest, authorPage.getTotalElements()));
        return "authors/viewAllAuthors";
    }

    @GetMapping("/add")
    public String create() {
        return "authors/addAuthor";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("authorForm") AuthorDto authorDto) {
        service.create(mapper.toEntity(authorDto));
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("author", mapper.toDto(service.getOne(id)));
        return "authors/updateAuthor"; // path to html file
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("authorForm") AuthorDto authorDto) {
        service.update(mapper.toEntity(authorDto));
        return "redirect:/authors";
    }

    @PostMapping("/search")
    public String searchByAuthorFIO(@ModelAttribute("searchAuthors") AuthorDto authorDto, Model model) {
        if (authorDto.getAuthorFIO().trim().equals("")) {
            model.addAttribute("author", mapper.toDtos(service.listAll()));
        } else {
            model.addAttribute("author", service.searchByAuthorFIO(authorDto.getAuthorFIO()));
        }
        return "authors/viewAllAuthors";
    }

//    @GetMapping("/search")
//    public String searchByAuthorFIO(@RequestParam(value = "author", required = false) String authorFIO, Model model) {
//        model.addAttribute("authors", service.searchByAuthorFIO(authorFIO).stream().map(mapper::toDto));
//        return "authors/viewAllAuthors";
//    }
}
