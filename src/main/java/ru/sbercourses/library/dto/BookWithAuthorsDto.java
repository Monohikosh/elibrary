package ru.sbercourses.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookWithAuthorsDto extends BookDto {

    private Set<AuthorDto> authors;

}
