package test_work;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test_work.Bean.SysUser;
import test_work.Service.UserService;

public class test01 {
    @Test
    public void test01() {
        String config = "IOC/test_work/test01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserService service = (UserService) ctx.getBean("userService");

        SysUser user = new SysUser();
        user.setName("lili");
        user.setAge(20);
        service.addUser(user);
    }
}
