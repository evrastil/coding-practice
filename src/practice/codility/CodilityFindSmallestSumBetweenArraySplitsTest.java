package practice.codility;

import org.junit.Test;

/**
 * Created by vrastil on 11.2.2017.
 */
public class CodilityFindSmallestSumBetweenArraySplitsTest {

    @Test
    public void testIt() {
        int[] array = new int[]{3, 1, 2, 4, 3};
        System.out.println(solution(array));
    }

    public int solution(int[] A) {
        int sumAll = 0;
        for (int i = 0; i < A.length; i++) {
            sumAll += A[i];
        }
        int smallestSumSoFar = -1;
        int rightToLeftSum = 0;
        for (int i = A.length - 1; i > 0; i--) {
            rightToLeftSum += A[i];
            int leftToRightSum = sumAll - rightToLeftSum;
            int absDiff = Math.abs(rightToLeftSum - leftToRightSum);
            if (smallestSumSoFar == -1) {
                smallestSumSoFar = absDiff;
            }
            if (absDiff < smallestSumSoFar) {
                smallestSumSoFar = absDiff;
            }
        }
        return smallestSumSoFar;
    }
}
