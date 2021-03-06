package io.github.jeanhwea.leetcode.basic.ch04_list;

/**
 * 反转链表
 *
 * @author Jinghui Hu
 * @since 2021-06-11, JDK1.8
 */
@SuppressWarnings("all")
public class Solution206 {

  public static ListNode reverseList(ListNode head) {
    ListNode p = head, q = head;

    while (p != null) {
      if (p == head) {
        p = p.next;
        head.next = null;
      } else {
        q = head;
        head = p;
        p = p.next;
        head.next = q;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.makeList(new int[] {1, 2, 3, 4, 5});
    ListNode.dispList(head);
    System.out.println("========================================");
    head = reverseList(head);
    ListNode.dispList(head);
  }
}
