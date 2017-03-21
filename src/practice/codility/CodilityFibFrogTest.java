package practice.codility;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by vrastil on 17.2.2017.
 */
public class CodilityFibFrogTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{0,1,0,1,0};
//        System.out.println(solution(arr));
//        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int[] fibs = new int[A.length + 1];
        fibs[0] = 1;
        fibs[1] = 1;
        for (int i = 2; i < A.length; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        fibs = Arrays.copyOfRange(fibs, 2, fibs.length);

        int jumps = 0;
        int actualIndex = 0;
        boolean isLand = false;
        boolean jumpWasMade = false;
        for (int runner = 0; runner < A.length; runner++) {
            if (A[runner] == 1) {
                isLand = true;
            } else {
                jumpWasMade = false;
                isLand = false;
            }
            if (isLand && !jumpWasMade) {
                int distanceToJump = actualIndex == 0 ? runner - actualIndex + 1 : runner - actualIndex;
                for (int i = 0; i < fibs.length; i++) {
                    int fib = fibs[i];
                    if (fib > distanceToJump) {
                        //fib not found try another land segment if there is one
                        if (runner + 2 > A.length || A[runner + 1] != 1) {
                            //can not jump
                            return -1;
                        } else {
                            //continue and try another segment
                            break;
                        }
                    }
                    if (distanceToJump == fib) {
                        // frog jumped
                        jumpWasMade = true;
                        actualIndex = runner;
                        //mark as visited
                        A[runner] = -1;
                        jumps++;
                        break;
                    }
                }
            }
        }
        //last jum can be always made?
        return jumps + 1;
    }
}
