package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.EndSearchRateStatisticsMapper;
import com.ruoyi.domain.EndSearchRateStatistics;
import com.ruoyi.service.IEndSearchRateStatisticsService;

/**
 * 终点站搜索频率统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class EndSearchRateStatisticsServiceImpl extends ServiceImpl<EndSearchRateStatisticsMapper, EndSearchRateStatistics> implements IEndSearchRateStatisticsService {
    @Autowired
    private EndSearchRateStatisticsMapper endSearchRateStatisticsMapper;

    @Override
    public List<EndSearchRateStatistics> getEndSearchRateStatisticsByDay() {
        return endSearchRateStatisticsMapper.getEndSearchRateStatisticsByDay();
    }

    @Override
    public List<EndSearchRateStatistics> getEndSearchRateStatisticsBySevenDay() {
        return endSearchRateStatisticsMapper.getEndSearchRateStatisticsBySevenDay();
    }

    @Override
    public List<EndSearchRateStatistics> getEndSearchRateStatisticsByMonth() {
        return endSearchRateStatisticsMapper.getEndSearchRateStatisticsByMonth();
    }

    @Override
    public List<EndSearchRateStatistics> getEndSearchRateStatisticsByYear() {
        return endSearchRateStatisticsMapper.getEndSearchRateStatisticsByYear();
    }
}
