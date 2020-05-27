package com.wumenghao.code.strategy.taxi;

import java.math.BigDecimal;

public class DistStrategy {
    private BigDecimal distGt;
    private BigDecimal distLt;
    private BigDecimal costs;

    public DistStrategy(BigDecimal distGt, BigDecimal distLt, BigDecimal costs) {
        this.distGt = distGt;
        this.distLt = distLt;
        this.costs = costs;
    }

    public boolean matches(BigDecimal dist){
        return dist.compareTo(distGt) >0;
    }

    public BigDecimal costAddOperate(BigDecimal result,BigDecimal dist){
        if (dist.compareTo(distLt)>0){
            result = result.add(distLt.subtract(distGt).multiply(costs));
        }else {
            result = result.add(dist.subtract(distGt).multiply(costs));
        }
        return result;
    }
}
