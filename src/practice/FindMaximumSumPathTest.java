package practice;

import org.junit.Test;

public class FindMaximumSumPathTest {
    @Test
    public void testIt() {
        int[] X = new int[]{1, 3, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = new int[]{1, 2, 3, 5, 7, 12, 13, 14, 15};
        System.out.println(findMaxSumPath(X, Y));
    }

    public int findMaxSumPath(int[] arrX, int[] arrY) {

        int i = 0, j = 0;
        int sum =0;
        int arrXSum = 0, arrYSum = 0;
        int arrXLength = arrX.length;
        int arrYLength = arrY.length;
        while (i < arrXLength && j < arrYLength) {
            if (arrX[i] < arrY[j]) {
                arrXSum += arrX[i];
                i++;
            } else if (arrX[i] > arrY[j]) {
                arrYSum += arrY[i];
                j++;
            } else { //val are same arrX[i] == arrY[j]
                sum += Math.max(arrXSum, arrYSum) + arrX[i];
                i++;
                j++;
                //reset
                arrXSum = 0;
                arrYSum = 0;
            }

        }

        return sum;
    }
}
