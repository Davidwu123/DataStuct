package com.study.sort;

import com.study.common.Log;

import java.util.Arrays;

/**
 * @author wuwei
 * @title: MergeSort
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-15 15:27
 */
public class MergeSort extends BaseSort {

    private static final String TAG = MergeSort.class.getSimpleName();

    @Override
    int[] sort(int[] array, int size) {
        mergeSort(array, 0, size - 1);
        Log.d(TAG, Arrays.toString(array));
        return null;
    }

    private void mergeSort(int[] arr, int from, int to) {
        int mid = (to + from) / 2;
        if (from < to) {
            mergeSort(arr, from, mid);
            mergeSort(arr, mid + 1, to);
            mergeArr(arr, from, mid, to);
        }
    }

    private void mergeArr(int[] arr, int from, int mid, int to) {
        int i = from;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[to + 1 - from];
        while (i <= mid && j <= to && i < j) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (j <= to) {//必须加==否则最后一个值不会赋值到temp里面
            temp[k++] = arr[j++];
        }
        while (i <= mid) {//必须加==否则最后一个值不会赋值到temp里面
            temp[k++] = arr[i++];
        }
        for (i = 0; i <= to - from; i++) {
            arr[from + i] = temp[i];
        }
    }

}
