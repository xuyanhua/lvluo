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
     * 空参数
     *
     * @return
     */
    Result<String> sayHello();

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

    /**
     * 无返回值
     *
     * @param student
     */
    void saveStudent(StudentBean student);
}
