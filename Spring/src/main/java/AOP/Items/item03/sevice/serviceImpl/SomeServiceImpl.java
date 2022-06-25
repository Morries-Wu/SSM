package AOP.Items.item03.sevice.serviceImpl;

import AOP.Items.item03.sevice.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, int age) {
        System.out.println("业务方法doSome(),创建商品的订单");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("执行业务方法doOther,处理库存");
        return "abcd";
    }

    @Override
    public String doFirst(String name) {
        System.out.println("执行业务方法doFirst,处理库存");
        return "doFirst";
    }

}
