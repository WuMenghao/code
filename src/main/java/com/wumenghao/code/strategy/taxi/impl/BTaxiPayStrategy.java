package com.wumenghao.code.strategy.taxi.impl;

import com.wumenghao.code.strategy.taxi.DistRange;
import com.wumenghao.code.strategy.taxi.TaxiPayStrategy;
import com.wumenghao.code.strategy.taxi.TimeRage;

public class BTaxiPayStrategy extends TaxiPayStrategy {
    public BTaxiPayStrategy(TimeRage timeRage, DistRange distRange) {
        super(timeRage, distRange);
    }

    public void getPay() {

    }
}
