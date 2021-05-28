package com.tyning.leetcode.jz48;

import java.util.HashSet;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 遍历所有的子串
     * 注意：i是从0开始到n-1
     *  j是i+1
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 1){
            return 1;
        }
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            HashSet set = new HashSet();
            set.add(chars[i]);
            //去遍历每一个子串
            for (int j = i + 1; j < chars.length; j++) {
                if (!set.add(chars[j])) {
                    int a = j - i;
                    if (num < a) {
                        num = a;
                    }
                    break;
                } else if (j == chars.length - 1){
                    int a = j - i + 1;
                    if (num < a) {
                        num = a;
                    }
                    break;
                }
            }
        }
        return num;
    }

    /**
     * 用动态规划
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        return 1;
    }

    public static void main(String[] args) {
//        String s = "au";
//        System.out.println(lengthOfLongestSubstring(s));
        System.out.println('c' - 'a');
    }
}
