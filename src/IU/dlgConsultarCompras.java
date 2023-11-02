package IU;

import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimalVenta;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlCompra;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class dlgConsultarCompras extends javax.swing.JDialog {
    
    private static Point point;

    public dlgConsultarCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        CabecerasTablas.consCompras(tbCompra);
        CabecerasTablas.consDetalleCompras(tbDetalleCompra);
        controlCompra.listarCompras(tbCompra);
        Renders();

    }
    
    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_DELETE ->
                btnAnular.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            default -> {
            }
        }
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestión de compras realizadas");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestión de compras realizadas");
        }
    }

    public static void Renders() {
        dlgConsultarCompras.tbCompra.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimalVenta());
    }

    public static void RendersD() {
        dlgConsultarCompras.tbDetalleCompra.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1());
        dlgConsultarCompras.tbDetalleCompra.getColumnModel().getColumn(6).setCellRenderer(new RenderDecimalVenta());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panelCabecera = new javax.swing.JPanel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel5 = new javax.swing.JPanel();
        PnlActualizar = new rojeru_san.rspanel.RSPanelImage();
        btnActualizar = new RSMaterialComponent.RSButtonIconUno();
        Separador7 = new javax.swing.JSeparator();
        LabelTitulo7 = new javax.swing.JLabel();
        PnlEliminarG = new rojeru_san.rspanel.RSPanelImage();
        btnAnular = new RSMaterialComponent.RSButtonIconUno();
        Separador8 = new javax.swing.JSeparator();
        LabelTitulo8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCabecera.setBackground(new java.awt.Color(17, 35, 46));
        panelCabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCabeceraMouseDragged(evt);
            }
        });
        panelCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCabeceraMousePressed(evt);
            }
        });
        panelCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setToolTipText("F12");
        btnSalir.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setRippleColor(java.awt.Color.white);
        btnSalir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        panelCabecera.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 3, 20, 20));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlActualizar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(0, 153, 255));
        btnActualizar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnActualizar.setForegroundHover(new java.awt.Color(0, 153, 255));
        btnActualizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnActualizar.setRippleColor(java.awt.Color.white);
        btnActualizar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        btnActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarKeyPressed(evt);
            }
        });
        PnlActualizar.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador7.setForeground(new java.awt.Color(204, 204, 204));
        PnlActualizar.add(Separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo7.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo7.setText("ACTUALIZAR");
        PnlActualizar.add(LabelTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel5.add(PnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlEliminarG.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlEliminarG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAnular.setBackground(new java.awt.Color(255, 0, 0));
        btnAnular.setToolTipText("DELETE");
        btnAnular.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnAnular.setForegroundHover(new java.awt.Color(255, 0, 0));
        btnAnular.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnAnular.setRippleColor(java.awt.Color.white);
        btnAnular.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        btnAnular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAnularKeyPressed(evt);
            }
        });
        PnlEliminarG.add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador8.setForeground(new java.awt.Color(204, 204, 204));
        PnlEliminarG.add(Separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo8.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo8.setText("ELIMINAR");
        PnlEliminarG.add(LabelTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel5.add(PnlEliminarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        panelCabecera.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.add(panelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 883, 102));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbCompra.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        tbCompra.setGridColor(new java.awt.Color(204, 204, 204));
        tbCompra.setRowHeight(20);
        tbCompra.setShowGrid(true);
        tbCompra.setShowVerticalLines(false);
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
        tbCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbCompraKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCompra);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 104, 883, 276));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Factura de Compra:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 18, -1, -1));

        txtCodCompra.setEditable(false);
        txtCodCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtCodCompra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodCompraKeyPressed(evt);
            }
        });
        jPanel1.add(txtCodCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, 121, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Fecha y Hora:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 18, -1, -1));

        txtFechaCompra.setEditable(false);
        txtFechaCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaCompra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFechaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFechaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaCompraKeyPressed(evt);
            }
        });
        jPanel1.add(txtFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 15, 146, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Proveedor :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 47, -1, -1));

        txtProveedor.setEditable(false);
        txtProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProveedorKeyPressed(evt);
            }
        });
        jPanel1.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 44, 357, 23));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbDetalleCompra.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        tbDetalleCompra.setEnabled(false);
        tbDetalleCompra.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalleCompra.setRowHeight(20);
        tbDetalleCompra.setShowGrid(true);
        tbDetalleCompra.setShowVerticalLines(false);
        tbDetalleCompra.getTableHeader().setResizingAllowed(false);
        tbDetalleCompra.getTableHeader().setReorderingAllowed(false);
        tbDetalleCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleCompraKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbDetalleCompra);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 70, 871, 239));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 385, 873, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tbCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCompraMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablaConsDetalleCompras(tbDetalleCompra);
            controlCompra.listarDetalleCompras(tbDetalleCompra);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.toString());
        }
    }//GEN-LAST:event_tbCompraMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablaConsCompras(tbCompra);
        CabecerasTablas.limpiarTablaConsDetalleCompras(tbDetalleCompra);
        controlCompra.listarCompras(tbCompra);
        Renders();
        txtCodCompra.setText("");
        txtFechaCompra.setText("");
        txtProveedor.setText("");
        Notif.NotifySuccess("Notificación del sistema", "Lista actualizada!");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarCompras.tbCompra.getSelectedRow() < 0) {
            //Mensajes.error("No es posible procesar la operación.\nSeleccione la venta que desea anular.");
            Notif.NotifyFail("Notificación del sistema", "No es posible procesar la operación.\r\nSeleccione la Compra que desea anular.");
        } else {
            int x = dlgConsultarCompras.tbCompra.getSelectedRow();
            String estado = dlgConsultarCompras.tbCompra.getValueAt(x, 10).toString();
            if (estado.equals("ANULADO")) {
                //Mensajes.informacion("Esta compra ya fue anulada");
                Notif.NotifyInformation("Notificación del sistema", "No es posible procesar la operación.\r\nEsta Compra ya fue anulada");
            } else {
                try {
                    String msg;
                    int rpta = Mensajes.confirmar("Seguro que desea Anular esta Compra?");
                    if (rpta == 0) {
                        msg = controlCompra.anularCompra();
                        if (msg == null) {
                            CabecerasTablas.limpiarTablaConsCompras(tbCompra);
                            CabecerasTablas.limpiarTablaConsDetalleCompras(tbDetalleCompra);
                            controlCompra.listarCompras(tbCompra);
                        }
                    }
                } catch (Exception e) {
                    Mensajes.informacion("Error anulando compra: "+e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAnularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAnularKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnAnularKeyPressed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void tbCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCompraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbCompraKeyPressed

    private void txtCodCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCompraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCodCompraKeyPressed

    private void txtProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtProveedorKeyPressed

    private void txtFechaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCompraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtFechaCompraKeyPressed

    private void tbDetalleCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleCompraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleCompraKeyPressed

    private void panelCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMousePressed
        // TODO add your handling code here:
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_panelCabeceraMousePressed

    private void panelCabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMouseDragged
        // TODO add your handling code here:
        int CurrentX = this.getLocation().x;
        int CurrentY = this.getLocation().y;

        int MoveX = (CurrentX + evt.getX()) - (CurrentX + point.x);
        int MoveY = (CurrentY + evt.getY()) - (CurrentY + point.y);

        int x = CurrentX + MoveX;
        int y = CurrentY + MoveY;

        this.setLocation(x, y);
    }//GEN-LAST:event_panelCabeceraMouseDragged

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
    private javax.swing.JLabel LabelTitulo7;
    private javax.swing.JLabel LabelTitulo8;
    private rojeru_san.rspanel.RSPanelImage PnlActualizar;
    private rojeru_san.rspanel.RSPanelImage PnlEliminarG;
    private javax.swing.JSeparator Separador7;
    private javax.swing.JSeparator Separador8;
    private RSMaterialComponent.RSButtonIconUno btnActualizar;
    private RSMaterialComponent.RSButtonIconUno btnAnular;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCabecera;
    public static final javax.swing.JTable tbCompra = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static final javax.swing.JTable tbDetalleCompra = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static javax.swing.JTextField txtCodCompra;
    public static javax.swing.JTextField txtFechaCompra;
    public static javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
}
