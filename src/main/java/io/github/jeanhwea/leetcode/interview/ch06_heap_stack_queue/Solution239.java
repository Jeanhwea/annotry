package io.github.jeanhwea.leetcode.interview.ch06_heap_stack_queue;

import java.util.*;

/**
 * 滑动窗口最大值
 *
 * @author Jinghui Hu
 * @since 2021-06-19, JDK1.8
 */
@SuppressWarnings("all")
public class Solution239 {

  // 优先队列
  public static int[] maxSlidingWindow(int[] a, int k) {
    int n = a.length;
    int[] b = new int[n - k + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] != y[0] ? y[1] - x[1] : 0);

    for (int i = 0; i < n; i++) {
      pq.offer(new int[] {i, a[i]});
      if (i + 1 >= k) {
        while (pq.peek()[0] < i - k + 1) pq.poll();
        b[i - k + 1] = pq.peek()[1];
      }
    }

    return b;
  }

  // 单调队列 使用双向队列保存第 k 大的数字
  public static int[] maxSlidingWindow0(int[] a, int k) {
    int n = a.length;
    int[] b = new int[n - k + 1];
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      // System.out.printf("dq=%s\n", dq.toString());
      if (dq.isEmpty() || a[dq.peekLast()] > a[i]) {
        dq.addLast(i);
      } else {
        while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
          dq.removeLast();
        }
        dq.addLast(i);
      }
      if (i + 1 >= k) {
        while (dq.peekFirst() < i - k + 1) {
          dq.removeFirst();
        }
        b[i - k + 1] = a[dq.peekFirst()];
      }
    }
    return b;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] b = maxSlidingWindow(a, 3);
    System.out.println(Arrays.toString(b));
  }
}
