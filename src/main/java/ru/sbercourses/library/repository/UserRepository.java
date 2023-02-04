package ru.sbercourses.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sbercourses.library.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByFirstName(String firstName);
    List<User> findAllByFirstNameAndMiddleName(String firstName, String middleName);

    @Query(nativeQuery = true, value = """
        select * from users where created_by = :createdBy
    """)
    List<User> findAllByCreatedBy(@Param(value = "createdBy") String createdBy);

}
