package practice;

import org.junit.Test;

public class CodilityCountFactorsTest {
    @Test
    public void testIt() {
        System.out.println(solution(24));
    }

    public int solution(int N) {
        int factorCount = 0;
        double i = 1;

        while (i * i < N) {
            if ((N % i) == 0) {
                factorCount += 2;
            }
            i++;
        }

        if (i * i == N) {
            factorCount++;
        }

        return factorCount;
    }
}
