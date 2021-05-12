package Chpt5.item31;

import java.util.*;

public class Union {
    // 반환 타입에는 한정적 와일드카드를 사용해선 안된다. 그렇게되면, 클라이언트 코드에도 와일드카드 타입을 써야한다.
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);

        Set<Double> doubles = new HashSet<>();
        doubles.add(2.0);
        doubles.add(4.0);
        doubles.add(6.0);

        
        // // 코드 31-6 자바 7까지는 명시적 타입 인수를 사용해야 한다.   (186쪽)
        // Set<Number> numbers = Union.<Number>union(integers, doubles);  
        Set<Number> numbers = union(integers, doubles); // 목표 타이핑
        System.out.println(numbers);
    }
}
