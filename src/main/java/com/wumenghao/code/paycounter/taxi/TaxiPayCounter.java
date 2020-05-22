package com.wumenghao.code.paycounter.taxi;

import com.wumenghao.code.Taxi;
import com.wumenghao.code.paycounter.AbstractTransportationPayCounter;

public class TaxiPayCounter extends AbstractTransportationPayCounter<Taxi> {
    public TaxiPayCounter(Taxi transportation) {
        super(transportation);
    }
}
