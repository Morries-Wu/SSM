package AOP.Items.item03;

import AOP.Items.item03.sevice.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01() {
        String config = "AOP/Items/item03/item03.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        String ret = service.doFirst("Morries");
        System.out.println("调用目标方法的结果:" + ret);
    }

}
