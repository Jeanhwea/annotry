package io.github.jeanhwea.leetcode.interview.ch07;

import java.util.*;

/**
 * 相交链表
 *
 * @author Jinghui Hu
 * @since 2021-06-16, JDK1.8
 */
public class Solution160 {

  public ListNode getIntersectionNode(ListNode p, ListNode q) {
    Set<ListNode> st = new HashSet<>();
    while (p != null) {
      st.add(p);
      p = p.next;
    }
    while (q != null) {
      if (st.contains(q)) return q;
      q = q.next;
    }
    return null;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode p = headA, q = headB;
    while (p != q) {
      p = p == null ? headB : p.next;
      q = q == null ? headA : q.next;
    }
    return p;
  }

  public static void main(String args[]) {
    // pass
  }
}
