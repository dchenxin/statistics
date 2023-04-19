package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.StartSearchRateStatisticsMapper;
import com.ruoyi.domain.StartSearchRateStatistics;
import com.ruoyi.service.IStartSearchRateStatisticsService;

/**
 * 起始站搜索频率统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class StartSearchRateStatisticsServiceImpl extends ServiceImpl<StartSearchRateStatisticsMapper, StartSearchRateStatistics> implements IStartSearchRateStatisticsService {
    @Autowired
    private StartSearchRateStatisticsMapper startSearchRateStatisticsMapper;

    @Override
    public List<StartSearchRateStatistics> getStartSearchRateStatisticsByDay() {
        return startSearchRateStatisticsMapper.getStartSearchRateStatisticsByDay();
    }

    @Override
    public List<StartSearchRateStatistics> getStartSearchRateStatisticsBySevenDay() {
        return startSearchRateStatisticsMapper.getStartSearchRateStatisticsBySevenDay();
    }

    @Override
    public List<StartSearchRateStatistics> getStartSearchRateStatisticsByMonth() {
        return startSearchRateStatisticsMapper.getStartSearchRateStatisticsByMonth();
    }

    @Override
    public List<StartSearchRateStatistics> getStartSearchRateStatisticsByYear() {
        return startSearchRateStatisticsMapper.getStartSearchRateStatisticsByYear();
    }
}
