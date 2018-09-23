package org.speakingcs.algorithms_datastructures.binarytrees.bottomview;

import java.util.*;

public class Tree {

    Node root;

    public Tree() {

    }

    public Tree(Node node) {
        root = node;
    }

    public void bottomView() {
        if(root == null) {
            return;
        }

        int hd = 0;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<Node>();

        root.hd = hd;
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.remove();

            hd = temp.hd;
            map.put(hd, temp.data);

            if(temp.left != null) {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        for(Map.Entry<Integer, Integer> anEntry : set) {
            System.out.println(anEntry.getValue());
        }
    }
}
