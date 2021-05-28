package com.tyning.leetcode.s149;

//149. 直线上最多的点数
//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
//
//示例 1:
//
//输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o
//+------------->
//0  1  2  3  4
//示例 2:
//
//输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6
//通过次数23,381提交次数92,074
// https://leetcode-cn.com/problems/max-points-on-a-line/

public class Solution {

    public static int maxPoints(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }
        // 将所有的数组的第一位和第二位相减 然后x轴和y轴差值一样的维维数组
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int maxij = 2;
                int x2 = points[j][0];
                int y2 = points[j][1];
                for (int k = j + 1; k < points.length; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    // y2-y1 : x2-x1 = y3 - y1 : x3 - x1 然后为了避免除法的除数为0的情况改为乘法 (y3 * (x1 - x2) + x3 * (y2 - y1)) == (y2 * x1 - y1 * x2)
                    if ((y3 * (x1 - x2) + x3 * (y2 - y1)) == (y2 * x1 - y1 * x2)) {
                        maxij = maxij + 1;
                    }
                }
                max = Math.max(maxij, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int result = lastRemaining(0, 3);
//        System.out.println(result);
//        PriorityQueue queue = new PriorityQueue();
//        queue.add()
        int[][] points = {{1, 2}, {2, 4}, {5, 6}};
//        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
//        int[][] points = {{1, 0}, {0, 0}};
//        int[][] points = {{2, 3}, {1, 1}};
        System.out.println(maxPoints(points));

    }
}
