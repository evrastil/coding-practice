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
        System.out.println(isCycleInLinkedList(node1));
        System.out.println(isCycleInLinkedList2(node1));
    }

    //naive approach
    private boolean isCycleInLinkedList(Node node) {
        Set<Node> visited = new HashSet<>();
        Node temp = node;
        while (temp != null) {
            if (visited.contains(temp)) {
                return true;
            }
            visited.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // Floyd's algorithm. Increment one pointer by one and the other by two.
// If they are ever pointing to the same node, there is a cycle.
// Explanation: https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
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
}
