package com.wumenghao.code.strategy;

import com.wumenghao.code.strategy.PayParam;

import java.math.BigDecimal;

public interface PayStrategy<P extends PayParam> {
    BigDecimal computePay(P payParam);
}
