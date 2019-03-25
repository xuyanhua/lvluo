package com.yanhua;

/**
 * 客户端Demo
 *
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午2:33
 */
public interface DemoService {
    /**
     * 单参数
     *
     * @param name
     * @return
     */
    Result<String> sayHello(String name);

    /**
     * 双参数
     *
     * @param name
     * @param age
     * @return
     */
    Result<String> sayHello(String name, Integer age);

    /**
     * javabean 参数
     *
     * @param student
     * @return
     */
    Result<String> sayHello(StudentBean student);
}
