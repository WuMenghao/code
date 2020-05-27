package com.wumenghao.code.strategy.taxi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;

public class TimeStrategy {
    private Integer payTimeGt;
    private Integer payTimeLt;
    private LinkedList<DistStrategy> distStrategies;

    public TimeStrategy(Integer payTimeGt, Integer payTimeLt) {
        this.payTimeGt = payTimeGt;
        this.payTimeLt = payTimeLt;
    }

    public boolean matches(Date endTime){
        Instant instant = endTime.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        boolean rs = payTimeGt < localDateTime.getHour() && localDateTime.getHour() <= payTimeLt;
        return rs;
    }

    public Integer getPayTimeGt() {
        return payTimeGt;
    }

    public void setPayTimeGt(Integer payTimeGt) {
        this.payTimeGt = payTimeGt;
    }

    public Integer getPayTimeLt() {
        return payTimeLt;
    }

    public void setPayTimeLt(Integer payTimeLt) {
        this.payTimeLt = payTimeLt;
    }

    public LinkedList<DistStrategy> getDistStrategies() {
        return distStrategies;
    }

    public void setDistStrategies(LinkedList<DistStrategy> distStrategies) {
        this.distStrategies = distStrategies;
    }
}
