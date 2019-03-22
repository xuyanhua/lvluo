package com.yanhua.lvluoweb.controller;

import com.yanhua.CallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午3:11
 */
@Controller
@RestController
public class CallController {

    @PostMapping("/call")
    public String call(String interfaceName, String methodName, String parameterTypes, String args) {
        String result = CallService.call(interfaceName, methodName, parameterTypes.split(","), args.split(","));
        return result;
    }
}
