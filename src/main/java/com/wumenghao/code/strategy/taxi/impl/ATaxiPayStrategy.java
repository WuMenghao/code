package com.wumenghao.code.strategy.taxi.impl;

import com.wumenghao.code.strategy.DistStrategyTypeEnum;
import com.wumenghao.code.strategy.taxi.DistStrategy;
import com.wumenghao.code.strategy.taxi.TaxiPayParam;
import com.wumenghao.code.strategy.taxi.TaxiPayStrategy;
import com.wumenghao.code.strategy.taxi.TimeStrategy;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ATaxiPayStrategy extends TaxiPayStrategy {
    public ATaxiPayStrategy() {
        this.timeStrategies = new ArrayList<TimeStrategy>();

        TimeStrategy day = new TimeStrategy(6, 18);
        LinkedList<DistStrategy> dayDists = new LinkedList<DistStrategy>();
        dayDists.add(new DistStrategy(new BigDecimal(0), new BigDecimal(3), new BigDecimal(14), DistStrategyTypeEnum.BASE_PAY));
        dayDists.add(new DistStrategy(new BigDecimal(3), new BigDecimal(10), new BigDecimal(2.5), DistStrategyTypeEnum.PLUS_PAY));
        dayDists.add(new DistStrategy(new BigDecimal(10), BigDecimal.valueOf(Double.MAX_VALUE), new BigDecimal(3.5),DistStrategyTypeEnum.PLUS_PAY));
        day.setDistStrategies(dayDists);

        TimeStrategy night1 = new TimeStrategy(0, 6);
        TimeStrategy night2 = new TimeStrategy(18, 24);
        LinkedList<DistStrategy> nightDists = new LinkedList<DistStrategy>();
        nightDists.add(new DistStrategy(new BigDecimal(0), new BigDecimal(3), new BigDecimal(18),DistStrategyTypeEnum.BASE_PAY));
        nightDists.add(new DistStrategy(new BigDecimal(3), new BigDecimal(10), new BigDecimal(3),DistStrategyTypeEnum.PLUS_PAY));
        nightDists.add(new DistStrategy(new BigDecimal(10), BigDecimal.valueOf(Double.MAX_VALUE), new BigDecimal(4.7),DistStrategyTypeEnum.PLUS_PAY));
        night1.setDistStrategies(nightDists);
        night2.setDistStrategies(nightDists);

        timeStrategies.add(day);
        timeStrategies.add(night1);
        timeStrategies.add(night2);
    }

    @Override
    public BigDecimal computePay(TaxiPayParam payParam) {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal distance = payParam.getDistance();
        if (timeStrategies!=null && timeStrategies.size()>0){
            for(TimeStrategy timeStrategy:timeStrategies){
                if (timeStrategy.matches(payParam.getEndTime())){
                    LinkedList<DistStrategy> distStrategies = timeStrategy.getDistStrategies();
                    if (distStrategies!=null && distStrategies.size()>0){
                        for(DistStrategy distStrategy:distStrategies){
                            if (distStrategy.matches(distance)){
                                total = distStrategy.costAddOperate(total,distance);
                            }
                        }
                    }
                }
            }
        }
        return total.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
