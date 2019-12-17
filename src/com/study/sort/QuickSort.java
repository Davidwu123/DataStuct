package com.study.sort;


import com.study.common.Log;

import java.util.Arrays;

/**
 * @author wuwei
 * @title: QuickSort
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-17 11:17
 */
public class QuickSort extends BaseSort {
    private static final String TAG = QuickSort.class.getSimpleName();

    @Override
    int[] sort(int[] array, int size) {
        quickSort(array, 0, size -1);
        Log.d(TAG, Arrays.toString(array));
        return null;
    }

    //第一轮演示
    //[4, 6, 5, 1, 8, 2, 7, 4, 6, 1, 3, 2]
    //[1, 6, 5, 1, 8, 2, 7, 4, 6, 4, 3, 2]
    //[1, 1, 5, 6, 8, 2, 7, 4, 6, 4, 3, 2]
    //[1, 1, 2, 6, 8, 2, 7, 4, 6, 4, 3, 5]
    private void quickSort(int[] arr, int from, int to) {
        if (from >= to) {
            return;
        }
        int keyItem = arr[to];
        int i = from;
        int j = to;
        while (i < j) {//必须让i=j才能退出
            //必须加==,否则进入死循环，否则i和j不可能相遇
            while (arr[i] <= keyItem && i < j) {//退出表示遇到了比key大的
                i++;
            }
            while (arr[j] >= keyItem && i < j) {//退出表示遇到了比key小的
                j--;
            }
//            Log.d(TAG, "i and j " + i + "\t " + j);
            //每一轮比较好后swap i j
//            swap(arr[i], arr[j]);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
//            Log.d(TAG, "temp" + Arrays.toString(arr));
        }
        //退出的条件为i=j;将keyItem的值放到arr[i]
        arr[to] = arr[i];//交换a[i]和keyItem的值
        arr[i] = keyItem;
        quickSort(arr, from, i - 1);
        quickSort(arr, i + 1, to);
    }

}
