package com.study.search;

import com.study.common.Log;

/**
 * @author wuwei
 * @title: BinarySerach
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-17 19:46
 */
public class BinarySearch extends BaseSearch{
    private static final String TAG = BinarySearch.class.getSimpleName();


    //递归写法，TODO 还需要优化
    @Override
    int search(int key, int[] arr, int low, int high) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);//可能low 大于high
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return search(key, arr, low, mid - 1);
        } else {
            return search(key, arr, mid + 1, high);
        }
    }


    public int search2(int key, int[] arr, int p, int q) {
        int low = p;
        int high = q;
        while (low <= high) {//等于号注意
//            int mid = (low + high) / 2;//可能会有溢出风险；low + (high - low) / 2
            int mid = low + ((high - low) >> 1);//向右移动一位相当于/2
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {//真实数据在左边
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
