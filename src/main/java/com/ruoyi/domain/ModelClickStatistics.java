package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 模块点击统计对象 MODEL_CLICK_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("MODEL_CLICK_STATISTICS")
public class ModelClickStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 模块名 */
    @Excel(name = "模块名")
    private String modelName;


    /** 点击数 */
    @Excel(name = "点击数")
    private Integer clickCount;


    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticsDate;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;


}
