package com.ruoyi.domain.vo.realLoadStatistics;

import lombok.Data;

import java.util.List;

/**
 * 实载率统计对象
 *
 * @author luz
 * @date 2023-03-06
 */
@Data
public class RealLoadStatisticsVo
{
    private static final long serialVersionUID = 1L;

    /**x轴数据*/
    List<String> aAxisData;

    /**实载率数据*/
    List<Double> data;


}
