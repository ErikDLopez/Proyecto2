package com.functionalities.checkers;

import com.functionalities.interfaces.Image;
import com.gui.checkers.principals.BoardGUI;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Clase que contiene los metodos y atributos para los movimientos correspondientes para las fichas
 * 
 * @author erik-lopez
 * 
 */
public class Move implements Image {
    char[][] logicBoard;
    JButton[][] board;
    int counterChangeTurn;
    Pawn pawn;
    int newPosX, newPosY;
    
    public void starMove(int playerTurn, int numberMoves, int posX, int posY) {
        logicBoard = Board.getLogicBoard();
        board = Board.getBoard();
        counterChangeTurn = 0;
        numberMoves(numberMoves, posX, posY, logicBoard[posX][posY], playerTurn);
        
    }
    
    public void numberMoves(int numberMoves, int posX, int posY, char ID, int playerTurn) {
        if (numberMoves == 1) {
            System.out.println("\nTurno para seleccionar ficha "+numberMoves);
            pawn = new Pawn(posX, posY,logicBoard[posX][posY],playerTurn);
            pawn.showStats();
            verifyPawn();
        }
        if (numberMoves == 2) {
            System.out.println("\nTurno para seleccionar casilla disponible "+numberMoves);
            pawn = Board.getPawn();
            newPosX = posX;
            newPosY = posY;
            pawn.showPositions();
            System.out.println("\nNueva posicion:     ("+newPosX+","+newPosY+")");
            movePawn();
        }
        changePlayerTurn(pawn.getPlayerTurn());
        Board.setLogicBoard(logicBoard);
        Board.setBoard(board);
    }
    
    public void verifyPawn() {
        boolean correctPawn = pawn.correctID();
        
        if (correctPawn == true) {
            System.out.println("\nLa pieza le pertenece al jugador");
            definePositions();
            
        }
        if (correctPawn == false) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una ficha del jugador");
        }
    }
    
    public void definePositions() {
        pawn.definePosiblesMoves();
        pawn.showPositions();
        availablePositions();
    }
    
    public void availablePositions() {
        boolean pos1 = pawn.verifyOptionExists(pawn.getOptionX1(), pawn.getOptionY1());
        boolean pos2 = pawn.verifyOptionExists(pawn.getOptionX2(), pawn.getOptionY2());
        boolean pos3 = pawn.verifyOptionExists(pawn.getOptionX3(), pawn.getOptionY3());
        boolean pos4 = pawn.verifyOptionExists(pawn.getOptionX4(), pawn.getOptionY4());
        
        System.out.println("\nOpcion 1 = "+pos1);
        System.out.println("Opcion 2 = "+pos2);
        
        if (pawn.getID() == 'B' || pawn.getID() == 'N') {
            posibilityToEat(pos1, pos2);
            System.out.println("\nPosiciones despues de verificar si se pueden comer fichas");
            pawn.showPositions();
            pos1 = pawn.verifyOptionExists(pawn.getOptionX1(), pawn.getOptionY1());
            pos2 = pawn.verifyOptionExists(pawn.getOptionX2(), pawn.getOptionY2());
            System.out.println("\nOpcion 1 despues de ver si se puede comer = "+pos1);
            System.out.println("Opcion 2 despues de ver si se puede comer= "+pos2);
            
            if (pos1 == true || pos2 == true) {
                System.out.println("\nSi hay posiciones jugables");
                determineFreePosition(pos1, pos2);
            } 
        }
        if (pawn.getID() == 'A' || pawn.getID() == 'Z') {
            System.out.println("Opcion 3 = "+pos3);
            System.out.println("Opcion 4 = "+pos4);
            posibilityToEatQueen(pos1, pos2, pos3, pos4);
            System.out.println("\nPosiciones despues de verificar si se pueden comer fichas");
            pawn.showPositionsQueen();
            pos1 = pawn.verifyOptionExists(pawn.getOptionX1(), pawn.getOptionY1());
            pos2 = pawn.verifyOptionExists(pawn.getOptionX2(), pawn.getOptionY2());
            pos3 = pawn.verifyOptionExists(pawn.getOptionX3(), pawn.getOptionY3());
            pos4 = pawn.verifyOptionExists(pawn.getOptionX4(), pawn.getOptionY4());
            System.out.println("\nOpcion 1 despues de ver si se puede comer = "+pos1);
            System.out.println("Opcion 2 despues de ver si se puede comer= "+pos2);
            System.out.println("Opcion 3 despues de ver si se puede comer = "+pos3);
            System.out.println("Opcion 4 despues de ver si se puede comer= "+pos4);
            
            if (pos1 == true || pos2 == true || pos3 == true || pos4 == true) {
                System.out.println("\nSi hay posiciones jugables");
                determineFreePositionQueen(pos1, pos2, pos3, pos4);
            } 
        }
            
    }
    
    public void posibilityToEatQueen(boolean pos1, boolean pos2, boolean pos3, boolean pos4) {
        if (pos1 == true) {
            optionsToEat(1);
        }
        if (pos2 == true) {
            optionsToEat(2);
        }
        if (pos3 == true) {
            optionsToEat(3);
        }
        if (pos4 == true) {
            optionsToEat(4);
        }
    }
    public void posibilityToEat(boolean pos1, boolean pos2) {
        if (pos1 == true) {
            optionsToEat(1);
        }
        if (pos2 == true) {
            optionsToEat(2);
        }
    }
    
    public void optionsToEat(int pos) {
        if (pawn.getPlayerTurn() == 1) {
            pawn.eatPawn(logicBoard, 'N', 'A',pos);
        }
        if (pawn.getPlayerTurn() == 2) {
            pawn.eatPawn(logicBoard, 'B', 'Z', pos);
        }
    }
    
    public void determineFreePosition(boolean pos1, boolean pos2) {
        boolean validPos1 = verifyPosition(pos1, pawn.getOptionX1(),pawn.getOptionY1());
        boolean validPos2 = verifyPosition(pos2, pawn.getOptionX2(),pawn.getOptionY2());
        
        System.out.println("\nEspacio disponible = "+validPos1);
        System.out.println("Espacio disponible = "+validPos2);
        
        if(validPos1 == false && validPos2 == false) {
            JOptionPane.showMessageDialog(null, "La ficha no puede realizar ningun movimiento");
        }
        
        if (validPos1 == true || validPos2 == true) {
            System.out.println("\nSi hay espacios para moverse");
            counterChangeTurn = 1;
            Board.setNumberMoves(2);
            Board.setPawn(pawn);
        }
    }
    public void determineFreePositionQueen(boolean pos1, boolean pos2,boolean pos3, boolean pos4) {
        boolean validPos1 = verifyPosition(pos1, pawn.getOptionX1(),pawn.getOptionY1());
        boolean validPos2 = verifyPosition(pos2, pawn.getOptionX2(),pawn.getOptionY2());
        boolean validPos3 = verifyPosition(pos3, pawn.getOptionX3(),pawn.getOptionY3());
        boolean validPos4 = verifyPosition(pos4, pawn.getOptionX4(),pawn.getOptionY4());
        
        System.out.println("\nEspacio disponible 1 = "+validPos1);
        System.out.println("Espacio disponible 2 = "+validPos2);
        System.out.println("Espacio disponible 3 = "+validPos3);
        System.out.println("Espacio disponible 4 = "+validPos4);
        
        if(validPos1 == false && validPos2 == false && validPos3 == false && validPos4 == false) {
            JOptionPane.showMessageDialog(null, "La ficha no puede realizar ningun movimiento");
        }
        
        if (validPos1 == true || validPos2 == true || validPos3 == true || validPos4 == true) {
            System.out.println("\nSi hay espacios para moverse");
            counterChangeTurn = 1;
            Board.setNumberMoves(2);
            Board.setPawn(pawn);
        }
    
    }
    
    public boolean verifyPosition(boolean posExists, int posX, int posY) {
        boolean validPosition = false;
        
        if (posExists == true){
            if (logicBoard[posX][posY] == '-') {
                board[posX][posY].setIcon(new javax.swing.ImageIcon(getClass().getResource(FREE_SLOT)));
                logicBoard[posX][posY] = 'O';
                validPosition = true;
            }
        }
        return validPosition;
    }
    
    public void movePawn(){
        char ID = logicBoard[newPosX][newPosY];
        
        if (ID == 'O') {
            System.out.println("\nEs un movimiento valido");
            if (pawn.getID() == 'N' || pawn.getID() == 'B') {
                cleanPawnEaten();
                moveLogicPositions();
                assignOtherLogicsPositions();
            }
            if (pawn.getID() == 'A' || pawn.getID() == 'Z') {
                System.out.println("\nSeleccion para una reina");
                cleanPawnEatenQueen();
                moveLogicPositionsQueen();
                assignOtherLogicsPositionsQueen();
            }
            counterChangeTurn = 2;
            Board.setNumberMoves(1);
        }
        if (ID != 'O') {
            JOptionPane.showMessageDialog(null, "No es un movimiento valido");
        }
    }
    
    public void cleanPawnEaten() {
        boolean pawnEaten = false;
        pawnEaten = pawn.analyzePosition(newPosY);
        System.out.println("Se puede comer ficha? "+pawnEaten);
        
        if (pawnEaten == true) {
            pawn.cleanPawn(newPosY);
            pawn.sendStat();
            board[pawn.getPosEatX()][pawn.getPosEatY()] = assignButtonDesign(board[pawn.getPosEatX()][pawn.getPosEatY()], '-');
            logicBoard[pawn.getPosEatX()][pawn.getPosEatY()] = '-';
        }
    }
    
    public void cleanPawnEatenQueen() {
        boolean pawnEaten = false;
        pawnEaten = pawn.analyzPositionQueen(newPosY, newPosX);
        System.out.println("Se puede comer pieza? "+pawnEaten);
        
        if (pawnEaten == true) {
            pawn.cleanPawnQueen(newPosX, newPosY);
            pawn.sendStat();
            board[pawn.getPosEatX()][pawn.getPosEatY()] = assignButtonDesign(board[pawn.getPosEatX()][pawn.getPosEatY()], '-');
            logicBoard[pawn.getPosEatX()][pawn.getPosEatY()] = '-';
        }
        
    }
    
    public void moveLogicPositions() {
        char newPosition = '-';
        switch (pawn.getPlayerTurn()) {
            case 1:
                logicBoard[newPosX][newPosY] = 'B';
                newPosition = 'B';
                break;
            case 2:
                logicBoard[newPosX][newPosY] = 'N';
                newPosition = 'N';
                break;
        }
        newPosition = pawnCrown(newPosition);
        logicBoard[pawn.getOriginX()][pawn.getOriginY()] = '-';
        board[pawn.getOriginX()][pawn.getOriginY()] = assignButtonDesign(board[pawn.getOriginX()][pawn.getOriginY()],'-');
        board[newPosX][newPosY] = assignButtonDesign(board[newPosX][newPosY], newPosition);
    }
    
    
    public char pawnCrown(char newPosition) {
        boolean crown = pawn.pawnCrown(newPosX);
        if (crown == true){
            if (pawn.getPlayerTurn() == 1) {
                logicBoard[newPosX][newPosY] = 'Z';
                newPosition = 'Z';
            }
            if (pawn.getPlayerTurn() == 2) {
                logicBoard[newPosX][newPosY] = 'A';
                newPosition = 'A';
            }
        }
        return newPosition;
    }
    
    public void assignOtherLogicsPositions() {
        boolean pos1 = pawn.verifyOptionExists(pawn.getOptionX1(), pawn.getOptionY1());
        boolean pos2 = pawn.verifyOptionExists(pawn.getOptionX2(), pawn.getOptionY2());
        
        defineOtherLogicPositions(pos1, pawn.getOptionX1(), pawn.getOptionY1());
        defineOtherLogicPositions(pos2, pawn.getOptionX2(), pawn.getOptionY2());
        Board.setBoard(board);
    }
    
    public void moveLogicPositionsQueen() {
        char newPosition = '-';
        switch (pawn.getPlayerTurn()) {
            case 1:
                logicBoard[newPosX][newPosY] = 'Z';
                newPosition = 'Z';
                break;
            case 2:
                logicBoard[newPosX][newPosY] = 'A';
                newPosition = 'A';
                break;
        }
        newPosition = pawnCrown(newPosition);
        logicBoard[pawn.getOriginX()][pawn.getOriginY()] = '-';
        board[pawn.getOriginX()][pawn.getOriginY()] = assignButtonDesign(board[pawn.getOriginX()][pawn.getOriginY()],'-');
        board[newPosX][newPosY] = assignButtonDesign(board[newPosX][newPosY], newPosition);
    }
    
    public void assignOtherLogicsPositionsQueen() {
        boolean pos1 = pawn.verifyOptionExists(pawn.getOptionX1(), pawn.getOptionY1());
        boolean pos2 = pawn.verifyOptionExists(pawn.getOptionX2(), pawn.getOptionY2());
        boolean pos3 = pawn.verifyOptionExists(pawn.getOptionX3(), pawn.getOptionY3());
        boolean pos4 = pawn.verifyOptionExists(pawn.getOptionX4(), pawn.getOptionY4());
        
        defineOtherLogicPositions(pos1, pawn.getOptionX1(), pawn.getOptionY1());
        defineOtherLogicPositions(pos2, pawn.getOptionX2(), pawn.getOptionY2());
        defineOtherLogicPositions(pos3, pawn.getOptionX3(), pawn.getOptionY3());
        defineOtherLogicPositions(pos4, pawn.getOptionX4(), pawn.getOptionY4());
        Board.setBoard(board);
    }
    
    public void defineOtherLogicPositions(boolean posExists, int posX, int posY) {
        if (posExists == true) {
            int charID = logicBoard[posX][posY];
            
            if (charID == 'O') {
                logicBoard[posX][posY] = '-';
            }
            board[posX][posY] = assignButtonDesign(board[posX][posY],logicBoard[posX][posY]);
        }
    }
    
    public void changePlayerTurn(int playerTurn) {
        if ( counterChangeTurn >= 2) {
            String namePlayer = "";
            int moves;
            
            switch (playerTurn) {
                case 1:
                    Board.setTurn(2);
                    moves = BoardGUI.getMovesUser1();
                    moves++;
                    BoardGUI.setMovesUser1(moves);
                    BoardGUI.setTurnStats(Board.getUser2().getName(),"FICHAS NEGRAS");
                    namePlayer = Board.getUser2().getName();
                    break;
                case 2:
                    Board.setTurn(1);
                    moves = BoardGUI.getMovesUser2();
                    moves++;
                    BoardGUI.setMovesUser2(moves);
                    BoardGUI.setTurnStats(Board.getUser1().getName(),"FICHAS BLANCAS");
                    namePlayer = Board.getUser1().getName();
                    break;
            }
            System.out.println("\nTotal movimientos FICHAS BLANCAS: "+BoardGUI.getMovesUser1());
            System.out.println("Total movimientos FICHAS NEGRAS:  "+BoardGUI.getMovesUser2());
            JOptionPane.showMessageDialog(null,"TURNO PARA: "+namePlayer);
        } else {
            System.out.println("\nTodavia no se cambia de turno");
        }
    }
    
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
        button.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        return button;
    }
}
