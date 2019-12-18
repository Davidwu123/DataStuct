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
    int search(int val, int[] arr, int p, int q) {
        return 0;
    }


    /**
     * 非递归查找从左侧第count个等于val的下标（非递归实现）
     * 思路：先找到第一个出现的下标，再在此基础上加count-1即为最终结果
     */
    int noRecSearchIdByCount(int val, int count, int[] arr, int low, int high) {
        //先找到第一个出现的位置
        while (low <= high) {//一直遍历出最后一个元素
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < val) {//在mid的左侧
                low = mid + 1;
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {//mid位置等于，这时候需要判断：判断左侧是否还有等于该值的，如果是则继续
                if (mid == 0 || arr[mid - 1] != val) {
                    //目标item is mid + count -1;
                    if ((mid + count - 1) < arr.length && arr[mid + count - 1] == val) {
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
     * 递归查找从左侧第count个等于val的下标（非递归实现）
     */
    int recSearchIdByCount(int val, int count, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] < val) {//应该在右边
            return recSearchIdByCount(val, count, arr, mid + 1, high);
        } else if (arr[mid] > val) {//应在左边
            return recSearchIdByCount(val, count, arr, low, mid - 1);
        } else {//等于
            if (mid == 0 || arr[mid - 1] != val) {
                //add count
                if ((mid + count - 1) < arr.length && arr[mid + count - 1] == val) {
                    return mid + count - 1;
                } else {
                    return -1;
                }
            } else {//还在左侧
                return recSearchIdByCount(val, count, arr, low, mid -1);
            }
        }
    }


    /**
     * 递归查找最后出现的val所在的index
     */
    int recSearchLastId(int val, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] < val) {
            return recSearchLastId(val, arr, mid + 1, high);
        } else if (arr[mid] > val) {
            return recSearchLastId(val, arr, low, mid - 1);
        } else {
            if (mid == arr.length - 1 || arr[mid + 1] != val) {
                return mid;
            } else {
                return recSearchLastId(val, arr, mid + 1, high);
            }
        }
    }

    /**
     * 非递归查找第一次出现大于等于val所在的index
     */
    int noRecSearchFirstBiggerId(int val, int[] arr, int low, int high) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= val) {//出现了大于等于的地方，需要判断前一个是否是小于的
                if (mid == 0 || arr[mid - 1] < val) {
                    return mid;
                } else {//左边的还是大于等于val，继续缩小范围
                    high = mid - 1;
                }
            } else {//val大于mid所在位置的值，
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归查找第一次出现大于等于val所在的index
     */
    int recSearchFirstBiggerId(int val, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] >= val) {
            if (mid == 0 || arr[mid - 1] < val) {
                return mid;
            } else {
                return recSearchFirstBiggerId(val, arr, low, mid - 1);
            }
        } else {
            return recSearchFirstBiggerId(val, arr, mid + 1, high);
        }
    }

    /**
     * 递归查找最后一个小于等于val的index
     */
    int recSearchLastSmallerId(int val, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] <= val) {//表示已初步找到了，还需判断是不是最后一个小于/等于改值的
            if (mid == arr.length - 1 || arr[mid + 1] > val) {//如果右边的大于该值，则返回mid
                return mid;
            } else {//右边的还是小于等于val，则继续向右找
                return recSearchLastSmallerId(val, arr, mid + 1, high);
            }
        } else {//val小于arr[mid],mid左侧全部比val大，要找比val小的，只能往左侧找
            return recSearchLastSmallerId(val, arr, low, mid - 1);
        }
    }



}
