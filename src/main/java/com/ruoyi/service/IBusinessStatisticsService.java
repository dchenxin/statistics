package com.ruoyi.service;

import java.util.List;
import com.ruoyi.domain.BusinessStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 业务统计Service接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface IBusinessStatisticsService extends IService<BusinessStatistics> {

    /**
     * 获取运营情况数据统计(日)
     * @return
     */
    List<BusinessStatistics> getBusinessStatisticsByDay();

    /**
     * 获取运营情况数据统计(近七日)
     * @return
     */
    List<BusinessStatistics> getBusinessStatisticsBySevenDay();

    /**
     * 获取运营情况数据统计(月)
     * @return
     */
    List<BusinessStatistics> getBusinessStatisticsByMonth();

    /**
     * 获取运营情况数据统计(年)
     * @return
     */
    List<BusinessStatistics> getBusinessStatisticsByYear();
}
