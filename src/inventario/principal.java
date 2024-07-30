/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package inventario;

import com.itextpdf.text.DocumentException;
import facturacion.Reporte;
import facturacion.actuaFacturas;
import facturacion.facturar;
import facturacion.repGeneral;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loging.geUsuarios;

public class principal extends javax.swing.JFrame {

    private String userName = "sin especificar";

    public principal(String usname) {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        desktopPane.setMaximumSize(screenSize);
        this.userName = usname;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        openMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem2 = new javax.swing.JMenuItem();
        cutMenuItem3 = new javax.swing.JMenuItem();
        cutMenuItem4 = new javax.swing.JMenuItem();
        cutMenuItem5 = new javax.swing.JMenuItem();
        editMenu1 = new javax.swing.JMenu();
        cutMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        desktopPane.setMaximumSize(new java.awt.Dimension(2147483647, 214748367));

        fileMenu.setMnemonic('f');
        fileMenu.setText("invetario");
        fileMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openMenuItem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("gestionar productos");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        openMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        openMenuItem1.setMnemonic('o');
        openMenuItem1.setText("gestionar inventario");
        openMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem1);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("facturar");
        editMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        cutMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cutMenuItem2.setMnemonic('t');
        cutMenuItem2.setText("facturar");
        cutMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem2ActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem2);

        cutMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cutMenuItem3.setMnemonic('t');
        cutMenuItem3.setText("Reporte general");
        cutMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem3ActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem3);

        cutMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cutMenuItem4.setMnemonic('t');
        cutMenuItem4.setText("Reporte por producto");
        cutMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem4ActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem4);

        cutMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cutMenuItem5.setMnemonic('t');
        cutMenuItem5.setText("Anular Facturas");
        cutMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem5ActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem5);

        menuBar.add(editMenu);

        editMenu1.setMnemonic('e');
        editMenu1.setText("usuarios");
        editMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        cutMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cutMenuItem1.setMnemonic('t');
        cutMenuItem1.setText("gestionar Usuarios");
        cutMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem1ActionPerformed(evt);
            }
        });
        editMenu1.add(cutMenuItem1);

        menuBar.add(editMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        //coloca el contenido del crud inventario
        gesProductos gp = new gesProductos();
        desktopPane.add(gp);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void openMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItem1ActionPerformed
        gestInventario gi = new gestInventario();
        desktopPane.add(gi);
    }//GEN-LAST:event_openMenuItem1ActionPerformed

    private void cutMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem1ActionPerformed
        geUsuarios gus = new geUsuarios();
        desktopPane.add(gus);
    }//GEN-LAST:event_cutMenuItem1ActionPerformed

    private void cutMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem2ActionPerformed
        facturar fac = new facturar(this.userName);
        desktopPane.add(fac);
    }//GEN-LAST:event_cutMenuItem2ActionPerformed

    private void cutMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem3ActionPerformed
        repGeneral rpg = new repGeneral();
        desktopPane.add(rpg);
    }//GEN-LAST:event_cutMenuItem3ActionPerformed

    private void cutMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem4ActionPerformed
        try {
            Reporte.reporteProProducto();
        } catch (DocumentException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cutMenuItem4ActionPerformed

    private void cutMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem5ActionPerformed
        // TODO add your handling code here:
        actuaFacturas af = new actuaFacturas();
        desktopPane.add(af);
    }//GEN-LAST:event_cutMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal("sin especificar").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cutMenuItem1;
    private javax.swing.JMenuItem cutMenuItem2;
    private javax.swing.JMenuItem cutMenuItem3;
    private javax.swing.JMenuItem cutMenuItem4;
    private javax.swing.JMenuItem cutMenuItem5;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu editMenu1;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem openMenuItem1;
    // End of variables declaration//GEN-END:variables

}
