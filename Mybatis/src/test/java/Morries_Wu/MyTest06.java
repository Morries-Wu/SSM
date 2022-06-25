package Morries_Wu;


import Morries_Wu.Bean.Custom;
import Morries_Wu.Bean.Student;
import Morries_Wu.Dao.StudentDao02;
import Morries_Wu.Utils.MybatisUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTest06 {

    @Test
    public void testSelectById() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        Custom custom = dao.selectById(1001);
        System.out.println(custom);
        session.close();
    }

    @Test
    public void testLikeOne() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        String name = "%李%";
        List<Student> stus = dao.selectLikeOne(name);
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testLikeTwo() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        String name = "李";
        List<Student> stus = dao.selectLikeTwo(name);
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testSelectIf() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        Student read = new Student();
        read.setName(null);
        read.setAge(22);
        List<Student> stus = dao.selectIf(read);
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testSelectWhere() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        Student read = new Student();
        read.setName(null);
        read.setAge(100);
        List<Student> stus = dao.selectWhere(read);
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testFor() {
        List<Integer> idlist = new ArrayList<>();
        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);
        //查询id在idlist中的student
        //select * from student where id in(1001,1002,1003)
        StringBuffer sql = new StringBuffer("");
        sql.append("select * from student where id in ");

        //使用循环,把list数据追加到sql字符串中,循环之前加入(
        sql.append("(");
        for (int i = 0; i < idlist.size(); i++) {
            Integer item = idlist.get(i);
            sql.append(item);//添加成员到sql字符串
            sql.append(",");
        }
        //循环之后,加入)
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        System.out.println("sql" + sql);
    }

    @Test
    public void testForeachOne() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        List<Integer> idlist = new ArrayList<>();

        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);

        List<Student> stus = dao.selectForeachOne(idlist);
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }


    @Test
    public void testForeachTwo() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        List<Student> stus = new ArrayList<>();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setId(1001);
        s2.setId(1002);
        s3.setId(1003);
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        List<Student> out = dao.selectForeachTwo(stus);
        out.forEach(stu -> System.out.println(stu));
        session.close();
    }


    @Test
    public void testPageHelper() throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        StudentDao02 dao = session.getMapper(StudentDao02.class);
        //调用PageHelper的方法
        PageHelper.startPage(1, 2);
        List<Student> stus = dao.selectAllStudents();
        stus.forEach(stu -> System.out.println(stu));
        session.close();
    }
}
