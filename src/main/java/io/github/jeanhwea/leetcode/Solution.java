package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static int strStr(String s, String t) {
    if (t.isEmpty()) return 0;

    int n = s.length(), m = t.length();
    for (int i = 0; i < n - m + 1; i++) {
      boolean found = true;
      for (int j = 0; j < m; j++) {
        if (s.charAt(i + j) != t.charAt(j)) {
          found = false;
          break;
        }
      }
      if (found) return i;
    }

    return -1;
  }

  public static void main(String args[]) {
    // pass
    System.out.println(strStr("aabc", ""));
    System.out.println(strStr("aabc", "ab"));
    System.out.println(strStr("aabc", "c"));
    System.out.println(strStr("aabc", "a"));
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static int[] genArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 50);
    }
    return a;
  }

  public static void display(int[] a) {
    System.out.println(Arrays.toString(a));
  }

  public static void display(Collection<Integer> a) {
    System.out.println(Arrays.toString(a.toArray()));
  }
}
