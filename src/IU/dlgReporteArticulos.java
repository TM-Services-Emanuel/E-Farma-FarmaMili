package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.ReporteF;
import Componentes.cargarComboBox;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dlgReporteArticulos extends javax.swing.JDialog {

    public ReporteF jasper;
    static DataSourceService dss = new DataSourceService();

    public dlgReporteArticulos(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        jasper = new ReporteF();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        CargarCombos();
    }

    private void CargarCombos() {
        cargarComboBox.cargar(cbLaboratorioInventario, "SELECT * FROM laboratorio WHERE lab_indicador='S'");
        cargarComboBox.cargar(cbLaboratorioLista, "SELECT * FROM laboratorio WHERE lab_indicador='S'");
        //cargarComboBox.cargar(cbFamilia, "SELECT * FROM familia WHERE fam_indicador='S'");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoReporte = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbInventarioG = new javax.swing.JRadioButton();
        rbInventarioL = new javax.swing.JRadioButton();
        cbLaboratorioInventario = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rbListadoG = new javax.swing.JRadioButton();
        rbListadoL = new javax.swing.JRadioButton();
        cbLaboratorioLista = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoGenerar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de reportes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GrupoReporte.add(rbInventarioG);
        rbInventarioG.setText("Inventario General");
        rbInventarioG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInventarioGActionPerformed(evt);
            }
        });

        GrupoReporte.add(rbInventarioL);
        rbInventarioL.setText("Inventario por  Laboratorio");
        rbInventarioL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInventarioLActionPerformed(evt);
            }
        });

        cbLaboratorioInventario.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbInventarioG)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbInventarioL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbLaboratorioInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbInventarioG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbInventarioL)
                    .addComponent(cbLaboratorioInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(1, 6));

        btnGenerar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte x 40.png"))); // NOI18N
        btnGenerar.setText("Generar Reporte - F6");
        btnGenerar.setToolTipText("Registrar Nuevo Artículo");
        btnGenerar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerar);

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back40.png"))); // NOI18N
        btnSalir.setText("Salir-Alt+F4");
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setPreferredSize(new java.awt.Dimension(53, 47));
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GrupoReporte.add(rbListadoG);
        rbListadoG.setSelected(true);
        rbListadoG.setText("Listado de Artículos General");
        rbListadoG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbListadoGActionPerformed(evt);
            }
        });

        GrupoReporte.add(rbListadoL);
        rbListadoL.setText("Listado de Artículos por  Laboratorio");
        rbListadoL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbListadoLActionPerformed(evt);
            }
        });

        cbLaboratorioLista.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbListadoG)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbListadoL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbLaboratorioLista, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbListadoG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbListadoL)
                    .addComponent(cbLaboratorioLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevoGenerar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemNuevoGenerar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevoGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itemNuevoGenerar.setText("Generar Reporte          ");
        itemNuevoGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoGenerarActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevoGenerar);
        jMenu1.add(jSeparator3);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoGenerarActionPerformed
        // TODO add your handling code here:
        btnGenerar.doClick();
    }//GEN-LAST:event_itemNuevoGenerarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        int codLab = 0;
        if (rbListadoG.isSelected()) {
            jasper.ListadoArticuloG("\\Reports\\articulos\\Listado_ArticulosGral.jasper");
        } else if (rbListadoL.isSelected()) {
            if (cbLaboratorioLista.getSelectedIndex() != 0) {
                try {
                    try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM laboratorio WHERE lab_nombre='" + cbLaboratorioLista.getSelectedItem().toString() + "'")) {
                        rs.last();
                        codLab = rs.getInt("lab_codigo");
                        rs.close();
                        st.close();
                        cn.close();
                    } catch (SQLException ex) {
                        Mensajes.error("Error al querer obtener ID del laboratorio");
                    }
                    jasper.ListadoArticuloL("\\Reports\\articulos\\Listado_ArticulosLab.jasper", "codlab", codLab);
                } catch (Exception pr) {
                    Mensajes.informacion("No existe Reporte para este Laboratorio");
                }
            } else {
                Mensajes.error("Seleccione un Laboratorio");
                cbLaboratorioLista.requestFocus();
                cbLaboratorioLista.setPopupVisible(true);
            }
        } else if (rbInventarioG.isSelected()) {
            jasper.InventarioArticuloG("\\Reports\\articulos\\inventario_articulos_Gral.jasper");
        } else if (rbInventarioL.isSelected()) {
            if (cbLaboratorioInventario.getSelectedIndex() != 0) {
                try {
                    try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM laboratorio WHERE lab_nombre='" + cbLaboratorioInventario.getSelectedItem().toString() + "'")){
                        rs.last();
                        codLab = rs.getInt("lab_codigo");
                        rs.close();
                        st.close();
                        cn.close();
                    } catch (SQLException ex) {
                        Mensajes.error("Error al querer obtener ID del laboratorio");
                    }
                    jasper.InventarioArticuloL("\\Reports\\articulos\\inventario_articulos_Lab.jasper", "Parameter1", codLab);
                } catch (Exception pr) {
                    Mensajes.informacion("No existe Reporte para este Laboratorio");
                }
            } else {
                Mensajes.error("Seleccione un Laboratorio");
                cbLaboratorioInventario.requestFocus();
                cbLaboratorioInventario.setPopupVisible(true);
            }

        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void rbInventarioGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInventarioGActionPerformed
        // TODO add your handling code here:
        cbLaboratorioInventario.setEnabled(false);
        cbLaboratorioLista.setEnabled(false);
    }//GEN-LAST:event_rbInventarioGActionPerformed

    private void rbInventarioLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInventarioLActionPerformed
        // TODO add your handling code here:
        cbLaboratorioInventario.setEnabled(true);
        cbLaboratorioLista.setEnabled(false);
    }//GEN-LAST:event_rbInventarioLActionPerformed

    private void rbListadoGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbListadoGActionPerformed
        // TODO add your handling code here:
        cbLaboratorioInventario.setEnabled(false);
        cbLaboratorioLista.setEnabled(false);
    }//GEN-LAST:event_rbListadoGActionPerformed

    private void rbListadoLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbListadoLActionPerformed
        // TODO add your handling code here:
        cbLaboratorioLista.setEnabled(true);
        cbLaboratorioInventario.setEnabled(false);
    }//GEN-LAST:event_rbListadoLActionPerformed

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
            java.util.logging.Logger.getLogger(dlgReporteArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgReporteArticulos dialog = new dlgReporteArticulos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgReporteArticulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoReporte;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbLaboratorioInventario;
    private javax.swing.JComboBox<String> cbLaboratorioLista;
    private javax.swing.JMenuItem itemNuevoGenerar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JRadioButton rbInventarioG;
    private javax.swing.JRadioButton rbInventarioL;
    private javax.swing.JRadioButton rbListadoG;
    private javax.swing.JRadioButton rbListadoL;
    // End of variables declaration//GEN-END:variables
}
