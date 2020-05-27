##出租车收费问题解决方案

###（1）主要组件
```
interface:
    Transportation   : 交通工具接口，可以用于扩展交通工具类别 getPayAmount 方法可获得最后支付额
    PayStrategy      : 收费策略接口，不同交通工具中聚合不同类别的实现
    PayParam         : 收费计算时传入的参数接口，不同交通工具中聚合不同类别的实现
abstractClass:
    TaxiPayStrategy  : 出租车收费策略抽象类，里面聚合了TimeStrategy链
class:
    Taxi             : Transportation的实现类
    ATaxPayStrategy  : A类出租车收费策略
    TaxiPayPatam     : 收费参数
    TimeStrategy     : 计程车的时间策略，聚合了DistStrategy策略链
    DistStrategy     : 计程车的里程策略，最底层的计费策略
```

### (2)使用示例

```
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime startTime = LocalDateTime.parse("2020-05-25 12:30", formatter);
LocalDateTime endTime = LocalDateTime.parse("2020-05-25 13:30", formatter);
//实例化ATaxiPayStrategy
ATaxiPayStrategy aTaxiPayStrategy = new ATaxiPayStrategy();
//实例化Taxi
Taxi taxi = new Taxi(aTaxiPayStrategy);
//传统计算参数得到结果
BigDecimal payAmount = taxi.getPayAmount(new TaxiPayParam(
        Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()),
        Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()),
        new BigDecimal(65.5)
));

```

###(3)扩展方式
    
    (1)当出租车的时段、计程段需要扩展时
    以甲类计程车为例，只需要修改ATaxiPayStrategy的TimeStrategy链以及TimeStratege
    中的DistStratege链中添加自定义的TimeStrategy或DistStratege即可实现扩展
    
    (2)当需要新增计程车类型时
    参照ATaxiPayStrategy新建新的TaxyPayStategy类的子类