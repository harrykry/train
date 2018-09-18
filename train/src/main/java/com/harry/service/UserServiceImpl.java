package com.harry.service;

import com.harry.enums.UserEnum;
import com.harry.pojo.UserInfo;
import com.harry.repository.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @program: train
 * @description:
 * @author: Harry
 * @create: 2018-09-11 18:48
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
    * @Description: 根据姓名密码查询用户
    * @Param: [name, password]
    * @return: com.harry.pojo.UserInfo
    * @Author: Harry
    * @Date: 2018/9/14
    */
    @Override
    public String findUserByNameAndPassword(String name, String password) {
        UserInfo user = userInfoRepository.findByUserNameAndUserPassword(name, password);
        if (user == null) {
            return UserEnum.NOT_EXIST.getMessage();
        }
        if (user.getUserStatus().equals(UserEnum.UNACTIVATED.getCode())) {
            return UserEnum.UNACTIVATED.getMessage();
        }
        return UserEnum.LOGIN_SUCCESS.getMessage();
    }

    @Autowired
    EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
    * @Description: 注册用户
    * @Param: [userInfo]
    * @return: java.lang.Integer
    * @Author: Harry
    * @Date: 2018/9/14
    */
    @Override
    public String insertUser(UserInfo userInfo) {

        //唯一性验证
        UserInfo byUserName = userInfoRepository.findByUserName(userInfo.getUserName());
        if (byUserName != null) {
            return UserEnum.NAME_ERROR.getMessage();
        }
        UserInfo byUserEmail = userInfoRepository.findByUserEmail(userInfo.getUserEmail());
        if (byUserEmail != null) {
            return UserEnum.EMAIL_ERROR.getMessage();
        }

        userInfo.setUserLevel(UserEnum.USER.getCode());
        userInfo.setUserStatus(UserEnum.UNACTIVATED.getCode());
        String emailCode = UUID.randomUUID().toString();
        userInfo.setUserEmailCode(emailCode);

        String emailSubject = "注册验证";
        String emailContent = "http://localhost:8080/emailCheck/"+emailCode;

        String message = emailService.sendSimpleMail(userInfo.getUserEmail(), emailSubject, emailContent);
        if (message.equals("邮件时发生异常！请重试")) {
            return message;
        }
        UserInfo userInfoNew = new UserInfo();
        BeanUtils.copyProperties(userInfo, userInfoNew);

        userInfoNew.setUserPassword(passwordEncoder.encode(userInfo.getUserPassword()));
        userInfoRepository.save(userInfoNew);
        return message;
    }
}
