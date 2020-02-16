package com.study.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuwei
 * @title: Utils
 * @projectName DataStuct
 * @description: TODO
 * @date 2020-02-16 14:00
 */
public class Utils {


    public static String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:sss");
        return sdf.format(d);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 自上而下堆化：和左右子节点中最大的元素交换位置
     * @param array
     * @param count
     * @param start
     */
    public static void heapifyUp2Down(int[] array, int count, int start) {
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

}
