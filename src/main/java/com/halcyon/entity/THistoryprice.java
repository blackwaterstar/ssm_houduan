package com.halcyon.entity;

import lombok.Data;

import java.util.Date;

@Data
public class THistoryprice {
    private Long thId;

    private Long pid;

    private Long price;

    private Date startTime;

    private Date endTime;


}