import org.junit.Test;

/**
 * Created by vrastil on 11.2.2017.
 */
public class CodilityMinimalIntNotInArrayTest {

    @Test
    public void testIt() {
        int[] arr = new int[]{1, 2, 3, 6, 4, 5};
        System.out.println(solution(arr));
    }

    public int solution(int[] A) {
        int[] posNumArray = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val > 0) {
                if (val - 1 <= A.length) {
                    posNumArray[val - 1] = val;
                }
            }
        }
        for (int i = 0; i < posNumArray.length; i++) {
            int val = posNumArray[i];
            if (i + 1 != val) {
                return i + 1;
            }

        }
        return 1;
    }
}
