package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 实载率统计对象 REAL_LOAD_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("REAL_LOAD_STATISTICS")
public class RealLoadStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 所属地区 */
    @Excel(name = "所属地区")
    private String regionName;


    /** 实载率(单位%) */
    @Excel(name = "实载率(单位%)")
    private Double realLoadRate;


    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticsDate;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;


    /** 所属地域 */
    @Excel(name = "所属地域")
    private String areaName;

    /** 线路名 */
    @Excel(name = "线路名")
    private String lineName;

}
