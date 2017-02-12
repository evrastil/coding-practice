import org.junit.Test;

import java.util.Arrays;

/**
 * Created by eda on 12.2.2017.
 */
public class CodilityCountAbsDistinctValuesTest {
    @Test
    public void testIt() {
        int[] arr = new int[]{-5, -2, -1, -1, 0, 1, 1, 1, 1, 2, 2, 2, 3, 4, 5};
        System.out.println(solution(arr));
    }

    public int solution(int[] A) {
        int distinctCount = A.length;
        int startIndex = 0;
        int endIndex = A.length - 1;
        int sum = 0;
        while (startIndex < endIndex) {
            while (startIndex != endIndex && A[startIndex] == A[startIndex + 1]) {
                distinctCount--;
                startIndex++;
            }

            while (startIndex != endIndex && A[endIndex] == A[endIndex - 1]) {
                distinctCount--;
                endIndex--;
            }
            if(startIndex== endIndex){
                break;
            }
            sum = A[startIndex] + A[endIndex];
            if (sum == 0) {
                distinctCount--;
                startIndex++;
                endIndex--;
            }
            if (sum < 0) {
                startIndex++;
            } else {
                endIndex--;
            }

        }

        return distinctCount;
    }
}
