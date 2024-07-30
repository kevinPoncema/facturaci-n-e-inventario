/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package inventario;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class gestInventario extends javax.swing.JInternalFrame {

    //modelo del combox de resultados
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
//constructor de formulario

    public gestInventario() {
        initComponents();
        cmbResult.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        txtParametro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbResult = new javax.swing.JComboBox<>();
        limpiar1 = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        txtProductoId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        rbRet = new javax.swing.JRadioButton();
        rbAdd = new javax.swing.JRadioButton();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCan = new javax.swing.JTextField();
        limpiar2 = new javax.swing.JButton();
        limpiar3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtCosto = new javax.swing.JFormattedTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar inventario");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Buscar por ");

        cmbBuscar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "marca", "nombre", "ID " }));
        cmbBuscar.setSelectedIndex(1);

        txtParametro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtParametro.setToolTipText("Palabras clave utilizadas para buscar  productos");
        txtParametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParametroKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Resultados");

        cmbResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cmbResult.setToolTipText("Lista que muestra los productos que coinciden con la búsqueda realizada a través de los parámetros especificados.");
        cmbResult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbResultItemStateChanged(evt);
            }
        });

        limpiar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        limpiar1.setText("Buscar");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });

        txtProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtProducto.setToolTipText(" Nombre del Producto");

        txtProductoId.setEditable(false);
        txtProductoId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Producto");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("ProductoId");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("costo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("cantidad");

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCantidad.setToolTipText("Número de unidades que se van a añadir o retirar del inventario.");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        buttonGroup1.add(rbRet);
        rbRet.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbRet.setText("retirar");

        buttonGroup1.add(rbAdd);
        rbAdd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rbAdd.setText("agregar");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setToolTipText("El coste monetario acumulado o total asociado con ese producto en particular.");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Cantidad restante");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Costo total");

        txtCan.setEditable(false);
        txtCan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCan.setToolTipText("Total de unidades de un producto disponible.");

        limpiar2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        limpiar2.setText("Guardar");
        limpiar2.setToolTipText("Agrega o elimina la cantidad especificada según la opción seleccionada.");
        limpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar2ActionPerformed(evt);
            }
        });

        limpiar3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        limpiar3.setText("Revisar datos");
        limpiar3.setToolTipText("Muestra la información del inventario correspondiente al producto seleccionado.");
        limpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(69, 69, 69)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProductoId)
                                            .addComponent(txtCantidad)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addComponent(rbRet)
                                        .addGap(166, 166, 166)))
                                .addGap(90, 90, 90))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33)
                        .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(limpiar2)
                                .addGap(51, 51, 51)
                                .addComponent(limpiar3)
                                .addGap(50, 50, 50)
                                .addComponent(jButton1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(limpiar1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCosto))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txtProductoId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAdd)
                            .addComponent(rbRet))
                        .addGap(45, 45, 45)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar1)
                    .addComponent(jButton1)
                    .addComponent(limpiar3)
                    .addComponent(limpiar2))
                .addContainerGap())
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

        getAccessibleContext().setAccessibleName("Gestionar productos");

        pack();
    }// </editor-fold>//GEN-END:initComponents
int estatusBusqueda = 0;
    ArrayList<Integer> arr = new ArrayList();
    private void cmbResultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbResultItemStateChanged
        int i = cmbResult.getSelectedIndex();
        if (estatusBusqueda != 1 && i != 0) {
            int id = arr.get(i - 1);
            productos.buscarPorId(id, this, txtProductoId, txtProducto);
        }
    }//GEN-LAST:event_cmbResultItemStateChanged
//boton de buscar
    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        if (!txtParametro.getText().isEmpty()) {
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
                    productos.buscarPorId(id, this, txtProductoId, txtProducto);
                    break;
            }
            if (arr.size() == 1) {
                productos.buscarPorId(arr.get(0), this, txtProductoId, txtProducto);
            }
            estatusBusqueda = 0;
            txtParametro.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Debes ingresar un parámetro");
        }
    }//GEN-LAST:event_limpiar1ActionPerformed

    //actualiza el inventario segun las opcines selecionadas
    private void limpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar2ActionPerformed
        String cantidadText = txtCantidad.getText();
        String productoIdText = txtProductoId.getText();
// Verificar si alguno de los campos está vacío
        if (cantidadText.isEmpty() || productoIdText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un producto e ingresar la cantidad", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int id = Integer.parseInt(productoIdText);
            int cantidad = Integer.parseInt(cantidadText);

            if (rbAdd.isSelected()) {
                if (txtCosto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar la cantidad", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    double costo = Double.parseDouble(txtCosto.getText().replace(",", ""));
                    double costoTotal = cantidad * costo;
                    Invetario.ingresoInvetario(id, costoTotal, cantidad, this,costo);
                }
            } else if (rbRet.isSelected()) {
                Invetario.egresoInvetario(id, cantidad);
            } else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar la opción de ingresar o retirar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_limpiar2ActionPerformed
//obtiene la cantidad de productos  restantes
    private void limpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar3ActionPerformed
        if (!txtProductoId.getText().isEmpty()) {
            int id = Integer.parseInt(txtProductoId.getText());
            String[] etiquetas = Invetario.obtenerRestantes(id);
            txtCan.setText(etiquetas[0]);
            txtTotal.setText(etiquetas[1]);
        } else {
            JOptionPane.showMessageDialog(this, "Debes buscar y selecionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_limpiar3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char enteredChar = evt.getKeyChar();
        if (!(Character.isDigit(enteredChar) || enteredChar == '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtParametroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParametroKeyTyped
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
//funcion que limpian todo los campos

    void limpiar() {
        txtCan.setText("");
        txtCantidad.setText("");
        txtCosto.setText("");
        txtParametro.setText("");
        //txtProducto.setText("");
        //txtProductoId.setText("");
        txtTotal.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbResult;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar1;
    private javax.swing.JButton limpiar2;
    private javax.swing.JButton limpiar3;
    private javax.swing.JRadioButton rbAdd;
    private javax.swing.JRadioButton rbRet;
    private javax.swing.JTextField txtCan;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextField txtParametro;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProductoId;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
