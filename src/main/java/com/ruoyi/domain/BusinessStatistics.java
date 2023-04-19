package com.ruoyi.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 业务统计对象 BUSINESS_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("BUSINESS_STATISTICS")
public class BusinessStatistics
{
    private static final long serialVersionUID = 1L;

    @TableId
    protected Long id;

    /** 所属地区 */
    @Excel(name = "所属地区")
    private String regionName;


    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticsDate;


    /** 订坐数 */
    @Excel(name = "订坐数")
    private Integer bookNum;


    /** 退订数 */
    @Excel(name = "退订数")
    private Integer cancelNum;


    /** 退订金额(单位/元) */
    @Excel(name = "退订金额(单位/元)")
    private Double cancelAmount;


    /** 撤销数 */
    @Excel(name = "撤销数")
    private Integer revokeNum;


    /** 成交金额(单位/元) */
    @Excel(name = "成交金额(单位/元)")
    private Double successAmount;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;

    /** 所属地域 */
    @Excel(name = "所属地域")
    private String areaName;


}
