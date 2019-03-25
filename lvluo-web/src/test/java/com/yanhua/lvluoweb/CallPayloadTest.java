package com.yanhua.lvluoweb;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/25 下午5:31
 */
public class CallPayloadTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(CallPayloadTest.class);

    /**
     * 无参的调用负载
     */
    @Test
    public void testNoneParams() {
        CallPayload callPayload = new CallPayload();
        callPayload.setInterfaceName("com.yanhua.DemoService");
        callPayload.setMethodName("sayHello");
        callPayload.setParameterTypes(new String[0]);
        callPayload.setArgs(new Object[0]);
        LOGGER.info(JSONObject.toJSONString(callPayload));
    }

    /**
     * 单参的调用负载
     */
    @Test
    public void testSingleParams() {
        CallPayload callPayload = new CallPayload();
        callPayload.setInterfaceName("com.yanhua.DemoService");
        callPayload.setMethodName("sayHello");
        callPayload.setParameterTypes(new String[]{"java.lang.String"});
        callPayload.setArgs(new Object[]{"xuyanhua"});
        LOGGER.info(JSONObject.toJSONString(callPayload));
    }

    /**
     * 双参的调用负载
     */
    @Test
    public void testDoubleParams() {
        CallPayload callPayload = new CallPayload();
        callPayload.setInterfaceName("com.yanhua.DemoService");
        callPayload.setMethodName("sayHello");
        callPayload.setParameterTypes(new String[]{"java.lang.String", "java.lang.Integer"});
        callPayload.setArgs(new Object[]{"xuyanhua", 12});
        LOGGER.info(JSONObject.toJSONString(callPayload));
    }

    /**
     * JavaBean参数的调用负载
     */
    @Test
    public void testJavaBeanParams() {
        CallPayload callPayload = new CallPayload();
        callPayload.setInterfaceName("com.yanhua.DemoService");
        callPayload.setMethodName("sayHello");
        callPayload.setParameterTypes(new String[]{"com.yanhua.StudentBean"});
        Map map = new HashMap();
        map.put("name", "xuyanhua");
        map.put("age", 12);
        callPayload.setArgs(new Object[]{map});
        LOGGER.info(JSONObject.toJSONString(callPayload));
    }


    /**
     * 混合参数的调用负载
     */
    @Test
    public void testMixedParams() {
        CallPayload callPayload = new CallPayload();
        callPayload.setInterfaceName("com.yanhua.DemoService");
        callPayload.setMethodName("validStudent");
        callPayload.setParameterTypes(new String[]{"java.lang.Integer", "com.yanhua.StudentBean"});
        Map map = new HashMap();
        map.put("name", "xuyanhua");
        map.put("age", 12);
        callPayload.setArgs(new Object[]{10, map});
        LOGGER.info(JSONObject.toJSONString(callPayload));
    }

}
