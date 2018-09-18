package com.harry.enums;

import lombok.Getter;

/**
 * @program: train
 * @description: 用户信息枚举类
 * @author: Harry
 * @create: 2018-09-14 01:16
 **/
@Getter
public enum UserEnum {
    SUCCESS(0,"注册成功"),
    EMAIL_ERROR(1,"邮箱重复"),
    NAME_ERROR(2, "用户名重复"),
    USER(3, "用户级别"),
    MANAGER(4, "管理员级别"),
    UNACTIVATED(5, "未激活"),
    ACTIVATED(6, "已激活"),
    EMAIL_CODE_ERROR(7, "邮箱验证码错误"),
    NOT_EXIST(8, "账号密码错误"),
    LOGIN_SUCCESS(9, "登陆成功")

    ;


    private Integer code;

    private String message;


    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
