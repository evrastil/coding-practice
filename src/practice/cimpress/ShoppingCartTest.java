package practice.cimpress;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement:
 * Design a system which helps calculate the TotalCost of the items in the Cart.
 * You will be given a list of items in the Cart with Discounts like in the example below.
 * <p>
 * The list would contain either items or discounts and the sequence matters:
 * Sample cart: $10 Book xyz, 10% Discount on all items, $20 stationary, 20% discount on next item, $100 Shirt, $15 off on 5th Item of Type Book.
 * <p>
 * Types of Discounts:
 * 10% Discount on all items
 * 20% discount on next item
 * $15 off on 5th Item of Type Book
 * (More type of Discounts can be added later to the system)
 */
public class ShoppingCartTest {

    @Test
    public void testIt() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new CartAllCoupon());
        items.add(new RangeNCoupon());
        items.add(new ItemNextCoupon());
        items.add(new CartItem(10, "book"));
        items.add(new CartItem(10, "book"));
        items.add(new CartItem(10, "book"));
        items.add(new CartItem(10, "book"));
        items.add(new CartItem(10, "book"));
        items.add(new CartItem(10, "book"));
        ShoppingCart shoppingCart = new ShoppingCart(items);
        System.out.println(shoppingCart.getTotalPrice());

    }

    class ShoppingCart {
        private List<Item> items;

        ShoppingCart(List<Item> items) {
            this.items = items;
        }

        private List<Coupon> extractCoupons() {
            List<Coupon> coupons = new ArrayList<>();
            for (Item item : items) {
                if (item instanceof Coupon) {
                    coupons.add((Coupon) item);
                }
            }
            return coupons;
        }

        double getTotalPrice() {
            double discount = 0;
            double total = 0;
            for (Coupon coupon : extractCoupons()) {
                discount += coupon.calculateDiscount(items);
            }
            for (Item item : items) {
                if (item instanceof CartItem) {
                    total += ((CartItem) item).price;
                }
            }
            return total - discount;
        }
    }

    interface Item {
    }

    interface Coupon extends Item {
        double calculateDiscount(List<Item> items);
    }

    class ItemNextCoupon implements Coupon {
        /**
         * Apply to next item
         */
        @Override
        public double calculateDiscount(List<Item> items) {
            double discount = 0;
            double discountRate = 0;
            for (Item item : items) {
                if (item instanceof ItemNextCoupon) {
                    discountRate = 0.2;
                }
                if (item instanceof CartItem) {
                    discount += ((CartItem) item).price * discountRate;
                    discountRate = 0;
                }
            }
            return discount;
        }
    }

    class CartAllCoupon implements Coupon {
        private double discountRate = 0.1;

        /**
         * Apply to all items
         */
        @Override
        public double calculateDiscount(List<Item> items) {
            double discount = 0;
            for (Item item : items) {
                if (item instanceof CartItem) {
                    discount += ((CartItem) item).price * discountRate;
                }
            }
            return discount;
        }
    }

    class RangeNCoupon implements Coupon {

        private double discountRate = 0.15;
        private int discountLimiter = 5;

        /*
        * 15% off on (5th) n-th item
        * */
        @Override
        public double calculateDiscount(List<Item> items) {
            double discount = 0;
            int bookCartCount = 0;
            for (Item item : items) {
                if ((item instanceof CartItem) && ((CartItem) item).type.equals("book")) {
                    bookCartCount++;
                    if (bookCartCount == discountLimiter) {
                        discount += ((CartItem) item).price * discountRate;
                        bookCartCount = 0;
                    }
                }
            }
            return discount;
        }
    }

    class CartItem implements Item {
        double price;
        String type;

        CartItem(double price, String type) {
            this.price = price;
            this.type = type;
        }
    }
}
