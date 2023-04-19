package com.ruoyi.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.ruoyi.domain.vo.dataModel.DataModel;
import com.ruoyi.domain.vo.dataModel.DataModelVo;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.domain.UserSexSpreadStatistics;
import com.ruoyi.service.IUserSexSpreadStatisticsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 用户性别分布统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/userSexSpreadStatistics")
@AllArgsConstructor
public class UserSexSpreadStatisticsController extends BaseController {

    private final IUserSexSpreadStatisticsService userSexSpreadStatisticsService;

    /**
     * 用户性别分布数据
     */
    @GetMapping("/getUserSexSpreadStatistics")
    public AjaxResult getUserSexSpreadStatistics() {
        LambdaQueryWrapper<UserSexSpreadStatistics> wrapper = Wrappers.lambdaQuery();
        wrapper.orderByDesc(UserSexSpreadStatistics::getStatisticsDate).last("limit 1");
        UserSexSpreadStatistics one = userSexSpreadStatisticsService.getOne(wrapper);
        Assert.notNull(one,"暂无用户性别分布数据");
        DataModelVo vo = new DataModelVo();
        List<DataModel> data = Lists.newArrayList(new DataModel("男",one.getManNum()),new DataModel("女",one.getWomanNum()));
        vo.setData(data);
        return AjaxResult.success(vo);
    }
}
