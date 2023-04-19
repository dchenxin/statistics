package com.ruoyi.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

/**
 * @author: Luz
 * @date: 2020-12-28
 */
public class CellUtils {
	 static  void exportExcel() throws Exception{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet name");

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
		//设置第一列单元格宽度
		sheet.setColumnWidth(0,80*80);
		sheet.setColumnWidth(1,80*80);
//		//设置第二列单元格宽度
//		sheet.setColumnWidth(1,50*50);
		//创建第一行
		HSSFRow row0 = sheet.createRow(0);
		//创建第二行
		HSSFRow row1 = sheet.createRow(1);
		//设置第一行单元格高度
		row0.setHeight((short) 200);
		//创建第一行第一列单元格
		HSSFCell cell0_1 = row0.createCell(0);
		//创建第二行第一列单元格
		HSSFCell cell0_2 = row1.createCell(0);
		//设置单元格的值
		cell0_1.setCellValue("所在乡村");
		//改变字体样式，步骤
		HSSFFont hssfFont = wb.createFont();
		//设置字体,红色
		hssfFont.setColor(IndexedColors.WHITE.getIndex());
		//字体粗体显示
		hssfFont.setBold(true);
		hssfFont.setFontName("Arial");
		// 字体大小
		hssfFont.setFontHeightInPoints((short) 16);
		//设置样式
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(hssfFont);
		//设置单元格背景色
		cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//设置居中
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
		//设置边框
		cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
		cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框
		cellStyle.setBorderTop(BorderStyle.THIN);//上边框
		cellStyle.setBorderRight(BorderStyle.THIN);//右边框
 		//3.单元格使用样式，设置第一行第一列单元格样式
		cell0_1.setCellStyle(cellStyle);
		cell0_2.setCellStyle(cellStyle);
		//生成excel文件
		FileOutputStream fileOut = new FileOutputStream("e:\\"+System.currentTimeMillis()+".xls");
		wb.write(fileOut);
		fileOut.close();
        /* struts导出excel，前端需要是提交form形式，否则，点击导出不会弹出框
              HSSFWorkbook wb = exportExcel(projectId, blockId, buildingId,buildingCode);
             // 生成excel文件
             String fileName = String.valueOf(Calendar.getInstance().getTimeInMillis()).concat(".xls");
             // 清空response
             this.getResponse().reset();
             this.getResponse().addHeader("Content-Disposition","attachment;filename=" + new                              String(fileName.getBytes()));
             this.getResponse().setContentType("application/vnd.ms-excel;charset=utf-8");
             OutputStream os = this.getResponse().getOutputStream();
             wb.write(os);
             if (os != null) {
             os.close();
             os = null;
             }
             wb.close();
         */
	}

	public static void main(String[] args) throws Exception {
		exportExcel();
	}
}
