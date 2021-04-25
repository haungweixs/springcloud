package com.huangwei.springcloud.controller;

import com.huangwei.springcloud.bean.req.pay.WeixinpayProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Hw
 * 21/03/08 16:36
 */
@Api(tags = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    WeixinpayProperties weixinpayProperties;


    /**
     * 身份认证测试接口
     * @param request
     * @return
     */
    @ApiOperation(value = "测试")
    @PostMapping("/admin")
    public String admin(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        System.out.println();
        return "success";
    }

    /**
     * 角色认证测试接口
     * @param request
     * @return
     */
    @PostMapping("/student")
    public String student(HttpServletRequest request) {
        return "success";
    }

    /**
     * 权限认证测试接口
     * @param request
     * @return
     */
    @PostMapping("/teacher")
    public String teacher(HttpServletRequest request) {
        return "success";
    }
}