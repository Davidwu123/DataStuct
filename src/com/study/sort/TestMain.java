package com.study.sort;


import com.study.common.Log;

import java.util.Arrays;

/**
 * @author wuwei
 * @title: TestMain
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-08 17:49
 */
public class TestMain {
    public static final String TAG = TestMain.class.getSimpleName();

    public static void main(String[] arg) {
        int[] array = new int[] {4, 6, 5, 1, 8, 2, 7, 4, 6, 1, 3, 2};
        Log.d(TAG, "raw sort: " + Arrays.toString(array));
        //答案[1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8]
//        Log.d(TAG, "select sort: " + Arrays.toString(new SelectionSort().sort(array, array.length)));
//        Log.d(TAG, "bubble sort: " + Arrays.toString(new BubbleSort().sort(array, array.length)));
//        Log.d(TAG, "insertion sort: " + Arrays.toString(new InsertionSort().sort(array, array.length)));
//        Log.d(TAG, "merge sort: " + Arrays.toString(new MergeSort().sort(array, array.length)));
        Log.d(TAG, "quick sort: " + Arrays.toString(new QuickSort().sort(array, array.length)));
    }
}
