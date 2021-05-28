package com.tyning.leetcode.jz32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
// 
//
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
//提示：
//
//节点总数 <= 1000
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list = levelOrder(root,0,list);
        return list;
    }

    public static List<List<Integer>> levelOrder(TreeNode root, int deep, List<List<Integer>> list) {
        if (root == null){
            return null;
        }
        if (list.size() < (deep+1)) {
            list.add(deep, new ArrayList<>());
        }
        list.get(deep).add(root.val);
        if (root.left != null) {
            levelOrder(root.left, deep + 1, list);
        }
        if (root.right != null) {
            levelOrder(root.right, deep + 1, list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2, null, null)), new TreeNode(4, null, null));
        List<List<Integer>> list = new ArrayList<>();
        list = levelOrder(root);
        for (List<Integer> integers : list) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
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
