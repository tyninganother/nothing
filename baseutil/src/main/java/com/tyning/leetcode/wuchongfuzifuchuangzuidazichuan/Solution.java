package com.tyning.leetcode.wuchongfuzifuchuangzuidazichuan;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s != null){
            s = s.replaceAll(" ","~");
        }
        //通过对字符串中每一个字符进行比较
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int ilen = 0;
            for (int j = i; j < s.length(); j++) {
                //i 到j 中有没有相同的字符
                //没有相同的字符那么就更新最大长度
                String zStr = s.substring(i, j);
                if (!cotend(zStr)) {
                    ilen = j - i;
                    maxLen = maxLen >= ilen ? maxLen : ilen;
                    System.out.println("c|"+zStr+"|" + maxLen + "|" + ilen);
                    continue;
                } else {
                    System.out.println("unc|"+zStr+"|" + maxLen + "|" + ilen);
                }
            }
        }
        return maxLen;
    }

    public static boolean cotend(String str) {
        for (char aa : str.toCharArray()) {
            if (str.indexOf(aa + "") != str.lastIndexOf(aa + "")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(cotend("aba"));
//        System.out.println("a".indexOf("a")+"|"+"a".lastIndexOf("a"));;
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
//        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
//        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
