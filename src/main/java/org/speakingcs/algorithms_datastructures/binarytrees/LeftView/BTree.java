package org.speakingcs.algorithms_datastructures.binarytrees.LeftView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BTree {

    private static int max_level = 0;
    private BTNode root = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int size = sc.nextInt();
        System.out.println("Enter nodes");

        BTree bTree = new BTree();
        boolean left = true;
        while (size-- > 0) {
            bTree.add(sc.next(), left);
            left = size % 2 == 0 ? true : false;
        }

        bTree.print(bTree.root);
        bTree.printLeftView(bTree.root);
    }

    private void printLeftView(BTNode root) {
        printLeftView(root, 1);
    }

    private void printLeftView(BTNode root, int level) {

        if (root == null) {
            return;
        }

        if (max_level < level) {
            System.out.println(root.getData());
            max_level = level;
        }
        printLeftView(root.getLeft(), level + 1);
        printLeftView(root.getRight(), level + 1);


    }

    private void print(BTNode root) {

        System.out.println(root.getData());

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        BTNode aNode = null;

        while ((aNode = queue.poll()) != null) {
            if (aNode.getLeft() == null) {
                System.out.print("-\t");
            } else {
                System.out.print(aNode.getLeft().getData() + "\t");
                queue.add(aNode.getLeft());
            }

            if (aNode.getRight() == null) {
                System.out.print("-\t");
            } else {
                System.out.print(aNode.getRight().getData() + "\t");
                queue.add(aNode.getRight());
            }
            System.out.println();
        }

    }

    private void add(String data, boolean side) {

        BTNode<String> aNode = new BTNode<>(data, null, null);
        if (root == null) {
            root = aNode;
        } else {
            if (root.getLeft() == null) {
                root.setLeft(aNode);
            } else if (root.getRight() == null) {
                root.setRight(aNode);
            } else {
                BTNode aNode1 = findEmptyNode(root, side);
                if (aNode1.getLeft() == null) {
                    aNode1.setLeft(aNode);
                } else {
                    aNode1.setRight(aNode);
                }
            }
        }
    }

    private BTNode findEmptyNode(BTNode root, boolean side) {
        if (root.getLeft() == null) {
            return root;
        }
        if (root.getRight() == null) {
            return root;
        }
        if (side) {
            return findEmptyNode(root.getLeft(), side);
        } else {
            return findEmptyNode(root.getRight(), side);
        }
    }

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }
}
