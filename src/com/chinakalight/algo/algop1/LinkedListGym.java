package com.chinakalight.algo.algop1;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/24/2020
 */
public class LinkedListGym {

    public static void main(String[] args) {
        //populate Node linked up
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
