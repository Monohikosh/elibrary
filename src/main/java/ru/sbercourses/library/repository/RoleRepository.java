package ru.sbercourses.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbercourses.library.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
