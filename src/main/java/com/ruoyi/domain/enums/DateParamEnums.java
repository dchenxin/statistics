package com.ruoyi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 时间搜索参数
 */
@Getter
@AllArgsConstructor
public enum DateParamEnums {
    /**昨天*/
    YESTODAY("昨日"),
    /**昨天*/
    TODAY("今日"),
    /**近七天*/
    SEVEN_DAY("近七日"),
    /**本月*/
    MONTH("本月"),
    /**本年*/
    YEAR("本年");

    private final String value;

    DateParamEnums find(String value){
        for (DateParamEnums paramEnums : DateParamEnums.values()) {
            if(value.equals(paramEnums.getValue())){
                return paramEnums;
            }
        }
        return null;
    }
}
