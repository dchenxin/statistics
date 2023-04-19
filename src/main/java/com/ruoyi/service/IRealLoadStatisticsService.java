package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.RealLoadStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实载率统计Service接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface IRealLoadStatisticsService extends IService<RealLoadStatistics> {
    /**
     * 获取实载率数据统计(昨日)
     * @return
     */
    List<RealLoadStatistics> getRealLoadStatisticsByDay();

    /**
     * 获取实载率数据统计(今日)
     * @return
     */
    List<RealLoadStatistics> getRealLoadStatisticsByToDay();

}
