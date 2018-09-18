package com.harry.config;

import com.harry.pojo.UserInfo;
import com.harry.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @program: harry
 * @description:
 * @author: Harry
 **/
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户的用户名: {}", username);
        // TODO 根据用户名，查找到对应的密码，与权限

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        UserInfo user = userInfoRepository.findByUserName(username);
        log.info(user.toString());
        return user;
    }
}
