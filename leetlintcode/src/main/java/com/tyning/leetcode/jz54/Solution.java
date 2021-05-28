package com.tyning.leetcode.jz54;

import java.util.ArrayList;
import java.util.List;

//给定一棵二叉搜索树，请找出其中第k大的节点。
//
// 
//
//示例 1:
//
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4
//示例 2:
//
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4
// 
//
//限制：
//
//1 ≤ k ≤ 二叉搜索树元素个数
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        list = kthLargest(root, k, list);
        return list.get(k-1);
    }

    public static List<Integer> kthLargest(TreeNode root, int k, List<Integer> list) {
        // 先右后左的中序遍历
        if (root.right != null){
            kthLargest(root.right, k, list);
        }
        list.add(root.val);
        //判断遍历个数，解决无用的遍历次数
        if (list.size() >= k){
            return list;
        }
        if (root.left != null){
            kthLargest(root.left, k, list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2, null, null)), new TreeNode(4, null, null));
        int reult = kthLargest(root, 1);
        System.out.println(reult);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
