package practice.codility;

import org.junit.Test;

/**
 * Created by vrastil on 17.2.2017.
 */
public class CodilityChocolatesByNumbersTest {
    @Test
    public void testIt() {
        System.out.println(solution(10, 4));
    }

    public int solution(int N, int M) {
        return N / (gcd(M, N));
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}