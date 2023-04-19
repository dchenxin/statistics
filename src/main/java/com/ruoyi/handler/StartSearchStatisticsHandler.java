package com.ruoyi.handler;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.StartSearchRateStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IBusinessStatisticsService;
import com.ruoyi.service.IStartSearchRateStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 起始站搜索统计执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class StartSearchStatisticsHandler {

    private final IStartSearchRateStatisticsService iStartSearchRateStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<StartSearchRateStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.YESTODAY.getValue(),(obj)->iStartSearchRateStatisticsService.getStartSearchRateStatisticsByDay());
        map.put(DateParamEnums.SEVEN_DAY.getValue(),(obj)->iStartSearchRateStatisticsService.getStartSearchRateStatisticsBySevenDay());
        map.put(DateParamEnums.MONTH.getValue(),(obj)->iStartSearchRateStatisticsService.getStartSearchRateStatisticsByMonth());
        map.put(DateParamEnums.YEAR.getValue(),(obj)->iStartSearchRateStatisticsService.getStartSearchRateStatisticsByYear());
    }

    /**
     * 执行查询
     * @return
     */
    public List<StartSearchRateStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
