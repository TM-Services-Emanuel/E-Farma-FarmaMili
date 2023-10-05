package Controladores;

import Componentes.DataSourceService;
import Componentes.Login;
import Componentes.Mensajes;
import Datos.*;
import IU.*;
import Modelo.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlFactura {

    static Cliente cl;
    static Articulo art;
    static DetalleFactura dfa;
    static ArregloFactura array = new ArregloFactura();
    static DataSourceService dss = new DataSourceService();

    public static void selecArticulo() {
        int x = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloVenta.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulos.busArticulo(cod);
        dlgVentas.txtCodArticulo.setText(String.valueOf(art.getCodArticulo()));
        dlgVentas.txtArt.setText(art.getDescripcion());
        dlgVentas.txtCant.setText("1");

        DecimalFormat df = new DecimalFormat("#,###");
        String PP = String.valueOf(art.getPrecioPublico());
        String DES = String.valueOf(art.getDescuento());
        dlgVentas.lbPublic.setText("Precio Público: Gs." + (df.format(Integer.parseInt(PP.trim().replace(".", "").replace(",", "")))) + " | Descuento de: " + DES + "%");

        String PV = String.valueOf(art.getPrecioVenta());
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
            sumarCuentas(cod, lineaCredito);
        } else {
            dlgVentas.rContado.setSelected(true);
            dlgVentas.rCredito.setEnabled(false);
            dlgVentas.txthabilitado.setText("NO");
            dlgVentas.txtdisponible.setText("0");
            dlgVentas.txtdisponibleL.setText("0");
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
            sumarCuentas(cod, lineaCredito);
        } else {
            dlgVentas.rCredito.setEnabled(false);
            dlgVentas.txthabilitado.setText("NO");
            dlgVentas.txtdisponible.setText("0");
            dlgVentas.txtdisponibleL.setText("0");
        }

    }

    public static void sumarCuentas(String cod, int limite) {
        String sql = "SELECT SUM(fac_totalfinal) FROM factura WHERE clientes_cli_codigo=" + cod + " AND estado='PENDIENTE' AND fac_indicador='S'";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            rs.first();
            int deuda;
            if (rs.getString(1) == null) {
                deuda = 0;
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtdisponibleL.setText(String.valueOf(limite - deuda));
                dlgVentas.txtdisponible.setText(df.format(Integer.valueOf(String.valueOf(limite - deuda).trim().replace(".", "").replace(",", ""))));
            } else {
                deuda = Integer.parseInt(rs.getString(1));
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtdisponibleL.setText(String.valueOf(limite - deuda));
                dlgVentas.txtdisponible.setText(df.format(Integer.valueOf(String.valueOf(limite - deuda).trim().replace(".", "").replace(",", ""))));
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            Mensajes.error("Error calculando disponibilidad de crédito del clinte: " + e.getMessage());
        }
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

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 8)).replace(".", "").replace(",", ""));
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
        String fila[] = new String[19];
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
        tb.addRow(fila);
    }

    public static void addTabla(JTable tabla) {
        try {
            int codA = art.getCodArticulo();
            String codB = art.getCodBarra();
            String desc = art.getDescripcion();
            int cant = Integer.parseInt(dlgVentas.txtCant.getText());
            int cantM = art.getCM();
            int precioMin = art.getPrecioVenta();
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
            int porcDesc = art.getDescuento();
            if (art.getPrecioPublico() == 0) {
                descuento = 0;
            } else {
                if (VM.equals("S")) {
                    if ((cant) < cantM) {
                        descuento = (art.getPrecioPublico() - precioMin) * (cant);
                    } else {
                        descuento = (art.getPrecioPublico() - precioMay) * (cant);
                    }
                } else {
                    descuento = (art.getPrecioPublico() - precioMin) * (cant);
                }
            }
            if (art.getPrecioPublico() == 0) {
                neto = 0;
            } else {
                neto = (art.getPrecioPublico() * cant);
            }
            int iva = art.getIVA();
            int ppub = art.getPrecioPublico();
            DetalleFactura dfac = new DetalleFactura(codA);
            if (array.busca(dfac.getCodArticulo()) != -1) {
                Mensajes.error("Articulo ya fue agregado");
            } else {
                array.agregar(dfac);
                insertar(String.valueOf(codA), codB, desc, String.valueOf(cant), String.valueOf(prec), String.valueOf(mont), iva, String.valueOf(descuento), String.valueOf(porcDesc), String.valueOf(neto), String.valueOf(ppub), tabla);
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                String descuent = String.valueOf(getDescuento());
                String net = String.valueOf(getNeto());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtExentaL.setText(exentas);
                dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txt5L.setText(iva5);
                dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                dlgVentas.txt10L.setText(iva10);
                dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                dlgVentas.txtTotalL.setText(total);
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                dlgVentas.txtDescuentoL.setText(descuent);
                dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txtNetoL.setText(net);
                dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
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
            int codA = dfa.getCodArticulo();
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
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtTotalL.setText(String.valueOf(total));
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.trim().replace(".", "").replace(",", ""))));
            }
        }
    }

    public static int calCulos() {
        int total = Integer.parseInt(dlgVentas.txtTotalL.getText());
        int abono = Integer.parseInt(dlgVentas.txtAbonoL.getText());
        int vuelto = abono - total;
        return (vuelto);
    }

    public static int calCulosT() {
        int total = Integer.parseInt(dlgVentas.txtTotalL.getText());
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
                    prec = arti.getPrecioVenta();
                    mont = (Integer.parseInt(cant) * prec);
                } else {
                    prec = arti.getPM();
                    mont = (Integer.parseInt(cant) * prec);
                }
            } else {
                prec = arti.getPrecioVenta();
                mont = (Integer.parseInt(cant) * prec);
            }

            dlgVentas.tbDetalle.setValueAt(cant, fila, 3);
            dlgVentas.tbDetalle.setValueAt(String.valueOf(prec), fila, 6);

            int descuento;
            int neto;
            if (arti.getPrecioPublico() == 0) {
                descuento = 0;
            } else {
                if (VM.equals("S")) {
                    if (Integer.parseInt(cant) < cantM) {
                        descuento = (arti.getPrecioPublico() - arti.getPrecioVenta()) * Integer.parseInt(cant);
                    } else {
                        descuento = (arti.getPrecioPublico() - arti.getPM()) * Integer.parseInt(cant);
                    }
                } else {
                    descuento = (arti.getPrecioPublico() - arti.getPrecioVenta()) * Integer.parseInt(cant);
                }
            }
            if (arti.getPrecioPublico() == 0) {
                neto = 0;
            } else {
                neto = (arti.getPrecioPublico() * Integer.parseInt(cant));
            }

            int iva = arti.getIVA();
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
            dlgVentas.txtExentaL.setText(exentas);
            dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txt5L.setText(iva5);
            dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
            dlgVentas.txt10L.setText(iva10);
            dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
            dlgVentas.txtTotalL.setText(total);
            dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
            dlgVentas.txtDescuentoL.setText(descuent);
            dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txtNetoL.setText(net);
            dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }

    public static void canCelar() {
        array.vaciar();
    }

    public static String anularFactura()//Metodo para anular facturas
    {
        String msg;
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarFactura.actFactura(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Venta Anulada");
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
            Mensajes.informacion("Venta Anulada");
            controlFactura.actStockEliminarFacturaL();
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
            Mensajes.informacion("Stock Actualizado");
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
            Mensajes.informacion("Stock Actualizado");
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

    public static void listFacturasLegal(JTable tabla, String fecha) {
        List lista;
        lista = GestionarFactura.listFacturasLegal(fecha);
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
        String fecha = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 2).toString();
        String des = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 4).toString();
        String total = dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 5).toString();
        dlgConsultarFacturasLegal.txtCondicion.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 7).toString());
        dlgConsultarFacturasLegal.txtPago.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 8).toString());
        dlgConsultarFacturasLegal.txtEstado.setText(dlgConsultarFacturasLegal.tbFactura.getValueAt(x, 11).toString());
        List lista;
        lista = GestionarFactura.listDetallesL(cod);
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

}
