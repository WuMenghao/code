package com.wumenghao.code.strategy.taxi;

import com.wumenghao.code.strategy.PayStrategy;

import java.util.List;

public abstract class TaxiPayStrategy implements PayStrategy<TaxiPayParam> {
    protected List<TimeStrategy> timeStrategies;
}
