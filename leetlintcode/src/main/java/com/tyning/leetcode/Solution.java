package com.tyning.leetcode;

import com.tyning.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author haining
 */
public class Solution {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * <p>
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        //遍历左节点
        //打印当前节点值
        //左边是否有节点，有的话就进去做
        List<String> binaryTreePathsList = new ArrayList<>();
        if (root == null) {
            return binaryTreePathsList;
        }
        binaryTreePathsList.add(String.valueOf(root.getVal()));
        if (root.getLeft() != null) {
            binaryTreePathsList.addAll(binaryTreePaths(root.getLeft()));
        }
        if (root.getRight() != null) {
            binaryTreePathsList.addAll(binaryTreePaths(root.getLeft()));
        }
        return binaryTreePathsList;

    }


    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        String path = null;
        boolean result = hasPathSum(root, sum, 0, path) != null;
        if (result) {
            System.out.println(path);
        }
        return result;
    }

    public static Integer hasPathSum(TreeNode root, int sum, int totalSum, String path) {
        if (root == null) {
            return null;
        }
//        Map path = "" + root.val;
        if (root.left == null && root.right == null && (totalSum + root.val) == sum) {
            System.out.println(path);
            return root.val;
        }
        Integer result = null;
        if (root.left != null) {
            result = hasPathSum(root.left, sum, totalSum + root.val, path);
        }
        if (root.right != null && result == null) {
            result = hasPathSum(root.right, sum, totalSum + root.val, path);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.setRight(new TreeNode(5));
        root.setLeft(left);
        root.setRight(new TreeNode(3));
        System.out.println(hasPathSum(root, 4));
//        Solution solution = new Solution();
//        List<String> solutionList = solution.binaryTreePaths(root);
//        System.out.println();
    }
}
