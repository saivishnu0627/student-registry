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
        Student s = Student.builder()
                .name("TestStudent")
                .email("test" + System.currentTimeMillis() + "@test.com")
                .age(19)
                .build();

        Student saved = service.create(s);

        assertNotNull(saved.getId());
        assertEquals("TestStudent", saved.getName());
    }

    @Test
    void shouldGetAllStudents() {
        var students = service.getAllStudents();
        assertNotNull(students);
    }
}