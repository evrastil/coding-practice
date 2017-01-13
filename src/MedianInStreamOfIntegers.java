import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median in a stream of integers (running integers)
 * Given that integers are read from a data stream.
 * Find median of elements read so for in efficient way.
 * For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …
 * <p>
 * Making it clear, when the input size is odd, we take the middle element of sorted data. If the input size is even, we pick average of middle two elements in sorted stream.
 * <p>
 * Method 1: Insertion Sort
 * Method 2: Augmented self balanced binary search tree (AVL, RB, etc…)
 * Method 3: Heaps
 */
public class MedianInStreamOfIntegers {
    @Test
    public void testMedianOfStreamData() {
        //median is 5
        int[] array = new int[]{5, 8, 9, 6, 4, 7, 3, 1, 2};
        MedianTracker medianTracker = new MedianTracker();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            medianTracker.add(value);
            System.out.printf(" median is: " + medianTracker.getMedian());
        }
    }
    class MedianTracker {
        private Queue<Integer> maxHeap = new PriorityQueue<>();
        private Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        void add(int n) {
            maxHeap.offer(n);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        int getMedian(){
            if(maxHeap.size() == minHeap.size()){
                //if heaps are same size make average of top values on heap
                return (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                //max heap holds median
                return maxHeap.peek();
            }
        }
    }
}
