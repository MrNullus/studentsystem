package org.punkdomus.studentsystem.service;

import org.punkdomus.studentsystem.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {
    public Student saveStudent(Student student);
}
