package com.ruoyi.domain.vo.businessStatistics;

import lombok.Data;

import java.util.List;

/**
 * 运营情况数据统计
 * @author dcx
 */
@Data
public class BusinessStatisticsVo {

    private List<String> xAxisData;

    private List<BusinessStatisticsDataVo> data;

    /**运营情况数据总数统计*/
    private BusinessStatisticsTotalVo totalVo;
}
