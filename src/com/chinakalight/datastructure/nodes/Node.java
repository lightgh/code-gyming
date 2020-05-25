package com.chinakalight.datastructure.nodes;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 5/25/2020
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }

    public int getValue(){
        return  this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public Node getNext(){ return this.next; }
    public void setNext(Node next){ this.next = next; }
}
