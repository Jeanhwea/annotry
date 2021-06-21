package io.github.jeanhwea.cheatsheet;

import java.util.*;

/**
 * 二叉树
 *
 * @author Jinghui Hu
 * @since 2021-06-12, JDK1.8
 */
public class DS04Tree {

  // 二叉树定义
  public static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 递归求树的高度
  public static int height(TreeNode root) {
    if (root == null) return 0;
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 层序遍历求树的高度
  public static int height2(TreeNode root) {
    if (root == null) return 0;

    int depth = 0;

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);
    while (!nodes.isEmpty()) {
      int n = nodes.size();
      for (int i = 0; i < n; i++) {
        TreeNode p = nodes.poll();
        if (p.left != null) nodes.offer(p.left);
        if (p.right != null) nodes.offer(p.right);
      }
      depth++;
    }

    return depth;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 二叉树前序遍历
  public static List<Integer> preorder(TreeNode root) {
    List<Integer> values = new LinkedList<>();
    if (root == null) return values;
    return preorder0(root, values);
  }

  public static List<Integer> preorder0(TreeNode root, List<Integer> values) {
    if (root == null) return null;

    values.add(root.val);
    if (root.left != null) preorder0(root.left, values);
    if (root.right != null) preorder0(root.right, values);

    return values;
  }

  public static List<Integer> preorder1(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<Integer> values = new LinkedList<>();
    Deque<TreeNode> nodes = new LinkedList<>();
    nodes.push(root);
    while (!nodes.isEmpty()) {
      root = nodes.pop();
      values.add(root.val);
      if (root.right != null) nodes.push(root.right);
      if (root.left != null) nodes.push(root.left);
    }

    return values;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 二叉树中序遍历
  public static List<Integer> inorder(TreeNode root) {
    List<Integer> values = new LinkedList<>();
    if (root == null) return values;
    return inorder0(root, values);
  }

  public static List<Integer> inorder0(TreeNode root, List<Integer> values) {
    if (root == null) return null;

    if (root.left != null) inorder0(root.left, values);
    values.add(root.val);
    if (root.right != null) inorder0(root.right, values);

    return values;
  }

  public static List<Integer> inorder1(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<Integer> values = new LinkedList<>();
    Deque<TreeNode> nodes = new LinkedList<>();
    while (root != null || !nodes.isEmpty()) {
      while (root != null) {
        nodes.push(root);
        root = root.left;
      }
      root = nodes.pop();
      values.add(root.val);
      root = root.right;
    }

    return values;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // 二叉树后序遍历
  public static List<Integer> postorder(TreeNode root) {
    List<Integer> values = new LinkedList<>();
    if (root == null) return values;
    return postorder0(root, values);
  }

  public static List<Integer> postorder0(TreeNode root, List<Integer> values) {
    if (root == null) return null;

    if (root.left != null) postorder0(root.left, values);
    if (root.right != null) postorder0(root.right, values);
    values.add(root.val);

    return values;
  }

  // 后序遍历第一种实现
  public static List<Integer> postorder1(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<Integer> values = new LinkedList<>();
    Deque<TreeNode> nodes = new LinkedList<>();
    nodes.push(root);
    while (!nodes.isEmpty()) {
      TreeNode p = nodes.pop();
      values.add(p.val);
      if (p.left != null) nodes.push(p.left);
      if (p.right != null) nodes.push(p.right);
    }

    Collections.reverse(values);
    return values;
  }

  // 后序遍历第二种实现
  public static List<Integer> postorder2(TreeNode root) {
    if (root == null) return new LinkedList<>();

    List<Integer> values = new LinkedList<>();
    Deque<TreeNode> nodes = new LinkedList<>();
    TreeNode prev = null;
    while (root != null || !nodes.isEmpty()) {
      while (root != null) {
        nodes.push(root);
        root = root.left;
      }
      root = nodes.peek();
      if (root.right == prev || root.right == null) {
        values.add(root.val);
        prev = nodes.pop();
        root = null;
      } else {
        root = root.right;
      }
    }

    return values;
  }

  public static void main(String[] args) {
    // List<TreeNode> trees = new LinkedList<>();
    // TreeNode tree1 = null;
    // TreeNode tree2 = TreeNode.makeTree(new int[] {1});
    // TreeNode tree3 = TreeNode.makeTree(new int[] {1, 2, 3, 4, 5});
    // TreeNode tree4 = TreeNode.makeTree(new int[] {1, 2, 3, -1, 4, 5, 6, -1, -1, 7});
    // TreeNode tree5 = TreeNode.makeTree(new int[] {1, 2, 3, 4});
    // trees.add(tree1);
    // trees.add(tree2);
    // trees.add(tree3);
    // trees.add(tree4);
    // trees.add(tree5);

    // System.out.println("===== tree list =====");
    // for (TreeNode t : trees) {
    //   TreeNode.display(t);
    // }

    // System.out.println("===== tree depth =====");
    // for (TreeNode t : trees) {
    //   String out = String.format("depth = %d, depth2 = %d", depth(t), depth2(t));
    //   System.out.println(out);
    // }

    // System.out.println("===== Pre-Order =====");
    // for (TreeNode t : trees) {
    //   List<Integer> v0 = preorder(t);
    //   System.out.println(Arrays.toString(v0.toArray()));
    //   List<Integer> v1 = preorder1(t);
    //   System.out.println(Arrays.toString(v1.toArray()));
    // }

    // System.out.println("===== In-Order =====");
    // for (TreeNode t : trees) {
    //   List<Integer> v0 = inorder(t);
    //   System.out.println(Arrays.toString(v0.toArray()));
    //   List<Integer> v1 = inorder1(t);
    //   System.out.println(Arrays.toString(v1.toArray()));
    // }

    // System.out.println("===== Post-Order =====");
    // for (TreeNode t : trees) {
    //   // TreeNode.display(t);
    //   List<Integer> v0 = postorder(t);
    //   System.out.println(Arrays.toString(v0.toArray()));
    //   List<Integer> v1 = postorder1(t);
    //   System.out.println(Arrays.toString(v1.toArray()));
    //   List<Integer> v2 = postorder2(t);
    //   System.out.println(Arrays.toString(v2.toArray()));
    // }
  }
}