package com.speakingcs.datastructures.binarytrees;

public class BinaryTreeExample {
	
	public static void main(String[] args)
	{
		BinaryTreeNode binaryTree = new BinaryTreeNode();
		binaryTree.addRoot(1);
		binaryTree.addLeft(2);
		binaryTree.addRight(3);
		binaryTree.addLeft(4);
		binaryTree.addRight(5);
		binaryTree.addLeft(6);
		binaryTree.addRight(7);
		binaryTree.addLeft(8);
		binaryTree.addRight(9);
		binaryTree.addLeft(10);
		binaryTree.addRight(11);
		binaryTree.addLeft(12);
		binaryTree.addRight(13);
		binaryTree.addLeft(14);
		binaryTree.addRight(15);
		binaryTree.addLeft(16);
		binaryTree.addRight(17);
		
		binaryTree.preOrderRecursive();
		binaryTree.preorderTranversalIterative();
		
		binaryTree.levelOrderTraversal();
		
		
	}

}
