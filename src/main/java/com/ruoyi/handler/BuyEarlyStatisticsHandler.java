package com.ruoyi.handler;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.BuyEarlyStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IBusinessStatisticsService;
import com.ruoyi.service.IBuyEarlyStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 提前购票执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class BuyEarlyStatisticsHandler {

    private final IBuyEarlyStatisticsService iBuyEarlyStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<BuyEarlyStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.YESTODAY.getValue(),(obj)->iBuyEarlyStatisticsService.getBuyEarlyStatisticsByDay());
        map.put(DateParamEnums.SEVEN_DAY.getValue(),(obj)->iBuyEarlyStatisticsService.getBuyEarlyStatisticsBySevenDay());
        map.put(DateParamEnums.MONTH.getValue(),(obj)->iBuyEarlyStatisticsService.getBuyEarlyStatisticsByMonth());
        map.put(DateParamEnums.YEAR.getValue(),(obj)->iBuyEarlyStatisticsService.getBuyEarlyStatisticsByYear());
    }

    /**
     * 执行查询
     * @return
     */
    public List<BuyEarlyStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
