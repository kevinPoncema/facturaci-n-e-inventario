/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package facturacion;

import inventario.Invetario;
import inventario.productos;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class facturar extends javax.swing.JInternalFrame {
//modelo del combox de resultados

    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    DefaultTableModel mt = new DefaultTableModel();
    private String USerName = "sin especificar";

    public facturar(String usname) {
        initComponents();
        this.USerName = usname;
        String eti[] = {"id", "cantidad", "producto", "precio unotario", "Total"};
        mt.setColumnIdentifiers(eti);
        // Agregar el TableModelListener a la tabla 
        //para detectar cuando se cambia un valor en la tabla
        mt.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int column = e.getColumn();
                    int row = e.getFirstRow();

                    // Verificar si el cambio ocurrió en una columna específica
                    if (column != TableModelEvent.ALL_COLUMNS) {
                        // Se ha actualizado el valor en la celda (row, column)
                        Object newValue = mt.getValueAt(row, column);
                        //System.out.println("Valor actualizado en la columna " + column + ": " + newValue);
                        if (column == 1 || column == 3) {
                            DecimalFormat dm = new DecimalFormat("#,##0.##");
                            // Desactivar el TableModelListener temporalmente
                            mt.removeTableModelListener(this);
                            try {

                                double canProduc = Double.parseDouble(mt.getValueAt(row, 1).toString().replace(",", ""));
                                double preUni = Double.parseDouble(mt.getValueAt(row, 3).toString().replace(",", ""));
                                double total = canProduc * preUni;
                                int id = Integer.parseInt(mt.getValueAt(row, 0).toString());
                                String[] eti = Invetario.obtenerRestantes(id);

                                int canInve = Integer.parseInt(eti[0].replace(",", ""));
                                System.out.println(canInve);
                                if (canInve < canProduc) {
                                    JOptionPane.showMessageDialog(null, "La cantidad excede a la del inventario; la fila se eliminará", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                    mt.removeRow(row);
                                } else if (preUni < 0) {
                                    JOptionPane.showMessageDialog(null, "el precio unitario es invalido devido a que es un valor negativo"
                                            + " \nla fila actual sera eliminada", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                    mt.removeRow(row);
                                } else {
                                    // Formatear y actualizar valores en el modelo
                                    mt.setValueAt(dm.format(canProduc), row, 1);
                                    mt.setValueAt(dm.format(preUni), row, 3);
                                    mt.setValueAt(dm.format(total), row, 4);
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Error numerico" + ex.getMessage(), "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                ex.printStackTrace(); // Manejar la excepción si hay un problema al convertir a double
                            } finally {
                                // Volver a agregar el TableModelListener después de realizar las actualizaciones
                                mt.addTableModelListener(this);
                            }
                        }
                    }
                }
            }
        });

        cmbResult.setModel(model);
        jtab.setModel(mt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        txtParametro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbResult = new javax.swing.JComboBox<>();
        limpiar1 = new javax.swing.JButton();
        txtProductoId = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtab = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtCan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lableCambio = new javax.swing.JLabel();
        TxtCambio1 = new javax.swing.JLabel();
        txrPrecio = new javax.swing.JFormattedTextField();
        txtTotalPagar = new javax.swing.JFormattedTextField();
        TxtCambio = new javax.swing.JFormattedTextField();
        txtCanPag = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRes = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturación");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Buscar por ");

        cmbBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "marca", "nombre", "ID " }));
        cmbBuscar.setSelectedIndex(1);
        cmbBuscar.setNextFocusableComponent(txtParametro);

        txtParametro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtParametro.setToolTipText("Palabras clave utilizadas para buscar un productos");
        txtParametro.setNextFocusableComponent(cmbResult);
        txtParametro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParametroKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Resultados");

        cmbResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbResult.setToolTipText("Lista que muestra los productos que coinciden con la búsqueda realizada ");
        cmbResult.setNextFocusableComponent(txtCan);
        cmbResult.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbResultItemStateChanged(evt);
            }
        });

        limpiar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        limpiar1.setText("Buscar");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });

        txtProductoId.setEditable(false);
        txtProductoId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Producto");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("ProductoId");

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jtab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtab);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("cantidad");

        txtCan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCan.setToolTipText("Número de unidades del producto que se desea vender");
        txtCan.setNextFocusableComponent(txrPrecio);
        txtCan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Precio");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setToolTipText("Botón que incorpora el producto a la tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setToolTipText(" borra el producto seleccionado de la tabla ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Generar");
        jButton3.setToolTipText("crea la factura y muestra el monto total a pagar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Total a pagar");

        lableCambio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lableCambio.setText("Cambio");

        TxtCambio1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TxtCambio1.setText("CantidadPagada");

        txrPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txrPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txrPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txrPrecioKeyTyped(evt);
            }
        });

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotalPagar.setEnabled(false);
        txtTotalPagar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TxtCambio.setEditable(false);
        TxtCambio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        TxtCambio.setEnabled(false);
        TxtCambio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCanPag.setEditable(false);
        txtCanPag.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtCanPag.setEnabled(false);
        txtCanPag.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Restante");

        txtRes.setEditable(false);
        txtRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtRes.setEnabled(false);
        txtRes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtRes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtResKeyTyped(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setText("Limpiar");
        jButton4.setToolTipText("crea la factura y muestra el monto total a pagar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txrPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(txtProductoId, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(59, 82, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(453, 453, 453)
                                .addComponent(TxtCambio1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCanPag, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lableCambio)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRes, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(25, 25, 25)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(limpiar1)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtProductoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txrPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lableCambio)
                        .addComponent(TxtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtCambio1)
                        .addComponent(txtCanPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            productos p = productos.buscarPorId(id);
            setDataProduct(p);
        }
    }//GEN-LAST:event_cmbResultItemStateChanged

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
                    productos p = productos.buscarPorId(id);
                    setDataProduct(p);
                    break;
            }
            if (arr.size() == 1) {
                productos p = productos.buscarPorId(arr.get(0));
                setDataProduct(p);
            }
            estatusBusqueda = 0;
            txtParametro.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Debes ingresar un parámetro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_limpiar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (vacio()) {
            factura.addProductoInTable(mt, txrPrecio.getText(), txtCan.getText(), txtProducto.getText(), txtProductoId.getText());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        factura.RemoveroductoInTable(mt, jtab.getSelectedRow());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int n = factura.generarFactura(mt, TxtCambio, txtTotalPagar, txtCanPag, this.USerName);
        //verifica si el proceso se realizo con exito
        if (n != -1) {
            limpiar();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtParametroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParametroKeyTyped
        char enteredChar = evt.getKeyChar();
        int indice = cmbBuscar.getSelectedIndex();
        if (!(Character.isDigit(enteredChar)) && indice == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtParametroKeyTyped

    private void txtCanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanKeyTyped
        // TODO add your handling code here:
        char enteredChar = evt.getKeyChar();
        if (!(Character.isDigit(enteredChar))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCanKeyTyped

    private void txrPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txrPrecioKeyTyped
        char enteredChar = evt.getKeyChar();
        if (!(Character.isDigit(enteredChar) || enteredChar == '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txrPrecioKeyTyped

    private void txtResKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    boolean vacio() {
        if (txtProducto.getText().isEmpty() || txrPrecio.getText().isEmpty() || txrPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes llenar los campos del producto");
            return false;

        }
        return true;
    }

    void setDataProduct(productos p) {
        txtProductoId.setText(Integer.toString(p.id));
        txtProducto.setText(p.nombre);
        txrPrecio.setText(Double.toString(p.precio));
        String[] etiquetas = Invetario.obtenerRestantes(p.id);
        txtRes.setText(etiquetas[0]);
    }

    void limpiar() {
        txtCan.setText("");
        txtParametro.setText("");
        txtProducto.setText("");
        txtProductoId.setText("");
        txrPrecio.setText("");
        mt.setRowCount(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField TxtCambio;
    private javax.swing.JLabel TxtCambio1;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbResult;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtab;
    private javax.swing.JLabel lableCambio;
    private javax.swing.JButton limpiar1;
    private javax.swing.JFormattedTextField txrPrecio;
    private javax.swing.JTextField txtCan;
    private javax.swing.JFormattedTextField txtCanPag;
    private javax.swing.JTextField txtParametro;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProductoId;
    private javax.swing.JFormattedTextField txtRes;
    private javax.swing.JFormattedTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
