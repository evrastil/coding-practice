package practice;

import org.junit.Test;

/**
 * Given a linked list, write a function that prints the nodes of the list in reverse order
 */
public class ReverseLinkedListTest {

    @Test
    public void testPrintLinkedListNodesInReverse(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        //print in order
        printLinkedList(node1);
        //print in reverse
        printLinkedListInReverse(node1);

    }

    private class Node{
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    private void printLinkedList(Node node){
        if(node == null){
            return;
        }
        System.out.printf(String.valueOf(node.value));
        printLinkedList(node.next);
    }

    private void printLinkedListInReverse(Node node){
        if(node == null){
            return;
        }
        printLinkedListInReverse(node.next);
        System.out.printf(String.valueOf(node.value));
    }

}