package com.ruoyi.handler;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IBusinessStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 业务统计执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class BusinessStatisticsHandler {

    private final IBusinessStatisticsService iBusinessStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<BusinessStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.YESTODAY.getValue(),(obj)->iBusinessStatisticsService.getBusinessStatisticsByDay());
        map.put(DateParamEnums.SEVEN_DAY.getValue(),(obj)->iBusinessStatisticsService.getBusinessStatisticsBySevenDay());
        map.put(DateParamEnums.MONTH.getValue(),(obj)->iBusinessStatisticsService.getBusinessStatisticsByMonth());
        map.put(DateParamEnums.YEAR.getValue(),(obj)->iBusinessStatisticsService.getBusinessStatisticsByYear());
    }

    /**
     * 执行查询
     * @return
     */
    public List<BusinessStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
