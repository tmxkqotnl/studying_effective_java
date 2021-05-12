package Chpt5.item30;
import java.util.*;

class Union{
    // parameters must have the same type
    public static <E> Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args){
        Set<String> guys = Set.of("Tom","dick","Harry");
        Set<String> stooges = Set.of("Rarry","moe","Curry");
        Set<String> aflCio = union(guys,stooges);
        System.out.println(aflCio); // lexicographical order
    }
}