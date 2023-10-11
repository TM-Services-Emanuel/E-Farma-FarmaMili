package IU;

import Componentes.DataSourceService;
import Componentes.DecimalFormatRenderer;
import Componentes.Empresa;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.RenderDecimal;
import Componentes.ReporteF;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import Datos.GestionarArticulos;
import Datos.GestionarFactura;
import java.awt.event.KeyEvent;
import Modelo.Articulo;
import java.awt.BorderLayout;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public final class dlgTransferencia extends javax.swing.JDialog {

    public ReporteF jasper;
    static DataSourceService dss = new DataSourceService();

    public dlgTransferencia(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        titulo();
        jasper = new ReporteF();
        CabecerasTablas.Transferencias(tbDetalle);
        Cancelar();
        pintarCondicion();
        Invisible();
        cargarComboBox.cargar(cboDestino, "SELECT * FROM v_sucursal WHERE suc_indicador='S' AND mi_suc='N'");
    }

    private void AccesoRapido(int n) {
        switch (n) {
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_F6 ->
                btnGuardar.doClick();
            case KeyEvent.VK_ALT | KeyEvent.VK_F4 ->
                btnSalir.doClick();
            case KeyEvent.VK_ESCAPE ->
                btnCancelar.doClick();
            case KeyEvent.VK_DELETE ->
                btnRestar.doClick();
            case KeyEvent.VK_F9 ->
                btnBuscarArticulo.doClick();
            default -> {
            }
        }
        System.out.println(n);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Venta de artículos");
        } else {
            this.setTitle(Software.getSoftware() + " - Venta de artículos");
        }
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

    private void Deshabilitar() {
        if (tbDetalle.getRowCount() > 0) {
            rEntrada.setEnabled(false);
            rSalida.setEnabled(false);
            cboDestino.setEnabled(false);
        } else {
            rEntrada.setEnabled(true);
            rSalida.setEnabled(true);
            cboDestino.setEnabled(true);
        }
    }

    public void Cancelar() {
        limpiarCampos();
        rEntrada.setEnabled(false);
        rSalida.setSelected(true);
        rSalida.setEnabled(false);
        cboDestino.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnNuevo.requestFocus();
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        cant();
    }

    public void Rendes() {
        dlgTransferencia.tbDetalle.getColumnModel().getColumn(3).setCellRenderer(new DecimalFormatRenderer());
        dlgTransferencia.tbDetalle.getColumnModel().getColumn(4).setCellRenderer(new DecimalFormatRenderer());
        dlgTransferencia.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new DecimalFormatRenderer());
        dlgTransferencia.tbDetalle.getColumnModel().getColumn(6).setCellRenderer(new DecimalFormatRenderer());
        dlgTransferencia.tbDetalle.getColumnModel().getColumn(7).setCellRenderer(new DecimalFormatRenderer());

        dlgTransferencia.tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimal());
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCred.setVisible(false);
        txtCodArticulo.setVisible(false);
        txtFechaReal.setVisible(false);
    }

    public void cant() {
        int total = tbDetalle.getRowCount();
        etiCant.setText("CANTIDAD DE ITEMS A TRANSFERIR: " + String.valueOf(total));
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

    private void limpiarCampos() {
        rSalida.doClick();
        txtCod.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtCosto.setText("");
        txtExenta.setText("0");
        txt5.setText("0");
        txt10.setText("0");
        txtCaja.setText("");
        txtTipo.setText("");

        cboDestino.setSelectedIndex(0);
        txtIdOrigen.setText("");
        txtIdDestino.setText("");
        lbSucursalOrigen.setText("");
        CabecerasTablas.limpiarTablasTransferencias(tbDetalle);
        CabecerasTablas.Transferencias(tbDetalle);
        controlFactura.canCelar();
    }

    public static void habilitarCANTCOSTO() {
        if (txtArt.getText().isEmpty()) {
            txtCant.setEnabled(false);
            txtCosto.setEnabled(false);
        } else {
            txtCant.setEnabled(true);
            txtCant.requestFocus();
            if (rEntrada.isSelected()) {
                txtCosto.setEnabled(true);
            } else if (rSalida.isSelected()) {
                txtCosto.setEnabled(false);
            }
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
 /*public static void imprimirTicket() {
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
    }*/

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

        menuEmergente = new javax.swing.JPopupMenu();
        itemCantidad = new javax.swing.JMenuItem();
        GrupoOpciones = new javax.swing.ButtonGroup();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        lbDestinoOrigen = new javax.swing.JLabel();
        cboDestino = new RSMaterialComponent.RSComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        rSalida = new rojerusan.RSCheckBox();
        rEntrada = new rojerusan.RSCheckBox();
        lbSucursalOrigen = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        panelGrabados = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtFechaReal = new javax.swing.JTextField();
        btnRestar = new javax.swing.JButton();
        lbCred = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel20 = new javax.swing.JPanel();
        PnlNuevo = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PnlGuardar = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        PnlCancelar = new rojeru_san.rspanel.RSPanelImage();
        btnCancelar = new RSMaterialComponent.RSButtonIconUno();
        Separador4 = new javax.swing.JSeparator();
        LabelTitulo4 = new javax.swing.JLabel();
        txtIdDestino = new javax.swing.JTextField();
        txtIdOrigen = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        etiCant = new javax.swing.JLabel();
        btnBuscarArticulo = new rojeru_san.rsbutton.RSButtonGradiente();
        txtArt = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        txtCodArticulo = new javax.swing.JTextField();

        itemCantidad.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        itemCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_black_20.png"))); // NOI18N
        itemCantidad.setText("Modificar Cantidad");
        itemCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCantidadActionPerformed(evt);
            }
        });
        menuEmergente.add(itemCantidad);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel1.setText("Operación N°:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 13, -1, 23));

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
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 12, 128, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("Fecha y Hora:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 13, 71, 23));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel19.setText("Mov. Caja N°:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 13, -1, 23));

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
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 12, 128, 23));

        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaKeyPressed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 12, 78, 23));

        txtHora.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraKeyPressed(evt);
            }
        });
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 12, 44, 23));

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel29.setText("Modalidad de Tranferencia:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 80, -1, 25));

        lbDestinoOrigen.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDestinoOrigen.setText("Destino de la transferencia:");
        lbDestinoOrigen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lbDestinoOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 80, -1, 25));

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
        jPanel1.add(cboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 80, -1, 25));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 43, 651, 10));

        GrupoOpciones.add(rSalida);
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
        jPanel1.add(rSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 80, 67, 25));

        GrupoOpciones.add(rEntrada);
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
        jPanel1.add(rEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 80, 71, 25));

        lbSucursalOrigen.setBackground(new java.awt.Color(255, 102, 0));
        lbSucursalOrigen.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbSucursalOrigen.setForeground(new java.awt.Color(255, 255, 255));
        lbSucursalOrigen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSucursalOrigen.setOpaque(true);
        jPanel1.add(lbSucursalOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 50, 651, 23));

        Blanco.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 109, 678, 115));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MONTO TRANSFERENCIA");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 298, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel7.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 30, 283, 30));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 290, -1));

        panelGrabados.setBackground(new java.awt.Color(255, 255, 255));
        panelGrabados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXENTA");
        panelGrabados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 86, -1));

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
        panelGrabados.add(txtExenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 22, 86, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");
        panelGrabados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 7, 86, -1));

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
        panelGrabados.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 22, 86, 20));

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
        panelGrabados.add(txt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 22, 86, 20));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");
        panelGrabados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 7, 86, -1));

        jPanel7.add(panelGrabados, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 67, 298, 45));

        Blanco.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 109, 310, 115));

        jPanel6.setBackground(new java.awt.Color(17, 35, 46));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(txtFechaReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 70, -1));

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        jPanel6.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        lbCred.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        lbCred.setText("jLabel12");
        jPanel6.add(lbCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 13, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel6.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
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
        jPanel6.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(987, 2, 20, 20));

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

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

        Separador1.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("NUEVO");

        javax.swing.GroupLayout PnlNuevoLayout = new javax.swing.GroupLayout(PnlNuevo);
        PnlNuevo.setLayout(PnlNuevoLayout);
        PnlNuevoLayout.setHorizontalGroup(
            PnlNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador1)
                    .addComponent(LabelTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlNuevoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlNuevoLayout.setVerticalGroup(
            PnlNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, -1));

        PnlGuardar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(0, 102, 0));
        btnGuardar.setToolTipText("F6");
        btnGuardar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setEnabled(false);
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

        Separador3.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("REGISTRAR");

        javax.swing.GroupLayout PnlGuardarLayout = new javax.swing.GroupLayout(PnlGuardar);
        PnlGuardar.setLayout(PnlGuardarLayout);
        PnlGuardarLayout.setHorizontalGroup(
            PnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador3)
                    .addComponent(LabelTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlGuardarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlGuardarLayout.setVerticalGroup(
            PnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, -1));

        PnlCancelar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setToolTipText("ESCAPE");
        btnCancelar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCancelar.setEnabled(false);
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

        Separador4.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo4.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo4.setText("CANCELAR");

        javax.swing.GroupLayout PnlCancelarLayout = new javax.swing.GroupLayout(PnlCancelar);
        PnlCancelar.setLayout(PnlCancelarLayout);
        PnlCancelarLayout.setHorizontalGroup(
            PnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador4)
                    .addComponent(LabelTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlCancelarLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        PnlCancelarLayout.setVerticalGroup(
            PnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.add(PnlCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, -1));

        jPanel6.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel6.add(txtIdDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 40, -1));
        jPanel6.add(txtIdOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 40, -1));
        jPanel6.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 30, -1));

        Blanco.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1010, -1));

        etiCant.setBackground(new java.awt.Color(17, 35, 46));
        etiCant.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        etiCant.setForeground(new java.awt.Color(255, 255, 255));
        etiCant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiCant.setText("Artículos registrados:");
        etiCant.setOpaque(true);
        Blanco.add(etiCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 668, 1008, 16));

        btnBuscarArticulo.setText("CARGAR ARTICULOS - F9");
        btnBuscarArticulo.setToolTipText("F9");
        btnBuscarArticulo.setColorPrimario(new java.awt.Color(255, 102, 0));
        btnBuscarArticulo.setColorPrimarioHover(new java.awt.Color(255, 137, 2));
        btnBuscarArticulo.setColorSecundario(new java.awt.Color(255, 137, 2));
        btnBuscarArticulo.setColorSecundarioHover(new java.awt.Color(255, 102, 0));
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
        Blanco.add(btnBuscarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 230, 180, 23));

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
        Blanco.add(txtArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 230, 492, 23));

        txtCant.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        Blanco.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 45, 23));

        txtCosto.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
        });
        Blanco.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 230, 80, 23));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CANT");
        Blanco.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 35, 23));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("COSTO");
        Blanco.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 40, 23));

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
        tbDetalle.setFillsViewportHeight(true);
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

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 257, 1008, 410));

        txtCodArticulo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        Blanco.add(txtCodArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 37, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlFactura.addTablaTransferencia(txtCodArticulo.getText(), tbDetalle);
        txtCodArticulo.setText("");
        txtArt.setText("");
        txtCant.setText("");
        txtCosto.setText("");
        habilitarCANTCOSTO();
        Rendes();
        Deshabilitar();
        cant();
        btnBuscarArticuloActionPerformed(null);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlFactura.delRenglonTransferencia(tbDetalle);
            Deshabilitar();
            cant();
        } catch (Exception e) {
            Mensajes.Sistema("No es posible quitar ningún item.\nPor favor, seleccione en la tabla el producto que desea eliminar de la lista de transferencias.");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

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
        if (dlgTransferencia.tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlFactura.actCantidadTransferencia(tbDetalle);
            } catch (Exception e) {
                System.out.println("Error btnModCantidad: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_itemCantidadActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.ObtenerCodigo("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        txtCod.setText(GestionarFactura.getTransferencia());
        txtFechaReal.setText(Fecha.fechaCorrecta());
        txtFecha.setText(Fecha.fechaFormulario());
        txtHora.setText(Fecha.darHoraSinSS());
        btnBuscarArticulo.setEnabled(true);
        txtCant.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        rSalida.setEnabled(true);
        rEntrada.setEnabled(true);
        cboDestino.setEnabled(true);
        rSalida.doClick();
        Rendes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
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
        } else if (tbDetalle.getRowCount() == 0) {
            Mensajes.Sistema("Tabla de transferencias vacía.\nPor favor, proceda a cargar los items a transferir y vuelva a intentarlo.");
        } else {
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement()) {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    txtCod.setText(GestionarFactura.getTransferencia());
                    try {
                        cn.setAutoCommit(false);
                        String sql = "insert into transferencia values(" + txtCod.getText() + "," + Empresa.getIdSucursal() + "," + txtCaja.getText() + ",'" + txtFechaReal.getText() + "','" + txtHora.getText() + "','" + txtTipo.getText() + "', " + txtIdOrigen.getText() + "," + txtIdDestino.getText() + ","
                                + txtTotal.getText().replace(".", "").replace(",", "") + "," + txtExenta.getText().replace(".", "").replace(",", "") + "," + txt5.getText().replace(".", "").replace(",", "") + ","
                                + txt10.getText().replace(".", "").replace(",", "") + ",'S','PR','" + Login.getUsuarioLogueado() + "')";
                        st.executeUpdate(sql);
                        int fila = tbDetalle.getRowCount();
                        for (int j = 0; j < fila; j++) {
                            String filas[] = {
                                tbDetalle.getValueAt(j, 0).toString(),//ID PRODUCTO -- 0
                                tbDetalle.getValueAt(j, 3).toString(),//CANTIDAD -- 1
                                tbDetalle.getValueAt(j, 4).toString(),//PRECIO -- 2
                                tbDetalle.getValueAt(j, 5).toString(),//EXENTA -- 3
                                tbDetalle.getValueAt(j, 6).toString(),//IVA5 -- 4
                                tbDetalle.getValueAt(j, 7).toString(),//IVA10 -- 5
                                tbDetalle.getValueAt(j, 8).toString(),//SUB-TOTAL -- 6
                                tbDetalle.getValueAt(j, 9).toString(),//GANANCIA -- 7
                                tbDetalle.getValueAt(j, 10).toString(),//DESCUENTO -- 8
                                tbDetalle.getValueAt(j, 11).toString(),//ORDEN -- 9
                                tbDetalle.getValueAt(j, 12).toString()//IVACOSTO -- 10
                            };
                            sql = "insert into detalle_transferencia values(" + txtCod.getText() + "," + filas[0] + "," + filas[1].replace(".", "").replace(",", "") + "," + filas[2].replace(".", "").replace(",", "") + "," + filas[3].replace(".", "").replace(",", "") + "," + filas[4].replace(".", "").replace(",", "") + "," + filas[5].replace(".", "").replace(",", "") + "," + filas[6].replace(".", "").replace(",", "") + "," + filas[9] + ")";
                            String sql2 = "UPDATE articulo SET art_stock=art_stock+" + filas[1] + ", art_costo=" + filas[2] + ", art_costoiva=" + filas[10] + ", art_ganancia=" + filas[7] + ", art_descuento=" + filas[8] + " WHERE  art_codigo=" + filas[0];
                            String sql3 = "UPDATE articulo SET art_stock=art_stock-" + filas[1] + " WHERE  art_codigo=" + filas[0];
                            st.executeUpdate(sql);
                            if (txtTipo.getText().equals("E")) {
                                st.executeUpdate(sql2);
                            } else if (txtTipo.getText().equals("S")) {
                                st.executeUpdate(sql3);
                            }
                        }
                        cn.commit();
                        st.close();
                        cn.close();
                        Mensajes.informacion("TRANSFERENCIA REALIZADA!");
                        CabecerasTablas.limpiarTablasTransferencias(tbDetalle);
                        CabecerasTablas.Transferencias(tbDetalle);
                        controlFactura.canCelarTransf();
                        cant();
                        llamarReporteTransferencia(Integer.parseInt(txtCod.getText().trim()));
                        Cancelar();
                    } catch (SQLException e) {
                        try {
                            cn.rollback();
                            cn.close();
                            Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                            controlFactura.canCelarTransf();
                        } catch (SQLException se) {
                            Mensajes.error(se.getMessage());
                        }
                    }
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar esta Transferencia?");
        if (rpta == 0) {
            limpiarCampos();
            rEntrada.setEnabled(false);
            rSalida.setSelected(true);
            rSalida.setEnabled(false);
            cboDestino.setEnabled(false);
            btnBuscarArticulo.setEnabled(false);
            txtCant.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnNuevo.requestFocus();
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnSalir.setEnabled(true);
            cant();
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

    private void rSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSalidaActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
        MensajeTransferencia();
        cboDestinoActionPerformed(null);
        habilitarCANTCOSTO();
    }//GEN-LAST:event_rSalidaActionPerformed

    private void rEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntradaActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
        MensajeTransferencia();
        cboDestinoActionPerformed(null);
        habilitarCANTCOSTO();
    }//GEN-LAST:event_rEntradaActionPerformed

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

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
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
            try {
                dlgBuscadorArticuloTransferencia baf = new dlgBuscadorArticuloTransferencia(null, true);
                baf.setLocationRelativeTo(null);
                baf.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("No hay conexión con el servidor");
            }
        }

    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCosto);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtCosto.getText().isEmpty()) {
                txtCosto.selectAll();
            } else if (txtCosto.getText().equals("0")) {
                txtCosto.selectAll();
            } else {
                btnAdd.doClick();
            }
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCant);
        Articulo Ar = GestionarArticulos.busArticulo((txtCodArticulo.getText()));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtCant.getText().isEmpty()) {
                txtCant.selectAll();
            } else if (txtCant.getText().equals("0")) {
                txtCant.selectAll();
            } else if (rSalida.isSelected() && Integer.parseInt(txtCant.getText()) > Ar.getStock()) {
                Mensajes.error("Cantidad supera el Stock actual");
                txtCant.requestFocus();
                txtCant.setText(String.valueOf(Ar.getStock()));
                txtCant.selectAll();
            } else if (rSalida.isSelected() && Integer.parseInt(txtCant.getText()) <= Ar.getStock() || rEntrada.isSelected()) {
                if (txtCosto.isEnabled()) {
                    txtCosto.requestFocus();
                } else {
                    btnAdd.doClick();
                }

            }
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCantKeyPressed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArtKeyReleased

    private void txtArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArtActionPerformed

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            txtCosto.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            System.out.println("Error costo key released: " + e.getMessage());
        }
    }//GEN-LAST:event_txtCostoKeyReleased

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

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtFechaKeyPressed

    private void txtHoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtHoraKeyPressed

    private void txtCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCajaKeyPressed

    private void rEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rEntradaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rEntradaKeyPressed

    private void rSalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSalidaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rSalidaKeyPressed

    private void cboDestinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboDestinoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_cboDestinoKeyPressed

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

    private void btnBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticuloKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarArticuloKeyPressed

    private void txtArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtArtKeyPressed

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleKeyPressed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

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
            java.util.logging.Logger.getLogger(dlgTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgTransferencia dialog = new dlgTransferencia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private javax.swing.ButtonGroup GrupoOpciones;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo3;
    private javax.swing.JLabel LabelTitulo4;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador3;
    private javax.swing.JSeparator Separador4;
    private javax.swing.JButton btnAdd;
    private rojeru_san.rsbutton.RSButtonGradiente btnBuscarArticulo;
    public static RSMaterialComponent.RSButtonIconUno btnCancelar;
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    private javax.swing.JButton btnRestar;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private RSMaterialComponent.RSComboBox cboDestino;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itemCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    protected javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbCred;
    private javax.swing.JLabel lbDestinoOrigen;
    private javax.swing.JLabel lbSucursalOrigen;
    private javax.swing.JPopupMenu menuEmergente;
    private javax.swing.JPanel panelGrabados;
    public static rojerusan.RSCheckBox rEntrada;
    public static rojerusan.RSCheckBox rSalida;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt5;
    public static javax.swing.JTextField txtArt;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCodArticulo;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaReal;
    public static javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdDestino;
    private javax.swing.JTextField txtIdOrigen;
    public static javax.swing.JTextField txtTipo;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
