package org.speakingcs.algorithms_datastructures.binarytrees.verticalordertraversal;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderBTree {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int data) {
            key = data;
            left = right = null;
        }
    }

    static void getVerticalOrder(Node root, int hd, TreeMap<Integer, List<Integer>> m) {
        if(root == null) {
            return;
        }

        List<Integer> nodes = m.get(hd);
        if(nodes == null) {
            nodes = new ArrayList<Integer>();
            nodes.add(root.key);
        } else {
            nodes.add(root.key);
        }
        m.put(hd, nodes);

        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("vertical order traversel is ");
        printVerticalOrder(root);

    }

    private static void printVerticalOrder(Node root) {
        TreeMap<Integer, List<Integer>> m = new TreeMap<>();
        getVerticalOrder(root, 0, m);

        for(Map.Entry<Integer, List<Integer>> entry: m.entrySet()) {
            System.out.println(entry.getValue());

        }
    }
}
