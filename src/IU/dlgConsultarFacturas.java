package IU;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.ReporteF;
import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.Operacion;
import Componentes.PrinterService;
import Componentes.RenderDecimal;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimalVenta;
import Componentes.Software;
import Componentes.traerIP;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dlgConsultarFacturas extends javax.swing.JDialog {

    public ReporteF jasper;
    private static String ImpresoraPred;
    static DataSourceService dss = new DataSourceService();
    private static Point point;

    public dlgConsultarFacturas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        titulo();
        txtCodCliente.setVisible(false);
        jasper = new ReporteF();
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
            this.setTitle("Gestionar TICKETS emitidos");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar TICKETS emitidos");
        }
    }

    public static void Renders() {
        dlgConsultarFacturas.tblFactura.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimalVenta());
    }

    public static void RendersD() {
        dlgConsultarFacturas.tblDetalle.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimal1());
        dlgConsultarFacturas.tblDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimalVenta());
    }

    public static void limpiarCampos() {
        txtCodCliente.setText("");
        txtRuc.setText("");
        txtRazonSocial.setText("");
        txtVendedor.setText("");
        txtCondicion.setText("");
        txtPago.setText("");
        txtEstado.setText("");
    }

    public static void obtenerImpresoraPredeterminada(String fact, String fecha, String hora, String total, String condicion, String cod) {
        String sqlImp = "SELECT * FROM v_puntoemision3 WHERE tipo='T' AND estado='Activo' AND ip='" + traerIP.getIP() + "'";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rss = st.executeQuery(sqlImp)) {
            rss.last();
            do {
                ImpresoraPred = rss.getString("imp_pred").trim();
                System.out.println(ImpresoraPred);

            } while (rss.next());
            rss.close();
            st.close();
            cn.close();
            imprimirTicket(ImpresoraPred, fact, fecha, hora, total);
            try {
                StringBuilder sql = new StringBuilder("INSERT INTO reimpresiones (re_fac_codigo, re_descripcion, re_tipo, fecha, usu) VALUES (");
                sql.append(cod).append(", ");
                sql.append("'RE-IMPRESION DE TICKET','");
                sql.append(condicion).append("',");
                sql.append("now(),'");
                sql.append(Login.getUsuarioLogueado()).append("')");
                String msg = Operacion.exeOperacion(sql.toString());
                if (msg == null) {
                    System.out.println("la re-impresion ha sido registrada");
                } else {
                    System.out.println("Error en registrar la re-impresion: " + msg);
                }
            } catch (Exception e) {
                Mensajes.error("Hubo un error en el registro de la re-impresión");
            }
        } catch (SQLException ex) {
            Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible realizar la re-impresión del Ticket.\nEl Sistema no logra identificar la Impresora Predeterminada para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
        }
    }

    public static void imprimirTicket(String ImpPred, String fact, String fecha, String hora, String total) {
        //Impresora termica
        PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());
        int filas = tblDetalle.getRowCount();
        DecimalFormat formateador = new DecimalFormat("#,###");
        //String tot = formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", "")));

        String Ticket = "            TICKET DE VENTA\n";
        Ticket += "----------------------------------------\n";
        Ticket += "NRO: " + fact + "\n";
        Ticket += "FECHA: " + fecha + " " + hora + "\n";
        Ticket += "VENDEDOR/A: " + txtVendedor.getText().trim() + "\n";
        Ticket += "----------------------------------------\n";
        Ticket += "CANT   P.PUBL  %DESC  P.UNIT    TOTAL   \n";
        Ticket += "----------------------------------------\n";
        for (int i = 0; i < filas; i++) {
            String Descripcion = tblDetalle.getValueAt(i, 3).toString().trim();
            String Cant = tblDetalle.getValueAt(i, 0).toString();
            //int pp = Integer.parseInt(tblDetalle.getValueAt(i, 17).toString()) / Integer.parseInt(tblDetalle.getValueAt(i, 3).toString());
            String Ppublic = /*String.valueOf(pp)*/ "*";
            String Desc = /*tblDetalle.getValueAt(i, 16).toString()*/ "*";
            String Punit = tblDetalle.getValueAt(i, 4).toString().trim();
            String Mont = tblDetalle.getValueAt(i, 5).toString().trim();

            Ticket += String.format("%1$1s", Descripcion + "\n");
            //Ticket += String.format("%1$11s %2$15s %3$19s" ,"CANT: "+tbDetalle.getValueAt(i, 3).toString(), "PRECIO: "+formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))), "SUBTOTAL: "+formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))))+ "\n";
            Ticket += String.format("%1$-6s %2$-8s %3$-5s %4$-9s %5$-5s", Cant, Ppublic, Desc,
                    formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))),
                    formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", "")))) + "\n";
        }
        Ticket += "----------------------------------------\n";
        Ticket += String.format("%1$6s %2$22s", "TOTAL A PAGAR:", formateador.format(Integer.parseInt(total.replace(".", "").replace(",", "")))) + "\n";
        Ticket += "----------------------------------------\n";
        Ticket += "      GRACIAS POR SU PREFERENCIA!\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";

        printerService.printString2(ImpPred, Ticket);
        //print some stuff

        // cut that paper!
        byte[] cutP = new byte[]{0x1d, 'V', 1};

        printerService.printBytes2(ImpPred, cutP);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        panelCabecera = new org.edisoncor.gui.panel.PanelImage();
        txtCodCliente = new javax.swing.JTextField();
        txtFechaF = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
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
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jScrollPane1 = new javax.swing.JScrollPane();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCondicion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscar = new RSMaterialComponent.RSButtonIconUno();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();

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

        txtCodCliente.setEditable(false);
        txtCodCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCodCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCabecera.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 13, 39, -1));
        panelCabecera.add(txtFechaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 45, 90, -1));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel4.add(PnlModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

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

        jPanel4.add(PnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

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

        jPanel4.add(PnlEliminarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        panelCabecera.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        panelCabecera.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 3, 20, 20));

        Blanco.add(panelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 883, 102));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane1.setOpaque(false);

        tblFactura.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura.setGridColor(new java.awt.Color(204, 204, 204));
        tblFactura.setRowHeight(20);
        tblFactura.setShowGrid(true);
        tblFactura.setShowVerticalLines(false);
        tblFactura.getTableHeader().setResizingAllowed(false);
        tblFactura.getTableHeader().setReorderingAllowed(false);
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFacturaMousePressed(evt);
            }
        });
        tblFactura.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblFacturaPropertyChange(evt);
            }
        });
        tblFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFacturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 550, 320));

        dcFecha.setCalendarBackground(new java.awt.Color(255, 255, 255));
        dcFecha.setFieldFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 14));
        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });
        Blanco.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 106, 100, 25));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("COMPROBANTES DE LA FECHA:");
        Blanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 106, -1, 25));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(17, 35, 46));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INFORMACIÓN");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 6, 319, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel7.setText("R.U.C.: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 38, -1, 23));

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
        });
        jPanel3.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 38, 119, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel5.setText("Razón Social:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 64, -1, 23));

        txtRazonSocial.setEditable(false);
        txtRazonSocial.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonSocial.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtRazonSocial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyPressed(evt);
            }
        });
        jPanel3.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 64, 210, 23));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel6.setText("Condición:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 90, -1, 23));

        txtCondicion.setEditable(false);
        txtCondicion.setBackground(new java.awt.Color(255, 255, 255));
        txtCondicion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCondicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCondicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCondicionKeyPressed(evt);
            }
        });
        jPanel3.add(txtCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 90, 210, 23));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel8.setText("Pago:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 116, -1, 23));

        txtPago.setEditable(false);
        txtPago.setBackground(new java.awt.Color(255, 255, 255));
        txtPago.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagoKeyPressed(evt);
            }
        });
        jPanel3.add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 116, 210, 23));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel9.setText("Estado:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 142, -1, 23));

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(255, 255, 255));
        txtEstado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstadoKeyPressed(evt);
            }
        });
        jPanel3.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 142, 210, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel2.setText("Vendedor:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 168, -1, 23));

        txtVendedor.setEditable(false);
        txtVendedor.setBackground(new java.awt.Color(255, 255, 255));
        txtVendedor.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVendedorKeyPressed(evt);
            }
        });
        jPanel3.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 168, 210, 23));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 2));

        Blanco.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 135, -1, 204));

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

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Buscador");
        Blanco.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 106, -1, 25));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tblDetalle.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tblDetalle.setRowHeight(20);
        tblDetalle.setShowGrid(true);
        tblDetalle.setShowVerticalLines(false);
        tblDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDetalleKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetalle);

        Blanco.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 457, 883, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llamarReporteFactura() throws SQLException {
        ReporteF gr;
        gr = new ReporteF();
        gr.cerrar();
    }
    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        // TODO add your handling code here:
        /*try {
            CabecerasTablas.limpiarTablas(tblDetalle);
            controlFactura.listDetalle(tblDetalle);
            controlFactura.ListClientes();
            controlFactura.selecVendedor();
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }*/
    }//GEN-LAST:event_tblFacturaMouseClicked

    private void tblFacturaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblFacturaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturaPropertyChange

    private void tblFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMousePressed
        // TODO add your handling code here:
        try {
            CabecerasTablas.limpiarTablaDetalleFactura(tblDetalle);
            controlFactura.listDetalle(tblDetalle);
            controlFactura.ListClientes();
            controlFactura.selecVendedor();
            RendersD();
        } catch (Exception e) {
            Mensajes.error(e.getMessage());
        }
    }//GEN-LAST:event_tblFacturaMousePressed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:c
        try {
            txtFechaF.setText(Fecha.formatoFecha(dcFecha.getText()));
            CabecerasTablas.limpiarTablaConsFacturas(tblFactura);
            CabecerasTablas.limpiarTablaDetalleFactura(tblDetalle);
            controlFactura.listFacturas(tblFactura, txtFechaF.getText().trim());
            Renders();
            limpiarCampos();
            Notif.NotifySuccess("Notificación del sistema", "Lista actualizada!");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_dcFechaOnCommit

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarFacturas.tblFactura.getSelectedRow() < 0) {
            //Mensajes.error("No es posible procesar la operación.\nSeleccione la venta que desea re-imprimir");
            Notif.NotifyFail("Notificación del sistema", "No es posible procesar la operación.\r\nSeleccione la Venta que desea re-imprimir");
        } else {
            int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
            String estado = dlgConsultarFacturas.tblFactura.getValueAt(x, 11).toString();
            if (estado.equals("ANULADO")) {
                //Mensajes.informacion("VENTA ANULADA: Imposible realizar la re-impresión");
                Notif.NotifyFail("Notificación del sistema", "VENTA ANULADA: Imposible realizar la re-impresión");
            } else {
                int rpta = Mensajes.confirmar("¿Seguro que desea re-imprimir la venta?");
                if (rpta == 0) {
                    try {
                        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
                        String fecha = dlgConsultarFacturas.tblFactura.getValueAt(x, 2).toString();
                        String hora = dlgConsultarFacturas.tblFactura.getValueAt(x, 3).toString();
                        String fact = dlgConsultarFacturas.tblFactura.getValueAt(x, 6).toString();
                        String caja = dlgConsultarFacturas.tblFactura.getValueAt(x, 5).toString();
                        String condicion = dlgConsultarFacturas.tblFactura.getValueAt(x, 7).toString();
                        String total = dlgConsultarFacturas.tblFactura.getValueAt(x, 9).toString();
                        if (condicion.equals("CONTADO")) {
                            obtenerImpresoraPredeterminada(fact, fecha, hora, total, condicion, cod);
                        } else {
                            jasper.BoletaCreditoRE("\\Reports\\ventas\\venta_credito_reimpresion.jasper", "cod", Integer.valueOf(cod));
                            try {
                                StringBuilder sql = new StringBuilder("INSERT INTO reimpresiones (re_fac_codigo, re_descripcion, re_tipo, fecha, usu) VALUES (");
                                sql.append(cod).append(", ");
                                sql.append("'RE-IMPRESION DE BOLETA CRÉDITO','");
                                sql.append(condicion).append("',");
                                sql.append("now(),'");
                                sql.append(Login.getUsuarioLogueado()).append("')");
                                String msg = Operacion.exeOperacion(sql.toString());
                                if (msg == null) {
                                    System.out.println("la re-impresion ha sido registrada");
                                } else {
                                    System.out.println("Error en registrar la re-impresion: " + msg);
                                }
                            } catch (Exception e) {
                                Mensajes.error("Hubo un error en el registro de la re-impresión");
                            }
                        }
                    } catch (NumberFormatException e) {
                        Mensajes.informacion(e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            CabecerasTablas.consFacturas(tblFactura);
            CabecerasTablas.detalleFactura(tblDetalle);
            CabecerasTablas.limpiarTablaConsFacturas(tblFactura);
            CabecerasTablas.limpiarTablaDetalleFactura(tblDetalle);
            controlFactura.listFacturas(tblFactura, txtFechaF.getText().trim());
            Renders();
            limpiarCampos();
            Notif.NotifySuccess("Notificación del sistema", "Lista actualizada!");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarFacturas.tblFactura.getSelectedRow() < 0) {
            Notif.NotifyFail("Notificación del sistema", "No es posible procesar la operación.\r\nSeleccione la venta que desea anular.");
            //Mensajes.error("No es posible procesar la operación.\r\nSeleccione la venta que desea anular.");
        } else {
            int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
            String estado = dlgConsultarFacturas.tblFactura.getValueAt(x, 11).toString();
            if (estado.equals("ANULADO")) {
                Notif.NotifyFail("Notificación del sistema", "No es posible procesar la operación.\r\nEsta Venta ya fue anulada");
                //Mensajes.informacion("No es posible procesar la operación.\r\nEsta Venta ya fue anulada");
            } else {
                String msg;
                int rpta = Mensajes.confirmar("¿Seguro que desea Anular esta Venta?");
                if (rpta == 0) {
                    try {
                        msg = controlFactura.anularFactura();
                        if (msg == null) {
                            controlFactura.listFacturas(tblFactura, txtFechaF.getText().trim());
                            btnActualizarActionPerformed(null);
                        }
                    } catch (Exception e) {
                        System.out.println("Error anulando venta: " + e.getMessage());
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            String cod = (JOptionPane.showInputDialog("Ingrese N° de factura"));
            for (int i = 0; i < tblFactura.getRowCount(); i++) {
                if (tblFactura.getValueAt(i, 6).equals(cod)) {
                    tblFactura.changeSelection(i, 1, false, false);
                    tblFacturaMousePressed(null);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Consulta cancelada" + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void tblFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFacturaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tblFacturaKeyPressed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtRazonSocialKeyPressed

    private void txtCondicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCondicionKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCondicionKeyPressed

    private void txtPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtPagoKeyPressed

    private void txtEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtEstadoKeyPressed

    private void txtVendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVendedorKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtVendedorKeyPressed

    private void tblDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetalleKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tblDetalleKeyPressed

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

    private void panelCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMousePressed
        // TODO add your handling code here:
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_panelCabeceraMousePressed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgConsultarFacturas dialog = new dlgConsultarFacturas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgConsultarFacturas.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private org.edisoncor.gui.panel.PanelImage panelCabecera;
    public static final javax.swing.JTable tblDetalle = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static final javax.swing.JTable tblFactura = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static javax.swing.JTextField txtCodCliente;
    public static javax.swing.JTextField txtCondicion;
    public static javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaF;
    public static javax.swing.JTextField txtPago;
    public static javax.swing.JTextField txtRazonSocial;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
