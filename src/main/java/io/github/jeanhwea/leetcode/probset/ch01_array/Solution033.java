package io.github.jeanhwea.leetcode.probset.ch01_array;

/**
 * 搜索旋转排序数组
 *
 * @author Jinghui Hu
 * @since 2021-06-20, JDK1.8
 */
@SuppressWarnings("all")
public class Solution033 {

  /**
   * 将数组一分为二，必定一个子数组有序，判断 target 是否在有序组中来进行二分查找
   *
   * @author Jinghui Hu
   * @since 2021-06-20, JDK1.8
   */
  public static int search(int[] a, int target) {
    int n = a.length, beg = 0, end = n - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      // System.out.println(mid);
      if (a[mid] == target) return mid;

      if (a[beg] <= a[mid]) {
        if (a[beg] <= target && target < a[mid]) {
          end = mid - 1;
        } else {
          beg = mid + 1;
        }
      } else {
        if (a[mid] < target && target <= a[end]) {
          beg = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {4, 5, 0, 1, 2};
    System.out.println(search(a, 5));
  }
}
