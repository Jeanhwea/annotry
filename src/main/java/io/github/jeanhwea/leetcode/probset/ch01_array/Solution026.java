package io.github.jeanhwea.leetcode.probset.ch01_array;

import java.util.*;

/**
 * 删除有序数组中的重复项
 *
 * @author Jinghui Hu
 * @since 2021-06-28, JDK1.8
 */
@SuppressWarnings("all")
public class Solution026 {

  public static int removeDuplicates(int[] a) {
    int n = a.length;

    if (n <= 1) return n;

    int k = 1;
    for (int i = 1; i < n; i++) {
      if (a[i] != a[k - 1]) {
        a[k++] = a[i];
      }
    }
    return k;
  }

  public static void main(String[] args) {
    // int[] a = {1, 2, 2, 3};
    int[] a = {1, 1, 1, 1};
    // int[] a = {};
    int k = removeDuplicates(a);
    int[] b = Arrays.copyOfRange(a, 0, k);
    System.out.println(Arrays.toString(b));
  }
}
