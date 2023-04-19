package com.ruoyi.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.domain.UserAgeSpreadStatistics;
import com.ruoyi.domain.vo.dataModel.DataModel;
import com.ruoyi.domain.vo.dataModel.DataModelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.service.IUserAgeSpreadStatisticsService;
import com.ruoyi.common.core.controller.BaseController;

import java.util.List;

/**
 * 用户年龄分布统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/userAgeSpreadStatistics")
public class UserAgeSpreadStatisticsController extends BaseController {
    @Autowired
    private IUserAgeSpreadStatisticsService userAgeSpreadStatisticsService;

    /**
     * 用户年龄分布数据
     */
    @GetMapping("/getUserAgeSpreadStatistics")
    public AjaxResult getUserAgeSpreadStatistics() {
        LambdaQueryWrapper<UserAgeSpreadStatistics> wrapper = Wrappers.lambdaQuery();
        wrapper.orderByDesc(UserAgeSpreadStatistics::getStatisticsDate).last("limit 1");
        UserAgeSpreadStatistics one = userAgeSpreadStatisticsService.getOne(wrapper);
        Assert.notNull(one,"暂无用户年龄分布数据");
        DataModelVo vo = new DataModelVo();
        List<DataModel> data = Lists.newArrayList(new DataModel("17岁以下",one.getAgeRangeOne())
                ,new DataModel("18~24岁",one.getAgeRangeTwo())
                ,new DataModel("25～29岁",one.getAgeRangeThird())
                ,new DataModel("30～39岁",one.getAgeRangeFour())
                ,new DataModel("40~49岁",one.getAgeRangeFive())
                ,new DataModel("50岁以上",one.getAgeRangeSix())
        );
        vo.setData(data);
        return AjaxResult.success(vo);
    }
}
