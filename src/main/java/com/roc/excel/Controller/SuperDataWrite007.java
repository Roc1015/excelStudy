package com.roc.excel.Controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/1/26 0:17
 */
public class SuperDataWrite007 {

    String Path = "excelStudy";

    @Test
    public void SuperDataWrite007() throws IOException {
        //获取程序开始时系统的时间且转换成秒
        long begin = System.currentTimeMillis();

        //创建一个工作簿
        Workbook workbook007 = new SXSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook007.createSheet();

        //写入数据
        //for循环写入
        //同样循环创建65336行
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                //每行循环创建10列且填入数据
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        //创建成功后
        System.out.println("over");
        //输出数据到文件中
        FileOutputStream fileOutputStream = new FileOutputStream(Path + "SuperDataWrite007.xlsx");
        workbook007.write(fileOutputStream);
        fileOutputStream.close();
        //清除过程中产生的临时文件
        ((SXSSFWorkbook) workbook007).dispose();

        //获取程序结束时系统的时间且转换成秒
        long end = System.currentTimeMillis();
        //计算前后总计花费多长时间
        System.out.println((double) (end - begin) / 1000);
    }
}
