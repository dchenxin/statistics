package com.ruoyi.controller;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.LineSearchRateStatistics;
import com.ruoyi.service.ILineSearchRateStatisticsService;
import com.ruoyi.mapper.LineSearchRateStatisticsMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 线路搜索频率统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/lineSearchRateStatistics")
public class LineSearchRateStatisticsController extends BaseController {
    @Autowired
    private ILineSearchRateStatisticsService lineSearchRateStatisticsService;

    @Autowired
    private LineSearchRateStatisticsMapper lineSearchRateStatisticsMapper;

    /**
     * 查询线路搜索频率统计列表
     */
    @PreAuthorize("@ss.hasPermi('module:lineSearchRateStatistics:list')")
    @GetMapping("/list")
        public TableDataInfo list(LineSearchRateStatistics lineSearchRateStatistics) {
        startPage();
        List<LineSearchRateStatistics> list = lineSearchRateStatisticsService.list(Wrappers.query(lineSearchRateStatistics));
        return getDataTable(list);
    }

    /**
     * 导出线路搜索频率统计列表
     */
    @PreAuthorize("@ss.hasPermi('module:lineSearchRateStatistics:export')")
    @Log(title = "线路搜索频率统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LineSearchRateStatistics lineSearchRateStatistics) {
        List<LineSearchRateStatistics> list = lineSearchRateStatisticsService.list(Wrappers.query(lineSearchRateStatistics));
        ExcelUtil<LineSearchRateStatistics> util = new ExcelUtil<LineSearchRateStatistics>(LineSearchRateStatistics.class);
        return util.exportExcel(list, "lineSearchRateStatistics");
    }

    /**
     * 获取线路搜索频率统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:lineSearchRateStatistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(lineSearchRateStatisticsService.getById(id));
    }

    /**
     * 新增线路搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:lineSearchRateStatistics:add')")
    @Log(title = "线路搜索频率统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LineSearchRateStatistics lineSearchRateStatistics)
    {
        return toAjax(lineSearchRateStatisticsMapper.insert(lineSearchRateStatistics));
    }

    /**
     * 修改线路搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:lineSearchRateStatistics:edit')")
    @Log(title = "线路搜索频率统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LineSearchRateStatistics lineSearchRateStatistics)
    {
        return toAjax(lineSearchRateStatisticsMapper.updateById(lineSearchRateStatistics));
    }

    /**
     * 删除线路搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:lineSearchRateStatistics:remove')")
    @Log(title = "线路搜索频率统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(lineSearchRateStatisticsMapper.deleteBatchIds(Arrays.asList(ids)));
    }
}
