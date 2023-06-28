package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.ReporteF;
import Componentes.Mensajes;
import Componentes.Operacion;
import Componentes.PrinterService;
import Componentes.RenderDecimal;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.generarCodigos;
import Componentes.traerIP;
import Controladores.CabecerasTablas;
import Controladores.ControlIngreso;
import Controladores.controlFactura;
import Datos.GestionarIngreso;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class dlgConsultarCreditos extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    public static MariaDbConnection con;
    public static MariaDbStatement st;
    public static ResultSet rss;

    public static String UsuarioL = "";
    public ReporteF jasper;
    static String emp;
    static String dir;
    static String cel;
    
    private static String ImpresoraPred;

    public dlgConsultarCreditos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        prepararBD();
        jasper = new ReporteF();
        cabe.consFacturasCreditos(tblFactura);
        controlFactura.listFacturasCreditoPendienteActivoGeneral(tblFactura);
        txtLimiteCredito.setText("0");
        DecimalFormat df = new DecimalFormat("#,###");
        txtDeudaTotal.setText(df.format(controlFactura.getTotalCreditos()));
        txtDisponible.setText("0");
        txtLimiteCreditoL.setText("");
        txtDeudaTotalL.setText("");
        Renders();
        Cant();
        Invisible();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("GESTIONAR CUENTAS PENDIENTES - TICKETS CRÉDITO");
        } else {
            this.setTitle(Software.getSoftware() + " - GESTIONAR CUENTAS PENDIENTES - TICKETS CRÉDITO");
        }
    }

    public static void Renders() {
        dlgConsultarCreditos.tblFactura.getColumnModel().getColumn(9).setCellRenderer(new RenderDecimal());
    }

    public static void Invisible() {
        txtLimiteCreditoL.setVisible(false);
        txtDeudaTotalL.setVisible(false);
        lblCodDetalle.setVisible(false);
        lblCodDetallIngreso.setVisible(false);
        lblCodCliente.setVisible(false);
        lbCodVenta.setVisible(false);
        txtImporteL.setVisible(false);
    }

    public static void prepararBD() {
        try {
            con = (MariaDbConnection) new ConexionBD().getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                st = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void lineaCredito(String cod) {
        String sql = "select cli_limitecuenta from clientes where cli_codigo=" + cod;
        try {
            rss = st.executeQuery(sql);
            rss.first();
            txtLimiteCreditoL.setText(rss.getString(1));
            DecimalFormat df = new DecimalFormat("#,###");
            txtLimiteCredito.setText(df.format(Integer.valueOf(txtLimiteCreditoL.getText().trim().replace(".", "").replace(",", ""))));
            rss.close();
        } catch (SQLException e) {
            Mensajes.error("Error consultado línea de crédito del clinte: " + e.getMessage());
        }
    }

    public static void sumarCuentas(String cod) {
        String sql = "SELECT SUM(fac_totalfinal) FROM factura WHERE clientes_cli_codigo=" + cod + " AND estado='PENDIENTE' AND fac_indicador='S'";
        try {
            rss = st.executeQuery(sql);
            rss.first();
            String cuenta=rss.getString(1);
            DecimalFormat df = new DecimalFormat("#,###");
            if(cuenta==null){
               txtDeudaTotalL.setText("0"); 
               txtDeudaTotal.setText(df.format(Integer.valueOf(txtDeudaTotalL.getText().trim().replace(".", "").replace(",", ""))));
            }else{
                txtDeudaTotalL.setText(rss.getString(1));
                txtDeudaTotal.setText(df.format(Integer.valueOf(txtDeudaTotalL.getText().trim().replace(".", "").replace(",", ""))));
            }
            rss.close();
        } catch (SQLException e) {
            Mensajes.error("Error calculando la deuda del clinte: " + e.getMessage());
        }
    }

    public static void calcularDiferencia() {
        int credito = Integer.parseInt(txtLimiteCreditoL.getText());
        int deuda = Integer.parseInt(txtDeudaTotalL.getText());
        DecimalFormat df = new DecimalFormat("#,###");
        txtDisponible.setText(df.format(Integer.valueOf(String.valueOf(credito - deuda).trim().replace(".", "").replace(",", ""))));
    }

    public static void Cant() {
        int Cantidad = dlgConsultarCreditos.tblFactura.getRowCount();
        lbCantidad.setText("Cantidad de registros filtrados: " + Cantidad);
    }

    public static void limpiarCampos() {
        txtLimiteCredito.setText("");
        txtDeudaTotal.setText("");
        txtDisponible.setText("");
    }
    
    public static void imprimirTicket_Pago() {

        try {
            
            String ip = traerIP.getIP();
            prepararBD();
            try {
                rss = st.executeQuery("SELECT * FROM v_puntoemision3 WHERE tipo='T' AND estado='Activo' AND ip='" + ip.trim() + "'");
                rss.last();
                do {
                    ImpresoraPred = rss.getString("imp_pred").trim();
                    System.out.println(ImpresoraPred);
                } while (rss.next());
                rss.close();
            } catch (SQLException ex) {
                //Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible emitir Ticket de venta.\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
            }
            try {
                prepararBD();
                String sql = "select em_razonsocial, em_direccion, em_celular from empresa where em_indicador='S'";
                rss = st.executeQuery(sql);
                try{
                    rss.first();
                    emp=rss.getString(1);
                } catch (SQLException e) {
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(0);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            //int filas = 8;
            int tamaño =25;
            printer.setOutSize(tamaño, 40);

    
            printer.printTextWrap(1, 1, 10, 40, "COMPROBANTE DE PAGO");
            printer.printTextWrap(2, 1, 1, 40, "****************************************");
            printer.printTextWrap(3, 1, 1, 40, "PAGO NRO:"+txtCodIngreso.getText());
            printer.printTextWrap(4, 1, 1, 40, "FECHA:"+Fecha.fechaFormulario());
            printer.printTextWrap(5, 1, 1, 40, "RECIBI DE:"+txtCliente.getText());
            printer.printTextWrap(6, 1, 1, 40, "GUARANIES:"+txtImporte.getText());
            printer.printTextWrap(7, 1, 1, 40, "DESCRIPCION:"+cbDetalleIngreso.getSelectedItem());
            printer.printTextWrap(8, 1, 1, 40, "EN CONCEPTO DE:");
            printer.printTextWrap(9, 1, 1, 40, printer.alinharADireita(1, txtObservacion.getText()));
            printer.printTextWrap(11, 1, 1, 40, "***************************************");
            printer.printTextWrap(14, 1, 6, 40, "----------------------------");
            printer.printTextWrap(15, 1, 10, 40, "FIRMA DEL RESPONSABLE");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("PAGO_TICKET.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("PAGO_TICKET.txt");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar Ticket: "+ex.getMessage());
            }
            if (inputStream == null) {
                return;
            }
            
            PrinterService printService = new PrinterService();
            printService.printString3(ImpresoraPred, inputStream);
            byte[] cutP = new byte[]{0x1d, 'V', 1};
            printService.printBytes2(ImpresoraPred, cutP);

            /*DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }*/

            inputStream.close();

        } catch (Exception e) {
            Mensajes.error("No se encuentra instalada la impresora predeterminada para este punto de impresión");
            //JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgRegistrarPago = new javax.swing.JDialog();
        Blanco1 = new org.edisoncor.gui.panel.PanelImage();
        Oscuro1 = new org.edisoncor.gui.panel.PanelImage();
        jPanel5 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodDetallIngreso = new javax.swing.JLabel();
        lblCodCliente = new javax.swing.JLabel();
        lbCodVenta = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dFecha = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        cbDetalleIngreso = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        txtImporteL = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtCodIngreso = new javax.swing.JTextField();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegitrarPago = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblCodDetalle = new javax.swing.JTextField();
        txtLimiteCreditoL = new javax.swing.JTextField();
        txtDeudaTotalL = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtClientes = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lbCantidad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtLimiteCredito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDisponible = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDeudaTotal = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        itemBuscarC = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        dlgRegistrarPago.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgRegistrarPago.setTitle("Registrar pago");
        dlgRegistrarPago.setResizable(false);

        Blanco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco1.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        Oscuro1.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar-F6");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMaximumSize(new java.awt.Dimension(71, 57));
        btnGuardar.setMinimumSize(new java.awt.Dimension(71, 57));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancel-Esc");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMaximumSize(new java.awt.Dimension(75, 57));
        btnCancelar.setMinimumSize(new java.awt.Dimension(75, 57));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar);

        lblCodDetallIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblCodCliente.setText(".");
        lblCodCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lbCodVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout Oscuro1Layout = new javax.swing.GroupLayout(Oscuro1);
        Oscuro1.setLayout(Oscuro1Layout);
        Oscuro1Layout.setHorizontalGroup(
            Oscuro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Oscuro1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCodDetallIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Oscuro1Layout.setVerticalGroup(
            Oscuro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Oscuro1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Oscuro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Oscuro1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbCodVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Oscuro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCodDetallIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCodCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("FECHA:");

        dFecha.setCalendarBackground(new java.awt.Color(255, 255, 255));
        dFecha.setEnabled(false);
        dFecha.setFieldFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 12));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("DESCRIPCIÓN:");

        cbDetalleIngreso.setBackground(new java.awt.Color(255, 255, 204));
        cbDetalleIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        cbDetalleIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDetalleIngresoActionPerformed(evt);
            }
        });
        cbDetalleIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbDetalleIngresoKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("CLIENTE:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("MONTO:");

        txtImporte.setEditable(false);
        txtImporte.setBackground(new java.awt.Color(255, 255, 255));
        txtImporte.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtImporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporte.setText("0");
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImporteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImporteKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("OBSERVACIÓN:");

        txtObservacion.setEditable(false);
        txtObservacion.setBackground(new java.awt.Color(255, 255, 255));
        txtObservacion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionActionPerformed(evt);
            }
        });
        txtObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionKeyTyped(evt);
            }
        });

        txtImporteL.setEditable(false);
        txtImporteL.setBackground(new java.awt.Color(255, 255, 204));
        txtImporteL.setText("0");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("MOVIMIENTO N°:");

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtCodIngreso.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtCodIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(txtImporteL, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDetalleIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(318, 318, 318))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel10)
                        .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbDetalleIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Blanco1Layout = new javax.swing.GroupLayout(Blanco1);
        Blanco1.setLayout(Blanco1Layout);
        Blanco1Layout.setHorizontalGroup(
            Blanco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
            .addGroup(Blanco1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Blanco1Layout.setVerticalGroup(
            Blanco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco1Layout.createSequentialGroup()
                .addComponent(Oscuro1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgRegistrarPagoLayout = new javax.swing.GroupLayout(dlgRegistrarPago.getContentPane());
        dlgRegistrarPago.getContentPane().setLayout(dlgRegistrarPagoLayout);
        dlgRegistrarPagoLayout.setHorizontalGroup(
            dlgRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgRegistrarPagoLayout.setVerticalGroup(
            dlgRegistrarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnImprimir.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer30.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setEnabled(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/page_refresh.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar);

        btnRegitrarPago.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnRegitrarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/dollar-icon_31870 - copia (2) - copia.png"))); // NOI18N
        btnRegitrarPago.setText("REGISTRAR PAGO");
        btnRegitrarPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegitrarPago.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegitrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegitrarPagoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegitrarPago);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setPreferredSize(new java.awt.Dimension(53, 47));
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);

        javax.swing.GroupLayout OscuroLayout = new javax.swing.GroupLayout(Oscuro);
        Oscuro.setLayout(OscuroLayout);
        OscuroLayout.setHorizontalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(txtLimiteCreditoL, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDeudaTotalL)
                .addGap(17, 17, 17))
        );
        OscuroLayout.setVerticalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLimiteCreditoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDeudaTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("FILTRAR EXTRACTO:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtClientes.setEditable(false);
        txtClientes.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        btnBuscarCliente.setToolTipText("");
        btnBuscarCliente.setOpaque(false);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtClientes)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnBuscarCliente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnGenerar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(17, 35, 46));
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        btnGenerar.setText("GENERAR");
        btnGenerar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jScrollPane1.setOpaque(false);

        tblFactura.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
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
        tblFactura.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblFactura.setOpaque(false);
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
        jScrollPane1.setViewportView(tblFactura);

        lbCantidad.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        lbCantidad.setText("Cantidad de registros filtrados:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 35, 46));
        jLabel4.setText("Línea de crédito:");

        txtLimiteCredito.setEditable(false);
        txtLimiteCredito.setBackground(new java.awt.Color(255, 255, 255));
        txtLimiteCredito.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtLimiteCredito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimiteCredito.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(17, 35, 46));
        jLabel5.setText("Crédito disponible:");

        txtDisponible.setEditable(false);
        txtDisponible.setBackground(new java.awt.Color(255, 255, 255));
        txtDisponible.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDisponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDisponible.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(17, 35, 46));
        jLabel7.setText("Deuda total:");

        txtDeudaTotal.setEditable(false);
        txtDeudaTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtDeudaTotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDeudaTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeudaTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDeudaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDeudaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BlancoLayout.createSequentialGroup()
                        .addComponent(lbCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BlancoLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidad))
                .addContainerGap())
        );

        jMenu2.setText("OPCIONES");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemBuscarC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemBuscarC.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer15.png"))); // NOI18N
        itemBuscarC.setText("IMPRIMIR EXTRACTO                          ");
        itemBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarCActionPerformed(evt);
            }
        });
        jMenu2.add(itemBuscarC);
        jMenu2.add(jSeparator5);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("SALIR");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu2.add(itemSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llamarReporteFactura() {
        ReporteF gr;
        gr = new ReporteF();
        //int codF = Integer.parseInt(txtCodFactura.getText());
        //gr.MostrarReporteConParametro(System.getProperty("user.dir")+"/Reportes/Facturas/Factura.jasper", "Factura de Venta", codF,"Facturas/Fact-"+codF+".pdf");
        //gr.cerrar();
    }
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarCreditos.tblFactura.getSelectedRow() < 0) {
            Mensajes.error("Seleccione una fila de la tabla");
        } else {
            int x = dlgConsultarCreditos.tblFactura.getSelectedRow();
            String estado = dlgConsultarCreditos.tblFactura.getValueAt(x, 11).toString();
            if (estado.equals("ANULADO")) {
                Mensajes.informacion("VENTA ANULADA: Imposible realizar la re-impresión");
            } else {
                int rpta = Mensajes.confirmar("¿Seguro que desea re-imprimir la venta?");
                if (rpta == 0) {
                    try {
                        String cod = dlgConsultarCreditos.tblFactura.getValueAt(x, 0).toString();
                        String fecha = dlgConsultarCreditos.tblFactura.getValueAt(x, 2).toString();
                        String hora = dlgConsultarCreditos.tblFactura.getValueAt(x, 3).toString();
                        String fact = dlgConsultarCreditos.tblFactura.getValueAt(x, 6).toString();
                        String caja = dlgConsultarCreditos.tblFactura.getValueAt(x, 5).toString();
                        String condicion = dlgConsultarCreditos.tblFactura.getValueAt(x, 7).toString();
                        String total = dlgConsultarCreditos.tblFactura.getValueAt(x, 9).toString();
                        if (condicion.equals("CONTADO")) {
                            //imprimirTicket(fecha, hora, fact, caja, condicion, total);
                            try {
                                UsuarioL = Login.getUsuarioLogueado();
                                StringBuilder sql = new StringBuilder("INSERT INTO reimpresiones (re_fac_codigo, re_descripcion, re_tipo, fecha, usuario) VALUES (");
                                sql.append(cod).append(", ");
                                sql.append("'RE-IMPRESION DE TICKET','");
                                sql.append(condicion).append("',");
                                sql.append("now(),'");
                                sql.append(UsuarioL).append("')");
                                String msg = Operacion.exeOperacion(sql.toString());
                                if (msg == null) {
                                    System.out.println("la re-impresion ha sido registrada");
                                } else {
                                    System.out.println("Error en registrar la re-impresion: " + msg);
                                }
                            } catch (Exception e) {
                                Mensajes.error("Hubo un error en el registro de la re-impresión");
                            }

                        } else {
                            jasper.BoletaCreditoRE("\\Reports\\ventas\\venta_credito_reimpresion.jasper", "cod", Integer.parseInt(cod));
                            try {
                                UsuarioL = Login.getUsuarioLogueado();
                                StringBuilder sql = new StringBuilder("INSERT INTO reimpresiones (re_fac_codigo, re_descripcion, re_tipo, fecha, usuario) VALUES (");
                                sql.append(cod).append(", ");
                                sql.append("'RE-IMPRESION DE BOLETA CRÉDITO','");
                                sql.append(condicion).append("',");
                                sql.append("now(),'");
                                sql.append(UsuarioL).append("')");
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
                    } catch (Exception e) {
                        Mensajes.informacion(e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            btnRegitrarPagoActionPerformed(null);
        }
    }//GEN-LAST:event_tblFacturaMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblFacturaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblFacturaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturaPropertyChange

    private void tblFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturaMousePressed

    private void itemBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarCActionPerformed
        // TODO add your handling code here:
        btnImprimirActionPerformed(null);
    }//GEN-LAST:event_itemBuscarCActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        if(lblCodDetalle.getText().isEmpty()){
           Mensajes.informacion("No se puede Generar el filtrado.\nBusque y seleccione un cliente para organizar los datos.");
        }else{
            CabecerasTablas.limpiarTablas(tblFactura);
            cabe.consFacturasCreditos(tblFactura);
            controlFactura.listFacturasCreditoPendienteActivo(tblFactura, lblCodDetalle.getText());
            Renders();
            lineaCredito(lblCodDetalle.getText());
            sumarCuentas(lblCodDetalle.getText());
            calcularDiferencia();
        }
        Cant();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tblFactura);
        cabe.consFacturasCreditos(tblFactura);
        controlFactura.listFacturasCreditoPendienteActivoGeneral(tblFactura);
        txtLimiteCredito.setText("0");
        DecimalFormat df = new DecimalFormat("#,###");
        txtDeudaTotal.setText(df.format(controlFactura.getTotalCreditos()));
        txtDisponible.setText("0");
        txtLimiteCreditoL.setText("");
        txtDeudaTotalL.setText("");
        lblCodDetalle.setText("");
        txtClientes.setText("");
        Renders();
        Cant();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (lblCodDetallIngreso.getText().isEmpty()) {
            Mensajes.error("Seleccione una Descripcion");
            cbDetalleIngreso.requestFocus();
            cbDetalleIngreso.setPopupVisible(true);
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(dlgRegistrarPago, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    ControlIngreso.addPago();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
            btnCancelarActionPerformed(null);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        cbDetalleIngreso.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCancelar.setEnabled(false);
        dlgRegistrarPago.dispose();
        if(lblCodDetalle.getText().isEmpty()){
            btnActualizarActionPerformed(null);
        }else{
            btnGenerarActionPerformed(null);
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbDetalleIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDetalleIngresoActionPerformed
        // TODO add your handling code here:
        if (cbDetalleIngreso.getSelectedIndex() == 0) {
            lblCodDetallIngreso.setText("");
        } else {
            String cod = cargarComboBox.getCodidgo(cbDetalleIngreso);
            lblCodDetallIngreso.setText(cod);
        }
    }//GEN-LAST:event_cbDetalleIngresoActionPerformed

    private void cbDetalleIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbDetalleIngresoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDetalleIngresoKeyPressed

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed

    }//GEN-LAST:event_txtImporteActionPerformed

    private void txtImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImporteKeyPressed

    private void txtImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyReleased
        // TODO add your handling code here
    }//GEN-LAST:event_txtImporteKeyReleased

    private void txtObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionActionPerformed
        // TODO add your handling code here:
        if (txtObservacion.getText().isEmpty()) {
            Mensajes.error("Ingrese una Observacion con relacion al registro");
            txtObservacion.requestFocus();
            txtObservacion.selectAll();
        } else {
            btnGuardar.doClick();
        }
    }//GEN-LAST:event_txtObservacionActionPerformed

    private void txtObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtObservacionKeyTyped

    private void btnRegitrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegitrarPagoActionPerformed
        // TODO add your handling code here:
        if (dlgConsultarCreditos.tblFactura.getSelectedRow() < 0) {
            Mensajes.error("Seleccione una fila de la tabla");
        } else {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar pagos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                int x = dlgConsultarCreditos.tblFactura.getSelectedRow();
                String estado = dlgConsultarCreditos.tblFactura.getValueAt(x, 11).toString();
                String pago = dlgConsultarCreditos.tblFactura.getValueAt(x, 8).toString();
                if (estado.equals("ANULADO")) {
                    Mensajes.informacion("VENTA ANULADA: No es posible regitrar un pago");
                }else if (pago.equals("ABONADO")) {
                    Mensajes.informacion("VENTA PAGADA: No es posible regitrar un pago");
                } else {
                    int rpta = Mensajes.confirmar("¿Seguro que desea Registrar el pago de este Ticket?");
                    if (rpta == 0) {
                        try {
                            try {
                                String FechaI = String.valueOf(Fecha.fechaCorrecta());
                                txtCaja.setText(generarCodigos.ObtenerCodigo("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            txtCodIngreso.setText(GestionarIngreso.getCodigo());
                            lbCodVenta.setText(dlgConsultarCreditos.tblFactura.getValueAt(x, 0).toString());
                            lblCodCliente.setText(dlgConsultarCreditos.tblFactura.getValueAt(x, 4).toString());
                            txtCliente.setText(dlgConsultarCreditos.tblFactura.getValueAt(x, 1).toString());
                            String fact = dlgConsultarCreditos.tblFactura.getValueAt(x, 6).toString();
                            String caja = dlgConsultarCreditos.tblFactura.getValueAt(x, 5).toString();
                            String fecha = dlgConsultarCreditos.tblFactura.getValueAt(x, 2).toString();
                            cargarComboBox.cargar(cbDetalleIngreso, "SELECT di_codigo,di_descripcion FROM detalleingreso WHERE di_indicador='S'");
                            //txtObservacion.setText("OPER.N°:"+lbCodVenta.getText()+", TICKET N°:" + fact + ", MOV. N°:" + caja + ", FECHA:" + fecha);
                            txtObservacion.setText("PAGO DE TICKET CREDITO N°:" + fact + " DE LA FECHA:" + Fecha.formatoFechaMuestra(fecha));
                            DecimalFormat df = new DecimalFormat("#,###");
                            txtImporte.setText(df.format(Integer.valueOf(dlgConsultarCreditos.tblFactura.getValueAt(x, 9).toString().trim().replace(".", "").replace(",", ""))));
                            txtImporteL.setText(dlgConsultarCreditos.tblFactura.getValueAt(x, 9).toString());

                            dlgRegistrarPago.setSize(595, 305);
                            dlgRegistrarPago.setLocationRelativeTo(this);
                            dlgRegistrarPago.setModal(true);

                            cbDetalleIngreso.setEnabled(true);
                            btnGuardar.setEnabled(true);
                            btnCancelar.setEnabled(true);

                            cbDetalleIngreso.requestFocus();
                            dlgRegistrarPago.setVisible(true);
                        } catch (Exception e) {

                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_btnRegitrarPagoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarCliente1 bcliente = new dlgBuscarCliente1(null, true);
            bcliente.setLocationRelativeTo(null);
            bcliente.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(dlgConsultarCreditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarCreditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarCreditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarCreditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgConsultarCreditos dialog = new dlgConsultarCreditos(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private org.edisoncor.gui.panel.PanelImage Blanco1;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private org.edisoncor.gui.panel.PanelImage Oscuro1;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarCliente;
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegitrarPago;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox cbDetalleIngreso;
    public static datechooser.beans.DateChooserCombo dFecha;
    public static javax.swing.JDialog dlgRegistrarPago;
    private javax.swing.JMenuItem itemBuscarC;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    public static javax.swing.JLabel lbCantidad;
    public static javax.swing.JLabel lbCodVenta;
    public static javax.swing.JLabel lblCodCliente;
    public static javax.swing.JLabel lblCodDetallIngreso;
    public static javax.swing.JTextField lblCodDetalle;
    public static javax.swing.JTable tblFactura;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtClientes;
    public static javax.swing.JTextField txtCodIngreso;
    public static javax.swing.JTextField txtDeudaTotal;
    public static javax.swing.JTextField txtDeudaTotalL;
    public static javax.swing.JTextField txtDisponible;
    public static javax.swing.JTextField txtImporte;
    public static javax.swing.JTextField txtImporteL;
    public static javax.swing.JTextField txtLimiteCredito;
    public static javax.swing.JTextField txtLimiteCreditoL;
    public static javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
