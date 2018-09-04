package com.speakingcs.datastructures.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNode {

	private BinaryTreeNode root = null;

	public int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode() {

	}

	private BinaryTreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return this.right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void addRoot(int data) {
		root = new BinaryTreeNode(data);
	}

	public void addLeft(int data) {
		BinaryTreeNode tempLeft = root.left;
		BinaryTreeNode leftNode = new BinaryTreeNode(data);

		if (tempLeft == null) {
			root.setLeft(leftNode);
			return;
		}

		while (tempLeft.left != null) {
			tempLeft = tempLeft.left;
		}

		tempLeft.setLeft(leftNode);
	}

	public void addRight(int data) {
		BinaryTreeNode tempRight = root.right;
		BinaryTreeNode rightNode = new BinaryTreeNode(data);

		if (tempRight == null) {
			root.setRight(rightNode);
			return;
		}

		while (tempRight.right != null) {
			tempRight = tempRight.right;
		}
		tempRight.right = rightNode;

	}

	public void preOrderRecursive() {
		preOrderRecursive(root);
	}

	private void preOrderRecursive(BinaryTreeNode aNode) {

		if (aNode != null) {
			System.out.println(aNode.getData());
			preOrderRecursive(aNode.getLeft());
			preOrderRecursive(aNode.getRight());
		}
	}

	public String toString() {
		return Integer.toString(data);
	}

	public void preorderTranversalIterative() {
		Stack<BinaryTreeNode> aStack = new Stack<BinaryTreeNode>();

		if (root == null) {
			return;
		}
		aStack.push(root);

		while (!aStack.isEmpty()) {
			BinaryTreeNode tempNode = aStack.pop();
			System.out.println(tempNode.getData());

			if (tempNode.getRight() != null) {
				aStack.push(tempNode.getRight());
			}

			if (tempNode.getLeft() != null) {
				aStack.push(tempNode.getLeft());
			}

		}
	}

	public void levelOrderTraversal() {
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			System.out.println(temp.getData());
			
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		
		}
		
	}

}
