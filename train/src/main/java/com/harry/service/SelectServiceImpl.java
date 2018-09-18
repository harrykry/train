package com.harry.service;

import com.harry.pojo.TrainInfo;
import com.harry.repository.TrainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: harry
 * @description:
 * @author: Harry
 **/

public class SelectServiceImpl implements SelectService {
    @Autowired
    private TrainInfoRepository trainInfoRepository;

    public List<TrainInfo> findAll(String locationStart, String locationFinal) {
        List<TrainInfo> byTrainLocationLike = trainInfoRepository.findByTrainLocationLike("%" + locationStart + "%" + locationFinal + "%");

        

        return null;
    }
}
