package com.wumenghao.code;

import com.wumenghao.code.strategy.taxi.TaxiPayStrategy;

public abstract class Taxi implements Transportation{
    protected TaxiPayStrategy payStrategy;
}
