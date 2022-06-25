package IOC.Item;

import IOC.items.item01.Bean.SysUser;
import IOC.items.item01.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01() {
        String config = "IOC/item01/Item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserService userService = (UserService) ctx.getBean("userService");
        SysUser user = new SysUser();
        user.setName("Xixi");
        user.setAge(18);
        userService.addUser(user);
    }
}
