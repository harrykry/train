package com.harry.repository;

import com.harry.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: train
 * @description:
 * @author: Harry
 * @create: 2018-09-11 18:13
 **/

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo findByUserNameAndUserPassword(String username, String password);

    UserInfo findByUserEmail(String userEmail);

    UserInfo findByUserName(String userName);

    UserInfo findByUserEmailCode(String userEmailCode);

}
