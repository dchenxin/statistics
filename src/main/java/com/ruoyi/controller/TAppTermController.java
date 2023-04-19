package com.ruoyi.controller;

import java.util.Arrays;
import java.util.List;

import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.domain.TAppTerm;
import com.ruoyi.service.ITAppTermService;
import com.ruoyi.mapper.TAppTermMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应用条款管理Controller
 *
 * @author gl
 * @date 2020-11-11
 */
@RestController
@RequestMapping("/module/appTerm")
public class TAppTermController extends BaseController {
    @Autowired
    private ITAppTermService tAppTermService;

    @Autowired
    private TAppTermMapper tAppTermMapper;

    /**
     * 查询应用条款管理列表
     */
    @PreAuthorize("@ss.hasPermi('module:appTerm:list')")
    @GetMapping("/list")
        public TableDataInfo list(TAppTerm tAppTerm) {
        startPage();
        List<TAppTerm> list = tAppTermService.list(Wrappers.query(tAppTerm));
        for (TAppTerm term : list) {
            // 去除标签体
            if (StringUtils.isNotEmpty(term.getContent())) {
                for (int i = 0; i < term.getContent().length(); i++) {
                    term.setContent(HtmlUtil.cleanHtmlTag(term.getContent()));
                }
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出应用条款管理列表
     */
    @PreAuthorize("@ss.hasPermi('module:appTerm:export')")
    @Log(title = "应用条款管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TAppTerm tAppTerm) {
        List<TAppTerm> list = tAppTermService.list(Wrappers.query(tAppTerm));
        ExcelUtil<TAppTerm> util = new ExcelUtil<TAppTerm>(TAppTerm.class);
        return util.exportExcel(list, "appTerm");
    }

    /**
     * 获取应用条款管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('module:appTerm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tAppTermService.getById(id));
    }

    /**
     * 新增应用条款管理
     */
    @PreAuthorize("@ss.hasPermi('module:appTerm:add')")
    @Log(title = "应用条款管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TAppTerm tAppTerm)
    {
        return toAjax(tAppTermMapper.insert(tAppTerm));
    }

    /**
     * 修改应用条款管理
     */
    @PreAuthorize("@ss.hasPermi('module:appTerm:edit')")
    @Log(title = "应用条款管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TAppTerm tAppTerm)
    {
        return toAjax(tAppTermMapper.updateById(tAppTerm));
    }

    /**
     * 删除应用条款管理
     */
    @PreAuthorize("@ss.hasPermi('module:appTerm:remove')")
    @Log(title = "应用条款管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tAppTermMapper.deleteBatchIds(Arrays.asList(ids)));
    }
}
