/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.functionalities.checkers;

import com.functionalities.utilities.files.User;
import com.gui.checkers.principals.BoardGUI;
import com.gui.hanoi.HanoiGUI;
import java.util.ArrayList;

/**
 * Clase destinada a la actualizacion de datos del jugador en las partidas de damas
 * Se actualizara su informacion despues de terminar las partidas
 * @author erik-lopez
 */
public class UpdateUser {
    private ArrayList<User> users;
    private User user;
    private int index, movesUser;
    
    /**
     *
     * @param users
     * @param user
     * @param winID
     * @param movesUser
     * @param game
     */
    public void updateStats(ArrayList<User> users, User user, int winID, int movesUser, int game) {
        this.users = users;
        this.user = user;
        this.movesUser = movesUser;
        
        int ID = user.getID();
        index = findUser(ID);
        
        updateTotalGames();
        updateWinsLostGames(winID, game);
        updateMoves(movesUser);
    }
    
    /**
     *
     */
    public void updateTotalGames() {
        int totalGames = users.get(index).getNumberGames();
        totalGames++;
        users.get(index).setNumberGames(totalGames);
    }
    
    /**
     *
     * @param winID
     * @param game
     */
    public void updateWinsLostGames(int winID, int game) {
        int totalWins = users.get(index).getNumberWinGames();
        int totalLoses = users.get(index).getNumberLostGames();
        
        switch (winID) {
            case 0:
                totalLoses++;
                break;
            case 1:
                totalWins++;
                updateBestTime(winID, game);
                break;
        }
        users.get(index).setNumberWinGames(totalWins);
        users.get(index).setNumberLostGames(totalLoses);
    }
    
    /**
     *
     * @param winID
     * @param game
     */
    public void updateBestTime(int winID, int game) {
        int hoursGame = BoardGUI.getHours();
        int minutesGame = BoardGUI.getMinutes();
        int secondsGame = BoardGUI.getSeconds();
        
        if (game == 2){
            hoursGame = HanoiGUI.getHours();
            minutesGame = HanoiGUI.getMinutes();
            secondsGame = HanoiGUI.getSeconds();
        }
        
        int hoursUser = users.get(index).getHours();
        int minutesUser = users.get(index).getMinutes();
        int secondsUser = users.get(index).getSeconds();
        
        if (hoursUser > hoursGame) {
            assingNewTime(hoursGame, minutesGame, secondsGame);
        }
        if (hoursUser == hoursGame) {
            if (minutesUser > minutesGame) {
                assingNewTime(hoursGame, minutesGame, secondsGame);
            }
            if (minutesUser == minutesGame) {
                if (secondsUser > secondsGame) {
                    assingNewTime(hoursGame, minutesGame, secondsGame);
                }
                if (secondsUser == secondsGame) {
                    
                }
            }
        }
    }
    
    /**
     *
     * @param hoursGame
     * @param minutesGame
     * @param secondsGame
     */
    public void assingNewTime(int hoursGame, int minutesGame, int secondsGame) {
        users.get(index).setHours(hoursGame);
        users.get(index).setMinutes(minutesGame);
        users.get(index).setSeconds(secondsGame);
        users.get(index).setBesTime(users.get(index).noBestTime());
        users.get(index).setBestMoves(movesUser);
    }
    
    /**
     *
     * @param movesUser
     */
    public void updateMoves(int movesUser) {
        int moves = users.get(index).getTotalMoves();
        movesUser += moves;
        users.get(index).setTotalMoves(movesUser);
    }
    
    /**
     *
     * @param userID
     * @return
     */
    public int findUser(int userID) {
        int correctIndex = 0;
        
        for (int i = 0; i < users.size(); i++) {
            int compareID = users.get(i).getID();
            
            if (compareID == userID) {
                correctIndex = i;
            }
        }
        return correctIndex;
    }
}
