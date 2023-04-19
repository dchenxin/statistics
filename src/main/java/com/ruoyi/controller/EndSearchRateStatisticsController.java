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
import com.ruoyi.domain.EndSearchRateStatistics;
import com.ruoyi.service.IEndSearchRateStatisticsService;
import com.ruoyi.mapper.EndSearchRateStatisticsMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 终点站搜索频率统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/endSearchRateStatistics")
public class EndSearchRateStatisticsController extends BaseController {
    @Autowired
    private IEndSearchRateStatisticsService endSearchRateStatisticsService;

    @Autowired
    private EndSearchRateStatisticsMapper endSearchRateStatisticsMapper;

    /**
     * 查询终点站搜索频率统计列表
     */
    @PreAuthorize("@ss.hasPermi('module:endSearchRateStatistics:list')")
    @GetMapping("/list")
        public TableDataInfo list(EndSearchRateStatistics endSearchRateStatistics) {
        startPage();
        List<EndSearchRateStatistics> list = endSearchRateStatisticsService.list(Wrappers.query(endSearchRateStatistics));
        return getDataTable(list);
    }

    /**
     * 导出终点站搜索频率统计列表
     */
    @PreAuthorize("@ss.hasPermi('module:endSearchRateStatistics:export')")
    @Log(title = "终点站搜索频率统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EndSearchRateStatistics endSearchRateStatistics) {
        List<EndSearchRateStatistics> list = endSearchRateStatisticsService.list(Wrappers.query(endSearchRateStatistics));
        ExcelUtil<EndSearchRateStatistics> util = new ExcelUtil<EndSearchRateStatistics>(EndSearchRateStatistics.class);
        return util.exportExcel(list, "endSearchRateStatistics");
    }

    /**
     * 获取终点站搜索频率统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:endSearchRateStatistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(endSearchRateStatisticsService.getById(id));
    }

    /**
     * 新增终点站搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:endSearchRateStatistics:add')")
    @Log(title = "终点站搜索频率统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EndSearchRateStatistics endSearchRateStatistics)
    {
        return toAjax(endSearchRateStatisticsMapper.insert(endSearchRateStatistics));
    }

    /**
     * 修改终点站搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:endSearchRateStatistics:edit')")
    @Log(title = "终点站搜索频率统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EndSearchRateStatistics endSearchRateStatistics)
    {
        return toAjax(endSearchRateStatisticsMapper.updateById(endSearchRateStatistics));
    }

    /**
     * 删除终点站搜索频率统计
     */
    @PreAuthorize("@ss.hasPermi('module:endSearchRateStatistics:remove')")
    @Log(title = "终点站搜索频率统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(endSearchRateStatisticsMapper.deleteBatchIds(Arrays.asList(ids)));
    }
}
