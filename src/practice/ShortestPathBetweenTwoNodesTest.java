package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given a directed graph, find the shortest path between two nodes if one exists.
 */
public class ShortestPathBetweenTwoNodesTest {

    /**
     *  1   ->    3
     *
     *  ^    2    |
     *  |   ^ ^   v
     *     /   \
     *  5    <-   4
     */
    @Test
    public void testShortestPath(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.children.add(node3);
        node3.children.add(node4);
        node4.children.add(node2);
        node4.children.add(node5);
        node5.children.add(node1);

        List<Node> shortestPath = findShortestPath(node1, node2);
        Assert.assertTrue(shortestPath.size() == 4);
        Assert.assertTrue(shortestPath.contains(node2));
        Assert.assertTrue(shortestPath.contains(node4));
        Assert.assertTrue(shortestPath.contains(node3));
        Assert.assertTrue(shortestPath.contains(node1));

    }

    public List<Node> findShortestPath(Node start, Node end) {
        List<Node> shortestPathResult = new ArrayList<>();
        Queue<Node> toVisit = new LinkedList<>();
        Map<Node, Node> parents = new HashMap<>(); // construct parents of nodes and then we can go end -> start

        toVisit.add(start);
        parents.put(start, null);
        while(!toVisit.isEmpty()){
            Node temp = toVisit.remove();
            if(temp == end) break; //we found shortest path stop constructing path with (leading trough parents)
            for (Node child : temp.children) {
                if(!parents.containsKey(child)) { // make sure that we don't go around in cycles, dont visit already visited
                    toVisit.add(child);
                    parents.put(child, temp);
                }
            }
        }

        Node tempEnd = end;
        while (tempEnd!= null){
            shortestPathResult.add(0/*append to start of the list otherwise it will be reversed*/, tempEnd);
            tempEnd = parents.get(tempEnd);
        }

        return shortestPathResult;
    }

    private class Node{
        int value;
        List<Node> children = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }
    }
}
