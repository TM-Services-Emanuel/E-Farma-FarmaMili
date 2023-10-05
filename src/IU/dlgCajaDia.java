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
            int diferencia = 0;

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
        jPanel6 = new javax.swing.JPanel();
        lbInicial = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        barMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompra.setText("0");

        txtTotalGastos.setEditable(false);
        txtTotalGastos.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalGastos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalGastos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalGastos.setText("0");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("COMPRAS A CONTADO:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("PAGOS Y/O RETIROS:");

        txtTotalCompraC.setEditable(false);
        txtTotalCompraC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompraC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalCompraC.setForeground(new java.awt.Color(0, 0, 102));
        txtTotalCompraC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompraC.setText("0");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("COMPRAS A CRÉDITO:");

        jLabel3.setBackground(new java.awt.Color(17, 35, 46));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATOS A CONSIDERAR");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotalCompraC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCompraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 35, 46));
        jLabel4.setText("FECHA Y HORA:");

        lbApertura.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbApertura.setText("FECHA Y HORA");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(17, 35, 46));
        jLabel1.setText("ABIERTO POR:");

        lbUsuI.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbUsuI.setText("USUARIO");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(17, 35, 46));
        jLabel19.setText("ESTADO ACTUAL:");

        lbEstado.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(0, 153, 0));
        lbEstado.setText("ESTADO");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(17, 35, 46));
        jLabel16.setText("MOVIMIENTO DIARIO N°");

        lbNCaja.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbNCaja.setForeground(new java.awt.Color(17, 35, 46));
        lbNCaja.setText("NCAJA");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel4.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("EFECTIVO A ENTREGAR");

        lblEntregar.setBackground(new java.awt.Color(255, 255, 255));
        lblEntregar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblEntregar.setForeground(new java.awt.Color(0, 153, 0));
        lblEntregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntregar.setText("0");
        lblEntregar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblEntregar.setOpaque(true);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("EFECTIVO ENTREGADO");

        txtEntregado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtEntregado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEntregado.setText("0");
        txtEntregado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("DIFERENCIA");

        lblDiferencia.setBackground(new java.awt.Color(255, 255, 255));
        lblDiferencia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblDiferencia.setForeground(new java.awt.Color(205, 0, 0));
        lblDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiferencia.setText("0");
        lblDiferencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblDiferencia.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEntregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEntregado, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(lblDiferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEntregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntregado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDiferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setOpaque(false);

        lbInicial.setBackground(new java.awt.Color(17, 35, 46));
        lbInicial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbInicial.setForeground(new java.awt.Color(255, 255, 255));
        lbInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInicial.setText("0");
        lbInicial.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(17, 35, 46));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" VALOR DE LA CAJA BASE INICIALIZADO");
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbUsuI, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbApertura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbUsuI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lbEstado)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        txtTicketContado.setEditable(false);
        txtTicketContado.setBackground(new java.awt.Color(255, 255, 255));
        txtTicketContado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTicketContado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTicketContado.setText("0");

        txtIngresos.setEditable(false);
        txtIngresos.setBackground(new java.awt.Color(255, 255, 255));
        txtIngresos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIngresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIngresos.setText("0");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("TOTAL DE VENTAS A CONTADO:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("COBRANZAS Y OTROS INGRESOS:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("MONTO TOTAL  DE INGRESOS EN  LA CAJA:");

        txtTotalIngresos.setEditable(false);
        txtTotalIngresos.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalIngresos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalIngresos.setForeground(new java.awt.Color(0, 153, 0));
        txtTotalIngresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalIngresos.setText("0");

        txtTotalVentasC.setEditable(false);
        txtTotalVentasC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVentasC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalVentasC.setForeground(new java.awt.Color(0, 0, 102));
        txtTotalVentasC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalVentasC.setText("0");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("PARA CONSIDERAR: VENTAS A CRÉDITO:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVentasC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTicketContado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTicketContado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalVentasC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 9));

        btnCerrar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icon-cerrarcaja.png"))); // NOI18N
        btnCerrar.setText("CERRAR CAJA");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCerrar);

        btnImprimir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer30.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setEnabled(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerifyInputWhenFocusTarget(false);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel5.add(btnImprimir);

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
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

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir);

        javax.swing.GroupLayout OscuroLayout = new javax.swing.GroupLayout(Oscuro);
        Oscuro.setLayout(OscuroLayout);
        OscuroLayout.setHorizontalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OscuroLayout.setVerticalGroup(
            OscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OscuroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Oscuro, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BlancoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(Oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setText("OPCIONES");
        menuOpciones.setFocusable(false);
        menuOpciones.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        menuOpciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itemNuevo.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("CARRAR CAJA");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuOpciones.add(itemNuevo);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        itemGuardar.setText("GUARDAR VALORES DEL MOMENTO     ");
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemGuardar);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer15.png"))); // NOI18N
        itemModificar.setText("IMPRIMIR");
        itemModificar.setEnabled(false);
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemModificar);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("SALIR");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(itemSalir);

        barMenu.add(menuOpciones);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnCerrar.doClick();
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

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

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemGuardarActionPerformed

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
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JButton btnCerrar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JMenuItem itemGuardar;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JLabel lbApertura;
    public static javax.swing.JLabel lbEstado;
    private static javax.swing.JLabel lbInicial;
    public static javax.swing.JLabel lbNCaja;
    private static javax.swing.JLabel lbUsuI;
    public static javax.swing.JLabel lblDiferencia;
    public static javax.swing.JLabel lblEntregar;
    private javax.swing.JMenu menuOpciones;
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
