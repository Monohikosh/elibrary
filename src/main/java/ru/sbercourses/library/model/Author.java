package ru.sbercourses.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity // класс является сущностью
@Table(name = "authors")
@Getter
@Setter
// для hibernate обязателен
// пустой конструктор
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_name", sequenceName = "authors_seq", allocationSize = 1)
public class Author extends GenericModel {

    @Column(name = "author_fio")
    private String authorFIO;

    @Column(name = "life_period")
    private String lifePeriod;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<Book> books = new HashSet<>();

}
