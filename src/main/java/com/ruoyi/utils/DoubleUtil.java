package com.ruoyi.utils;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.util.Objects;

public class DoubleUtil {

    /**
     * double数值保留两位小数
     * @param d
     * @return
     */
    public static double format(Double d){
        BigDecimal bg = new BigDecimal(d);
        double result = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static double getPercent(double a, double b){
        String s = NumberUtil.formatPercent(a / b, 2);
        return Double.parseDouble(s.replace("%",""));
    }
}
