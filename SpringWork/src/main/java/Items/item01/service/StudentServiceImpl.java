package Items.item01.service;

import Items.item01.Bean.Student;
import Items.item01.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <bean>
 *
 * @Service
 */
@Service
public class StudentServiceImpl implements StudentService {
    /**
     * dao是引用类型,StudentDao类型的对象是在Spring的配置文件中创建的对象
     * 引用类型自动注入@Autowired,@Resource
     */
    @Autowired
    private StudentDao dao;

    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);
        return rows;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> stulist = dao.selectStudent();
        return stulist;
    }
}
