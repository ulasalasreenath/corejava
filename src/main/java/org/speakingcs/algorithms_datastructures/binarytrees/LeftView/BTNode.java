package org.speakingcs.algorithms_datastructures.binarytrees.LeftView;

public class BTNode<T> {

    private T data;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T data, BTNode<T> left, BTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
