package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.BuyEarlyStatisticsMapper;
import com.ruoyi.domain.BuyEarlyStatistics;
import com.ruoyi.service.IBuyEarlyStatisticsService;

/**
 * 提前购票统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class BuyEarlyStatisticsServiceImpl extends ServiceImpl<BuyEarlyStatisticsMapper, BuyEarlyStatistics> implements IBuyEarlyStatisticsService {
    @Autowired
    private BuyEarlyStatisticsMapper buyEarlyStatisticsMapper;

    @Override
    public List<BuyEarlyStatistics> getBuyEarlyStatisticsByDay() {
        return buyEarlyStatisticsMapper.getBuyEarlyStatisticsByDay();
    }

    @Override
    public List<BuyEarlyStatistics> getBuyEarlyStatisticsBySevenDay() {
        return buyEarlyStatisticsMapper.getBuyEarlyStatisticsBySevenDay();
    }

    @Override
    public List<BuyEarlyStatistics> getBuyEarlyStatisticsByMonth() {
        return buyEarlyStatisticsMapper.getBuyEarlyStatisticsByMonth();
    }

    @Override
    public List<BuyEarlyStatistics> getBuyEarlyStatisticsByYear() {
        return buyEarlyStatisticsMapper.getBuyEarlyStatisticsByYear();
    }
}
