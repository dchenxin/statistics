package com.ruoyi.controller;

import com.ruoyi.domain.ModelClickStatistics;
import com.ruoyi.domain.RealLoadStatistics;
import com.ruoyi.domain.vo.modelClickStatistics.ModelClickStatisticsVo;
import com.ruoyi.domain.vo.realLoadStatistics.RealLoadStatisticsVo;
import com.ruoyi.handler.RealLoadStatisticsHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.service.IRealLoadStatisticsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实载率统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/realLoadStatistics")
@AllArgsConstructor
public class RealLoadStatisticsController extends BaseController {

    private final RealLoadStatisticsHandler realLoadStatisticsHandler;

    /**
     * 实载率数据
     */
    @GetMapping("/getRealLoadStatistics/{type}")
    public AjaxResult getRealLoadStatistics(@PathVariable("type") String type) {
        List<RealLoadStatistics> execute = realLoadStatisticsHandler.execute(type);
        Assert.notEmpty(execute,"暂无实载率数据");
        //返回数据
        RealLoadStatisticsVo result = new RealLoadStatisticsVo();
        result.setAAxisData(execute.stream().map(RealLoadStatistics::getLineName).collect(Collectors.toList()));
        result.setData(execute.stream().map(RealLoadStatistics::getRealLoadRate).collect(Collectors.toList()));
        return AjaxResult.success(result);
    }
}
