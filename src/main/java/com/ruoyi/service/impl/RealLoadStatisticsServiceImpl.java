package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.RealLoadStatisticsMapper;
import com.ruoyi.domain.RealLoadStatistics;
import com.ruoyi.service.IRealLoadStatisticsService;

/**
 * 实载率统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class RealLoadStatisticsServiceImpl extends ServiceImpl<RealLoadStatisticsMapper, RealLoadStatistics> implements IRealLoadStatisticsService {
    @Autowired
    private RealLoadStatisticsMapper realLoadStatisticsMapper;

    @Override
    public List<RealLoadStatistics> getRealLoadStatisticsByDay() {
        return realLoadStatisticsMapper.getRealLoadStatisticsByDay();
    }

    @Override
    public List<RealLoadStatistics> getRealLoadStatisticsByToDay() {
        return realLoadStatisticsMapper.getRealLoadStatisticsByToDay();
    }
}
