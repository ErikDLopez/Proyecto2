
package com.gui.general;

import com.gui.checkers.principals.BoardGUI;
import com.gui.checkers.principals.MenuCheckersGUI;
import com.gui.hanoi.HanoiGUI;
import com.gui.hanoi.MenuHanoi;

/**
 * Clase del tipo frame, es la principal donde se inicializa el programa
 * 
 * @author Lopez
 * 
 */
public class PrincipalGUI extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalForm
     */
    public PrincipalGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        checkersButton = new javax.swing.JButton();
        hanoiButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        infoButton = new javax.swing.JButton();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MIND GAMES");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setPreferredSize(new java.awt.Dimension(850, 640));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkersButton.setBackground(new java.awt.Color(0, 102, 153));
        checkersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/checkersLogo.png"))); // NOI18N
        checkersButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        checkersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkersButtonActionPerformed(evt);
            }
        });
        background.add(checkersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, 150));

        hanoiButton.setBackground(new java.awt.Color(0, 102, 153));
        hanoiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/hanoiLogo.png"))); // NOI18N
        hanoiButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hanoiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hanoiButtonActionPerformed(evt);
            }
        });
        background.add(hanoiButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 150, 150));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Chandas", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TORRES DE HANOI");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 220, 40));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Chandas", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JUEGO DE DAMAS");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 220, 40));

        infoButton.setBackground(new java.awt.Color(255, 255, 255));
        infoButton.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        infoButton.setForeground(new java.awt.Color(0, 0, 0));
        infoButton.setText("Acerca de...");
        infoButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        background.add(infoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 583, 120, 30));

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/bgPrincipal.jpg"))); // NOI18N
        background.add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, -40, 850, 680));

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

    private void checkersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkersButtonActionPerformed
        MenuCheckersGUI checkers = new MenuCheckersGUI();
        checkers.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkersButtonActionPerformed

    private void hanoiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hanoiButtonActionPerformed
        MenuHanoi hanoi = new MenuHanoi();
        hanoi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hanoiButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JButton checkersButton;
    private javax.swing.JButton hanoiButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
