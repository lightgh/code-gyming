package com.chinakalight.algo.algop1;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/28/2020
 */
public class ReverseBetween {
    public static void main(String[] args) {

        Node firstNode = new Node(1);
        firstNode.setNext(new Node(2));
        firstNode.getNext().setNext(new Node(3));
        firstNode.getNext().getNext().setNext(new Node(4));
        firstNode.getNext().getNext().getNext().setNext(new Node(5));

        System.out.println("PRINTING THE CONTENT OF THE LINKED LIST");
        printLinkedList(firstNode);
        Node reversedNode = reverseBetween(firstNode, 2, 4);
        printLinkedList(reversedNode);

    }

    public static void printLinkedList(Node head){
        Node temporaryHeadPointer = head;

        while( temporaryHeadPointer != null ){
            System.out.print(temporaryHeadPointer.getData() + " => ");
            temporaryHeadPointer = temporaryHeadPointer.getNext();
        }

        System.out.println( " NULL" );
    }

    public static Node reverseBetween(Node head, int m, int n) {
        if(head == null && head.getNext() == null){
            return head;
        }

        Node prev = head;
        Node current_node = head;

        while( m > 1 ){
            prev = current_node;
            current_node = current_node.getNext();
            m--;
            n--;
        }

        Node connection = prev;
        Node tail = current_node;

        while(n > 0){
            Node next_node = current_node.getNext();
            current_node.setNext(prev);
            prev = current_node;
            current_node = next_node;
            n--;
        }

        if(connection != null){
            connection.setNext(prev);
        } else {
            head = prev;
        }

        tail.setNext(current_node);



        return head;
    }
}
