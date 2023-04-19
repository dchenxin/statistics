package com.ruoyi.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.UserSexSpreadStatisticsMapper;
import com.ruoyi.domain.UserSexSpreadStatistics;
import com.ruoyi.service.IUserSexSpreadStatisticsService;

/**
 * 用户性别分布统计Service业务层处理
 *
 * @author luz
 * @date 2023-03-06
 */
@Service
public class UserSexSpreadStatisticsServiceImpl extends ServiceImpl<UserSexSpreadStatisticsMapper, UserSexSpreadStatistics> implements IUserSexSpreadStatisticsService {
    @Autowired
    private UserSexSpreadStatisticsMapper userSexSpreadStatisticsMapper;

}
