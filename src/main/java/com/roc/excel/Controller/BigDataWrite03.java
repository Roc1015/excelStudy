package com.roc.excel.Controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/1/25 23:42
 */
public class BigDataWrite03 {

    String Path = "excelStudy";

    @Test
    public void BigDataWriteTest03() throws IOException {
        //获取程序开始时系统的时间且转换成秒
        long begin = System.currentTimeMillis();

        //创建一个工作簿
        HSSFWorkbook workbook03 = new HSSFWorkbook();
        //创建一个工作表
        HSSFSheet sheet = workbook03.createSheet();

        //写入数据
        //for循环写入
        //循环创建65336行
        for (int rowNum = 0;rowNum<65536;rowNum++){
            HSSFRow row = sheet.createRow(rowNum);
            for(int cellNum = 0;cellNum<10;cellNum++){
        //每行循环创建10列且填入数据
                HSSFCell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        //创建成功后
        System.out.println("over");
        //输出数据到文件中
        FileOutputStream fileOutputStream = new FileOutputStream(Path + "BigDataWriteTest03.xls");
        workbook03.write(fileOutputStream);
        fileOutputStream.close();

        //获取程序结束时系统的时间且转换成秒
        long end = System.currentTimeMillis();
        //计算前后总计花费多长时间
        System.out.println((double) (end-begin)/1000);
    }
}
