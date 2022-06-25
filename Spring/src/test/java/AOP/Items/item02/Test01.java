package AOP.Items.item02;

import AOP.Items.item02.sevice.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01() {
        String config = "AOP/Items/item02/item02.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        String ret = service.doOther("张三", 22);
        System.out.println("test01中调用目标方法的结果:" + ret);
    }

}
