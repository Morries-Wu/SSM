package IOC.Service.Impl;

import IOC.Service.SomeService;

public class SomeServiceImpl implements SomeService {

    /**
     * spring默认使用的无参构造方法,创建对象
     * 如果定义了有参构造方法,应该再定义无参构造方法
     */
    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl的无参构造方法");
    }

    @Override
    public void dosome() {
        System.out.println("执行了业务方法doSome()");
    }
}
