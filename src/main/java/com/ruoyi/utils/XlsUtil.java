package com.ruoyi.utils;

import org.apache.poi.ss.usermodel.*;

import java.util.HashMap;
import java.util.Map;

public class XlsUtil {

    /**
     * 创建表格样式
     *
     * @param wb 工作薄对象
     * @return 样式列表
     */
    public static Map<String, CellStyle> createStyles(Workbook wb)
    {
        // 写入各条记录,每条记录对应excel表中的一行
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style = wb.createCellStyle();
        style.setWrapText(true); // 自动换行
        style.setAlignment(HorizontalAlignment.CENTER); // 水平对齐
        style.setVerticalAlignment(VerticalAlignment.CENTER); //垂直对齐
        style.setBorderRight(BorderStyle.THIN); // 右边框
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex()); // 右边框颜色 灰色
        style.setBorderLeft(BorderStyle.THIN); // 左边框
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN); // 上边框
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex()); //
        style.setBorderBottom(BorderStyle.THIN); // 下边框
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial"); // 字体样式
        dataFont.setFontHeightInPoints((short) 10); // 字体大小
        style.setFont(dataFont);
        styles.put("data", style);
//        style.setWrapText(true); // 自动换行

        style = wb.createCellStyle();
        style.setWrapText(true); // 自动换行
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex()); //设置前置色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 并设置 SOLID
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBold(true); // 加粗
        headerFont.setColor(IndexedColors.WHITE.getIndex()); // 白色字体
        style.setFont(headerFont);
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font totalFont = wb.createFont();
        totalFont.setFontName("Arial");
        totalFont.setFontHeightInPoints((short) 10);
        style.setFont(totalFont);
        styles.put("total", style);

        return styles;
        // 设置第一行的高度
//        Row row = sheet.createRow(0);
//        row.setHeight((short) (30 * 20));
//        row.setHeightInPoints((short) 30);
//
//        // 设置默认的宽和高
//        sheet.setDefaultColumnWidth(100 * 256);
//        sheet.setDefaultRowHeight((short) (30 * 20));
    }
}
