/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Sort
 * Author:   Stones
 * Date:     2021/3/11 19:50
 * Description: 冒泡排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kafoon.algo.a11_sort;

/**
 * 〈一句话功能简述〉<br> 
 * 〈冒泡排序〉
 *
 * @author Stones
 * @create 2021/3/11
 * @since 1.0.0
 */
public class Sort {
    /**
     * 冒泡排序
     * @param items 数组
     * @param n 数组大小
     */
    public static void bubbleSort(int[] items, int n){
        if(n <= 1) return;

        for(int i = 0; i < n; i++){
            //优化点，如果新的一轮冒泡没有元素交换，那么认为有序，可以直接退出
            boolean flag = false;
            for(int j = 0;j < n-i-1; j++){
                if(items[j] > items[j+1]){
                    int tmp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = tmp;

                    //发生数据交换
                    flag = true;
                }
            }

            if(!flag) break;

        }

    }

    /**
     * 插入排序
     * @param a  数组
     * @param n  数组大小
     */
    public static void insertionSort(int[] a, int n){
        if(n <= 1) return;

        for(int i = 1;i < n; ++i){
            //当前需要插入的位置的元素
            int value = a[i];
            //前面有序空间的最后一个元素
            int j = i -1;
            for(;j > 0; j--){
                if(a[j] > value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    /**
     * 选择排序
     * @param a  数组
     * @param n  数组大小
     */
    public static void selectionSort(int[] a, int n){
        if(n <= 1) return;

        for(int i = 0; i < n-1; i++){
            int min = i;
            //从i+1起，找到比i位置元素还要小的元素的角标
            for(int j = i+1; j < n; j++){
                if(a[j] < a[i]){
                    min = j;
                }
            }

            //交换i位置和min位置的元素
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;

        }
    }




    public static void main(String[] args) {

    }



}
