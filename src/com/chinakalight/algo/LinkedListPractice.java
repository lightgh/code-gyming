package com.chinakalight.algo;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/23/2020
 */
public class LinkedListPractice {
    public static void main(String[] args) {

        Node linkedListHead = new Node(new SecureRandom().nextInt(50));
        Node tmpPointerFiller = linkedListHead;

        // Populating the LinkedList
        for (int i = 0; i < 9; i++) {
            Node tmpNode = new Node(new SecureRandom().nextInt(100));
            tmpPointerFiller.setNext(tmpNode);
            tmpPointerFiller = tmpPointerFiller.getNext();
        }

        System.out.println("LinkedListHead ::: Full-LIST");
        printLinkedList(linkedListHead);

        Node fast = linkedListHead;
        Node slow = linkedListHead;

        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        fast = linkedListHead;
        slow = reverseLinkedList(slow);

        while(slow != null){
            if(slow.getVal() != fast.getVal()){
                System.out.println("NOT A PALINDROME");
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext();
        }

        System.out.println("FAST:::::");
        printLinkedList(fast);
        System.out.println("SLOW:::::");
        printLinkedList(slow);
//        System.out.println("REVERSING LINKED-LIST");
//        Node reversedLinkedList = reverseLinkedList(linkedListHead);
//        printLinkedList(reversedLinkedList);


    }

    static void printLinkedList(Node head){
        Node startTransverse = head;
        while( startTransverse != null ){
            System.out.print( startTransverse.getVal() + " => ");
            startTransverse = startTransverse.getNext();
        }
        System.out.println("NULL");
    }

    static Node reverseLinkedList(Node head){
        Node previousNode = null;
//        Node head = headParam;

        while(head != null){
            Node nextNode = head.getNext();
            head.setNext(previousNode);
            previousNode = head;
            head = nextNode;
        }

        return previousNode;
    }

    static Node reverseLinkedList2(Node head){
        Node newHead = null;

        while(head != null){
            Node nextNode = head.getNext();
            head.setNext(newHead);
            newHead = head;
            head = nextNode;
        }

        return newHead;

    }


}



class Node {
    private Node next;
    private int val;

    public Node(int val){
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
