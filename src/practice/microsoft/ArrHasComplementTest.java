package practice.microsoft;

import org.junit.Test;

/**
 * Created by eda on 23.3.2017.
 */
public class ArrHasComplementTest {
    @Test
    public void testIt() {
        int[] arr = new int[]{1, 2, 4, 5, 6, 100};
        System.out.println(hasComplement(arr, 8));
        int[] arr2 = new int[]{1, 2, 4, 5};
        System.out.println(hasComplement(arr2, 8));
    }

    private boolean hasComplement(int[] arr, int complement) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            if (low > complement) {
                return false;
            }
            while (high > complement) {
                high--;
            }
            if (arr[low] + arr[high] == complement) {
                return true;
            }
            low++;
            high--;

        }
        return false;
    }
}
