package com.yanhua;

import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * Hello world!
 */
public class CallService {

    public static Object call(String interfaceName, String methodName, String[] parameterTypes, Object[] args) {
        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = ReferenceConfigCenter.getInstance().get(interfaceName);

        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke(methodName, parameterTypes, args);

        System.out.println("api调用返回：" + result);
        // 用Map表示POJO参数，如果返回值为POJO也将自动转成Map
//        Map<String, Object> person = new HashMap<String, Object>();
//        person.put("name", "xxx");
//        person.put("password", "yyy");
//// 如果返回POJO将自动转成Map
//        Object result = genericService.$invoke("findPerson", new String[]{"com.xxx.Person"}, new Object[]{person});
        return result;
    }

    public static void main(String[] args) {
        String interfaceName = "com.yanhua.DemoService";
        String methodName = "sayHello";
        String[] parameterTypes = new String[]{"java.lang.String"};
        Object[] args0 = new Object[]{"world"};
        call(interfaceName, methodName, parameterTypes, args0);
    }
}
