package org.speakingcs.algorithms_datastructures.binarytrees.bottomview;

public class Node {

    int data;
    int hd;
    Node left, right;

    public Node(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
