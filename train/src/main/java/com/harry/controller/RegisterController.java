package com.harry.controller;

import com.harry.enums.UserEnum;
import com.harry.pojo.UserInfo;
import com.harry.service.EmailService;
import com.harry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: train
 * @description:
 * @author: Harry
 **/
@Controller
public class RegisterController {
    /**
     * @Description: 前往注册界面
     * @Param: []
     * @return: java.lang.String
     * @Author: Harry
     * @Date: 2018/9/14
     */
    @RequestMapping("/registerPage")
    public String registerPage() {
        return "register";
    }


    @Autowired
    private UserService userService;


    /**
     * @Description: 注册操作
     * @Param: [userInfo]
     * @return: java.lang.String
     * @Author: Harry
     * @Date: 2018/9/14
     */
    @RequestMapping("/register")
    public String register(UserInfo userInfo, Map<String, Object> map) {
        String message = userService.insertUser(userInfo);
        if (message.equals("邮件已经发送") || message.equals("邮件时发生异常！请重试")) {
            map.put("message", message);
            return "success";
        } else if (message.equals(UserEnum.EMAIL_ERROR.getMessage())) {
            userInfo.setUserEmail(null);
        } else {
            userInfo.setUserName(null);
        }
        map.put("userInfo", userInfo);
        map.put("message", message);
        return "/register";
    }

    @Autowired
    private EmailService emailService;

    /**
    * @Description: 邮箱验证
    * @Param: [emailCode]
    * @return: java.lang.String
    * @Author: Harry
    */
    @RequestMapping("/emailCheck/{emailCode}")
    public String emailCheck(@PathVariable String emailCode, Map<String, Object> map) {
        String check = emailService.emailCheck(emailCode);
        map.put("message", check);
        return "/success";
    }
}
