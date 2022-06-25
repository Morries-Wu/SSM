package IOC.items.item02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component: 表示创建对象, 对象放到容器中, 作用是<bean>
 * 属性:value,表示对象名称,也就是bean的id属性值
 * 位置:在类的上面,表示创建此类的对象
 * @Component(value = "myStudent") 等同于
 * <bean id="myStudent" class="item02.Student"/>
 * 和@Component功能相同的创建对象的注解
 * 1、@Repository:放在dao接口的实现类上面,表示创建dao对象,持久层,能访问数据库
 * 2、@Service:放在业务层接口的实现类上面,表示创建业务层对象,业务层对象有事务的功能
 * 3、@Controller:放在控制器类的上面,表示创建控制器对象。属于表示层对象。
 * 控制器对象能接收请求,把请求的处理结果显示给用户
 *
 * 以上四个注解都能创建对象,但是@Repository,@Service,@Controller有角色说明,表示对象是分层的
 * 对象是属于不同层的,具有额外的功能
 */
//使用value指定对象的名称
//@Component(value = "myStudent")
//省略value
@Component("myStudent")
//没有提供自定义对象名称,使用框架的默认对象名称:类名首字母小写 student
//@Component
public class Student {
    /**
     * 简单类型属性赋值:@Value
     *
     * @Value:简单类型属性赋值 属性:value简单类型属性值
     * 位置:
     * 1、在属性定义的上面,无需set方法,推荐使用
     * 2、在set方法的上面
     */

    //使用外部属性文件中的数据,语法${"key"}
    @Value("${myname}")
    private String name;
    private int age;

    public Student() {
        System.out.println("Student无参数构造方法");
    }


    public void setName(String name) {
        System.out.println("setName=" + name);
        this.name = name;
    }


    @Value("${myage}")
    public void setAge(int age) {
        System.out.println("setAge=" + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
