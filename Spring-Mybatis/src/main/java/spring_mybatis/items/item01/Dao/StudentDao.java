package spring_mybatis.items.item01.Dao;

import spring_mybatis.items.item01.Bean.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudents();
}
