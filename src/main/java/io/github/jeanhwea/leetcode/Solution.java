package io.github.jeanhwea.leetcode;

import java.util.*;

@SuppressWarnings("all")
public class Solution {

  public static void main(String[] args) {
    int[][] a = {
      {1, 2, 3},
      {5, 6, 7},
      {9, 8, 1},
      {9, 8, 1}
    };
    System.out.println(visitMatrix(a));
  }

  public static List<Integer> visitMatrix(int[][] a) {
    List<Integer> ans = new LinkedList<>();

    int n = a.length, m = a[0].length;
    for (int i = 0; i < n; i++) {
      int x = m - 1, y = i;
      while (x >= 0 && y >= 0) ans.add(a[y--][x--]);
    }

    for (int j = m - 2; j >= 0; j--) {
      int x = j, y = n - 1;
      while (x >= 0 && y >= 0) ans.add(a[y--][x--]);
    }

    return ans;
  }
}
