package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.OprationStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 运营统计Service接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface IOprationStatisticsService extends IService<OprationStatistics> {
    /**
     * 获取小程序运营情况数据统计(日)
     * @return
     */
    List<OprationStatistics> getOprationStatisticsByDay();

    /**
     * 获取小程序运营情况数据统计(近七日)
     * @return
     */
    List<OprationStatistics> getOprationStatisticsBySevenDay();

    /**
     * 获取小程序运营情况数据统计(月)
     * @return
     */
    List<OprationStatistics> getOprationStatisticsByMonth();

    /**
     * 获取小程序运营情况数据统计(年)
     * @return
     */
    List<OprationStatistics> getOprationStatisticsByYear();
}
