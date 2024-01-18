package Controladores;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.Redondeo;
import Datos.*;
import IU.dlgBuscadorArticuloTransferencia;
import IU.dlgBuscadorArticuloVenta;
import IU.dlgBuscarCliente;
import IU.dlgBuscarCliente1;
import IU.dlgBuscarCliente2;
import IU.dlgConsultarCreditos;
import IU.dlgConsultarCreditosFacturas;
import IU.dlgConsultarFacturas;
import IU.dlgConsultarFacturasLegal;
import IU.dlgConsultarTransferencias;
import IU.dlgTransferencia;
import IU.dlgVentas;
import Modelo.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlFactura {

    static Cliente cl;
    static DetalleFactura dfa;
    static DetalleTransferencia dft;
    static ArregloFactura array = new ArregloFactura();
    static ArregloTransferencia arrayTransf = new ArregloTransferencia();
    static DataSourceService dss = new DataSourceService();

    public static void selecArticulo() {
        Articulo art;
        int x = dlgBuscadorArticuloVenta.tbDetalle.getSelectedRow();
        String cod = dlgBuscadorArticuloVenta.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulos.busArticulo(cod);
        dlgVentas.txtCodArticulo.setText(String.valueOf(art.getCodArticulo()));
        dlgVentas.txtArt.setText(art.getDescripcion());
        dlgVentas.txtCant.setText("1");

        DecimalFormat df = new DecimalFormat("#,###");
        String PP = String.valueOf(art.getPpublico());
        String DES = String.valueOf(art.getDescuento());
        dlgVentas.lbPublic.setText("Precio Público: Gs." + (df.format(Integer.parseInt(PP.trim().replace(".", "").replace(",", "")))) + " | Descuento de: " + DES + "%");

        String PV = String.valueOf(art.getPventa());
        String PVM = String.valueOf(art.getPM());
        int MC = art.getCM();
        String May;
        if (art.getVM().equals("N")) {
            //May="NO";
            dlgVentas.lbPVenta.setText("Precio Unitario: Gs." + (df.format(Integer.parseInt(PV.trim().replace(".", "").replace(",", "")))));
        } else {
            May = "SI";
            dlgVentas.lbPVenta.setText("Precio Unitario: Gs." + (df.format(Integer.parseInt(PV.trim().replace(".", "").replace(",", "")))) + " | A partir de " + MC + ": Gs." + (df.format(Integer.parseInt(PVM.trim().replace(".", "").replace(",", "")))));
        }
    }

    public static void selecArticulo_para_Transferir() {
        int x = dlgBuscadorArticuloTransferencia.tbDetalle.getSelectedRow();
        String cod = dlgBuscadorArticuloTransferencia.tbDetalle.getValueAt(x, 0).toString();
        Articulo art = GestionarArticulos.busArticulo(cod);
        dlgTransferencia.txtCodArticulo.setText(String.valueOf(art.getCodArticulo()));
        dlgTransferencia.txtArt.setText(art.getDescripcion());
        dlgTransferencia.txtCant.setText("1");
        DecimalFormat df = new DecimalFormat("#,###");
        dlgTransferencia.txtCosto.setText(df.format(art.getCosto()));
    }

    public static void selectCliente() {
        int x = dlgBuscarCliente.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgVentas.txtCodCliente.setText(String.valueOf(cl.getCodCliente()));
        dlgVentas.txtRuc.setText((cl.getRuc()));
        dlgVentas.txtRazonS.setText(cl.getRazonSocial());
        dlgVentas.lbCred.setText(cl.getCredito());
        if (dlgVentas.lbCred.getText().equals("SI")) {
            dlgVentas.rCredito.setEnabled(true);
            dlgVentas.txthabilitado.setText("SI");
            int lineaCredito = cl.getLimCuenta();
            int deudaTicket = sumarCuentasTicket(cod);
            int deudaFactura = sumarCuentasFactura(cod);
            DecimalFormat df = new DecimalFormat("#,###");
            dlgVentas.txtdisponible.setText(df.format(lineaCredito - (deudaTicket + deudaFactura)));
        } else {
            dlgVentas.rContado.setSelected(true);
            dlgVentas.rCredito.setEnabled(false);
            dlgVentas.txthabilitado.setText("NO");
            dlgVentas.txtdisponible.setText("0");
        }

    }

    public static void selectCliente1() {
        int x = dlgBuscarCliente1.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente1.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgConsultarCreditos.txtClientes.setText(cl.getRuc() + ", " + cl.getRazonSocial());
        dlgConsultarCreditos.lblCodDetalle.setText(String.valueOf(cl.getCodCliente()));
    }

    public static void selectCliente2() {
        int x = dlgBuscarCliente2.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente2.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgConsultarCreditosFacturas.txtClientes.setText(cl.getRuc() + ", " + cl.getRazonSocial());
        dlgConsultarCreditosFacturas.lblCodDetalle.setText(String.valueOf(cl.getCodCliente()));
    }

    public static void selectClienteInicio(String cod) {
        cl = GestionarCliente.busCliente(cod);
        dlgVentas.txtCodCliente.setText(String.valueOf(cl.getCodCliente()));
        dlgVentas.txtRuc.setText((cl.getRuc()));
        dlgVentas.txtRazonS.setText(cl.getRazonSocial());
        dlgVentas.lbCred.setText(cl.getCredito());
        if (dlgVentas.lbCred.getText().equals("SI")) {
            dlgVentas.rCredito.setEnabled(true);
            dlgVentas.txthabilitado.setText("SI");
            int lineaCredito = cl.getLimCuenta();
            int deudaTicket = sumarCuentasTicket(cod);
            int deudaFactura = sumarCuentasFactura(cod);
            DecimalFormat df = new DecimalFormat("#,###");
            dlgVentas.txtdisponible.setText(df.format(lineaCredito - (deudaTicket + deudaFactura)));
        } else {
            dlgVentas.rCredito.setEnabled(false);
            dlgVentas.txthabilitado.setText("NO");
            dlgVentas.txtdisponible.setText("0");
        }

    }

    public static int sumarCuentasTicket(String cod) {
        int deuda = 0;
        String sql = "SELECT IFNULL ((SELECT SUM(fac_totalfinal) FROM factura WHERE clientes_cli_codigo=" + cod + " AND estado='PENDIENTE' AND fac_indicador='S'),0) AS cuenta";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            rs.first();
            deuda = rs.getInt(1);
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            Mensajes.error("Error calculando disponibilidad de crédito del clinte: " + e.getMessage());
        }

        return deuda;
    }

    public static int sumarCuentasFactura(String cod) {
        int deuda = 0;
        String sql = "SELECT IFNULL ((SELECT SUM(fac_totalfinal) FROM factura_l WHERE clientes_cli_codigo=" + cod + " AND estado='PENDIENTE' AND fac_indicador='S'),0) AS cuenta";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            rs.first();
            deuda = rs.getInt(1);
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            Mensajes.error("Error calculando disponibilidad de crédito del clinte: " + e.getMessage());
        }

        return deuda;
    }

    public static int getExcetas() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 7)).replace(".", "").replace(",", ""));
        }
        return (total);
    }
    
    public static int getExcetasConsultaFacturaLegal() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturasLegal.tbDetalleFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgConsultarFacturasLegal.tbDetalleFactura.getModel().getValueAt(i, 7)).replace(".", "").replace(",", ""));
        }
        return (total);
    }
    
    public static int get5ConsultaFacturaLegal() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturasLegal.tbDetalleFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgConsultarFacturasLegal.tbDetalleFactura.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return (total);
    }
    public static int get10ConsultaFacturaLegal() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturasLegal.tbDetalleFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgConsultarFacturasLegal.tbDetalleFactura.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int getExcetasTransferencia() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgTransferencia.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgTransferencia.tbDetalle.getModel().getValueAt(i, 5)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return (total / 21);
    }
    
    public static int get5Completo() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return total;
    }

    public static int get5Transferencia() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgTransferencia.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgTransferencia.tbDetalle.getModel().getValueAt(i, 6)).replace(".", "").replace(",", ""));
        }
        return (total / 21);
    }

    public static int get10() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
        }
        return (total / 11);
    }
    public static int get10Completo() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
        }
        return total;
    }

    public static int get10Transferencia() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgTransferencia.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgTransferencia.tbDetalle.getModel().getValueAt(i, 7)).replace(".", "").replace(",", ""));
        }
        return (total / 11);
    }

    public static int getTotal()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 10)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int getTotalTransferencia()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgTransferencia.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgTransferencia.tbDetalle.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int getTotalCreditos()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarCreditos.tblFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgConsultarCreditos.tblFactura.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int getTotalFactCreditos()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarCreditosFacturas.tblFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgConsultarCreditosFacturas.tblFactura.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
        }
        return (total);
    }

    public static int getDescuento()//Calcula el total de la venta
    {
        int descuento = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            descuento += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 11)).replace(".", "").replace(",", ""));
        }
        return (descuento);
    }

    public static int getNeto()//Calcula el total de la venta
    {
        int neto = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            neto += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 12)).replace(".", "").replace(",", ""));
        }
        return (neto);
    }

    public static void insertar(String cod, String codB, String desc, String cant, String prec, String total, int iva, String descuento, String porcDesc, String neto, String ppub, JTable tabla) {
        String fila[] = new String[14];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codB;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = ppub;
        fila[5] = porcDesc;
        fila[6] = prec;
        switch (iva) {
            case 10 -> {
                fila[7] = "0";
                fila[8] = "0";
                fila[9] = total;
            }
            case 5 -> {
                fila[7] = "0";
                fila[8] = total;
                fila[9] = "0";
            }
            default -> {
                fila[7] = total;
                fila[8] = "0";
                fila[9] = "0";
            }
        }
        fila[10] = total;
        fila[11] = descuento;
        fila[12] = neto;
        fila[13] = String.valueOf(iva);
        tb.addRow(fila);
    }

    public static void addTabla(String cod, JTable tabla) {
        try {
            Articulo art;
            art = GestionarArticulos.busArticulo(cod);
            int codA = art.getCodArticulo();
            String codB = art.getCodBarra();
            String desc = art.getDescripcion();
            int cant = Integer.parseInt(dlgVentas.txtCant.getText());
            int cantM = art.getCM();
            int precioMin = art.getPventa();
            int precioMay = art.getPM();
            String VM = art.getVM();
            int mont;
            int prec;
            if (VM.equals("S")) {
                if (cant < cantM) {
                    prec = precioMin;
                    mont = (cant * prec);
                } else {
                    prec = precioMay;
                    mont = (cant * prec);
                }
            } else {
                prec = precioMin;
                mont = (cant * prec);
            }
            int descuento;
            int neto;
            double porcDesc = art.getDescuento();
            if (art.getPpublico() == 0) {
                descuento = 0;
            } else {
                if (VM.equals("S")) {
                    if ((cant) < cantM) {
                        descuento = (art.getPpublico() - precioMin) * (cant);
                    } else {
                        descuento = (art.getPpublico() - precioMay) * (cant);
                    }
                } else {
                    descuento = (art.getPpublico() - precioMin) * (cant);
                }
            }
            if (art.getPpublico() == 0) {
                neto = 0;
            } else {
                neto = (art.getPpublico() * cant);
            }
            int iva = art.getIva();
            int ppub = art.getPpublico();
            dfa = new DetalleFactura(codA);
            if (array.busca(dfa.getCodArticulo()) != -1) {
                Mensajes.error("Articulo ya fue agregado");
            } else {
                array.agregar(dfa);
                insertar(String.valueOf(codA), codB, desc, String.valueOf(cant), String.valueOf(prec), String.valueOf(mont), iva, String.valueOf(descuento), String.valueOf(porcDesc), String.valueOf(neto), String.valueOf(ppub), tabla);
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                String descuent = String.valueOf(getDescuento());
                String net = String.valueOf(getNeto());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
            }
        } catch (NumberFormatException e) {
            Mensajes.error("ERROR AL AGREGAR ARTICULO: " + e.getMessage().toUpperCase());
        }
    }

    public static void insertarTransferencia(String codP, String codBar, String descipP, String cantP, String precP, String totalP, int iva, double Gan, double Desc, int order, double costiv, JTable tabla) {
        String fila[] = new String[13];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = codP;
        fila[1] = codBar;
        fila[2] = descipP;
        fila[3] = cantP;
        fila[4] = precP;
        switch (iva) {
            case 10 -> {
                fila[5] = "0";
                fila[6] = "0";
                fila[7] = totalP;
            }
            case 5 -> {
                fila[5] = "0";
                fila[6] = totalP;
                fila[7] = "0";
            }
            default -> {
                fila[5] = totalP;
                fila[6] = "0";
                fila[7] = "0";
            }
        }
        fila[8] = totalP;
        fila[9] = String.valueOf(Gan);
        fila[10] = String.valueOf(Desc);
        fila[11] = String.valueOf(order);
        fila[12] = String.valueOf(costiv);
        tb.addRow(fila);
    }

    public static void addTablaTransferencia(String cod, JTable tabla) {
        try {
            Articulo art;
            art = GestionarArticulos.busArticulo(cod);
            int codA = art.getCodArticulo();
            String codB = art.getCodBarra();
            String desc = art.getDescripcion();
            int cant = Integer.parseInt(dlgTransferencia.txtCant.getText());
            int costo = Integer.parseInt(dlgTransferencia.txtCosto.getText().replace(".", "").replace(",", ""));
            long mont = (long) (cant * costo);

            int iv = art.getIva();
            double costoiva = 0;
            switch (iv) {
                case 0 ->
                    costoiva = 0;
                case 5 ->
                    costoiva = (double) (costo / 21);
                case 10 ->
                    costoiva = (double) (costo / 11);
                default -> {
                }
            }
            double Ganancia = CalcGananciaT(Double.valueOf(art.getPventa()), Double.valueOf(costo));
            double Descuento = CalcDescuentoT(Double.valueOf(art.getPventa()), Double.valueOf(art.getPpublico()));
            int Orden = tabla.getRowCount() + 1;
            dft = new DetalleTransferencia(codA);
            if (arrayTransf.busca(dft.getCodArticulo()) != -1) {
                Mensajes.error("Articulo ya fue agregado");
            } else {
                arrayTransf.agregar(dft);
                insertarTransferencia(String.valueOf(codA), codB, desc, String.valueOf(cant), String.valueOf(costo), String.valueOf(mont), iv, Ganancia, Descuento, Orden, costoiva, tabla);
                String total = String.valueOf(getTotalTransferencia());
                String exentas = String.valueOf(getExcetasTransferencia());
                String iva5 = String.valueOf(get5Transferencia());
                String iva10 = String.valueOf(get10Transferencia());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgTransferencia.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                dlgTransferencia.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                dlgTransferencia.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                dlgTransferencia.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
            }
        } catch (NumberFormatException e) {
            Mensajes.error("ERROR AL AGREGAR ARTICULO: " + e.getMessage().toUpperCase());
        }
    }

    public static void consLinea() {
        int fila = dlgVentas.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Articulo no existe");
        } else {
            dfa = array.getFila(p);
            //int codA = dfa.getCodArticulo();
        }
    }

    public static void delRenglon(JTable tabla) {
        consLinea();
        int fila = dlgVentas.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf((getTotal()));
                String descuent = String.valueOf(getDescuento());
                String net = String.valueOf(getNeto());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
            }
        }
    }

    public static void consLineaTransferencia() {
        int fila = dlgTransferencia.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgTransferencia.tbDetalle.getValueAt(fila, 0).toString());
        int p = arrayTransf.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Articulo no existe");
        }
    }

    public static void delRenglonTransferencia(JTable tabla) {
        consLineaTransferencia();
        int fila = dlgTransferencia.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgTransferencia.tbDetalle.getValueAt(fila, 0).toString());
        int p = arrayTransf.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                arrayTransf.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(getTotalTransferencia());
                String exentas = String.valueOf(getExcetasTransferencia());
                String iva5 = String.valueOf(get5Transferencia());
                String iva10 = String.valueOf(get10Transferencia());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgTransferencia.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                dlgTransferencia.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                dlgTransferencia.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                dlgTransferencia.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
            }
        }
    }

    public static int calCulos() {
        int total = Integer.parseInt(dlgVentas.txtTotal.getText().replace(".", "").replace(",", ""));
        int abono = Integer.parseInt(dlgVentas.txtAbonoL.getText());
        int vuelto = abono - total;
        return (vuelto);
    }

    public static int calCulosT() {
        int total = Integer.parseInt(dlgVentas.txtTotal.getText().replace(".", "").replace(",", ""));
        int abono = Integer.parseInt(dlgVentas.txtAbonoTL.getText());
        int vuelto = abono - total;
        return (vuelto);
    }

    public static void actCantidad() {
        try {
            int fila = dlgVentas.tbDetalle.getSelectedRow();
            String cod = dlgVentas.tbDetalle.getValueAt(fila, 0).toString();
            Articulo arti = GestionarArticulos.busArticulo(cod);
            int ca = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 3).toString().replace(".", "").replace(",", ""));
            int cantM = arti.getCM();
            int prec;
            String VM = arti.getVM();
            String cant = String.valueOf(Mensajes.ingresarNumerosV(ca));
            int mont;
            if (VM.equals("S")) {
                if (Integer.parseInt(cant) < cantM) {
                    prec = arti.getPventa();
                    mont = (Integer.parseInt(cant) * prec);
                } else {
                    prec = arti.getPM();
                    mont = (Integer.parseInt(cant) * prec);
                }
            } else {
                prec = arti.getPventa();
                mont = (Integer.parseInt(cant) * prec);
            }

            dlgVentas.tbDetalle.setValueAt(cant, fila, 3);
            dlgVentas.tbDetalle.setValueAt(String.valueOf(prec), fila, 6);

            int descuento;
            int neto;
            if (arti.getPpublico() == 0) {
                descuento = 0;
            } else {
                if (VM.equals("S")) {
                    if (Integer.parseInt(cant) < cantM) {
                        descuento = (arti.getPpublico() - arti.getPventa()) * Integer.parseInt(cant);
                    } else {
                        descuento = (arti.getPpublico() - arti.getPM()) * Integer.parseInt(cant);
                    }
                } else {
                    descuento = (arti.getPpublico() - arti.getPventa()) * Integer.parseInt(cant);
                }
            }
            if (arti.getPpublico() == 0) {
                neto = 0;
            } else {
                neto = (arti.getPpublico() * Integer.parseInt(cant));
            }

            int iva = arti.getIva();
            switch (iva) {
                case 10 -> {
                    dlgVentas.tbDetalle.setValueAt(String.valueOf(mont), fila, 9);
                }
                case 5 -> {
                    dlgVentas.tbDetalle.setValueAt(String.valueOf(mont), fila, 8);
                }
                default -> {
                    dlgVentas.tbDetalle.setValueAt(String.valueOf(mont), fila, 7);
                }
            }
            dlgVentas.tbDetalle.setValueAt(String.valueOf(mont), fila, 10);
            dlgVentas.tbDetalle.setValueAt(descuento, fila, 11);
            dlgVentas.tbDetalle.setValueAt(neto, fila, 12);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            String descuent = String.valueOf(getDescuento());
            String net = String.valueOf(getNeto());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
            dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
            dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
            dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }

    public static void actCantidadTransferencia(JTable table) {
        try {
            int fila = table.getSelectedRow();
            String cod = table.getValueAt(fila, 0).toString();
            Articulo arti = GestionarArticulos.busArticulo(cod);
            int ca = Integer.parseInt(table.getValueAt(fila, 3).toString().replace(".", "").replace(",", ""));
            int costo = Integer.parseInt(table.getValueAt(fila, 4).toString().replace(".", "").replace(",", ""));
            String cant = String.valueOf(Mensajes.ingresarNumerosT(ca, dlgTransferencia.txtTipo.getText()));
            long mont = (long) (Integer.parseInt(cant) * costo);
            System.out.println("Mont: " + mont);
            table.setValueAt(cant, fila, 3);

            int iva = arti.getIva();
            System.out.println("IVa: " + iva);
            switch (iva) {
                case 10 -> {
                    table.setValueAt(String.valueOf(mont), fila, 7);
                }
                case 5 -> {
                    table.setValueAt(String.valueOf(mont), fila, 6);
                }
                case 0 -> {
                    table.setValueAt(String.valueOf(mont), fila, 5);
                }
                default -> {
                }
            }
            table.setValueAt(String.valueOf(mont), fila, 8);
            String total = String.valueOf(getTotalTransferencia());
            String exentas = String.valueOf(getExcetasTransferencia());
            String iva5 = String.valueOf(get5Transferencia());
            String iva10 = String.valueOf(get10Transferencia());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgTransferencia.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
            dlgTransferencia.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
            dlgTransferencia.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
            dlgTransferencia.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }

    public static void canCelar() {
        array.vaciar();
    }

    public static void canCelarTransf() {
        arrayTransf.vaciar();
    }

    public static String anularFactura()//Metodo para anular facturas
    {
        String msg;
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarFactura.actFactura(cod, usuario);
        if (msg == null) {
            //Mensajes.informacion("Venta Anulada");
            Notif.NotifySuccess("Notificación del sistema", "Venta Anulada satisfactoriamente.");
            controlFactura.actStockEliminarFactura();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String anularFacturaL()//Metodo para anular facturas
    {
        String msg;
        int x = dlgConsultarFacturasLegal.tbFactura.getSelectedRow();
        String cod = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 0).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarFactura.actFacturaL(cod, usuario);
        if (msg == null) {
            //Mensajes.informacion("Venta Anulada");
            Notif.NotifySuccess("Notificación del sistema", "Venta anulada satisfactoriamente.");
            controlFactura.actStockEliminarFacturaL();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String anularTransferencia() {
        String msg;
        int x = dlgConsultarTransferencias.tbTransferencias.getSelectedRow();
        String cod = dlgConsultarTransferencias.tbTransferencias.getValueAt(x, 0).toString();
        String tipo = dlgConsultarTransferencias.tbTransferencias.getValueAt(x, 4).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarFactura.actTransferencia(cod, usuario);
        if (msg == null) {
            // Mensajes.Sistema("Transferencia anulada satisfactoriamente.");
            Notif.NotifySuccess("Notificación del sistema", "Transferencia anulada satisfactoriamente.");
            if (tipo.equals("TIPO ENTRADA")) {
                controlFactura.actStockEliminarTransferenciaE();
            } else if (tipo.equals("TIPO SALIDA")) {
                controlFactura.actStockEliminarTransferenciaS();
            }
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarTransferenciaE() {
        String msg = null;
        int f = dlgConsultarTransferencias.tbDetalleTransferencias.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarTransferencias.tbDetalleTransferencias.getValueAt(i, 1).toString());
            int stk = Integer.parseInt(dlgConsultarTransferencias.tbDetalleTransferencias.getValueAt(i, 0).toString());
            Articulo a = new Articulo(coda, stk);
            msg = GestionarArticulos.actStockMENOS(a);
        }
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "Stock Actualizado.");
            //Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarTransferenciaS() {
        String msg = null;
        int f = dlgConsultarTransferencias.tbDetalleTransferencias.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarTransferencias.tbDetalleTransferencias.getValueAt(i, 1).toString());
            int stk = Integer.parseInt(dlgConsultarTransferencias.tbDetalleTransferencias.getValueAt(i, 0).toString());
            Articulo a = new Articulo(coda, stk);
            msg = GestionarArticulos.actStockMAS(a);
        }
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "Stock Actualizado.");
            //Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarFacturaL() {
        String msg = null;
        int f = dlgConsultarFacturasLegal.tbDetalleFactura.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarFacturasLegal.tbDetalleFactura.getValueAt(i, 1).toString());
            int stk = Integer.parseInt(dlgConsultarFacturasLegal.tbDetalleFactura.getValueAt(i, 0).toString());
            Articulo a = new Articulo(coda, stk);
            msg = GestionarArticulos.actStockMAS(a);
        }
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "Stock Actualizado.");
            //Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarFactura() {
        String msg = null;
        int f = dlgConsultarFacturas.tblDetalle.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarFacturas.tblDetalle.getValueAt(i, 1).toString());
            int stk = Integer.parseInt(dlgConsultarFacturas.tblDetalle.getValueAt(i, 0).toString());
            Articulo a = new Articulo(coda, stk);
            msg = GestionarArticulos.actStockMAS(a);
        }
        if (msg == null) {
            //Mensajes.informacion("Stock Actualizado");
            Notif.NotifySuccess("Notificación del sistema", "Stock Actualizado.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listFacturas(JTable tabla, String fecha) {
        List lista;
        lista = GestionarFactura.listFacturas(fecha);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            String filas[] = new String[12];
            Object[] fila = (Object[]) lista.get(i);
            filas[0] = fila[0].toString();
            filas[1] = fila[1].toString();
            filas[2] = Fecha.formatoFechaMuestra(fila[2].toString());
            filas[3] = Fecha.formatoHora_sin_seg(fila[3].toString());
            filas[4] = fila[4].toString();
            filas[5] = fila[5].toString();
            filas[6] = fila[6].toString();
            filas[7] = fila[7].toString();
            filas[8] = fila[8].toString();
            filas[9] = fila[9].toString();
            filas[10] = fila[10].toString();
            if (fila[11].toString().equals("S")) {
                filas[11] = "ACTIVO";
            } else {
                filas[11] = "ANULADO";
            }
            tb.addRow(filas);
        }
    }

    public static void listFacturasLegal(JTable tabla, String fecha) {
        List lista;
        lista = GestionarFactura.listFacturasLegal(fecha);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            String filas[] = new String[15];
            Object[] fila = (Object[]) lista.get(i);
            filas[0] = fila[0].toString();
            filas[1] = fila[1].toString();
            filas[2] = Fecha.formatoFechaMuestra(fila[2].toString());
            filas[3] = Fecha.formatoHora_sin_seg(fila[3].toString());
            filas[4] = fila[4].toString();
            filas[5] = fila[5].toString();
            filas[6] = fila[6].toString();
            filas[7] = fila[7].toString();
            filas[8] = fila[8].toString();
            filas[9] = fila[9].toString();
            filas[10] = fila[10].toString();
            if (fila[11].toString().equals("S")) {
                filas[11] = "ACTIVO";
            } else {
                filas[11] = "ANULADO";
            }
            filas[12] = fila[12].toString();
            filas[13] = fila[13].toString();
            filas[14] = fila[14].toString();
            tb.addRow(filas);
        }
    }

    public static void listTransferencias(JTable tabla, String fecha) {
        List lista;
        lista = GestionarFactura.listTransferencias(fecha);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            String filas[] = new String[9];
            Object[] fila = (Object[]) lista.get(i);
            filas[0] = fila[0].toString();
            filas[1] = fila[0].toString() + "-" + fila[1].toString();
            filas[2] = fila[2].toString();
            filas[3] = Fecha.formatoFechaMuestra(fila[3].toString()) + " " + Fecha.formatoHora_sin_seg(fila[4].toString());
            filas[4] = fila[5].toString();
            filas[5] = fila[6].toString();
            filas[6] = fila[7].toString();
            filas[7] = fila[8].toString();
            filas[8] = fila[9].toString();
            tb.addRow(filas);
        }
    }

    public static void listFacturasCredito(JTable tabla, String cliente) {
        List lista;
        lista = GestionarFactura.listFacturasCredito(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendiente(JTable tabla, String cliente) {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendiente(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoActivo(JTable tabla, String cliente) {
        List lista;
        lista = GestionarFactura.listFacturasCreditoActivo(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendienteActivo(JTable tabla, String cliente) {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendienteActivo(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendienteActivo2(JTable tabla, String cliente) {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendienteActivo2(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendienteActivoGeneral(JTable tabla) {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendienteActivoGeneral();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendienteGeneral(JTable tabla) {
        List lista;
        lista = GestionarFactura.listFacturasCreditoPendienteGeneral();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturas2(JTable tabla) {
        List lista;
        lista = GestionarFactura.lisFacturas2();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            tb.addRow(fila);
        }
    }

    public static void listDetalle(JTable tabla) {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        String fecha = dlgConsultarFacturas.tblFactura.getValueAt(x, 2).toString();
        String des = dlgConsultarFacturas.tblFactura.getValueAt(x, 4).toString();
        String total = dlgConsultarFacturas.tblFactura.getValueAt(x, 5).toString();
        dlgConsultarFacturas.txtCondicion.setText(dlgConsultarFacturas.tblFactura.getValueAt(x, 7).toString());
        dlgConsultarFacturas.txtPago.setText(dlgConsultarFacturas.tblFactura.getValueAt(x, 8).toString());
        dlgConsultarFacturas.txtEstado.setText(dlgConsultarFacturas.tblFactura.getValueAt(x, 11).toString());
        List lista;
        lista = GestionarFactura.listDetalles(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void listDetalleL(JTable tabla) {
        int x = dlgConsultarFacturasLegal.tbFactura.getSelectedRow();
        String cod = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 0).toString();
        dlgConsultarFacturasLegal.txtCondicion.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 7).toString());
        dlgConsultarFacturasLegal.txtPago.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 8).toString());
        dlgConsultarFacturasLegal.txtEstado.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 11).toString());
        dlgConsultarFacturasLegal.txtTotal.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 9).toString());
        List lista;
        lista = GestionarFactura.listDetallesL(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
        
        dlgConsultarFacturasLegal.txtExenta.setText(String.valueOf(getExcetasConsultaFacturaLegal()));
        dlgConsultarFacturasLegal.txt5.setText(String.valueOf(get5ConsultaFacturaLegal()));
        dlgConsultarFacturasLegal.txt10.setText(String.valueOf(get10ConsultaFacturaLegal()));
    }

    public static void listDetalleTransferencias(JTable tabla) {
        int x = dlgConsultarTransferencias.tbTransferencias.getSelectedRow();
        String cod = dlgConsultarTransferencias.tbTransferencias.getValueAt(x, 0).toString();
        List lista;
        lista = GestionarFactura.listDetallesTransferencias(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void ListClientes() {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 4).toString();
        Cliente c = GestionarCliente.busCliente(cod);
        dlgConsultarFacturas.txtCodCliente.setText(String.valueOf(c.getCodCliente()));
        dlgConsultarFacturas.txtRazonSocial.setText(c.getRazonSocial());
        dlgConsultarFacturas.txtRuc.setText(c.getRuc());
    }

    public static void ListClientesF() {
        int x = dlgConsultarFacturasLegal.tbFactura.getSelectedRow();
        String cod = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 4).toString();
        Cliente c = GestionarCliente.busCliente(cod);
        dlgConsultarFacturasLegal.txtCodCliente.setText(String.valueOf(c.getCodCliente()));
        dlgConsultarFacturasLegal.txtRazonSocial.setText(c.getRazonSocial());
        dlgConsultarFacturasLegal.txtRuc.setText(c.getRuc());
    }

    public static void selecVendedor() {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 10).toString();
        Vendedor ven = GestionarVendedor.busVendedor(cod);
        dlgConsultarFacturas.txtVendedor.setText(ven.getNombreV());
    }

    public static void selecVendedorF() {
        int x = dlgConsultarFacturasLegal.tbFactura.getSelectedRow();
        String cod = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 10).toString();
        Vendedor ven = GestionarVendedor.busVendedor(cod);
        dlgConsultarFacturasLegal.txtVendedor.setText(ven.getNombreV());
    }

    public static void fillCliente(JTable tabla, String nom) {
        List lista;
        lista = GestionarFactura.fillCliente(nom);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static double CalcGananciaT(double pv, double costo) {
        double ganancia = 0;
        try {
            if (pv == 0) {
                ganancia = 0;
            } else {
                double i = (double) (costo / pv);
                ganancia = Redondeo.redondearD((1 - i) * 100);
            }
        } catch (NumberFormatException e) {
            Mensajes.error("Error al calcular Ganancia en transferencia: " + e.getMessage());
        }
        return ganancia;
    }

    public static double CalcDescuentoT(double pv, double pp) {
        double descuento = 0;
        try {
            if (pp == 0) {
                descuento = 0;
            } else {
                double dif = (double) (pv / pp);
                descuento = Redondeo.redondearD((1 - dif) * 100);
            }
        } catch (Exception e) {
            Mensajes.error("Error al calcular Descuento: " + e.getMessage());
        }
        return descuento;
    }

}
