package com.myapp.studentregistry.repository;

import com.myapp.studentregistry.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository gives us findAll(), save(), deleteById() for FREE!
public interface StudentRepository
        extends JpaRepository<Student, Long> {
}