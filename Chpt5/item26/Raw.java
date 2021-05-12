package Chpt5.item26;
import java.util.*;

// Runtime error
class Raw{
    public static void main(String[] args){
        List<String> list = new ArrayList<>(); //ArrayList<String>
        unsafeAdd(list,Integer.valueOf(42)); 
        String s = list.get(0); // 컴파일러가 자동으로 형변환을 시도

       /*  unsafeAdd_(list, "42");
        unsafeAdd_(list, Integer.valueOf(42)); */
    }

    // raw type. do not use it
    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }
    
    // generic type
    private static <T> void unsafeAdd_(List<T> list, T o){
        list.add(o);
    }
}