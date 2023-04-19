package com.ruoyi.mapper;

import java.util.List;

import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.StartSearchRateStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 起始站搜索频率统计Mapper接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface StartSearchRateStatisticsMapper extends BaseMapper<StartSearchRateStatistics> {

    /**
     * 获取起始站搜索频率数据统计(日)
     * @return
     */
    List<StartSearchRateStatistics> getStartSearchRateStatisticsByDay();

    /**
     * 获取起始站搜索频率数据统计(近七日)
     * @return
     */
    List<StartSearchRateStatistics> getStartSearchRateStatisticsBySevenDay();

    /**
     * 获取起始站搜索频率数据统计(月)
     * @return
     */
    List<StartSearchRateStatistics> getStartSearchRateStatisticsByMonth();

    /**
     * 获取起始站搜索频率据统计(年)
     * @return
     */
    List<StartSearchRateStatistics> getStartSearchRateStatisticsByYear();

}
