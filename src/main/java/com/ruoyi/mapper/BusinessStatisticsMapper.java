package com.ruoyi.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.domain.BusinessStatistics;

/**
 * 业务统计Mapper接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface BusinessStatisticsMapper extends BaseMapper<BusinessStatistics> {
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
