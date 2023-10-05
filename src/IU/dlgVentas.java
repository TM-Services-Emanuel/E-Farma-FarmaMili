package IU;

import Componentes.DataSourceService;
import Componentes.DecimalFormatRenderer;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Numero_a_Letra;
import Componentes.PrinterService;
import Componentes.RenderDecimal;
import Componentes.RenderDecimal2;
import Componentes.ReporteF;
import Componentes.Software;
import Componentes.Tickets;
import Componentes.Timbrado;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import Datos.GestionarArticulos;
import Datos.GestionarFactura;
import Datos.GestionarVendedor;
import java.awt.event.KeyEvent;
import Modelo.Articulo;
import Modelo.Vendedor;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class dlgVentas extends javax.swing.JDialog {

    public static int PrecioVenta;
    public static double costoiva;
    public static double descuento;
    public ReporteF jasper;

    /*private static int idEmision;
    private static String Timbr;
    private static String Establecimiento;
    private static String Emision;
    private static String Desde;
    private static String Hasta;
    private static String EstablecimientoT;
    private static String EmisionT;
    private static int facturaactual;
    private static int facturaactualT;
    private static int facturafin;
    private static int facturafinT;
    private static String ImpresoraPred;*/
    Numero_a_Letra L;
    static DataSourceService dss = new DataSourceService();

    public dlgVentas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        titulo();
        jasper = new ReporteF();
        CabecerasTablas.ventas(tbDetalle);
        Cancelar();
        pintarCondicion();
        Invisible();
        L = new Numero_a_Letra();
        txtCodVendedorF.setText("");
        txtCodVendedorT.setText("");
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Venta de artículos");
        } else {
            this.setTitle(Software.getSoftware() + " - Venta de artículos");
        }
    }

    public void Cancelar() {
        limpiarCampos();
        //dcFecha.setEnabled(false);
        btnProveedor.setEnabled(false);
        rContado.setEnabled(false);
        rContado.setSelected(true);
        rCredito.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnNuevo.requestFocus();
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        itemBuscarA.setEnabled(false);
        itemBuscarC.setEnabled(false);
        itemQuitar.setEnabled(false);

        cant();
    }

    public void Rendes() {
        dlgVentas.tbDetalle.getColumnModel().getColumn(3).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(7).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(9).setCellRenderer(new DecimalFormatRenderer());

        dlgVentas.tbDetalle.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimal());

        dlgVentas.tbDetalle.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimal2());
        dlgVentas.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal2());
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCond.setVisible(false);
        txtTotalL.setVisible(false);
        lbCred.setVisible(false);
        txtExentaL.setVisible(false);
        txt5L.setVisible(false);
        txt10L.setVisible(false);
        txtNetoL.setVisible(false);
        txtDescuentoL.setVisible(false);
        txtCodArticulo.setVisible(false);
        txtCodCliente.setVisible(false);
        btnModCantidad.setVisible(false);
        txtdisponibleL.setVisible(false);
        txtidEmision.setVisible(false);
        txtFechaReal.setVisible(false);
        txtCodF.setVisible(false);
        txtCodT.setVisible(false);
    }

    public void cant() {
        int total = tbDetalle.getRowCount();
        etiCant.setText("ITEM A FACTURAR: " + String.valueOf(total));
    }

    private void pintarCondicion() {
        if (rContado.isSelected()) {
            rContado.setFont(new java.awt.Font("Tahoma", 1, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 51));
            rCredito.setFont(new java.awt.Font("Tahoma", 0, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 0));
            lbCond.setText("CONTADO");
        } else {
            rContado.setFont(new java.awt.Font("Tahoma", 0, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 0));
            rCredito.setFont(new java.awt.Font("Tahoma", 1, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 51));
            lbCond.setText("CREDITO");
        }
    }

    private void limpiarCampos() {
        txtCod.setText("");
        txtFacturaN.setText("");
        txtFecha.setText("");
        txtFacturaN.setText("");
        txtCodCliente.setText("");
        txtHora.setText("");
        txtRuc.setText("");
        txtRazonS.setText("");
        rContado.isSelected();
        txtTotalL.setText("0");
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtExenta.setText("0");
        txtExentaL.setText("0");
        txt5L.setText("0");
        txt5.setText("0");
        txt10L.setText("0");
        txt10.setText("0");
        txtNetoL.setText("0");
        txtNeto.setText("0");
        txtDescuentoL.setText("0");
        txtDescuento.setText("0");
        lbCond.setText("");
        lbPVenta.setText("");
        lbPublic.setText("");
        txtCaja.setText("");
        txtEstablecimiento.setText("");
        txtEmision.setText("");
        txtFacturaN.setText("");
        rContado.setSelected(true);
        CabecerasTablas.limpiarTablasVentas(tbDetalle);
        CabecerasTablas.ventas(tbDetalle);
        controlFactura.canCelar();
        txtCodVendedorF.setText("");
        lbEmpleadoF.setText("");
        txthabilitado.setText("");
        txtdisponible.setText("");
        txtidEmision.setText("");
    }

    public static void habilitarCANTCOSTO() {
        if (txtArt.getText().isEmpty()) {
            txtCant.setEnabled(false);
        } else {
            txtCant.setEnabled(true);
        }
    }

    public static void obtenerNFactura() {
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT facturaactual FROM v_puntoemision3 WHERE idemision=" + Timbrado.getIdEmision())) {
            rs.last();
            do {
                int facturaactual = rs.getInt("facturaactual");
                lbTimbrado.setText("TIMBRADO " + Timbrado.getTimbrado());
                lbValidaz.setText("VALIDO DESDE: " + Timbrado.getDesde() + " HASTA: " + Timbrado.getHasta());
                int FA = facturaactual + 1;
                if (FA <= Timbrado.getFacturaFin()) {
                    txtidEmision.setText(String.valueOf(Timbrado.getIdEmision()));
                    txtEstablecimiento.setText(Timbrado.getEstablecimiento());
                    txtEmision.setText(Timbrado.getPuntoExpedicion());
                    switch (String.valueOf(FA).length()) {
                        case 1 ->
                            txtFacturaN.setText("000000" + String.valueOf(FA));
                        case 2 ->
                            txtFacturaN.setText("00000" + String.valueOf(FA));
                        case 3 ->
                            txtFacturaN.setText("0000" + String.valueOf(FA));
                        case 4 ->
                            txtFacturaN.setText("000" + String.valueOf(FA));
                        case 5 ->
                            txtFacturaN.setText("00" + String.valueOf(FA));
                        case 6 ->
                            txtFacturaN.setText("0" + String.valueOf(FA));
                        case 7 ->
                            txtFacturaN.setText(String.valueOf(FA));
                        default -> {
                        }
                    }
                    OpcionesEmision.dispose();
                    dlgFinFacturaL.setSize(418, 530);
                    dlgFinFacturaL.setLocationRelativeTo(null);
                    dlgFinFacturaL.setModal(true);
                    dlgFinFacturaL.setTitle("Confirmar Venta");
                    String cod = GestionarFactura.getFactura();
                    txtCodF.setText(cod);
                    txtCodVendedorF.setText("");
                    dlgFinFacturaL.setVisible(true);
                    txtCodVendedorF.requestFocus();
                }else{
                    Mensajes.Sistema("Se ha alcanzado la cantidad máxima de facturas habilitadas para este puento de expedición");
                }
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible emitir factura legal.\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
        }
    }

    public static void ComprobarNF() {
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT facturaactual FROM v_puntoemision3 WHERE idemision=" + txtidEmision.getText().trim())) {
            rs.last();
            do {
                int facturaactual = rs.getInt("facturaactual");
                int FA = facturaactual + 1;
                if (FA <= Timbrado.getFacturaFin()) {
                    txtEstablecimiento.setText(Timbrado.getEstablecimiento());
                    txtEmision.setText(Timbrado.getPuntoExpedicion());
                    switch (String.valueOf(FA).length()) {
                        case 1 ->
                            txtFacturaN.setText("000000" + String.valueOf(FA));
                        case 2 ->
                            txtFacturaN.setText("00000" + String.valueOf(FA));
                        case 3 ->
                            txtFacturaN.setText("0000" + String.valueOf(FA));
                        case 4 ->
                            txtFacturaN.setText("000" + String.valueOf(FA));
                        case 5 ->
                            txtFacturaN.setText("00" + String.valueOf(FA));
                        case 6 ->
                            txtFacturaN.setText("0" + String.valueOf(FA));
                        case 7 ->
                            txtFacturaN.setText(String.valueOf(FA));
                        default -> {
                        }
                    }
                }
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();
            String cod = GestionarFactura.getFactura();
            txtCodF.setText(cod);

        } catch (SQLException ex) {
        }
    }

    public static void obtenerNTicket() {
        String cod = GestionarFactura.getCodigo();
        txtCodT.setText(cod);
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT facturaactual FROM v_puntoemision3 WHERE idemision="+Tickets.getIdEmision())) {
            rs.last();
            do {
                txtidEmision.setText(String.valueOf(Tickets.getIdEmision()));
                int facturaactualT = rs.getInt("facturaactual");
                int numero = (facturaactualT + 1);
                if (numero <= Tickets.getTicketFin()) {
                    txtEPE.setText(Tickets.getEstablecimiento() + "-" + Tickets.getPuntoExpedicion() + "-");
                    txtTicketN.setText(String.valueOf(numero));
                    OpcionesEmision.dispose();
                    dlgFinTicket.setSize(433, 502);
                    dlgFinTicket.setLocationRelativeTo(null);
                    dlgFinTicket.setModal(true);
                    dlgFinTicket.setTitle("Confirmar Venta");
                    txtCodVendedorT.setText("");
                    dlgFinTicket.setVisible(true);
                    txtCodVendedorT.requestFocus();
                }else{
                    Mensajes.Sistema("Se ha alcanzado la cantidad máxima de ticket habilitadas para este puento de expedición");
                }
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible emitir Ticket de venta.\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
        }
    }

    public static void ComprobarNT() {
        String cod = GestionarFactura.getCodigo();
        txtCodT.setText(cod);
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT facturaactual FROM v_puntoemision3 WHERE idemision=" + txtidEmision.getText().trim())) {
            rs.last();
            do {
                int facturaactualT = rs.getInt("facturaactual");
                int numero = (facturaactualT + 1);
                if (numero <= Tickets.getTicketFin()) {
                    txtEPE.setText(Tickets.getEstablecimiento() + "-" + Tickets.getPuntoExpedicion() + "-");
                    txtTicketN.setText(String.valueOf(numero));
                }
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
        }
    }

    /* public static void imprimirTicketO() {

        try {

            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(20.30);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = tbDetalle.getRowCount();
            int tamaño = filas+40;
            printer.setOutSize(tamaño, 80);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 1, 3, 40, "========================================");
            printer.printTextWrap(1, 1, 32, 80, "FARMAMILI"); //NOMBRE EMPRESA
            printer.printTextWrap(3, 1, 28, 80, "de Alfonso Avalos Gimenez."); //PROPIETARIO
            printer.printTextWrap(4, 1, 16, 80, "Jose M. A. Godoy c/ Las Residentas - (0971) 799 004"); //DIRECCION
            printer.printTextWrap(5, 1, 3, 80, "_____________________________________________________________________________");
            printer.printTextWrap(6, 1, 3, 80, "FECHA: " + Fecha.fechaCorrecta() + " " + Fecha.darHora()); //FECHA Y HORA
            printer.printTextWrap(6, 1, 65, 80, lbCond.getText()); //CONDICION DE VENTA
            printer.printTextWrap(7, 1, 3, 80, "TICKET N°: " + txtCodFactura.getText()); //FACTURA O PEDIDO
            printer.printTextWrap(7, 1, 65, 80, "CAJA N°: " + txtCaja.getText()); //CAJA
            printer.printTextWrap(8, 1, 3, 80, "VENDEDOR: " + lbEmpleado.getText()); //VENDEDOR
            printer.printTextWrap(9, 1, 3, 80, "CLIENTE: " + txtRuc.getText() + " / " + txtRazonS.getText());//RUC Y RS
            printer.printTextWrap(10, 1, 3, 80, "_____________________________________________________________________________");
            printer.printTextWrap(11, 1, 3, 80, "DESCRIPCION                            CANT  P.PUBL  %DESC  P.UNIT   TOTAL");
            printer.printTextWrap(12, 1, 0, 80, " ");

            for (int i = 0; i < filas; i++) {
                int p = 13 + i; //Fila
                DecimalFormat formateador = new DecimalFormat("#,###");
                String DES = printer.alinharADireita(10, tbDetalle.getValueAt(i, 2).toString());
                String Cant = tbDetalle.getValueAt(i, 3).toString();
                String Ppublic = tbDetalle.getValueAt(i, 17).toString();
                String Desc = tbDetalle.getValueAt(i, 16).toString();
                String Punit = tbDetalle.getValueAt(i, 5).toString();
                String Mont = tbDetalle.getValueAt(i, 13).toString();
                printer.printTextWrap(p, 1, 3, 40, DES);
                printer.printTextWrap(p, 1, 43, 46, formateador.format(Integer.parseInt(Cant.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 48, 57, formateador.format(Integer.parseInt(Ppublic.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 58, 62, formateador.format(Integer.parseInt(Desc.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 64, 71, formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 72, 80, formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))));

            }

            printer.printTextWrap(filas + 17, 1, 3, 80, "-----------------------------------------------------------------------------");

            DecimalFormat formateador = new DecimalFormat("#,###");
            String tot = printer.alinharADireita(10, formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", ""))));
            printer.printTextWrap(filas + 18, 1, 3, 20, "TOTAL A PAGAR:");
            printer.printTextWrap(filas + 18, 1, 67, 80, (tot));
            printer.printTextWrap(filas + 19, 1, 3, 80, "-----------------------------------------------------------------------------");
            String efe = printer.alinharADireita(10, txtAbono.getText());
            printer.printTextWrap(filas + 20, 1, 3, 80, "EFECTIVO : ");
            printer.printTextWrap(filas + 20, 1, 20, 80, efe);

            String cam = printer.alinharADireita(10, txtVuelto.getText());
            printer.printTextWrap(filas + 21, 1, 3, 80, "VUELTO   : ");
            printer.printTextWrap(filas + 21, 1, 20, 80, cam);

            printer.printTextWrap(filas + 22, 1, 3, 80, "=============================================================================");
            printer.printTextWrap(filas + 23, 1, 27, 80, "!GRACIAS POR SU PREFERENCIA!");
            printer.printTextWrap(filas + 26, 1, 12, 80, "E-FARM - v1.2.1 - Software Integral de Gestión Farmacéutica");
            printer.printTextWrap(filas + 27, 1, 3, 80, "=============================================================================");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
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

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }
     */
 /*    public static void imprimirTicket() {

        try {
            try {
                String sql = "select em_razonsocial, em_direccion, em_celular from empresa where em_indicador='S'";
                st = (MariaDbStatement) con.createStatement();
                rss = st.executeQuery(sql);
                try{
                    rss.first();
                    emp=rss.getString(1);
                    dir=rss.getString(2);
                    cel=rss.getString(3);
                } catch (SQLException e) {
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(0);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = tbDetalle.getRowCount();
            int tamaño = filas+15;
            printer.setOutSize(tamaño, 80);

            //Imprimir = 1ra linea de la columa de 1 a 32
            //printer.printTextWrap(0, 1, 15, 24, "FARMAMILI"); //NOMBRE EMPRESA
            switch (emp.length()) {
                case 1 -> printer.printTextWrap(0, 1, 20, 40, emp); //NOMBRE EMPRESA
                case 2 -> printer.printTextWrap(0, 1, 19, 40, emp); //NOMBRE EMPRESA
                case 3 -> printer.printTextWrap(0, 1, 19, 40, emp); //NOMBRE EMPRESA
                case 4 -> printer.printTextWrap(0, 1, 18, 40, emp); //NOMBRE EMPRESA
                case 5 -> printer.printTextWrap(0, 1, 18, 40, emp); //NOMBRE EMPRESA
                case 6 -> printer.printTextWrap(0, 1, 17, 40, emp); //NOMBRE EMPRESA
                case 7 -> printer.printTextWrap(0, 1, 17, 40, emp); //NOMBRE EMPRESA
                case 8 -> printer.printTextWrap(0, 1, 16, 40, emp); //NOMBRE EMPRESA
                case 9 -> printer.printTextWrap(0, 1, 16, 40, emp); //NOMBRE EMPRESA
                case 10 -> printer.printTextWrap(0, 1, 15, 40, emp); //NOMBRE EMPRESA
                case 11 -> printer.printTextWrap(0, 1, 15, 40, emp); //NOMBRE EMPRESA
                case 12 -> printer.printTextWrap(0, 1, 14, 40, emp); //NOMBRE EMPRESA
                case 13 -> printer.printTextWrap(0, 1, 14, 40, emp); //NOMBRE EMPRESA
                case 14 -> printer.printTextWrap(0, 1, 13, 40, emp); //NOMBRE EMPRESA
                case 15 -> printer.printTextWrap(0, 1, 13, 40, emp); //NOMBRE EMPRESA
                case 16 -> printer.printTextWrap(0, 1, 12, 40, emp); //NOMBRE EMPRESA
                case 17 -> printer.printTextWrap(0, 1, 12, 40, emp); //NOMBRE EMPRESA
                case 18 -> printer.printTextWrap(0, 1, 11, 40, emp); //NOMBRE EMPRESA
                case 19 -> printer.printTextWrap(0, 1, 11, 40, emp); //NOMBRE EMPRESA
                case 20 -> printer.printTextWrap(0, 1, 10, 40, emp); //NOMBRE EMPRESA
                case 21 -> printer.printTextWrap(0, 1, 10, 40, emp); //NOMBRE EMPRESA
                case 22 -> printer.printTextWrap(0, 1, 9, 40, emp); //NOMBRE EMPRESA
                case 23 -> printer.printTextWrap(0, 1, 9, 40, emp); //NOMBRE EMPRESA
                case 24 -> printer.printTextWrap(0, 1, 8, 40, emp); //NOMBRE EMPRESA
                case 25 -> printer.printTextWrap(0, 1, 8, 40, emp); //NOMBRE EMPRESA
                case 26 -> printer.printTextWrap(0, 1, 7, 40, emp); //NOMBRE EMPRESA
                case 27 -> printer.printTextWrap(0, 1, 7, 40, emp); //NOMBRE EMPRESA
                case 28 -> printer.printTextWrap(0, 1, 6, 40, emp); //NOMBRE EMPRESA
                case 29 -> printer.printTextWrap(0, 1, 6, 40, emp); //NOMBRE EMPRESA
                case 30 -> printer.printTextWrap(0, 1, 5, 40, emp); //NOMBRE EMPRESA
                case 31 -> printer.printTextWrap(0, 1, 5, 40, emp); //NOMBRE EMPRESA
                case 32 -> printer.printTextWrap(0, 1, 4, 40, emp); //NOMBRE EMPRESA
                case 33 -> printer.printTextWrap(0, 1, 4, 40, emp); //NOMBRE EMPRESA
                case 34 -> printer.printTextWrap(0, 1, 3, 40, emp); //NOMBRE EMPRESA
                case 35 -> printer.printTextWrap(0, 1, 3, 40, emp); //NOMBRE EMPRESA
                case 36 -> printer.printTextWrap(0, 1, 2, 40, emp); //NOMBRE EMPRESA
                case 37 -> printer.printTextWrap(0, 1, 2, 40, emp); //NOMBRE EMPRESA
                case 38 -> printer.printTextWrap(0, 1, 1, 40, emp); //NOMBRE EMPRESA
                case 39 -> printer.printTextWrap(0, 1, 1, 40, emp); //NOMBRE EMPRESA
            }
            //printer.printTextWrap(0, 1, 15, 40, emp); //NOMBRE EMPRESA
            printer.printTextWrap(0, 1, 41, 80, "_______________________________________"); //PROPIETARIO
            //printer.printTextWrap(1, 1, 3, 37, "Jose M. A. Godoy c/ Las Residentas"); //DIRECCION
            switch (dir.length()) {
                case 1 -> printer.printTextWrap(1, 1, 20, 40, dir); //NOMBRE EMPRESA
                case 2 -> printer.printTextWrap(1, 1, 19, 40, dir); //NOMBRE EMPRESA
                case 3 -> printer.printTextWrap(1, 1, 19, 40, dir); //NOMBRE EMPRESA
                case 4 -> printer.printTextWrap(1, 1, 18, 40, dir); //NOMBRE EMPRESA
                case 5 -> printer.printTextWrap(1, 1, 18, 40, dir); //NOMBRE EMPRESA
                case 6 -> printer.printTextWrap(1, 1, 17, 40, dir); //NOMBRE EMPRESA
                case 7 -> printer.printTextWrap(1, 1, 17, 40, dir); //NOMBRE EMPRESA
                case 8 -> printer.printTextWrap(1, 1, 16, 40, dir); //NOMBRE EMPRESA
                case 9 -> printer.printTextWrap(1, 1, 16, 40, dir); //NOMBRE EMPRESA
                case 10 -> printer.printTextWrap(1, 1, 15, 40, dir); //NOMBRE EMPRESA
                case 11 -> printer.printTextWrap(1, 1, 15, 40, dir); //NOMBRE EMPRESA
                case 12 -> printer.printTextWrap(1, 1, 14, 40, dir); //NOMBRE EMPRESA
                case 13 -> printer.printTextWrap(1, 1, 14, 40, dir); //NOMBRE EMPRESA
                case 14 -> printer.printTextWrap(1, 1, 13, 40, dir); //NOMBRE EMPRESA
                case 15 -> printer.printTextWrap(1, 1, 13, 40, dir); //NOMBRE EMPRESA
                case 16 -> printer.printTextWrap(1, 1, 12, 40, dir); //NOMBRE EMPRESA
                case 17 -> printer.printTextWrap(1, 1, 12, 40, dir); //NOMBRE EMPRESA
                case 18 -> printer.printTextWrap(1, 1, 11, 40, dir); //NOMBRE EMPRESA
                case 19 -> printer.printTextWrap(1, 1, 11, 40, dir); //NOMBRE EMPRESA
                case 20 -> printer.printTextWrap(1, 1, 10, 40, dir); //NOMBRE EMPRESA
                case 21 -> printer.printTextWrap(1, 1, 10, 40, dir); //NOMBRE EMPRESA
                case 22 -> printer.printTextWrap(1, 1, 9, 40, dir); //NOMBRE EMPRESA
                case 23 -> printer.printTextWrap(1, 1, 9, 40, dir); //NOMBRE EMPRESA
                case 24 -> printer.printTextWrap(1, 1, 8, 40, dir); //NOMBRE EMPRESA
                case 25 -> printer.printTextWrap(1, 1, 8, 40, dir); //NOMBRE EMPRESA
                case 26 -> printer.printTextWrap(1, 1, 7, 40, dir); //NOMBRE EMPRESA
                case 27 -> printer.printTextWrap(1, 1, 7, 40, dir); //NOMBRE EMPRESA
                case 28 -> printer.printTextWrap(1, 1, 6, 40, dir); //NOMBRE EMPRESA
                case 29 -> printer.printTextWrap(1, 1, 6, 40, dir); //NOMBRE EMPRESA
                case 30 -> printer.printTextWrap(1, 1, 5, 40, dir); //NOMBRE EMPRESA
                case 31 -> printer.printTextWrap(1, 1, 5, 40, dir); //NOMBRE EMPRESA
                case 32 -> printer.printTextWrap(1, 1, 4, 40, dir); //NOMBRE EMPRESA
                case 33 -> printer.printTextWrap(1, 1, 4, 40, dir); //NOMBRE EMPRESA
                case 34 -> printer.printTextWrap(1, 1, 3, 40, dir); //NOMBRE EMPRESA
                case 35 -> printer.printTextWrap(1, 1, 3, 40, dir); //NOMBRE EMPRESA
                case 36 -> printer.printTextWrap(1, 1, 2, 40, dir); //NOMBRE EMPRESA
                case 37 -> printer.printTextWrap(1, 1, 2, 40, dir); //NOMBRE EMPRESA
                case 38 -> printer.printTextWrap(1, 1, 1, 40, dir); //NOMBRE EMPRESA
                case 39 -> printer.printTextWrap(1, 1, 1, 40, dir); //NOMBRE EMPRESA
            }
            //printer.printTextWrap(1, 1, 3, 37, dir); //DIRECCION
            //printer.printTextWrap(1, 1, 43, 73, "Cel:(0981) 700 414"); //DIRECCION
            printer.printTextWrap(1, 1, 43, 73, "Cel:"+cel); //DIRECCION
            printer.printTextWrap(2, 1, 1, 40, "________________________________________");
            printer.printTextWrap(2, 1, 41, 67, "FECHA: " + txtFecha.getText() + " " + Fecha.darHora()); //FECHA Y HORA
            printer.printTextWrap(2, 1, 71, 78, lbCond.getText()); //CONDICION DE VENTA
            printer.printTextWrap(3, 1, 1, 24, "TICKET N: " +txtTC.getText()+""+txtCodFactura.getText()); //FACTURA O PEDIDO
            printer.printTextWrap(3, 1, 26, 37, "CAJA N: " + txtCaja.getText()); //CAJA
            printer.printTextWrap(3, 1, 41, 80, "VENDEDOR: " + lbEmpleado.getText()); //VENDEDOR
            printer.printTextWrap(4, 1, 1, 40, "CLIENTE: " + txtRazonS.getText());//RUC Y RS
            printer.printTextWrap(4, 1, 41, 80, "R.U.C.: " + txtRuc.getText());//RUC Y RS
            printer.printTextWrap(5, 1, 1, 40, "________________________________________");
            printer.printTextWrap(5, 1, 41, 79, "CANT   P.PUBL  %DESC  P.UNIT    TOTAL");
            for (int i = 0; i < filas; i++) {
                int p = 6 + i; //Fila
                DecimalFormat formateador = new DecimalFormat("#,###");
                String DES = printer.alinharADireita(10, tbDetalle.getValueAt(i, 2).toString());
                //String DES = tbDetalle.getValueAt(i, 2).toString();
                String Cant = tbDetalle.getValueAt(i, 3).toString();
                int pp = Integer.parseInt(tbDetalle.getValueAt(i, 17).toString())/Integer.parseInt(tbDetalle.getValueAt(i, 3).toString());
                String Ppublic = String.valueOf(pp);
                String Desc = tbDetalle.getValueAt(i, 16).toString();
                String Punit = tbDetalle.getValueAt(i, 5).toString();
                String Mont = tbDetalle.getValueAt(i, 13).toString();
                printer.printTextWrap(p, 1, 1, 40, DES);
                printer.printTextWrap(p, 1, 41, 45, formateador.format(Integer.parseInt(Cant.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 48, 54, formateador.format(Integer.parseInt(Ppublic.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 56, 61, formateador.format(Integer.parseInt(Desc.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 63, 69, formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 72, 79, formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))));
            }
            printer.printTextWrap(filas+6, 1, 1, 40, "---------------------------------------");

            DecimalFormat formateador = new DecimalFormat("#,###");
            String tot = printer.alinharADireita(10, formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", ""))));
            printer.printTextWrap(filas + 6, 1, 41, 55, "TOTAL A PAGAR:");
            printer.printTextWrap(filas + 6, 1, 66, 79, (tot));
            printer.printTextWrap(filas + 7, 1, 1, 40, "---------------------------------------");
            String efe = printer.alinharADireita(10, txtAbono.getText());
            printer.printTextWrap(filas + 7, 1, 41, 52, "EFECTIVO : ");
            printer.printTextWrap(filas + 7, 1, 55, 80, efe);

            String cam = printer.alinharADireita(10, txtVuelto.getText());
            printer.printTextWrap(filas + 8, 1, 1, 12, "VUELTO   : ");
            printer.printTextWrap(filas + 8, 1, 15, 40, cam);

            printer.printTextWrap(filas + 8, 1, 41, 80, "=======================================");
            printer.printTextWrap(filas + 9, 1, 6, 34, "GRACIAS POR SU PREFERENCIA!!");
            printer.printTextWrap(filas + 9, 1, 52, 66, "SISTEMA E-FARM");
            printer.printTextWrap(filas + 10, 1, 1, 40, "=======================================");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar ticket: "+ex.getMessage());
            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
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

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }*/
    public static void imprimirTicket() {
        //Impresora termica
        PrinterService printerService = new PrinterService();
        int filas = tbDetalle.getRowCount();
        DecimalFormat formateador = new DecimalFormat("#,###");
        String tot = formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", "")));

        String Ticket = "            TICKET DE VENTA\n";
        Ticket += "----------------------------------------\n";
        Ticket += "NRO: " + txtEPE.getText().trim() + txtTicketN.getText().trim() + "\n";
        Ticket += "FECHA: " + txtFecha.getText().trim() + " " + Fecha.darHora() + "\n";
        Ticket += "VENDEDOR/A: " + lbEmpleadoT.getText().trim() + "\n";
        Ticket += "----------------------------------------\n";
        Ticket += "CANT   P.PUBL  %DESC  P.UNIT    TOTAL   \n";
        Ticket += "----------------------------------------\n";
        for (int i = 0; i < filas; i++) {

            String Descripcion = tbDetalle.getValueAt(i, 2).toString().trim();
            String Cant = tbDetalle.getValueAt(i, 3).toString();
            //int pp = Integer.parseInt(tbDetalle.getValueAt(i, 4).toString()) / Integer.parseInt(tbDetalle.getValueAt(i, 3).toString());
            String Ppublic = tbDetalle.getValueAt(i, 4).toString();
            String Desc = tbDetalle.getValueAt(i, 5).toString();
            String Punit = tbDetalle.getValueAt(i, 6).toString().trim();
            String Mont = tbDetalle.getValueAt(i, 10).toString().trim();

            Ticket += String.format("%1$1s", Descripcion + "\n");
            //Ticket += String.format("%1$11s %2$15s %3$19s" ,"CANT: "+tbDetalle.getValueAt(i, 3).toString(), "PRECIO: "+formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))), "SUBTOTAL: "+formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))))+ "\n";
            Ticket += String.format("%1$-6s %2$-8s %3$-5s %4$-9s %5$-5s", Cant, formateador.format(Integer.parseInt(Ppublic.replace(".", "").replace(",", ""))),
                    formateador.format(Integer.parseInt(Desc.replace(".", "").replace(",", ""))),
                    formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))),
                    formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", "")))) + "\n";
        }
        Ticket += "----------------------------------------\n";
        Ticket += String.format("%1$6s %2$22s", "TOTAL A PAGAR:", tot) + "\n";
        Ticket += "----------------------------------------\n";
        Ticket += "      GRACIAS POR SU PREFERENCIA!\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";
        Ticket += "\n";

        try {
            printerService.printString2(Tickets.getImpresora(), Ticket);
            byte[] cutP = new byte[]{0x1d, 'V', 1};
            printerService.printBytes2(Tickets.getImpresora(), cutP);
        } catch (Exception e) {
            Mensajes.error("No se encuentra instalada la impresora predeterminada para este punto de impresión");
        }
    }

    /* public static void imprimirTicket() {

        try {
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(0);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = tbDetalle.getRowCount();
            int tamaño = filas+6;
            printer.setOutSize(tamaño, 80);

            printer.printTextWrap(1, 1, 12, 40, "TICKET DE VENTA"); //DIRECCION
            printer.printTextWrap(1, 1, 41, 80, "________________________________________");
            printer.printTextWrap(2, 1, 1, 27, "FECHA: " + txtFecha.getText() + " " + Fecha.darHora()); //FECHA Y HORA
            printer.printTextWrap(2, 1, 31, 40, lbCond.getText()); //CONDICION DE VENTA
            printer.printTextWrap(2, 1, 41, 80, "________________________________________");
            printer.printTextWrap(3, 1, 1, 40, "CANT   P.PUBL  %DESC  P.UNIT    TOTAL");
            for (int i = 0; i < filas; i++) {
                int p = 3 + i; //Fila
                DecimalFormat formateador = new DecimalFormat("#,###");
                String DES = printer.alinharADireita(10, tbDetalle.getValueAt(i, 2).toString());
                //String DES = tbDetalle.getValueAt(i, 2).toString();
                String Cant = tbDetalle.getValueAt(i, 3).toString();
                int pp = Integer.parseInt(tbDetalle.getValueAt(i, 17).toString())/Integer.parseInt(tbDetalle.getValueAt(i, 3).toString());
                String Ppublic = String.valueOf(pp);
                String Desc = tbDetalle.getValueAt(i, 16).toString();
                String Punit = tbDetalle.getValueAt(i, 5).toString();
                String Mont = tbDetalle.getValueAt(i, 13).toString();
                printer.printTextWrap(p, 1, 41, 80, DES);
                printer.printTextWrap(p, 1, 1, 5, formateador.format(Integer.parseInt(Cant.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 8, 14, formateador.format(Integer.parseInt(Ppublic.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 16, 21, formateador.format(Integer.parseInt(Desc.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 23, 29, formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 32, 39, formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))));
            }
            printer.printTextWrap(filas+3, 1, 41, 80, "---------------------------------------");

            DecimalFormat formateador = new DecimalFormat("#,###");
            String tot = printer.alinharADireita(10, formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", ""))));
            printer.printTextWrap(filas + 4, 1, 1, 15, "TOTAL A PAGAR:");
            printer.printTextWrap(filas + 4, 1, 26, 39, (tot));
            printer.printTextWrap(filas + 4, 1, 41, 80, "---------------------------------------");
            printer.printTextWrap(filas + 5, 1, 6, 34, "GRACIAS POR SU PREFERENCIA!!");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar ticket: "+ex.getMessage());
            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            Doc document = new SimpleDoc(inputStream, docFormat, null);

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);
                } catch (PrintException ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] cutP = new byte[] { 0x1d, 'V', 1 };
                    Doc doc = new SimpleDoc(cutP, docFormat, null);
                    printJob.print(doc, null);
                } catch (PrintException es) {
                    Mensajes.error("Error printBytes: "+e);
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }*/
    public void llamarReporteFactura(int cod, String Letra) throws SQLException {
        ReporteF gr;
        gr = new ReporteF();
        gr.FacturaLegal("\\Reports\\ventas\\facturaLegal.jasper", "cod", cod, "Letra", Letra);
        gr.cerrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dlgFinFacturaL = new javax.swing.JDialog();
        btnConfirmarFactura = new javax.swing.JButton();
        txtAbonoL = new javax.swing.JTextField();
        Blanco1 = new org.edisoncor.gui.panel.PanelImage();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtAbonoF = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtVueltoF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbNetoF = new javax.swing.JLabel();
        lbDescuentoF = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCodVendedorF = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lbTimbrado = new javax.swing.JLabel();
        lbValidaz = new javax.swing.JLabel();
        txtCodF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEstablecimiento = new javax.swing.JTextField();
        txtEmision = new javax.swing.JTextField();
        txtFacturaN = new javax.swing.JTextField();
        lbEmpleadoF = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemVolverdeFactura = new javax.swing.JMenuItem();
        menuEmergente = new javax.swing.JPopupMenu();
        itemCantidad = new javax.swing.JMenuItem();
        dlgFinTicket = new javax.swing.JDialog();
        btnConfirmarTicket = new javax.swing.JButton();
        txtAbonoTL = new javax.swing.JTextField();
        Blanco2 = new org.edisoncor.gui.panel.PanelImage();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtAbonoT = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtVueltoT = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbNetoT = new javax.swing.JLabel();
        lbDescuentoT = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        lblTotalT = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtCodVendedorT = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txtEPE = new javax.swing.JTextField();
        txtTicketN = new javax.swing.JTextField();
        lbEmpleadoT = new javax.swing.JLabel();
        txtCodT = new javax.swing.JTextField();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        item_ConfirmarTicket = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        item_VolverdeTicket = new javax.swing.JMenuItem();
        OpcionesEmision = new javax.swing.JDialog();
        Blanco3 = new org.edisoncor.gui.panel.PanelImage();
        btnTicket = new javax.swing.JButton();
        btnFacturaLegal = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        itemTicket_de_Venta = new javax.swing.JMenuItem();
        itemFactura_Legal = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemCancelarEmitirComprobante = new javax.swing.JMenuItem();
        GrupoOpciones = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtRazonS = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtdisponible = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthabilitado = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        rContado = new javax.swing.JRadioButton();
        rCredito = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txtArt = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        etiCant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNetoL = new javax.swing.JTextField();
        txtDescuentoL = new javax.swing.JTextField();
        txtCodArticulo = new javax.swing.JTextField();
        txtExentaL = new javax.swing.JTextField();
        txt5L = new javax.swing.JTextField();
        txt10L = new javax.swing.JTextField();
        lbPublic = new javax.swing.JTextField();
        lbPVenta = new javax.swing.JTextField();
        btnBuscarArticulo = new newscomponents.RSButtonGradientIcon_new();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtNeto = new javax.swing.JTextField();
        lbNETO = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtidEmision = new javax.swing.JTextField();
        txtFechaReal = new javax.swing.JTextField();
        btnModCantidad = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        txtCodCliente = new javax.swing.JTextField();
        txtTotalL = new javax.swing.JTextField();
        lbCond = new javax.swing.JLabel();
        txtdisponibleL = new javax.swing.JTextField();
        lbCred = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemBuscarC = new javax.swing.JMenuItem();
        itemBuscarA = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemQuitar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        dlgFinFacturaL.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgFinFacturaL.setResizable(false);
        dlgFinFacturaL.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgFinFacturaLWindowOpened(evt);
            }
        });
        dlgFinFacturaL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dlgFinFacturaLKeyPressed(evt);
            }
        });

        btnConfirmarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/accept.png"))); // NOI18N
        btnConfirmarFactura.setText("CONFIRMAR");
        btnConfirmarFactura.setEnabled(false);
        btnConfirmarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarFacturaActionPerformed(evt);
            }
        });

        Blanco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco1.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel10.setOpaque(false);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel11.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel13.setText("EFECTIVO");

        txtAbonoF.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        txtAbonoF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbonoF.setText("0");
        txtAbonoF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAbonoFMouseClicked(evt);
            }
        });
        txtAbonoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbonoFActionPerformed(evt);
            }
        });
        txtAbonoF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoFKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel14.setText("VUELTO");

        txtVueltoF.setEditable(false);
        txtVueltoF.setBackground(new java.awt.Color(255, 255, 255));
        txtVueltoF.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        txtVueltoF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVueltoF.setText("0");
        txtVueltoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAbonoF)
                    .addComponent(txtVueltoF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAbonoF, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVueltoF, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setText("RESUMEN DE VENTA:");

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setText("TOTAL S/ DESC.");

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setText("AHORRO");

        lbNetoF.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbNetoF.setForeground(new java.awt.Color(51, 51, 255));
        lbNetoF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNetoF.setText("0");

        lbDescuentoF.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbDescuentoF.setForeground(new java.awt.Color(102, 204, 0));
        lbDescuentoF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescuentoF.setText("0");

        jPanel13.setBackground(new java.awt.Color(17, 35, 46));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 50, 0)));
        jPanel13.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(254, 50, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("TOTAL A COBRAR");

        lblTotal.setFont(new java.awt.Font("Digital-7 Mono", 1, 48)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(254, 50, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lbDescuentoF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(lbNetoF, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbNetoF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbDescuentoF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DETALLAR COBRANZA", new javax.swing.ImageIcon(getClass().getResource("/Iconos/efectivo_30.png")), jPanel10); // NOI18N

        jPanel18.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Vendedor");

        txtCodVendedorF.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtCodVendedorF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodVendedorF.setBorder(null);
        txtCodVendedorF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVendedorFActionPerformed(evt);
            }
        });
        txtCodVendedorF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodVendedorFKeyPressed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        lbTimbrado.setBackground(new java.awt.Color(102, 102, 102));
        lbTimbrado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbTimbrado.setForeground(new java.awt.Color(255, 255, 255));
        lbTimbrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTimbrado.setText("TIMBRADO N°: ");
        lbTimbrado.setToolTipText("");
        lbTimbrado.setOpaque(true);

        lbValidaz.setBackground(new java.awt.Color(102, 102, 102));
        lbValidaz.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbValidaz.setForeground(new java.awt.Color(255, 255, 255));
        lbValidaz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValidaz.setText("VALIDEZ:");
        lbValidaz.setOpaque(true);

        txtCodF.setEditable(false);
        txtCodF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("FACTURA N°");

        txtEstablecimiento.setEditable(false);
        txtEstablecimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtEstablecimiento.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtEstablecimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstablecimiento.setBorder(null);
        txtEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstablecimientoActionPerformed(evt);
            }
        });

        txtEmision.setEditable(false);
        txtEmision.setBackground(new java.awt.Color(255, 255, 255));
        txtEmision.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtEmision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmision.setBorder(null);
        txtEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmisionActionPerformed(evt);
            }
        });

        txtFacturaN.setEditable(false);
        txtFacturaN.setBackground(new java.awt.Color(255, 255, 255));
        txtFacturaN.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtFacturaN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFacturaN.setBorder(null);
        txtFacturaN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaNKeyTyped(evt);
            }
        });

        lbEmpleadoF.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbEmpleadoF.setForeground(new java.awt.Color(255, 255, 255));
        lbEmpleadoF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCodF, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFacturaN, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbValidaz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTimbrado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCodVendedorF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbEmpleadoF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodVendedorF, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmpleadoF, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTimbrado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValidaz, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(txtEstablecimiento, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCodF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFacturaN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Blanco1Layout = new javax.swing.GroupLayout(Blanco1);
        Blanco1.setLayout(Blanco1Layout);
        Blanco1Layout.setHorizontalGroup(
            Blanco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Blanco1Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        Blanco1Layout.setVerticalGroup(
            Blanco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco1Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("EFECTIVO");

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar2.setBorder(null);
        jMenuBar2.setBorderPainted(false);

        jMenu2.setText("Opciones");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/like25.png"))); // NOI18N
        jMenuItem1.setText("Confirmar");
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        itemVolverdeFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemVolverdeFactura.setBackground(new java.awt.Color(255, 255, 255));
        itemVolverdeFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/door_out32.png"))); // NOI18N
        itemVolverdeFactura.setText("Volver");
        itemVolverdeFactura.setOpaque(true);
        itemVolverdeFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVolverdeFacturaActionPerformed(evt);
            }
        });
        jMenu2.add(itemVolverdeFactura);

        jMenuBar2.add(jMenu2);

        dlgFinFacturaL.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout dlgFinFacturaLLayout = new javax.swing.GroupLayout(dlgFinFacturaL.getContentPane());
        dlgFinFacturaL.getContentPane().setLayout(dlgFinFacturaLLayout);
        dlgFinFacturaLLayout.setHorizontalGroup(
            dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinFacturaLLayout.createSequentialGroup()
                .addComponent(Blanco1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAbonoL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        dlgFinFacturaLLayout.setVerticalGroup(
            dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinFacturaLLayout.createSequentialGroup()
                .addGroup(dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgFinFacturaLLayout.createSequentialGroup()
                        .addComponent(btnConfirmarFactura)
                        .addGap(108, 108, 108)
                        .addComponent(txtAbonoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Blanco1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        itemCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itemCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        itemCantidad.setText("Modificar Cantidad");
        itemCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCantidadActionPerformed(evt);
            }
        });
        menuEmergente.add(itemCantidad);

        dlgFinTicket.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgFinTicket.setResizable(false);
        dlgFinTicket.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgFinTicketWindowOpened(evt);
            }
        });
        dlgFinTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dlgFinTicketKeyPressed(evt);
            }
        });

        btnConfirmarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/accept.png"))); // NOI18N
        btnConfirmarTicket.setText("CONFIRMAR");
        btnConfirmarTicket.setEnabled(false);
        btnConfirmarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTicketActionPerformed(evt);
            }
        });

        Blanco2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco2.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel14.setOpaque(false);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel15.setOpaque(false);

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel23.setText("EFECTIVO");

        txtAbonoT.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        txtAbonoT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbonoT.setText("0");
        txtAbonoT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAbonoTMouseClicked(evt);
            }
        });
        txtAbonoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbonoTActionPerformed(evt);
            }
        });
        txtAbonoT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoTKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel24.setText("VUELTO");

        txtVueltoT.setEditable(false);
        txtVueltoT.setBackground(new java.awt.Color(255, 255, 255));
        txtVueltoT.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        txtVueltoT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVueltoT.setText("0");
        txtVueltoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAbonoT)
                    .addComponent(txtVueltoT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAbonoT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVueltoT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel25.setText("RESUMEN DE VENTA:");

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setText("TOTAL S/ DESC.");

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setText("AHORRO");

        lbNetoT.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbNetoT.setForeground(new java.awt.Color(51, 51, 255));
        lbNetoT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNetoT.setText("0");

        lbDescuentoT.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbDescuentoT.setForeground(new java.awt.Color(102, 204, 0));
        lbDescuentoT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescuentoT.setText("0");

        jPanel16.setBackground(new java.awt.Color(17, 35, 46));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 50, 0)));
        jPanel16.setOpaque(false);

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(254, 50, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("TOTAL A COBRAR");

        lblTotalT.setFont(new java.awt.Font("Digital-7 Mono", 1, 48)); // NOI18N
        lblTotalT.setForeground(new java.awt.Color(254, 50, 0));
        lblTotalT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalT.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(lblTotalT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lbDescuentoT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(lbNetoT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lbNetoT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lbDescuentoT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DETALLAR COBRANZA", new javax.swing.ImageIcon(getClass().getResource("/Iconos/efectivo_30.png")), jPanel14); // NOI18N

        jPanel19.setBackground(new java.awt.Color(102, 102, 102));

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ID Vendedor");

        txtCodVendedorT.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtCodVendedorT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodVendedorT.setBorder(null);
        txtCodVendedorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVendedorTActionPerformed(evt);
            }
        });
        txtCodVendedorT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodVendedorTKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("TICKET N°");

        txtEPE.setEditable(false);
        txtEPE.setBackground(new java.awt.Color(255, 255, 255));
        txtEPE.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtEPE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEPE.setBorder(null);
        txtEPE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEPEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEPEKeyTyped(evt);
            }
        });

        txtTicketN.setEditable(false);
        txtTicketN.setBackground(new java.awt.Color(255, 255, 255));
        txtTicketN.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtTicketN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTicketN.setBorder(null);
        txtTicketN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTicketNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTicketNKeyTyped(evt);
            }
        });

        lbEmpleadoT.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbEmpleadoT.setForeground(new java.awt.Color(255, 255, 255));
        lbEmpleadoT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEPE, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTicketN, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodVendedorT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEmpleadoT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodVendedorT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbEmpleadoT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTicketN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEPE, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Blanco2Layout = new javax.swing.GroupLayout(Blanco2);
        Blanco2.setLayout(Blanco2Layout);
        Blanco2Layout.setHorizontalGroup(
            Blanco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Blanco2Layout.setVerticalGroup(
            Blanco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco2Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        txtCodT.setEditable(false);
        txtCodT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jMenuBar3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar3.setBorder(null);
        jMenuBar3.setBorderPainted(false);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Opciones");
        jMenu3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu3.setOpaque(true);
        jMenu3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        item_ConfirmarTicket.setBackground(new java.awt.Color(255, 255, 255));
        item_ConfirmarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/like25.png"))); // NOI18N
        item_ConfirmarTicket.setText("Confirmar");
        item_ConfirmarTicket.setOpaque(true);
        item_ConfirmarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_ConfirmarTicketActionPerformed(evt);
            }
        });
        jMenu3.add(item_ConfirmarTicket);

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setOpaque(true);
        jMenu3.add(jSeparator8);

        item_VolverdeTicket.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        item_VolverdeTicket.setBackground(new java.awt.Color(255, 255, 255));
        item_VolverdeTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/door_out32.png"))); // NOI18N
        item_VolverdeTicket.setText("Volver");
        item_VolverdeTicket.setOpaque(true);
        item_VolverdeTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_VolverdeTicketActionPerformed(evt);
            }
        });
        jMenu3.add(item_VolverdeTicket);

        jMenuBar3.add(jMenu3);

        dlgFinTicket.setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout dlgFinTicketLayout = new javax.swing.GroupLayout(dlgFinTicket.getContentPane());
        dlgFinTicket.getContentPane().setLayout(dlgFinTicketLayout);
        dlgFinTicketLayout.setHorizontalGroup(
            dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinTicketLayout.createSequentialGroup()
                .addComponent(Blanco2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodT)
                        .addComponent(txtAbonoTL, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfirmarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        dlgFinTicketLayout.setVerticalGroup(
            dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(dlgFinTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirmarTicket)
                .addGap(186, 186, 186)
                .addComponent(txtAbonoTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        OpcionesEmision.setResizable(false);

        Blanco3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco3.setPreferredSize(new java.awt.Dimension(690, 418));

        btnTicket.setBackground(new java.awt.Color(0, 204, 0));
        btnTicket.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        btnTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TICK_30.png"))); // NOI18N
        btnTicket.setText("TICKET DE VENTA");
        btnTicket.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTicket.setBorderPainted(false);
        GrupoOpciones.add(btnTicket);
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });

        btnFacturaLegal.setBackground(new java.awt.Color(0, 0, 255));
        btnFacturaLegal.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        btnFacturaLegal.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturaLegal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/FACT_30.png"))); // NOI18N
        btnFacturaLegal.setText("FACTURA LEGAL");
        btnFacturaLegal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFacturaLegal.setBorderPainted(false);
        GrupoOpciones.add(btnFacturaLegal);
        btnFacturaLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaLegalActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMITIR COMPROBANTE COMO:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Blanco3Layout = new javax.swing.GroupLayout(Blanco3);
        Blanco3.setLayout(Blanco3Layout);
        Blanco3Layout.setHorizontalGroup(
            Blanco3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Blanco3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnFacturaLegal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Blanco3Layout.setVerticalGroup(
            Blanco3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Blanco3Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFacturaLegal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar4.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuBar4.setBorderPainted(false);

        jMenu4.setText("Opciones");
        jMenu4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemTicket_de_Venta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, 0));
        itemTicket_de_Venta.setBackground(new java.awt.Color(255, 255, 255));
        itemTicket_de_Venta.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemTicket_de_Venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TICK_30 - copia.png"))); // NOI18N
        itemTicket_de_Venta.setText("TICKET DE VENTA               ");
        itemTicket_de_Venta.setOpaque(true);
        itemTicket_de_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTicket_de_VentaActionPerformed(evt);
            }
        });
        jMenu4.add(itemTicket_de_Venta);

        itemFactura_Legal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        itemFactura_Legal.setBackground(new java.awt.Color(255, 255, 255));
        itemFactura_Legal.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemFactura_Legal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/FACT_30 - copia.png"))); // NOI18N
        itemFactura_Legal.setText("FACTURA LEGAL");
        itemFactura_Legal.setOpaque(true);
        itemFactura_Legal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFactura_LegalActionPerformed(evt);
            }
        });
        jMenu4.add(itemFactura_Legal);

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setOpaque(true);
        jMenu4.add(jSeparator7);

        itemCancelarEmitirComprobante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelarEmitirComprobante.setBackground(new java.awt.Color(255, 255, 255));
        itemCancelarEmitirComprobante.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemCancelarEmitirComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/door_out32.png"))); // NOI18N
        itemCancelarEmitirComprobante.setText("Volver");
        itemCancelarEmitirComprobante.setOpaque(true);
        itemCancelarEmitirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarEmitirComprobanteActionPerformed(evt);
            }
        });
        jMenu4.add(itemCancelarEmitirComprobante);

        jMenuBar4.add(jMenu4);

        OpcionesEmision.setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout OpcionesEmisionLayout = new javax.swing.GroupLayout(OpcionesEmision.getContentPane());
        OpcionesEmision.getContentPane().setLayout(OpcionesEmisionLayout);
        OpcionesEmisionLayout.setHorizontalGroup(
            OpcionesEmisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        OpcionesEmisionLayout.setVerticalGroup(
            OpcionesEmisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel3.setLayout(new java.awt.GridLayout(1, 4));

        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);

        jLabel1.setText("Operación N°");

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Fecha y Hora");

        jLabel19.setText("Mov. Caja N°");

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtRazonS.setEditable(false);
        txtRazonS.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(0, 0, 51));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        btnProveedor.setText("F3-Clientes");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(17, 35, 46));
        jLabel3.setText("Línea de crédito disponible:");

        txtdisponible.setEditable(false);
        txtdisponible.setBackground(new java.awt.Color(255, 255, 255));
        txtdisponible.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtdisponible.setForeground(new java.awt.Color(255, 0, 0));
        txtdisponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(17, 35, 46));
        jLabel5.setText("Crédito habilitado:");

        txthabilitado.setEditable(false);
        txthabilitado.setBackground(new java.awt.Color(255, 255, 255));
        txthabilitado.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txthabilitado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txthabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txthabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtHora.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rContado);
        rContado.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rContado.setSelected(true);
        rContado.setText("CONTADO");
        rContado.setOpaque(false);
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rCredito);
        rCredito.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        rCredito.setText("CREDITO");
        rCredito.setEnabled(false);
        rCredito.setOpaque(false);
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rContado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rCredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(rContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setOpaque(false);

        txtArt.setEditable(false);
        txtArt.setBackground(new java.awt.Color(255, 255, 255));
        txtArt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtActionPerformed(evt);
            }
        });
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArtKeyReleased(evt);
            }
        });

        txtCant.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CANT.");

        etiCant.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        etiCant.setText("Artículos registrados:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        tbDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalle.setFillsViewportHeight(true);
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setShowGrid(false);
        tbDetalle.setShowHorizontalLines(true);
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        tbDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXCENTAS");

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExenta.setText("0");

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");

        txt5.setEditable(false);
        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setText("0");

        txt10.setEditable(false);
        txt10.setBackground(new java.awt.Color(255, 255, 255));
        txt10.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10.setText("0");

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt5)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        txtNetoL.setEditable(false);
        txtNetoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetoL.setText("0");

        txtDescuentoL.setEditable(false);
        txtDescuentoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuentoL.setText("0");

        txtCodArticulo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N

        txtExentaL.setEditable(false);
        txtExentaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExentaL.setText("0");

        txt5L.setEditable(false);
        txt5L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5L.setText("0");

        txt10L.setEditable(false);
        txt10L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10L.setText("0");

        lbPublic.setEditable(false);
        lbPublic.setBackground(new java.awt.Color(102, 102, 102));
        lbPublic.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lbPublic.setForeground(new java.awt.Color(255, 255, 255));
        lbPublic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPublic.setBorder(null);

        lbPVenta.setEditable(false);
        lbPVenta.setBackground(new java.awt.Color(102, 102, 102));
        lbPVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbPVenta.setForeground(new java.awt.Color(255, 255, 255));
        lbPVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPVenta.setBorder(null);

        btnBuscarArticulo.setText("CARGAR ARTICULOS - F9");
        btnBuscarArticulo.setColorPrimario(new java.awt.Color(17, 35, 46));
        btnBuscarArticulo.setColorPrimarioHover(new java.awt.Color(63, 74, 80));
        btnBuscarArticulo.setColorSecundario(new java.awt.Color(63, 74, 80));
        btnBuscarArticulo.setColorSecundarioHover(new java.awt.Color(17, 35, 46));
        btnBuscarArticulo.setFont(new java.awt.Font("Roboto Bold", 0, 12)); // NOI18N
        btnBuscarArticulo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_SHOPPING_CART);
        btnBuscarArticulo.setSizeIcon(25.0F);
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(307, 307, 307))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNetoL, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescuentoL, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtExentaL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt5L, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt10L, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCant)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPVenta)
                            .addComponent(lbPublic))))
                .addGap(5, 5, 5))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiCant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuentoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNetoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt10L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt5L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExentaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 50, 0)));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 50, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TOTAL");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtTotal.setFont(new java.awt.Font("Digital-7 Mono", 1, 40)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(254, 50, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 218, 218)));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setText("TOTAL AHORRO:");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 0, 102));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.setText("0");

        txtNeto.setEditable(false);
        txtNeto.setBackground(new java.awt.Color(255, 255, 255));
        txtNeto.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtNeto.setForeground(new java.awt.Color(0, 102, 0));
        txtNeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNeto.setText("0");
        txtNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetoActionPerformed(evt);
            }
        });

        lbNETO.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbNETO.setText("TOTAL VENTA SIN DESCUENTO:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNETO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(txtNeto))
                .addGap(10, 10, 10))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNETO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        txtidEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidEmisionActionPerformed(evt);
            }
        });

        btnModCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        btnModCantidad.setForeground(new java.awt.Color(204, 0, 0));
        btnModCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        btnModCantidad.setText("EDIT. CANT");
        btnModCantidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModCantidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCantidadActionPerformed(evt);
            }
        });

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTotalL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalL.setText("0");
        txtTotalL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalLActionPerformed(evt);
            }
        });

        lbCond.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbCred.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        lbCred.setText("jLabel12");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnNuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuevo.setText("Nuevo-F1");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(85, 57));
        btnNuevo.setMinimumSize(new java.awt.Dimension(85, 57));
        btnNuevo.setPreferredSize(new java.awt.Dimension(90, 60));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit30.png"))); // NOI18N
        btnModificar.setText("Modif-F5");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setMaximumSize(new java.awt.Dimension(63, 57));
        btnModificar.setMinimumSize(new java.awt.Dimension(63, 57));
        btnModificar.setPreferredSize(new java.awt.Dimension(90, 60));
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(btnModificar);

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
        jPanel4.add(btnGuardar);

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
        jPanel4.add(btnCancelar);

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("Salir-Alt+F4");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCred)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCond, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtdisponibleL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodCliente)
                    .addComponent(txtTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnModCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnRestar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaReal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbCred)
                        .addGap(15, 15, 15)
                        .addComponent(btnAdd))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbCond, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtdisponibleL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodCliente)
                            .addComponent(btnModCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidEmision, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestar)
                            .addComponent(txtFechaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        itemModificar.setText("Guardar Modificación");
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificar);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        itemGuardar.setText("Guardar Nuevo");
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(itemGuardar);

        itemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        itemCancelar.setText("Cancelar");
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        jMenu1.add(itemCancelar);
        jMenu1.add(jSeparator1);

        itemBuscarC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itemBuscarC.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search20.png"))); // NOI18N
        itemBuscarC.setText("Cambiar Cliente");
        itemBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarCActionPerformed(evt);
            }
        });
        jMenu1.add(itemBuscarC);

        itemBuscarA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        itemBuscarA.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemBuscarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search20.png"))); // NOI18N
        itemBuscarA.setText("Buscar Artículo");
        itemBuscarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarAActionPerformed(evt);
            }
        });
        jMenu1.add(itemBuscarA);
        jMenu1.add(jSeparator4);

        itemQuitar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemQuitar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vcsremoved_93492 - copia.png"))); // NOI18N
        itemQuitar.setText("Quitar Artículo");
        itemQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitarActionPerformed(evt);
            }
        });
        jMenu1.add(itemQuitar);
        jMenu1.add(jSeparator5);

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
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlFactura.canCelar();
            this.dispose();
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlFactura.addTabla(tbDetalle);
        cant();
        txtCodArticulo.setText("");
        txtArt.setText("");
        txtCant.setText("");
        lbPVenta.setText("");
        lbPublic.setText("");
        btnBuscarArticulo.requestFocus();
        habilitarCANTCOSTO();
        btnBuscarArticuloActionPerformed(null);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlFactura.delRenglon(tbDetalle);
            cant();
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCant);
        Articulo Ar = GestionarArticulos.busArticulo((txtCodArticulo.getText()));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtCant.getText().isEmpty()) {
                txtCant.selectAll();
            } else if (txtCant.getText().equals("0")) {
                txtCant.selectAll();
            } else if (Integer.parseInt(txtCant.getText()) > Ar.getStock()) {
                Mensajes.error("Cantidad supera el Stock actual");
                txtCant.requestFocus();
                txtCant.setText(String.valueOf(Ar.getStock()));
                txtCant.selectAll();
            } else {
                btnAdd.doClick();
            }
        }
    }//GEN-LAST:event_txtCantKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        /*obtenerNFactura();
        if (facturaactual <= facturafin) {
            String cod = GestionarFactura.getCodigo();
            txtCod.setText(cod);
            txtidEmision.setText(String.valueOf(idEmision));
            txtEstablecimiento.setText(Establecimiento);
            txtEmision.setText(Emision);
            switch (String.valueOf(facturaactual).length()) {
                case 1 ->
                    txtFacturaN.setText("000000" + (facturaactual + 1));
                case 2 ->
                    txtFacturaN.setText("00000" + (facturaactual + 1));
                case 3 ->
                    txtFacturaN.setText("0000" + (facturaactual + 1));
                case 4 ->
                    txtFacturaN.setText("000" + (facturaactual + 1));
                case 5 ->
                    txtFacturaN.setText("00" + (facturaactual + 1));
                case 6 ->
                    txtFacturaN.setText("0" + (facturaactual + 1));
                case 7 ->
                    txtFacturaN.setText(String.valueOf(facturaactual + 1));
                default -> {
                }
            }
        }*/
        //String cod = GestionarFactura.getCodigo();
        //txtCod.setText(cod);
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.ObtenerCodigo("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        controlFactura.selectClienteInicio("1");
        rContado.setSelected(true);
        if (lbCred.getText().equals("SI")) {
            rCredito.setEnabled(true);
        } else {
            rCredito.setEnabled(false);
        }
        pintarCondicion();
        txtFechaReal.setText(Fecha.fechaCorrecta());
        txtFecha.setText(Fecha.fechaFormulario());
        txtHora.setText(Fecha.darHoraSinSS());
        //txtFecha.setText(String.valueOf(now().getDayOfMonth()+"-"+now().getMonthValue()+"-"+now().getYear()));
        btnProveedor.setEnabled(true);
        rContado.setEnabled(true);
        btnBuscarArticulo.setEnabled(true);
        txtCant.setEnabled(true);
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        itemBuscarA.setEnabled(true);
        itemBuscarC.setEnabled(true);
        itemQuitar.setEnabled(true);
        btnBuscarArticulo.doClick();
        habilitarCANTCOSTO();
        Rendes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getRowCount() <= 0) {
            Mensajes.error("El detalle de la compra esta vacia");
            btnBuscarArticulo.doClick();
        } else {
            if (lbCond.getText().equals("CONTADO")) {
                DecimalFormat df = new DecimalFormat("#,###");
                if (dlgVentas.txtTotalL.getText().trim().length() >= 1) {
                    dlgVentas.lblTotal.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                    dlgVentas.lblTotalT.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                }
                if (dlgVentas.txtNetoL.getText().trim().length() >= 1) {
                    dlgVentas.lbNetoF.setText(df.format(Integer.valueOf(dlgVentas.txtNetoL.getText().trim().replace(".", "").replace(",", ""))));
                    dlgVentas.lbNetoT.setText(df.format(Integer.valueOf(dlgVentas.txtNetoL.getText().trim().replace(".", "").replace(",", ""))));
                }
                if (dlgVentas.txtDescuentoL.getText().trim().length() >= 1) {
                    dlgVentas.lbDescuentoF.setText(df.format(Integer.valueOf(dlgVentas.txtDescuentoL.getText().trim().replace(".", "").replace(",", ""))));
                    dlgVentas.lbDescuentoT.setText(df.format(Integer.valueOf(dlgVentas.txtDescuentoL.getText().trim().replace(".", "").replace(",", ""))));
                }
                OpcionesEmision.setSize(370, 330);
                OpcionesEmision.setLocationRelativeTo(this);
                OpcionesEmision.setModal(true);
                OpcionesEmision.setTitle("OPCIONES DE EMISIÓN");
                OpcionesEmision.setVisible(true);
                //btnConfirmar.requestFocus();
            } else {
                if (Integer.parseInt(txtTotalL.getText()) <= Integer.parseInt(txtdisponibleL.getText())) {
                    DecimalFormat df = new DecimalFormat("#,###");
                    if (dlgVentas.txtTotalL.getText().trim().length() >= 1) {
                        dlgVentas.lblTotal.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                        dlgVentas.lblTotalT.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                    }
                    if (dlgVentas.txtNetoL.getText().trim().length() >= 1) {
                        dlgVentas.lbNetoF.setText(df.format(Integer.valueOf(dlgVentas.txtNetoL.getText().trim().replace(".", "").replace(",", ""))));
                        dlgVentas.lbNetoT.setText(df.format(Integer.valueOf(dlgVentas.txtNetoL.getText().trim().replace(".", "").replace(",", ""))));
                    }
                    if (dlgVentas.txtDescuentoL.getText().trim().length() >= 1) {
                        dlgVentas.lbDescuentoF.setText(df.format(Integer.valueOf(dlgVentas.txtDescuentoL.getText().trim().replace(".", "").replace(",", ""))));
                        dlgVentas.lbDescuentoT.setText(df.format(Integer.valueOf(dlgVentas.txtDescuentoL.getText().trim().replace(".", "").replace(",", ""))));
                    }
                    OpcionesEmision.setSize(370, 350);
                    OpcionesEmision.setLocationRelativeTo(this);
                    OpcionesEmision.setModal(true);
                    OpcionesEmision.setTitle("OPCIONES DE EMISIÓN");
                    OpcionesEmision.setVisible(true);
                    //btnConfirmar.requestFocus();
                } else {
                    Mensajes.informacion("Línea de crédito insuficiente");
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            limpiarCampos();
            //dcFecha.setEnabled(false);
            btnProveedor.setEnabled(false);
            rContado.setEnabled(false);
            rContado.setSelected(true);
            rCredito.setEnabled(false);
            btnBuscarArticulo.setEnabled(false);
            txtCant.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnNuevo.requestFocus();
            itemNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            itemModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            itemGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            itemCancelar.setEnabled(false);
            itemBuscarA.setEnabled(false);
            itemBuscarC.setEnabled(false);
            itemQuitar.setEnabled(false);
            cant();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarCliente bcliente = new dlgBuscarCliente(null, true);
            bcliente.setLocationRelativeTo(null);
            bcliente.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }

    }//GEN-LAST:event_btnProveedorActionPerformed

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rCreditoActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        btnGuardarActionPerformed(null);
    }//GEN-LAST:event_itemGuardarActionPerformed

    private void itemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_itemCancelarActionPerformed

    private void itemBuscarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarAActionPerformed
        // TODO add your handling code here:
        btnBuscarArticulo.doClick();
    }//GEN-LAST:event_itemBuscarAActionPerformed

    private void itemQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitarActionPerformed
        // TODO add your handling code here:S
        btnRestar.doClick();
    }//GEN-LAST:event_itemQuitarActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCantActionPerformed

    private void txtArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtActionPerformed

    private void txtArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtFacturaNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaNKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaNKeyPressed

    private void txtFacturaNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaNKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        int limite = 15;
        if (txtFacturaN.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFacturaNKeyTyped

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtNetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNetoActionPerformed

    private void txtAbonoFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoFKeyReleased
        // TODO add your handling code here:
        try {
            if (txtAbonoF.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtAbonoF.setText(df.format(Integer.valueOf(txtAbonoF.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbonoF.setText("0");
                txtAbonoF.selectAll();

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
        try {
            if (txtAbonoF.getText().trim().length() >= 1) {
                DecimalFormat dff = new DecimalFormat("#0");
                txtAbonoL.setText(dff.format(Integer.valueOf(txtAbonoF.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbonoL.setText("0");

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtAbonoFKeyReleased

    private void btnConfirmarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarFacturaActionPerformed
        // TODO add your handling code here:
        ComprobarNF();
        String cond = lbCond.getText();
        String est;
        if (cond.equals("CONTADO")) {
            est = "ABONADO";
        } else {
            est = "PENDIENTE";
        }
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement()){
            int resp = JOptionPane.showConfirmDialog(dlgFinFacturaL, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    cn.setAutoCommit(false);
                    String sql = "insert into factura_l values(" + txtCodF.getText() + "," + txtCodVendedorF.getText() + "," + txtCodCliente.getText() + "," + txtCaja.getText() + "," + txtidEmision.getText() + ", '" + txtEstablecimiento.getText() + "-" + txtEmision.getText() + "-" + txtFacturaN.getText() + "','" + cond + "','"
                            + txtFechaReal.getText().trim() + "','" + txtHora.getText().trim() + "'," + txtTotalL.getText() + "," + txtExentaL.getText() + "," + txt5L.getText() + "," + txt10L.getText() + ",'S','" + Login.getUsuarioLogueado() + "','" + est + "')";
                    String sql3 = "update puntoemision set facturaactual=" + Integer.valueOf(txtFacturaN.getText().trim()) + " where idemision=" + txtidEmision.getText().trim();

                    st.executeUpdate(sql);
                    st.executeUpdate(sql3);
                    int fila = tbDetalle.getRowCount();
                    for (int j = 0; j < fila; j++) {
                        String filas[] = {
                            tbDetalle.getValueAt(j, 0).toString(),
                            tbDetalle.getValueAt(j, 3).toString(),
                            tbDetalle.getValueAt(j, 6).toString(),
                            tbDetalle.getValueAt(j, 7).toString(),
                            tbDetalle.getValueAt(j, 8).toString(),
                            tbDetalle.getValueAt(j, 9).toString(),
                            tbDetalle.getValueAt(j, 10).toString()};
                        sql = "insert into detalle_factura_l values(" + txtCodF.getText() + "," + filas[0] + "," + filas[1].replace(".", "").replace(",", "") + "," + filas[2].replace(".", "").replace(",", "") + "," + filas[3].replace(".", "").replace(",", "") + "," + filas[4].replace(".", "").replace(",", "") + "," + filas[5].replace(".", "").replace(",", "") + "," + filas[6].replace(".", "").replace(",", "") + ")";
                        String sql2 = "UPDATE articulo SET art_stock=art_stock-" + filas[1] + " WHERE  art_codigo=" + filas[0];
                        st.executeUpdate(sql);
                        st.executeUpdate(sql2);
                    }
                    cn.commit();
                    st.close();
                    cn.close();
                    Mensajes.informacion("VENTA REALIZADA!");
                    dlgFinFacturaL.dispose();
                    if (cond.equals("CONTADO")) {
                        String Letra = L.Convertir((txtTotalL.getText()), true);
                        llamarReporteFactura(Integer.parseInt(txtCodF.getText().trim()), Letra);
                        CabecerasTablas.limpiarTablasVentas(tbDetalle);
                        CabecerasTablas.ventas(tbDetalle);
                        controlFactura.canCelar();
                        Cancelar();
                        txtAbonoF.setText("0");
                        txtVueltoF.setText("0");
                        cant();
                    } else {
                        String Letra = L.Convertir((txtTotalL.getText()), true);
                        llamarReporteFactura(Integer.parseInt(txtCodF.getText().trim()), Letra);
                        CabecerasTablas.limpiarTablasVentas(tbDetalle);
                        CabecerasTablas.ventas(tbDetalle);
                        controlFactura.canCelar();
                        Cancelar();
                        txtAbonoF.setText("0");
                        txtVueltoF.setText("0");
                        cant();

                    }
                } catch (SQLException e) {
                    try {
                        cn.rollback();
                        cn.close();
                        Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        controlFactura.canCelar();
                        dlgFinFacturaL.dispose();
                    } catch (SQLException se) {
                        Mensajes.error(se.getMessage());
                    }
                }
            }
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarFacturaActionPerformed

    private void txtAbonoFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAbonoFMouseClicked
        // TODO add your handling code here:
        //txtAbono.selectAll();
    }//GEN-LAST:event_txtAbonoFMouseClicked

    private void dlgFinFacturaLWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgFinFacturaLWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_dlgFinFacturaLWindowOpened

    private void dlgFinFacturaLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgFinFacturaLKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgFinFacturaLKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        btnConfirmarFactura.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtCodVendedorFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVendedorFActionPerformed
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtCodVendedorF.getText()) <= 0) {
                Mensajes.error("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
                btnConfirmarFactura.setEnabled(false);
                txtCodVendedorF.requestFocus();
                txtCodVendedorF.selectAll();
            } else {
                try {
                    Vendedor vn = GestionarVendedor.busVendedorFactura(txtCodVendedorF.getText());
                    lbEmpleadoF.setText(vn.getNombreV());
                    btnConfirmarFactura.setEnabled(true);
                    txtAbonoF.requestFocus();
                    txtAbonoF.selectAll();
                } catch (Exception e) {
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCodVendedorFActionPerformed

    private void txtCodVendedorFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorFKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCodVendedorF);
    }//GEN-LAST:event_txtCodVendedorFKeyPressed

    private void itemVolverdeFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVolverdeFacturaActionPerformed
        // TODO add your handling code here:
        dlgFinFacturaL.dispose();
        txtCodVendedorF.setText("");
        lbEmpleadoF.setText("");
        txtAbonoF.setText("0");
        txtVueltoF.setText("0");
    }//GEN-LAST:event_itemVolverdeFacturaActionPerformed

    private void txtAbonoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbonoFActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtAbonoL.getText()) == 0) {
            btnConfirmarFactura.doClick();
        } else {
            try {
                int calculos = controlFactura.calCulos();
                //txtVuelto.setText(String.valueOf(calculos));
                DecimalFormat df = new DecimalFormat("#,###");
                txtVueltoF.setText(df.format(Integer.parseInt(String.valueOf(calculos).trim().replace(".", "").replace(",", ""))));
                txtVueltoF.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtAbonoFActionPerformed

    private void txtVueltoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoFActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtVueltoF.getText().trim().replace(".", "").replace(",", "")) < 0) {
            txtAbonoF.requestFocus();
        } else {
            btnConfirmarFactura.doClick();
        }

    }//GEN-LAST:event_txtVueltoFActionPerformed

    private void itemBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemBuscarCActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btnModCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCantidadActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlFactura.actCantidad();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnModCantidadActionPerformed

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MousePressed

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleMousePressed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            if (evt.getClickCount() == 2) {
                menuEmergente.show(tbDetalle, evt.getX(), evt.getY());
            }

        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void itemCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCantidadActionPerformed
        // TODO add your handling code here:
        btnModCantidadActionPerformed(null);
    }//GEN-LAST:event_itemCantidadActionPerformed

    private void txtTotalLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalLActionPerformed

    private void txtEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstablecimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstablecimientoActionPerformed

    private void txtEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmisionActionPerformed

    private void txtidEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidEmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidEmisionActionPerformed

    private void btnConfirmarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTicketActionPerformed
        // TODO add your handling code here:
        ComprobarNT();
        String cond = lbCond.getText();
        String est;
        if (cond.equals("CONTADO")) {
            est = "ABONADO";
        } else {
            est = "PENDIENTE";
        }
        
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement()){
            int resp = JOptionPane.showConfirmDialog(dlgFinTicket, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    cn.setAutoCommit(false);
                    String sql = "insert into factura values(" + txtCodT.getText() + "," + txtCodVendedorT.getText() + "," + txtCodCliente.getText() + "," + txtCaja.getText() + "," + txtidEmision.getText() + ",'" + txtEPE.getText() + txtTicketN.getText() + "','" + cond + "','"
                            + txtFechaReal.getText().trim() + "','" + txtHora.getText().trim() + "'," + txtTotalL.getText() + "," + txtExentaL.getText() + "," + txt5L.getText() + "," + txt10L.getText() + ",'S','" + Login.getUsuarioLogueado() + "','" + est + "')";
                    String sql3 = "update puntoemision set facturaactual=" + Integer.parseInt(txtTicketN.getText().trim()) + " where idemision=" + txtidEmision.getText().trim();

                    st.executeUpdate(sql);
                    st.executeUpdate(sql3);
                    int fila = tbDetalle.getRowCount();
                    for (int j = 0; j < fila; j++) {
                        String filas[] = {
                            tbDetalle.getValueAt(j, 0).toString(),
                            tbDetalle.getValueAt(j, 3).toString(),
                            tbDetalle.getValueAt(j, 6).toString(),
                            tbDetalle.getValueAt(j, 10).toString()};
                        sql = "insert into detalle_factura values(" + txtCodT.getText() + "," + filas[0] + "," + filas[1].replace(".", "").replace(",", "") + "," + filas[2].replace(".", "").replace(",", "") + "," + filas[3].replace(".", "").replace(",", "") + ")";
                        String sql2 = "UPDATE articulo SET art_stock=art_stock-" + filas[1] + " WHERE  art_codigo=" + filas[0];
                        st.executeUpdate(sql);
                        st.executeUpdate(sql2);
                    }
                    cn.commit();
                    st.close();
                    cn.close();
                    Mensajes.informacion("VENTA REALIZADA!");
                    dlgFinTicket.dispose();
                    if (cond.equals("CONTADO")) {
                        imprimirTicket();
                        CabecerasTablas.limpiarTablasVentas(tbDetalle);
                        CabecerasTablas.ventas(tbDetalle);
                        controlFactura.canCelar();
                        Cancelar();
                        txtAbonoT.setText("0");
                        txtVueltoT.setText("0");
                        cant();
                    } else {
                        CabecerasTablas.limpiarTablasVentas(tbDetalle);
                        CabecerasTablas.ventas(tbDetalle);
                        controlFactura.canCelar();
                        jasper.BoletaCredito("\\Reports\\ventas\\venta_credito.jasper", "cod", Integer.valueOf(txtCodT.getText().trim()));
                        jasper.cerrar();
                        Cancelar();
                        txtAbonoT.setText("0");
                        txtVueltoT.setText("0");
                        cant();

                    }
                    //CabecerasTablas.limpiarTablas(tbDetalle);
                    //cabe.compras(tbDetalle);
                    //controlFactura.canCelar();  
                } catch (SQLException e) {
                    try {
                        cn.rollback();
                        cn.close();
                        Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        controlFactura.canCelar();
                        dlgFinTicket.dispose();
                    } catch (SQLException se) {
                        Mensajes.error(se.getMessage());
                    }
                }
                //Cancelar();
                //txtAbono.setText("0");
                //txtVuelto.setText("0");
                //cant();
            }
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarTicketActionPerformed

    private void txtCodVendedorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVendedorTActionPerformed
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtCodVendedorT.getText()) <= 0) {
                Mensajes.error("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
                btnConfirmarTicket.setEnabled(false);
                txtCodVendedorT.requestFocus();
                txtCodVendedorT.selectAll();
            } else {
                try {
                    Vendedor vn = GestionarVendedor.busVendedorFactura(txtCodVendedorT.getText());
                    lbEmpleadoT.setText(vn.getNombreV());
                    btnConfirmarTicket.setEnabled(true);
                    txtAbonoT.requestFocus();
                    txtAbonoT.selectAll();
                } catch (Exception e) {
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCodVendedorTActionPerformed

    private void txtCodVendedorTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorTKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCodVendedorT);
    }//GEN-LAST:event_txtCodVendedorTKeyPressed

    private void txtTicketNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTicketNKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTicketNKeyPressed

    private void txtTicketNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTicketNKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTicketNKeyTyped

    private void txtAbonoTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAbonoTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAbonoTMouseClicked

    private void txtAbonoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbonoTActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtAbonoTL.getText()) == 0) {
            btnConfirmarTicket.doClick();
        } else {
            try {
                int calculos = controlFactura.calCulosT();
                //txtVuelto.setText(String.valueOf(calculos));
                DecimalFormat df = new DecimalFormat("#,###");
                txtVueltoT.setText(df.format(Integer.parseInt(String.valueOf(calculos).trim().replace(".", "").replace(",", ""))));
                txtVueltoT.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtAbonoTActionPerformed

    private void txtAbonoTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoTKeyReleased
        // TODO add your handling code here:
        try {
            if (txtAbonoT.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtAbonoT.setText(df.format(Integer.valueOf(txtAbonoT.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbonoT.setText("0");
                txtAbonoT.selectAll();

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
        try {
            if (txtAbonoT.getText().trim().length() >= 1) {
                DecimalFormat dff = new DecimalFormat("#0");
                txtAbonoTL.setText(dff.format(Integer.valueOf(txtAbonoT.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbonoTL.setText("0");

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtAbonoTKeyReleased

    private void txtVueltoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoTActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtVueltoT.getText().trim().replace(".", "").replace(",", "")) < 0) {
            txtAbonoT.requestFocus();
        } else {
            btnConfirmarTicket.doClick();
        }

    }//GEN-LAST:event_txtVueltoTActionPerformed

    private void item_ConfirmarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_ConfirmarTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_ConfirmarTicketActionPerformed

    private void item_VolverdeTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_VolverdeTicketActionPerformed
        // TODO add your handling code here:
        dlgFinTicket.dispose();
        txtCodVendedorT.setText("");
        lbEmpleadoT.setText("");
        txtAbonoT.setText("0");
        txtVueltoT.setText("0");
    }//GEN-LAST:event_item_VolverdeTicketActionPerformed

    private void dlgFinTicketWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgFinTicketWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgFinTicketWindowOpened

    private void dlgFinTicketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgFinTicketKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgFinTicketKeyPressed

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        // TODO add your handling code here: 
        txtCodVendedorT.setText("");
        obtenerNTicket();
    }//GEN-LAST:event_btnTicketActionPerformed

    private void btnFacturaLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaLegalActionPerformed
        // TODO add your handling code here:
        txtCodVendedorF.setText("");
        obtenerNFactura();
    }//GEN-LAST:event_btnFacturaLegalActionPerformed

    private void itemTicket_de_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTicket_de_VentaActionPerformed
        // TODO add your handling code here:
        btnTicket.doClick();
    }//GEN-LAST:event_itemTicket_de_VentaActionPerformed

    private void itemFactura_LegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFactura_LegalActionPerformed
        // TODO add your handling code here:
        btnFacturaLegal.doClick();
    }//GEN-LAST:event_itemFactura_LegalActionPerformed

    private void itemCancelarEmitirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarEmitirComprobanteActionPerformed
        // TODO add your handling code here:
        OpcionesEmision.dispose();
    }//GEN-LAST:event_itemCancelarEmitirComprobanteActionPerformed

    private void txtEPEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEPEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEPEKeyPressed

    private void txtEPEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEPEKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEPEKeyTyped

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloVenta baf = new dlgBuscarArticuloVenta(null, true);
            //baf.setLocationRelativeTo(null);
            baf.setLocation(228, 270);
            baf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

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
            java.util.logging.Logger.getLogger(dlgVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgVentas dialog = new dlgVentas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private org.edisoncor.gui.panel.PanelImage Blanco1;
    private org.edisoncor.gui.panel.PanelImage Blanco2;
    private org.edisoncor.gui.panel.PanelImage Blanco3;
    private javax.swing.ButtonGroup GrupoOpciones;
    public static javax.swing.JDialog OpcionesEmision;
    private javax.swing.JButton btnAdd;
    public static newscomponents.RSButtonGradientIcon_new btnBuscarArticulo;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnConfirmarFactura;
    public static javax.swing.JButton btnConfirmarTicket;
    public static javax.swing.JButton btnFacturaLegal;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModCantidad;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRestar;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JButton btnTicket;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JDialog dlgFinFacturaL;
    public static javax.swing.JDialog dlgFinTicket;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itemBuscarA;
    private javax.swing.JMenuItem itemBuscarC;
    private javax.swing.JMenuItem itemCancelar;
    private javax.swing.JMenuItem itemCancelarEmitirComprobante;
    private javax.swing.JMenuItem itemCantidad;
    private javax.swing.JMenuItem itemFactura_Legal;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemQuitar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemTicket_de_Venta;
    private javax.swing.JMenuItem itemVolverdeFactura;
    private javax.swing.JMenuItem item_ConfirmarTicket;
    private javax.swing.JMenuItem item_VolverdeTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    protected javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JLabel lbCond;
    public static javax.swing.JLabel lbCred;
    public static javax.swing.JLabel lbDescuentoF;
    public static javax.swing.JLabel lbDescuentoT;
    public static javax.swing.JLabel lbEmpleadoF;
    public static javax.swing.JLabel lbEmpleadoT;
    private javax.swing.JLabel lbNETO;
    public static javax.swing.JLabel lbNetoF;
    public static javax.swing.JLabel lbNetoT;
    public static javax.swing.JTextField lbPVenta;
    public static javax.swing.JTextField lbPublic;
    public static javax.swing.JLabel lbTimbrado;
    public static javax.swing.JLabel lbValidaz;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JLabel lblTotalT;
    private javax.swing.JPopupMenu menuEmergente;
    public static javax.swing.JRadioButton rContado;
    public static javax.swing.JRadioButton rCredito;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt10L;
    public static javax.swing.JTextField txt5;
    public static javax.swing.JTextField txt5L;
    public static javax.swing.JTextField txtAbonoF;
    public static javax.swing.JTextField txtAbonoL;
    public static javax.swing.JTextField txtAbonoT;
    public static javax.swing.JTextField txtAbonoTL;
    public static javax.swing.JTextField txtArt;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCodArticulo;
    public static javax.swing.JTextField txtCodCliente;
    public static javax.swing.JTextField txtCodF;
    public static javax.swing.JTextField txtCodT;
    public static javax.swing.JTextField txtCodVendedorF;
    public static javax.swing.JTextField txtCodVendedorT;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDescuentoL;
    public static javax.swing.JTextField txtEPE;
    public static javax.swing.JTextField txtEmision;
    public static javax.swing.JTextField txtEstablecimiento;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtExentaL;
    public static javax.swing.JTextField txtFacturaN;
    public static javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaReal;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtNeto;
    public static javax.swing.JTextField txtNetoL;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTicketN;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalL;
    public static javax.swing.JTextField txtVueltoF;
    public static javax.swing.JTextField txtVueltoT;
    public static javax.swing.JTextField txtdisponible;
    public static javax.swing.JTextField txtdisponibleL;
    public static javax.swing.JTextField txthabilitado;
    public static javax.swing.JTextField txtidEmision;
    // End of variables declaration//GEN-END:variables

}
