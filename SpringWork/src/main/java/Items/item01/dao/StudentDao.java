package Items.item01.dao;

import Items.item01.Bean.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudent();
}
