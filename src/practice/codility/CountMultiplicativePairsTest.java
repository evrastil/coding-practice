package practice.codility;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CountMultiplicativePairsTest {
    @Test
    public void testIt() {
        int[] A = new int[]{0, 0, 1, 1, 2, 3, 5, 100};
        int[] B = new int[]{100000, 999999, 100000, 400000, 500000, 0, 20000, 1};
        // C[] "0.1","0.999999","1.1","1.4","2.5","3","5.02","100.000001"
        int count = count(A, B);
        System.out.println(count);
        int bruteForce = countBruteForce(A, B);
        System.out.println(bruteForce);
        Assert.assertEquals(bruteForce, count);
        Assert.assertEquals(bruteForce, count2(A, B));
    }

    public int count(int[] A, int[] B) {
        BigDecimal[] C = new BigDecimal[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = (BigDecimal.valueOf(B[i])).divide(BigDecimal.valueOf(1000000)).add(BigDecimal.valueOf(A[i]));
        }
        int count = 0;
        int left = 0, right = A.length - 1;
        while (left < right) {
            if (C[left].multiply(C[right]).compareTo(C[left].add(C[right])) >= 0) {
                count += right - left;
                right--;
            } else {
                left++;
            }
        }
        return count;
    }

    public int count2(int[] A, int[] B) {
        BigDecimal[] C = new BigDecimal[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = (BigDecimal.valueOf(B[i])).divide(BigDecimal.valueOf(1000000)).add(BigDecimal.valueOf(A[i]));
        }
        int count = 0;
        int left = 0, right = A.length - 1;
        while (right > left) {
            BigDecimal m = C[right].add(BigDecimal.valueOf(-1));
            BigDecimal v = C[right].divide(m, 10, BigDecimal.ROUND_UP);

            while (left < right && C[left].compareTo(v) < 0) {
                left++;
            }

            if (left == right)
                break;

            count += right - left;

            right--;

        }
        return count;
    }

    public int countBruteForce(int[] A, int[] B) {
        BigDecimal[] C = new BigDecimal[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = (BigDecimal.valueOf(B[i])).divide(BigDecimal.valueOf(1000000)).add(BigDecimal.valueOf(A[i]));
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (C[i].multiply(C[j]).compareTo(C[i].add(C[j])) >= 0) {
                    count++;
                }

            }

        }
        return count;
    }
}
