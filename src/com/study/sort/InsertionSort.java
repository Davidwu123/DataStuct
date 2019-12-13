package com.study.sort;

/**
 * @author wuwei
 * @title: InsertionSort
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-08 18:12
 */
public class InsertionSort extends BaseSort {

    /**
     * 主要思路：分为已排序和未排序两部分，每次从未排序中按照i遍历选择一个插入已经排序j的部分（需要倒序遍历j比较）
     * @param array
     * @param size
     * @return
     */
    @Override
    int[] sort(int[] array, int size) {
        if (size <= 1) {
            return array;
        }
        for (int i = 1; i < size; i++) {
            int val = array[i];
            int j = i - 1;
            //第二个循环为已经排序好的数组,因为要移动，且val位置是可以覆盖的，所以必须j递减
            for (; j >= 0; j--) {
                if (val < array[j]) {
                    array[j + 1] = array[j];
                } else {//遇到判断点退出，并且将val赋值到next位置
                    break;
                }
            }
            array[j + 1] = val;
        }
        return array;
    }
}
