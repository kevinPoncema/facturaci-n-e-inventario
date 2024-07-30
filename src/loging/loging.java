package loging;
// libterias
import inventario.conexionConfig;
import inventario.principal;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class loging extends javax.swing.JFrame {
    // constructor de la clase
    public loging() {
        initComponents();
    }
//1.Primero se crea la variable de conección
    Connection conn;
    //2.Se crea la variable para manipular los datos
    PreparedStatement ps;
    //una variable vara almacenar los resultados de las consultas
    ResultSet rs;
    //funcion para establecer conexion
    void con() throws SQLException {
       conn = DriverManager.getConnection(conexionConfig.host
                + "?useUnicode=true&useJDBCCompliantTimezonesShift="
                + "true&useLegacyDatetimeCode=false&serverTimezone=UTC", conexionConfig.user, conexionConfig.pass);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        rbOcultar = new javax.swing.JRadioButton();
        rbMostrar = new javax.swing.JRadioButton();
        btnLoging = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("usuario");

        jtxtus.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("contraseña");

        pass1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbOcultar);
        rbOcultar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbOcultar.setText("ocultar");
        rbOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOcultarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMostrar);
        rbMostrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbMostrar.setText("mostrar");
        rbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMostrarActionPerformed(evt);
            }
        });

        btnLoging.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnLoging.setText("inciar secion");
        btnLoging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbMostrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnLoging)))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtus, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(pass1))
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtxtus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOcultar)
                    .addComponent(rbMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoging)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//metodo para ocultar la contraseña
    private void rbOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOcultarActionPerformed

        pass1.setEchoChar((char) 42);

    }//GEN-LAST:event_rbOcultarActionPerformed
//metodo para mostrar la contraseña
    private void rbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMostrarActionPerformed
       pass1.setEchoChar((char) 0);
    }//GEN-LAST:event_rbMostrarActionPerformed
// metodo para inciar secion
    private void btnLogingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogingActionPerformed
        // TODO add your handling code here:
        String user = jtxtus.getText();
        String pass = pass1.getText();
        if (!user.isEmpty() && !pass.isEmpty()) {
            try {
                con();
                ps = conn.prepareStatement("select  * from TBL_user where nom_us =? and pass_uss = ?");
                ps.setString(1, user);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //  crea y habilita un nuevo formulario y cierra este 
                   principal p = new principal(user);
                   p.setVisible(true);
                   dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado: usuario o contraseña no válidos");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error de base de datos "+ex);
                //Logger.getLogger(loging.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el usuario y contraseña.");
        }
    }//GEN-LAST:event_btnLogingActionPerformed

    private void pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass1ActionPerformed

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
            java.util.logging.Logger.getLogger(loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoging;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtxtus;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JRadioButton rbMostrar;
    private javax.swing.JRadioButton rbOcultar;
    // End of variables declaration//GEN-END:variables
}
