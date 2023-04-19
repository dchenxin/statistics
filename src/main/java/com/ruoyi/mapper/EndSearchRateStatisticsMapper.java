package com.ruoyi.mapper;

import java.util.List;
import com.ruoyi.domain.EndSearchRateStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.domain.StartSearchRateStatistics;

/**
 * 终点站搜索频率统计Mapper接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface EndSearchRateStatisticsMapper extends BaseMapper<EndSearchRateStatistics> {
    /**
     * 获取起始站搜索频率数据统计(日)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsByDay();

    /**
     * 获取起始站搜索频率数据统计(近七日)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsBySevenDay();

    /**
     * 获取起始站搜索频率数据统计(月)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsByMonth();

    /**
     * 获取起始站搜索频率据统计(年)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsByYear();
}
