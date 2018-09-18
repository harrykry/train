package com.harry.service;

import com.harry.enums.UserEnum;
import com.harry.pojo.UserInfo;
import com.harry.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @program: train
 * @description: 邮箱服务
 * @author: Harry
 * @create: 2018-09-14 14:39
 **/
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender mailSender;

    @Value("${mailAddress}")
    private String from;


    /**
     * @Description: 发送短信
     * @Param: [to, subject, content]
     * @return: void
     * @Author: Harry
     */
    @Override
    public String sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info("简单邮件已经发送。");
            return "邮件已经发送";
        } catch (Exception e) {
            log.error("发送简单邮件时发生异常！", e);
            return "邮件时发生异常！请重试";
        }
    }

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
    * @Description: 邮箱验证
    * @Param: [emailCode]
    * @return: void
    * @Author: Harry
    */
    @Override
    public String emailCheck(String emailCode) {
        UserInfo byUserEmailCode = userInfoRepository.findByUserEmailCode(emailCode);
        if (byUserEmailCode == null) {
            return UserEnum.EMAIL_CODE_ERROR.getMessage();
        }
        byUserEmailCode.setUserStatus(UserEnum.ACTIVATED.getCode());
        byUserEmailCode.setUserEmailCode(null);
        userInfoRepository.save(byUserEmailCode);
        return UserEnum.ACTIVATED.getMessage();
    }
}
