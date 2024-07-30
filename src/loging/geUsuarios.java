/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package loging;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import inventario.*;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class geUsuarios extends javax.swing.JInternalFrame {
 //variables para gestionar la conexion a dbb
    //1.Primero se crea la variable de conección
     Connection conn;
    //2.Se crea la variable para manipular los datos
     PreparedStatement ps;
    //una variable vara almacenar los resultados de las consultas
     ResultSet rs;
     ResultSetMetaData rsm;

    //funcion para establecer conexion
    void con() throws SQLException {

        conn = DriverManager.getConnection(conexionConfig.host
                + "?useUnicode=true&useJDBCCompliantTimezonesShift="
                + "true&useLegacyDatetimeCode=false&serverTimezone=UTC", conexionConfig.user, conexionConfig.pass);
    }
//constructor de formulario
    public geUsuarios() {
        initComponents();
    } 
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ocultar = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtxtId = new javax.swing.JTextField();
        jtxtNom = new javax.swing.JTextField();
        JtxtPass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("gestionar invetario");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("nombre usuario");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("contraseña");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Dni");

        buttonGroup1.add(ocultar);
        ocultar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ocultar.setText("ocultar");
        ocultar.setToolTipText("Muestra la contraseña");
        ocultar.setNextFocusableComponent(registrar);
        ocultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton1.setText("mostar");
        jRadioButton1.setToolTipText("Oculta la contraseña");
        jRadioButton1.setNextFocusableComponent(jtxtId);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        registrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        registrar.setText("Registrar");
        registrar.setToolTipText("registro de un nuevo usuario en el sistema.      ");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("eliminar");
        jButton3.setToolTipText("borra  a un usuario del sistema");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtxtId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtId.setToolTipText("Número único que identifica al usuario en el sistema.");
        jtxtId.setNextFocusableComponent(jtxtNom);
        jtxtId.setOpaque(true);
        jtxtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtIdKeyTyped(evt);
            }
        });

        jtxtNom.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtNom.setToolTipText("Nombre del usuaurio");
        jtxtNom.setNextFocusableComponent(JtxtPass);

        JtxtPass.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JtxtPass.setToolTipText("Contraseña del sitema");
        JtxtPass.setNextFocusableComponent(ocultar);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("actualizar");
        jButton2.setToolTipText(" modifica y renueva la información de un usuario existente en el sistema.");
        jButton2.setActionCommand("actuazlizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(24, 24, 24)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(ocultar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JtxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jtxtId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JtxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ocultar)
                    .addComponent(jRadioButton1))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Gestionar productos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ocultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarActionPerformed
        // TODO add your handling code here:
        JtxtPass.setEchoChar((char)42);
    }//GEN-LAST:event_ocultarActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        JtxtPass.setEchoChar((char)0);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        String id =  jtxtId.getText();
        String nom = jtxtNom.getText();
        String pass = JtxtPass.getText();
        System.out.println("id"+id+" "+nom+" "+pass);
        try {
            // se invoca la conexion
            con();
            ps = conn.prepareStatement("insert into TBL_user(id_us,nom_us,pass_uss)values(?,?,?)");
            ps.setString(1, id);
            ps.setString(2, nom);
            ps.setString(3, pass);
            int res = ps.executeUpdate();
            if(res==1){
                JOptionPane.showMessageDialog(null, "Se registró con éxito.");
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrió un error.");
            }
            nuevo();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_registrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt( jtxtId.getText());
        try {
            con();
            ps = conn.prepareStatement("delete from TBL_user where id_us =?");
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Se borró el usuario con éxito");
            }else{ JOptionPane.showMessageDialog(null,"Ocurrió un error, no se pudo borrar");}

        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtxtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtIdKeyTyped
        // TODO add your handling code here:
        int c = (int) (evt.getKeyChar());
        if(c>=48 &&c<=57){

        }else{
            evt.consume();
        }
    }//GEN-LAST:event_jtxtIdKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt( jtxtId.getText());
        String nom = jtxtNom.getText();
        String pass = JtxtPass.getText();
        try {
            // se invoca la conexion
            con();
            ps = conn.prepareStatement("update TBL_user set id_us =?,nom_us=?,pass_uss=? where id_us=?");
            ps.setInt(1, id);
            ps.setString(2, nom);
            ps.setString(3, pass);
            ps.setInt(4, id);
            int res = ps.executeUpdate();
            if(res==1){
                JOptionPane.showMessageDialog(null, "Se registró con éxito.");
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrió un error, no se pudo actualizar ");
            }
            nuevo();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "error de base de datos "+ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    void nuevo(){
         jtxtId.setText("");
         jtxtNom.setText("");
         JtxtPass.setText("");
    }
   //codigo para el boton de buscar



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JtxtPass;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextField jtxtNom;
    private javax.swing.JRadioButton ocultar;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
