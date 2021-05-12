package Chpt5.item33;

import java.util.*;

// 타입 안전 이종 컨테이너 패턴 (199-202쪽)

// Class 객체를 제네릭이 아닌 로 타입으로 넘기면 인스턴스의 타입 안전성이 쉽게 깨진다.
// 실체화 불가 타입에는 사용할 수 없다. 즉, List<String> 와 같이는 저장할 수 없다.
public class Favorites {
    // 코드 33-3 타입 안전 이종 컨테이너 패턴 - 구현 (200쪽)
    // 와일드카드 타입이 중첩되어, 키가 와일드카드 타입이 된다.
    // 즉, 모든 키가 서로 다른 매개변수화 타입일 수 있음을 뜻함
    private Map<Class<?>, Object> favorites = new HashMap<>();

    /* public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    } */

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    // 코드 33-4 동적 형변환으로 런타임 타입 안전성 확보 (202쪽)
    // class와 값 사이의 타입 관계를 보증한다.
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    // 코드 33-2 타입 안전 이종 컨테이너 패턴 - 클라이언트 (199쪽)
    public static void main(String[] args) {
        Favorites f = new Favorites();
        
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
       
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        
        System.out.printf("%s %x %s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());
    }
}