package com.harry.service;

import com.harry.pojo.UserInfo;

/**
 * @program: train
 * @description:
 * @author: Harry
 * @create: 2018-09-14 14:32
 **/

public interface EmailService {
    String sendSimpleMail(String to, String subject, String content);

    String emailCheck(String emailCode);
}
