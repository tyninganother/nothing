package com.tyning.leetcode.s3;

//3. 无重复字符的最长子串
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//示例 4:
//
//输入: s = ""
//输出: 0
//
//
//提示：
//
//0 <= s.length <= 5 * 104
//s 由英文字母、数字、符号和空格组成

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        char[] strChars = s.toCharArray();
        if (strChars == null || strChars.length < 1) {
            return 0;
        }
        //创造循环 指定窗口
        int left = 0;
        int right = 0;
        int max = 0;
        // 每一次循环就是检测现在的right对应的值是否符合left到right-1字符串的的要求
        while (right < strChars.length) {
            // 判断新添加的char在新的字符数组中存在的位置
            int leftDoubleNum = existsDoubleCharNum(strChars, left, right - 1, strChars[right]);
            // 两个地方求max的方法不一样。第一处是遍历到最后一位求此时的长度应该考虑right位置上的数字
            // 第二处是新添加char时包含这个char的值，求得是left到right-1字符串这个字符串的长度
            if (leftDoubleNum != -1) {
                max = Math.max(max, right - 1 - left + 1);
                if (right != (strChars.length - 1) && left != right) {
                    left = leftDoubleNum + 1;
                }
            } else {
                if (right == (strChars.length - 1)) {
                    max = Math.max(max, right - 1 - left + 1 + 1);
                }
            }
            ++right;
        }
        return max;
    }

    public static int existsDoubleCharNum(char[] strChars, int left, int right, char c) {
        for (int i = left; i <= right; i++) {
            if (strChars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
//        for (int i =0 ;i<2;++i){
//            int a = i;
//        }
    }
}
