/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.principal;

import com.gui.general.PrincipalGUI;

/**
 * Clase principal en la cual se hace el llamado a las demas clases del proyecto
 * @author erik-lopez
 */
public class Principal {

    /**
     * @param args clase principal donde se inicializa el proyecto
     */
    public static void main(String[] args) {
        PrincipalGUI principal = new PrincipalGUI();
        principal.setVisible(true);
    }
    
}
