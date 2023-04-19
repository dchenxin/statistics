package com.ruoyi.domain.vo.businessStatistics;

import lombok.Data;

import java.util.List;

/**
 * 运营情况数据统计
 * @author dcx
 */
@Data
public class BusinessStatisticsDataVo {
    /**地区名*/
    private String name;
    /**数据*/
    private Double bookNumData;
    private Double cancelNumData;
    private Double cancelAmountData;
    private Double revokeNumData;
    private Double successAmountData;
}
