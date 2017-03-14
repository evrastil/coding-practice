import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKBiggestInArrTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{5, 400, 8, 9, 6, 3, 4, 7, 52}; //400,52,9,8,7,6,5,4,3
        System.out.println(findKBiggest(8, arr));
        System.out.println(findKBiggest2(8, arr));
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

    // max heap
    public int findKBiggest2(int K, int[] arr) {
        if (K > arr.length) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(arr.length, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            priorityQueue.add(i1);
        }
        for (int i = 0; i < K - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }


}
