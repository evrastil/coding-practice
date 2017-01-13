import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeNumbersTest {
    /**
     * 1. One solution and optimizations:
     *  - Only even prime number is 2
     *  - All numbers a factors of prime numbers so check only division by prime numbers
     *  - Only check up to square root (druha odmocnina) of number, because it is always in the first middle of factors (nasobku cisla),
     *    it is only good enough to find first factor and it it doesn't exist the second doest exist either
     *
     * 2. Second solution is to go trough array of numbers N from prime number 2 and cross out all factors of that number
     * then go to next number which is by definition prime and cross out all factors etc. etc.
     */

    @Test
    public void testIsIntPrime() {
        //prime numbers
        //2,3,5,7,11,13,17,19,23,29,31 ....

        assertFalse(isPrime(1));
        assertTrue(isPrime(2));
        assertTrue(isPrime(11));
        assertFalse(isPrime(10));
        for (int i = 1; i < 1001; i++) {
            isPrime(i);
        }
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;

        //we do not have to check even numbers
        if (num % 2 == 0) return false;

        /*
         * only check up to square root of number, because it is always in the middle of factors (nasobku cisla),
         * it is only good enough to find first factor and it it doesn't exist the second doest exist either
         */
        double limit = Math.sqrt(num);
        for (int i = 2; i < limit; i++) {
            //check for division reminder
            if (num % i == 0) {
                return false;
            }
        }
        System.out.println("prime number: " + num);
        return true;
    }

}
