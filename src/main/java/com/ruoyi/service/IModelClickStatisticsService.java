package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.ModelClickStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 模块点击统计Service接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface IModelClickStatisticsService extends IService<ModelClickStatistics> {
    /**
     * 获取模块点击数据统计(日)
     * @return
     */
    List<ModelClickStatistics> getModelClickStatisticsByDay();

    /**
     * 获取模块点击数据统计(近七日)
     * @return
     */
    List<ModelClickStatistics> getModelClickStatisticsBySevenDay();

    /**
     * 获取模块点击数据统计(月)
     * @return
     */
    List<ModelClickStatistics> getModelClickStatisticsByMonth();

    /**
     * 获取模块点击数据统计(年)
     * @return
     */
    List<ModelClickStatistics> getModelClickStatisticsByYear();
}
