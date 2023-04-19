package com.ruoyi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;

/**
 * 用户性别分布统计对象 USER_SEX_SPREAD_STATISTICS
 *
 * @author luz
 * @date 2023-03-06
 */
@ToString
@Data
@TableName("USER_SEX_SPREAD_STATISTICS")
public class UserSexSpreadStatistics
{
    private static final long serialVersionUID = 1L;


    /** 系统类型 */
    @Excel(name = "系统类型")
    private String type;


    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticsDate;


    /** 女性数量 */
    @Excel(name = "女性数量")
    private Integer womanNum;


    /** 男性数量 */
    @Excel(name = "男性数量")
    private Integer manNum;


}
