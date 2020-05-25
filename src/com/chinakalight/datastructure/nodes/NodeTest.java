package com.chinakalight.datastructure.nodes;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 5/25/2020
 */
public class NodeTest {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(5);
        node.next.next = new Node(7);

        printNodeValues(node);
    }

    static void printNodeValues(Node node){
        while(node != null ){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
