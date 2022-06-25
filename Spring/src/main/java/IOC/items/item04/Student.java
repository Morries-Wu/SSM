package IOC.items.item04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {

    //${properties文件中的value}
    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private int age;

    /**
     * 引用类型
     *
     * @Autowired: spring框架提供的, 给引用类型赋值, 使用自动注入原理。
     *             支持byName,byType.默认是byType
     *              位置:
     *              1、在属性定义的上面,无需set方法,推荐使用
     *              2、在set方法的上面
     *
     * byName自动注入:
     *              1、@Autowired:给引用类型赋值
     *              2、@Qualifer(value="bean的id") 从容器中找到指定名称对象,把对象赋值给引用类型
     */

    //使用byName
    @Autowired
    @Qualifier(value = "mySchool")
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
