package com.harry.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: harry
 * @description:
 * @author: Harry
 **/
@Entity
@Data
public class TrainInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;

    private String trainName;

    private String trainLocation;

    private String trainTime;

    private Date trainDate;
}
