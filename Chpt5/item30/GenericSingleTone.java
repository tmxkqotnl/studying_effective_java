package Chpt5.item30;
import java.util.function.UnaryOperator;

import org.graalvm.compiler.graph.spi.Canonicalizable.Unary;

public class GenericSingleTone {
    //identity function
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction(){
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args){
        String[] strings = {"sambae","daema","nailon"};
        Number[] numbers = {1,2.0,3L};

        UnaryOperator<String> sameString = identityFunction();
        UnaryOperator<Number> sameNumber = identityFunction();

        for(String s : strings){
            System.out.println(s);
        }
        for(Number n : numbers){
            System.out.println(n);
        }
    }
}
