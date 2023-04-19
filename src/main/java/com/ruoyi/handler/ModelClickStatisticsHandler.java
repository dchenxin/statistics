package com.ruoyi.handler;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.ModelClickStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IBusinessStatisticsService;
import com.ruoyi.service.IModelClickStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 模块点击统计执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class ModelClickStatisticsHandler {

    private final IModelClickStatisticsService iModelClickStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<ModelClickStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.YESTODAY.getValue(),(obj)->iModelClickStatisticsService.getModelClickStatisticsByDay());
        map.put(DateParamEnums.SEVEN_DAY.getValue(),(obj)->iModelClickStatisticsService.getModelClickStatisticsBySevenDay());
        map.put(DateParamEnums.MONTH.getValue(),(obj)->iModelClickStatisticsService.getModelClickStatisticsByMonth());
        map.put(DateParamEnums.YEAR.getValue(),(obj)->iModelClickStatisticsService.getModelClickStatisticsByYear());
    }

    /**
     * 执行查询
     * @return
     */
    public List<ModelClickStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
