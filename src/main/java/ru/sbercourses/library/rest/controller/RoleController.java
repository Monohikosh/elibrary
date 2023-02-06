package ru.sbercourses.library.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.model.Role;
import ru.sbercourses.library.service.RoleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/role")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Role> list() {
        return service.getList();
    }

//    public final RoleRepository roleRepository;
//
//    public RoleController(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @Operation(description = "Получить список всех ролей", method = "GetAll")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ResponseEntity<?> list() {
//        log.info("REST");
//        return ResponseEntity.ok().body(roleRepository.findAll());
//    }
//
//    @Operation(description = "Получить роль по ID", method = "GetOne")
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.findById(id).orElseThrow());
//    }
//
//    @Operation(description = "Создать новую роль", method = "Create")
//    @PostMapping("")
//    public ResponseEntity<?> create(@RequestBody Role role) {
//        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.save(role));
//    }
//
//    @Operation(description = "Обновить данные роли по ID", method = "Update")
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody Role role, @PathVariable Long id) {
//        role.setId(id);
//        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.save(role));
//    }
//
//    @Operation(description = "Удалить роль по ID", method = "Delete")
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        roleRepository.deleteById(id);
//    }

}
