package com.yanhua;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午2:39
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public Result<String> sayHello() {
        System.out.println("空参数...");
        Result<String> result = new Result<>();
        result.setModule("[empty param]hello:" + "无参数");
        return result;
    }

    @Override
    public Result<String> sayHello(String name) {
        System.out.println("hello:" + name);
        Result<String> result = new Result<>();
        result.setModule("[single param]hello:" + name);
        return result;
    }

    @Override
    public Result<String> sayHello(String name, Integer age) {
        System.out.println("hello:" + name);
        Result<String> result = new Result<>();
        result.setModule("[double params]hello:" + name + ", your age is:" + age);
        return result;
    }

    @Override
    public Result<String> sayHello(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        System.out.println("hello:" + name);
        Result<String> result = new Result<>();
        result.setModule("[java bean]hello:" + name + ", your age is:" + age);
        return result;
    }
}
