// 서비스 제공자 인터페이스의 대략적인 모습

// 서비스 인터페이스 
public interface Service { 
    ... // 서비스에 고유한 메서드들이 이 자리에 온다. 
}

// 서비스 제공자 인터페이스
public interface Provider {
   Service newService();
}

// 서비스 등록과 접근에 사용되는 객체 생성 불가능 클래스
public class Services {

   private Services() {
   } // 객체 생성 방지

   // 서비스 이름과 서비스 간 대응관계 보관
   private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
   public static final String DEFAULT_PROVIDER_NAME = "<def>";

   // 제공자 등록 API
   public static void registerDefaultProvider(Provider p) {
       registerProvider(DEFAULT_PROVIDER_NAME, p);
   }

   public static void registerProvider(String name, Provider p) {
       providers.put(name, p);
   }

   // 서비스 접근 API
   public static Service newInstance() {
       return newInstance(DEFAULT_PROVIDER_NAME);
   }

   public static Service newInstance(String name) {
       Provider p = providers.get(name);
       if (p == null)
           throw new IllegalArgumentException("No provider registered with name: " + name);
       return p.newService();
   }
}

// Source : https://12bme.tistory.com/192