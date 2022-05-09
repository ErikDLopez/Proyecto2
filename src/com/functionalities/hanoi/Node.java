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
public class Node implements Serializable{
    private String data;
    private Node up;
    private Node down;

    /**
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Node getUp() {
        return up;
    }

    /**
     *
     * @param up
     */
    public void setUp(Node up) {
        this.up = up;
    }

    /**
     *
     * @return
     */
    public Node getDown() {
        return down;
    }

    /**
     *
     * @param down
     */
    public void setDown(Node down) {
        this.down = down;
    }
    
}
