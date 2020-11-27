package com.tyning.leetcode;


import com.tyning.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree util
 *
 * @author haining
 */
public class TreeUtil {

    public static List<TreeNode> createTree(int[] array) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            //创建结点，每一个结点的左结点和右结点为null
            TreeNode node = new TreeNode(array[i], null, null);
            // list中存着每一个结点
            list.add(node);
        }
        // 构建二叉树
        if (list.size() > 0) {
            // i表示的是根节点的索引，从0开始
            for (int i = 0; i < array.length / 2 - 1; i++) {
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
        return list;
    }

    // 遍历，先序遍历
    public static void print(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            print(node.left);
            print(node.right);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<TreeNode> list = TreeUtil.createTree(array);
        print(list.get(0));
    }
}
