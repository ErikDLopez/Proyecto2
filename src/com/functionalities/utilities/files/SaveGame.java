/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionalities.utilities.files;

import com.functionalities.hanoi.Pile;
import java.io.Serializable;

/**
 *
 * @author erik-lopez
 */
public class SaveGame implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private User user1;
    private User user2;
    private char[][] logicBoard;
    private int hours;
    private int minutes;
    private int seconds;
    private String viewTime;
    private Pile pileA, pileB, pileC;

    /**
     *
     * @param user1
     * @param user2
     * @param logicBoard
     * @param hours
     * @param minutes
     * @param seconds
     */
    public SaveGame(User user1, User user2, char[][] logicBoard, int hours, int minutes, int seconds) {
        this.user1 = user1;
        this.user2 = user2;
        this.logicBoard = logicBoard;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.viewTime = noBestTime();
    }

    /**
     *
     * @param user1
     * @param hours
     * @param minutes
     * @param seconds
     * @param viewTime
     * @param pileA
     * @param pileB
     * @param pileC
     */
    public SaveGame(User user1, int hours, int minutes, int seconds, String viewTime, Pile pileA, Pile pileB, Pile pileC) {
        this.user1 = user1;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.viewTime = viewTime;
        this.pileA = pileA;
        this.pileB = pileB;
        this.pileC = pileC;
    }
    
    /**
     *
     * @return
     */
    public User getUser1() {
        return user1;
    }

    /**
     *
     * @param user1
     */
    public void setUser1(User user1) {
        this.user1 = user1;
    }

    /**
     *
     * @return
     */
    public User getUser2() {
        return user2;
    }

    /**
     *
     * @param user2
     */
    public void setUser2(User user2) {
        this.user2 = user2;
    }

    /**
     *
     * @return
     */
    public char[][] getLogicBoard() {
        return logicBoard;
    }

    /**
     *
     * @param logicBoard
     */
    public void setLogicBoard(char[][] logicBoard) {
        this.logicBoard = logicBoard;
    }

    /**
     *
     * @return
     */
    public int getHours() {
        return hours;
    }

    /**
     *
     * @param hours
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     *
     * @return
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     *
     * @param minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     *
     * @return
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     *
     * @param seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     *
     * @return
     */
    public String getViewTime() {
        return viewTime;
    }

    /**
     *
     * @param viewTime
     */
    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    /**
     *
     * @return
     */
    public String noBestTime() {
        String time = (hours<=9?"0":"")+hours+":"+(minutes<=9?"0":"")+minutes+":"+(seconds<=9?"0":"")+seconds;
        return time;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User1: "+user1.getName()+"   User2: "+user2.getName()+"   Tiempo: "+viewTime+"   Comidas por 1: "+user1.getEatenPawns()+"   Comidas por 2: "+user2.getEatenPawns()+"   Mov1: "+user1.getTemporalMoves()+"   Mov2: "+user2.getTemporalMoves();
    }
    
    /**
     *
     * @return
     */
    public String showStats(){
        return "User1: "+user1+"   User2: "+user2+"   Tiempo: "+viewTime;
    }
    
    /**
     *
     * @return
     */
    public String showHanoi() {
        return "User1: "+user1.getName()+"   Tiempo: "+viewTime;
    }
}
