package com.wumenghao.test;

import com.wumenghao.code.Taxi;
import com.wumenghao.code.strategy.taxi.TaxiPayParam;
import com.wumenghao.code.strategy.taxi.impl.ATaxiPayStrategy;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {
    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse("2020-05-25 12:30", formatter);
        LocalDateTime endTime = LocalDateTime.parse("2020-05-25 13:30", formatter);
        ATaxiPayStrategy aTaxiPayStrategy = new ATaxiPayStrategy();
        Taxi taxi = new Taxi(aTaxiPayStrategy);
        BigDecimal payAmount = taxi.getPayAmount(new TaxiPayParam(
                Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()),
                new BigDecimal(65.5)
        ));
        System.out.println(payAmount.toString());
    }
}
