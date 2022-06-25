package spring_mybatis.items.item01.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring_mybatis.items.item01.Bean.Student;
import spring_mybatis.items.item01.Dao.StudentDao;
import spring_mybatis.items.item01.Service.ServiceStudent;

import javax.annotation.Resource;
import java.util.List;

public class ServiceStudentImpl implements ServiceStudent {


    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int rows = studentDao.insertStudent(student);
        return rows;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
