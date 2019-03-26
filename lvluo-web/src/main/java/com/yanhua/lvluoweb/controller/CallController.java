package com.yanhua.lvluoweb.controller;

import com.yanhua.CallService;
import com.yanhua.lvluoweb.CallPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Object call(@RequestBody CallPayload callPayload) {
        String interfaceName = callPayload.getInterfaceName();
        String methodName = callPayload.getMethodName();
        String[] parameterTypes = callPayload.getParameterTypes();
        Object[] args = callPayload.getArgs();
        Map<String, String> option = callPayload.getOption();
        try {
            Object result = CallService.call(interfaceName, methodName, parameterTypes, args,option);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
