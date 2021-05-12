package Chpt3.item14;

import java.util.Objects;
import java.util.Comparator;
import java.io.Serializable;

public class objectReference {
    /*
     * 우선 comparing 이라는 정적 메서드 2개가 다중정의되어 있다. 첫 번째는 키 추출자를 받아서 그 키의 자연적 순서를 사용한다.
     */

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable) (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    // 두 번째는 키 추출자 하나와 추출된 키를 비교할 비교자까지 총 2개의 인수를 받는다.

    public static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator) {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return (Comparator<T> & Serializable) (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1),
                keyExtractor.apply(c2));
    }

    /*
     * 또한 thenComparing이란 인스턴스 메서드가 3개 다중정의되어 있다. 첫 번째는 비교자 하나만 인수로 받아 그 비교자로 부차 순서를
     * 정한다.
     */

    default Comparator<T> thenComparing(Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return (Comparator<T> & Serializable) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }
    /* 두 번째는 키 추출자를 인수로 받아 그 키의 자연적 순서로 보조 순서를 정한다. */

    default <U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator) {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }
    /* 마지막 세 번째는 키 추출자와 추출된 키를 비교할 비교자까지 총 2개의 인수를 받는다. */

    default <U extends Comparable<? super U>> Comparator<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }
}
