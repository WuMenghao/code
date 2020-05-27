package com.wumenghao.test;

import com.wumenghao.code.Taxi;
import com.wumenghao.code.strategy.taxi.TaxiPayParam;
import com.wumenghao.code.strategy.taxi.impl.ATaxiPayStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {
    @Test
    public void taxiADay(){
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

        BigDecimal expect = new BigDecimal(14)
                .add(new BigDecimal(2.5).multiply(new BigDecimal(7)))
                .add(new BigDecimal(3.5).multiply(new BigDecimal(55.5))).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(expect.toString());
        Assert.assertEquals(payAmount,expect);
    }

    @Test
    public void taxiANight(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse("2020-05-25 18:30", formatter);
        LocalDateTime endTime = LocalDateTime.parse("2020-05-25 23:30", formatter);
        ATaxiPayStrategy aTaxiPayStrategy = new ATaxiPayStrategy();
        Taxi taxi = new Taxi(aTaxiPayStrategy);
        BigDecimal payAmount = taxi.getPayAmount(new TaxiPayParam(
                Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()),
                new BigDecimal(8)
        ));
        System.out.println(payAmount.toString());

        BigDecimal expect = new BigDecimal(18)
                .add(new BigDecimal(3).multiply(new BigDecimal(5)))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(expect.toString());
        Assert.assertEquals(payAmount,expect);
    }
}
