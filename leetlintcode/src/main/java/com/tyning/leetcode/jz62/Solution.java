package com.tyning.leetcode.jz62;

//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
//
//例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
//
// 
//
//示例 1：
//
//输入: n = 5, m = 3
//输出:3
//示例 2：
//
//输入: n = 10, m = 17
//输出:2
//
//
//限制：
//
//1 <= n<= 10^5
//1 <= m <= 10^6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Solution {

    public static int lastRemaining(int n, int m) {
        int[] initn = new int[n];
        for(int i=0;i<n;i++){
            initn[i] = i;
        }
        int[] temp = new int[m];
        //填充temp
        //initn的长度大于m的话就使用这个方法填充
        if (initn.length >= m) {
            for (int i = 0; i < m; i++) {
                temp[i] = initn[i];
            }
        } else {

        }
        //取出最后一个元素
        int result = temp[m-1];
        //将最后一个元素从initn中去除
        initn[m-1] = -1;
        //重新赋值init
        for (int i = 0;i<initn.length;i++){

        }
        return result;
    }

    public static void main(String[] args) {
//        int result = lastRemaining(0, 3);
//        System.out.println(result);
//        PriorityQueue queue = new PriorityQueue();
//        queue.add()
        System.out.println(4%17);

    }
}
