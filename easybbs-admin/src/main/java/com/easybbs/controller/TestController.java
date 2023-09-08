package com.easybbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyt
 * @date 2023/9/8 16:55
 */

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "h分为11";
    }
}
