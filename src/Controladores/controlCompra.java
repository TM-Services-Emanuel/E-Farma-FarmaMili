package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Datos.ArregloCompras;
import Datos.GestionarArticulos;
import Datos.GestionarCompra;
import Datos.GestionarProveedor;
import IU.dlgBuscarArticuloCompra;
import IU.dlgBuscarProveedor;
import IU.dlgCompras;
import IU.dlgConsultarCompras;
import Modelo.Articulo;
import Modelo.DetalleCompra;
import Modelo.Proveedor;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlCompra {

    static DetalleCompra dc;
    public static ArregloCompras array = new ArregloCompras();

    public static void selectProveedor() {
        int x = dlgBuscarProveedor.tbDetalle.getSelectedRow();
        String cod = dlgBuscarProveedor.tbDetalle.getValueAt(x, 0).toString();
        Proveedor prov = GestionarProveedor.busProveedor(cod);
        dlgCompras.txtCodProv.setText(String.valueOf(prov.getCodP()));
        dlgCompras.txtRazonS.setText(prov.getRazoS());
        dlgCompras.txtRuc.setText(prov.getRuc());
    }

    public static void selectArticulo() {
        int x = dlgBuscarArticuloCompra.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloCompra.tbDetalle.getValueAt(x, 0).toString();
        Articulo art = GestionarArticulos.busArticulo(cod);
        dlgCompras.txtCodA.setText(String.valueOf(art.getCodArticulo()));
        dlgCompras.txtArt.setText(art.getDescripcion());
        dlgCompras.txtCant.setText("1");
        dlgCompras.txtCant.selectAll();
        int PC = art.getCosto();
        DecimalFormat df = new DecimalFormat("#,###");
        dlgCompras.txtCosto.setText((df.format(PC)));
    }

    public static void insertar(String cod, String codB, String desc, String cant, String prec, String total, int iva, String PCosto, String Gan, String Des, JTable tabla) {

        String fila[] = new String[19];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codB;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = cant;
        fila[5] = prec;
        fila[6] = prec;
        fila[7] = String.valueOf(iva);
        switch (iva) {
            case 10 -> {
                fila[8] = "0";
                fila[9] = "0";
                fila[10] = "0";
                fila[11] = "0";
                fila[12] = total;
                fila[13] = total;
            }
            case 5 -> {
                fila[8] = "0";
                fila[9] = "0";
                fila[10] = total;
                fila[11] = total;
                fila[12] = "0";
                fila[13] = "0";
            }
            default -> {
                fila[8] = total;
                fila[9] = total;
                fila[10] = "0";
                fila[11] = "0";
                fila[12] = "0";
                fila[13] = "0";
            }
        }
        fila[14] = total;
        fila[15] = total;
        fila[16] = PCosto;
        fila[17] = Gan;
        fila[18] = Des;
        tb.addRow(fila);
    }

    public static int getExcetas() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras.tbDetalle.getModel().getValueAt(i, 8)));
        }
        return (total);
    }

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras.tbDetalle.getModel().getValueAt(i, 10)));
        }
        return (total / 21);
    }

    public static int get10() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgCompras.tbDetalle.getModel().getValueAt(i, 12)));
        }
        return (total / 11);
    }

    public static long getTotal() {
        long total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += (long) Integer.valueOf(String.valueOf(dlgCompras.tbDetalle.getModel().getValueAt(i, 15)));
        }
        return (total);
    }

    public static double CalcCostoIVA(double iva, int costo) {
        double costoiva = 0;
        try {
            double div = 0;

            switch ((int) iva) {
                case 5 ->
                    div = 21;
                case 10 ->
                    div = 11;
                default -> {
                }
            }
            if (iva != 0) {
                costoiva = Redondeo.redondearD((costo) / div);
            } else {
                costoiva = 0.0;
            }

        } catch (Exception e) {
            Mensajes.error("Error al calcular costo iva: " + e.getMessage());
        }
        return costoiva;
    }

    public static double CalcGanancia(double pv, double costo) {
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

    public static double CalcDescuento(double pv, double pp) {
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

    public static void addTabla(JTable tabla, String cod) {
        try {
            Articulo art = GestionarArticulos.busArticulo(cod);
            int codA = art.getCodArticulo();
            String codB = art.getCodBarra();
            String desc = art.getDescripcion();
            int cant = Integer.parseInt(dlgCompras.txtCant.getText());
            int costo = Integer.parseInt(dlgCompras.txtCosto.getText().replace(".", "").replace(",", ""));
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
            double Gan = CalcGanancia(Double.valueOf(art.getPventa()), Double.valueOf(costo));
            double Des = CalcDescuento(Double.valueOf(art.getPventa()), Double.valueOf(art.getPpublico()));
            if (Gan <= 0) {
                Mensajes.error("Ganancia no válido.\nValor negativo o igual a 0");
            } else {
                DetalleCompra dco = new DetalleCompra(codA);
                if (array.busca(dco.getCodArticulo()) != -1) {
                    Mensajes.informacion("EL ARTICULO YA FUE AGREGADO");
                } else {
                    array.agregar(dco);
                    insertar(String.valueOf(codA), codB, desc, String.valueOf(cant), String.valueOf(costo), String.valueOf(mont), iv, String.valueOf(costoiva), String.valueOf(Gan), String.valueOf(Des), tabla);
                    long total = getTotal();
                    String exentas = String.valueOf(getExcetas());
                    String iva5 = String.valueOf(get5());
                    String iva10 = String.valueOf(get10());
                    DecimalFormat df = new DecimalFormat("#,###");
                    dlgCompras.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
                    dlgCompras.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
                    dlgCompras.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
                    dlgCompras.txtTotal.setText(df.format(total));
                }
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL CARGAR DETALLE: " + e.getMessage().toLowerCase());
        }
    }

    public static void consLinea() {
        int fila = dlgCompras.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Artículo no existe");
        } else {
            dc = array.getFila(p);
            int codAr = dc.getCodArticulo();
            //int cant = dc.getCant();
            //int prec = dc.getPrecio();
            //int monto = dc.getMonto();
        }
    }

    public static void delRenglon(JTable tabla) {
        consLinea();
        int fila = dlgCompras.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                long total = getTotal();
                DecimalFormat df = new DecimalFormat("#,###");
                dlgCompras.txtTotal.setText(df.format(total));
            }
        }
    }

    public static void canCelar() {
        array.vaciar();
    }

    /*    public static String addCompra() {
        String msg;
        int codc = Integer.parseInt(dlgCompras.txtCod.getText());
        int codProv = Integer.parseInt(dlgCompras.txtCodProv.getText());
        String condPago = (dlgCompras.lbCond.getText());
        String Fact= dlgCompras.txtFactura.getText();
        String fecha = dlgCompras.txtFecha.getText();
        int total = Integer.parseInt(dlgCompras.txtTotalL.getText());
        int exenta= Integer.parseInt(dlgCompras.txtExentaL.getText());
        int iva5= Integer.parseInt(dlgCompras.txt5L.getText());
        int iva10=Integer.parseInt(dlgCompras.txt10L.getText());

        Compra c = new Compra(codc, codProv,condPago,Fact, fecha, total, exenta, iva5, iva10);

        array.vaciar();
        msg = GestionarCompra.addCompra(c);

        if (msg == null) {
            Mensajes.informacion("Compra Realizada");
            controlCompra.addDetalleCompra();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/

 /*   public static String addDetalleCompra() {
        String msg = null;
        int fila = dlgCompras.tbDetalle.getRowCount();
        for (int i = 0; i < fila; i++) {
            int codCompra = Integer.valueOf(dlgCompras.txtCod.getText());
            int codArt = Integer.valueOf(dlgCompras.tbDetalle.getValueAt(i, 0).toString());
            int cantidad = Integer.valueOf(dlgCompras.tbDetalle.getValueAt(i, 4).toString());
            int precio = Integer.valueOf(dlgCompras.tbDetalle.getValueAt(i, 6).toString());
            int mont = Integer.valueOf(dlgCompras.tbDetalle.getValueAt(i, 14).toString());

            dc = new DetalleCompra(codCompra, codArt, cantidad, precio, mont);

            msg = GestionarCompra.addDetalleCompra(dc);
        }
        if (msg == null) {
            Mensajes.informacion("Detalle Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/

 /*  public static void finalizar(JTable tabla) {
        int fila = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgCompras.tbDetalle.getModel();
        int renglones = tb.getRowCount();
        for (int i = 0; i < renglones; i++) {
            fila++;
        }
        if (fila <= 0) {
            Mensajes.error("No ha ingresado artículos");
        } else {
            dlgFinCompra fc = new dlgFinCompra(null, true);
            fc.setLocationRelativeTo(null);
            int total = Redondeo.redondearI(getTotal());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgFinCompra.lblTotal.setText("₲ "+df.format(Integer.valueOf(String.valueOf(total).trim().replace(".", "").replace(",", ""))));
            //dlgFinCompra.lblTotal.setText(String.valueOf(total));
            fc.setVisible(true);
        }
    }*/

 /*------CONSULTADO LAS COMPRAS REALIZADAS*/
    public static void listarCompras(JTable tabla) {
        List lista;
        lista = GestionarCompra.listarCompras();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            //fila[10].toString();
            if (fila[10].toString().equals("S")) {
                fila[10] = "ACTIVO";
            } else {
                fila[10] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listarDetalleCompras(JTable tabla) {
        int x = dlgConsultarCompras.tbCompra.getSelectedRow();
        String cod = dlgConsultarCompras.tbCompra.getValueAt(x, 0).toString();
        String fac = dlgConsultarCompras.tbCompra.getValueAt(x, 7).toString();
        String fecha = dlgConsultarCompras.tbCompra.getValueAt(x, 2).toString() + " " + dlgConsultarCompras.tbCompra.getValueAt(x, 3).toString();
        String pro = dlgConsultarCompras.tbCompra.getValueAt(x, 4).toString() + " - " + dlgConsultarCompras.tbCompra.getValueAt(x, 5).toString();
        String codPro = dlgConsultarCompras.tbCompra.getValueAt(x, 8).toString();
        DecimalFormat df = new DecimalFormat("#,###");
        String total = dlgConsultarCompras.tbCompra.getValueAt(x, 9).toString();
        dlgConsultarCompras.txtCodCompra.setText(fac);
        dlgConsultarCompras.txtFechaCompra.setText(fecha);
        dlgConsultarCompras.txtProveedor.setText(pro);
        dlgConsultarCompras.txtTotalCompra.setText("Gs. " + df.format(Integer.parseInt(total.trim().replace(".", "").replace(",", ""))));
        List lista;
        lista = GestionarCompra.listarDetalleCompras(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[5].toString();
            fila[6].toString();
            tb.addRow(fila);
        }
    }

    public static String anularCompra() {
        String msg;
        int x = dlgConsultarCompras.tbCompra.getSelectedRow();
        String cod = dlgConsultarCompras.tbCompra.getValueAt(x, 0).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarCompra.delCompra(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Compra Anulada");
            controlCompra.actStockEliminarCompra();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarCompra() {
        String msg = null;
        int f = dlgConsultarCompras.tbDetalleCompra.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarCompras.tbDetalleCompra.getValueAt(i, 1).toString());
            int st = Integer.valueOf(dlgConsultarCompras.tbDetalleCompra.getValueAt(i, 4).toString());
            Articulo a = new Articulo(coda, st);
            msg = GestionarArticulos.actStockMENOS(a);
        }
        if (msg == null) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void actCantidad(JTable tabla) {
        try {
            int fila = dlgCompras.tbDetalle.getSelectedRow();
            int ca = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 4).toString());
            int pre = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 6).toString());
            String cant = String.valueOf(Mensajes.ingresarNumerosC(ca));
            long monto = (long) (pre * Integer.parseInt(cant));
            int iva = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 7).toString());
            dlgCompras.tbDetalle.setValueAt(cant, fila, 3);
            dlgCompras.tbDetalle.setValueAt(cant, fila, 4);

            switch (iva) {
                case 10 -> {
                    dlgCompras.tbDetalle.setValueAt(monto, fila, 12);
                    dlgCompras.tbDetalle.setValueAt(monto, fila, 13);
                }
                case 5 -> {
                    dlgCompras.tbDetalle.setValueAt(monto, fila, 10);
                    dlgCompras.tbDetalle.setValueAt(monto, fila, 11);
                }
                default -> {
                    dlgCompras.tbDetalle.setValueAt(monto, fila, 8);
                    dlgCompras.tbDetalle.setValueAt(monto, fila, 9);
                }
            }
            dlgCompras.tbDetalle.setValueAt(monto, fila, 14);
            dlgCompras.tbDetalle.setValueAt(monto, fila, 15);
            long total = getTotal();
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgCompras.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgCompras.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgCompras.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgCompras.txtTotal.setText(df.format(total));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

    public static void actPrecio(JTable tabla) {
        try {
           
            int fila = dlgCompras.tbDetalle.getSelectedRow();
            String cod = (dlgCompras.tbDetalle.getValueAt(fila, 0).toString());
            Articulo art = GestionarArticulos.busArticulo(cod);
            int cant = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 4).toString());
            int pre = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 6).toString());
            int costo = Mensajes.ingresarPrecioC(pre);
            int iva = Integer.parseInt(dlgCompras.tbDetalle.getValueAt(fila, 7).toString());
            double costoiva = CalcCostoIVA(iva, costo);
            int pv = art.getPventa();
            int pp = art.getPpublico();
            double Gan = CalcGanancia(pv, costo);
            double Des = CalcDescuento(pv, pp);
            long monto = (long)(cant * costo);

            dlgCompras.tbDetalle.setValueAt(String.valueOf(costo), fila, 5);
            dlgCompras.tbDetalle.setValueAt(String.valueOf(costo), fila, 6);

            switch (iva) {
                case 10 -> {
                    dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 12);
                    dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 13);
                }
                case 5 -> {
                    dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 10);
                    dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 11);
                }
                default -> {
                    dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 8);
                    dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 9);
                }
            }
            dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 14);
            dlgCompras.tbDetalle.setValueAt(String.valueOf(monto), fila, 15);
            dlgCompras.tbDetalle.setValueAt(String.valueOf(costoiva), fila, 16);
            dlgCompras.tbDetalle.setValueAt(String.valueOf(Gan), fila, 17);
            dlgCompras.tbDetalle.setValueAt(String.valueOf(Des), fila, 18);
            long total = getTotal();
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgCompras.txtExenta.setText(df.format(Integer.parseInt(exentas.trim().replace(".", "").replace(",", ""))));
            dlgCompras.txt5.setText(df.format(Integer.parseInt(iva5.replace(".", "").replace(",", ""))));
            dlgCompras.txt10.setText(df.format(Integer.parseInt(iva10.replace(".", "").replace(",", ""))));
            dlgCompras.txtTotal.setText(df.format(total));
        } catch (NumberFormatException e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }

}
