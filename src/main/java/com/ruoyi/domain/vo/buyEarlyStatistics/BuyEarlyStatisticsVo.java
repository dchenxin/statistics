package com.ruoyi.domain.vo.buyEarlyStatistics;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 提前购票统计对象 BUY_EARLY_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@Data
@Builder
public class BuyEarlyStatisticsVo
{
    private static final long serialVersionUID = 1L;


    /** 所属地区 */
    private String regionName;

    /** 线路名 */
    private String lineName;

    /** 提前1小时人数 */
    private Integer earlyOneHour;


    /** 提前8小时人数 */
    private Integer earlyEight;


    /** 提前16小时人数 */
    private Integer earlySixteen;


    /** 提前1天 */
    private Integer earlyOneDay;


    /** 提前2天 */
    private Integer earlyTwoDay;


    /** 提前2天以上 */
    private Integer earlyTwoDayOver;


    /** 日期 */
    private Date statisticsDate;


}
