package com.functionalities.utilities;

import java.util.Random;

/**
 * Clase que contiene metodos y atributos utilitarios
 * 
 * @author erik-lopez
 * 
 */
public class Util {
    
    public int randomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        int number = random.nextInt(upperBound)+lowerBound;
        return number;
    }
    
    public int fiftyPercent() {
        int percent = randomNumber(1,100);
        
        int choice = 0;
        
        if (percent >= 1 && percent <= 50) {
            choice = 1;
        }
        if (percent >= 51 && percent <= 100) {
            choice = 2;
        }
        return choice;
    }
    
}
