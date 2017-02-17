import org.junit.Test;

import java.util.Arrays;

/**
 * Created by vrastil on 17.2.2017.
 */
public class CodilityContSemiprimesTest {
    //prime numbers
    //2,3,5,7,11,13,17,19,23,29,31 ....
    @Test
    public void testIt() {
        int[] P = new int[]{1, 4, 16};
        int[] Q = new int[]{26, 10, 20};
        int[] solution = solution(26, P, Q);
        for (int i : solution) {
            System.out.printf(" result " + String.valueOf(i));
        }
    }

    public int[] solution(int N, int[] P, int[] Q) {
        int[] result = new int[P.length];

        boolean[] primes = new boolean[N*N];
        Arrays.fill(primes, true);
        //find prime numbers up to N
        for (int i = 2; i < N; i++) {
            if (primes[i]) {
                for (int j = 2; j * i < N; j++) {
                    primes[(i * j)-1] = false;
                }
            }
        }
        //return semi primes in range
        for (int i = 0; i < P.length; i++) {
            for (int j = P[i]; j < Q[i]; j++) {
                if (!primes[j]) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}
