package com.myapp.studentregistry.controller;

import com.myapp.studentregistry.model.Student;
import com.myapp.studentregistry.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController         // This class handles HTTP requests
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    // GET /api/students → list all
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    // GET /api/students/1 → get one
    @GetMapping("/{id}")
    public Student getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST /api/students → create new
    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    // PUT /api/students/1 → update
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student) {
        return service.update(id, student);
    }

    // DELETE /api/students/1 → remove
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Student deleted!");
    }
}