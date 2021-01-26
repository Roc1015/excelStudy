package com.roc.excel.EasyController;

import java.util.List;

/**
 * @author WP
 * @date 2021/1/26  10:15
 */
public class EasyExcelDao {

    public void save(List<EasyExcelReadDemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }

}
