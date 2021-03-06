package IOC.items.item06;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component("myStudent")
public class Student {

    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private int age;

    /**
     * @Resource:来自jdk中,给引用类型赋值的,支持byName,byType,默认是byName spring支持这个注解的使用
     * 位置:
     * 1、在属性定义的上面,无需set方法,推荐使用
     * 2、在set方法上面
     * <p>
     * 说明:使用jdk1.8带有@Resource注解,高于jdk1.8没有这个@Resource
     * 需要加入一个依赖
     * @Resource只使用byName赋值 使用注解属性name="bean的id"
     */

    @Resource(name = "mySchool")
    private School school;

    public Student() {
        System.out.println("Student无参数构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
