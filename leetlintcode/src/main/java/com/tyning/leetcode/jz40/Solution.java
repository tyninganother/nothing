package com.tyning.leetcode.jz40;

import java.util.Arrays;

//剑指 Offer 40. 最小的k个数
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
//示例 1：
//
//输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//示例 2：
//
//输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//限制：
//
//0 <= k <= arr.length <= 10000
//0 <= arr[i] <= 10000
//通过次数189,692提交次数333,542
// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
class Solution {

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k < 1 || arr == null || arr.length < 1){
            return new int[]{};
        }
        // 1.进行排序然后从左往右找到k个数字
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int [] resultarr = new int[k];
        for (int i =0;i<k;i++){
            resultarr[i] = arr[i];
        }
        return resultarr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        System.out.println(Arrays.toString(getLeastNumbers(arr,2)));
    }
}

