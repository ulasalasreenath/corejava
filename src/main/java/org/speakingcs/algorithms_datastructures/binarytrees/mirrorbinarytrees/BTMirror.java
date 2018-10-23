package org.speakingcs.algorithms_datastructures.binarytrees.mirrorbinarytrees;

public class BTMirror {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        BTNode mirror = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        mirror.right = new BTNode(2);
        mirror.left = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        mirror.right.right = new BTNode(4);
        mirror.right.left = new BTNode(5);

        boolean isMirror = isMirror(root, mirror);
        System.out.println("both are mirrors (true/false)?" + isMirror);

        BTNode root1 = new BTNode(1);
        root1.left = new BTNode(2);
        root1.right = new BTNode(3);
        root1.left.left = new BTNode(4);
        root1.left.right = new BTNode(5);
        root1.right.left = new BTNode(6);
        root1.right.right = new BTNode(7);

        BTNode root2 = new BTNode(1);
        root2.left = new BTNode(2);
        root2.right = new BTNode(3);
        root2.left.left = new BTNode(4);
        root2.left.right = new BTNode(5);
        root2.right.left = new BTNode(6);
        root2.right.right = new BTNode(7);

        isMirror = isMirror(root1, root2);
        System.out.println("Both are mirrors (true/false)? " + isMirror);

    }

    private static boolean isMirror(BTNode root, BTNode mirror) {

        if (root == null && mirror == null) {
            return true;
        }

        if (root == null || mirror == null) {
            return false;
        }

        if (root.data != mirror.data) {
            return false;
        }

        boolean isLeftMirror = isMirror(root.left, mirror.right);
        boolean isRightMirror = isMirror(root.right, mirror.left);

        if (isLeftMirror && isRightMirror) {
            return true;
        }

        return false;


    }

    static class BTNode {
        int data;
        BTNode left;
        BTNode right;

        BTNode(int data) {
            this.data = data;
        }
    }


}
