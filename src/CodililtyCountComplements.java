import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by vrastil on 18.2.2017.
 */
public class CodililtyCountComplements {
    @Test
    public void testìT() {
        int arr[] = new int[]{1, 8, -3, 0, 1, 3, -2, 4, 5};
        System.out.println(solution(6, arr));
    }

    public int solution(int K, int[] A) {
        int numOfComplements = 0;

        HashMap<Integer, Integer> numberCount = new HashMap<>(); //key:num,val:count
        for (int value : A) {
            if (numberCount.get(value) == null){
                numberCount.put(value, 1);
            } else {
                numberCount.put(value, numberCount.get(value) + 1);
            }
        }

        //find complementary number in hashmap
        Set<Integer> numbers = numberCount.keySet();
        for (Integer number : numbers) {
            int complement = K - number;
            if (numberCount.containsKey(complement)) {
                numOfComplements += numberCount.get(number) * numberCount.get(complement);//multiply occurrence num counts to get num of complements
            }
        }

        return numOfComplements;
    }
}
