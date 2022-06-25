package AOP.Items.item01.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * Aspect:切面类注解
 * 位置:放在某个类的上面
 * 作用:表示当前类是切面类
 * 切面类:表示包含切面功能的类
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法,表示切面的具体功能
     * 前置通知方法的定义
     *          [1]方法是public
     *          [2]方法是void
     *          [3]方法名臣自定义
     *          [4]方法可以有参数,如果有是JoinPoint也可以没有
     */


    /**
     * @Before:前置通知 属性:value 切入点表达式,表示切面的执行位置
     * 在这个方式时,会同时执行切面的功能
     *    位置:在方法的上面
     *    特点:
     *        [1]执行时间,在目标方法之前执行的
     *        [2]不会影响目标方法的执行
     *        [3]不会修改目标方法的执行结果
     */
    /*@Before(value = "execution(public void AOP.Items.item01.sevice.serviceImpl.SomeServiceImpl.doSome(String , int ))")
    public void myBefore01() {
        //切面的功能代码
        System.out.println("前置通知,切面功能,在目标方法之前先执行" + new Date());
    }*/


    @Before(value = "execution(void AOP.Items.item01.sevice.serviceImpl.SomeServiceImpl.doSome(String , int ))")
    public void myBefore02() {
        //切面的功能代码
        System.out.println("前置通知,切面功能,在目标方法之前先执行" + new Date());
    }

    /**
     * 切面类中的通知方法,可以有参数,也可以没有
     * JoinPoint必须是它
     * JoinPoint:表示正在执行的业务方法,相当于反射中的Method
     * 使用要求:必须是参数列表的第一个
     * 作用:获取方法执行时的信息,例如方法名称,方法的参数集合
     */

    @Before(value = "execution(* * ..SomeServiceImpl.do*(..))")
    public void myBefore03(JoinPoint joinPoint) {
        //获取方法的定义
        System.out.println("前置通知中,获取目标方法的定义:" + joinPoint.getSignature());
        System.out.println("前置通知中,获取方法名称:" + joinPoint.getSignature().getName());
        //获取方法执行时参数
        Object[] args = joinPoint.getArgs();//数组中存放的是,方法的所有参数
        for (Object arg : args) {
            System.out.println("前置通知,获取方法的参数:" + arg);
        }
        String methodName = joinPoint.getSignature().getName();
        if ("doSome".equals(methodName)) {
            //切面的功能代码
            System.out.println("doSome输出日志-------前置通知,切面功能,在目标方法之前先执行" + new Date());
        } else if ("doOther".equals(methodName)) {
            System.out.println("doOther前置通知,作为方法名称,参数的记录");
        }

    }


}
