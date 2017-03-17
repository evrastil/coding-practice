package practice;

import org.junit.Test;

/*
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3.
Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
public class MaximizeStockProfitTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{40, 535, 695, 100, 180, 260, 310};
        int maxProfit = maxProfit2(arr);
        System.out.printf(String.valueOf(maxProfit));
    }

    //n*n
    public int maxProfit(int[] arr) {
        int maxProfitSoFar = arr[1] - arr[0];
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            for (int j = i; j < arr.length; j++) {
                int i2 = arr[j];
                int i3 = i2 - i1;
                if (i3 > maxProfitSoFar) {
                    maxProfitSoFar = i3;
                }


            }

        }
        if (maxProfitSoFar < 0) {
            return -1;
        }
        return maxProfitSoFar;
    }

    //n
    public int maxProfit2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int prevMin = arr[0];
        int prevMax = arr[0];
        int prevValue = arr[0];

        int maxProfitSoFar = 0;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (value < prevValue) {
                prevMin = value;
            } else {
                prevMax = value;
            }

            int profit = prevMax - prevMin;
            if (profit > maxProfitSoFar) {
                maxProfitSoFar = profit;
            }

            prevValue = value;

        }
        return maxProfitSoFar;
    }

}
