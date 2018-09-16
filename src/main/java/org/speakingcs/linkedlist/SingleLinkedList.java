package org.speakingcs.linkedlist;

public class SingleLinkedList<T> {

    Node<T> head = null;
    Node<T> nextNode = null;

    public void add(T element) {

        if(head == null) {
            head = new Node<>();
            head.setData(element);
            head.setNext(null);
            nextNode = head;
            return;
        }

        Node<T> temp = new Node<>();
        temp.setData(element);
        temp.setNext(null);
        nextNode.setNext(temp);
        nextNode = temp;

    }

    /**
     * In-Memory reverse
     */
    public void reverse() {

        Node<T> temp = head;
        Node<T> next1 = temp.getNext();
        Node<T> next2 = null;

        temp.setNext(null);
        while(next1 != null) {
            next2 = next1.getNext();
            next1.setNext(temp);
            temp = next1;
            next1 = next2;

        }

        head = temp;
    }


    public void print() {
        Node<T> temp = head;

        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();

        }

    }

    public static void main(String[] args) {

        SingleLinkedList<Integer> aList = new SingleLinkedList<>();
//        aList.add(1);
//        aList.add(2);
//        aList.add(3);
//        aList.add(4);

        for(int i = 1; i <= 100; i++) {
            aList.add(i);
        }

        System.out.println("printing");
        aList.print();
        aList.reverse();
        System.out.println("printing");
        aList.print();

    }

}

class Node<T> {

    private T data;
    private Node<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

