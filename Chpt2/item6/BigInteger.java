package Chpt2.item6;

// java.math.BigInteger.valueOf메서드의 코드
public class BigInteger {
    public static final BigInteger ZERO = new BigInteger(new int[0], 0);

    private final static int MAX_CONSTANT = 16;
    private static BigInteger posConst[] = new BigInteger[MAX_CONSTANT + 1];
    private static BigInteger negConst[] = new BigInteger[MAX_CONSTANT + 1];

    static {
        /* posConst에 1 ~ 16까지의 BigInteger 값을 담는다. */
        /* negConst에 -1 ~ -16까지의 BigInteger 값을 담는다. */
    }

    public static BigInteger valueOf(long val) {
        // 미리 만들어둔 객체를 리턴한다
        if (val == 0)
            return ZERO;
        if (val > 0 && val <= MAX_CONSTANT)
            return posConst[(int) val];
        else if (val < 0 && val >= -MAX_CONSTANT)
            return negConst[(int) -val];

        // 새로운 객체를 만들어 리턴한다
        return new BigInteger(val);
    }
}
