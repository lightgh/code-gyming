package com.chinakalight.datastructure.nodes;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 5/25/2020
 */
public class NodeTest {
    public static void main(String[] args) {
        Node first = new Node(3);
        Node second = new Node(5);
        first.next = second;
        Node third = new Node(7);
        second.next = third;
        printNodeValues(first);
    }

    static void printNodeValues(Node node){
        while(node != null ){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
