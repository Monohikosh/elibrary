package ru.sbercourses.library.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto extends GenericDto{

    private String authorFIO;
    private String lifePeriod;
    private String description;
    private Set<Long> booksIds;

}
