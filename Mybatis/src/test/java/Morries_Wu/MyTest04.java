package Morries_Wu;

import Morries_Wu.Bean.Student;
import Morries_Wu.Dao.StudentDao;
import Morries_Wu.Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class MyTest04 {

    public static void main(String[] args) {

    }


    @Test
    public void testQueryStudent() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stus = dao.queryStudent("'李家华'");
        stus.forEach(out -> System.out.println(out));
        session.close();
    }


    @Test
    public void testQueryStudentOrById() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stus = dao.queryStudentOrById();
        stus.forEach(out -> System.out.println(out));
        session.close();
    }


    @Test
    public void testQueryStudentOrByName() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stus = dao.queryStudentOrByName();
        stus.forEach(out -> System.out.println(out));
        session.close();
    }

    @Test
    public void testQueryStudentOrByColName() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stus = dao.queryStudentOrByColName("id");
        stus.forEach(out -> System.out.println(out));
        session.close();
    }

}
