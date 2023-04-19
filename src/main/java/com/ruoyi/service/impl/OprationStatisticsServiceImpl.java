package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.OprationStatisticsMapper;
import com.ruoyi.domain.OprationStatistics;
import com.ruoyi.service.IOprationStatisticsService;

/**
 * 运营统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class OprationStatisticsServiceImpl extends ServiceImpl<OprationStatisticsMapper, OprationStatistics> implements IOprationStatisticsService {
    @Autowired
    private OprationStatisticsMapper oprationStatisticsMapper;

    @Override
    public List<OprationStatistics> getOprationStatisticsByDay() {
        return oprationStatisticsMapper.getOprationStatisticsByDay();
    }

    @Override
    public List<OprationStatistics> getOprationStatisticsBySevenDay() {
        return oprationStatisticsMapper.getOprationStatisticsBySevenDay();
    }

    @Override
    public List<OprationStatistics> getOprationStatisticsByMonth() {
        return oprationStatisticsMapper.getOprationStatisticsByMonth();
    }

    @Override
    public List<OprationStatistics> getOprationStatisticsByYear() {
        return oprationStatisticsMapper.getOprationStatisticsByYear();
    }
}
