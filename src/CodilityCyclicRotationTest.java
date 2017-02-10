import org.junit.Test;

public class CodilityCyclicRotationTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{3, 8, 9, 7, 6, 1};
        int[] solution = solution(arr, 8);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }

    public int[] solution(int[] A, int K) {
        int resultArr[] = new int[A.length];
        if(K>A.length){
            K= K-A.length;
        }
        for (int i = 0; i < A.length + 1; i++) {
            if (i >= K) {
                resultArr[i - K] = A[i - 1];
            } else if (i < K && i + K < A.length) {
                resultArr[i + K] = A[i];
            }
        }
        return resultArr;
    }
}
