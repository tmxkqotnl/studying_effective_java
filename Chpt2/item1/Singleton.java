package Chpt2.item1;


import java.util.Objects;

public class Singleton {
    private static Singleton singleton = null;
    Singleton(){}

    // 싱글톤 접근 메서드
    public static Singleton getinstance(){
        if(Objects.isNull(singleton)){
            singleton = new Singleton();
        }
        return singleton;
    }
}
