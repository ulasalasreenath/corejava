package org.speakingcs.algorithms_datastructures.binarytrees.spiralOrder;

import java.util.Stack;

public class SpiralOrderTest {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);

        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        root.left.left.left = new BTNode(8);
        root.left.left.right = new BTNode(9);
        root.left.right.left = new BTNode(10);
        root.left.right.right = new BTNode(11);
        root.right.left.left = new BTNode(12);
        root.right.left.right = new BTNode(13);

        printSpiralOrder(root);


    }

    private static void printSpiralOrder(BTNode root) {


        Stack<BTNode> leftToRightStack = new Stack<>();
        Stack<BTNode> rightToLeftStack = new Stack<>();

        /**
         * printing root
         */

        rightToLeftStack.add(root);
        while (!rightToLeftStack.isEmpty() || !leftToRightStack.isEmpty()) {

            BTNode temp = null;

            while (!rightToLeftStack.isEmpty() && (temp = rightToLeftStack.pop()) != null) {
                leftToRightStack.push(temp.left);
                leftToRightStack.push(temp.right);
                System.out.println(temp.data);
            }

            while (!leftToRightStack.isEmpty() && (temp = leftToRightStack.pop()) != null) {
                rightToLeftStack.push(temp.right);
                rightToLeftStack.push(temp.left);
                System.out.println(temp.data);
            }

        }

    }

    static class BTNode {
        Integer data;
        BTNode left;
        BTNode right;

        public BTNode(Integer data) {
            this.data = data;
        }
    }

    /*private static void printSpiralOrder(BTNode root) {

        Deque<BTNode> deque = new LinkedList<>();
        deque.add(null);

        System.out.println(root.data);

        deque.addFirst(root.left);
        deque.addFirst(root.right);

        BTNode temp = null;
        while(!deque.isEmpty() && !(deque.peek() == null)) {

            while ((temp = deque.peekFirst()) != null) {
                temp = deque.removeFirst();
                System.out.println(temp.data);
                deque.addLast(temp.right);
                deque.addLast(temp.left);
            }
            while ((temp = deque.peekLast()) != null) {
                temp = deque.removeLast();
                System.out.println(temp.data);
                deque.addFirst(temp.right);
                deque.addFirst(temp.left);
            }

        }


    }*/
}
