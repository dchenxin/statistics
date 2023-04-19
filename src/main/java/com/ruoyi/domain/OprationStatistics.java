package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 运营统计对象 OPRATION_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("OPRATION_STATISTICS")
public class OprationStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 交易金额(单位/万元) */
    @Excel(name = "交易金额(单位/万元)")
    private Double tradeAmount;


    /** 交易笔数 */
    @Excel(name = "交易笔数")
    private Integer tradeCount;


    /** 交易人数 */
    @Excel(name = "交易人数")
    private Integer tradeNum;


    /** 首次交易人数 */
    @Excel(name = "首次交易人数")
    private Integer tradeNumFirst;


    /** 交易日期 */
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String statisticsDate;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;


}
