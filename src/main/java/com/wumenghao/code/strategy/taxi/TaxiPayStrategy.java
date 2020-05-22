package com.wumenghao.code.strategy.taxi;

import com.wumenghao.code.strategy.PayStrategy;

public abstract class TaxiPayStrategy implements PayStrategy {
    private TimeRage timeRage;
    private DistRange distRange;

    public TaxiPayStrategy(TimeRage timeRage, DistRange distRange) {
        this.timeRage = timeRage;
        this.distRange = distRange;
    }

    public abstract void getPay();
}
