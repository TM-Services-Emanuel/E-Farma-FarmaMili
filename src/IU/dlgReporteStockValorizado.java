package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.ReporteF;
import Componentes.cargarComboBox;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dlgReporteStockValorizado extends javax.swing.JDialog {

    public ReporteF jasper;
    static DataSourceService dss = new DataSourceService();

    public dlgReporteStockValorizado(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        jasper = new ReporteF();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        CargarCombos();
    }

    private void CargarCombos() {
        cargarComboBox.cargar(cbLaboratorio, "SELECT * FROM laboratorio WHERE lab_indicador='S'");
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
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel1 = new javax.swing.JPanel();
        rbReporteG = new javax.swing.JRadioButton();
        rbReporteL = new javax.swing.JRadioButton();
        cbLaboratorio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de Reportes");
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
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

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 438, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbReporteG.setBackground(new java.awt.Color(255, 255, 255));
        GrupoReporte.add(rbReporteG);
        rbReporteG.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbReporteG.setSelected(true);
        rbReporteG.setText("General");
        rbReporteG.setFocusPainted(false);
        rbReporteG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReporteGActionPerformed(evt);
            }
        });
        rbReporteG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbReporteGKeyPressed(evt);
            }
        });
        jPanel1.add(rbReporteG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        rbReporteL.setBackground(new java.awt.Color(255, 255, 255));
        GrupoReporte.add(rbReporteL);
        rbReporteL.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbReporteL.setText("Por Laboratorio");
        rbReporteL.setFocusPainted(false);
        rbReporteL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReporteLActionPerformed(evt);
            }
        });
        rbReporteL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbReporteLKeyPressed(evt);
            }
        });
        jPanel1.add(rbReporteL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cbLaboratorio.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cbLaboratorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cbLaboratorio.setEnabled(false);
        cbLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbLaboratorioKeyPressed(evt);
            }
        });
        jPanel1.add(cbLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 290, 23));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 420, 65));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbReporteGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReporteGActionPerformed
        // TODO add your handling code here:
        cbLaboratorio.setEnabled(false);
    }//GEN-LAST:event_rbReporteGActionPerformed

    private void rbReporteLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReporteLActionPerformed
        // TODO add your handling code here:
        cbLaboratorio.setEnabled(true);
    }//GEN-LAST:event_rbReporteLActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        int codLab;
        if (rbReporteG.isSelected()) {
            jasper.StockValorizado("\\Reports\\articulos\\stockvalorizado.jasper");
        } else if (rbReporteL.isSelected()) {
            if (cbLaboratorio.getSelectedIndex() != 0) {
                try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM laboratorio WHERE lab_nombre='" + cbLaboratorio.getSelectedItem().toString() + "'")) {
                    rs.last();
                    codLab = rs.getInt("lab_codigo");
                    rs.close();
                    st.close();
                    cn.close();
                    jasper.StockValorizadoL("\\Reports\\articulos\\stockvalorizadoL.jasper", "codLab", codLab);
                } catch (Exception pr) {
                    Mensajes.error("Error al querer obtener ID del laboratorio");
                }
            } else {
                Mensajes.error("Seleccione un Laboratorio");
                cbLaboratorio.requestFocus();
                cbLaboratorio.setPopupVisible(true);
            }

        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGenerarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGenerarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnGenerarKeyPressed

    private void PnlNuevo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PnlNuevo2KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_PnlNuevo2KeyPressed

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

    private void jPanel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel4KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_jPanel4KeyPressed

    private void rbReporteGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbReporteGKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rbReporteGKeyPressed

    private void rbReporteLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbReporteLKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rbReporteLKeyPressed

    private void cbLaboratorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbLaboratorioKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_cbLaboratorioKeyPressed

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
            java.util.logging.Logger.getLogger(dlgReporteStockValorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteStockValorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteStockValorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteStockValorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgReporteStockValorizado dialog = new dlgReporteStockValorizado(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgReporteStockValorizado.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> cbLaboratorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton rbReporteG;
    private javax.swing.JRadioButton rbReporteL;
    // End of variables declaration//GEN-END:variables
}
