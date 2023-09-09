package com.easybbs.controller;

import com.easybbs.controller.base.BaseController;
import com.easybbs.entity.constants.Constants;
import com.easybbs.entity.dto.CreateImageCode;
import com.easybbs.entity.enums.ResponseCodeEnum;
import com.easybbs.entity.vo.ResponseVO;
import com.easybbs.exception.BusinessException;
import com.easybbs.mappers.UserInfoMapper;
import com.easybbs.service.EmailCodeService;
import com.easybbs.utils.StringTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cyt
 * @date 2023/9/8 20:07
 */

@RestController
@SuppressWarnings({"all"})
public class AccountController extends BaseController {

    @Resource
    private EmailCodeService emailCodeService;

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 验证码
     *
     * @return
     */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session, Integer type) throws IOException {
        CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        // 登录注册
        if (type == null || type == 0) {
            session.setAttribute(Constants.CHECK_CODE_KEY, code);
        } else {
            session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
        }
        vCode.write(response.getOutputStream());
    }


    @RequestMapping("/sendEmailCode")
    public ResponseVO sendEmailCode(HttpSession session, String email, String checkCode, Integer type) throws IOException {
//        if (StringTools.isEmpty(email) || StringTools.isEmpty(checkCode) || type == null) {
//            throw new BusinessException(ResponseCodeEnum.CODE_600);
//        }
        emailCodeService.sendEmailCode(email, type);
        return getSuccessResponseVO(null);
    }

    @RequestMapping("/register")
    public ResponseVO checkCode(HttpSession session, String checkCode) throws IOException {
        if (checkCode == null || "".equals(checkCode)) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }

        String sessionCode = (String) session.getAttribute(Constants.CHECK_CODE_KEY);
        if (sessionCode.equals(checkCode)) {
            return getSuccessResponseVO("验证成功");
        } else {
            throw new BusinessException("验证失败");
        }
    }
}
