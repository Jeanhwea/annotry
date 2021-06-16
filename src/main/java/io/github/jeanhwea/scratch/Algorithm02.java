package io.github.jeanhwea.scratch;

import java.util.*;

/**
 * 回溯法
 *
 * @author Jinghui Hu
 * @since 2021-06-15, JDK1.8
 */
public class Algorithm02 {

  public static List<String> tokenize(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);

    List<List<String>> sentences = new LinkedList<>();
    List<String> choose = new LinkedList<>();
    backtrack(s, 0, choose, sentences, dict);

    List<String> ans = new LinkedList<>();
    for (int i = 0; i < sentences.size(); i++) {
      String str = String.join(" ", sentences.get(i));
      ans.add(str);
    }
    return ans;
  }

  // 回溯函数
  public static void backtrack(
      String s, int k, List<String> choose, List<List<String>> sentences, Set<String> dict) {
    int n = s.length();
    if (k == n) {
      System.out.println(choose);
      sentences.add(new ArrayList<String>(choose));
      return;
    }

    for (int i = k; i < n; i++) {
      String word = s.substring(k, i + 1);
      choose.add(s.substring(k, i + 1));
      backtrack(s, i + 1, choose, sentences, dict);
      choose.remove(choose.size() - 1);
    }
  }

  // 回溯函数，带剪枝
  public static void backtrack1(
      String s, int k, List<String> choose, List<List<String>> sentences, Set<String> dict) {
    int n = s.length();
    if (k == n) {
      sentences.add(new ArrayList<String>(choose));
      return;
    }

    for (int i = k; i < n; i++) {
      String word = s.substring(k, i + 1);
      if (dict.contains(word)) {
        choose.add(s.substring(k, i + 1));
        backtrack1(s, i + 1, choose, sentences, dict);
        choose.remove(choose.size() - 1);
      }
    }
  }

  public static void testTokenize() {
    String s = "abcb";
    List<String> wordDict = Arrays.asList("a", "bc", "ac", "b");
    System.out.println(s);
    System.out.println(wordDict);
    System.out.println("========================================");
    List<String> ans = tokenize(s, wordDict);
    System.out.println("----------------------------------------");
    System.out.println(ans);
  }

  public static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void perm(int[] a, int k, List<Integer> choose, List<List<Integer>> ans) {
    System.out.printf("k=%d, choose=%s\n", k, choose.toString());

    int n = a.length;
    if (k >= n) {
      ans.add(new ArrayList<>(choose));
      System.out.println(choose);
      return;
    }

    for (int i = k; i < n; i++) {
      choose.add(a[i]);
      swap(a, k, i);
      perm(a, k + 1, choose, ans);
      swap(a, k, i);
      choose.remove(choose.size() - 1);
    }
  }

  public static void main(String args[]) {
    int[] a = {1, 2, 3};
    List<Integer> choose = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();
    perm(a, 0, choose, ans);
  }
}
