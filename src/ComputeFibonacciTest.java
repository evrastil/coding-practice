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
        long fibonacci = fibonacciRecursive(10);
        System.out.println(fibonacci);
        Assert.assertTrue(fibonacci == 55);
        long fibonacci1 = fibonacciRecursive(9);
        System.out.println(fibonacci1);
        Assert.assertTrue(fibonacci1 == 34);

        //optimal
        long fibonacci2 = fibonacciDynamic(9);
        System.out.println(fibonacci2);
        Assert.assertTrue(fibonacci2 == 34);

        long fibonacci3 = fibonacciBottomUp(9);
        System.out.println(fibonacci3);
        Assert.assertTrue(fibonacci3 == 34);
    }

    public int fibonacciBottomUp(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];

        }
        return cache[n-1];

    }

    public long fibonacciDynamic(Integer n) {
        HashMap<Integer, Long> cache = new HashMap<>();
        //init for fib(1)(0)=1 and fib(2) (0+1)=1
        cache.put(1, 1L);
        cache.put(2, 1L);
        return fibonacciDynamic(n, cache);
    }

    private long fibonacciDynamic(Integer n, HashMap<Integer, Long> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long fib = fibonacciDynamic(n - 1, cache) + fibonacciDynamic(n - 2, cache);
        System.out.println(fib);
        cache.put(n, fib);
        return fib;
    }

    // not efficient but short ;)
    public long fibonacciRecursive(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long out = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        System.out.println(out);
        return out;
    }


}
