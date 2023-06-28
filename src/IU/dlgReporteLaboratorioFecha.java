package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.ReporteF;
import Componentes.cargarComboBox;
import java.awt.Toolkit;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;
import java.sql.*;

public class dlgReporteLaboratorioFecha extends javax.swing.JDialog {

    public ReporteF jasper;
    public static ResultSet rs;
    public static MariaDbStatement sentencia;
    public static MariaDbConnection con;
    static String Fdesde;
    static String Fhasta;
    static int codLab;

    public dlgReporteLaboratorioFecha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jasper = new ReporteF();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        CargarFecha();
        invisible();
        CargarCombos();
    }
    
    private void CargarCombos() {
        cargarComboBox.cargar(cboLaboratorio, "SELECT * FROM laboratorio WHERE lab_indicador='S'");
    }

    private void CargarFecha() {
        lbFechaActual.setText(Fecha.fechaFormulario());
        lbFechaActualR.setText(Fecha.fechaCorrecta());
    }
    
    private void invisible(){
        txtFDesdeR.setVisible(false);
        txtFHastaR.setVisible(false);
        lbFechaActualR.setVisible(false);
    }

    public static void prepararBD() {
        {
            try {
                con = (MariaDbConnection) new ConexionBD().getConexion();
                if (con == null) {
                    System.out.println("No hay Conexion con la Base de Datos");
                } else {
                    sentencia = (MariaDbStatement) con.createStatement();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoReporte = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbLaboratorioA = new javax.swing.JRadioButton();
        rbLaboratorioF = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lbFechaActual = new javax.swing.JLabel();
        dcFDesde = new datechooser.beans.DateChooserCombo();
        dcFHasta = new datechooser.beans.DateChooserCombo();
        txtFDesde = new javax.swing.JTextField();
        txtFHasta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboLaboratorio = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lbFechaActualR = new javax.swing.JLabel();
        txtFDesdeR = new javax.swing.JTextField();
        txtFHastaR = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoGenerar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de Reportes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        GrupoReporte.add(rbLaboratorioA);
        rbLaboratorioA.setSelected(true);
        rbLaboratorioA.setText("Reporte de la fecha actual:");
        rbLaboratorioA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLaboratorioAActionPerformed(evt);
            }
        });

        GrupoReporte.add(rbLaboratorioF);
        rbLaboratorioF.setText("Reporte entre fechas:");
        rbLaboratorioF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLaboratorioFActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde");

        lbFechaActual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFechaActual.setText("jLabel2");

        dcFDesde.setEnabled(false);
        dcFDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFDesdeOnCommit(evt);
            }
        });

        dcFHasta.setEnabled(false);
        dcFHasta.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFHastaOnCommit(evt);
            }
        });

        txtFDesde.setEditable(false);
        txtFDesde.setBackground(new java.awt.Color(255, 255, 204));
        txtFDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtFDesde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFDesde.setEnabled(false);
        txtFDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDesdeActionPerformed(evt);
            }
        });

        txtFHasta.setEditable(false);
        txtFHasta.setBackground(new java.awt.Color(255, 255, 204));
        txtFHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtFHasta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFHasta.setEnabled(false);
        txtFHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFHastaActionPerformed(evt);
            }
        });

        jLabel2.setText("Hasta");

        jLabel3.setText("Laboratorio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 131, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbLaboratorioF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbLaboratorioA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLaboratorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLaboratorioA)
                    .addComponent(lbFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbLaboratorioF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcFHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        lbFechaActualR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaActualR.setText("jLabel2");

        txtFDesdeR.setEditable(false);
        txtFDesdeR.setBackground(new java.awt.Color(255, 255, 204));
        txtFDesdeR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFDesdeR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtFHastaR.setEditable(false);
        txtFHastaR.setBackground(new java.awt.Color(255, 255, 204));
        txtFHastaR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFHastaR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbFechaActualR, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFHastaR)
                            .addComponent(txtFDesdeR)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFDesdeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFHastaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbFechaActualR))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (cboLaboratorio.getSelectedIndex() == 0) {
            Mensajes.error("Seleccione un Laboratorio");
            cboLaboratorio.requestFocus();
            cboLaboratorio.setPopupVisible(true);     
        }else{
            try {
                    prepararBD();
                    String lab;
                    lab = cboLaboratorio.getSelectedItem().toString();
                    try {
                        rs = sentencia.executeQuery("SELECT * FROM laboratorio WHERE lab_nombre='" + lab + "'");
                        rs.last();
                        codLab = rs.getInt("lab_codigo");
                        rs.close();
                    } catch (SQLException ex) {
                        Mensajes.error("Error al querer obtener ID del laboratorio");
                    }
                } catch (Exception pr) {
                    Mensajes.informacion("No existe Reporte para este Laboratorio");
                }
            if (rbLaboratorioA.isSelected()) {
            jasper.reporteTresParametroHorizontal("\\Reports\\ventas\\VTporLaboratorio.jasper", "codLab", codLab, "desde", Date.valueOf(lbFechaActualR.getText().trim()), "hasta", Date.valueOf(lbFechaActualR.getText().trim()));
        }else if(rbLaboratorioF.isSelected()){
            if(txtFDesde.getText().trim().isEmpty()){
                Mensajes.informacion("Fije la fecha desde");
            }else if(txtFHasta.getText().trim().isEmpty()){
                Mensajes.informacion("Fije la fecha hasta");
            }else if(Date.valueOf(txtFDesdeR.getText().trim()).after(Date.valueOf(txtFHastaR.getText().trim()))){
                Mensajes.error("Error en los parametros fijados.\nFavor verifique las fechas Desde y Hasta.");
            }else{
                jasper.reporteTresParametroHorizontal("\\Reports\\ventas\\VTporLaboratorio.jasper", "codLab", codLab, "desde", Date.valueOf(txtFDesdeR.getText().trim()), "hasta", Date.valueOf(txtFHastaR.getText().trim()));
            }
        }
            
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void rbLaboratorioAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLaboratorioAActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(false);
        txtFDesde.setText("");
        txtFDesdeR.setText("");
        dcFDesde.setEnabled(false);
        txtFHasta.setEnabled(false);
        txtFHasta.setText("");
        txtFHastaR.setText("");
        dcFHasta.setEnabled(false);
    }//GEN-LAST:event_rbLaboratorioAActionPerformed

    private void rbLaboratorioFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLaboratorioFActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(true);
        dcFDesde.setEnabled(true);
        txtFHasta.setEnabled(true);
        dcFHasta.setEnabled(true);
    }//GEN-LAST:event_rbLaboratorioFActionPerformed

    private void dcFDesdeOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFDesdeOnCommit
        // TODO add your handling code here:
        txtFDesde.setText(Fecha.fechaCFormulario(dcFDesde.getText()));
        txtFDesdeR.setText(Fecha.formatoFecha(dcFDesde.getText()));
    }//GEN-LAST:event_dcFDesdeOnCommit

    private void dcFHastaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFHastaOnCommit
        // TODO add your handling code here:
        txtFHasta.setText(Fecha.fechaCFormulario(dcFHasta.getText()));
        txtFHastaR.setText(Fecha.formatoFecha(dcFHasta.getText()));
    }//GEN-LAST:event_dcFHastaOnCommit

    private void txtFHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFHastaActionPerformed

    private void txtFDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFDesdeActionPerformed

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
            java.util.logging.Logger.getLogger(dlgReporteLaboratorioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteLaboratorioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteLaboratorioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteLaboratorioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgReporteLaboratorioFecha dialog = new dlgReporteLaboratorioFecha(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup GrupoReporte;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboLaboratorio;
    public static datechooser.beans.DateChooserCombo dcFDesde;
    public static datechooser.beans.DateChooserCombo dcFHasta;
    private javax.swing.JMenuItem itemNuevoGenerar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lbFechaActual;
    private javax.swing.JLabel lbFechaActualR;
    private javax.swing.JRadioButton rbLaboratorioA;
    private javax.swing.JRadioButton rbLaboratorioF;
    public static javax.swing.JTextField txtFDesde;
    public static javax.swing.JTextField txtFDesdeR;
    public static javax.swing.JTextField txtFHasta;
    public static javax.swing.JTextField txtFHastaR;
    // End of variables declaration//GEN-END:variables
}
