package IOC.Beans;

import IOC.beans.bean02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class bean02 {

    @Test
    public void test01() {
        String config = "IOC/beans/beans02.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student date = (Student) ctx.getBean("myStudent03");
        System.out.println(date);
        File myfile = (File) ctx.getBean("myfile");
        System.out.println(myfile.getName());
    }

}
