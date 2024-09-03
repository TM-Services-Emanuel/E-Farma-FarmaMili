package IU;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.ReporteF;
import Componentes.cargarComboBox;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class dlgReporteResumenCaja extends javax.swing.JDialog {

    static DataSourceService dss = new DataSourceService();

    public dlgReporteResumenCaja(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        invisible();
        rbCajaF.doClick();
        cargarComboBox.cargarCaja(cboCajaN, "SELECT * FROM caja WHERE ca_fechainicio='" + txtFDesdeR.getText() + "'");
    }

    private void invisible() {
        txtFDesdeR.setVisible(false);
    }

    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F6 ->
                btnGenerar.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            default -> {
            }
        }
    }

    public void llamarReporteHistorial(int cod) throws SQLException {
        VisorReportes vr = new VisorReportes(null, true);
        try (Connection cn = dss.getDataSource().getConnection()) {
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\caja\\ResumenCaja.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("caja", cod);
            //agregamos los parametros y la conexion a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, cn);
            //se crea el visor con el reporte
            JRViewer jRViewer = new JRViewer(jasperPrint);
            //se elimina elementos del contenedor JPanel
            VisorReportes.jpContainer.removeAll();
            //para el tamaño del reporte se agrega un BorderLayout
            VisorReportes.jpContainer.setLayout(new BorderLayout());
            VisorReportes.jpContainer.add(jRViewer, BorderLayout.CENTER);
            jRViewer.setZoomRatio((float) 1);
            jRViewer.setVisible(true);
            VisorReportes.jpContainer.repaint();
            VisorReportes.jpContainer.revalidate();
            cn.close();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }
        vr.setLocationRelativeTo(this);
        vr.setVisible(true);
    }
    
    public void llamarReporteHistorial1(int cod) throws SQLException {
        VisorReportes vr = new VisorReportes(null, true);
        try (Connection cn = dss.getDataSource().getConnection()) {
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\caja\\ResumenCajaP.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("caja", cod);
            //agregamos los parametros y la conexion a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, cn);
            //se crea el visor con el reporte
            JRViewer jRViewer = new JRViewer(jasperPrint);
            //se elimina elementos del contenedor JPanel
            VisorReportes.jpContainer.removeAll();
            //para el tamaño del reporte se agrega un BorderLayout
            VisorReportes.jpContainer.setLayout(new BorderLayout());
            VisorReportes.jpContainer.add(jRViewer, BorderLayout.CENTER);
            jRViewer.setZoomRatio((float) 1);
            jRViewer.setVisible(true);
            VisorReportes.jpContainer.repaint();
            VisorReportes.jpContainer.revalidate();
            cn.close();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }
        vr.setLocationRelativeTo(this);
        vr.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoReporte = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        PnlNuevo2 = new rojeru_san.rspanel.RSPanelImage();
        btnGenerar = new RSMaterialComponent.RSButtonIconUno();
        Separador9 = new javax.swing.JSeparator();
        LabelTitulo9 = new javax.swing.JLabel();
        txtFDesdeR = new javax.swing.JTextField();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel1 = new javax.swing.JPanel();
        rbCajaF = new javax.swing.JRadioButton();
        dcFDesde = new datechooser.beans.DateChooserCombo();
        txtFDesde = new javax.swing.JTextField();
        cboCajaN = new javax.swing.JComboBox<>();
        rbCajaF1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de Reportes");
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(17, 35, 46));
        jPanel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel4KeyPressed(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PnlNuevo2KeyPressed(evt);
            }
        });
        PnlNuevo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerar.setBackground(new java.awt.Color(0, 102, 0));
        btnGenerar.setToolTipText("GENERAR DOCUMENTO");
        btnGenerar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGenerar.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnGenerar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DASHBOARD);
        btnGenerar.setRippleColor(java.awt.Color.white);
        btnGenerar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        btnGenerar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGenerarKeyPressed(evt);
            }
        });
        PnlNuevo2.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador9.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo2.add(Separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo9.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo9.setText("GENERAR");
        PnlNuevo2.add(LabelTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        txtFDesdeR.setEditable(false);
        txtFDesdeR.setBackground(new java.awt.Color(255, 255, 204));
        txtFDesdeR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFDesdeR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtFDesdeR, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 59, 143, -1));

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
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 2, 20, 20));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 100));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GrupoReporte.add(rbCajaF);
        rbCajaF.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbCajaF.setText("Resumen valores de la fecha y caja");
        rbCajaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCajaFActionPerformed(evt);
            }
        });
        jPanel1.add(rbCajaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 23));

        dcFDesde.setEnabled(false);
        dcFDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFDesdeOnCommit(evt);
            }
        });
        jPanel1.add(dcFDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 10, 27, 23));

        txtFDesde.setEditable(false);
        txtFDesde.setBackground(new java.awt.Color(255, 255, 255));
        txtFDesde.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtFDesde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFDesde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFDesde.setEnabled(false);
        txtFDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDesdeActionPerformed(evt);
            }
        });
        txtFDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFDesdeKeyPressed(evt);
            }
        });
        jPanel1.add(txtFDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 100, 23));

        cboCajaN.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        cboCajaN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cboCajaN.setEnabled(false);
        cboCajaN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboCajaNKeyPressed(evt);
            }
        });
        jPanel1.add(cboCajaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 101, 23));

        GrupoReporte.add(rbCajaF1);
        rbCajaF1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbCajaF1.setSelected(true);
        rbCajaF1.setText("Resumen de movimiento de productos de la fecha y caja");
        rbCajaF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCajaF1ActionPerformed(evt);
            }
        });
        jPanel1.add(rbCajaF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 23));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 420, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbCajaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCajaFActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(true);
        dcFDesde.setEnabled(true);
    }//GEN-LAST:event_rbCajaFActionPerformed

    private void dcFDesdeOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFDesdeOnCommit
        // TODO add your handling code here:
        txtFDesde.setText(Fecha.fechaCFormulario(dcFDesde.getText()));
        txtFDesdeR.setText(Fecha.formatoFecha(dcFDesde.getText()));
        txtFDesdeActionPerformed(null);
    }//GEN-LAST:event_dcFDesdeOnCommit

    private void txtFDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDesdeActionPerformed
        // TODO add your handling code here:
        if (!txtFDesdeR.getText().isEmpty()) {
            cboCajaN.setEnabled(true);
            cargarComboBox.cargarCaja(cboCajaN, "SELECT * FROM caja WHERE ca_fechainicio='" + txtFDesdeR.getText() + "'");
        }

    }//GEN-LAST:event_txtFDesdeActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        try {
            if (rbCajaF.isSelected()) {
                if (txtFDesde.getText().trim().isEmpty()) {
                    Mensajes.informacion("Fije una fecha para el reporte");
                } else if (cboCajaN.getSelectedItem().toString().equals("SELEC.")) {
                    Mensajes.informacion("Indique el N° de caja para generar el reporte");
                } else {
                    System.out.println(cboCajaN.getSelectedItem().toString());
                    llamarReporteHistorial(Integer.parseInt(cboCajaN.getSelectedItem().toString()));
                }
            }else if (rbCajaF1.isSelected()) {
                if (txtFDesde.getText().trim().isEmpty()) {
                    Mensajes.informacion("Fije una fecha para el reporte");
                } else if (cboCajaN.getSelectedItem().toString().equals("SELEC.")) {
                    Mensajes.informacion("Indique el N° de caja para generar el reporte");
                } else {
                    System.out.println(cboCajaN.getSelectedItem().toString());
                    llamarReporteHistorial1(Integer.parseInt(cboCajaN.getSelectedItem().toString()));
                }
            }
        } catch (NumberFormatException | SQLException e) {
            Mensajes.error("Ocurrio un error generando el reporte");

        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGenerarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGenerarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnGenerarKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void txtFDesdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFDesdeKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtFDesdeKeyPressed

    private void cboCajaNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCajaNKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_cboCajaNKeyPressed

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_jPanel3KeyPressed

    private void PnlNuevo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PnlNuevo2KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_PnlNuevo2KeyPressed

    private void jPanel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel4KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_jPanel4KeyPressed

    private void rbCajaF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCajaF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCajaF1ActionPerformed

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
            java.util.logging.Logger.getLogger(dlgReporteResumenCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteResumenCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteResumenCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteResumenCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgReporteResumenCaja dialog = new dlgReporteResumenCaja(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgReporteResumenCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoReporte;
    private javax.swing.JLabel LabelTitulo9;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo2;
    private javax.swing.JSeparator Separador9;
    public static RSMaterialComponent.RSButtonIconUno btnGenerar;
    public static RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JComboBox<String> cboCajaN;
    public static datechooser.beans.DateChooserCombo dcFDesde;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton rbCajaF;
    private javax.swing.JRadioButton rbCajaF1;
    public static javax.swing.JTextField txtFDesde;
    public static javax.swing.JTextField txtFDesdeR;
    // End of variables declaration//GEN-END:variables
}
