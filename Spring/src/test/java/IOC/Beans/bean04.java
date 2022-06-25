package IOC.Beans;

import IOC.beans.bean04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bean04 {

    @Test
    public void test01() {
        String config = "IOC/beans/beans04.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student date = (Student) ctx.getBean("myStudent");
        System.out.println(date);
    }


}
