package AOP.Items.item01.sevice.serviceImpl;

import AOP.Items.item01.sevice.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, int age) {
        System.out.println("业务方法doSome(),创建商品的订单");
    }

    @Override
    public void doOther() {
        System.out.println("业务方法doOther()");
    }
}
