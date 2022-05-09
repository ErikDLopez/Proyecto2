/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionalities.hanoi;

import java.io.Serializable;

/**
 *
 * @author erik-lopez
 */
public class Pile implements Serializable{
    private int counterNode = 0;
    private Node head;

    /**
     *
     * @return
     */
    public int getCounterNode() {
        return counterNode;
    }

    /**
     *
     * @param counterNode
     */
    public void setCounterNode(int counterNode) {
        this.counterNode = counterNode;
    }

    /**
     *
     * @return
     */
    public Node getHead() {
        return head;
    }

    /**
     *
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     *
     * @param node
     */
    public void push(Node node) {
        counterNode++;
        
        if (head == null) {
            head = node;
        } else {
            node.setDown(head);
            head.setUp(node);
            head = node;
        }
    }
    
    /**
     *
     */
    public void pop() {
        if (counterNode > 0) {
            counterNode--;
            head = head.getDown();
        }
    
    }
    
    /**
     *
     * @return
     */
    public String peek() {
        return head.getData();
    }
}
