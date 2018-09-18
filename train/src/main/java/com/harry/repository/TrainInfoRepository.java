package com.harry.repository;


import com.harry.pojo.TrainInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: harry
 * @description:
 * @author: Harry
 **/

public interface TrainInfoRepository extends JpaRepository<TrainInfo, Integer> {
    List<TrainInfo> findByTrainLocationLike(String s);
}
