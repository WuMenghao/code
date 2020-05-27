package com.wumenghao.code.strategy.taxi;

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
