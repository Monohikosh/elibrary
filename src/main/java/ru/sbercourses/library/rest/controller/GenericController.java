package ru.sbercourses.library.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbercourses.library.model.GenericModel;
import ru.sbercourses.library.repository.GenericRepository;

@RestController
public abstract class GenericController<T extends GenericModel> {

    private final GenericRepository<T> genericRepository;

    protected GenericController(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Operation(description = "Получить список всех записей", method = "GetAll")
    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(genericRepository.findAll());
    }

    @Operation(description = "Получить запись", method = "GetOne")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(genericRepository.findById(id).orElseThrow());
    }

    @Operation(description = "Создать запись", method = "Create")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody T object) {
        return ResponseEntity.status(HttpStatus.OK).body(genericRepository.save(object));
    }

    @Operation(description = "Обновить запись", method = "Update")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody T object, @PathVariable Long id) {
        object.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(genericRepository.save(object));
    }

    @Operation(description = "Удалить запись", method = "Delete")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genericRepository.deleteById(id);
    }
}
