package com.functionalities.checkers;

import com.functionalities.interfaces.Image;
import com.functionalities.utilities.Util;
import com.functionalities.utilities.files.User;
import com.gui.checkers.options.LoadGame;
import com.gui.checkers.options.SelectPlayer;
import com.gui.checkers.principals.BoardGUI;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que contiene los metodos y atributos para la generacion del tablero y de sus acciones
 * 
 * @author erik-lopez
 * 
 */
public class Board implements ActionListener, Image{
    Util util = new Util();

    /**
     *
     */
    public static User user1,

    /**
     *
     */
    user2;

    /**
     *
     */
    public static Pawn pawn;
    private int size;

    /**
     *
     */
    public static JButton[][] board;

    /**
     *
     */
    public static char[][] logicBoard;

    /**
     *
     */
    public static int numberMoves;

    /**
     *
     */
    public static int turn;

    /**
     *
     */
    public static int[] tempPositions = new int[8];
    
    /**
     *
     * @param size
     */
    public Board(int size) {
        this.size = size;
        numberMoves = 1;
    }

    /**
     *
     * @return
     */
    public static int getTurn() {
        return turn;
    }

    /**
     *
     * @param turn
     */
    public static void setTurn(int turn) {
        Board.turn = turn;
    }

    /**
     *
     * @return
     */
    public static int getNumberMoves() {
        return numberMoves;
    }

    /**
     *
     * @param numberMoves
     */
    public static void setNumberMoves(int numberMoves) {
        Board.numberMoves = numberMoves;
    }

    /**
     *
     * @return
     */
    public static JButton[][] getBoard() {
        return board;
    }

    /**
     *
     * @param board
     */
    public static void setBoard(JButton[][] board) {
        Board.board = board;
    }

    /**
     *
     * @return
     */
    public static char[][] getLogicBoard() {
        return logicBoard;
    }

    /**
     *
     * @param logicBoard
     */
    public static void setLogicBoard(char[][] logicBoard) {
        Board.logicBoard = logicBoard;
    }

    /**
     *
     * @return
     */
    public static int[] getTempPositions() {
        return tempPositions;
    }

    /**
     *
     * @param tempPositions
     */
    public static void setTempPositions(int[] tempPositions) {
        Board.tempPositions = tempPositions;
    }

    /**
     *
     * @return
     */
    public static Pawn getPawn() {
        return pawn;
    }

    /**
     *
     * @param pawn
     */
    public static void setPawn(Pawn pawn) {
        Board.pawn = pawn;
    }

    /**
     *
     * @return
     */
    public static User getUser1() {
        return user1;
    }

    /**
     *
     * @param user1
     */
    public static void setUser1(User user1) {
        Board.user1 = user1;
    }

    /**
     *
     * @return
     */
    public static User getUser2() {
        return user2;
    }

    /**
     *
     * @param user2
     */
    public static void setUser2(User user2) {
        Board.user2 = user2;
    }
    
    /**
     *
     * @param boardPanel
     * @param typeGame
     * @return
     */
    public JPanel generateBoard(JPanel boardPanel, int typeGame) {
        board = new JButton[size][size];
        logicBoard = new char[size][size];
        boardPanel.setLayout(new GridLayout(size,size));
        assignTotalLogiBoard(typeGame);
        
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                assignSlotID(x, y, typeGame);
                board[x][y] = new JButton();
                board[x][y] = defineButton(board[x][y],logicBoard[x][y]);
                boardPanel.add(board[x][y]);
            }
        }
        BoardGUI.setLogicBoard(logicBoard);
        return boardPanel;
    }
    
    /**
     *
     * @param posX
     * @param posY
     * @param typeGame
     */
    public void assignSlotID(int posX, int posY, int typeGame) {
        if (typeGame == 1){
            logicBoard[posX][posY] = assignBackgroundID(posX,posY);
            logicBoard[posX][posY] = assignPawnID(posX, posY);
        }
    }
    
    /**
     *
     * @param typeGame
     */
    public void assignTotalLogiBoard(int typeGame) {
        if (typeGame == 2){
            logicBoard = LoadGame.getGame().getLogicBoard();
        }
    }
    
    /**
     *
     * @param posX
     * @param posY
     * @return
     */
    public char assignBackgroundID(int posX, int posY) {
        char character = '0';
        
        //# para las casillas claras y - para las casillas oscuras donde se juega
        if (posX % 2 == 0) {
            
            if (posY % 2 == 0) {
                character = '#';
            } 
            if (posY % 2 != 0) {
                character = '-';
            }
        }
        if (posX % 2 != 0){
            
            if (posY % 2 == 0) {
                character = '-';
            } 
            if (posY % 2 != 0) {
                character = '#';
            }
        }
        return character;
    }
    
    /**
     *
     * @param posX
     * @param posY
     * @return
     */
    public char assignPawnID(int posX, int posY) {
        char bgID = logicBoard[posX][posY];
        char character = bgID;
        
        //Para ubicar las fichas negras en las filas superiores
        if (posX == 0 || posX == 1 || posX == 2) {
            character = definePawn('N', bgID, posX, posY);
        }
        //Para ubicar las fichas blancas en las filas inferiores
        if (posX == 5 || posX == 6 || posX == 7) {
            character = definePawn('B', bgID, posX, posY);
        }
        return character;
    }
    
    /**
     *
     * @param pawnID
     * @param bgID
     * @param posX
     * @param posY
     * @return
     */
    public char definePawn(char pawnID, char bgID, int posX, int posY) {
        char character = bgID;
        
        //Para asignar fichas en casillas con posX par y posY impar
        if (posX % 2 == 0) {
            if (posY % 2 != 0) {
                character = pawnID;
            }
        } 
        //Para asignar fichas en casillas con posX impar y posY par
        if (posX % 2 != 0) {
            if (posY % 2 == 0) {
                character = pawnID;
            } 
        }
        return character;
    }
    
    /**
     *
     * @param button
     * @param slotID
     * @return
     */
    public JButton defineButton(JButton button, char slotID) {
        button = assignButtonDesign(button, slotID);
        button = assignActionButton(button, slotID);
        button.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        return button;
    }
    
    /**
     *
     * @param button
     * @param slotID
     * @return
     */
    public JButton assignButtonDesign(JButton button, char slotID) {
        switch(slotID){
            case '#':
                button.setBackground(new java.awt.Color(179, 111, 43));
                break;
            case '-':
                button.setBackground(new java.awt.Color(89, 44, 0));
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource(TRANSPARENT_SLOT)));
                break;
            case 'N':
                button.setBackground(new java.awt.Color(89, 44, 0));
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource(BLACK_TOKEN)));
                break;
            case 'B':
                button.setBackground(new java.awt.Color(89, 44, 0));
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource(WHITE_TOKEN)));
                break;
            case 'A':
                button.setBackground(new java.awt.Color(89, 44, 0));
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource(BLACK_QUEEN)));
                break;
            case 'Z':
                button.setBackground(new java.awt.Color(89, 44, 0));
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource(WHITE_QUEEN)));
                break;
        }
        return button;
    }
    
    /**
     *
     * @param button
     * @param slotID
     * @return
     */
    public JButton assignActionButton(JButton button, char slotID) {
        if (slotID == '-' || slotID == 'N' || slotID == 'B' || slotID == 'A' || slotID == 'Z') {
            button.addActionListener(this);
        }
        return button;
        
    }
    
    /**
     *
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        Move move = new Move();
        int catchesPlayer1 = Integer.parseInt(BoardGUI.getCatchesPlayer1());
        int catchesPlayer2 = Integer.parseInt(BoardGUI.getCatchesPlayer2());
        
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (event.getSource().equals(board[x][y])) {
                    
                    BoardGUI.setLogicBoard(logicBoard);
                    
                    if (BoardGUI.getEndSavedGame() == 1){
                        BoardGUI.time.stop();
                        JOptionPane.showMessageDialog(null, "SE HA GUARDADO LA PARTIDA, NO PUEDES SEGUIR JUGANDO");
                    } 
                    if (BoardGUI.getEndSavedGame() == 0) {
                        
                        if (catchesPlayer1 < 12 && catchesPlayer2 < 12){
                            move.starMove(turn, numberMoves, x, y);
                            showLogicBoard();
                        }
                        if (catchesPlayer1 >= 12){
                            BoardGUI.time.stop();
                            BoardGUI.setSaveDataID(1);
                            JOptionPane.showMessageDialog(null, "EL JUGADOR "+user1.getName()+" YA HA GANADO");
                            BoardGUI.setWinUser1(1);
                            BoardGUI.setWinUser2(0);
                            BoardGUI.saveButton.setEnabled(false);
                        }
                        if (catchesPlayer2 >= 12){
                            BoardGUI.time.stop();
                            BoardGUI.setSaveDataID(1);
                            JOptionPane.showMessageDialog(null, "EL JUGADOR "+user2.getName()+" YA HA GANADO");
                            BoardGUI.setWinUser1(0);
                            BoardGUI.setWinUser2(1);
                            BoardGUI.saveButton.setEnabled(false);
                        }  
                    }
                    
                }
            }
        }
    }
    
    /**
     *
     * @param typeGame
     */
    public void generateStats(int typeGame) {
        turn = util.fiftyPercent();
        
        if (typeGame == 1){
            user1 = SelectPlayer.getUser1();
            user2 = SelectPlayer.getUser2();
        }
        if (typeGame == 2){
            user1 = LoadGame.getGame().getUser1();
            user2 = LoadGame.getGame().getUser2();
        }
        if (turn == 1) {
            BoardGUI.setTurnStats(user1.getName(),"FICHAS BLANCAS");
        }
        if (turn == 2) {
            BoardGUI.setTurnStats(user2.getName(),"FICHAS NEGRAS");
        }
    }
    
    /**
     *
     */
    public void showLogicBoard() {
        System.out.println("\nTablero logico\n");
        for (int x = 0; x < size; x++) {
            System.out.print("   ");
            
            for (int y = 0; y < size; y++) {
                System.out.print(logicBoard[x][y]);
                
                if (y!= board[x].length-1){ 
                    System.out.print("   ");
                }
            }
            System.out.println();//este es el salto de linea
        }
    }
    
}
