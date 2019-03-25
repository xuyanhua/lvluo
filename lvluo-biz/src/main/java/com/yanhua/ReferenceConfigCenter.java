package com.yanhua;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/14 下午12:24
 */
public class ReferenceConfigCenter {
    private static Map<String, ReferenceConfig<GenericService>> referenceConfigMap = new ConcurrentHashMap<>();

    @Value("zk")
    private String zk = "zookeeper://127.0.0.1:2181";
    private static final String applicationName = "dubbo-warpper";

    private ReferenceConfigCenter() {
    }
    private static class Inner{
        public static ReferenceConfigCenter instance = new ReferenceConfigCenter();
    }


    public GenericService get(String interfaceName) {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName(applicationName);

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(zk);

        ReferenceConfig<GenericService> reference = referenceConfigMap.get(interfaceName);
        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        if (reference == null) {
            // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
            reference = new ReferenceConfig<>();
            reference.setApplication(application);
            // 多个注册中心可以用setRegistries()
            reference.setRegistry(registry);
            reference.setInterface(interfaceName);
            reference.setGeneric(true);
            referenceConfigMap.put(interfaceName, reference);
        }
        GenericService genericService = reference.get();
        return genericService;
    }

    public static ReferenceConfigCenter getInstance() {
        return Inner.instance;
    }
}
