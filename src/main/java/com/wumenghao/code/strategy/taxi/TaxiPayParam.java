package com.wumenghao.code.strategy.taxi;


import com.wumenghao.code.strategy.PayParam;

import java.math.BigDecimal;
import java.util.Date;

public class TaxiPayParam implements PayParam {
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //距离里程
    private BigDecimal distance;

    public TaxiPayParam(Date startTime, Date endTime,  BigDecimal distance) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
