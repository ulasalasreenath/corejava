package org.speakingcs.algorithms_datastructures.binarytrees.CheckBST;

import org.speakingcs.algorithms_datastructures.binarytrees.LeftView.BTNode;
import org.speakingcs.algorithms_datastructures.binarytrees.LeftView.BTree;

public class BSTMain {

    BTNode<Integer> root = null;

    public static void main(String[] args) {
        BSTMain bstMain = new BSTMain();
        bstMain.createBST(5, 4,6, 7,8, 2,3, 9, 10, 1);
        //System.out.println("SUCCESS: Binary Search Tree created successfully");
        //System.out.println("Balanced " + bstMain.checkIsBST(bstMain.root));
        //System.out.println("Balance " + bstMain.checkIsBST1(bstMain.root));

        BTNode<Integer> bt = bstMain.createBT(5,4,6,7,8,2,3,9,10,1);
        System.out.println("SUCCESS: Binary tree is created successfully");
        //bstMain.checkIsBST2(bstMain.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        //bstMain.checkIsBST2(bt, Integer.MIN_VALUE, Integer.MAX_VALUE);
        bstMain.checkIsBST2(bstMain.root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    /**
     * creates binary tree
     * @param data
     */
    private BTNode<Integer> createBT(int ... data) {

        BTNode<Integer> root = null;

        for(int val: data) {

            if(root == null) {
                root = new BTNode<>(val, null, null);
            } else {
                if(val %2 == 0) {
                    addRight(root, val);
                } else {
                    addLeft(root, val);
                }
            }
        }
        return root;
    }

    private void addRight(BTNode<Integer> root, int val) {

        while(root.getRight() != null) {
            root = root.getRight();
        }

        root.setRight(new BTNode<>(val, null, null));
    }

    private void addLeft(BTNode<Integer> root, int val) {
        while(root.getLeft() != null) {
            root = root.getLeft();
        }

        root.setLeft(new BTNode<>(val, null, null));
    }

    private boolean checkIsBST2(BTNode<Integer> root, int minValue, int maxValue) {

        if(root == null) {
            return true;
        }

        if(!((root.getData() > minValue) &&(root.getData() < maxValue))) {
            return false;
        }

        boolean isLeftBst = checkIsBST2(root.getLeft(), minValue, root.getData());
        boolean isRightBst = checkIsBST2(root.getRight(), root.getData(), maxValue);

        if(isLeftBst && isRightBst) {
            return true;
        }

        return false;
    }

    /**
     * Not a correct solution
     * @param aNode
     * @return
     */
    private boolean checkIsBST1(BTNode<Integer> aNode) {

        if(aNode == null) {
            return true;
        }

        if(aNode.getLeft()!= null && aNode.getLeft().getData() > aNode.getData()) {
            return false;
        }

        if(aNode.getRight() != null && aNode.getRight().getData() < aNode.getData()) {
            return false;
        }

        if(!checkIsBST1(aNode.getLeft()) || !checkIsBST1(aNode.getRight())) {
            return false;
        }

        return true;
    }

    /**
     * Not a correct solution
     * @param aNode
     * @return
     */
    private boolean checkIsBST(BTNode<Integer> aNode) {

        if(aNode == null) {
            return true;
        }
        if(aNode.getLeft() == null && aNode.getRight() == null) {
            return true;
        }

        boolean isLeftBST = checkIsBST(aNode.getLeft());
        boolean isRightBST = checkIsBST(aNode.getRight());

        if (aNode.getRight() != null && aNode.getLeft() != null ) {
            boolean returnVal = false;
            if(aNode.getRight().getData() > aNode.getData() && aNode.getLeft().getData() < aNode.getData()) {
                returnVal = true;
            } else {
                returnVal = false;
            }
            return returnVal;
        }

        if(aNode.getRight() == null) {
            return aNode.getLeft().getData() < aNode.getData();
        }

        if(aNode.getLeft() == null) {
            return aNode.getRight().getData() > aNode.getData();
        }

        if(isLeftBST && isRightBST) {
            return true;
        }

        return false;

    }

    private void createBST(int... data) {

        BTNode<Integer> aNode = null;

        for(int a: data) {
            if(root == null) {
                root = new BTNode<>(a, null, null);
            } else {
                addToTree(root, a);
            }
        }

    }

    private void addToTree(BTNode<Integer> root, int dataVal) {
        BTNode<Integer> aNode = new BTNode<>(dataVal, null, null);
        if(root.getData() < dataVal) {
            if(root.getRight() == null) {
                root.setRight(new BTNode<>(dataVal, null, null));
            } else {
                addToTree(root.getRight(), dataVal);
            }
        } else if(root.getData() > dataVal) {
            if(root.getLeft() == null) {
                root.setLeft(new BTNode<>(dataVal, null, null));
            } else {
                addToTree(root.getLeft(), dataVal);
            }

        }
    }
}