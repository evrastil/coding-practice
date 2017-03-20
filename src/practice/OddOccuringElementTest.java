package practice;

import org.junit.Test;

/**
 * Created by eda on 19.3.17.
 */
public class OddOccuringElementTest {
    @Test
    public void testIt(){
        int[] arr = new int[]{4, 3, 6, 2, 6, 4, 2, 3, 4, 3, 3};
        for (int i : arr) {
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println(findOddOcc(arr));
    }
    public int findOddOcc(int[] arr){
        int oddEle = 0;
        for (int i = 0; i < arr.length; i++) {
           oddEle^=arr[i];
        }
        return oddEle;
    }
}
