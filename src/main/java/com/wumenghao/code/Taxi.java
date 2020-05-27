package com.wumenghao.code;

import com.wumenghao.code.strategy.taxi.TaxiPayParam;
import com.wumenghao.code.strategy.taxi.TaxiPayStrategy;

import java.math.BigDecimal;

public class Taxi implements Transportation<TaxiPayStrategy,TaxiPayParam>{
    private TaxiPayStrategy payStrategy;

    public Taxi(TaxiPayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public BigDecimal getPayAmount(TaxiPayParam payParam) {
        return payStrategy.computePay(payParam);
    }

    public void setPayStrategy(TaxiPayStrategy payStrategy) {
        this.payStrategy=payStrategy;
    }

    public TaxiPayStrategy getPayStrategy() {
        return this.payStrategy;
    }
}
