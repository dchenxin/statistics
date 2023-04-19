package com.ruoyi.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.domain.BuyEarlyStatistics;

/**
 * 提前购票统计Mapper接口
 *
 * @author luz
 * @date 2023-03-06
 */
public interface BuyEarlyStatisticsMapper extends BaseMapper<BuyEarlyStatistics> {
    /**
     * 获取提前购票数据统计(日)
     * @return
     */
    List<BuyEarlyStatistics> getBuyEarlyStatisticsByDay();

    /**
     * 获取提前购票数据统计(近七日)
     * @return
     */
    List<BuyEarlyStatistics> getBuyEarlyStatisticsBySevenDay();

    /**
     * 获取提前购票数据统计(月)
     * @return
     */
    List<BuyEarlyStatistics> getBuyEarlyStatisticsByMonth();

    /**
     * 获取提前购票数据统计(年)
     * @return
     */
    List<BuyEarlyStatistics> getBuyEarlyStatisticsByYear();
}
