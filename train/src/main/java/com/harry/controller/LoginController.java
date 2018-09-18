package com.harry.controller;

import com.harry.enums.UserEnum;
import com.harry.pojo.UserInfo;
import com.harry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: train
 * @description:
 * @author: Harry
 * @create: 2018-09-11 18:32
 **/
@Controller
public class LoginController {

    /**
    * @Description: 前往登陆界面
    * @Param: []
    * @return: java.lang.String
    * @Author: Harry
    * @Date: 2018/9/14
    */
    @RequestMapping({"/", "loginPage"})
    public String loginPage() {
        return "login";
    }


    @Autowired
    private UserService userService;


    /**
    * @Description: 登陆操作
    * @Param: [userName, userPassword]
    * @return: java.lang.String
    * @Author: Harry
    * @Date: 2018/9/14
    */
//    @RequestMapping("/login")
//    public String login(@RequestParam String userName, @RequestParam String userPassword, Map<String, Object> map) {
//        String message = userService.findUserByNameAndPassword(userName, userPassword);
//        if (!message.equals(UserEnum.LOGIN_SUCCESS.getMessage())) {
//            map.put("message", message);
//            return "login";
//        }
//        return "train";
//    }

    @RequestMapping("/loginError")
    public String loginError(@RequestParam String userName, @RequestParam String userPassword, Map<String, Object> map) {
        String message = userService.findUserByNameAndPassword(userName, userPassword);

            map.put("message", message);
        System.out.println("----------");
            return "train";

    }




}
