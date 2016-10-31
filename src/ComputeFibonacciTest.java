import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer n, write a function to compute the nth Fibonacci number
 */
public class ComputeFibonacciTest {

    @Test
    public void testComputeFibonacci() {
        //add adjacent numbers to get to next n times
        // fiboncci(10) = 1+1+2+3+5+8+13+21+34+55
        int fibonacci = fibonacci(10);
        System.out.println(fibonacci);
        Assert.assertTrue(fibonacci == 55);
        int fibonacci1 = fibonacci(9);
        System.out.println(fibonacci1);
        Assert.assertTrue(fibonacci1 == 34);
    }

    // not efficient but nice ;)
    private int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return  fibonacci(--num) + fibonacci(--num);
    }


}
