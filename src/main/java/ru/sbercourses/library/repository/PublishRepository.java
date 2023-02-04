package ru.sbercourses.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbercourses.library.model.Publish;

public interface PublishRepository extends JpaRepository<Publish, Long> {

}
