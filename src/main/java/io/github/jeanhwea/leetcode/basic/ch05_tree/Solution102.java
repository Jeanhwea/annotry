package io.github.jeanhwea.leetcode.basic.ch05_tree;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
@SuppressWarnings("all")
public class Solution102 {

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();

    if (root==null) return ans;

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while (!nodes.isEmpty()) {
      List<Integer> level = new LinkedList<>();
      int n = nodes.size();
      for (int i = 0; i < n; i++) {
        TreeNode p = nodes.poll();
        level.add(p.val);
        if (p.left!=null) nodes.offer(p.left);
        if (p.right!=null) nodes.offer(p.right);
      }
      ans.add(level);
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {3, 9, 20, -1, 15, 7});
    TreeNode.dispTree(tree1);
    List<List<Integer>> ans = levelOrder(tree1);
    System.out.println("done");
  }
}
