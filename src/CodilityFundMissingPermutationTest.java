import org.junit.Test;

public class CodilityFundMissingPermutationTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{1};
        int solution = solution(arr);
        System.out.println(solution);
    }

    public int solution(int[] A) {
         int[] comparisonArr = new int[A.length + 1];
        for (int i = 1; i <= comparisonArr.length; i++) {
            comparisonArr[i - 1] = i;
        }

        for (int i = 0; i < A.length; i++) {
            comparisonArr[A[i] - 1] = -1;

        }
        for (int i = 0; i < comparisonArr.length; i++) {
            int val = comparisonArr[i];
            if (val != -1) {
                return val;
            }
        }

        return 0;
    }
}
