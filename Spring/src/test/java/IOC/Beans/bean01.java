package IOC.Beans;

import IOC.Service.OtherService;
import IOC.Service.SomeService;
import IOC.beans.bean01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class bean01 {

    //Spring创建对象,调用是类的哪个方法
    @Test
    public void test01() {
        //1、指定spring配置文件:从类路径(classpath)之下开始的路径
        String config = "IOC/beans/beans01.xml";
        //2、创建容器对象,ApplicationContext   表示spring容器对象,通过ctx获取某个Java对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //3、从容器中获取指定名称的对象,使用getBean("id")
        SomeService service = (SomeService) ctx.getBean("someService");
        //SomeService service = ctx.getBean(SomeService.class);
        //4、调用对象的方法,接口中的方法
        service.dosome();
    }


    @Test
    public void test02() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        service.dosome();
    }

    //获取容器中对象的信息
    @Test
    public void test03() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取容器中定义对象的数量
        int nums = ctx.getBeanDefinitionCount();
        System.out.println("容器中定义对象的数量:" + nums);

        //获取容器中定义的对象名称
        String names[] = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象的名称:" + name);
        }
    }

    //让spring创建非自定义类的对象,有class就能让spring创建对象
    @Test
    public void test04() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Date date = (Date) ctx.getBean("mydate");
        System.out.println(date);
    }

    @Test
    public void test05() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        OtherService date = (OtherService) ctx.getBean("otherService");
        date.doOther();
    }


    @Test
    public void test06() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student stu = (Student) ctx.getBean("myStudent");
        System.out.println(stu);
    }

    @Test
    public void test07() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Date date = (Date) ctx.getBean("mydate");
        System.out.println(date);
    }


    @Test
    public void test08() {
        String config = "IOC/beans/beans01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student date = (Student) ctx.getBean("myStudent");
        System.out.println(date);
    }


}
