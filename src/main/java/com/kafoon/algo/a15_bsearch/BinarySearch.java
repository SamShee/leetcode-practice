package com.kafoon.algo.a15_bsearch;

public class BinarySearch {

    public static void main(String[] args) {

    }

    /**
     * 原始二分查找，获取数组a中和value相等元素的位置；不考虑数据重复问题
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearch(int[] a, int n, int value){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value){
                low = mid + 1;
            }else if(a[mid] > value){
                high = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    /**
     * 二分查找变体方式：数据有重复，查找第一个value相同的数据
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearchFindFirst(int[] a, int n, int value){
        int low = 0;
        int high = n;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                low = mid + 1;
            }else if(a[mid] < value){
                high = mid -1;
            }else{
                if(mid == 0 || a[mid - 1] != value)
                    return mid;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找变体二：数据有重复，查找最后一个与value相同的数据
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearchFindLast(int[] a, int n, int value){
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if(a[mid] > value){
                high = mid - 1;
            }else if(a[mid] < value){
                low = mid + 1;
            }else{
                if(mid == n-1 || a[mid+1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变体三：查找第一个大于等于value的数据
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearchFindFirstGt(int[] a, int n, int value){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] >= value){
                if(mid == 0 || a[mid-1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找变体四：查找最后一个小于或者等于value的数据
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearchFindLastLt(int[] a, int n, int value){
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value){
                if(mid == n-1 || a[mid+1] > value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else {
                high = mid -1;
            }
        }

        return -1;
    }

}
