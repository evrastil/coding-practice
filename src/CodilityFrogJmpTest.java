import org.junit.Test;

/**
 * Created by vrastil on 11.2.2017.
 */
public class CodilityFrogJmpTest {

    @Test
    public void testIt() {
        int solution = solution(10, 85, 30);
        System.out.println(solution);
    }

    public int solution(int X, int Y, int D) {
        int pathLength = Y - X;
        double jumps = pathLength / (double)D;
        return (int) Math.ceil(jumps);
    }
}
