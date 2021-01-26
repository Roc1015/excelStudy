package com.roc.excel.EasyController;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WP
 * @date 2021/1/26  9:40
 */
public class EasyExcelWriteTest {

    String Path = "excelStudy";

    private List<EasyExcelWriteDemoData> data() {
        List<EasyExcelWriteDemoData> list = new ArrayList<EasyExcelWriteDemoData>();
        for (int i = 0; i < 10; i++) {
            EasyExcelWriteDemoData data = new EasyExcelWriteDemoData();
            data.setString( "字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    //根据List写入数据
    /**
     * 最简单的写
     * <p>1. 创建excel对应的实体对象 参照{@link EasyExcelWriteDemoData}
     * <p>2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        // 写法1
        String fileName = Path + "EasyExcel.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        //write方法
        //fileName
        //格式从实体类中取
        //sheet名字自定义
        //doWrite写data中的数据
        EasyExcel.write(fileName, EasyExcelWriteDemoData.class).sheet("模板").doWrite(data());
    }
}



//        // 写法2
//        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(fileName, EasyExcel.class).build();
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            excelWriter.write(data(), writeSheet);
//        } finally {
//            // 千万别忘记finish 会帮忙关闭流
//            if (excelWriter != null) {
//                excelWriter.finish();
//            }
//        }