package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.EndSearchRateStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 终点站搜索频率统计Service接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface IEndSearchRateStatisticsService extends IService<EndSearchRateStatistics> {
    /**
     * 获取终点站搜索频率数据统计(日)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsByDay();

    /**
     * 获取终点站搜索频率数据统计(近七日)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsBySevenDay();

    /**
     * 获取终点站搜索频率数据统计(月)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsByMonth();

    /**
     * 获取终点站搜索频率据统计(年)
     * @return
     */
    List<EndSearchRateStatistics> getEndSearchRateStatisticsByYear();

}
