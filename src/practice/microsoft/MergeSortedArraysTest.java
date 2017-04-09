package practice.microsoft;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    1st MS ex :(
 */
public class MergeSortedArraysTest {
    @Test
    public void testIt() {
        int[][] arr = new int[][]{
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7},
                {5, 10, 15}
        };
        MergeSortArr sortArr = new MergeSortArr(arr);
        System.out.println(Arrays.toString(sortArr.sort()));
    }

    class MergeSortArr {

        class PQNode implements Comparable<PQNode> {
            int row, col, val;

            public PQNode(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }

            @Override
            public int compareTo(PQNode o) {
                if (this.val > o.val) {
                    return 1;
                } else if (this.val < o.val) {
                    return -1;
                } else {
                    return 0;
                }

            }
        }

        PriorityQueue<PQNode> priorityQueue = new PriorityQueue<>();
        int[][] arr;
        int[] result;

        public MergeSortArr(int[][] arr) {
            this.arr = arr;
            this.result = new int[arr[0].length * arr.length];
        }

        public int[] sort() {

            for (int row = 0; row < arr.length; row++) {
                priorityQueue.add(new PQNode(row, 0, arr[row][0]));
            }

            for (int i = 0; !priorityQueue.isEmpty(); i++) {
                PQNode node = priorityQueue.poll();
                result[i] = node.val;
                if (node.col + 1 < arr[node.row].length) {
                    priorityQueue.add(new PQNode(node.row, node.col+1, arr[node.row][node.col + 1]));
                }
            }
            return result;
        }
    }

}
