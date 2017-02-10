import org.junit.Test;

/**
 * Find an index in an array such that its prefix sum equals its suffix sum.
 */
public class ArrayEquilibriumTest {

    @Test
    public void testEquilibrium() {
        int[] A = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};
        //7,3,1
//        int eqIndex = findAnyEquilibriumIndex(A, A.length);
        int eqIndex2 = findAnyEquilibriumIndex2(A, A.length);
//        System.out.printf(String.valueOf(eqIndex2));
    }

    /**
     * Using extra O(n) space in O(n) time
     */
    private int findAnyEquilibriumIndex(int[] array, int arrayLength) {

        int[] leftValueSums = new int[arrayLength];
        leftValueSums[0] = array[0];
        //left aray sums
        for (int i = 1; i < arrayLength; i++) {
            leftValueSums[i] = array[i] + leftValueSums[i - 1];
        }
        int rightArraySum = 0;
        for (int i = arrayLength - 1; i >= 0; i--) {
            rightArraySum = rightArraySum + array[i];
            if (rightArraySum == leftValueSums[i]) {
                System.out.println(i);
            }
        }
        return -1;
    }

    private int findAnyEquilibriumIndex2(int[] array, int arrayLength) {
        int arraySum = 0;
        for (int i = 0; i < arrayLength; i++) {
            arraySum += array[i];
        }
        int rightArraySum = 0;
        for (int i = arrayLength - 1; i >= 0; i--) {
            if (rightArraySum == arraySum - (array[i] + rightArraySum)) {
                System.out.printf(String.valueOf(i));
            }
            rightArraySum += array[i];
        }

        return -1;
    }


}
