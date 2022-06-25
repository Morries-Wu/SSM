package AOP.Items.item05;

import AOP.Items.item05.sevice.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01() {
        String config = "AOP/Items/item05/item05.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        service.doThird();
    }

}
