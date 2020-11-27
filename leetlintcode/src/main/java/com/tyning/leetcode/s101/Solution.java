package com.tyning.leetcode.s101;

//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 1128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.tyning.leetcode.TreeUtil;
import com.tyning.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<TreeNode> list = TreeUtil.createTree(array);
        isSymmetric(list.get(0));
    }

    public static boolean isSymmetric(TreeNode root) {
        List<Integer> leftNOdes = new ArrayList<>();
        hou(root.left, leftNOdes);
        System.out.println("left");
        leftNOdes.forEach(s-> System.out.println(s));
        List<Integer> rightNOdes = new ArrayList<>();
        System.out.println("right");
        xian(root.right, rightNOdes);
        rightNOdes.forEach(s-> System.out.println(s));
        return false;
    }

    public static List<Integer> hou(TreeNode root, List<Integer> rootNodes) {
        if (root == null){
            return rootNodes;
        }
        rootNodes.addAll(hou(root.right,rootNodes));
        rootNodes.addAll(hou(root.left,rootNodes));
        rootNodes.add(root.val);
        return rootNodes;
    }

    public static List<Integer> xian(TreeNode root, List<Integer> rootNodes) {
        if (root == null){
            return rootNodes;
        }
        rootNodes.addAll(xian(root.left,rootNodes));
        rootNodes.addAll(xian(root.right,rootNodes));
        rootNodes.add(root.val);
        return rootNodes;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

