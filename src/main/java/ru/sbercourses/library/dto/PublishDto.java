package ru.sbercourses.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sbercourses.library.model.Book;
import ru.sbercourses.library.model.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublishDto extends GenericDto {

    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Integer rentPeriod;
    private Integer amount;
    private Long userID;
    private Long bookID;

}
