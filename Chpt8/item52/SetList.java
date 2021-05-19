package Chpt8.item52;

import java.util.*;

// 이 프로그램은 무엇을 출력할까? (315-316쪽)
public class SetList {
  public static void main(String[] args) {
      Set<Integer> set = new TreeSet<>();
      List<Integer> list = new ArrayList<>();

      for (int i = -3; i < 3; i++) {
          set.add(i);
          list.add(i);
      }
      for (int i = 0; i < 3; i++) {
          set.remove(i); 
          list.remove(i); // 다중정의에 의해서 index에 해당하는 값을 없앤다.
          // list.remove((Integer) i);
      }
      System.out.println(set + " " + list);
  }
}