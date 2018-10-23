package org.speakingcs.algorithms_datastructures.binarytrees.lcsbinarysearchtree;

public class LCABinarySearchTree {

    private static class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        public BSTNode(int data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        BSTNode root = new BSTNode(20, null, null);
        root.left = new BSTNode(8, null, null);
        root.right = new BSTNode(22, null, null);
        root.left.left = new BSTNode(4,null,null);
        root.left.right = new BSTNode(12, null, null);
        root.left.right.left = new BSTNode(10, null, null);
        root.left.right.right = new BSTNode(14, null, null);

        BSTNode lca1 = findLCA(root, 10, 14);
        BSTNode lca2 = findLCA(root, 14, 8);
        BSTNode lca3 = findLCA(root, 10, 22);

        System.out.println("LCA1 is " + lca1.data);
        System.out.println("LCA2 is " + lca2.data);
        System.out.println("LCA3 is " + lca3.data);
    }

    private static BSTNode findLCA(BSTNode root, int val1, int val2) {

        if(root == null) {
            return null;
        }

        if(val1 > root.data && val2 > root.data) {
            return findLCA(root.right, val1, val2);
        }

        if(val1 < root.data && val2 < root.data) {
            return findLCA(root.left, val1, val2);
        }

        return root;

    }


}
