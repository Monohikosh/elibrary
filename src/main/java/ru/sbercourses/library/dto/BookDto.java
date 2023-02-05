package ru.sbercourses.library.dto;

import lombok.*;
import ru.sbercourses.library.model.Author;
import ru.sbercourses.library.model.Genre;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String downloadLink;
    private String title;
    private Genre genre;
    private String storagePlace;
    private Integer amount;
    private String publishYear;

}
