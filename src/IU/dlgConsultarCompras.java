package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal;
import Componentes.RenderDecimal1;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlCompra;

public class dlgConsultarCompras extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public dlgConsultarCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.consCompras(tbCompra);
        cabe.consDetalleCompras(tbDetalleCompra);
        controlCompra.listarCompras(tbCompra);
        Renders();
        
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestión de compras realizadas");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestión de compras realizadas");
        }
    }
    
    public static void Renders() {
        dlgConsultarCompras.tbCompra.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimal());
    }
    public static void RendersD() {
        dlgConsultarCompras.tbDetalleCompra.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1());
        dlgConsultarCompras.tbDetalleCompra.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimal());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCompra = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalleCompra = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jLabel6 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAnular = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        tbCompra.setBackground(new java.awt.Color(255, 255, 204));
        tbCompra.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        tbCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCompra.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbCompra.getTableHeader().setResizingAllowed(false);
        tbCompra.getTableHeader().setReorderingAllowed(false);
        tbCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCompraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCompraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCompra);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Factura de Compra:");

        txtCodCompra.setEditable(false);
        txtCodCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtCodCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Fecha y Hora:");

        txtFechaCompra.setEditable(false);
        txtFechaCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtFechaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Proveedor :");

        txtProveedor.setEditable(false);
        txtProveedor.setBackground(new java.awt.Color(255, 255, 204));

        tbDetalleCompra.setBackground(new java.awt.Color(255, 255, 204));
        tbDetalleCompra.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        tbDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleCompra.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbDetalleCompra.setEnabled(false);
        tbDetalleCompra.getTableHeader().setResizingAllowed(false);
        tbDetalleCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDetalleCompra);

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        jLabel6.setText("TOTAL COMPRA");

        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalCompra.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtProveedor))
                        .addGap(392, 392, 392))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnAnular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/receipt_106581 - copia (2) - copia.png"))); // NOI18N
        btnAnular.setText("Anular Compra");
        btnAnular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnular);

        btnActualizar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/receipt_106581 - copia - copia.png"))); // NOI18N
        btnActualizar.setText("Actualizar Listado");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar);

        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 831, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCompraMouseClicked
        // TODO add your handling code here:
        /*try {
            CabecerasTablas.limpiarTablas(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }*/
    }//GEN-LAST:event_tbCompraMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarCompras.tbCompra.getSelectedRow() < 0) {
            Mensajes.error("Seleccione una fila de la tabla");
        } else {
            int x = dlgConsultarCompras.tbCompra.getSelectedRow();
            String estado = dlgConsultarCompras.tbCompra.getValueAt(x, 10).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.informacion("Esta compra ya fue anulada");
            } else {
                try {
                    String msg;
                    int rpta = Mensajes.confirmar("Seguro que desea Anular esta Compra?");
                    if (rpta == 0) {
                        msg = controlCompra.anularCompra();
                        if (msg == null) {
                            CabecerasTablas.limpiarTablas(tbCompra);
                            CabecerasTablas.limpiarTablas(tbDetalleCompra);
                            cabe.consCompras(tbCompra);
                            cabe.consDetalleCompras(tbDetalleCompra);
                            controlCompra.listarCompras(tbCompra);
                        }
                    }
                } catch (Exception e) {
                    Mensajes.informacion("Seleccione la fila a eliminar");
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        cabe.consCompras(tbCompra);
        cabe.consDetalleCompras(tbDetalleCompra);
        controlCompra.listarCompras(tbCompra);
        Renders();
        txtCodCompra.setText("");
        txtFechaCompra.setText("");
        txtProveedor.setText("");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tbCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCompraMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablas(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }
    }//GEN-LAST:event_tbCompraMousePressed

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
            java.util.logging.Logger.getLogger(dlgConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgConsultarCompras dialog = new dlgConsultarCompras(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tbCompra;
    public static javax.swing.JTable tbDetalleCompra;
    public static javax.swing.JTextField txtCodCompra;
    public static javax.swing.JTextField txtFechaCompra;
    public static javax.swing.JTextField txtProveedor;
    public static javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
