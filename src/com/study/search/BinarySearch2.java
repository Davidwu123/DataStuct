package com.study.search;

/**
 * @author wuwei
 * @title: BinarySearch2
 * @projectName DataStuct
 * @description: 针对含有重复数据的有序数组进行二分查找
 * @date 2019-12-18 11:19
 */
public class BinarySearch2 extends BaseSearch{
    @Override
    int search(int key, int[] arr, int p, int q) {
        return 0;
    }


    /**
     * 非递归查找从左侧第count个等于key的下标（非递归实现）
     * 思路：先找到第一个出现的下标，再在此基础上加count-1即为最终结果
     */
    int noRecSearchKeyByCount(int key, int count, int[] arr, int low, int high) {
        //先找到第一个出现的位置
        while (low <= high) {//一直遍历出最后一个元素
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < key) {//在mid的左侧
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {//mid位置等于，这时候需要判断：判断左侧是否还有等于该值的，如果是则继续
                if (mid == 0 || arr[mid - 1] != key) {
                    //目标item is mid + count -1;
                    if ((mid + count - 1) < arr.length && arr[mid + count - 1] == key) {
                        return mid + count - 1;
                    } else {
                        return -1;
                    }
                } else {//还需要检查左侧
                    high = mid -1;
                }
            }
        }
        return -1;
    }


    /**
     * 递归查找从左侧第count个等于key的下标（非递归实现）
     */
    int recSearchKeyByCount(int key, int count, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] < key) {//应该在右边
            return recSearchKeyByCount(key, count, arr, mid + 1, high);
        } else if (arr[mid] > key) {//应在左边
            return recSearchKeyByCount(key, count, arr, low, mid - 1);
        } else {//等于
            if (mid == 0 || arr[mid - 1] != key) {
                //add count
                if ((mid + count - 1) < arr.length && arr[mid + count - 1] == key) {
                    return mid + count - 1;
                } else {
                    return -1;
                }
            } else {//还在左侧
                return recSearchKeyByCount(key, count, arr, low, mid -1);
            }
        }
    }


    /**
     * 递归查找最后出现的key所在的index
     */
    int recSearchKeyByEnd(int key, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] < key) {
            return recSearchKeyByEnd(key, arr, mid + 1, high);
        } else if (arr[mid] > key) {
            return recSearchKeyByEnd(key, arr, low, mid - 1);
        } else {
            if (mid == arr.length - 1 || arr[mid + 1] != key) {
                return mid;
            } else {
                return recSearchKeyByEnd(key, arr, mid + 1, high);
            }
        }
    }

}
