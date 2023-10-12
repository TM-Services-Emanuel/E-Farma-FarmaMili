package IU;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.ReporteF;
import Componentes.cargarComboBox;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import Componentes.Empresa;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class dlgReporteTransferenciasFecha extends javax.swing.JDialog {

    public ReporteF jasper;
    static DataSourceService dss = new DataSourceService();

    public dlgReporteTransferenciasFecha(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        jasper = new ReporteF();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        CargarFecha();
        invisible();
        rSalida.doClick();
        pintarCondicion();
        CargarCombos();
    }

    private void CargarCombos() {
        cargarComboBox.cargar(cboDestino, "SELECT * FROM v_sucursal WHERE suc_indicador='S' AND mi_suc='N'");
    }

    private void CargarFecha() {
        lbFechaActual.setText(Fecha.fechaFormulario());
        lbFechaActualR.setText(Fecha.fechaCorrecta());
    }

    private void invisible() {
        txtFDesdeR.setVisible(false);
        txtFHastaR.setVisible(false);
        lbFechaActualR.setVisible(false);
        txtIdDestino.setVisible(false);
        txtIdOrigen.setVisible(false);
        txtTipo.setVisible(false);
    }

    private void MensajeTransferencia() {
        if (rSalida.isSelected()) {
            lbDestinoOrigen.setText("Destino de la transferencia:");
            lbSucursalOrigen.setText("ORIGEN DE LA TRANSFERENCIA: " + Empresa.getSucursal());
            txtIdOrigen.setText(String.valueOf(Empresa.getIdSucursal()));
            txtTipo.setText("S");
        } else if (rEntrada.isSelected()) {
            lbDestinoOrigen.setText("Origen de la transferencia:");
            lbSucursalOrigen.setText("DESTINO DE LA TRANSFERENCIA: " + Empresa.getSucursal());
            txtIdDestino.setText(String.valueOf(Empresa.getIdSucursal()));
            txtTipo.setText("E");
        }
    }

    private void pintarCondicion() {
        if (rEntrada.isSelected()) {
            rEntrada.setFont(new java.awt.Font("Roboto", 1, 11));
            rEntrada.setForeground(new java.awt.Color(255, 102, 0));
            rSalida.setFont(new java.awt.Font("Roboto", 0, 11));
            rSalida.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            rEntrada.setFont(new java.awt.Font("Roboto", 0, 11));
            rEntrada.setForeground(new java.awt.Color(0, 0, 0));
            rSalida.setFont(new java.awt.Font("Roboto", 1, 11));
            rSalida.setForeground(new java.awt.Color(255, 102, 0));
        }
    }

    public void llamarReporteTransferencia(Date desde, Date Hasta, String t, int id_o, int id_d) throws SQLException {
        VisorReportes vr = new VisorReportes(null, true);
        try (Connection cn = dss.getDataSource().getConnection()) {
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\ventas\\documento_transferencia_gral.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("desde", desde);
            parametros.put("hasta", Hasta);
            parametros.put("t", t);
            parametros.put("id_o", id_o);
            parametros.put("id_d", id_d);
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSalir1 = new RSMaterialComponent.RSButtonIconUno();
        PnlActualizar = new rojeru_san.rspanel.RSPanelImage();
        btnGenerar = new RSMaterialComponent.RSButtonIconUno();
        Separador7 = new javax.swing.JSeparator();
        LabelTitulo7 = new javax.swing.JLabel();
        txtFDesdeR = new javax.swing.JTextField();
        txtFHastaR = new javax.swing.JTextField();
        lbFechaActualR = new javax.swing.JLabel();
        txtIdOrigen = new javax.swing.JTextField();
        txtIdDestino = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        rEntrada = new rojerusan.RSCheckBox();
        rSalida = new rojerusan.RSCheckBox();
        jLabel29 = new javax.swing.JLabel();
        lbSucursalOrigen = new javax.swing.JLabel();
        lbDestinoOrigen = new javax.swing.JLabel();
        cboDestino = new RSMaterialComponent.RSComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        rDiario = new javax.swing.JRadioButton();
        rEntreFechas = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lbFechaActual = new javax.swing.JLabel();
        dcFDesde = new datechooser.beans.DateChooserCombo();
        dcFHasta = new datechooser.beans.DateChooserCombo();
        txtFDesde = new javax.swing.JTextField();
        txtFHasta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Generador de Reportes");
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(17, 35, 46));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir1.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir1.setToolTipText("ALT+F4");
        btnSalir1.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.setRippleColor(java.awt.Color.white);
        btnSalir1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        btnSalir1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalir1KeyPressed(evt);
            }
        });
        jPanel4.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 3, 20, 20));

        PnlActualizar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerar.setBackground(new java.awt.Color(0, 153, 255));
        btnGenerar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGenerar.setForegroundHover(new java.awt.Color(0, 153, 255));
        btnGenerar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MENU);
        btnGenerar.setRippleColor(java.awt.Color.white);
        btnGenerar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        PnlActualizar.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador7.setForeground(new java.awt.Color(204, 204, 204));
        PnlActualizar.add(Separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo7.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo7.setText("GENERAR");
        PnlActualizar.add(LabelTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 100, 100));

        txtFDesdeR.setEditable(false);
        txtFDesdeR.setBackground(new java.awt.Color(255, 255, 204));
        txtFDesdeR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFDesdeR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtFDesdeR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 86, -1));

        txtFHastaR.setEditable(false);
        txtFHastaR.setBackground(new java.awt.Color(255, 255, 204));
        txtFHastaR.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtFHastaR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFHastaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFHastaRActionPerformed(evt);
            }
        });
        jPanel4.add(txtFHastaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 86, -1));

        lbFechaActualR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaActualR.setText("jLabel2");
        lbFechaActualR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.add(lbFechaActualR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 90, 23));
        jPanel4.add(txtIdOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 40, -1));
        jPanel4.add(txtIdDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 40, -1));
        jPanel4.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 30, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 549, 100));

        buttonGroup1.add(rEntrada);
        rEntrada.setForeground(new java.awt.Color(0, 0, 0));
        rEntrada.setText("Entrada");
        rEntrada.setColorCheck(new java.awt.Color(255, 102, 0));
        rEntrada.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rEntrada.setFocusPainted(false);
        rEntrada.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEntradaActionPerformed(evt);
            }
        });
        rEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rEntradaKeyPressed(evt);
            }
        });
        jPanel3.add(rEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 138, 71, 25));

        buttonGroup1.add(rSalida);
        rSalida.setForeground(new java.awt.Color(0, 0, 0));
        rSalida.setText("Salida");
        rSalida.setColorCheck(new java.awt.Color(255, 102, 0));
        rSalida.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rSalida.setFocusPainted(false);
        rSalida.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSalidaActionPerformed(evt);
            }
        });
        rSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rSalidaKeyPressed(evt);
            }
        });
        jPanel3.add(rSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 138, 67, 25));

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel29.setText("MDT");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 138, -1, 25));

        lbSucursalOrigen.setBackground(new java.awt.Color(255, 102, 0));
        lbSucursalOrigen.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbSucursalOrigen.setForeground(new java.awt.Color(255, 255, 255));
        lbSucursalOrigen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSucursalOrigen.setOpaque(true);
        jPanel3.add(lbSucursalOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 530, 23));

        lbDestinoOrigen.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDestinoOrigen.setText("Destino de la transferencia:");
        lbDestinoOrigen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(lbDestinoOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 138, -1, 25));

        cboDestino.setForeground(new java.awt.Color(0, 0, 0));
        cboDestino.setColorArrow(new java.awt.Color(17, 35, 46));
        cboDestino.setColorBorde(new java.awt.Color(204, 204, 204));
        cboDestino.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        cboDestino.setColorFondo(new java.awt.Color(255, 255, 255));
        cboDestino.setColorSeleccion(new java.awt.Color(0, 153, 204));
        cboDestino.setConBorde(true);
        cboDestino.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDestinoActionPerformed(evt);
            }
        });
        cboDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboDestinoKeyPressed(evt);
            }
        });
        jPanel3.add(cboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 138, -1, 25));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 530, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rDiario.setBackground(new java.awt.Color(255, 255, 255));
        GrupoReporte.add(rDiario);
        rDiario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rDiario.setSelected(true);
        rDiario.setText("Reporte de la fecha actual:");
        rDiario.setFocusPainted(false);
        rDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rDiarioActionPerformed(evt);
            }
        });
        jPanel1.add(rDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 23));

        rEntreFechas.setBackground(new java.awt.Color(255, 255, 255));
        GrupoReporte.add(rEntreFechas);
        rEntreFechas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rEntreFechas.setText("Reporte entre fechas:");
        rEntreFechas.setFocusPainted(false);
        rEntreFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEntreFechasActionPerformed(evt);
            }
        });
        jPanel1.add(rEntreFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, -1, 23));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Desde");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 48, 36, 23));

        lbFechaActual.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbFechaActual.setText("jLabel2");
        jPanel1.add(lbFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 10, 78, 23));

        dcFDesde.setEnabled(false);
        dcFDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFDesdeOnCommit(evt);
            }
        });
        jPanel1.add(dcFDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 48, 27, 23));

        dcFHasta.setEnabled(false);
        dcFHasta.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFHastaOnCommit(evt);
            }
        });
        jPanel1.add(dcFHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 48, 27, 23));

        txtFDesde.setEditable(false);
        txtFDesde.setBackground(new java.awt.Color(255, 255, 255));
        txtFDesde.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtFDesde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFDesde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFDesde.setEnabled(false);
        txtFDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDesdeActionPerformed(evt);
            }
        });
        jPanel1.add(txtFDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 48, 92, 23));

        txtFHasta.setEditable(false);
        txtFHasta.setBackground(new java.awt.Color(255, 255, 255));
        txtFHasta.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtFHasta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFHasta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFHasta.setEnabled(false);
        txtFHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFHastaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 48, 92, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Hasta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 48, 36, 23));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 40, 518, 1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 530, 82));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rDiarioActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(false);
        txtFDesde.setText("");
        txtFDesdeR.setText("");
        dcFDesde.setEnabled(false);
        txtFHasta.setEnabled(false);
        txtFHasta.setText("");
        txtFHastaR.setText("");
        dcFHasta.setEnabled(false);
    }//GEN-LAST:event_rDiarioActionPerformed

    private void rEntreFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntreFechasActionPerformed
        // TODO add your handling code here:
        txtFDesde.setEnabled(true);
        dcFDesde.setEnabled(true);
        txtFHasta.setEnabled(true);
        dcFHasta.setEnabled(true);
    }//GEN-LAST:event_rEntreFechasActionPerformed

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

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        if (cboDestino.getSelectedIndex() == 0) {
            if (rEntrada.isSelected()) {
                Mensajes.Sistema("Origen de la transferencia no especificado.\nPor favor, seleccione la sucursal para cargar los items trasnferidos.");
                cboDestino.setPopupVisible(true);
                cboDestino.requestFocus();
            } else if (rSalida.isSelected()) {
                Mensajes.Sistema("Destino de la transferencia no especificado.\nPor favor, seleccione la sucursal para cargar los items a transferir.");
                cboDestino.setPopupVisible(true);
                cboDestino.requestFocus();
            }
        } else {
            if (rDiario.isSelected()) {
                try {
                    llamarReporteTransferencia(Date.valueOf(lbFechaActualR.getText()), Date.valueOf(lbFechaActualR.getText()), txtTipo.getText(), Integer.parseInt(txtIdOrigen.getText()), Integer.parseInt(txtIdDestino.getText()));
                } catch (SQLException ex) {
                    System.out.println("Error llamarReporteTransferencia: " + ex.getMessage());
                }
            } else if (rEntreFechas.isSelected()) {
                if(txtFDesdeR.getText().isEmpty()){
                    Mensajes.Sistema("La fecha desde no ha sido espeficicado.\nPor favor, complete esta información para continuar con el proceso de generación de reporte.");
                }else if(txtFHastaR.getText().isEmpty()){
                    Mensajes.Sistema("La fecha hasta no ha sido espeficicado.\nPor favor, complete esta información para continuar con el proceso de generación de reporte.");
                }else if (Date.valueOf(txtFHastaR.getText()).before(Date.valueOf(txtFDesdeR.getText()))) {
                    Mensajes.Sistema("Hay un error en el cargado de los parametros de fechas.\nLa fecha hasta es anterior a la fecha desde.");
                } else {
                    try {
                        llamarReporteTransferencia(Date.valueOf(txtFDesdeR.getText()), Date.valueOf(txtFHastaR.getText()), txtTipo.getText(), Integer.parseInt(txtIdOrigen.getText()), Integer.parseInt(txtIdDestino.getText()));
                    } catch (SQLException ex) {
                        System.out.println("Error llamarReporteTransferencia: " + ex.getMessage());
                    }
                }

            }

        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnSalir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalir1KeyPressed
        // TODO add your handling code here:
        // AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalir1KeyPressed

    private void txtFHastaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFHastaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFHastaRActionPerformed

    private void rEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntradaActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
        MensajeTransferencia();
        cboDestinoActionPerformed(null);
    }//GEN-LAST:event_rEntradaActionPerformed

    private void rEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rEntradaKeyPressed
        // TODO add your handling code here:
        //AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rEntradaKeyPressed

    private void rSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSalidaActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
        MensajeTransferencia();
        cboDestinoActionPerformed(null);
    }//GEN-LAST:event_rSalidaActionPerformed

    private void rSalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSalidaKeyPressed
        // TODO add your handling code here:
        //AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rSalidaKeyPressed

    private void cboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDestinoActionPerformed
        // TODO add your handling code here:
        if (cboDestino.getSelectedIndex() != 0) {
            String sqlEmp = "Select suc_codigo from v_sucursal where suc_nombre='" + String.valueOf(cboDestino.getSelectedItem()) + "'and suc_indicador='S' AND mi_suc='N'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlEmp)) {
                rs.first();
                if (rs.getRow() != 0) {
                    if (rSalida.isSelected()) {
                        txtIdDestino.setText(String.valueOf(rs.getInt(1)));
                    } else if (rEntrada.isSelected()) {
                        txtIdOrigen.setText(String.valueOf(rs.getInt(1)));
                    }
                    rs.close();
                    st.close();
                    cn.close();
                } else {
                    System.out.println("Consulta sin resultados.");
                }

            } catch (SQLException ex) {
                Mensajes.error("Error obteniendo ID familia:" + ex.getMessage());
            }
        } else {
            if (rSalida.isSelected()) {
                txtIdDestino.setText("");
            } else if (rEntrada.isSelected()) {
                txtIdOrigen.setText("");
            }
        }
    }//GEN-LAST:event_cboDestinoActionPerformed

    private void cboDestinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboDestinoKeyPressed
        // TODO add your handling code here:
        //AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_cboDestinoKeyPressed

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
            java.util.logging.Logger.getLogger(dlgReporteTransferenciasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgReporteTransferenciasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgReporteTransferenciasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgReporteTransferenciasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                dlgReporteTransferenciasFecha dialog = new dlgReporteTransferenciasFecha(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgReporteTransferenciasFecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoReporte;
    private javax.swing.JLabel LabelTitulo7;
    private rojeru_san.rspanel.RSPanelImage PnlActualizar;
    private javax.swing.JSeparator Separador7;
    private RSMaterialComponent.RSButtonIconUno btnGenerar;
    public static RSMaterialComponent.RSButtonIconUno btnSalir1;
    private javax.swing.ButtonGroup buttonGroup1;
    private RSMaterialComponent.RSComboBox cboDestino;
    public static datechooser.beans.DateChooserCombo dcFDesde;
    public static datechooser.beans.DateChooserCombo dcFHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDestinoOrigen;
    private javax.swing.JLabel lbFechaActual;
    private javax.swing.JLabel lbFechaActualR;
    private javax.swing.JLabel lbSucursalOrigen;
    private javax.swing.JRadioButton rDiario;
    public static rojerusan.RSCheckBox rEntrada;
    private javax.swing.JRadioButton rEntreFechas;
    public static rojerusan.RSCheckBox rSalida;
    public static javax.swing.JTextField txtFDesde;
    public static javax.swing.JTextField txtFDesdeR;
    public static javax.swing.JTextField txtFHasta;
    public static javax.swing.JTextField txtFHastaR;
    private javax.swing.JTextField txtIdDestino;
    private javax.swing.JTextField txtIdOrigen;
    public static javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
