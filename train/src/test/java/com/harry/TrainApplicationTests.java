package com.harry;

import com.harry.pojo.TrainInfo;
import com.harry.repository.TrainInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainApplicationTests {

    @Autowired
    private TrainInfoRepository trainInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        List<TrainInfo> byTrainLocationLike = trainInfoRepository.findByTrainLocationLike("%北京%xia%");
        System.out.println(byTrainLocationLike);



    }

    @Test
    public void demo() {
        String encode = passwordEncoder.encode("1111");
        System.out.println(encode);
    }
}
