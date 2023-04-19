package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.ModelClickStatisticsMapper;
import com.ruoyi.domain.ModelClickStatistics;
import com.ruoyi.service.IModelClickStatisticsService;

/**
 * 模块点击统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class ModelClickStatisticsServiceImpl extends ServiceImpl<ModelClickStatisticsMapper, ModelClickStatistics> implements IModelClickStatisticsService {
    @Autowired
    private ModelClickStatisticsMapper modelClickStatisticsMapper;

    @Override
    public List<ModelClickStatistics> getModelClickStatisticsByDay() {
        return modelClickStatisticsMapper.getModelClickStatisticsByDay();
    }

    @Override
    public List<ModelClickStatistics> getModelClickStatisticsBySevenDay() {
        return modelClickStatisticsMapper.getModelClickStatisticsBySevenDay();
    }

    @Override
    public List<ModelClickStatistics> getModelClickStatisticsByMonth() {
        return modelClickStatisticsMapper.getModelClickStatisticsByMonth();
    }

    @Override
    public List<ModelClickStatistics> getModelClickStatisticsByYear() {
        return modelClickStatisticsMapper.getModelClickStatisticsByYear();
    }
}
