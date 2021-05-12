package Chpt3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s){
        this.s = Objects.requireNonNull(s);
    }

    @Override // 대소문자를 구분하지 않는다.
    public boolean equals(Object o){
        // check 'same object and have same element'
        return o instanceof CaseInsensitiveString && (((CaseInsensitiveString) o).s).equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("poLIsh");
        String s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s)); // false
        System.out.println(cis.equals(s)); // false
        System.out.println(cis.equals(cis2)); // true
    }
}