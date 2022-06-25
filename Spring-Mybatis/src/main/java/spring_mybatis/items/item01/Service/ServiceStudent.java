package spring_mybatis.items.item01.Service;

import spring_mybatis.items.item01.Bean.Student;

import java.util.List;

public interface ServiceStudent {
    int addStudent(Student student);

    List<Student> queryStudent();
}
