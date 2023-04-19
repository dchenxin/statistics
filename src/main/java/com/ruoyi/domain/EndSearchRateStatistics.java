package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 终点站搜索频率统计对象 END_SEARCH_RATE_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("END_SEARCH_RATE_STATISTICS")
public class EndSearchRateStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 所属地区 */
    @Excel(name = "所属地区")
    private String regionName;


    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticsDate;


    /** 终点站名 */
    @Excel(name = "终点站名")
    private String endName;


    /** 搜索次数 */
    @Excel(name = "搜索次数")
    private Integer searchCount;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;


    /** 所属地域 */
    @Excel(name = "所属地域")
    private String areaName;
}
