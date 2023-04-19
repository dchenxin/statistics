package com.ruoyi.domain.vo.modelClickStatistics;

import lombok.Data;

import java.util.List;

/**
 * 模块点击统计对象 BUY_EARLY_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@Data
public class ModelClickStatisticsVo
{
    private static final long serialVersionUID = 1L;

    /**x轴数据*/
    List<String> aAxisData;

    /**点击量数据*/
    List<Integer> data;


}
