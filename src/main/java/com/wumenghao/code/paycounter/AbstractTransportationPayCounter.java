package com.wumenghao.code.paycounter;

import com.wumenghao.code.Transportation;

public abstract class AbstractTransportationPayCounter<T extends Transportation> {
    protected T transportation;

    public AbstractTransportationPayCounter(T transportation) {
        this.transportation = transportation;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(T transportation) {
        this.transportation = transportation;
    }
}
