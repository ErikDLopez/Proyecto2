/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionalities.utilities.files;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que se encarga del manejo y creacion de los usuarios de los juegos del proyecto
 * @author erik-lopez
 * 
 */
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int ID;
    private String bestTime;
    private int hours;
    private int minutes;
    private int seconds;
    private int numberGames;
    private int numberLostGames;
    private int numberWinGames;
    private int totalMoves;
    private int bestMoves;
    private int eatenPawns;
    private int temporalMoves;
    private String hanoiPlayer;
    private String solution;

    /**
     *
     * @param nombre
     */
    public User(String nombre) {
        this.name = nombre;
        this.numberGames = 0;
        this.numberLostGames = 0;
        this.numberWinGames = 0;
        this.totalMoves = 0;
        this.hours = 23;
        this.minutes = 59;
        this.seconds = 59;
        this.bestTime = noBestTime();
        this.bestMoves = 0;
    }

    /**
     *
     * @param name
     * @param hanoiPlayer
     */
    public User(String name, String hanoiPlayer) {
        this.name = name;
        this.hanoiPlayer = hanoiPlayer;
        this.numberGames = 0;
        this.numberLostGames = 0;
        this.numberWinGames = 0;
        this.totalMoves = 0;
        this.hours = 23;
        this.minutes = 59;
        this.seconds = 59;
        this.bestTime = noBestTime();
        this.solution = "";
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    public String getBesTime() {
        return bestTime;
    }

    /**
     *
     * @param besTime
     */
    public void setBesTime(String besTime) {
        this.bestTime = besTime;
    }

    /**
     *
     * @return
     */
    public int getNumberGames() {
        return numberGames;
    }

    /**
     *
     * @param numberGames
     */
    public void setNumberGames(int numberGames) {
        this.numberGames = numberGames;
    }

    /**
     *
     * @return
     */
    public int getNumberLostGames() {
        return numberLostGames;
    }

    /**
     *
     * @param numberLostGames
     */
    public void setNumberLostGames(int numberLostGames) {
        this.numberLostGames = numberLostGames;
    }

    /**
     *
     * @return
     */
    public int getNumberWinGames() {
        return numberWinGames;
    }

    /**
     *
     * @param numberWinGames
     */
    public void setNumberWinGames(int numberWinGames) {
        this.numberWinGames = numberWinGames;
    }

    /**
     *
     * @return
     */
    public int getTotalMoves() {
        return totalMoves;
    }

    /**
     *
     * @param totalMoves
     */
    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }

    /**
     *
     * @return
     */
    public String getBestTime() {
        return bestTime;
    }

    /**
     *
     * @param bestTime
     */
    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
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
    public int getBestMoves() {
        return bestMoves;
    }

    /**
     *
     * @param bestMoves
     */
    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }

    /**
     *
     * @return
     */
    public int getEatenPawns() {
        return eatenPawns;
    }

    /**
     *
     * @param eatenPawns
     */
    public void setEatenPawns(int eatenPawns) {
        this.eatenPawns = eatenPawns;
    }

    /**
     *
     * @return
     */
    public int getTemporalMoves() {
        return temporalMoves;
    }

    /**
     *
     * @param temporalMoves
     */
    public void setTemporalMoves(int temporalMoves) {
        this.temporalMoves = temporalMoves;
    }

    /**
     *
     * @return
     */
    public String getSolution() {
        return solution;
    }

    /**
     *
     * @param solution
     */
    public void setSolution(String solution) {
        this.solution = solution;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return  "Nombre del usuario : "+name+"   ID : " + ID;
    }
    
    /**
     *
     * @return
     */
    public String showStats() {
        return  "Nombre: "+name+"   ID : " + ID+"   BestT: "+bestTime+"   Partidas: "+numberGames+"   Lost: "+numberLostGames+"   Wins: "+numberWinGames+"   MovesT: "+totalMoves+"   BestMov: "+bestMoves;
    }
    
    /**
     *
     * @return
     */
    public String showHanoi() {
        return  "Nombre del usuario : "+name+"   ID : " + ID;
    }

    /**
     *
     * @param users
     */
    public void assignID(ArrayList<User> users) {
        int size = users.size();
        ID = size +1 ;
    }
    
    /**
     *
     * @param users
     * @param name
     * @return
     */
    public boolean sameName(ArrayList<User> users, String name) {
        boolean same = false;
        
        for (int i = 0; i < users.size(); i++) {
            String userName = users.get(i).getName();
            
            if (userName.equalsIgnoreCase(name)){
                System.out.println("\nLos nombres son iguales: "+userName+" y "+name);
                same = true;
            }
        }
        return same;
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
    public String defineAverageMoves() {
        String averageText = "Sin datos";
        
        if (totalMoves > 0 && numberGames > 0){
            float average = (totalMoves)/(numberGames);
            averageText = String.valueOf(average);
        } 
        return averageText;
    }
}
