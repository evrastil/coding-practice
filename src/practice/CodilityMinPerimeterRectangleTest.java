package practice;

import org.junit.Test;

public class CodilityMinPerimeterRectangleTest {
    @Test
    public void testIt() {
        System.out.println(solution(30));
    }

    public int solution(int N) {
        int smallestSumSoFar = N;
        int A = 1;
        int B = N;
        while (A <= B) {
            if (N % A == 0) {
                B = N / A;
                int sum = A + B;
                if (sum < smallestSumSoFar) {
                    smallestSumSoFar = sum;
                }
            }
            A++;

        }
        return smallestSumSoFar * 2;
    }
}
