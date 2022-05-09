package com.gui.hanoi;

import com.functionalities.utilities.files.User;
import com.functionalities.utilities.files.Serialization;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author erik-lopez
 * 
 */
public class CreateUser extends javax.swing.JFrame {
    private int ID;
    /**
     * Creates new form CreatePlayer
     */
    public CreateUser() {
        initComponents();
        ID = 0;
        this.setLocationRelativeTo(null);
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
        separatorLine2 = new javax.swing.JSeparator();
        iconLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        separatorLine3 = new javax.swing.JSeparator();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CREACION DE JUGADORES");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        background.setBackground(new java.awt.Color(11, 81, 11));
        background.setMinimumSize(new java.awt.Dimension(560, 360));
        background.setPreferredSize(new java.awt.Dimension(530, 330));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        separatorLine2.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine2.setForeground(new java.awt.Color(255, 255, 255));
        background.add(separatorLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 250, 20));

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images/utilities/userIcon.png"))); // NOI18N
        background.add(iconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, 180));

        nameField.setBackground(new java.awt.Color(0, 66, 148));
        nameField.setFont(new java.awt.Font("Chandas", 1, 12)); // NOI18N
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameField.setText("Ingrese el nombre");
        nameField.setBorder(null);
        background.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 250, 40));

        saveButton.setBackground(new java.awt.Color(2, 32, 122));
        saveButton.setFont(new java.awt.Font("Chandas", 3, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Guardar");
        saveButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.blue, java.awt.Color.blue));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        background.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 140, 50));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoLabel.setFont(new java.awt.Font("Chandas", 3, 18)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(0, 204, 204));
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("NUEVO USUARIO");
        infoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 200, 30));

        separatorLine3.setBackground(new java.awt.Color(255, 255, 255));
        separatorLine3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(separatorLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 200, 20));

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 440, -1));

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/images_Hanoi/hanoiBG.jpg"))); // NOI18N
        bgLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        background.add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveUsers();
    }//GEN-LAST:event_saveButtonActionPerformed
    
    private void saveUsers() {
        ArrayList<User> usersHanoi = MenuHanoi.getUsersHanoi();
        User user = new User(nameField.getText(),"Hanoi Player");
        user.assignID(usersHanoi);
        boolean sameName = user.sameName(usersHanoi, user.getName());
        
        if (sameName == true){
            JOptionPane.showMessageDialog(null,"Este jugador ya existe");
            nameField.setText("Ingrese el nombre");
        }
        if (sameName == false){
            usersHanoi.add(user);
            Serialization serialize = new Serialization();
            serialize.serializeUsers(usersHanoi,"Hanoi_users.dat");
            JOptionPane.showMessageDialog(null,"Se ha creado el jugador con exito");
            nameField.setText("Ingrese el nombre");
        }
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (ID == 0){
            MenuHanoi menuHanoi = new MenuHanoi();
            menuHanoi.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton saveButton;
    private javax.swing.JSeparator separatorLine2;
    private javax.swing.JSeparator separatorLine3;
    // End of variables declaration//GEN-END:variables
}