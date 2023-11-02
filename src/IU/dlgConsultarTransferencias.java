package IU;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.ReporteF;
import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.RenderDecimalVenta;
import Componentes.RenderDecimalsinColor;
import Componentes.RenderTextoRojo;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class dlgConsultarTransferencias extends javax.swing.JDialog {
    static DataSourceService dss = new DataSourceService();
    private static Point point;

    public dlgConsultarTransferencias(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        titulo();
        txtFechaF.setText(Fecha.formatoFecha(dcFecha.getText()));
        btnActualizarActionPerformed(null);
        txtFechaF.setVisible(false);

    }
    
    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F10 ->
                btnImprimir.doClick();
            case KeyEvent.VK_DELETE ->
                btnAnular.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            case KeyEvent.VK_F3 ->
                btnBuscar.doClick();
            default -> {
            }
        }
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar FACTURAS LEGALES emitidos");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar FACTURAS LEGALES emitidos");
        }
    }

    public static void Renders() {
        dlgConsultarTransferencias.tbTransferencias.getColumnModel().getColumn(7).setCellRenderer(new RenderDecimalVenta());
        dlgConsultarTransferencias.tbTransferencias.getColumnModel().getColumn(8).setCellRenderer(new RenderTextoRojo());
    }

    public static void RendersD() {
        dlgConsultarTransferencias.tbDetalleTransferencias.getColumnModel().getColumn(0).setCellRenderer(new RenderDecimalsinColor());
        dlgConsultarTransferencias.tbDetalleTransferencias.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimalsinColor());
        dlgConsultarTransferencias.tbDetalleTransferencias.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimalsinColor());
    }

    public void llamarReporteTransferencia(int cod) throws SQLException {
        VisorReportes vr = new VisorReportes(null, true);
        try (Connection cn = dss.getDataSource().getConnection()) {
            String jasperUrl = System.getProperty("user.dir").concat("\\Reports\\ventas\\documento_transferencia.jasper");
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasperUrl);
            //para los parametro
            Map parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            parametros.put("cod", cod);
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

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        panelCabecera = new org.edisoncor.gui.panel.PanelImage();
        txtFechaF = new javax.swing.JTextField();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel3 = new javax.swing.JPanel();
        PnlModificar1 = new rojeru_san.rspanel.RSPanelImage();
        btnImprimir = new RSMaterialComponent.RSButtonIconUno();
        Separador6 = new javax.swing.JSeparator();
        LabelTitulo6 = new javax.swing.JLabel();
        PnlActualizar = new rojeru_san.rspanel.RSPanelImage();
        btnActualizar = new RSMaterialComponent.RSButtonIconUno();
        Separador7 = new javax.swing.JSeparator();
        LabelTitulo7 = new javax.swing.JLabel();
        PnlEliminarG = new rojeru_san.rspanel.RSPanelImage();
        btnAnular = new RSMaterialComponent.RSButtonIconUno();
        Separador8 = new javax.swing.JSeparator();
        LabelTitulo8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new RSMaterialComponent.RSButtonIconUno();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBackground(new java.awt.Color(255, 255, 255));
        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        panelCabecera.setPreferredSize(new java.awt.Dimension(690, 418));
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
        panelCabecera.add(txtFechaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 90, -1));

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
        panelCabecera.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 3, 20, 20));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlModificar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlModificar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnImprimir.setBackground(new java.awt.Color(255, 102, 0));
        btnImprimir.setToolTipText("F10");
        btnImprimir.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnImprimir.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnImprimir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimir.setRippleColor(java.awt.Color.white);
        btnImprimir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        btnImprimir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnImprimirKeyPressed(evt);
            }
        });
        PnlModificar1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 45, 45));

        Separador6.setForeground(new java.awt.Color(204, 204, 204));
        PnlModificar1.add(Separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo6.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo6.setText("RE-IMPRIMIR");
        PnlModificar1.add(LabelTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel3.add(PnlModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

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

        jPanel3.add(PnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

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
        LabelTitulo8.setText("ANULAR");
        PnlEliminarG.add(LabelTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel3.add(PnlEliminarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        panelCabecera.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        Blanco.add(panelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 924, 102));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setOpaque(false);

        tbTransferencias.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbTransferencias.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTransferencias.setFillsViewportHeight(true);
        tbTransferencias.setGridColor(new java.awt.Color(204, 204, 204));
        tbTransferencias.setRowHeight(20);
        tbTransferencias.setShowGrid(true);
        tbTransferencias.setShowVerticalLines(false);
        tbTransferencias.getTableHeader().setResizingAllowed(false);
        tbTransferencias.getTableHeader().setReorderingAllowed(false);
        tbTransferencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbTransferenciasMousePressed(evt);
            }
        });
        tbTransferencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTransferenciasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbTransferencias);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 135, 924, 250));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "DETALLE DE LA TRANSFERENCIA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 10), new java.awt.Color(17, 35, 46))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbDetalleTransferencias.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbDetalleTransferencias.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalleTransferencias.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalleTransferencias.setRowHeight(20);
        tbDetalleTransferencias.setShowGrid(true);
        tbDetalleTransferencias.setShowVerticalLines(false);
        tbDetalleTransferencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleTransferenciasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbDetalleTransferencias);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 14, 913, 233));

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 387, 920, 250));

        dcFecha.setCalendarBackground(new java.awt.Color(255, 255, 255));
        dcFecha.setFieldFont(new java.awt.Font("Roboto", java.awt.Font.BOLD, 12));
        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });
        Blanco.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 106, 90, 25));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("TRANSFERENCIAS DE LA FECHA:");
        Blanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 106, -1, 25));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setForeground(new java.awt.Color(17, 35, 46));
        btnBuscar.setToolTipText("F3");
        btnBuscar.setBackgroundHover(new java.awt.Color(255, 102, 0));
        btnBuscar.setForegroundText(new java.awt.Color(17, 35, 46));
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscar.setRippleColor(java.awt.Color.white);
        btnBuscar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });
        Blanco.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 106, 25, 25));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Buscador");
        Blanco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 106, -1, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llamarReporteFactura(int cod, String Letra) throws SQLException {
        ReporteF gr;
        gr = new ReporteF();
        gr.FacturaLegal("\\Reports\\ventas\\facturaLegal.jasper", "cod", cod, "Letra", Letra);
        gr.cerrar();
    }
    private void tbTransferenciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransferenciasMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablaDetalleTransferencia(tbDetalleTransferencias);
            controlFactura.listDetalleTransferencias(tbDetalleTransferencias);
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_tbTransferenciasMousePressed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:c
        txtFechaF.setText(Fecha.formatoFecha(dcFecha.getText()));
        btnActualizarActionPerformed(null);
    }//GEN-LAST:event_dcFechaOnCommit

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            String cod = (JOptionPane.showInputDialog("Ingrese N° de Transferencia"));
            for (int i = 0; i < tbTransferencias.getRowCount(); i++) {
                if (tbTransferencias.getValueAt(i, 1).equals(cod)) {
                    tbTransferencias.changeSelection(i, 1, false, false);
                    tbTransferenciasMousePressed(null);
                    break;
                }
            }
        } catch (HeadlessException e) {
            System.out.println("Consulta cancelada" + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarTransferencias.tbTransferencias.getSelectedRow() < 0) {
            Notif.NotifyFail("Notificación del sistema", "No es posible levantar el documento de transferencia.\r\nPor favor, seleccione la transferencia que desea volver a re-imprimir.");
            //Mensajes.Sistema("No es posible levantar el documento de transferencia.\nPor favor, seleccione la transferencia que desea volver a re-imprimir.");
        } else {
            try {
                int x = dlgConsultarTransferencias.tbTransferencias.getSelectedRow();
                String cod = dlgConsultarTransferencias.tbTransferencias.getValueAt(x, 0).toString();
                llamarReporteTransferencia(Integer.parseInt(cod));
            } catch (NumberFormatException | SQLException e) {
                Mensajes.Sistema("Error intentando levantar hoja de transferencia: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            CabecerasTablas.consTransferencias(tbTransferencias);
            CabecerasTablas.limpiarTablaConsTransferencias(tbTransferencias);
            CabecerasTablas.detalleTransferencia(tbDetalleTransferencias);
            CabecerasTablas.limpiarTablaDetalleTransferencia(tbDetalleTransferencias);
            controlFactura.listTransferencias(tbTransferencias, txtFechaF.getText().trim());
            Renders();
            Notif.NotifySuccess("Notificación del sistema", "Lista actualizada!");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarTransferencias.tbTransferencias.getSelectedRow() < 0) {
            //Mensajes.error("No es posible procesar la anulación.\nPor favor, seleccione la transferencia que desea anular.");
            Notif.NotifyFail("Notificación del sistema", "No es posible procesar la operación.\r\nSeleccione la Transferencia que desea anular.");
        } else {
            int x = dlgConsultarTransferencias.tbTransferencias.getSelectedRow();
            String estado = dlgConsultarTransferencias.tbTransferencias.getValueAt(x, 8).toString();
            if (estado.equals("TRANSFERENCIA ANULADA")) {
                //Mensajes.Sistema("Esta transferencia ya se encuentra anulada.");
                Notif.NotifyFail("Notificación del sistema", "No es posible procesar la operación.\r\nEsta Transferencia ya fue anulada");
            } else {
                String msg;
                int rpta = Mensajes.confirmar("¿Seguro que desea procesar la anulación de esta transferencia?");
                if (rpta == 0) {
                    try {
                        msg = controlFactura.anularTransferencia();
                        if (msg == null) {
                            btnActualizarActionPerformed(null);
                        }

                    } catch (Exception e) {
                    }
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

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnImprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnImprimirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnImprimirKeyPressed

    private void btnAnularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAnularKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnAnularKeyPressed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void tbTransferenciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTransferenciasKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbTransferenciasKeyPressed

    private void tbDetalleTransferenciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleTransferenciasKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleTransferenciasKeyPressed

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

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarTransferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarTransferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarTransferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarTransferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgConsultarTransferencias dialog = new dlgConsultarTransferencias(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                System.out.println("Error levanando dlgConsultarTransferencia: " + ex.getMessage());
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private javax.swing.JLabel LabelTitulo6;
    private javax.swing.JLabel LabelTitulo7;
    private javax.swing.JLabel LabelTitulo8;
    private rojeru_san.rspanel.RSPanelImage PnlActualizar;
    private rojeru_san.rspanel.RSPanelImage PnlEliminarG;
    private rojeru_san.rspanel.RSPanelImage PnlModificar1;
    private javax.swing.JSeparator Separador6;
    private javax.swing.JSeparator Separador7;
    private javax.swing.JSeparator Separador8;
    private RSMaterialComponent.RSButtonIconUno btnActualizar;
    private RSMaterialComponent.RSButtonIconUno btnAnular;
    private RSMaterialComponent.RSButtonIconUno btnBuscar;
    private RSMaterialComponent.RSButtonIconUno btnImprimir;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private datechooser.beans.DateChooserCombo dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.PanelImage panelCabecera;
    public static final javax.swing.JTable tbDetalleTransferencias = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static final javax.swing.JTable tbTransferencias = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    private javax.swing.JTextField txtFechaF;
    // End of variables declaration//GEN-END:variables
}
