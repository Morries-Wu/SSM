package Morries_Wu;

import Morries_Wu.Bean.Student;
import Morries_Wu.Dao.StudentDao;
import Morries_Wu.QueryParam.QueryParam;
import Morries_Wu.Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest03 {

    @Test
    public void testSelectById() throws IOException {
        //1、获取SqlSession
        SqlSession session = MybatisUtil.getsqlsession();
        //2、获取Dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = dao.selectById(1005);
        System.out.println(stu);
        session.close();
    }

    @Test
    public void testSelectStudents() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        System.out.println(dao.getClass().getName());
        List<Student> stus = dao.selectStudents();
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testOneParameter() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = dao.selectByEmail("li@qq.com");
        System.out.println(stu);
        session.close();
    }

    @Test
    public void testSelectByNameOrAge() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stus = dao.selectByNameOrAge("李春", 26);
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }


    @Test
    public void testSelectByObject() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("李春");
        stu.setAge(21);
        List<Student> stus = dao.selectByObject(stu);
        stus.forEach(out -> System.out.println(out));
        session.close();
    }

    @Test
    public void testSelectByQueryParam() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setP1("李春");
        param.setP2(21);
        List<Student> params = dao.selectByQueryParam(param);
        params.forEach(out -> System.out.println(out));
        session.close();
    }

    @Test
    public void testSelectByPosition() {
        //按位置传递参数
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> stus = dao.selectByPosition("李春", 21);
        stus.forEach(out -> System.out.println(out));
        session.close();
    }

    @Test
    public void testSelectByMap() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        //使用Map传递参数
        Map<String, Object> data = new HashMap<>();
        data.put("myname", "李思思");
        data.put("myage", 21);
        List<Student> stus = dao.selectStudentByMap(data);
        stus.forEach(out -> System.out.println(out));
        session.close();
    }


    @Test
    public void testUpdateStudent() {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student data = new Student();
        data.setName("李家华");
        data.setAge(200);
        data.setId(1004);
        data.setEmail("lijiahua@qq.com");
        int rows = dao.updateStudent(data);
        session.commit();
        System.out.println(rows);
        session.close();
    }


}
