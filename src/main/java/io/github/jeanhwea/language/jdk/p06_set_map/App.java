package io.github.jeanhwea.language.jdk.p06_set_map;

import java.util.*;

/**
 * 集合和哈希表
 *
 * @author Jinghui Hu
 * @since 2021-07-26, JDK1.8
 */
@SuppressWarnings("all")
public class App {

  public static void test01() {
    // 集合
    Set<Integer> set1 = new HashSet<>();
    set1.add(3);
    set1.add(3);
    set1.add(4);
    set1.contains(4);

    // 散列表
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("a", 3);
    map1.put("b", 4);
    map1.put("b", 8);
    map1.putIfAbsent("b", 8);
    map1.get("c"); // 查找 key, 如果不存在返回 null
    map1.getOrDefault("c", 0);

    map1.containsKey("s");
    map1.containsValue(8);

    map1.keySet(); // 键的集合
    map1.values(); // 值的集合
    map1.entrySet(); // 键值对的集合
  }

  public static void test02() {
    // 有序集合
    SortedSet<Integer> set1 = new TreeSet<>();
    set1.add(3);
    set1.add(3);
    set1.add(4);
    set1.add(5);
    set1.add(9);
    set1.contains(4);
    SortedSet<Integer> heads1 = set1.headSet(4);
    SortedSet<Integer> tails1 = set1.tailSet(4);
    SortedSet<Integer> sub1 = set1.subSet(4, 9);
    // System.out.println(heads1);
    // System.out.println(tails1);
    // System.out.println(sub1);
  }

  public static void main(String[] args) {
    test01();
    test02();
  }
}
