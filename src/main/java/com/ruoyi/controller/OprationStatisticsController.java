package com.ruoyi.controller;

import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Lists;
import com.ruoyi.domain.vo.operationStatistics.OperationStatisticsVo;
import com.ruoyi.handler.OperationStatisticsHandler;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.OprationStatistics;
import com.ruoyi.service.IOprationStatisticsService;
import com.ruoyi.mapper.OprationStatisticsMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运营统计Controller
 *
 * @author luz
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/module/oprationStatistics")
@AllArgsConstructor
public class OprationStatisticsController extends BaseController {
    private final OperationStatisticsHandler operationStatisticsHandler;

    /**
     * 获取小程序运营情况数据统计
     */
    @GetMapping("/getOperationStatistics/{type}")
    public AjaxResult getBusinessStatistics(@PathVariable("type") String type) {
        List<OprationStatistics> operationStatisticsList = operationStatisticsHandler.execute(type);
        Assert.notEmpty(operationStatisticsList,"暂无业务运营数据");
        List<OperationStatisticsVo> result = Lists.newArrayList();
        operationStatisticsList.forEach(operationStatistics-> {
            OperationStatisticsVo vo = new OperationStatisticsVo();
            BeanUtil.copyProperties(operationStatistics,vo);
            result.add(vo);
        });
        return AjaxResult.success(result);
    }

//    /**
//     * 查询运营统计列表
//     */
//    @PreAuthorize("@ss.hasPermi('module:oprationStatistics:list')")
//    @GetMapping("/list")
//        public TableDataInfo list(OprationStatistics oprationStatistics) {
//        startPage();
//        List<OprationStatistics> list = oprationStatisticsService.list(Wrappers.query(oprationStatistics));
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出运营统计列表
//     */
//    @PreAuthorize("@ss.hasPermi('module:oprationStatistics:export')")
//    @Log(title = "运营统计", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(OprationStatistics oprationStatistics) {
//        List<OprationStatistics> list = oprationStatisticsService.list(Wrappers.query(oprationStatistics));
//        ExcelUtil<OprationStatistics> util = new ExcelUtil<OprationStatistics>(OprationStatistics.class);
//        return util.exportExcel(list, "oprationStatistics");
//    }
//
//    /**
//     * 获取运营统计详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('module:oprationStatistics:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Integer id)
//    {
//        return AjaxResult.success(oprationStatisticsService.getById(id));
//    }
//
//    /**
//     * 新增运营统计
//     */
//    @PreAuthorize("@ss.hasPermi('module:oprationStatistics:add')")
//    @Log(title = "运营统计", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody OprationStatistics oprationStatistics)
//    {
//        return toAjax(oprationStatisticsMapper.insert(oprationStatistics));
//    }
//
//    /**
//     * 修改运营统计
//     */
//    @PreAuthorize("@ss.hasPermi('module:oprationStatistics:edit')")
//    @Log(title = "运营统计", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody OprationStatistics oprationStatistics)
//    {
//        return toAjax(oprationStatisticsMapper.updateById(oprationStatistics));
//    }
//
//    /**
//     * 删除运营统计
//     */
//    @PreAuthorize("@ss.hasPermi('module:oprationStatistics:remove')")
//    @Log(title = "运营统计", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable Integer[] ids) {
//        return toAjax(oprationStatisticsMapper.deleteBatchIds(Arrays.asList(ids)));
//    }
}
