package Morries_Wu;

import Morries_Wu.Bean.Student;
import Morries_Wu.Utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest01 {
    //测试mybatis执行sql语句
    @Test
    public void testSelectStudentById() throws IOException {
        //调用mybatis某个对象的方法,执行mapper文件中的sql语句
        //mybatis核心类:SqlSessionFactory

        //1、定义mybatis主配置文件的位置,从类路径开始的相对路径
        String config = "mybatis.xml";
        //2、读取主配置文件,使用mybatis框架中Resources类
        InputStream read = Resources.getResourceAsStream(config);
        //3、创建SqlSessionFactory对象,使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);

        //4、获取SqlSession对象
        SqlSession session = factory.openSession();
        //5、指定要执行的sql语句的id,sql的id=namespace+"."+<select>|<update>|<insert>|<delete>标签的id属性值
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "selectById";
        //6、通过SqlSession的方法,执行sql语句
        Student stu = session.selectOne(sqlId);
        System.out.println("使用mybatis查询一个学生:" + stu);
        //7、关闭SqlSession对象
        session.close();
    }


    //测试mybatis执行sql语句
    @Test
    public void testSelectStudentById2() throws IOException {
        //调用mybatis某个对象的方法,执行mapper文件中的sql语句
        //mybatis核心类:SqlSessionFactory
        //1、定义mybatis主配置文件的位置,从类路径开始的相对路径
        String config = "mybatis.xml";
        //2、读取主配置文件,使用mybatis框架中Resources类
        InputStream read = Resources.getResourceAsStream(config);
        //3、创建SqlSessionFactory对象,使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);

        //4、获取SqlSession对象
        SqlSession session = factory.openSession();
        //5、指定要执行的sql语句的id,sql的id=namespace+"."+<select>|<update>|<insert>|<delete>标签的id属性值
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "selectById";
        //6、通过SqlSession的方法,执行sql语句
        Student stu = session.selectOne(sqlId, 1002);
        System.out.println("使用mybatis查询一个学生:" + stu);
        //7、关闭SqlSession对象
        session.close();
    }

    @Test
    public void testInsertStudent() throws IOException {
        String config = "mybatis.xml";
        InputStream read = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(read);
        SqlSession session = factory.openSession();
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "insertStudent";

        Student stu = new Student();
        stu.setId(1004);
        stu.setName("李嘉诚");
        stu.setEmail("lijia@qq.com");
        stu.setAge(100);
        int rows = session.insert(sqlId, stu);
        System.out.println("使用mybatis添加一个学生,rows:" + rows);

        //mybatis默认执行sql语句是 手工提交事务模式,在做insert,update,delete后需要提交事务。
        session.commit();
        session.close();
    }

    @Test
    public void testselectById() {
        //1、获取SqlSession
        SqlSession session = MybatisUtil.getsqlsession();
        //2、指定sqlId
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "selectById";
        //3、执行SqlSession的方法,表示执行sql语句
        Student stu = session.selectOne(sqlId, 1004);
        System.out.println(stu);
        //4、关闭SqlSession对象
        session.close();
    }


    @Test
    public void testselectAll() {
        //1、获取SqlSession
        SqlSession session = MybatisUtil.getsqlsession();
        //2、指定sqlId
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "selectStudents";
        //3、执行SqlSession的方法,表示执行sql语句
        List<Student> stus = session.selectList(sqlId);
        for (Student stu : stus) {
            System.out.println(stu);
        }
        //4、关闭SqlSession对象
        session.close();
    }


}
