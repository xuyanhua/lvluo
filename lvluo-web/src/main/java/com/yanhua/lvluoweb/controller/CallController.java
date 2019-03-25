package com.yanhua.lvluoweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yanhua.CallService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午3:11
 */
@RestController
public class CallController {

    @PostMapping(value = "/call", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object call(String interfaceName, String methodName, String parameterTypes, String args) {
        try {
            Object[] argsArr = null;
            if (parameterTypes.startsWith("java.lang")) {
                argsArr = args.split(",");
            } else {
                argsArr = new Object[]{JSONObject.parseObject(args).toJavaObject(Map.class)};
            }
            Object result = CallService.call(interfaceName, methodName, parameterTypes.split(","), argsArr);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
