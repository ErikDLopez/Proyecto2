/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.checkers.principals;

import com.functionalities.checkers.Board;
import com.functionalities.checkers.UpdateUser;
import com.functionalities.utilities.Util;
import com.functionalities.utilities.files.SaveGame;
import com.functionalities.utilities.files.Serialization;
import com.functionalities.utilities.files.User;
import com.gui.checkers.options.LoadGame;
import com.gui.checkers.options.OptionGame;
import com.gui.checkers.options.SelectPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Erik David Lopez
 * 
 */
public class BoardGUI extends javax.swing.JFrame {
    Util util = new Util();
    Board board;
    public static Timer time;
    private int hundredthsSecond = 0;
    public static int seconds = 0;
    public static int minutes = 0;
    public static int hours = 0;
    public static int saveDataID, winUser1, winUser2, movesUser1, movesUser2;
    private int ID;
    public static int endSavedGame;
    public static User saveUser1, saveUser2;
    public static char[][] logicBoard;
    /**
     * Creates new form BoardForm
     */
    public BoardGUI() {
        System.out.println("\nLa opcion de juego enviada es: "+OptionGame.getGameID());
        initComponents();
        ID = 0;
        saveDataID = 0;
        endSavedGame = 0;
        winUser1 = 2;
        winUser2 = 2;
        movesUser1 = 0;
        movesUser2 = 0;
        timerSettings(OptionGame.getGameID());
        extraComponents();
    }
    
    public void extraComponents(){
        defineUsers();
        this.setLocationRelativeTo(null);
        time = new Timer(10, actions);
        time.start();
        board = new Board(8);
        boardPanel = board.generateBoard(boardPanel,OptionGame.getGameID());
        board.showLogicBoard();
        board.generateStats(OptionGame.getGameID());
        playerData();
    }
    
    private void updateLabel() {
        String text = (hours<=9?"0":"")+hours+":"+(minutes<=9?"0":"")+minutes+":"+(seconds<=9?"0":"")+seconds+":"+(hundredthsSecond<=9?"0":"")+hundredthsSecond;
        timerLabel.setText(text);
    }
    
    private void defineUsers(){
        if (OptionGame.getGameID() == 1){
            saveUser1 = SelectPlayer.getUser1();
            saveUser2 = SelectPlayer.getUser2();
        }
        if (OptionGame.getGameID() == 2){
            saveUser1 = LoadGame.getGame().getUser1();
            saveUser2 = LoadGame.getGame().getUser2();
            catchesPlayer1Label.setText(String.valueOf(saveUser1.getEatenPawns()));
            catchesPlayer2Label.setText(String.valueOf(saveUser2.getEatenPawns()));
            movesUser1 = saveUser1.getTemporalMoves();
            movesUser2 = saveUser2.getTemporalMoves();
        }
    }
    
    public void timerSettings(int gameID) {
        if (gameID == 1) {
            hours = 0;
            minutes = 0;
            seconds = 0;
            System.out.println("\nSe inicio el tiempo desde 00");
        }
        if (gameID == 2) {
            hours = LoadGame.getGame().getHours();
            minutes = LoadGame.getGame().getMinutes();
            seconds = LoadGame.getGame().getSeconds();
            System.out.println("\nSe cargo el tiempo guardado");
        } 
    }
    
    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            hundredthsSecond++;
            if (hundredthsSecond == 100){
                seconds++;
                hundredthsSecond = 0;
            }
            if (seconds == 60){
                minutes++;
                seconds = 0;
            }
            if (minutes == 60){
                hours++;
                minutes = 0;
            }
            if (hours == 24){
                hours = 0;
            }
            updateLabel();
        }
    };
    
    public void playerData(){
        String dataPlayer1 = "Piezas comidas por "+saveUser1.getName();
        String dataPlayer2 = "Piezas comidas por "+saveUser2.getName();
        player1Label.setText(dataPlayer1);
        player2Label.setText(dataPlayer2);
    }

    public static void setTimerLabel(String message) {
        timerLabel.setText(message);
    }
    
    public static void setTurnStats(String player, String pawnsColor) {
        playerTurnLabel.setText(player);
        pawnsColorLabel.setText(pawnsColor);
    }
    
    public static void setCatchesPlayer1(String pawnEaten) {
        catchesPlayer1Label.setText(pawnEaten);
    }
    
    public static void setCatchesPlayer2(String pawnEaten) {
        catchesPlayer2Label.setText(pawnEaten);
    }
    
    public static String getCatchesPlayer1() {
        return catchesPlayer1Label.getText();
    }
    
    public static String getCatchesPlayer2() {
        return catchesPlayer2Label.getText();
    }

    public static int getSeconds() {
        return seconds;
    }

    public static int getMinutes() {
        return minutes;
    }

    public static int getHours() {
        return hours;
    }

    public static int getSaveDataID() {
        return saveDataID;
    }

    public static void setSaveDataID(int saveDataID) {
        BoardGUI.saveDataID = saveDataID;
    }

    public static int getWinUser1() {
        return winUser1;
    }

    public static void setWinUser1(int winUser1) {
        BoardGUI.winUser1 = winUser1;
    }

    public static int getWinUser2() {
        return winUser2;
    }

    public static void setWinUser2(int winUser2) {
        BoardGUI.winUser2 = winUser2;
    }

    public static int getMovesUser1() {
        return movesUser1;
    }

    public static void setMovesUser1(int movesUser1) {
        BoardGUI.movesUser1 = movesUser1;
    }

    public static int getMovesUser2() {
        return movesUser2;
    }

    public static void setMovesUser2(int movesUser2) {
        BoardGUI.movesUser2 = movesUser2;
    }

    public static int getEndSavedGame() {
        return endSavedGame;
    }

    public static void setEndSavedGame(int endSavedGame) {
        BoardGUI.endSavedGame = endSavedGame;
    }

    public static char[][] getLogicBoard() {
        return logicBoard;
    }

    public static void setLogicBoard(char[][] logicBoard) {
        BoardGUI.logicBoard = logicBoard;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        boardPanel = new javax.swing.JPanel();
        statsPanel = new javax.swing.JPanel();
        player2Label = new javax.swing.JLabel();
        separatorLine = new javax.swing.JSeparator();
        playerTurnLabel = new javax.swing.JLabel();
        separatorLine1 = new javax.swing.JSeparator();
        separatorLine2 = new javax.swing.JSeparator();
        pawnsColorLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        separatorLine3 = new javax.swing.JSeparator();
        catchesPlayer2Label = new javax.swing.JLabel();
        separatorLine4 = new javax.swing.JSeparator();
        catchesPlayer1Label = new javax.swing.JLabel();
        player1Label = new javax.swing.JLabel();
        infoLabel5 = new javax.swing.JLabel();
        infoLabel4 = new javax.swing.JLabel();
        infoLabel6 = new javax.swing.JLabel();
        infoLabel7 = new javax.swing.JLabel();
        infoLabel8 = new javax.swing.JLabel();
        infoLabel9 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JUGANDO A LAS DAMAS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        background.setBackground(new java.awt.Color(0, 87, 87));
        background.setPreferredSize(new java.awt.Dimension(1080, 680));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boardPanel.setBackground(new java.awt.Color(0, 0, 0));
        boardPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout boardPanelLayout = new javax.swing.GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        boardPanelLayout.setVerticalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );

        background.add(boardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 640, 640));

        statsPanel.setBackground(new java.awt.Color(51, 51, 51));
        statsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        statsPanel.setForeground(new java.awt.Color(255, 255, 255));
        statsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player2Label.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        player2Label.setForeground(new java.awt.Color(255, 255, 255));
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText("Piezas comidas por Jugador 2");
        player2Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(player2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 290, 30));

        separatorLine.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine.setForeground(new java.awt.Color(255, 255, 255));
        statsPanel.add(separatorLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 220, 20));

        playerTurnLabel.setFont(new java.awt.Font("Chandas", 3, 18)); // NOI18N
        playerTurnLabel.setForeground(new java.awt.Color(0, 204, 204));
        playerTurnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerTurnLabel.setText("JUGADOR 1");
        playerTurnLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(playerTurnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, 30));

        separatorLine1.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine1.setForeground(new java.awt.Color(255, 255, 255));
        statsPanel.add(separatorLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 200, 20));

        separatorLine2.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine2.setForeground(new java.awt.Color(255, 255, 255));
        statsPanel.add(separatorLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, 20));

        pawnsColorLabel.setFont(new java.awt.Font("Chandas", 3, 18)); // NOI18N
        pawnsColorLabel.setForeground(new java.awt.Color(0, 204, 204));
        pawnsColorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pawnsColorLabel.setText("FICHAS BLANCAS");
        pawnsColorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(pawnsColorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 240, 30));

        timerLabel.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(0, 204, 204));
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("00:00:00:00");
        timerLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(timerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 230, 30));

        separatorLine3.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine3.setForeground(new java.awt.Color(255, 255, 255));
        statsPanel.add(separatorLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 220, 20));

        catchesPlayer2Label.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        catchesPlayer2Label.setForeground(new java.awt.Color(0, 204, 204));
        catchesPlayer2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        catchesPlayer2Label.setText("0");
        catchesPlayer2Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(catchesPlayer2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 220, 30));

        separatorLine4.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine4.setForeground(new java.awt.Color(255, 255, 255));
        statsPanel.add(separatorLine4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 200, 20));

        catchesPlayer1Label.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        catchesPlayer1Label.setForeground(new java.awt.Color(0, 204, 204));
        catchesPlayer1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        catchesPlayer1Label.setText("0");
        catchesPlayer1Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(catchesPlayer1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 220, 30));

        player1Label.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        player1Label.setForeground(new java.awt.Color(255, 255, 255));
        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Label.setText("Piezas comidas por Jugador 1");
        player1Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(player1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 310, 30));

        infoLabel5.setFont(new java.awt.Font("Chandas", 3, 14)); // NOI18N
        infoLabel5.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel5.setText("REGLAS DEL JUEGO");
        infoLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(infoLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 200, 30));

        infoLabel4.setFont(new java.awt.Font("Chandas", 3, 14)); // NOI18N
        infoLabel4.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel4.setText("TURNO DE");
        infoLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(infoLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 200, 30));

        infoLabel6.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        infoLabel6.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel6.setText("--> Solo es permitido comer una pieza");
        infoLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(infoLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 310, 30));

        infoLabel7.setFont(new java.awt.Font("Chandas", 3, 14)); // NOI18N
        infoLabel7.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel7.setText("CRONOMETRO");
        infoLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(infoLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 30));

        infoLabel8.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        infoLabel8.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel8.setText("--> Pieza tocada, pieza movida");
        infoLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(infoLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 270, 30));

        infoLabel9.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        infoLabel9.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel9.setText("--> No flying");
        infoLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsPanel.add(infoLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 270, 30));

        saveButton.setBackground(new java.awt.Color(0, 102, 102));
        saveButton.setFont(new java.awt.Font("Chandas", 3, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save Game");
        saveButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        statsPanel.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 240, 40));

        background.add(statsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 360, 640));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/checkersBG.jpg"))); // NOI18N
        background.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (ID == 0){
            MenuCheckersGUI menuCheckers = new MenuCheckersGUI();
            menuCheckers.setVisible(true);
            time.stop();
        }
        if (saveDataID == 1) {
            System.out.println("\nSe guardaron los datos de la partida");
            UpdateUser update = new UpdateUser();
            update.updateStats(MenuCheckersGUI.getUsers(),saveUser1, winUser1, movesUser1,1);
            update.updateStats(MenuCheckersGUI.getUsers(),saveUser2, winUser2, movesUser2,1);
            
            Serialization serialize = new Serialization();
            serialize.serializeUsers(MenuCheckersGUI.getUsers(),"Checkers_users.dat");
        } else {
            System.out.println("\nLa partida no conto para guardar datos");
        }
    }//GEN-LAST:event_formWindowClosed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        time.stop();
        saveGame();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void saveGame() {
        saveUser1.setEatenPawns(Integer.parseInt(catchesPlayer1Label.getText()));
        saveUser2.setEatenPawns(Integer.parseInt(catchesPlayer2Label.getText()));
        saveUser1.setTemporalMoves(movesUser1);
        saveUser2.setTemporalMoves(movesUser2);
        
        ArrayList<SaveGame> gamesSaved = MenuCheckersGUI.getGamesSaved();
        SaveGame gameSaved = new SaveGame(saveUser1, saveUser2,logicBoard, hours, minutes, seconds);
        gamesSaved.add(gameSaved);
        
        Serialization serialize = new Serialization();
        serialize.serializeGames(gamesSaved, "Checkers_games.dat");
        JOptionPane.showMessageDialog(null,"Se ha guardado la partida con exito");
        endSavedGame = 1;
        saveButton.setEnabled(false);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel boardPanel;
    public static javax.swing.JLabel catchesPlayer1Label;
    public static javax.swing.JLabel catchesPlayer2Label;
    private javax.swing.JLabel infoLabel4;
    private javax.swing.JLabel infoLabel5;
    private javax.swing.JLabel infoLabel6;
    private javax.swing.JLabel infoLabel7;
    private javax.swing.JLabel infoLabel8;
    private javax.swing.JLabel infoLabel9;
    public static javax.swing.JLabel pawnsColorLabel;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player2Label;
    public static javax.swing.JLabel playerTurnLabel;
    public static javax.swing.JButton saveButton;
    private javax.swing.JSeparator separatorLine;
    private javax.swing.JSeparator separatorLine1;
    private javax.swing.JSeparator separatorLine2;
    private javax.swing.JSeparator separatorLine3;
    private javax.swing.JSeparator separatorLine4;
    private javax.swing.JPanel statsPanel;
    public static javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
