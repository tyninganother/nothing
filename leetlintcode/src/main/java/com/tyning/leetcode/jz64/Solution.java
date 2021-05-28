package com.tyning.leetcode.jz64;

//剑指 Offer 64. 求1+2+…+n
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
//
//
//示例 1：
//
//输入: n = 3
//输出: 6
//示例 2：
//
//输入: n = 9
//输出: 45
//
//
//限制：
//
//1 <= n <= 10000
// https://leetcode-cn.com/problems/qiu-12n-lcof/

public class Solution {
    public static int sumNums(int n) {
        boolean a = (n > 1) && ((n = n + sumNums(n - 1)) > 0);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(0));
    }
}
