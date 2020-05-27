package com.wumenghao.code.strategy.taxi;

import com.wumenghao.code.strategy.DistStrategyTypeEnum;

import java.math.BigDecimal;

public class DistStrategy {
    private BigDecimal distGt;
    private BigDecimal distLt;
    private BigDecimal costs;
    private DistStrategyTypeEnum type;

    public DistStrategy(BigDecimal distGt, BigDecimal distLt, BigDecimal costs, DistStrategyTypeEnum type) {
        this.distGt = distGt;
        this.distLt = distLt;
        this.costs = costs;
        this.type = type;
    }

    public boolean matches(BigDecimal dist){
        return dist.compareTo(distGt) >0;
    }

    public BigDecimal costAddOperate(BigDecimal result,BigDecimal dist){
        if (DistStrategyTypeEnum.BASE_PAY.equals(type)){
            return result.add(costs);
        }
        if (dist.compareTo(distLt)>0){
            result = result.add(distLt.subtract(distGt).multiply(costs));
        }else {
            result = result.add(dist.subtract(distGt).multiply(costs));
        }
        return result;
    }
}
