package practice;

import org.junit.Test;

/**
 * You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
 * Write a function getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
 */
public class ProductsOfAllIntsExceptAtIndexTest {

    @Test
    public void testProductsOfAllIntsExceptAtIndex(){
        int[] integers = new int[]{1,3,2,4};
        int[] products = getProductsOfAllIntsExceptAtIndex(integers);
        for (int i = 0; i < products.length; i++) {
            int product = products[i];
            System.out.println(product);
        }
    }

    private int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsOfAllIntsExceptAtIndex;

    }
}
