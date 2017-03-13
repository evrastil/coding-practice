import org.junit.Test;

public class FindKBiggestInArrTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{5, 400, 8, 9, 6, 3, 4, 7, 52}; //400,52,9,8,7,6,5,4,3
        int i = findKBiggest(8, arr);
        System.out.println(i);
    }

    public int findKBiggest(int K, int[] arr) {
        if (K > arr.length) {
            return -1;
        }
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[K-1];
    }


}
