package com.yanhua.lvluoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/25 下午1:33
 */
@Controller
public class IndexController {
    @RequestMapping("")
    public String index() {
        return "/index";
    }
}
