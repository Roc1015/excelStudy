package com.roc.excel.Controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/1/25 22:57
 */
public class ExcelWriteTest03 {

    String Path = "excelStudy";

    @Test
    public void testWrite03() throws IOException {
        //1.创建一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建一个工作表
        HSSFSheet sheet = workbook.createSheet();
        //3.创建第一行
        Row row1 = sheet.createRow(0);
        //4.创建第一列
        Cell cell0101 = row1.createCell(0);
        //4.创建第二列
        Cell cell0102 = row1.createCell(1);
        //5.放入数据
        cell0101.setCellValue("信息");
        cell0102.setCellValue("这是POI的一节课");

        //创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建第二行的第一列和第二列，且向第二的第一列和第二列放入日期格式的值
        Cell cell0201 = row2.createCell(0);
        Cell cell0202 = row2.createCell(1);
        cell0201.setCellValue("时间");
        String dateTime = new Date().toString();
        cell0202.setCellValue(dateTime);

        //生成一张表(IO文件流) 03版本的后缀为.xls
        //代码操作文件依旧是通过IO操作，new一个新的IO文件流，且使用完IO流之后关闭
        //使用IO流的过程中不断抛出异常
        FileOutputStream fileOutputStream = new FileOutputStream(Path + "POI的第一张表03.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
