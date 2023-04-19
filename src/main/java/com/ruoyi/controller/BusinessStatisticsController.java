package com.ruoyi.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import cn.hutool.core.util.NumberUtil;
import com.google.common.collect.Lists;
import com.ruoyi.domain.vo.businessStatistics.BusinessStatisticsDataVo;
import com.ruoyi.domain.vo.businessStatistics.BusinessStatisticsTotalVo;
import com.ruoyi.domain.vo.businessStatistics.BusinessStatisticsVo;
import com.ruoyi.handler.BusinessStatisticsHandler;
import com.ruoyi.utils.DoubleUtil;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.domain.BusinessStatistics;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 业务统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/module/businessStatistics")
@AllArgsConstructor
public class BusinessStatisticsController extends BaseController {
    private final BusinessStatisticsHandler businessStatisticsHandler;

    /**
     * 获取运营情况数据统计
     */
    @GetMapping("/getBusinessStatistics/{type}")
    public AjaxResult getBusinessStatistics(@PathVariable("type") String type) {
        BusinessStatisticsVo businessStatisticsVo = new BusinessStatisticsVo();
        List<BusinessStatistics> result = businessStatisticsHandler.execute(type);
        Assert.notEmpty(result,"暂无业务运营数据");

//        List<String> xAxisData = Lists.newArrayList("订座数","退订数","退订金额(元)","撤销数","成交金额(元)");


        //按照地区名分组 并求各个字段和
        Map<String, List<BusinessStatistics>> map = result.stream().collect(Collectors.groupingBy(BusinessStatistics::getRegionName));
        //x轴
        List<String> xAxisData = Lists.newArrayList( map.keySet());
        //订座总数
        int bookNumTotal = result.stream().mapToInt(BusinessStatistics::getBookNum).sum();
        //退订总数
        int cancelNumTotal = result.stream().mapToInt(BusinessStatistics::getCancelNum).sum();
        //退订金额总数
        double cancelAmountTotal = DoubleUtil.format(result.stream().mapToDouble(BusinessStatistics::getCancelAmount).sum());
        //撤销数
        int revokeNumTotal = result.stream().mapToInt(BusinessStatistics::getRevokeNum).sum();
        //成交金额总数
        double successAmountTotal = DoubleUtil.format(result.stream().mapToDouble(BusinessStatistics::getSuccessAmount).sum());

        //y轴数据
        List<BusinessStatisticsDataVo> data = Lists.newArrayList();
        map.keySet().forEach(s -> {
            List<BusinessStatistics> businessStatistics = map.get(s);
            BusinessStatisticsDataVo dataVo = new BusinessStatisticsDataVo();
            //key值即为地区名
            dataVo.setName(s);
            dataVo.setBookNumData(DoubleUtil.getPercent(businessStatistics.stream().mapToInt(BusinessStatistics::getBookNum).sum(), bookNumTotal));
            dataVo.setCancelNumData(DoubleUtil.getPercent(businessStatistics.stream().mapToInt(BusinessStatistics::getCancelNum).sum(),cancelNumTotal));
            dataVo.setCancelAmountData(DoubleUtil.getPercent(businessStatistics.stream().mapToDouble(BusinessStatistics::getCancelAmount).sum(),cancelAmountTotal));
            dataVo.setRevokeNumData(DoubleUtil.getPercent(businessStatistics.stream().mapToInt(BusinessStatistics::getRevokeNum).sum(),revokeNumTotal));
            dataVo.setSuccessAmountData(DoubleUtil.getPercent(businessStatistics.stream().mapToDouble(BusinessStatistics::getSuccessAmount).sum(),successAmountTotal));
            data.add(dataVo);
        });
        //统计总数
        BusinessStatisticsTotalVo totalVo = BusinessStatisticsTotalVo.builder()
                .bookNum(bookNumTotal)
                .cancelNum(cancelNumTotal)
                .cancelAmount(cancelAmountTotal)
                .revokeNum(revokeNumTotal)
                .successAmount(successAmountTotal)
                .build();

        businessStatisticsVo.setXAxisData(xAxisData);
        businessStatisticsVo.setData(data);
        businessStatisticsVo.setTotalVo(totalVo);
        return AjaxResult.success(businessStatisticsVo);
    }


//    /**
//     * 查询业务统计列表
//     */
//    @ApiOperation("获取用户列表")
//    @PreAuthorize("@ss.hasPermi('module:businessStatistics:list')")
//    @GetMapping("/list")
//        public TableDataInfo list(BusinessStatistics businessStatistics) {
//        startPage();
//        List<BusinessStatistics> list = businessStatisticsService.list(Wrappers.query(businessStatistics));
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出业务统计列表
//     */
//    @PreAuthorize("@ss.hasPermi('module:businessStatistics:export')")
//    @Log(title = "业务统计", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(BusinessStatistics businessStatistics) {
//        List<BusinessStatistics> list = businessStatisticsService.list(Wrappers.query(businessStatistics));
//        ExcelUtil<BusinessStatistics> util = new ExcelUtil<BusinessStatistics>(BusinessStatistics.class);
//        return util.exportExcel(list, "businessStatistics");
//    }
//
//    /**
//     * 获取业务统计详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('module:businessStatistics:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Integer id)
//    {
//        return AjaxResult.success(businessStatisticsService.getById(id));
//    }
//
//    /**
//     * 新增业务统计
//     */
//    @PreAuthorize("@ss.hasPermi('module:businessStatistics:add')")
//    @Log(title = "业务统计", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody BusinessStatistics businessStatistics)
//    {
//        return toAjax(businessStatisticsMapper.insert(businessStatistics));
//    }
//
//    /**
//     * 修改业务统计
//     */
//    @PreAuthorize("@ss.hasPermi('module:businessStatistics:edit')")
//    @Log(title = "业务统计", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody BusinessStatistics businessStatistics)
//    {
//        return toAjax(businessStatisticsMapper.updateById(businessStatistics));
//    }
//
//    /**
//     * 删除业务统计
//     */
//    @PreAuthorize("@ss.hasPermi('module:businessStatistics:remove')")
//    @Log(title = "业务统计", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable Integer[] ids) {
//        return toAjax(businessStatisticsMapper.deleteBatchIds(Arrays.asList(ids)));
//    }
}
