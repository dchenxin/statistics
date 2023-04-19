package com.ruoyi.mapper;

import java.util.List;

import com.ruoyi.domain.ModelClickStatistics;
import com.ruoyi.domain.RealLoadStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 实载率统计Mapper接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface RealLoadStatisticsMapper extends BaseMapper<RealLoadStatistics> {
    /**
     * 获取实载率数据统计(日)
     * @return
     */
    List<RealLoadStatistics> getRealLoadStatisticsByDay();

    /**
     * 获取实载率数据统计(近七日)
     * @return
     */
    List<RealLoadStatistics> getRealLoadStatisticsByToDay();

}
