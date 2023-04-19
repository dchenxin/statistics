package com.ruoyi.domain.vo.businessStatistics;

import lombok.Builder;
import lombok.Data;

/**
 * 运营情况数据总数统计
 * @author dcx
 * @date 2023/03/06
 */
@Data
@Builder
public class BusinessStatisticsTotalVo {

    /** 订坐数 */
    private Integer bookNum;


    /** 退订数 */
    private Integer cancelNum;


    /** 退订金额(单位/元) */
    private Double cancelAmount;


    /** 撤销数 */
    private Integer revokeNum;


    /** 成交金额(单位/元) */
    private Double successAmount;
}
