package com.gui.checkers.options;

import com.gui.checkers.principals.MenuCheckersGUI;

/**
 *
 * @author erik-lopez
 */
public class OptionGame extends javax.swing.JFrame {
    private int ID;
    public static int gameID;
    /**
     * Creates new form OptionGame
     */
    public OptionGame() {
        initComponents();
        ID = 0;
        this.setLocationRelativeTo(null);
    }

    public static int getGameID() {
        return gameID;
    }

    public static void setGameID(int gameID) {
        OptionGame.gameID = gameID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        infoLabel5 = new javax.swing.JLabel();
        separatorLine2 = new javax.swing.JSeparator();
        loadButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        playerTurnLabel1 = new javax.swing.JLabel();
        playerTurnLabel2 = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OPCIONES DEL JUEGO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optionPanel.setBackground(new java.awt.Color(51, 51, 51));
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoLabel5.setFont(new java.awt.Font("Chandas", 3, 14)); // NOI18N
        infoLabel5.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel5.setText("Seleccione una opcion");
        infoLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        optionPanel.add(infoLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, 30));

        separatorLine2.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine2.setForeground(new java.awt.Color(255, 255, 255));
        optionPanel.add(separatorLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 200, 20));

        loadButton.setBackground(new java.awt.Color(153, 0, 51));
        loadButton.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        loadButton.setForeground(new java.awt.Color(255, 255, 255));
        loadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/click2.png"))); // NOI18N
        loadButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        optionPanel.add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 100, 100));

        newButton.setBackground(new java.awt.Color(0, 51, 153));
        newButton.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        newButton.setForeground(new java.awt.Color(255, 255, 255));
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/click2.png"))); // NOI18N
        newButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        newButton.setDefaultCapable(false);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        optionPanel.add(newButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 100, 100));

        playerTurnLabel1.setFont(new java.awt.Font("Chandas", 1, 14)); // NOI18N
        playerTurnLabel1.setForeground(new java.awt.Color(255, 255, 255));
        playerTurnLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        playerTurnLabel1.setText("CARGAR PARTIDA");
        playerTurnLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        optionPanel.add(playerTurnLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 160, 30));

        playerTurnLabel2.setFont(new java.awt.Font("Chandas", 1, 14)); // NOI18N
        playerTurnLabel2.setForeground(new java.awt.Color(255, 255, 255));
        playerTurnLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        playerTurnLabel2.setText("JUEGO NUEVO");
        playerTurnLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        optionPanel.add(playerTurnLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 30));

        background.add(optionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 410, 420));

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/checkersBG.jpg"))); // NOI18N
        background.add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 450));

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

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        OptionGameType gameType = new OptionGameType();
        gameType.setVisible(true);
        ID = 1;
        gameID = 1;
        System.out.println("\nOpcion de juego: "+gameID);
        this.dispose();
    }//GEN-LAST:event_newButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (ID == 0){
            MenuCheckersGUI menuCheckers = new MenuCheckersGUI();
            menuCheckers.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        LoadGame load = new LoadGame();
        load.setVisible(true);
        ID = 1;
        gameID = 2;
        System.out.println("\nOpcion de juego: "+gameID);
        this.dispose();
    }//GEN-LAST:event_loadButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(OptionGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(OptionGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(OptionGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(OptionGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLabel infoLabel5;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JLabel playerTurnLabel1;
    private javax.swing.JLabel playerTurnLabel2;
    private javax.swing.JSeparator separatorLine2;
    // End of variables declaration//GEN-END:variables
}