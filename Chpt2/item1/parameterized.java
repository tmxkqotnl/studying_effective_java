// 기본적인 형인자 자료형 선언
Map<String, List<Strubg>> m = new HashMap<String, List<String>>();

// 정적 팩토리 메서드 사용
public static<K, V> HashMap<K, V> newInstance() { return new HashMap<K, V>(); }
Map<String, List<String>> m = HashMap.newInstance();