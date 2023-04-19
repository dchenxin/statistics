package com.ruoyi.domain.vo.operationStatistics;

import lombok.Data;


/**
 * 小程序运营统计数据
 * @author dcx
 * @date 2023/03/14
 */

@Data
public class OperationStatisticsVo {
    /** 交易金额(单位/万元) */
    private Double tradeAmount;


    /** 交易笔数 */
    private Integer tradeCount;


    /** 交易人数 */
    private Integer tradeNum;


    /** 首次交易人数 */
    private Integer tradeNumFirst;


    /** 交易日期 */
    private String statisticsDate;


    /** 系统类型 */
    private String type;

}
