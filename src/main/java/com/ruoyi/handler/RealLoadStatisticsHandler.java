package com.ruoyi.handler;

import com.ruoyi.domain.RealLoadStatistics;
import com.ruoyi.domain.enums.DateParamEnums;
import com.ruoyi.service.IRealLoadStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 实载率统计执行
 * @author dcx
 */
@Component
@AllArgsConstructor
public class RealLoadStatisticsHandler {

    private final IRealLoadStatisticsService iRealLoadStatisticsService;

    private final ConcurrentHashMap<String, Function<Object,List<RealLoadStatistics>>> map = new ConcurrentHashMap<>();

    @PostConstruct
    private void init(){
        map.put(DateParamEnums.YESTODAY.getValue(),(obj)->iRealLoadStatisticsService.getRealLoadStatisticsByDay());
        map.put(DateParamEnums.TODAY.getValue(),(obj)->iRealLoadStatisticsService.getRealLoadStatisticsByToDay());
    }

    /**
     * 执行查询
     * @return
     */
    public List<RealLoadStatistics> execute(String type){
       return map.get(type).apply(type);
    }
}
