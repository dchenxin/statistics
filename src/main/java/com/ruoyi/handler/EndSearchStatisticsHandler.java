package com.ruoyi.handler;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.EndSearchRateStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IBusinessStatisticsService;
import com.ruoyi.service.IEndSearchRateStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 终点站搜索统计执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class EndSearchStatisticsHandler {

    private final IEndSearchRateStatisticsService iEndSearchRateStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<EndSearchRateStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.YESTODAY.getValue(),(obj)->iEndSearchRateStatisticsService.getEndSearchRateStatisticsByDay());
        map.put(DateParamEnums.SEVEN_DAY.getValue(),(obj)->iEndSearchRateStatisticsService.getEndSearchRateStatisticsBySevenDay());
        map.put(DateParamEnums.MONTH.getValue(),(obj)->iEndSearchRateStatisticsService.getEndSearchRateStatisticsByMonth());
        map.put(DateParamEnums.YEAR.getValue(),(obj)->iEndSearchRateStatisticsService.getEndSearchRateStatisticsByYear());
    }

    /**
     * 执行查询
     * @return
     */
    public List<EndSearchRateStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
