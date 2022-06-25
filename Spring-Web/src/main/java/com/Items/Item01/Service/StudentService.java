package com.Items.Item01.Service;

import com.Items.Item01.Bean.Student;

public interface StudentService {
    int addStudent(Student student);

    Student findStudentById(Integer id);
}
