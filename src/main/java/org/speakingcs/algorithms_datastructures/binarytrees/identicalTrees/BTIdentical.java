package org.speakingcs.algorithms_datastructures.binarytrees.identicalTrees;

public class BTIdentical {


    static class BTNode {
        int data;
        BTNode left;
        BTNode right;

        BTNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

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

        boolean identical = checkForIdentity(root1, root2);

        System.out.println("Both the trees are identical (true/false)?" +identical);


    }

    private static boolean checkForIdentity(BTNode root1, BTNode root2) {

        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null && root2 != null) {
            return false;
        }

        if(root1 != null && root2 == null) {
            return false;
        }

        if(root1.data != root2.data) {
            return false;
        }

        boolean leftSideIdentity = checkForIdentity(root1.left, root2.left);
        if(!leftSideIdentity) {
            return false;
        }
        boolean rightSideIdentity = checkForIdentity(root1.right, root2.right);
        if(!rightSideIdentity) {
            return false;
        }

        if(rightSideIdentity && leftSideIdentity) {
            return true;
        }
        return false;
    }
}
