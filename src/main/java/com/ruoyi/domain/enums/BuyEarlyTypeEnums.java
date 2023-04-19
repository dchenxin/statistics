package com.ruoyi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 提前购票事件搜索参数
 * @author dcx
 */
@Getter
@AllArgsConstructor
public enum BuyEarlyTypeEnums {
    /**昨天*/
    ONE_HOUR(1,"提前1小时"),
    /**昨天*/
    EIGHT_HOUR(2,"提前8小时"),
    /**近七天*/
    SIXTEEN_HOUR(3,"提前16小时"),
    /**本月*/
    ONE_DAY(4,"提前1天"),
    /**本年*/
    TWO_DAY(5,"提前2天"),
    /**本年*/
    TWO_DAY_OVER(6,"提前2天以上");

    private final Integer value;
    private final String description;

    BuyEarlyTypeEnums find(Integer value){
        for (BuyEarlyTypeEnums paramEnums : BuyEarlyTypeEnums.values()) {
            if(value.equals(paramEnums.getValue())){
                return paramEnums;
            }
        }
        return null;
    }
}
