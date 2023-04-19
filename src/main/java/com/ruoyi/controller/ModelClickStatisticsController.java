package com.ruoyi.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.domain.ModelClickStatistics;
import com.ruoyi.domain.vo.modelClickStatistics.ModelClickStatisticsVo;
import com.ruoyi.handler.ModelClickStatisticsHandler;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 模块点击统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/modelClickStatistics")
@AllArgsConstructor
public class ModelClickStatisticsController extends BaseController {

    private final ModelClickStatisticsHandler modelClickStatisticsHandler;

    /**
     * 模块点击数据
     */
    @GetMapping("/getModelClickStatistics/{type}")
    public AjaxResult getModelClickStatistics(@PathVariable("type") String type) {
        List<ModelClickStatistics> execute = modelClickStatisticsHandler.execute(type);
        Assert.notEmpty(execute,"暂无模块点击数据");
        //按模块名分组 并求和
        Map<String, List<ModelClickStatistics>> collect = execute.stream().collect(Collectors.groupingBy(ModelClickStatistics::getModelName));
        List<ModelClickStatistics> resultData = collect.keySet().stream().map(s -> {
            ModelClickStatistics modelClickStatistics = new ModelClickStatistics();
            modelClickStatistics.setModelName(s);
            modelClickStatistics.setClickCount(collect.get(s).stream().mapToInt(ModelClickStatistics::getClickCount).sum());
            return modelClickStatistics;
        }).collect(Collectors.toList());
        //按照点击量从小到大排序
        resultData = resultData.stream().sorted(Comparator.comparing(ModelClickStatistics::getClickCount)).collect(Collectors.toList());
        //返回数据
        ModelClickStatisticsVo result = new ModelClickStatisticsVo();
        result.setAAxisData(resultData.stream().map(ModelClickStatistics::getModelName).collect(Collectors.toList()));
        result.setData(resultData.stream().map(ModelClickStatistics::getClickCount).collect(Collectors.toList()));
        return AjaxResult.success(result);
    }

}
