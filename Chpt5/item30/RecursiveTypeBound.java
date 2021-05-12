package Chpt5.item30;
import java.util.*;

class RecursiveTypeBound{
    // 모든 타입 E는 자기 자신과 비교할 수 있다.
    // IllegalArgumentException을 피하기 위해서 Optional<E>를 반환하도록 하는 것이 좋을 수 있다.
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }
    public static void main(String[] args){
        List<String> argList = Arrays.asList(args);
        System.out.println(max(argList));
    }
}