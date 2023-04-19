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
import com.ruoyi.domain.StartSearchRateStatistics;
import com.ruoyi.service.IStartSearchRateStatisticsService;
import com.ruoyi.mapper.StartSearchRateStatisticsMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 起始站搜索频率统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/startSearchRateStatistics")
public class StartSearchRateStatisticsController extends BaseController {
    @Autowired
    private IStartSearchRateStatisticsService startSearchRateStatisticsService;

    @Autowired
    private StartSearchRateStatisticsMapper startSearchRateStatisticsMapper;

    /**
     * 查询起始站搜索频率统计列表
     */
    @PreAuthorize("@ss.hasPermi('module:startSearchRateStatistics:list')")
    @GetMapping("/list")
        public TableDataInfo list(StartSearchRateStatistics startSearchRateStatistics) {
        startPage();
        List<StartSearchRateStatistics> list = startSearchRateStatisticsService.list(Wrappers.query(startSearchRateStatistics));
        return getDataTable(list);
    }

    /**
     * 导出起始站搜索频率统计列表
     */
    @PreAuthorize("@ss.hasPermi('module:startSearchRateStatistics:export')")
    @Log(title = "起始站搜索频率统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(StartSearchRateStatistics startSearchRateStatistics) {
        List<StartSearchRateStatistics> list = startSearchRateStatisticsService.list(Wrappers.query(startSearchRateStatistics));
        ExcelUtil<StartSearchRateStatistics> util = new ExcelUtil<StartSearchRateStatistics>(StartSearchRateStatistics.class);
        return util.exportExcel(list, "startSearchRateStatistics");
    }

    /**
     * 获取起始站搜索频率统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:startSearchRateStatistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(startSearchRateStatisticsService.getById(id));
    }

    /**
     * 新增起始站搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:startSearchRateStatistics:add')")
    @Log(title = "起始站搜索频率统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StartSearchRateStatistics startSearchRateStatistics)
    {
        return toAjax(startSearchRateStatisticsMapper.insert(startSearchRateStatistics));
    }

    /**
     * 修改起始站搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:startSearchRateStatistics:edit')")
    @Log(title = "起始站搜索频率统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StartSearchRateStatistics startSearchRateStatistics)
    {
        return toAjax(startSearchRateStatisticsMapper.updateById(startSearchRateStatistics));
    }

    /**
     * 删除起始站搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:startSearchRateStatistics:remove')")
    @Log(title = "起始站搜索频率统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(startSearchRateStatisticsMapper.deleteBatchIds(Arrays.asList(ids)));
    }
}
