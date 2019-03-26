package com.yanhua;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class CallService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CallService.class);

    public static Object call(String interfaceName, String methodName, String[] parameterTypes, Object[] args, Map<String, String> option) {
        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = ReferenceConfigCenter.getInstance().get(interfaceName, option);
        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke(methodName, parameterTypes, args);
        LOGGER.info("api调用返回：{}", result);
        return result;
    }

    public static void main(String[] args) {
        String interfaceName = "com.yanhua.DemoService";
        String methodName = "sayHello";
        String[] parameterTypes = new String[]{"java.lang.String"};
        Object[] args0 = new Object[]{"world"};
        call(interfaceName, methodName, parameterTypes, args0, new HashMap<>());
    }
}
