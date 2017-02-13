import org.junit.Test;

import java.util.HashSet;

public class CodilityCountDistinctSlicesTest {
    @Test
    public void testIt() {
        int[] arr = new int[]{3, 4, 5, 5, 2};
        System.out.printf(String.valueOf(solution(6, arr)));
    }

    public int solution(int M, int[] A) {
        int ans = 0, pre = -1;
        int[] hash = new int[M + 1];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (hash[A[i]] > pre) {
                pre = hash[A[i]];
            }
            ans += i - pre;
            hash[A[i]] = i;
        }
        return ans;

    }

}
