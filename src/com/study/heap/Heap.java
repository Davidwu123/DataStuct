package com.study.heap;

import com.study.common.Log;

import java.util.Arrays;

/**
 * @author wuwei
 * @title: Heap
 * @projectName DataStuct
 * @description: TODO
 * @date 2020-02-15 22:21
 */
public class Heap {
    private int[] mArray;
    private int mCapability;//最多可以存储的元素个数
    private int mCount = 0;//已有的元素个数，且元素下表从1开始

    public Heap(int capability) {
        this.mCapability = capability;
        this.mArray = new int[capability];
    }


    /**
     * 插入元素
     * <P>
     * 若空间已经满了，则插入失败
     * @param data 元素
     * @return 插入是否成功
     */
    public boolean insert(int data) {
        //优先处理边界条件
        if (mCount > mCapability) return false;
        mArray[++mCount] = data;
        heapifyDown2Up(mArray, mCount);
        return true;
    }

    private void heapifyDown2Up(int[] array, int count) {
        //新增元素后，自下而上堆化：最后一个元素和父节点比较，大于父节点交换位置，循环操作
        int idx = count;
        while (idx / 2 > 0 && array[idx] > array[idx / 2]) {
            swap(array, idx, idx / 2);
            idx = idx / 2;
        }
    }

    private void swap(int[] array, int idxA, int idxB) {
        int temp = array[idxA];
        array[idxA] = array[idxB];
        array[idxB] = temp;
    }

    /**
     * 删除堆顶元素，默认大顶堆
     * <p>
     * 思路：
     * 1.(X)将堆顶元素比较下移并交换。但最终结构并不是完全二叉树，又重新树化，并且把空白的删除掉
     * 2.(✅)直接将需要删除的堆顶元素最后一个元素作为空白的，并将原本最后一个元素作为堆顶元素，然后树化。(相比方法一，前一部分工作不需要
     * 做了)
     * @return 删除是否成功
     */
    public boolean remove() {
        //边界条件
        if (mCount < 1) return false;
        mArray[1] = mArray[mCount];
        mArray[mCount--] = 0;//最后的元素要置位
//        heapifyUp2Down1(mArray, mCount, 1);
        heapifyUp2Down2(mArray, mCount, 1);
        return true;
    }

    private void heapifyUp2Down1(int[] array, int count, int start) {
        int idx = start;
        while (idx * 2 <= count && idx * 2 + 1 <= mCount && mArray[idx] < max(mArray, idx * 2, idx * 2 + 1)) {
            int maxIdx = array[idx * 2] > mArray[idx * 2 + 1] ? idx * 2 : idx * 2 + 1;
            swap(mArray, idx, maxIdx);
            idx = maxIdx;
        }
    }

    private int max(int[] array, int i, int j) {
        if (array[i] > array[j]) {
            return array[i];
        } else {
            return array[j];
        }
    }


    private void heapifyUp2Down2(int[] array, int count, int start) {
        int idx = start;
        int maxIdx = idx;
        while (true) {
            if (2 * idx <= count && array[idx] < array[2 * idx]) maxIdx = 2 * idx;
            if (2 * idx + 1 <= count && array[maxIdx] < array[2 * idx + 1]) maxIdx = 2 * idx + 1;
            if (maxIdx == idx) break;//若相等说明本节点都大于左右子节点，无需继续比较了
            swap(array, idx, maxIdx);
            idx = maxIdx;
        }
    }


    public String toString() {
        return Arrays.toString(mArray);
    }


    public static void main(String[] arg) {
        Heap heap = new Heap(10);
        heap.insert(3);
        heap.insert(34);
        heap.insert(12);
        heap.insert(10);
        heap.insert(1);
        heap.insert(7);
        Log.d(Heap.class, "插入后堆的打印为：" + heap.toString());
        heap.remove();
        Log.d(Heap.class, "删除后堆的打印为：" + heap.toString());
    }

}
