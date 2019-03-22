package com.yanhua;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午2:35
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();
        System.in.read();
    }
}
