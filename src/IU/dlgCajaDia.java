package IU;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.PrinterService;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.traerIP;
import Controladores.ControlCaja;
import Datos.GestionarCaja;
import Modelo.Caja;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public final class dlgCajaDia extends javax.swing.JDialog {

    public String NCaja;
    public static int ING;
    public static int GAS;
    public int INI;
    static String hora;
    static String fecha;
    static String usuF;
    static String estado;
    private static String ImpresoraPred;
    static DecimalFormat df;
    static DataSourceService dss = new DataSourceService();

    public dlgCajaDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        df = new DecimalFormat("#,###");
        try {
            NCaja = (generarCodigos.ObtenerCodigo("SELECT ca_id from caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1"));
            System.out.println("N CAja hoy: " + NCaja);
            Caja caj = GestionarCaja.busCaja(NCaja);
            lbInicial.setText(df.format(caj.getCaInicial()));
            txtEntregado.setText(df.format(caj.getCaEntregado()));
            INI = ((caj.getCaInicial()));
            lbNCaja.setText(String.valueOf(caj.getCaId()));
            lbApertura.setText(String.valueOf(Fecha.formatoFechaMuestra(caj.getFechaI()) + " " + Fecha.formatoHoraMuestra(caj.getHoraI())));
            lbUsuI.setText(String.valueOf(caj.getUsuarioI()));
            if (caj.getIndicador().equals("S")) {
                lbEstado.setText("ABIERTO");
            } else {
                lbEstado.setText("CERRADO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        totalVentasCont();
        totalVentasCred();
        totalCompraCont();
        totalCompraCred();
        totalGasto();
        totalIngreso();
        ingresoTotal();
        totalCaja();
        calcularDif();
    }

    private static void calcularDif() {

        if (Integer.parseInt(lblEntregar.getText().trim().replace(".", "").replace(",", "")) >= 0) {
            int entregar = Integer.parseInt(lblEntregar.getText().trim().replace(".", "").replace(",", ""));
            int entregado = Integer.parseInt(txtEntregado.getText().trim().replace(".", "").replace(",", ""));
            int diferencia;

            diferencia = entregado - entregar;
            lblDiferencia.setText(df.format(diferencia));
        }
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("VISOR DE VALORES - MOVIMIENTOS DEL DÍA");
        } else {
            this.setTitle(Software.getSoftware() + " - VISOR DE VALORES - MOVIMIENTOS DEL DÍA");
        }
    }

    public static void imprimirCierre() {
        String ip = traerIP.getIP();
        String sql = "SELECT * FROM v_puntoemision3 WHERE tipo='T' AND estado='Activo' AND ip='" + ip.trim() + "'";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            rs.last();
            do {
                ImpresoraPred = rs.getString("imp_pred").trim();
                System.out.println(ImpresoraPred);
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            //Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible emitir Ticket de venta.\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
        }

        try {
            String sql2 = "SELECT caja.ca_fechafin, caja.ca_horafin, caja.ca_usuariocierre, caja.ca_indicador from caja WHERE ca_id=" + lbNCaja.getText();
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql2)) {
                rs.first();
                if (rs.getString(4).equals("N")) {
                    fecha = rs.getString(1);
                    hora = rs.getString(2);
                    usuF = rs.getString(3);
                    estado = "CERRADO";
                } else {
                    fecha = "";
                    hora = "";
                    usuF = "";
                    estado = "ABIERTO";
                }
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(0);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            //int filas = 8;
            int tamaño = 40;
            printer.setOutSize(tamaño, 40);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(1, 1, 12, 40, "TICKET DE CIERRE");
            printer.printTextWrap(2, 1, 1, 40, "****************************************");
            printer.printTextWrap(3, 1, 1, 40, "APERTURADO POR: " + lbUsuI.getText());
            printer.printTextWrap(4, 1, 1, 40, "FECHA: " + lbApertura.getText());
            printer.printTextWrap(5, 1, 1, 40, "****************************************");
            printer.printTextWrap(6, 1, 1, 40, "CERRADO POR: " + usuF);
            printer.printTextWrap(7, 1, 1, 40, "FECHA: " + Fecha.formatoFechaMuestra(fecha) + " " + Fecha.formatoHoraMuestra(hora));
            printer.printTextWrap(8, 1, 1, 40, "****************************************");
            printer.printTextWrap(9, 1, 1, 40, "CAJA N°: " + lbNCaja.getText());
            printer.printTextWrap(10, 1, 1, 40, "CAJA BASE:" + lbInicial.getText());
            printer.printTextWrap(11, 1, 1, 40, "VALOR A ENTREGAR:" + lblEntregar.getText());
            printer.printTextWrap(12, 1, 1, 40, "VALOR ENTREGADO:" + txtEntregado.getText());
            printer.printTextWrap(13, 1, 1, 40, "DIFERENCIA:" + lblDiferencia.getText());
            printer.printTextWrap(14, 1, 1, 40, "ESTADO: " + estado);
            printer.printTextWrap(15, 1, 1, 40, "---------------------------------------");
            printer.printTextWrap(16, 1, 8, 40, "DETALLES DE MOVIMIENTOS");
            printer.printTextWrap(17, 1, 1, 40, "---------------------------------------");
            printer.printTextWrap(18, 1, 14, 40, "INGRESOS:");
            printer.printTextWrap(19, 1, 1, 40, "VENTAS CONTADO: " + txtTicketContado.getText());
            printer.printTextWrap(20, 1, 1, 40, "COBRANZAS Y OTROS INGRESOS: " + txtIngresos.getText());
            printer.printTextWrap(21, 1, 1, 40, "VENTAS CREDITO: " + txtTotalVentasC.getText());
            printer.printTextWrap(23, 1, 10, 28, "TOTAL DE INGRESOS:");
            printer.printTextWrap(23, 1, 29, 40, txtTotalIngresos.getText());
            printer.printTextWrap(24, 1, 1, 40, "---------------------------------------");
            printer.printTextWrap(25, 1, 14, 40, "EGRESOS:");
            printer.printTextWrap(26, 1, 1, 40, "COMPRAS CONTADO: " + txtTotalCompra.getText());
            printer.printTextWrap(27, 1, 1, 40, "PAGOS Y RETIROS: " + txtTotalGastos.getText());
            printer.printTextWrap(28, 1, 1, 40, "COMPRAS CREDITO: " + txtTotalCompraC.getText());
            printer.printTextWrap(29, 1, 1, 40, "---------------------------------------");
            printer.printTextWrap(32, 1, 6, 35, "_____________________________");
            printer.printTextWrap(33, 1, 10, 32, "FIRMA DEL RESPONSABLE");
            printer.printTextWrap(34, 1, 1, 40, "");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("CIERRE_CAJA.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("CIERRE_CAJA.txt");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar cierre: " + ex.getMessage());
            }
            if (inputStream == null) {
                return;
            }

            PrinterService printService = new PrinterService();
            printService.printString3(ImpresoraPred, inputStream);
            byte[] cutP = new byte[]{0x1d, 'V', 1};
            printService.printBytes2(ImpresoraPred, cutP);


            /* DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
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
            }
             */
            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (Exception e) {
            Mensajes.error("No se encuentra instalada la impresora predeterminada para este punto de impresión");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel3 = new javax.swing.JPanel();
        txtTotalCompra = new javax.swing.JTextField();
        txtTotalGastos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotalCompraC = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbApertura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbUsuI = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbNCaja = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblEntregar = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEntregado = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lblDiferencia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbInicial = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txtTicketContado = new javax.swing.JTextField();
        txtIngresos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTotalIngresos = new javax.swing.JTextField();
        txtTotalVentasC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel7 = new javax.swing.JPanel();
        PnlNuevo = new rojeru_san.rspanel.RSPanelImage();
        btnCerrar = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PnlGuardar = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        btnSalir1 = new RSMaterialComponent.RSButtonIconUno();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompra.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompra.setText("0");
        txtTotalCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 76, 100, 23));

        txtTotalGastos.setEditable(false);
        txtTotalGastos.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalGastos.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalGastos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalGastos.setText("0");
        txtTotalGastos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtTotalGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 14, 100, 23));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("COMPRAS A CONTADO:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 76, 218, 23));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("PAGOS Y/O RETIROS:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 222, 23));

        txtTotalCompraC.setEditable(false);
        txtTotalCompraC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompraC.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalCompraC.setForeground(new java.awt.Color(0, 0, 102));
        txtTotalCompraC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompraC.setText("0");
        txtTotalCompraC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtTotalCompraC, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 106, 100, 23));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("COMPRAS A CRÉDITO:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 106, -1, 23));

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATOS A CONSIDERAR");
        jLabel3.setOpaque(true);
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 45, 350, 24));

        Blanco.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 290, 361, 135));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 35, 46));
        jLabel4.setText("FECHA Y HORA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 80, 114, -1));

        lbApertura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbApertura.setText("FECHA Y HORA");
        jPanel1.add(lbApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 80, 147, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(17, 35, 46));
        jLabel1.setText("ABIERTO POR:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 102, 114, -1));

        lbUsuI.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbUsuI.setText("USUARIO");
        jPanel1.add(lbUsuI, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 102, 147, -1));

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(17, 35, 46));
        jLabel19.setText("ESTADO ACTUAL:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 124, 114, -1));

        lbEstado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(0, 153, 0));
        lbEstado.setText("ESTADO");
        jPanel1.add(lbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 124, 147, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 102, 0));
        jLabel16.setText("MOVIMIENTO DIARIO N°");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 42, -1, -1));

        lbNCaja.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbNCaja.setForeground(new java.awt.Color(255, 102, 0));
        lbNCaja.setText("NCAJA");
        jPanel1.add(lbNCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 42, 79, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel17.setText("EFECTIVO A ENTREGAR");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 46, 160, 30));

        lblEntregar.setBackground(new java.awt.Color(255, 255, 255));
        lblEntregar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblEntregar.setForeground(new java.awt.Color(0, 153, 0));
        lblEntregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntregar.setText("0");
        lblEntregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblEntregar.setOpaque(true);
        jPanel4.add(lblEntregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 45, 136, 31));

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel18.setText("EFECTIVO ENTREGADO");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 78, 160, 30));

        txtEntregado.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtEntregado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEntregado.setText("0");
        txtEntregado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntregadoActionPerformed(evt);
            }
        });
        txtEntregado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEntregadoKeyReleased(evt);
            }
        });
        jPanel4.add(txtEntregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 78, 136, 30));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel20.setText("DIFERENCIA");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 111, 160, 30));

        lblDiferencia.setBackground(new java.awt.Color(255, 255, 255));
        lblDiferencia.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblDiferencia.setForeground(new java.awt.Color(205, 0, 0));
        lblDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiferencia.setText("0");
        lblDiferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblDiferencia.setOpaque(true);
        jPanel4.add(lblDiferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 111, 136, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" VALOR DE LA CAJA BASE INICIALIZADO");
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 5, 242, 25));

        lbInicial.setBackground(new java.awt.Color(255, 255, 255));
        lbInicial.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbInicial.setForeground(new java.awt.Color(0, 153, 255));
        lbInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInicial.setText("0");
        lbInicial.setOpaque(true);
        jPanel4.add(lbInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 5, 155, 25));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 380, 2));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 400, 150));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 759, 170));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTicketContado.setEditable(false);
        txtTicketContado.setBackground(new java.awt.Color(255, 255, 255));
        txtTicketContado.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTicketContado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTicketContado.setText("0");
        txtTicketContado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtTicketContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 7, 100, 23));

        txtIngresos.setEditable(false);
        txtIngresos.setBackground(new java.awt.Color(255, 255, 255));
        txtIngresos.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtIngresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIngresos.setText("0");
        txtIngresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 37, 100, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("TOTAL DE VENTAS A CONTADO:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 242, 23));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("COBRANZAS Y OTROS INGRESOS:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, 242, 23));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setText("MONTO TOTAL  DE INGRESOS EN  LA CAJA:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 67, -1, 23));

        txtTotalIngresos.setEditable(false);
        txtTotalIngresos.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalIngresos.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalIngresos.setForeground(new java.awt.Color(0, 153, 0));
        txtTotalIngresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalIngresos.setText("0");
        txtTotalIngresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtTotalIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 67, 100, 23));

        txtTotalVentasC.setEditable(false);
        txtTotalVentasC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVentasC.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalVentasC.setForeground(new java.awt.Color(0, 0, 102));
        txtTotalVentasC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalVentasC.setText("0");
        txtTotalVentasC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtTotalVentasC, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 104, 100, 23));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("PARA CONSIDERAR: VENTAS A CRÉDITO:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 104, 258, 23));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 97, 363, 7));

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 390, 135));

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(0, 102, 0));
        btnCerrar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCerrar.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnCerrar.setRippleColor(java.awt.Color.white);
        btnCerrar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        PnlNuevo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador1.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("FINALIZAR");
        PnlNuevo.add(LabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel7.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlGuardar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRippleColor(java.awt.Color.white);
        btnGuardar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PnlGuardar.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador3.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("REGISTRAR");
        PnlGuardar.add(LabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel7.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        Oscuro.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        btnSalir1.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir1.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.setRippleColor(java.awt.Color.white);
        btnSalir1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        Oscuro.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 3, 20, 20));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 777, 105));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void totalVentasCont() {
        int V_TICKET, V_FACTURA;
        try {
            V_TICKET = Integer.parseInt(generarCodigos.getDecimales("SELECT IFNULL((select SUM(fac_totalfinal) from factura where caja_ca_id = " + NCaja + " and fac_indicador='S' and fac_tipoventa='CONTADO'),0)"));
        } catch (NumberFormatException e) {
            V_TICKET = 0;
        }
        try {
            V_FACTURA = Integer.parseInt(generarCodigos.getDecimales("SELECT IFNULL((select SUM(fac_totalfinal) from factura_l where caja_ca_id = " + NCaja + " and fac_indicador='S' and fac_tipoventa='CONTADO'),0)"));
        } catch (NumberFormatException e) {
            V_FACTURA = 0;
        }
        int TOTALVENTA = (V_TICKET + V_FACTURA);
        txtTicketContado.setText(df.format(TOTALVENTA));
    }

    void totalVentasCred() {
        int V_TICKET, V_FACTURA;
        try {
            V_TICKET = Integer.parseInt(generarCodigos.getDecimales("SELECT IFNULL((select SUM(fac_totalfinal) from factura where caja_ca_id = " + NCaja + " and fac_indicador='S' and fac_tipoventa='CREDITO'),0)"));
        } catch (NumberFormatException e) {
            V_TICKET = 0;
        }
        try {
            V_FACTURA = Integer.parseInt(generarCodigos.getDecimales("SELECT IFNULL((select SUM(fac_totalfinal) from factura_l where caja_ca_id = " + NCaja + " and fac_indicador='S' and fac_tipoventa='CREDITO'),0)"));
        } catch (NumberFormatException e) {
            V_FACTURA = 0;
        }
        int TOTALVENTA = (V_TICKET + V_FACTURA);
        txtTotalVentasC.setText(df.format(TOTALVENTA));
    }

    void totalCompraCont() {
        try {
            String TotalCompra = (generarCodigos.getDecimales("SELECT IFNULL((select SUM(com_total) from compra where caja_ca_id = " + NCaja + " and com_indicador='S' and com_condpago='CONTADO'),0)"));
            txtTotalCompra.setText(df.format(Integer.valueOf((TotalCompra.trim().replace(".", "").replace(",", "")))));
        } catch (NumberFormatException e) {
            txtTotalCompra.setText("0");
        }

    }

    void totalCompraCred() {
        try {
            String TotalCompra = (generarCodigos.getDecimales("SELECT IFNULL((select SUM(com_total) from compra where caja_ca_id = " + NCaja + " and com_indicador='S' and com_condpago='CREDITO'),0)"));
            txtTotalCompraC.setText(df.format(Integer.valueOf((TotalCompra.trim().replace(".", "").replace(",", "")))));
        } catch (NumberFormatException e) {
            txtTotalCompraC.setText("0");
        }

    }

    void totalGasto() {
        try {
            String TotalGasto = (generarCodigos.getDecimales("SELECT IFNULL((select SUM(ga_importe) from gastos where caja_ca_id = " + NCaja + " and ga_indicador='S'),0)"));
            GAS = Integer.parseInt(TotalGasto);
            txtTotalGastos.setText(df.format(Integer.valueOf((TotalGasto.trim().replace(".", "").replace(",", "")))));
        } catch (NumberFormatException e) {
            txtTotalGastos.setText("0");
        }
    }

    void totalIngreso() {
        try {
            String TotalIngreso = (generarCodigos.getDecimales("SELECT IFNULL((select SUM(ing_importe) from ingreso where caja_ca_id = " + NCaja + " and ing_indicador='S'),0)"));
            txtIngresos.setText(df.format(Integer.valueOf((TotalIngreso.trim().replace(".", "").replace(",", "")))));
        } catch (NumberFormatException e) {
            txtIngresos.setText("0");
        }

    }

    static void ingresoTotal() {
        try {
            int ticket = Integer.parseInt(txtTicketContado.getText().trim().replace(",", "").replace(".", ""));
            int ingreso = Integer.parseInt(txtIngresos.getText().trim().replace(",", "").replace(".", ""));
            int ingresoTotal = (ticket + ingreso);

            ING = (ingresoTotal);
            txtTotalIngresos.setText((df.format(ingresoTotal)));
        } catch (NumberFormatException e) {
            txtTotalIngresos.setText("0");
        }
    }

    void totalCaja() {
        int totalCaja = (ING - GAS);
        String FINAL = (String.valueOf((totalCaja)));
        lblEntregar.setText(df.format(Integer.valueOf((FINAL.trim().replace(".", "").replace(",", "")))));
    }
    private void txtEntregadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntregadoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtEntregado.getText().trim().length() >= 1) {
                txtEntregado.setText(df.format(Integer.valueOf(txtEntregado.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtEntregado.setText("0");
                txtEntregado.selectAll();

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
        calcularDif();
    }//GEN-LAST:event_txtEntregadoKeyReleased

    private void txtEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntregadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntregadoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtEntregado.getText().trim().replace(".", "").replace(",", "")) <= 0) {
            Mensajes.error("No se puede proceder a cerrar la caja.\nDebe de espeficicar el EFECTIVO ENTREGADO.");
        } else {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Cerrar la Caja y finalizar las operaciones?", "Cierre de caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    ControlCaja.delCaja();
                    btnCerrar.setEnabled(false);
                    btnGuardar.setEnabled(false);
                    txtEntregado.setEnabled(false);
                    try {
                        Caja caj = GestionarCaja.busCaja(lbNCaja.getText().trim());
                        if (caj.getIndicador().equals("S")) {
                            lbEstado.setText("ABIERTO");
                        } else {
                            lbEstado.setText("CERRADO");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    imprimirCierre();
                } catch (Exception e) {
                    Mensajes.error(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Guardar estos valores?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            try {
                ControlCaja.actCaja();
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCajaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgCajaDia dialog = new dlgCajaDia(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo3;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador3;
    private RSMaterialComponent.RSButtonIconUno btnCerrar;
    private RSMaterialComponent.RSButtonIconUno btnGuardar;
    private RSMaterialComponent.RSButtonIconUno btnSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private static javax.swing.JLabel lbApertura;
    public static javax.swing.JLabel lbEstado;
    private static javax.swing.JLabel lbInicial;
    public static javax.swing.JLabel lbNCaja;
    private static javax.swing.JLabel lbUsuI;
    public static javax.swing.JLabel lblDiferencia;
    public static javax.swing.JLabel lblEntregar;
    public static javax.swing.JTextField txtEntregado;
    private static javax.swing.JTextField txtIngresos;
    private static javax.swing.JTextField txtTicketContado;
    private static javax.swing.JTextField txtTotalCompra;
    private static javax.swing.JTextField txtTotalCompraC;
    private static javax.swing.JTextField txtTotalGastos;
    private static javax.swing.JTextField txtTotalIngresos;
    private static javax.swing.JTextField txtTotalVentasC;
    // End of variables declaration//GEN-END:variables
}
