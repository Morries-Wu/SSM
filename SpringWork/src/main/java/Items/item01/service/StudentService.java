package Items.item01.service;

import Items.item01.Bean.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> queryStudents();

}
