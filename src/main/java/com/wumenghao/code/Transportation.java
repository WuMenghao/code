package com.wumenghao.code;

import com.wumenghao.code.strategy.PayParam;
import com.wumenghao.code.strategy.PayStrategy;

import java.math.BigDecimal;

public interface Transportation<PS extends PayStrategy,P extends PayParam> {
    BigDecimal getPayAmount(P payParam);
    void setPayStrategy(PS payStrategy);
    PS getPayStrategy();
}
