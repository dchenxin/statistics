package com.ruoyi.utils;

import cn.hutool.extra.pinyin.PinyinUtil;

import java.util.UUID;

/**
 * @author: gaoy
 * @date: 2021/2/4
 * @description: 请在方法和代码块前添加注释
 */
public class CodeUtil {

    /**
     * 获取校验码 并过滤字符
     * @param addr
     * @return
     */
    public static String getCheckCode(String addr){
        String letters = PinyinUtil.getFirstLetter(addr, "")
                + UUID.randomUUID().toString().split("-")[0].substring(0,4); // 大写首字母
        String uc = letters.toUpperCase() ;
        String result = "";
        for (char c: uc.toCharArray()){
            if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
                result += c;
            }
        }
        return result;
    }
}
