package io.github.jeanhwea.leetcode.interview.ch09;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 *
 * @author Jinghui Hu
 * @since 2021-06-15, JDK1.8
 */
public class SolutionA68 {

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Deque<TreeNode> nodes = new LinkedList<>();
    nodes.push(root);
    parent.put(root, null);
    while (!nodes.isEmpty()) {
      TreeNode c = nodes.pop();
      if (parent.containsKey(p) && parent.containsKey(q)) break;
      if (c.left != null) {
        parent.put(c.left, c);
        nodes.push(c.left);
      }
      if (c.right != null) {
        parent.put(c.right, c);
        nodes.push(c.right);
      }
    }

    while (p != null) {
      TreeNode t = q;
      while (t != null) {
        if (t == p) return p;
        t = parent.get(t);
      }
      p = parent.get(p);
    }

    return null;
  }

  public static void main(String args[]) {
    TreeNode tree1 = TreeNode.makeTree(new int[] {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
    TreeNode.display(tree1);
    TreeNode p = findNode(tree1, 5);
    TreeNode q = findNode(tree1, 1);
    TreeNode ans = lowestCommonAncestor(tree1, p, q);
    System.out.println(ans.val);
  }

  private static TreeNode findNode(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    TreeNode p = findNode(root.left, val);
    TreeNode q = findNode(root.right, val);
    return p == null ? q : p;
  }
}
