import org.junit.Test;

/**
 * Created by vrastil on 18.2.2017.
 */
public class CodililtyTest2 {
    @Test
    public void  testìT(){
        int[] arr = new int[]{9,4,-3,-10};
        System.out.println(solution(arr));
    }
    public int solution(int[] A){
        int maxDeviationIndex = -1;
        double avgValOfArr = 0;
        int arrLength = A.length;
        for (int i = 0; i < arrLength; i++) {
            int val = A[i];
            avgValOfArr+=val;

        }
        avgValOfArr = avgValOfArr/ arrLength;

        double maxDevSoFar = 0;

        for (int i = 0; i < arrLength; i++) {
            int val = A[i];
            double deviation=Math.abs(val-avgValOfArr);
            if(deviation>maxDevSoFar){
                maxDevSoFar = deviation;
                maxDeviationIndex = i;
            }

        }

        return maxDeviationIndex;
    }
}
