/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package inventario;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class gesProductos extends javax.swing.JInternalFrame {

    //modelo del combox de resultados
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

    //constructor de formulario
    public gesProductos() {
        initComponents();
        cmbResult.setModel(model);//incializar modelo
    }
    int estatusBusqueda = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtParametro = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        limpiar1 = new javax.swing.JButton();
        cmbResult = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JFormattedTextField();
        txtCosto = new javax.swing.JFormattedTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar productos");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Buscar por ");

        txtParametro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtParametro.setToolTipText("Parametro");
        txtParametro.setNextFocusableComponent(cmbResult);
        txtParametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParametroKeyTyped(evt);
            }
        });

        cmbBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "marca", "nombre", "ID " }));
        cmbBuscar.setSelectedIndex(1);
        cmbBuscar.setNextFocusableComponent(txtParametro);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Resultados");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("ID");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setToolTipText(" Nombre del Producto");
        txtNombre.setNextFocusableComponent(txtCosto);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("nombre ");

        txtMarca.setToolTipText(" compañía que  produce el producto.");
        txtMarca.setNextFocusableComponent(cmbBuscar);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Precio ");

        txtID.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("costo");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Marca ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setToolTipText("crea un nuevo producto ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Borrar");
        jButton2.setToolTipText("borra un producto seleccionado de la base de datos ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Editar");
        jButton3.setToolTipText("modificar y actualizar la información del producto seleccionado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        limpiar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        limpiar.setText("Limpiar");
        limpiar.setToolTipText("limpia los campos del sitema");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        limpiar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        limpiar1.setText("Buscar");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });

        cmbResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cmbResult.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbResult.setNextFocusableComponent(txtNombre);
        cmbResult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbResultItemStateChanged(evt);
            }
        });

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtCosto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txtCosto))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(35, 35, 35)
                                .addComponent(jButton2)
                                .addGap(40, 40, 40)
                                .addComponent(jButton3)))
                        .addGap(40, 40, 40)
                        .addComponent(limpiar)
                        .addGap(26, 26, 26)
                        .addComponent(limpiar1)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(limpiar)
                    .addComponent(limpiar1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//boton de limpiar
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //muestra un mensaje personalizado 
        Object[] options = {"Continuar", "Cerrar"};
        int res = JOptionPane.showOptionDialog(null,
                "¿Estás seguro que deseas eliminar este producto?",
                "Confirmación",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (!txtID.getText().isEmpty() && res == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(txtID.getText());
                productos.borrarProducto(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El ID ingresado no es válido");
            }
        } else if (!txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes buscar y seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!txtID.getText().isEmpty() && noVacio()) {
            try {
                int id = Integer.parseInt(txtID.getText());
                String nom = txtNombre.getText();
                String mar = txtMarca.getText();
                double pre = Double.parseDouble(txtPrecio.getText().replace(",", ""));
                double cos = Double.parseDouble(txtCosto.getText().replace(",", ""));
                productos.actualizar(id, nom, mar, pre, cos, this);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El ID ingresado no es válido");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes buscar y seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    //codigo para el boton de buscar
    ArrayList<Integer> arr = new ArrayList();
    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        estatusBusqueda = 1;
        int indice = cmbBuscar.getSelectedIndex();
        switch (indice) {
            case 0:
                arr = productos.buscarPorMarca(txtParametro.getText(), model, this);
                break;
            case 1:
                arr = productos.buscarPorNombre(txtParametro.getText(), model, this);
                break;
            case 2:
                int id = Integer.parseInt(txtParametro.getText());
                productos.buscarPorId(id, this, txtID, txtNombre, txtMarca, txtPrecio, txtCosto);
                break;
        }
        if (arr.size() == 1) {
            productos p = productos.buscarPorId(arr.get(0));
            productos.buscarPorId(arr.get(0), this, txtID, txtNombre, txtMarca, txtPrecio, txtCosto);
        }
        estatusBusqueda = 0;
        txtParametro.setText("");
    }//GEN-LAST:event_limpiar1ActionPerformed
//codigo del boton de agregar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (noVacio()) {
            String nom = txtNombre.getText();
            String mar = txtMarca.getText();
            // Verificar si el campo de precio y costo  están vacíos y asignar 0 si es así
            double pre = (txtPrecio.getText().isEmpty()) ? 0 : Double.parseDouble(txtPrecio.getText().replace(",", ""));
            double cos = (txtCosto.getText().isEmpty()) ? 0 : Double.parseDouble(txtCosto.getText().replace(",", ""));
            productos.agregarProducto(nom, mar, pre, cos, this);
        }


    }//GEN-LAST:event_jButton1ActionPerformed
//metodo que actualiza los campos segun el selector de resultados
    private void cmbResultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbResultItemStateChanged
        int i = cmbResult.getSelectedIndex();
        if (estatusBusqueda != 1 && i != 0) {
            int id = arr.get(i - 1);
            productos.buscarPorId(id, this, txtID, txtNombre, txtMarca, txtPrecio, txtCosto);
        }

    }//GEN-LAST:event_cmbResultItemStateChanged

    private void txtParametroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParametroKeyTyped
        // TODO add your handling code here:
        char enteredChar = evt.getKeyChar();
        int indice = cmbBuscar.getSelectedIndex();
        if (!(Character.isDigit(enteredChar)) && indice == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtParametroKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        // TODO add your handling code here:
        char enteredChar = evt.getKeyChar();
        if (!(Character.isDigit(enteredChar) || enteredChar == '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char enteredChar = evt.getKeyChar();
        if (!(Character.isDigit(enteredChar) || enteredChar == '.')) {
            evt.consume();
        }


    }//GEN-LAST:event_txtPrecioKeyTyped

    //funcion que limpia todos los campos
    public void limpiar() {
        txtID.setText("");
        txtMarca.setText("");
        txtNombre.setText("");
        txtParametro.setText("");
        txtPrecio.setText("");
        txtCosto.setText("");
    }

    //metodo que verifica que los campos obligatorios no esten vacios
    boolean noVacio() {
        if (txtMarca.getText().isEmpty() || txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes llenar el nombre y la marca.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbResult;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton limpiar1;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtParametro;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
