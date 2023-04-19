package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 用户年龄分布统计对象 USER_AGE_SPREAD_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("USER_AGE_SPREAD_STATISTICS")
public class UserAgeSpreadStatistics
{
    private static final long serialVersionUID = 1L;


    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticsDate;


    /** 17岁以下人数 */
    @Excel(name = "17岁以下人数")
    private Integer ageRangeOne;


    /** 18~24岁人数 */
    @Excel(name = "18~24岁人数")
    private Integer ageRangeTwo;


    /** 25~29岁人数 */
    @Excel(name = "25~29岁人数")
    private Integer ageRangeThird;


    /** 30~39岁人数 */
    @Excel(name = "30~39岁人数")
    private Integer ageRangeFour;


    /** 40~49岁人数 */
    @Excel(name = "40~49岁人数")
    private Integer ageRangeFive;


    /** 50岁以上人数 */
    @Excel(name = "50岁以上人数")
    private Integer ageRangeSix;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;


}
