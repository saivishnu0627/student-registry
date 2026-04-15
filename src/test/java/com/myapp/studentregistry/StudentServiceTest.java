package com.myapp.studentregistry;

import com.myapp.studentregistry.model.Student;
import com.myapp.studentregistry.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    void shouldCreateStudent() {
        // 1. Create a student object
        Student s = Student.builder()
                .name("Bob")
                .email("bob@test.com")
                .age(19)
                .build();

        // 2. Save it to database
        Student saved = service.create(s);

        // 3. Check it was saved correctly
        assertNotNull(saved.getId());        // Should have an ID
        assertEquals("Bob", saved.getName()); // Name should be Bob
        assertEquals("bob@test.com", saved.getEmail()); // Email correct
        assertEquals(19, saved.getAge());    // Age should be 19
    }

    @Test
    void shouldGetAllStudents() {
        // Get list of all students
        var students = service.getAllStudents();

        // List should not be null
        assertNotNull(students);
    }
}