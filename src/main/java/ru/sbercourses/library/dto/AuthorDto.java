package ru.sbercourses.library.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private Long id;
    private String authorFIO;
    private String lifePeriod;
    private String description;

}
