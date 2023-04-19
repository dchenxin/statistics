package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.LineSearchRateStatisticsMapper;
import com.ruoyi.domain.LineSearchRateStatistics;
import com.ruoyi.service.ILineSearchRateStatisticsService;

/**
 * 线路搜索频率统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class LineSearchRateStatisticsServiceImpl extends ServiceImpl<LineSearchRateStatisticsMapper, LineSearchRateStatistics> implements ILineSearchRateStatisticsService {
    @Autowired
    private LineSearchRateStatisticsMapper lineSearchRateStatisticsMapper;

}
