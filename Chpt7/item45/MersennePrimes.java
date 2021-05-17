import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

// 스트림을 사용해 처음 20개의 메르센 소수를 생성한다. (274쪽)
public class MersennePrimes {
    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
      // 종단 연산의 결과물을 통해 거꾸로 매핑하기
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }
}