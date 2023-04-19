package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 提前购票统计对象 BUY_EARLY_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("BUY_EARLY_STATISTICS")
public class BuyEarlyStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 所属地区 */
    @Excel(name = "所属地区")
    private String regionName;


    /** 提前1小时人数 */
    @Excel(name = "提前1小时人数")
    private Integer earlyOneHour;


    /** 提前8小时人数 */
    @Excel(name = "提前8小时人数")
    private Integer earlyEight;


    /** 提前16小时人数 */
    @Excel(name = "提前16小时人数")
    private Integer earlySixteen;


    /** 提前1天 */
    @Excel(name = "提前1天")
    private Integer earlyOneDay;


    /** 提前2天 */
    @Excel(name = "提前2天")
    private Integer earlyTwoDay;


    /** 提前2天以上 */
    @Excel(name = "提前2天以上")
    private Integer earlyTwoDayOver;


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
