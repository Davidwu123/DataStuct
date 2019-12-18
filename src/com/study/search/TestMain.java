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
        Log.d(TAG, "优化后的二分非递归实现, index is " +  new BinarySearch2().noRecSearchKeyByCount(1000, 2, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分递归实现, index is " +  new BinarySearch2().recSearchKeyByCount(30, 2, orderedArr, 0, orderedArr.length - 1));
        Log.d(TAG, "优化后的二分递归实现, 查找最后一个，index is " +  new BinarySearch2().recSearchKeyByEnd(2345, orderedArr, 0, orderedArr.length - 1));
    }
}
