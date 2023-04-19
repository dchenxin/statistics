package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.BusinessStatisticsMapper;
import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.service.IBusinessStatisticsService;

/**
 * 业务统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class BusinessStatisticsServiceImpl extends ServiceImpl<BusinessStatisticsMapper, BusinessStatistics> implements IBusinessStatisticsService {
    @Autowired
    private BusinessStatisticsMapper businessStatisticsMapper;

    @Override
    public List<BusinessStatistics> getBusinessStatisticsByDay() {
        return businessStatisticsMapper.getBusinessStatisticsByDay();
    }

    @Override
    public List<BusinessStatistics> getBusinessStatisticsBySevenDay() {
        return businessStatisticsMapper.getBusinessStatisticsBySevenDay();
    }

    @Override
    public List<BusinessStatistics> getBusinessStatisticsByMonth() {
        return businessStatisticsMapper.getBusinessStatisticsByMonth();
    }

    @Override
    public List<BusinessStatistics> getBusinessStatisticsByYear() {
        return businessStatisticsMapper.getBusinessStatisticsByYear();
    }
}
