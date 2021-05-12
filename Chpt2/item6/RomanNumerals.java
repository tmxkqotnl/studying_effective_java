package Chpt2.item6;

// 지연 초기화로 사용할 때 초기화 하도록 할 수 있지만
// 코드만 복잡해지고 그렇게 큰 성능의 향상을 기대할 수 없다.
//  권장하지 않는다.

import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^(?=. )M*(C[MD]|D?C{0,3})"+"(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
