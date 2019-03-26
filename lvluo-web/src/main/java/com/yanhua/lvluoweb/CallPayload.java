package com.yanhua.lvluoweb;

import java.util.Map;

/**
 * 调用载体
 *
 * @author xuyanhua
 * @description:
 * @date 2019/3/25 下午5:23
 */
public class CallPayload {
    private String interfaceName;
    private String methodName;
    private String[] parameterTypes;
    private Object[] args;
    private Map<String, String> option;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }
}
