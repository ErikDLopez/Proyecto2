
package com.functionalities.checkers;

import com.functionalities.interfaces.Image;
import com.gui.checkers.principals.BoardGUI;
import javax.swing.JButton;

/**
 *
 * @author erik-lopez
 */
public class Pawn implements Image{
    private int playerTurn;
    private int originX;
    private int originY;
    private char ID;
    private int optionX1;
    private int optionY1;
    private int optionX2;
    private int optionY2;
    private int optionX3;
    private int optionY3;
    private int optionX4;
    private int optionY4;
    private boolean eatPos1;
    private boolean eatPos2;
    private boolean eatPos3, eatPos4;
    private int posEatX, posEatY;

    /**
     *
     * @param originX
     * @param originY
     * @param ID
     * @param playerTurn
     */
    public Pawn(int originX, int originY, char ID, int playerTurn) {
        this.playerTurn = playerTurn;
        this.originX = originX;
        this.originY = originY;
        this.ID = ID;
        this.optionX1 = 0;
        this.optionY1 = 0;
        this.optionX2 = 0;
        this.optionY2 = 0;
        this.optionX3 = 0;
        this.optionY3 = 0;
        this.optionX4 = 0;
        this.optionY4 = 0;
        this.eatPos1 = false;
        this.eatPos2 = false;
        this.eatPos3 = false;
        this.eatPos4 = false;
        this.posEatX = 0;
        this.posEatY = 0;
    }

    /**
     *
     * @return
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     *
     * @param playerTurn
     */
    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
    
    /**
     *
     * @return
     */
    public int getOriginX() {
        return originX;
    }

    /**
     *
     * @param originX
     */
    public void setOriginX(int originX) {
        this.originX = originX;
    }

    /**
     *
     * @return
     */
    public int getOriginY() {
        return originY;
    }

    /**
     *
     * @param originY
     */
    public void setOriginY(int originY) {
        this.originY = originY;
    }

    /**
     *
     * @return
     */
    public char getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(char ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    public int getOptionX1() {
        return optionX1;
    }

    /**
     *
     * @param optionX1
     */
    public void setOptionX1(int optionX1) {
        this.optionX1 = optionX1;
    }

    /**
     *
     * @return
     */
    public int getOptionY1() {
        return optionY1;
    }

    /**
     *
     * @param optionY1
     */
    public void setOptionY1(int optionY1) {
        this.optionY1 = optionY1;
    }

    /**
     *
     * @return
     */
    public int getOptionX2() {
        return optionX2;
    }

    /**
     *
     * @param optionX2
     */
    public void setOptionX2(int optionX2) {
        this.optionX2 = optionX2;
    }

    /**
     *
     * @return
     */
    public int getOptionY2() {
        return optionY2;
    }

    /**
     *
     * @param optionY2
     */
    public void setOptionY2(int optionY2) {
        this.optionY2 = optionY2;
    }

    /**
     *
     * @return
     */
    public boolean isEatPos1() {
        return eatPos1;
    }

    /**
     *
     * @param eatPos1
     */
    public void setEatPos1(boolean eatPos1) {
        this.eatPos1 = eatPos1;
    }

    /**
     *
     * @return
     */
    public boolean isEatPos2() {
        return eatPos2;
    }

    /**
     *
     * @param eatPos2
     */
    public void setEatPos2(boolean eatPos2) {
        this.eatPos2 = eatPos2;
    }

    /**
     *
     * @return
     */
    public int getPosEatX() {
        return posEatX;
    }

    /**
     *
     * @param posEatX
     */
    public void setPosEatX(int posEatX) {
        this.posEatX = posEatX;
    }

    /**
     *
     * @return
     */
    public int getPosEatY() {
        return posEatY;
    }

    /**
     *
     * @param posEatY
     */
    public void setPosEatY(int posEatY) {
        this.posEatY = posEatY;
    }

    /**
     *
     * @return
     */
    public int getOptionX3() {
        return optionX3;
    }

    /**
     *
     * @param optionX3
     */
    public void setOptionX3(int optionX3) {
        this.optionX3 = optionX3;
    }

    /**
     *
     * @return
     */
    public int getOptionY3() {
        return optionY3;
    }

    /**
     *
     * @param optionY3
     */
    public void setOptionY3(int optionY3) {
        this.optionY3 = optionY3;
    }

    /**
     *
     * @return
     */
    public int getOptionX4() {
        return optionX4;
    }

    /**
     *
     * @param optionX4
     */
    public void setOptionX4(int optionX4) {
        this.optionX4 = optionX4;
    }

    /**
     *
     * @return
     */
    public int getOptionY4() {
        return optionY4;
    }

    /**
     *
     * @param optionY4
     */
    public void setOptionY4(int optionY4) {
        this.optionY4 = optionY4;
    }

    /**
     *
     * @return
     */
    public boolean isEatPos3() {
        return eatPos3;
    }

    /**
     *
     * @param eatPos3
     */
    public void setEatPos3(boolean eatPos3) {
        this.eatPos3 = eatPos3;
    }

    /**
     *
     * @return
     */
    public boolean isEatPos4() {
        return eatPos4;
    }

    /**
     *
     * @param eatPos4
     */
    public void setEatPos4(boolean eatPos4) {
        this.eatPos4 = eatPos4;
    }
    
    /**
     *
     * @return
     */
    public boolean correctID() {
        boolean correctID = false;
        
        switch (playerTurn) {
            case 1:
                correctID = compareID('B','Z');
                break;
            case 2:
                correctID = compareID('N','A');
                break;
        }
        return correctID;
    }
    
    /**
     *
     * @param typeID
     * @param queenID
     * @return
     */
    public boolean compareID(int typeID, int queenID) {
        boolean sameID = false;
        if (ID == typeID || ID == queenID) {
            sameID = true;
        }
        return sameID;
    }
    
    /**
     *
     * @param posX
     * @return
     */
    public boolean pawnCrown(int posX) {
        boolean crown = false;
        if (playerTurn == 1) {
            if (posX == 0) {
                crown = true;
            }
        }
        if (playerTurn == 2) {
            if (posX == 7) {
                crown = true;
            }
        }
        return crown;
    }
    
    /**
     *
     */
    public void definePosiblesMoves() {
        optionY1 = originY - 1; 
        optionY2 = originY + 1;
        optionY3 = originY - 1;
        optionY4 = originY + 1;
        
        if (ID == 'B'){
            optionX1 = originX - 1;
            optionX2 = originX - 1;
        }
        if (ID == 'N'){
            optionX1 = originX + 1;
            optionX2 = originX + 1;
        }
        if (ID == 'A' || ID == 'Z'){
            optionX1 = originX - 1;
            optionX2 = originX - 1;
            optionX3 = originX + 1;
            optionX4 = originX + 1;
        }
    }
    
    /**
     *
     * @param posX
     * @param posY
     * @return
     */
    public boolean verifyOptionExists(int posX, int posY) {
        boolean optionExists = false;
        boolean posXExists = verifyLimits(posX);
        boolean posYExists = verifyLimits(posY);
        
        if (posXExists == true && posYExists == true) {
            optionExists = true;
        }
        return optionExists;
    }
    
    /**
     *
     * @param position
     * @return
     */
    public boolean verifyLimits(int position) {
        boolean free = false;
        
        if (position >= 0 && position <= 7) {
            free = true;
        } else {
            free = false;
        }
        return free;
    }
    
    /**
     *
     * @param logicBoard
     * @param type
     * @param typeQueen
     * @param pos
     */
    public void eatPawn(char[][] logicBoard, char type, char typeQueen, int pos) {
        switch (pos) {
            case 1:
                char idPos1 = logicBoard[optionX1][optionY1];
                boolean eatPos1 = posibilityToEat(type, typeQueen,idPos1);
                positionsEatPos1(eatPos1);
                break;
            case 2:
                char idPos2 = logicBoard[optionX2][optionY2];
                boolean eatPos2 = posibilityToEat(type, typeQueen, idPos2);
                positionsEatPos2(eatPos2);
                break;
            case 3:
                char idPos3 = logicBoard[optionX3][optionY3];
                boolean eatPos3 = posibilityToEat(type, typeQueen, idPos3);
                positionsEatPos3(eatPos3);
                break;
            case 4:
                char idPos4 = logicBoard[optionX4][optionY4];
                boolean eatPos4 = posibilityToEat(type, typeQueen, idPos4);
                positionsEatPos4(eatPos4);
                break;    
        }
    }
    
    /**
     *
     * @param typeID
     * @param typeQueen
     * @param pos
     * @return
     */
    public boolean posibilityToEat(char typeID,char typeQueen, char pos) {
        boolean eat = false;
        if (pos == typeID || pos == typeQueen) {
            eat = true;
        }
        return eat;
    }
    
    /**
     *
     * @param eatPos
     */
    public void positionsEatPos1(boolean eatPos) {
        if (eatPos == true) {
            if (playerTurn == 1) {
                optionX1 = originX - 2;
            }
            if (playerTurn == 2) {
                optionX1 = originX + 2;
            }
            if (ID == 'A' || ID == 'Z'){
                optionX1 = originX - 2;
            }
            optionY1 = originY - 2;
            eatPos1 = true;
        }
    }
    
    /**
     *
     * @param eatPos
     */
    public void positionsEatPos2(boolean eatPos) {
        if (eatPos == true) {
            if (playerTurn == 1) {
                optionX2 = originX - 2;
            }
            if (playerTurn == 2) {
                optionX2 = originX + 2;
            }
            if (ID == 'A' || ID == 'Z'){
                optionX2 = originX - 2;
            }
            optionY2 = originY + 2;
            eatPos2 = true;
        }
    }
    
    /**
     *
     * @param eatPos
     */
    public void positionsEatPos3(boolean eatPos) {
        if (eatPos == true) {
            if (ID == 'A' || ID == 'Z'){
                optionX3 = originX + 2;
                optionY3 = originY - 2;
            }
            eatPos3= true;
        }
    }
    
    /**
     *
     * @param eatPos
     */
    public void positionsEatPos4(boolean eatPos) {
        if (eatPos == true) {
            if (ID == 'A' || ID == 'Z'){
                optionX4 = originX + 2;
                optionY4 = originY + 2;
            }
            eatPos4 = true;
        }
    }
    
    /**
     *
     * @param posY
     * @return
     */
    public boolean analyzePosition(int posY) {
        boolean eatMove = false;
        if (posY > originY) {
            System.out.println("\nSe selecciono la pos2");
            eatMove = movementToEat(eatPos2);  
        }
        if (posY < originY) {
            System.out.println("\nSe selecciono la pos1");
            eatMove = movementToEat(eatPos1);
        }
        return eatMove;
    }
    
    /**
     *
     * @param posY
     * @param posX
     * @return
     */
    public boolean analyzPositionQueen(int posY, int posX) {
        boolean eatMove = false;
        if (posY > originY) {
            if (posX > originX) {
                System.out.println("\nSe selecciono la pos4");
                eatMove = movementToEat(eatPos4);
            }
            if (posX < originX) {
                System.out.println("\nSe selecciono la pos2");
                eatMove = movementToEat(eatPos2);
            }  
        }
        if (posY < originY) {
            if (posX > originX) {
                System.out.println("\nSe selecciono la pos3");
                eatMove = movementToEat(eatPos3);
            }
            if (posX < originX) {
                System.out.println("\nSe selecciono la pos1");
                eatMove = movementToEat(eatPos1);
            }
        }
        return eatMove;
    }
    
    /**
     *
     * @param eatPos
     * @return
     */
    public boolean movementToEat(boolean eatPos) {
        boolean eat = false;
        if (eatPos == true){
            System.out.println("Es un movimiento para comer la ficha");
            eat = true;
        }
        return eat;
    }
    
    /**
     *
     * @param posY
     */
    public void cleanPawn(int posY) { 
        if (posY < originY) {
            cleanPos1();
        }
        if (posY > originY) {
            cleanPos2();
        }
    }
    
    /**
     *
     * @param posX
     * @param posY
     */
    public void cleanPawnQueen(int posX, int posY) { 
        if (posY > originY) {
            if (posX > originX) {
                cleanPos4();
            }
            if (posX < originX) {
                cleanPos2();
            }  
        }
        if (posY < originY) {
            if (posX > originX) {
                cleanPos3();
            }
            if (posX < originX) {
                cleanPos1();
            }
        }
    }
    
    /**
     *
     */
    public void cleanPos1() {
        if (playerTurn == 1){
            posEatX = originX - 1;   
        }
        if (playerTurn == 2){
            posEatX = originX + 1;
        }
        if (ID == 'A' || ID == 'Z') {
            posEatX = originX - 1;
        }
        posEatY = originY - 1;
    }
    
    /**
     *
     */
    public void cleanPos2() {
        if (playerTurn == 1){
            posEatX = originX - 1;    
        }
        if (playerTurn == 2){
            posEatX = originX + 1;
        }
        if (ID == 'A' || ID == 'Z') {
            posEatX = originX - 1;
        }
        posEatY = originY + 1;
    }
    
    /**
     *
     */
    public void cleanPos3() {
        if (ID == 'A' || ID == 'Z') {
            posEatX = originX + 1;
            posEatY = originY - 1;
        }
    }
    
    /**
     *
     */
    public void cleanPos4() {
        if (ID == 'A' || ID == 'Z') {
            posEatX = originX + 1;
            posEatY = originY + 1;
        }
    }
    
    /**
     *
     */
    public void sendStat() {
        int pawnsEaten = 0;
        
        if (playerTurn == 1){
            pawnsEaten = Integer.parseInt(BoardGUI.getCatchesPlayer1());
            pawnsEaten++;
            BoardGUI.setCatchesPlayer1(String.valueOf(pawnsEaten));
        }
        if (playerTurn == 2){
            pawnsEaten = Integer.parseInt(BoardGUI.getCatchesPlayer2());
            pawnsEaten++;
            BoardGUI.setCatchesPlayer2(String.valueOf(pawnsEaten));
        }
    }
    
    /**
     *
     */
    public void showPositions() {
        System.out.println("\nPos original     ("+originX+","+originY+")");
        System.out.println("Pos izquierda  1 ("+optionX1+","+optionY1+")");
        System.out.println("Pos derecha    2 ("+optionX2+","+optionY2+")");
    }
    
    /**
     *
     */
    public void showStats() {
        System.out.println("\nEs turno del jugador: "+playerTurn);
        System.out.println("Pos original     ("+originX+","+originY+")");
        System.out.println("El caracter es: "+ID);
    }
    
    /**
     *
     */
    public void showPositionsQueen() {
        System.out.println("\nPos original     ("+originX+","+originY+")");
        System.out.println("Pos izquierda  1 ("+optionX1+","+optionY1+")");
        System.out.println("Pos derecha    2 ("+optionX2+","+optionY2+")");
        System.out.println("Pos izquierda  3 ("+optionX3+","+optionY3+")");
        System.out.println("Pos derecha    4 ("+optionX4+","+optionY4+")");
    }
}
