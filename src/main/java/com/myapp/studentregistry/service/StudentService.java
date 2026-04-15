package com.myapp.studentregistry.service;

import com.myapp.studentregistry.model.Student;
import com.myapp.studentregistry.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repo;

    // GET all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // GET one student by ID
    public Student getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
    }

    // CREATE a new student
    public Student create(Student student) {
        return repo.save(student);
    }

    // UPDATE a student
    public Student update(Long id, Student updated) {
        Student existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setAge(updated.getAge());
        return repo.save(existing);
    }

    // DELETE a student
    public void delete(Long id) {
        repo.deleteById(id);
    }
}