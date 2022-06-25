package spring_mybatis.com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_mybatis.items.item01.Bean.Student;
import spring_mybatis.items.item01.Dao.StudentDao;
import spring_mybatis.items.item01.Service.ServiceStudent;

import java.util.List;

public class TestDataSource {
    @Test
    public void test01() {
        String config = "spring_mybatis/items/item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象名称-----" + name);
        }
    }

    @Test
    public void test02() {
        String config = "spring_mybatis/items/item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setName("simin");
        student.setAge(18);
        dao.insertStudent(student);
    }

    @Test
    public void test03() {
        String config = "spring_mybatis/items/item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ServiceStudent service = (ServiceStudent) ctx.getBean("studentService");
        Student student = new Student();
        student.setName("Morries_Wu");
        student.setAge(18);
        service.addStudent(student);
    }


    @Test
    public void test04() {
        String config = "spring_mybatis/items/item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ServiceStudent service = (ServiceStudent) ctx.getBean("studentService");
        List<Student> list = service.queryStudent();
        list.forEach(stu -> System.out.println(stu));
    }

}
