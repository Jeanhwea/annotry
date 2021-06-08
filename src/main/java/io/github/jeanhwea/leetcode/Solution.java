package io.github.jeanhwea.leetcode;

import java.util.*;

public class Solution {

  public static int[] intersect(int[] a, int[] b) {
    int n = a.length, m = b.length;
    Set<Integer> st = new HashSet<>();
    List<Integer> c = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st.add(b[i]);
    }
    for (int i = 0; i < n; i++) {
      if (st.contains(a[i])) {
        c.add(a[i]);
      }
    }

    int[] res = new int[c.size()];
    for (int i = 0; i < c.size(); i++) {
      res[i] = c.get(i);
    }
    return res;
  }

  public static void main(String args[]) {
    // int[] a = genArray(6);
    // display(a);
    // System.out.println("========================================");
    // System.out.println(containsDuplicate(a));

    int[] a = new int[] {4, 9, 5};
    int[] b = new int[] {9, 4, 9, 8, 4};
    display(a);
    display(b);
    System.out.println("========================================");
    int[] c = intersect(a, b);
    System.out.println(c);
    for (int i = 0; i < c.length; i++) {
      System.out.println(c[i]);
    }
  }

  ////////////////////////////////////////////////////////////////////////////////
  public static int[] genArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (int) (Math.random() * 30);
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
