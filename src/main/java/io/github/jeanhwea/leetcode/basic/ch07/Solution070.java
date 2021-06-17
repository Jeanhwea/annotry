package io.github.jeanhwea.leetcode.basic.ch07;

/**
 * 爬楼梯
 *
 * @author Jinghui Hu
 * @since 2021-06-13, JDK1.8
 */
public class Solution070 {

  public static int climbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    for (int i = 1; i < 6; i++) {
      System.out.println(climbStairs(i));
    }
  }
}
