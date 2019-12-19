package com.study.search;

import com.study.common.Log;

/**
 * @author wuwei
 * @title: TestMain
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-17 19:47
 */
public class TestMain {
    private static final String TAG = TestMain.class.getSimpleName();
    public static void main(String[] a) {
        int[] orderedArr = new int[]{1, 2, 4, 30, 30, 200, 583, 1000, 1000, 1230, 2345};
//        Log.d(TAG, "b search 1, index is " +  new BinarySearch().search(10400, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分非递归实现, index is " +  new BinarySearch2().noRecSearchIdByCount(1000, 2, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分递归实现, index is " +  new BinarySearch2().recSearchIdByCount(30, 2, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分递归实现, 查找最后一个，index is " +  new BinarySearch2().recSearchLastId(2345, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分非递归实现, 第一次出现大于等于，index is " +  new BinarySearch2().noRecSearchFirstBiggerId(1010, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分递归实现, 第一次出现大于等于，index is " +  new BinarySearch2().recSearchFirstBiggerId(1010, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分递归实现, 最后一个小于等于，index is " +  new BinarySearch2().recSearchLastSmallerId(30, orderedArr, 0, orderedArr.length - 1));
        int[] loopSortedArr1 = new int[] {4,6,14,17,20,1,3};
        int[] loopSortedArr2 = new int[] {10,9,8,5,20,15,13,11};
        Log.d(TAG, "循环有序数组二分非递归实现，递增index is " + new BinarySearch2().noRecSearchIdFromLoopSortedArr(1, loopSortedArr1, 0, loopSortedArr1.length - 1));
        Log.d(TAG, "循环有序数组二分非递归实现，递减index is " + new BinarySearch2().noRecSearchIdFromLoopSortedArr(11, loopSortedArr2, 0, loopSortedArr2.length - 1));
    }
}
