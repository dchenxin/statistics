package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.UserAgeSpreadStatisticsMapper;
import com.ruoyi.domain.UserAgeSpreadStatistics;
import com.ruoyi.service.IUserAgeSpreadStatisticsService;

/**
 * 用户年龄分布统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class UserAgeSpreadStatisticsServiceImpl extends ServiceImpl<UserAgeSpreadStatisticsMapper, UserAgeSpreadStatistics> implements IUserAgeSpreadStatisticsService {
    @Autowired
    private UserAgeSpreadStatisticsMapper userAgeSpreadStatisticsMapper;
}
