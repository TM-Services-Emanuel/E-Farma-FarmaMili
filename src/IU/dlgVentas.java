package IU;

import Componentes.DataSourceService;
import Componentes.DecimalFormatRenderer;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.Numero_a_Letra;
import Componentes.PrinterService;
import Componentes.RenderDecimal1conPuntos;
import Componentes.RenderDecimalPublico;
import Componentes.RenderDecimalVenta;
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
import java.awt.Point;
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
    Numero_a_Letra L;
    static DataSourceService dss = new DataSourceService();
    private static Point point;
    public static int min;

    public dlgVentas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        min = 0;
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

    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_F6 ->
                btnGuardar.doClick();
            case KeyEvent.VK_ESCAPE ->
                btnCancelar.doClick();
            case KeyEvent.VK_DELETE ->
                btnRestar.doClick();
            case KeyEvent.VK_F9 ->
                btnBuscarArticulo.doClick();
            case KeyEvent.VK_F3 ->
                btnProveedor.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            default -> {
            }
        }
    }

    private void AccesoRapidoOpciones(int n) {
        switch (n) {
            case KeyEvent.VK_T ->
                btnTicket.doClick();
            case KeyEvent.VK_F ->
                btnFacturaLegal.doClick();
            case KeyEvent.VK_ESCAPE ->
                OpcionesEmision.dispose();
            default -> {
            }
        }
        System.out.println(n);
    }

    private void AccesoRapidoTicket(int n) {
        switch (n) {
            case KeyEvent.VK_ESCAPE ->
                dlgFinTicket.dispose();
            default -> {
            }
        }
        System.out.println(n);
    }

    private void AccesoRapidoFactura(int n) {
        switch (n) {
            case KeyEvent.VK_ESCAPE ->
                dlgFinFacturaL.dispose();
            default -> {
            }
        }
        System.out.println(n);
    }

    public void Cancelar() {
        limpiarCampos();
        btnProveedor.setEnabled(false);
        rContado.setEnabled(false);
        rContado.setSelected(true);
        rCredito.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnNuevo.requestFocus();
        btnSalir.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        controlFactura.canCelar();
        cant();
    }

    public void Rendes() {
        dlgVentas.tbDetalle.getColumnModel().getColumn(3).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(7).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(9).setCellRenderer(new DecimalFormatRenderer());

        dlgVentas.tbDetalle.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimalVenta());

        dlgVentas.tbDetalle.getColumnModel().getColumn(4).setCellRenderer(new RenderDecimalPublico());
        dlgVentas.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new RenderDecimal1conPuntos());
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCond.setVisible(false);
        lbCred.setVisible(false);
        txtCodArticulo.setVisible(false);
        txtCodCliente.setVisible(false);
        btnModCantidad.setVisible(false);
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
            rContado.setFont(new java.awt.Font("Roboto", 1, 11));
            rContado.setForeground(new java.awt.Color(255, 102, 0));
            rCredito.setFont(new java.awt.Font("Roboto", 0, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 0));
            lbCond.setText("CONTADO");
        } else {
            rContado.setFont(new java.awt.Font("Roboto", 0, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 0));
            rCredito.setFont(new java.awt.Font("Roboto", 1, 11));
            rCredito.setForeground(new java.awt.Color(255, 102, 0));
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
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtExenta.setText("0");
        txt5.setText("0");
        txt10.setText("0");
        txtNeto.setText("0");
        txtDescuento.setText("0");
        lbCond.setText("");
        lbPVenta.setText("");
        lbPublic.setText("");
        txtCaja.setText("");
        txtEstablecimiento.setText("");
        txtEmision.setText("");
        txtFacturaN.setText("");
        rContado.setSelected(true);
        CabecerasTablas.limpiarTablaVentas(tbDetalle);
        CabecerasTablas.ventas(tbDetalle);
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
                    dlgFinFacturaL.setSize(374, 369);
                    dlgFinFacturaL.setLocationRelativeTo(null);
                    dlgFinFacturaL.setModal(true);
                    dlgFinFacturaL.setTitle("Confirmar Venta");
                    String cod = GestionarFactura.getFactura();
                    txtCodF.setText(cod);
                    txtCodVendedorF.setText("");
                    dlgFinFacturaL.setVisible(true);
                    txtCodVendedorF.requestFocus();
                } else {
                    Notif.NotifyFail("Notificación del sistema", "Se ha alcanzado la cantidad máxima de facturas habilitadas para este puento de expedición");
                    //Mensajes.Sistema("Se ha alcanzado la cantidad máxima de facturas habilitadas para este puento de expedición");
                }
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Notif.NotifyInformation("Notificación del sistema", "OBSERVACIÓN: En estos momentos es imposible emitir factura legal.\r\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\r\n\nPara mayor información comuniquese con el proveedor del Sistema.");
           // Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible emitir factura legal.\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
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
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT facturaactual FROM v_puntoemision3 WHERE idemision=" + Tickets.getIdEmision())) {
            rs.last();
            do {
                txtidEmision.setText(String.valueOf(Tickets.getIdEmision()));
                int facturaactualT = rs.getInt("facturaactual");
                int numero = (facturaactualT + 1);
                if (numero <= Tickets.getTicketFin()) {
                    txtEPE.setText(Tickets.getEstablecimiento() + "-" + Tickets.getPuntoExpedicion() + "-");
                    txtTicketN.setText(String.valueOf(numero));
                    OpcionesEmision.dispose();
                    dlgFinTicket.setSize(374, 329);
                    dlgFinTicket.setLocationRelativeTo(null);
                    dlgFinTicket.setModal(true);
                    dlgFinTicket.setTitle("Confirmar Venta");
                    txtCodVendedorT.setText("");
                    dlgFinTicket.setVisible(true);
                    //txtCodVendedorT.requestFocus();
                } else {
                    //Mensajes.Sistema("Se ha alcanzado la cantidad máxima de ticket habilitadas para este puento de expedición");
                    Notif.NotifyFail("Notificación del sistema", "Se ha alcanzado la cantidad máxima de ticket habilitadas para este puento de expedición");
                }
            } while (rs.next());
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Notif.NotifyInformation("Notificación del sistema", "OBSERVACIÓN: En estos momentos es imposible emitir Ticket de venta.\r\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\r\n\nPara mayor información comuniquese con el proveedor del Sistema.");
           // Mensajes.informacion("OBSERVACIÓN:\nEn estos momentos es imposible emitir Ticket de venta.\nEl Sistema no logra identificar un PUNTO DE EMISIÓN habilitado para esta terminal de venta.\nPara mayor información comuniquese con el proveedor del Sistema.");
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
        String tot = txtTotal.getText();

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
                    Desc,
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
        lbDescuentoF = new javax.swing.JLabel();
        lbNetoF = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel18 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCodVendedorF = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lbTimbrado = new javax.swing.JLabel();
        lbValidaz = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEstablecimiento = new javax.swing.JTextField();
        txtEmision = new javax.swing.JTextField();
        txtFacturaN = new javax.swing.JTextField();
        lbEmpleadoF = new javax.swing.JLabel();
        txtCodF = new javax.swing.JTextField();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbNetoT = new javax.swing.JLabel();
        lbDescuentoT = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtCodVendedorT = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txtEPE = new javax.swing.JTextField();
        txtTicketN = new javax.swing.JTextField();
        lbEmpleadoT = new javax.swing.JLabel();
        txtCodT = new javax.swing.JTextField();
        OpcionesEmision = new javax.swing.JDialog();
        Blanco3 = new org.edisoncor.gui.panel.PanelImage();
        btnTicket = new javax.swing.JButton();
        btnFacturaLegal = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        GrupoOpciones = new javax.swing.ButtonGroup();
        dlgMinimizado = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnEvento1 = new RSMaterialComponent.RSButtonIconUno();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtRuc = new javax.swing.JTextField();
        txtRazonS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnProveedor = new javax.swing.JButton();
        txtdisponible = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthabilitado = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        rCredito = new rojerusan.RSRadioButton();
        rContado = new rojerusan.RSRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txtArt = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lbPublic = new javax.swing.JTextField();
        lbPVenta = new javax.swing.JTextField();
        btnBuscarArticulo = new rojeru_san.rsbutton.RSButtonGradiente();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtNeto = new javax.swing.JTextField();
        lbNETO = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        panelCabecera = new javax.swing.JPanel();
        btnEvento = new RSMaterialComponent.RSButtonIconUno();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        txtidEmision = new javax.swing.JTextField();
        txtFechaReal = new javax.swing.JTextField();
        btnModCantidad = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        txtCodCliente = new javax.swing.JTextField();
        lbCond = new javax.swing.JLabel();
        lbCred = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        PnlNuevo2 = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador9 = new javax.swing.JSeparator();
        LabelTitulo9 = new javax.swing.JLabel();
        PnlGuardar1 = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador11 = new javax.swing.JSeparator();
        LabelTitulo11 = new javax.swing.JLabel();
        PnlCancelar1 = new rojeru_san.rspanel.RSPanelImage();
        btnCancelar = new RSMaterialComponent.RSButtonIconUno();
        Separador12 = new javax.swing.JSeparator();
        LabelTitulo12 = new javax.swing.JLabel();
        txtCodArticulo = new javax.swing.JTextField();
        etiCant = new javax.swing.JLabel();

        dlgFinFacturaL.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgFinFacturaL.setUndecorated(true);
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
        btnConfirmarFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmarFacturaKeyPressed(evt);
            }
        });

        txtAbonoL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoLKeyPressed(evt);
            }
        });

        Blanco1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco1.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(255, 102, 0));
        jTabbedPane1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N

        jPanel10.setOpaque(false);
        jPanel10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel10KeyPressed(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel13.setText("EFECTIVO");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 124, 29));

        txtAbonoF.setEditable(false);
        txtAbonoF.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        txtAbonoF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbonoF.setText("0");
        txtAbonoF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtAbonoF.setOpaque(false);
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoFKeyReleased(evt);
            }
        });
        jPanel11.add(txtAbonoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 193, 29));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel14.setText("VUELTO");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 124, 29));

        txtVueltoF.setEditable(false);
        txtVueltoF.setBackground(new java.awt.Color(255, 255, 255));
        txtVueltoF.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        txtVueltoF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVueltoF.setText("0");
        txtVueltoF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtVueltoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoFActionPerformed(evt);
            }
        });
        txtVueltoF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVueltoFKeyPressed(evt);
            }
        });
        jPanel11.add(txtVueltoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 193, 29));

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel15.setText("RESUMEN DE VENTA:");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 181, 20));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel16.setText("TOTAL S/ DESC.");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel17.setText("AHORRO");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 20));

        lbDescuentoF.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDescuentoF.setForeground(new java.awt.Color(0, 153, 0));
        lbDescuentoF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescuentoF.setText("0");
        jPanel11.add(lbDescuentoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 90, 20));

        lbNetoF.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbNetoF.setForeground(new java.awt.Color(255, 0, 0));
        lbNetoF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNetoF.setText("0");
        jPanel11.add(lbNetoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 90, 20));

        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 340, 1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 13, 350, 170));

        jTabbedPane1.addTab("DETALLAR COBRANZA", new javax.swing.ImageIcon(getClass().getResource("/Iconos/efectivo_30.png")), jPanel10); // NOI18N

        Blanco1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 365, 230));
        jTabbedPane1.getAccessibleContext().setAccessibleName("EFECTIVO");

        jPanel18.setBackground(new java.awt.Color(17, 35, 46));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Vendedor");
        jPanel18.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 20));

        txtCodVendedorF.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        jPanel18.add(txtCodVendedorF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 13, 69, 19));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 356, 1));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 356, 1));

        lbTimbrado.setBackground(new java.awt.Color(17, 35, 46));
        lbTimbrado.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbTimbrado.setForeground(new java.awt.Color(255, 102, 0));
        lbTimbrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTimbrado.setText("TIMBRADO N°: ");
        lbTimbrado.setToolTipText("");
        lbTimbrado.setOpaque(true);
        lbTimbrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbTimbradoKeyPressed(evt);
            }
        });
        jPanel18.add(lbTimbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 356, 20));

        lbValidaz.setBackground(new java.awt.Color(17, 35, 46));
        lbValidaz.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbValidaz.setForeground(new java.awt.Color(255, 102, 0));
        lbValidaz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValidaz.setText("VALIDEZ:");
        lbValidaz.setOpaque(true);
        lbValidaz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbValidazKeyPressed(evt);
            }
        });
        jPanel18.add(lbValidaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 356, 20));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("FACTURA N°");
        jPanel18.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 100, -1, 23));

        txtEstablecimiento.setEditable(false);
        txtEstablecimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtEstablecimiento.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtEstablecimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstablecimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        txtEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstablecimientoActionPerformed(evt);
            }
        });
        txtEstablecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstablecimientoKeyPressed(evt);
            }
        });
        jPanel18.add(txtEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 100, 40, 23));

        txtEmision.setEditable(false);
        txtEmision.setBackground(new java.awt.Color(255, 255, 255));
        txtEmision.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtEmision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        txtEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmisionActionPerformed(evt);
            }
        });
        txtEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmisionKeyPressed(evt);
            }
        });
        jPanel18.add(txtEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 100, 40, 23));

        txtFacturaN.setEditable(false);
        txtFacturaN.setBackground(new java.awt.Color(255, 255, 255));
        txtFacturaN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtFacturaN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFacturaN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        txtFacturaN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaNKeyTyped(evt);
            }
        });
        jPanel18.add(txtFacturaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 100, 114, 23));

        lbEmpleadoF.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        lbEmpleadoF.setForeground(new java.awt.Color(255, 255, 255));
        lbEmpleadoF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmpleadoF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbEmpleadoFKeyPressed(evt);
            }
        });
        jPanel18.add(lbEmpleadoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 13, 200, 21));

        Blanco1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 372, 130));

        txtCodF.setEditable(false);
        txtCodF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodFKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout dlgFinFacturaLLayout = new javax.swing.GroupLayout(dlgFinFacturaL.getContentPane());
        dlgFinFacturaL.getContentPane().setLayout(dlgFinFacturaLLayout);
        dlgFinFacturaLLayout.setHorizontalGroup(
            dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinFacturaLLayout.createSequentialGroup()
                .addComponent(Blanco1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAbonoL, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnConfirmarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodF))
                .addContainerGap())
        );
        dlgFinFacturaLLayout.setVerticalGroup(
            dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinFacturaLLayout.createSequentialGroup()
                .addGroup(dlgFinFacturaLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgFinFacturaLLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnConfirmarFactura)
                        .addGap(65, 65, 65)
                        .addComponent(txtCodF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAbonoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Blanco1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        dlgFinTicket.setUndecorated(true);
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
        btnConfirmarTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmarTicketKeyPressed(evt);
            }
        });

        txtAbonoTL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoTLKeyPressed(evt);
            }
        });

        Blanco2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco2.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setForeground(new java.awt.Color(255, 102, 0));
        jTabbedPane2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N

        jPanel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jPanel14.setOpaque(false);
        jPanel14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel14KeyPressed(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel23.setText("EFECTIVO");
        jPanel15.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, 124, 29));

        txtAbonoT.setEditable(false);
        txtAbonoT.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        txtAbonoT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbonoT.setText("0");
        txtAbonoT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtAbonoT.setOpaque(false);
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoTKeyReleased(evt);
            }
        });
        jPanel15.add(txtAbonoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 12, 193, 29));

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel24.setText("VUELTO");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 124, 29));

        txtVueltoT.setEditable(false);
        txtVueltoT.setBackground(new java.awt.Color(255, 255, 255));
        txtVueltoT.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        txtVueltoT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVueltoT.setText("0");
        txtVueltoT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtVueltoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoTActionPerformed(evt);
            }
        });
        txtVueltoT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVueltoTKeyPressed(evt);
            }
        });
        jPanel15.add(txtVueltoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 193, 29));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel15.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 340, 1));

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel25.setText("RESUMEN DE VENTA:");
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 181, 20));

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel26.setText("TOTAL S/ DESC.");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel27.setText("AHORRO");
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 20));

        lbNetoT.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbNetoT.setForeground(new java.awt.Color(205, 0, 0));
        lbNetoT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNetoT.setText("0");
        jPanel15.add(lbNetoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 90, 20));

        lbDescuentoT.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDescuentoT.setForeground(new java.awt.Color(0, 153, 0));
        lbDescuentoT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescuentoT.setText("0");
        jPanel15.add(lbDescuentoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 90, 20));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 13, 350, 170));

        jTabbedPane2.addTab("DETALLAR COBRANZA", new javax.swing.ImageIcon(getClass().getResource("/Iconos/efectivo_30.png")), jPanel14); // NOI18N

        Blanco2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 93, 365, 230));

        jPanel19.setBackground(new java.awt.Color(17, 35, 46));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ID Vendedor");
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 20));

        txtCodVendedorT.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        jPanel19.add(txtCodVendedorT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 14, 69, 19));
        jPanel19.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 356, 1));

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("TICKET N°");
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 54, -1, -1));

        txtEPE.setEditable(false);
        txtEPE.setBackground(new java.awt.Color(255, 255, 255));
        txtEPE.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtEPE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEPE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        txtEPE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEPEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEPEKeyTyped(evt);
            }
        });
        jPanel19.add(txtEPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 50, 72, 23));

        txtTicketN.setEditable(false);
        txtTicketN.setBackground(new java.awt.Color(255, 255, 255));
        txtTicketN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtTicketN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTicketN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        txtTicketN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTicketNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTicketNKeyTyped(evt);
            }
        });
        jPanel19.add(txtTicketN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 114, 23));

        lbEmpleadoT.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        lbEmpleadoT.setForeground(new java.awt.Color(255, 255, 255));
        lbEmpleadoT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel19.add(lbEmpleadoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 13, 200, 21));

        Blanco2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 372, 80));

        txtCodT.setEditable(false);
        txtCodT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodTKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout dlgFinTicketLayout = new javax.swing.GroupLayout(dlgFinTicket.getContentPane());
        dlgFinTicket.getContentPane().setLayout(dlgFinTicketLayout);
        dlgFinTicketLayout.setHorizontalGroup(
            dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinTicketLayout.createSequentialGroup()
                .addComponent(Blanco2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtAbonoTL, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgFinTicketLayout.setVerticalGroup(
            dlgFinTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirmarTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAbonoTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Blanco2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        OpcionesEmision.setUndecorated(true);
        OpcionesEmision.setResizable(false);

        Blanco3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco3.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTicket.setBackground(new java.awt.Color(0, 153, 204));
        btnTicket.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TICK_30.png"))); // NOI18N
        btnTicket.setText("TICKET DE VENTA (T)");
        btnTicket.setToolTipText("PULSAR TECLA T");
        btnTicket.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTicket.setBorderPainted(false);
        GrupoOpciones.add(btnTicket);
        btnTicket.setFocusPainted(false);
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });
        btnTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTicketKeyPressed(evt);
            }
        });
        Blanco3.add(btnTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 41, 334, 98));

        btnFacturaLegal.setBackground(new java.awt.Color(255, 102, 0));
        btnFacturaLegal.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnFacturaLegal.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturaLegal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/FACT_30.png"))); // NOI18N
        btnFacturaLegal.setText("FACTURA LEGAL (F)");
        btnFacturaLegal.setToolTipText("PULSAR TECLA F");
        btnFacturaLegal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFacturaLegal.setBorderPainted(false);
        GrupoOpciones.add(btnFacturaLegal);
        btnFacturaLegal.setFocusPainted(false);
        btnFacturaLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaLegalActionPerformed(evt);
            }
        });
        btnFacturaLegal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnFacturaLegalKeyPressed(evt);
            }
        });
        Blanco3.add(btnFacturaLegal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 140, 334, 98));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(17, 35, 46));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMITIR COMPROBANTE COMO:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Blanco3.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 336, 40));

        javax.swing.GroupLayout OpcionesEmisionLayout = new javax.swing.GroupLayout(OpcionesEmision.getContentPane());
        OpcionesEmision.getContentPane().setLayout(OpcionesEmisionLayout);
        OpcionesEmisionLayout.setHorizontalGroup(
            OpcionesEmisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        OpcionesEmisionLayout.setVerticalGroup(
            OpcionesEmisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dlgMinimizado.setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(17, 35, 46));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Gestionar Productos");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 9, 110, 12));

        btnEvento1.setBackground(new java.awt.Color(17, 35, 46));
        btnEvento1.setToolTipText("F12");
        btnEvento1.setBackgroundHover(new java.awt.Color(17, 35, 46));
        btnEvento1.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnEvento1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_UP);
        btnEvento1.setRippleColor(java.awt.Color.white);
        btnEvento1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEvento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvento1ActionPerformed(evt);
            }
        });
        btnEvento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEvento1KeyPressed(evt);
            }
        });
        jPanel3.add(btnEvento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 2, 25, 25));

        javax.swing.GroupLayout dlgMinimizadoLayout = new javax.swing.GroupLayout(dlgMinimizado.getContentPane());
        dlgMinimizado.getContentPane().setLayout(dlgMinimizadoLayout);
        dlgMinimizadoLayout.setHorizontalGroup(
            dlgMinimizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgMinimizadoLayout.setVerticalGroup(
            dlgMinimizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Operación N°");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 40, 78, 23));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
        });
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 40, 128, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Fecha y Hora");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 70, 78, 23));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel19.setText("Mov. Caja N°");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, -1, 23));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCajaKeyPressed(evt);
            }
        });
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 10, 128, 23));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
        });
        jPanel5.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 7, 95, 23));

        txtRazonS.setEditable(false);
        txtRazonS.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSKeyPressed(evt);
            }
        });
        jPanel5.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 7, 330, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Línea de crédito disponible:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 37, -1, 23));

        btnProveedor.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(213, 51, 0));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        btnProveedor.setText("F3-Clientes");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.setFocusPainted(false);
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        btnProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProveedorKeyPressed(evt);
            }
        });
        jPanel5.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 7, -1, -1));

        txtdisponible.setEditable(false);
        txtdisponible.setBackground(new java.awt.Color(255, 255, 255));
        txtdisponible.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtdisponible.setForeground(new java.awt.Color(255, 102, 0));
        txtdisponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdisponible.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtdisponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdisponibleKeyPressed(evt);
            }
        });
        jPanel5.add(txtdisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 37, 100, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("Crédito habilitado:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 37, -1, 23));

        txthabilitado.setEditable(false);
        txthabilitado.setBackground(new java.awt.Color(255, 255, 255));
        txthabilitado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txthabilitado.setForeground(new java.awt.Color(255, 102, 0));
        txthabilitado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txthabilitado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txthabilitado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthabilitadoKeyPressed(evt);
            }
        });
        jPanel5.add(txthabilitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 37, 38, 23));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 550, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaKeyPressed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 70, 78, 23));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraKeyPressed(evt);
            }
        });
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 70, 44, 23));

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rCredito);
        rCredito.setForeground(new java.awt.Color(0, 0, 0));
        rCredito.setText("CREDITO");
        rCredito.setColorCheck(new java.awt.Color(255, 102, 0));
        rCredito.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rCredito.setFocusPainted(false);
        rCredito.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });
        rCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rCreditoKeyPressed(evt);
            }
        });
        jPanel12.add(rCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 30, 95, 23));

        buttonGroup1.add(rContado);
        rContado.setForeground(new java.awt.Color(0, 0, 0));
        rContado.setText("CONTADO");
        rContado.setColorCheck(new java.awt.Color(255, 102, 0));
        rContado.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rContado.setFocusPainted(false);
        rContado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });
        rContado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rContadoKeyPressed(evt);
            }
        });
        jPanel12.add(rContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 95, 23));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, -1, 60));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 105, 560, 180));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtArt.setEditable(false);
        txtArt.setBackground(new java.awt.Color(255, 255, 255));
        txtArt.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtArt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtArt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtActionPerformed(evt);
            }
        });
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArtKeyReleased(evt);
            }
        });
        jPanel2.add(txtArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 34, 492, 23));

        txtCant.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
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
        jPanel2.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 34, 40, 23));

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CANT.");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 20, 40, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        tbDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(20);
        tbDetalle.setShowGrid(true);
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
        tbDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 62, 977, 285));

        lbPublic.setEditable(false);
        lbPublic.setBackground(new java.awt.Color(255, 102, 0));
        lbPublic.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbPublic.setForeground(new java.awt.Color(255, 255, 255));
        lbPublic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPublic.setBorder(null);
        lbPublic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbPublicKeyPressed(evt);
            }
        });
        jPanel2.add(lbPublic, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 5, 420, 23));

        lbPVenta.setEditable(false);
        lbPVenta.setBackground(new java.awt.Color(255, 102, 0));
        lbPVenta.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbPVenta.setForeground(new java.awt.Color(255, 255, 255));
        lbPVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPVenta.setBorder(null);
        lbPVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbPVentaKeyPressed(evt);
            }
        });
        jPanel2.add(lbPVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 34, 420, 23));

        btnBuscarArticulo.setText("CARGAR ARTICULOS - F9");
        btnBuscarArticulo.setToolTipText("F9");
        btnBuscarArticulo.setColorPrimario(new java.awt.Color(255, 102, 0));
        btnBuscarArticulo.setColorPrimarioHover(new java.awt.Color(255, 137, 2));
        btnBuscarArticulo.setColorSecundario(new java.awt.Color(255, 137, 2));
        btnBuscarArticulo.setColorSecundarioHover(new java.awt.Color(255, 102, 0));
        btnBuscarArticulo.setFocusPainted(false);
        btnBuscarArticulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });
        btnBuscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarArticuloKeyPressed(evt);
            }
        });
        jPanel2.add(btnBuscarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 180, 23));

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 285, 977, 330));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel7KeyPressed(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VENTA TOTAL");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 6, 374, 23));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });
        jPanel7.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 35, 374, 30));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel12.setText("TOTAL AHORRO:");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 90, 23));

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 102, 0));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.setText("0");
        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
        });
        jPanel9.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 10, 85, 23));

        txtNeto.setEditable(false);
        txtNeto.setBackground(new java.awt.Color(255, 255, 255));
        txtNeto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtNeto.setForeground(new java.awt.Color(255, 0, 0));
        txtNeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNeto.setText("0");
        txtNeto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetoActionPerformed(evt);
            }
        });
        txtNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetoKeyPressed(evt);
            }
        });
        jPanel9.add(txtNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 10, 85, 23));

        lbNETO.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbNETO.setText("TOTAL S/ DESC.:");
        jPanel9.add(lbNETO, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 23));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 75, 390, 43));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 380, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXENTA");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 86, -1));

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExenta.setText("0");
        txtExenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtExenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExentaKeyPressed(evt);
            }
        });
        jPanel8.add(txtExenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 22, 86, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 7, 86, -1));

        txt5.setEditable(false);
        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setText("0");
        txt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt5KeyPressed(evt);
            }
        });
        jPanel8.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 22, 86, 20));

        txt10.setEditable(false);
        txt10.setBackground(new java.awt.Color(255, 255, 255));
        txt10.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10.setText("0");
        txt10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt10KeyPressed(evt);
            }
        });
        jPanel8.add(txt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 22, 86, 20));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 7, 86, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 129, 300, 50));

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, -1));

        Blanco.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 105, 400, 180));

        panelCabecera.setBackground(new java.awt.Color(17, 35, 46));
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
        panelCabecera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelCabeceraKeyPressed(evt);
            }
        });
        panelCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEvento.setBackground(new java.awt.Color(17, 35, 46));
        btnEvento.setToolTipText("MINIMIZAR");
        btnEvento.setBackgroundHover(new java.awt.Color(255, 102, 0));
        btnEvento.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_DOWN);
        btnEvento.setRippleColor(java.awt.Color.white);
        btnEvento.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventoActionPerformed(evt);
            }
        });
        btnEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEventoKeyPressed(evt);
            }
        });
        panelCabecera.add(btnEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 3, 20, 20));

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
        panelCabecera.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 3, 20, 20));

        txtidEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidEmisionActionPerformed(evt);
            }
        });
        panelCabecera.add(txtidEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 13, 71, -1));
        panelCabecera.add(txtFechaReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 43, 70, -1));

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
        panelCabecera.add(btnModCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 13, 38, 21));

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        panelCabecera.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 42, -1, -1));

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelCabecera.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 13, 63, 22));

        lbCond.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCabecera.add(lbCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 81, 20));

        lbCred.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        lbCred.setText("jLabel12");
        panelCabecera.add(lbCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 42, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelCabecera.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 63, -1, -1));

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 102, 0));
        btnNuevo.setToolTipText("F1");
        btnNuevo.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnNuevo.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setRippleColor(java.awt.Color.white);
        btnNuevo.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        PnlNuevo2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador9.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo2.add(Separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo9.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo9.setText("NUEVO");
        PnlNuevo2.add(LabelTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel20.add(PnlNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlGuardar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setToolTipText("F6");
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
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        PnlGuardar1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador11.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar1.add(Separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo11.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo11.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo11.setText("REGISTRAR");
        PnlGuardar1.add(LabelTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel20.add(PnlGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlCancelar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlCancelar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setToolTipText("ESCAPE");
        btnCancelar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCancelar.setForegroundHover(new java.awt.Color(153, 0, 51));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setRippleColor(java.awt.Color.white);
        btnCancelar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        PnlCancelar1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador12.setForeground(new java.awt.Color(204, 204, 204));
        PnlCancelar1.add(Separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo12.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo12.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo12.setText("CANCELAR");
        PnlCancelar1.add(LabelTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel20.add(PnlCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        panelCabecera.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 110));

        txtCodArticulo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        panelCabecera.add(txtCodArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 37, 20));

        Blanco.add(panelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 978, 102));

        etiCant.setBackground(new java.awt.Color(17, 35, 46));
        etiCant.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        etiCant.setForeground(new java.awt.Color(255, 255, 255));
        etiCant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiCant.setText("Artículos registrados:");
        etiCant.setOpaque(true);
        etiCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                etiCantKeyPressed(evt);
            }
        });
        Blanco.add(etiCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 632, 977, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlFactura.addTabla(txtCodArticulo.getText(), tbDetalle);
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
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCantKeyPressed

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
        AccesoRapidoFactura(evt.getKeyCode());
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
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement()) {
            int resp = JOptionPane.showConfirmDialog(dlgFinFacturaL, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    cn.setAutoCommit(false);
                    String sql = "insert into factura_l values(" + txtCodF.getText() + "," + txtCodVendedorF.getText() + "," + txtCodCliente.getText() + "," + txtCaja.getText() + "," + txtidEmision.getText() + ", '" + txtEstablecimiento.getText() + "-" + txtEmision.getText() + "-" + txtFacturaN.getText() + "','" + cond + "','"
                            + txtFechaReal.getText().trim() + "','" + txtHora.getText().trim() + "'," + txtTotal.getText().replace(".", "").replace(",", "") + "," + txtExenta.getText().replace(".", "").replace(",", "") + "," + txt5.getText().replace(".", "").replace(",", "") + "," + txt10.getText().replace(".", "").replace(",", "") + ",'S','" + Login.getUsuarioLogueado() + "','" + est + "')";
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
                    //Mensajes.informacion("VENTA REGISTRADA EXITOSAMENTE");
                    Notif.NotifySuccess("Notificación del sistema", "Venta registrada satisfactoriamente!");
                    dlgFinFacturaL.dispose();
                    String Letra = L.Convertir((txtTotal.getText().replace(".", "").replace(",", "")), true);
                    llamarReporteFactura(Integer.parseInt(txtCodF.getText().trim()), Letra);
                    Cancelar();
                    txtAbonoF.setText("0");
                    txtVueltoF.setText("0");
                    cant();
                } catch (SQLException e) {
                    try {
                        cn.rollback();
                        cn.close();
                        //Mensajes.error("TRANSACCION FALLIDA.\nLOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        Notif.NotifyError("Notificación del sistema", "TRANSACCION FALLIDA.\nLOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        dlgFinFacturaL.dispose();
                        Cancelar();

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

    private void txtCodVendedorFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVendedorFActionPerformed
        // TODO add your handling code here:
        if (txtCodVendedorF.getText().isEmpty()) {
            btnConfirmarFactura.setEnabled(false);
            txtCodVendedorF.requestFocus();
            txtCodVendedorF.selectAll();
            dlgVentas.txtAbonoF.setEditable(false);
        } else if (Integer.parseInt(txtCodVendedorF.getText()) <= 0) {
            Mensajes.error("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
            btnConfirmarFactura.setEnabled(false);
            txtCodVendedorF.requestFocus();
            txtCodVendedorF.selectAll();
        } else {
            try {
                Vendedor vn = GestionarVendedor.busVendedorFactura(txtCodVendedorF.getText());
                lbEmpleadoF.setText(vn.getNombreV());
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_txtCodVendedorFActionPerformed

    private void txtCodVendedorFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorFKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCodVendedorF);
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtCodVendedorFKeyPressed

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

        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement()) {
            int resp = JOptionPane.showConfirmDialog(dlgFinTicket, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    cn.setAutoCommit(false);
                    String sql = "insert into factura values(" + txtCodT.getText() + "," + txtCodVendedorT.getText() + "," + txtCodCliente.getText() + "," + txtCaja.getText() + "," + txtidEmision.getText() + ",'" + txtEPE.getText() + txtTicketN.getText() + "','" + cond + "','"
                            + txtFechaReal.getText().trim() + "','" + txtHora.getText().trim() + "'," + txtTotal.getText().replace(".", "").replace(",", "") + "," + txtExenta.getText().replace(".", "").replace(",", "") + "," + txt5.getText().replace(".", "").replace(",", "") + "," + txt10.getText().replace(".", "").replace(",", "") + ",'S','" + Login.getUsuarioLogueado() + "','" + est + "')";
                    String sql3 = "update puntoemision set facturaactual=" + Integer.valueOf(txtTicketN.getText().trim()) + " where idemision=" + txtidEmision.getText().trim();

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
                    //Mensajes.Sistema("VENTA REGISTRADA EXITOSAMENTE");
                    Notif.NotifySuccess("Notificación del sistema", "Venta registrada satisfactoriamente!");
                    dlgFinTicket.dispose();
                    if (cond.equals("CONTADO")) {
                        imprimirTicket();
                        Cancelar();
                        txtAbonoT.setText("0");
                        txtVueltoT.setText("0");
                        cant();
                    } else {
                        jasper.BoletaCredito("\\Reports\\ventas\\venta_credito.jasper", "cod", Integer.valueOf(txtCodT.getText().trim()));
                        jasper.cerrar();
                        Cancelar();
                        txtAbonoT.setText("0");
                        txtVueltoT.setText("0");
                        cant();
                    }
                } catch (SQLException e) {
                    try {
                        cn.rollback();
                        cn.close();
                       // Mensajes.error("TRANSACCION FALLIDA.\nLOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        Notif.NotifyError("Notificación del sistema", "TRANSACCION FALLIDA.\nLOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        Cancelar();
                        dlgFinTicket.dispose();
                    } catch (SQLException se) {
                        Mensajes.error(se.getMessage());
                    }
                }
            }
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarTicketActionPerformed

    private void txtCodVendedorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVendedorTActionPerformed
        // TODO add your handling code here:
        if (txtCodVendedorT.getText().isEmpty()) {
            btnConfirmarTicket.setEnabled(false);
            txtCodVendedorT.requestFocus();
            txtCodVendedorT.selectAll();
            dlgVentas.txtAbonoT.setEditable(false);
        } else if (Integer.parseInt(txtCodVendedorT.getText()) <= 0) {
            Mensajes.Sistema("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
            btnConfirmarTicket.setEnabled(false);
            txtCodVendedorT.requestFocus();
            txtCodVendedorT.selectAll();
            dlgVentas.txtAbonoT.setEditable(false);
        } else {
            try {
                Vendedor vn = GestionarVendedor.busVendedorTicket(txtCodVendedorT.getText());
                lbEmpleadoT.setText(vn.getNombreV());
            } catch (Exception e) {
                System.out.println("Error txtCodVendedorTActionPerformed: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtCodVendedorTActionPerformed

    private void txtCodVendedorTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorTKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCodVendedorT);
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_txtCodVendedorTKeyPressed

    private void txtTicketNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTicketNKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
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

    private void dlgFinTicketWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgFinTicketWindowOpened
        // TODO add your handling code here:
        txtCodVendedorT.requestFocus();
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

    private void txtEPEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEPEKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_txtEPEKeyPressed

    private void txtEPEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEPEKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEPEKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
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
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        btnBuscarArticulo.doClick();
        habilitarCANTCOSTO();
        Rendes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getRowCount() <= 0) {
            Mensajes.Sistema("No se puede procesar la venta.\nEl detalle de articulos a vender se encuentra vacio.");
            btnBuscarArticulo.doClick();
        } else {
            if (lbCond.getText().equals("CONTADO")) {
                DecimalFormat df = new DecimalFormat("#,###");
                if (dlgVentas.txtNeto.getText().replace(".", "").replace(",", "").length() >= 1) {
                    dlgVentas.lbNetoF.setText(dlgVentas.txtNeto.getText());
                    dlgVentas.lbNetoT.setText(dlgVentas.txtNeto.getText());
                }
                if (dlgVentas.txtDescuento.getText().replace(".", "").replace(",", "").length() >= 1) {
                    dlgVentas.lbDescuentoF.setText(dlgVentas.txtDescuento.getText());
                    dlgVentas.lbDescuentoT.setText(dlgVentas.txtDescuento.getText());
                }
                if (Timbrado.getValidado().equals("SI")) {
                    btnFacturaLegal.setEnabled(true);
                } else if (Timbrado.getValidado().equals("NO")) {
                    btnFacturaLegal.setEnabled(false);
                }

                if (Tickets.getHabilitado().equals("SI")) {
                    btnTicket.setEnabled(true);
                } else if (Tickets.getHabilitado().equals("NO")) {
                    btnTicket.setEnabled(false);
                }
                OpcionesEmision.setSize(338, 241);
                OpcionesEmision.setLocationRelativeTo(this);
                OpcionesEmision.setModal(true);
                OpcionesEmision.setTitle("OPCIONES DE EMISIÓN");
                OpcionesEmision.setVisible(true);
            } else {
                if (Integer.parseInt(txtTotal.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtdisponible.getText().replace(".", "").replace(",", ""))) {
                    DecimalFormat df = new DecimalFormat("#,###");
                    if (dlgVentas.txtNeto.getText().replace(".", "").replace(",", "").trim().length() >= 1) {
                        dlgVentas.lbNetoF.setText(dlgVentas.txtNeto.getText());
                        dlgVentas.lbNetoT.setText(dlgVentas.txtNeto.getText());
                    }
                    if (dlgVentas.txtDescuento.getText().replace(".", "").replace(",", "").length() >= 1) {
                        dlgVentas.lbDescuentoF.setText(dlgVentas.txtDescuento.getText());
                        dlgVentas.lbDescuentoT.setText(dlgVentas.txtDescuento.getText());
                    }
                    if (Timbrado.getValidado().equals("SI")) {
                        btnFacturaLegal.setEnabled(true);
                    } else if (Timbrado.getValidado().equals("NO")) {
                        btnFacturaLegal.setEnabled(false);
                    }

                    if (Tickets.getHabilitado().equals("SI")) {
                        btnTicket.setEnabled(true);
                    } else if (Tickets.getHabilitado().equals("NO")) {
                        btnTicket.setEnabled(false);
                    }
                    OpcionesEmision.setSize(338, 241);
                    OpcionesEmision.setLocationRelativeTo(this);
                    OpcionesEmision.setModal(true);
                    OpcionesEmision.setTitle("OPCIONES DE EMISIÓN");
                    OpcionesEmision.setVisible(true);
                } else {
                    Mensajes.Sistema("No es posible registrar esta venta.\nEl Total supera la línea de crédito disponible para este cliente.");
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlFactura.canCelar();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rCreditoActionPerformed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscadorArticuloVenta baf = new dlgBuscadorArticuloVenta(null, true);
            baf.setLocationRelativeTo(null);
            //baf.setLocation(228, 270);
            baf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void btnBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticuloKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarArticuloKeyPressed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void rContadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rContadoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rContadoKeyPressed

    private void rCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rCreditoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rCreditoKeyPressed

    private void btnProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProveedorKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnProveedorKeyPressed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void txthabilitadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthabilitadoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txthabilitadoKeyPressed

    private void txtdisponibleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdisponibleKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtdisponibleKeyPressed

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtNetoKeyPressed

    private void txtExentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExentaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtExentaKeyPressed

    private void txt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txt5KeyPressed

    private void txt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt10KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txt10KeyPressed

    private void txtArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtArtKeyPressed

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleKeyPressed

    private void btnTicketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTicketKeyPressed
        // TODO add your handling code here:
        AccesoRapidoOpciones(evt.getKeyCode());
    }//GEN-LAST:event_btnTicketKeyPressed

    private void btnFacturaLegalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFacturaLegalKeyPressed
        // TODO add your handling code here:
        AccesoRapidoOpciones(evt.getKeyCode());
    }//GEN-LAST:event_btnFacturaLegalKeyPressed

    private void txtAbonoTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoTKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_txtAbonoTKeyPressed

    private void txtVueltoTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVueltoTKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_txtVueltoTKeyPressed

    private void jPanel14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel14KeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_jPanel14KeyPressed

    private void lbEmpleadoFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbEmpleadoFKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_lbEmpleadoFKeyPressed

    private void lbTimbradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbTimbradoKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_lbTimbradoKeyPressed

    private void lbValidazKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbValidazKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_lbValidazKeyPressed

    private void txtEstablecimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstablecimientoKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtEstablecimientoKeyPressed

    private void txtEmisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmisionKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtEmisionKeyPressed

    private void txtAbonoFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoFKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtAbonoFKeyPressed

    private void txtVueltoFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVueltoFKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtVueltoFKeyPressed

    private void txtCodFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtCodFKeyPressed

    private void txtAbonoLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoLKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_txtAbonoLKeyPressed

    private void btnConfirmarFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmarFacturaKeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_btnConfirmarFacturaKeyPressed

    private void jPanel10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel10KeyPressed
        // TODO add your handling code here:
        AccesoRapidoFactura(evt.getKeyCode());
    }//GEN-LAST:event_jPanel10KeyPressed

    private void btnConfirmarTicketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmarTicketKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_btnConfirmarTicketKeyPressed

    private void txtAbonoTLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoTLKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_txtAbonoTLKeyPressed

    private void txtCodTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTKeyPressed
        // TODO add your handling code here:
        AccesoRapidoTicket(evt.getKeyCode());
    }//GEN-LAST:event_txtCodTKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_jPanel1KeyPressed

    private void lbPublicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbPublicKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_lbPublicKeyPressed

    private void lbPVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbPVentaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_lbPVentaKeyPressed

    private void jPanel7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel7KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_jPanel7KeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtTotalKeyPressed

    private void panelCabeceraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelCabeceraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_panelCabeceraKeyPressed

    private void txtFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtFechaKeyPressed

    private void txtHoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtHoraKeyPressed

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCajaKeyPressed

    private void etiCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etiCantKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_etiCantKeyPressed

    private void btnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventoActionPerformed
        // TODO add your handling code here:
        min = 1;
        System.out.println("btnEvento min: " + min);
        this.setVisible(false);
        Notif.Notify_Minim_dlgVentas("Notificación del sistema", "Formulario de Ventas minimizado.\r\n\nHaga click sobre esta notificación para visualizarlo nuevamente.");
    }//GEN-LAST:event_btnEventoActionPerformed

    private void btnEventoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEventoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEventoKeyPressed

    private void btnEvento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvento1ActionPerformed
        // TODO add your handling code here:
        min = 0;
        System.out.println("btnEvento1 min: " + min);
        dlgMinimizado.dispose();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }//GEN-LAST:event_btnEvento1ActionPerformed

    private void btnEvento1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEvento1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEvento1KeyPressed

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if(btnNuevo.isEnabled() && txtArt.getText().isEmpty()){
            btnNuevo.requestFocus();
        }else if (btnBuscarArticulo.isEnabled() && txtArt.getText().isEmpty()){
            btnBuscarArticulo.requestFocus();
        }
    }//GEN-LAST:event_formWindowActivated

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
    private javax.swing.JLabel LabelTitulo11;
    private javax.swing.JLabel LabelTitulo12;
    private javax.swing.JLabel LabelTitulo9;
    public static javax.swing.JDialog OpcionesEmision;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar1;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar1;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo2;
    private javax.swing.JSeparator Separador11;
    private javax.swing.JSeparator Separador12;
    private javax.swing.JSeparator Separador9;
    private javax.swing.JButton btnAdd;
    private rojeru_san.rsbutton.RSButtonGradiente btnBuscarArticulo;
    public static RSMaterialComponent.RSButtonIconUno btnCancelar;
    public static javax.swing.JButton btnConfirmarFactura;
    public static javax.swing.JButton btnConfirmarTicket;
    public static RSMaterialComponent.RSButtonIconUno btnEvento;
    public static RSMaterialComponent.RSButtonIconUno btnEvento1;
    public static javax.swing.JButton btnFacturaLegal;
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    private javax.swing.JButton btnModCantidad;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    public static javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRestar;
    public static RSMaterialComponent.RSButtonIconUno btnSalir;
    public static javax.swing.JButton btnTicket;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JDialog dlgFinFacturaL;
    public static javax.swing.JDialog dlgFinTicket;
    private javax.swing.JFrame dlgMinimizado;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itemCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    protected javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
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
    private javax.swing.JPopupMenu menuEmergente;
    private javax.swing.JPanel panelCabecera;
    public static rojerusan.RSRadioButton rContado;
    public static rojerusan.RSRadioButton rCredito;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt5;
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
    public static javax.swing.JTextField txtEPE;
    public static javax.swing.JTextField txtEmision;
    public static javax.swing.JTextField txtEstablecimiento;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtFacturaN;
    public static javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaReal;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtNeto;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTicketN;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtVueltoF;
    public static javax.swing.JTextField txtVueltoT;
    public static javax.swing.JTextField txtdisponible;
    public static javax.swing.JTextField txthabilitado;
    public static javax.swing.JTextField txtidEmision;
    // End of variables declaration//GEN-END:variables

}
