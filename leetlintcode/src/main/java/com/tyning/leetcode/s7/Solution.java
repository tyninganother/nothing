package com.tyning.leetcode.s7;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学
// 👍 2333 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-534236469));
    }

    /**
     * 这个题目使用字符串转变成数组的形式并不是太好，空间复杂度太大
     * 对x模10可以得到最后一位的数字，然后取余a1.a1%10得到x的倒数第二位数字，依次可以取到所有的数字。
     * 组成反转后的数字就是将之前得到的a1...an乘以相应10的倍数再相加。便得到了反转后的数子。
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        char[] xchars = String.valueOf(x).toCharArray();
        int flag = (xchars[0] == '-') ? 1 : 0;
        char[] newXChars = new char[xchars.length];
        newXChars[0] = '-';
        for (int i = 0; i < xchars.length - flag; i++) {
            newXChars[xchars.length - 1 - i] = xchars[i + flag];
        }
        Long toLong = Long.valueOf(new String(newXChars));
        return toLong > Long.valueOf(Integer.MAX_VALUE) || toLong < Long.valueOf(Integer.MIN_VALUE) ? 0 : toLong.intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
