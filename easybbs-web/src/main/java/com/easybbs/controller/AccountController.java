package com.easybbs.controller;

import com.easybbs.controller.base.BaseController;
import com.easybbs.entity.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author cyt
 * @date 2023/9/8 20:07
 */

@RestController
public class AccountController extends BaseController {
    @RequestMapping("/test")
    public ResponseVO test(Integer userId) {
        HashMap<String, Object> test = new HashMap<>();
        test.put("name", "张三");
        test.put("age", "userId");
        Integer a = null;
        return getSuccessResponseVO(a.equals("test"));
    }
}
