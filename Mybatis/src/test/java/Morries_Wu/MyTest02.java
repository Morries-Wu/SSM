package Morries_Wu;

import Morries_Wu.Bean.Student;
import Morries_Wu.Dao.IMPL.StudentDaoIMPL;
import Morries_Wu.Dao.StudentDao;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MyTest02 {
    @Test
    public void testSelectOne() throws IOException {
        //要使用Dao的方法
        //接口类型 变量=new 接口的实现类();
        StudentDao dao = new StudentDaoIMPL();
        Student stu = dao.selectById(1001);
        System.out.println("通过Dao执行方法,得到的对象--------" + stu);
    }

    @Test
    public void testSelectStudents() {
        StudentDao dao = new StudentDaoIMPL();
        List<Student> stus = dao.selectStudents();
        stus.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void testInsert() {
        StudentDao dao = new StudentDaoIMPL();
        Student stu = new Student();
        stu.setId(1005);
        stu.setName("李潇");
        stu.setEmail("lixi@qq.com");
        stu.setAge(99);
        dao.insertStudent(stu);
    }

}
