package practice.codility;

import org.junit.Test;

public class CodilityCyclicRotationTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{3, 8, 9, 7, 6};
        int[] solution = solution(arr, 1);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }

    public int[] solution(int[] A, int K) {
        if(A == null || A.length == 0){
            return new int[0];
        }
        if (K > A.length) {
            int floor = K / A.length;
            K = K - floor * A.length;
        }
        int left = A.length - K;
        int[] leftArr = new int[left];
        for (int i = 0; i < A.length; i++) {
            if (i < left) {
                leftArr[i] = A[i];
            } else {
                A[i - left] = A[i];
            }
        }
        for (int i = 0, j = 0; i < A.length; i++) {
            if (i >= K) {
                A[i] = leftArr[j];
                j++;
            }
        }
        return A;
    }
}
