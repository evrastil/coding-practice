import org.junit.Test;

public class FindKBiggestInArrTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{5, 400, 8, 9, 6, 3, 4, 7, 52}; //400,52,9,8,7,6,5,4,3
        int i = findKBiggest(8, arr);
        System.out.println(i);
    }

    //bubble sort
    public int findKBiggest(int K, int[] arr) {
        if (K > arr.length) {
            return -1;
        }
        boolean allSwapped = false;
        while (!allSwapped) {
            allSwapped = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] > arr[i]) {
                    allSwapped = false;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr[K - 1];
    }


}
