import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Given an integer n, write a function to compute the nth Fibonacci number
 */
public class ComputeFibonacciTest {

    @Test
    public void testComputeFibonacci() {
        //add adjacent numbers to get to next n times
        // fiboncci(10) = 1+1+2+3+5+8+13+21+34+55
        long fibonacci = fibonacci(10);
        System.out.println(fibonacci);
        Assert.assertTrue(fibonacci == 55);
        long fibonacci1 = fibonacci(9);
        System.out.println(fibonacci1);
        Assert.assertTrue(fibonacci1 == 34);

        //optimal
        long fibonacci2 = fibonacciDynamic(9);
        System.out.println(fibonacci2);
        Assert.assertTrue(fibonacci2 == 34);
    }

    public long fibonacciDynamic(Integer n) {
        HashMap<Integer, Long> cache = new HashMap<>();
        //init for fib(1)(0)=1 and fib(2) (0+1)=1
        cache.put(1, 1L);
        cache.put(2, 1L);
        return fibonacciDynamic(n, cache);
    }

    /**
     * dynamic programming
     */
    private long fibonacciDynamic(Integer n, HashMap<Integer, Long> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n - 1, fibonacciDynamic(n - 1, cache));
        cache.put(n - 2, fibonacciDynamic(n - 2, cache));

        long fib = fibonacciDynamic(n - 1, cache) + fibonacciDynamic(n - 2, cache);
        System.out.println(fib);
        cache.put(n, fib);
        return fib;
    }

    // not efficient but short ;)
    public long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long out = fibonacci(n - 1) + fibonacci(n - 2);
        System.out.println(out);
        return out;
    }


}
