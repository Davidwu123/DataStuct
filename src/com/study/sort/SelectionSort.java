package com.study.sort;

/**
 * @author wuwei
 * @title: SelectionSort
 * @projectName DataStuct
 * @description: 选择排序
 * @date 2019-12-08 17:02
 */
public class SelectionSort extends BaseSort{


    /**
     * 主要思想:为已排序和未排序两部分，选择最小的，记录index，然后交换当前首位元素
     * 最左边为已经排好序的，从已经排好序i的下一个i+1开始找剩下的最小的,然后和i位置替换
     * @param array
     * @param size
     * @return
     */
    @Override
    public int[] sort(int[] array, int size) {
        if (size <= 1) {
            return array;
        }
        //4 5 6 2 3 1
        //->1 5 6 2 3 4
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
