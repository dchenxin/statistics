package com.ruoyi.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 城市
 * @author codegen
 * @date 2019-10-24 09:59:29
 */
@Data
@TableName("CITY")
public class City {
    /**
     * 主键 设置为主键并自增长
     */
    private String cityId;

    /**
     * 创建时间
     */
    private String cityName;

    /**
     * 最后更新时间
     */
    private Integer regionId;



}
