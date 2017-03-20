package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given a linked list, determine whether it contains a cycle
 * <p>
 * 1 -> 2 -> 3 -> 4
 * ^         |
 * |_________|
 */
public class LinkedListCycleTest {
    /**
     * 1 -> 2 -> 3 -> 4
     * ^         |
     * |_________|
     */

    @Test
    public void testCycleInList() {
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(isCycleInLinkedList2(node1));
    }

    //naive approach
    private boolean isCycleInLinkedList(Node node) {
        Set<Node> visited = new HashSet<>();
        Node temp = node;
        while (temp.next != null) {
            if (visited.contains(temp)) {
                return true;
            }
            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }

    //best approach
    private boolean isCycleInLinkedList2(Node node) {
        if (node == null) {
            return false;
        }
        Node slow = node, fast = node;
        while (true) {
            slow = slow.next;
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    // Algorithm using extra space. Mark visited nodes and check that you
// only visit each node once.
//    public boolean hasCycle(Node n) {
//        HashSet<Node> visited = new HashSet<Node>();
//        for (Node curr = n; curr != null; curr = curr.next) {
//            if (visited.contains(curr)) return true;
//            visited.add(curr);
//        }
//
//        return false;
//    }

    // Floyd's algorithm. Increment one pointer by one and the other by two.
// If they are ever pointing to the same node, there is a cycle.
// Explanation: https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
//    public boolean hasCycleFloyd(Node n) {
//        if (n == null) return false;
//        Node slow = n;
//        Node fast = n.next;
//
//        while (fast != null && fast.next != null) {
//            if (fast == slow) return true;
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        return false;
//    }
}
