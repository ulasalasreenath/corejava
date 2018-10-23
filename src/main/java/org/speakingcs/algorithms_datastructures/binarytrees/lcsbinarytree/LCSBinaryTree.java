package org.speakingcs.algorithms_datastructures.binarytrees.lcsbinarytree;

public class LCSBinaryTree {

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
        root.right.right.left = new BTNode(14);
        root.right.right.right = new BTNode(15);

        BTNode lca = findLCS(root, 10, 15);
        System.out.println("LCA for 10 and 15 is " + lca.data);

        BTNode lca1 = findLCS(root, 4, 5);
        System.out.println("LCA for 4 and 5 is " + lca1.data);

        BTNode lca2 = findLCS(root, 6, 7);
        System.out.println("LCA for 6 and 7 is " + lca2.data);

        BTNode lca3 = findLCS(root, 8, 11);
        System.out.println("LCA for 8 and 11 is " + lca1.data);
    }

    private static BTNode findLCS(BTNode root, int val1, int val2) {

        if(root == null) {
            return null;
        }

        if(root.data == val1 || root.data == val2) {
            return root;
        }

        BTNode fromLeft = findLCS(root.left, val1, val2);
        BTNode fromRight = findLCS(root.right, val1, val2);

        if(fromLeft!= null && fromRight != null) {
            return root;
        }

        if(fromLeft == null && fromRight == null) {
            return null;
        }

        return fromLeft == null? fromRight:fromLeft;



    }

    static class BTNode {
        int data;
        BTNode left;
        BTNode right;

        public BTNode(int data) {
            this.data = data;
        }
    }
}
