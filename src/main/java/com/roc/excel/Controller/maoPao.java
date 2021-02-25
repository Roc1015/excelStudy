package com.roc.excel.Controller;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: WP
 * @date: 2021/2/25 23:34
 */
public class maoPao {

    public static void main(String[] args) {
        int[] list = {4,3};
        System.out.println("\n\n\n\n"+"list数组:"+Arrays.toString(list));
        System.out.println("list数组中有"+list.length+"个数");

        for (int i = 0 ; i < list.length; i++){
            for (int j = 0; j < list.length -1 - i ; j++){
                if (list[j] > list[j+1]){
                    int temp = list[j];
                    System.out.println(temp);
                    list[j] = list[j+1];
                    System.out.println(list[j]);
                    list[j+1] = temp;
                    System.out.println(list[j+1]);
                }
            }
        }
        System.out.println("经过冒泡排序后的list数组："+Arrays.toString(list)+"\n\n\n\n");
    }
}
