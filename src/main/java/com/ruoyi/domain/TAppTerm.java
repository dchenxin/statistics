package com.ruoyi.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 应用条款管理对象 t_app_term
 *
 * @author gl
 * @date 2020-11-11
 */
@ToString
@Data
@TableName("t_app_term")
public class TAppTerm extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 标题 */
    @Excel(name = "标题")
    private String title;


    /** 内容 */
    @Excel(name = "内容")
    private String content;


}
