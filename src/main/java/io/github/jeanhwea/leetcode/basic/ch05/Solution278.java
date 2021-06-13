package io.github.jeanhwea.leetcode.basic.ch05;

import java.util.*;

/**
 * 第一个错误的版本
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution278 {

  private static boolean isBadVersion(int version) {
    return version > 0;
  }

  public static int firstBadVersion(int n) {
    int i = 1, j = n;

    while (i <= j) {
      int k = i + (j - i) / 2;
      if (!isBadVersion(k - 1) && isBadVersion(k)) return k;
      else if (isBadVersion(k)) j = k - 1;
      else i = k + 1;
    }

    return -1;
  }

  public static void main(String args[]) {
    System.out.println(firstBadVersion(6));
  }
}
