package com.study.sort;

import com.study.common.Utils;

/**
 * @author wuwei
 * @title: HeapSort
 * @projectName DataStuct
 * @description: TODO
 * @date 2020-02-16 14:50
 */
public class HeapSort extends BaseSort {

    @Override
    int[] sort(int[] array, int size) {
        if (array == null || size == 0) return null;
        int count = array.length - 1;
        buildHeap(array, count);//堆化
        innerSort(array, count);//排序
        return array;
    }

    /**
     * 思路：完全二叉树最后一个元素下标为count。且非叶子节点是从count/2下标开始的
     * <p>
     * 叶子节点不需要进行堆化了，省去不必要的操作.从count / 2下标开始到第一个节点进行循环堆化
     * 时间复杂度为O(n)
     * @param array
     * @param count
     */
    private void buildHeap(int[] array, int count) {
        for (int i = count / 2; i >= 1; i--) {
            Utils.heapifyUp2Down(array, count, i);
        }
    }

    /**
     * 思路：对于已经堆化好的数组，堆顶元素为最大的，因此将最大的和最后一个元素位置交换swap(1, count)
     * 然后堆前count - 1个数据进行堆化，由于改变的是堆顶元素，所以按照自上而下的方式进行堆化，直至剩余最后一个元素
     * 时间复杂度为O(nlogn)
     * @param array
     */
    private void innerSort(int[] array, int count) {
        int idx = count;
        while (idx > 1) {//for(;idx > 1;)
            Utils.swap(array, 1, idx--);//交换时不比较大小，相同的也会交换，因此为不稳定的排序
            Utils.heapifyUp2Down(array, idx, 1);
        }
    }
}
