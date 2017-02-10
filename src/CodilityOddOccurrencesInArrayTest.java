import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vrastil on 10.2.2017.
 */
public class CodilityOddOccurrencesInArrayTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{2, 3, 3, 2, 4};
        System.out.printf(String.valueOf(solution(arr)));
    }

    public int solution(int[] A) {
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
}
