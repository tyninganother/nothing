package com.tyning.leetcode.jz03;

//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//示例 1：
//
//输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
// 
//
//限制：
//
//2 <= n <= 100000
//
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 这个方法执行超时
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 使用的是现在hashset 如果插入成功的话就是没有如果插入失败就是重复
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        HashSet set = new HashSet(nums.length);
        for (int a : nums) {
            if(!set.add(a)){
                return a;
            }
        }
        return -1;
    }
    /**
     * 利用条件  数组中的元素一定时0到n-1的数字 所以就是0到n-1的一个乱序
     * 那么就将下标和数字放在同样的位置
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]){
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
