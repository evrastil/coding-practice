import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vrastil on 10.2.2017.
 */
public class CodilityOddOccurrencesInArrayTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{2, 3, 3, 2, 4};
        System.out.printf(String.valueOf(solutionC(arr)));
    }

    public int solutionA(int[] A) {
        if (A != null) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                int key = A[i];
                if (map.containsKey(key)) {
                    Integer count = map.get(key);
                    map.put(key, count + 1);
                } else {
                    map.put(key, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
                if (entries.getValue() < 2) {
                    return entries.getKey();
                }
            }
        }
        return 0;
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i + 1 <= A.length - 1 && A[i] == A[i + 1]) {
                continue;
            }
            if (i - 1 >= 0 && A[i] == A[i - 1]) {
                continue;
            }
            return A[i];
        }
        return 0;

    }

    //correct solution
    public int solutionC(int[] A) {
        int missing = 0;
        for (int i = 0; i < A.length; i++) {
            missing ^= A[i];
        }
        return missing;
    }
}
