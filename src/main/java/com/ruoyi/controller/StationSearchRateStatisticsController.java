package com.ruoyi.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.domain.EndSearchRateStatistics;
import com.ruoyi.domain.StartSearchRateStatistics;
import com.ruoyi.domain.vo.stationStatistics.StationStatisticsVo;
import com.ruoyi.handler.EndSearchStatisticsHandler;
import com.ruoyi.handler.StartSearchStatisticsHandler;
import com.ruoyi.service.IEndSearchRateStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 起始终点站搜索频率统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/stationSearchRateStatistics")
@AllArgsConstructor
public class StationSearchRateStatisticsController extends BaseController {
    private final StartSearchStatisticsHandler startSearchStatisticsHandler;
    private final EndSearchStatisticsHandler endSearchStatisticsHandler;


    /**
     * 起始终点站搜索频率数据
     */
    @GetMapping("/getSearchRateStatistics/{type}")
    public AjaxResult getBusinessStatistics(@PathVariable("type") String type) {
        StationStatisticsVo result = StationStatisticsVo.builder().build();
        //查询起始站
        List<StartSearchRateStatistics> startList = startSearchStatisticsHandler.execute(type);
        Assert.notEmpty(startList,"暂无起始站搜索数据");
        //按所属地区分组
        Map<String, List<StartSearchRateStatistics>> startMap = startList.stream().collect(Collectors.groupingBy(StartSearchRateStatistics::getRegionName));
        Set<String> startRegionName = startMap.keySet();
        //查询终点站
        List<EndSearchRateStatistics> endList = endSearchStatisticsHandler.execute(type);
        Assert.notEmpty(endList,"暂无终点站搜索数据");
        //按所属地区分组
        Map<String, List<EndSearchRateStatistics>> endMap = endList.stream().collect(Collectors.groupingBy(EndSearchRateStatistics::getRegionName));
        Set<String> endRegionName = endMap.keySet();
        //x轴数据
        Set<String> aAxisData = Sets.newHashSet();
        Sets.union(startRegionName,endRegionName).copyInto(aAxisData);
        List<String> strings = Lists.newArrayList(aAxisData);
        strings.add(0,"product");
        result.setAAxisData(strings);
        //起始站数据
        List<Object> startData = Lists.newArrayList("起始站");
        aAxisData.forEach(s->{
            List<StartSearchRateStatistics> list = startMap.get(s);
            if(CollectionUtil.isEmpty(list)){
                //不存在则为0
                startData.add(0);
            }else{
                startData.add(list.stream().mapToInt(StartSearchRateStatistics::getSearchCount).sum());
            }
        });
        result.setStartData(startData);

        //终点站数据
        List<Object> endData = Lists.newArrayList("终点站");
        aAxisData.forEach(s->{
            List<EndSearchRateStatistics> list = endMap.get(s);
            if(CollectionUtil.isEmpty(list)){
                //不存在则为0
                endData.add(0);
            }else{
                endData.add(list.stream().mapToInt(EndSearchRateStatistics::getSearchCount).sum());
            }
        });
        result.setEndData(endData);
        return AjaxResult.success(result);
    }


}
