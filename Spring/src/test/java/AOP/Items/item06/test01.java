package AOP.Items.item06;

import AOP.Items.item06.sevice.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {

    @Test
    public void test01() {
        String cofing = "AOP/Items/item06/item06.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(cofing);
        SomeService service = (SomeService) ctx.getBean("someService");
        service.doThird();
    }
}
