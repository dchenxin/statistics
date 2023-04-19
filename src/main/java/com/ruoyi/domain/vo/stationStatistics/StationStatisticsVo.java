package com.ruoyi.domain.vo.stationStatistics;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 起始终点站搜索频率数据
 * @author dcx
 * @date 2023/03/14
 */

@Data
@Builder
public class StationStatisticsVo {
    /**x轴数据*/
    List<String> aAxisData;
    /**起始站数据*/
    List<Object> startData;
    /**终点站数据*/
    List<Object> endData;
}
