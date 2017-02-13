import org.junit.Test;

import java.util.HashSet;

public class CodilityCountDistinctSlicesTest {
    @Test
    public void testIt() {
        int[] arr = new int[]{3, 4, 5, 5, 2};
        System.out.printf(String.valueOf(solution(6, arr)));
    }

    public int solution(int M, int[] A) {
        int result = 0, left = -1;
        int[] foundArr = new int[M + 1];
        for (int i = 0; i < foundArr.length; i++) {
            foundArr[i] = -1;
        }
        for (int right = 0; right < A.length; right++) {
            if (foundArr[A[right]] > left) {
                left = foundArr[A[right]];
            }
            result += right - left;
            foundArr[A[right]] = right;
        }
        return result;

    }

}
