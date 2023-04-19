package com.ruoyi.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;

/**
 * String字符串、String数组 转换工具类
 *
 * @author: gaoy
 * @date: 2021/2/4
 * @description: 请在方法和代码块前添加注释
 */
public class StringArrayUtils {

    /**
     * String字符串转String数组
     * @param origin
     * @return
     */
    public static String[] toStringArray(String origin){
        JSONArray arrays = JSONArray.parseArray(origin);
        String[] result = new String[arrays.size()];
        for(int i = 0;i<arrays.size();i++){
            String item = (String) arrays.get(i);
            result[i] = item;
        }
        return result;
    }

    /**
     * 只转首个
     * @param origin
     * @return
     */
    public static String[] toStringArrayFirst(String origin){
        JSONArray arrays = JSONArray.parseArray(origin);
        String[] result = new String[1];
        result[0] = (String) arrays.get(0);
        return result;
    }


}
