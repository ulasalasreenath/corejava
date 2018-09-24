package org.speakingcs.algorithms_datastructures.binarytrees.connectnodesatsamelevel;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeAtSameLevel {

    private static class BTNode {
        int data;
        BTNode left;
        BTNode right;
        BTNode nextRight;

        public BTNode(int data, BTNode left, BTNode right, BTNode nextRight) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.nextRight = nextRight;
        }
    }

    public static void main(String[] args) {

        BTNode root = new BTNode(1, null, null, null);
        root.left = new BTNode(2, null, null, null);
        root.right = new BTNode(3, null, null, null);
        root.left.left = new BTNode(4, null, null, null);
        root.left.right = new BTNode(5, null, null, null);
        root.right.left = new BTNode(6, null, null, null);
        root.right.right = new BTNode(7, null, null, null);

        connect(root);
        System.out.println(root); // this is line is added for debugging

    }

    private static void connect(BTNode root) {

        Queue<BTNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {

            BTNode node = queue.peek();
            queue.remove();

            if(node != null) {
                BTNode nextNode = queue.peek();
                node.nextRight = nextNode;
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }

            } else if(!queue.isEmpty()){
                queue.add(null);
            }

        }

    }
}
