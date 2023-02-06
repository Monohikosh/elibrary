package ru.sbercourses.library.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.model.GenericModel;
import ru.sbercourses.library.service.GenericService;

@RestController
public abstract class GenericController<T extends GenericModel> {

    private final GenericService<T> service;

    protected GenericController(GenericService<T> service) {
        this.service = service;
    }

    @Operation(description = "Получить список всех записей", method = "GetAll")
    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(service.listAll());
    }

    @Operation(description = "Получить запись", method = "GetOne")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
    }

    @Operation(description = "Создать запись", method = "Create")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody T object) {
        return ResponseEntity.status(HttpStatus.OK).body(service.create(object));
    }

    @Operation(description = "Обновить запись", method = "Update")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody T object, @PathVariable Long id) {
        object.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.update(object));
    }

    @Operation(description = "Удалить запись", method = "Delete")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
