package com.study.sort;


/**
 * @author wuwei
 * @title: BubbleSort
 * @projectName DataStuct
 * @description: 冒泡排序
 * @date 2019-12-08 17:53
 */
public class BubbleSort extends BaseSort {


    /**
     * 主要思想：只需要相邻两个比较，满足条件后交换顺序
     * @param array
     * @param size
     * @return
     */
    @Override
    int[] sort(int[] array, int size) {
        //4 5 6 2 3 1
        //-> 4 5 2 3 1 6
        if (size <= 1) {
            return array;
        }
        for (int i = 0; i < size; i++) {
            //add 对于不需要排序的直接退出本轮比较
            boolean isSorted = true;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        return array;
    }
}
