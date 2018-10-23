package org.speakingcs.algorithms_datastructures.binarytrees.findpathfromroot;

import java.util.ArrayList;

public class BinaryTreeFindPathFromRoot {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);

        ArrayList<Integer> path = new ArrayList<Integer>();
        boolean found = findPathFromRoot(root, 7, path);
        if(found) {
            System.out.println(path.toString());
            path.clear();
        }

        found = findPathFromRoot(root, 4, path);
        System.out.println("path found for 4 " + found);
        if(found) {
            System.out.println(path.toString());
            path.clear();
        }
        found = findPathFromRoot(root, 5, path);
        System.out.println("path found for 5 " + found);
        if(found) {
            System.out.println(path.toString());
            path.clear();
        }
        found = findPathFromRoot(root, 6, path);
        System.out.println("path found for 6 " + found);
        if(found) {
            System.out.println(path.toString());
            path.clear();
        }
        found = findPathFromRoot(root, 99, path);
        System.out.println("path found for 99 " + found);
        if(found) {
            System.out.println(path.toString());
            path.clear();
        }

    }

    private static boolean findPathFromRoot(BTNode root, int nodeVal, ArrayList<Integer> path) {

        if(root == null) {
            return false;
        }

        path.add(root.data);

        if(root.data == nodeVal) {
            return true;
        }

        if(root.left != null) {
            if(findPathFromRoot(root.left, nodeVal, path)) {
                return true;
            }
        }

        if(root.right != null) {
            if(findPathFromRoot(root.right, nodeVal, path)) {
                return true;
            }
        }

        path.remove(path.size() -1);

        return false;


    }

    static class BTNode {
        int data;
        BTNode right;
        BTNode left;

        public BTNode(int data) {
            this.data = data;
        }
    }

}
