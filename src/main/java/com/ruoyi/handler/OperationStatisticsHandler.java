package com.ruoyi.handler;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.OprationStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IBusinessStatisticsService;
import com.ruoyi.service.IOprationStatisticsService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 小程序业务统计执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class OperationStatisticsHandler {

    private final IOprationStatisticsService iOprationStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<OprationStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.SEVEN_DAY.getValue(),(obj)->iOprationStatisticsService.getOprationStatisticsBySevenDay());
        map.put(DateParamEnums.MONTH.getValue(),(obj)->iOprationStatisticsService.getOprationStatisticsByMonth());
        map.put(DateParamEnums.YEAR.getValue(),(obj)->iOprationStatisticsService.getOprationStatisticsByYear());
    }

    /**
     * 执行查询
     * @return
     */
    public List<OprationStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
