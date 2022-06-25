package AOP.Items.item01;

import AOP.Items.item01.sevice.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01() {
        String config = "AOP/Items/item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        /*没有加入代理的处理:
        1、目标方法执行时,没有切面功能的
        2、service对象没有被改变*/
        SomeService service = (SomeService) ctx.getBean("someService");
        //service==serviceAOP.Items.item01.sevice.serviceImpl.SomeServiceImpl
        System.out.println("service:" + service.getClass().getName());
        service.doSome("ll", 20);
    }


    @Test
    public void test02() {
        String config = "AOP/Items/item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //加入代理的处理:
        // [1]目标方法执行时,有切面功能
        // [2]service对象是改变后的 代理对象 servicecom.sun.proxy.$Proxy8
        // servicecom.sun.proxy.$Proxy8 代理$Proxy=ServiceProxy
        SomeService service = (SomeService) ctx.getBean("someService");
        System.out.println("service:" + service.getClass().getName());
        //代理对象,调用方法,才有切面的功能增强
        //service.doSome("ll", 20);
        service.doOther();
    }
}
