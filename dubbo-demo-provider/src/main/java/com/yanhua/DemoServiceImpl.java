package com.yanhua;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午2:39
 */
public class DemoServiceImpl implements DemoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public Result<String> sayHello() {
        Result<String> result = new Result<>();
        result.setModule("[empty param]hello:无参数");
        LOGGER.info("[empty param]hello:无参数");
        return result;
    }

    @Override
    public Result<String> sayHello(String name) {
        Result<String> result = new Result<>();
        result.setModule("[single param]hello:" + name);
        LOGGER.info("[single param]hello:" + name);
        return result;
    }

    @Override
    public Result<String> sayHello(String name, Integer age) {
        Result<String> result = new Result<>();
        result.setModule("[double params]hello:" + name + ", your age is:" + age);
        LOGGER.info("[double params]hello:" + name + ", your age is:" + age);
        return result;
    }

    @Override
    public Result<String> sayHello(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        Result<String> result = new Result<>();
        result.setModule("[java bean]hello:" + name + ", your age is:" + age);
        LOGGER.info("[java bean]hello:" + name + ", your age is:" + age);
        return result;
    }

    @Override
    public void saveStudent(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        System.out.println("hello:" + name);
        Result<String> result = new Result<>();
        result.setModule("[no response]saveStudent:name=" + name + ", age=" + age);
    }
}
