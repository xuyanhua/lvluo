package com.yanhua;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午2:39
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("hello:" + name);
        return "hello:" + name;
    }
}
