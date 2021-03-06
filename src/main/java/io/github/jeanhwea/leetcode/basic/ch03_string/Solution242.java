package io.github.jeanhwea.leetcode.basic.ch03_string;

/**
 * 有效的字母异位词
 *
 * @author Jinghui Hu
 * @since 2021-06-09, JDK1.8
 */
@SuppressWarnings("all")
public class Solution242 {

  public static boolean isAnagram(String s, String t) {
    int n = s.length(), m = t.length();
    if (n != m) return false;

    int total = 26;
    int[] a = new int[total], b = new int[total];
    for (int i = 0; i < n; i++) {
      a[s.charAt(i) - 'a'] += 1;
      b[t.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i < total; i++) {
      if (a[i] != b[i]) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "nl", t = "cx";
    System.out.println(isAnagram(s, t));
  }
}
