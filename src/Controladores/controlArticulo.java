package Controladores;

import Componentes.DataSourceService;
import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionarArticulos;
import IU.dlgArticulos;
import IU.dlgGestArticulos;
import Modelo.Articulo;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class controlArticulo {

    static int codLab;
    static int codProv;
    static int codFam;

    static DataSourceService dss = new DataSourceService();

    public static void aModifcar() {
        try {
            int x = dlgArticulos.tbProductos.getSelectedRow();
            String cod = dlgArticulos.tbProductos.getValueAt(x, 0).toString();
            System.out.println("articulo a mod: " + cod);
            Articulo ar = GestionarArticulos.busArticulo(cod);
            dlgGestArticulos.txtCodProducto.setText(String.valueOf(ar.getCodArticulo()));
            dlgGestArticulos.txtCodBarra.setText((ar.getCodBarra()));
            dlgGestArticulos.txtCodLab.setText(String.valueOf(ar.getCodLab()));
            dlgGestArticulos.txtCodFam.setText(String.valueOf(ar.getCodFam()));
            dlgGestArticulos.txtCodPro.setText(String.valueOf(ar.getCodProv()));
            dlgGestArticulos.txtDescripcion.setText(ar.getDescripcion());
            dlgGestArticulos.txtPrincipio.setText(ar.getPrincipio());
            dlgGestArticulos.txtAccion.setText(ar.getAccion());
            if (ar.getVenta().equals("LIBRE")) {
                dlgGestArticulos.rLibre.setSelected(true);
                dlgGestArticulos.rLibre.doClick();
            } else {
                dlgGestArticulos.rControlado.setSelected(true);
                dlgGestArticulos.rControlado.doClick();
            }
            if (ar.getTipo().equals("N")) {
                dlgGestArticulos.rNacional.setSelected(true);
                dlgGestArticulos.rNacional.doClick();
            } else {
                dlgGestArticulos.rImportado.setSelected(true);
                dlgGestArticulos.rImportado.doClick();
            }
            if (ar.getProdActivo().equals("SI")) {
                dlgGestArticulos.rActivo.setSelected(true);
                dlgGestArticulos.rActivo.doClick();
            } else {
                dlgGestArticulos.rInactivo.setSelected(true);
                dlgGestArticulos.rInactivo.doClick();
            }
            DecimalFormat df = new DecimalFormat("#,###");
            dlgGestArticulos.txtCosto.setText(df.format(ar.getCosto()));
            dlgGestArticulos.txtPrecioPublico.setText(df.format(ar.getPpublico()));
            dlgGestArticulos.txtGanancia.setText(String.valueOf(ar.getGanancia()));
            dlgGestArticulos.txtDesc.setText(String.valueOf(ar.getDescuento()));
            dlgGestArticulos.txtPrecioVenta.setText(df.format(ar.getPventa()));
            switch (ar.getIva()) {
                case 0 -> {
                    dlgGestArticulos.cbImpuesto.setSelectedIndex(1);
                    dlgGestArticulos.CalculoIVAC(0);
                }
                case 5 -> {
                    dlgGestArticulos.cbImpuesto.setSelectedIndex(2);
                    dlgGestArticulos.CalculoIVAC(5);
                }
                case 10 -> {
                    dlgGestArticulos.cbImpuesto.setSelectedIndex(3);
                    dlgGestArticulos.CalculoIVAC(10);
                }
                default -> {
                }
            }
            dlgGestArticulos.txtIVACosto.setText(String.valueOf(ar.getCostoiva()));
            dlgGestArticulos.txtStock.setText(String.valueOf(ar.getStock()));
            dlgGestArticulos.txtStockMin.setText(String.valueOf(ar.getStockMin()));
            /*try {
                if (ar.getVencimiento().equals("0000-00-00")) {
                    dlgGestArticulos.dfecha.cleanup();
                } else {
                    SimpleDateFormat fe = new SimpleDateFormat("dd/MM/yyyy");
                    dlgGestArticulos.dfecha.setDate(fe.parse(ar.getVencimiento()));
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }*/
            try {
                if (ar.getVM().equals("S")) {
                    dlgGestArticulos.ckHabilitar.setSelected(true);
                    dlgGestArticulos.txtCantM.setText(String.valueOf(ar.getCM()));
                    dlgGestArticulos.txtCantM.setEnabled(true);
                    dlgGestArticulos.txtPrecioVentaML.setText(String.valueOf(ar.getPM()));
                    dlgGestArticulos.txtPrecioVentaM.setText(df.format(Integer.valueOf(dlgGestArticulos.txtPrecioVentaML.getText().trim().replace(".", "").replace(",", ""))));
                    dlgGestArticulos.txtPrecioVentaM.setEnabled(true);
                } else {
                    dlgGestArticulos.ckHabilitar.setSelected(false);
                    dlgGestArticulos.txtCantM.setText(String.valueOf(ar.getCM()));
                    dlgGestArticulos.txtCantM.setEnabled(false);
                    dlgGestArticulos.txtPrecioVentaML.setText(String.valueOf(ar.getPM()));
                    dlgGestArticulos.txtPrecioVentaM.setText(df.format(Integer.valueOf(dlgGestArticulos.txtPrecioVentaML.getText().trim().replace(".", "").replace(",", ""))));
                    dlgGestArticulos.txtPrecioVentaM.setEnabled(false);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al obtener datos Mayorista" + e.getMessage());
            }
        } catch (NumberFormatException ee) {
            System.out.println(ee.getMessage());
        }

    }

    public static Articulo capturarCampos() {
        Articulo art;

        int codA = Integer.parseInt(dlgGestArticulos.txtCodProducto.getText());
        String codBar;
        if (dlgGestArticulos.txtCodBarra.getText().trim().isEmpty()) {
            codBar = (dlgGestArticulos.txtCodProducto.getText());
        } else {
            codBar = (dlgGestArticulos.txtCodBarra.getText());
        }

        String nomb = dlgGestArticulos.txtDescripcion.getText().toUpperCase();
        String princ;
        if (dlgGestArticulos.txtPrincipio.getText().trim().toUpperCase().isEmpty()) {
            princ = "";
        } else {
            princ = dlgGestArticulos.txtPrincipio.getText().toUpperCase();
        }
        String accion;
        if (dlgGestArticulos.txtAccion.getText().trim().toUpperCase().isEmpty()) {
            accion = "";
        } else {
            accion = dlgGestArticulos.txtAccion.getText().toUpperCase();
        }
        String venta;
        if (dlgGestArticulos.rLibre.isSelected()) {
            venta = "LIBRE";
        } else {
            venta = "CONTROLADO";
        }
        String tipo;
        if (dlgGestArticulos.rNacional.isSelected()) {
            tipo = "N";
        } else {
            tipo = "I";
        }
        String sqlLab = "SELECT * FROM laboratorio WHERE lab_nombre='" + dlgGestArticulos.cbLaboratorio.getSelectedItem().toString() + "'";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlLab)) {
            rs.last();
            codLab = rs.getInt("lab_codigo");
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Mensajes.error("Error al querer obtener valor del laboratorio: " + ex.getMessage());
        }
        String sqlProv = "SELECT * FROM proveedor WHERE pro_razonsocial='" + dlgGestArticulos.cbProveedor.getSelectedItem().toString() + "'";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlProv)) {
            rs.last();
            codProv = rs.getInt("pro_codigo");
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Mensajes.error("Error al querer obtener valor del proveedor: " + ex.getMessage());
        }
        String sqlFam = "SELECT * FROM familia WHERE fam_nombre='" + dlgGestArticulos.cbFamilia.getSelectedItem().toString() + "'";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlFam)) {
            rs.last();
            codFam = rs.getInt("fam_codigo");
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            Mensajes.error("Error al querer obtener valor de la familia: " + ex.getMessage());
        }
        int Pcosto = Integer.parseInt(dlgGestArticulos.txtCosto.getText().replace(".", "").replace(",", ""));
        int Ppublico = Integer.parseInt(dlgGestArticulos.txtPrecioPublico.getText().replace(".", "").replace(",", ""));
        double Gan = Double.parseDouble(dlgGestArticulos.txtGanancia.getText());
        double des = Double.parseDouble(dlgGestArticulos.txtDesc.getText());
        int Pventa = Integer.parseInt(dlgGestArticulos.txtPrecioVenta.getText().replace(".", "").replace(",", ""));
        int ivaG = 0;
        switch (dlgGestArticulos.cbImpuesto.getSelectedIndex()) {
            case 1 ->
                ivaG = 0;
            case 2 ->
                ivaG = 5;
            case 3 ->
                ivaG = 10;
            default -> {
            }
        }
        double ivaC = Double.parseDouble(dlgGestArticulos.txtIVACosto.getText());
        String fechas = "0000-00-00";
        int stock = Integer.parseInt(dlgGestArticulos.txtStock.getText().trim());
        int stockMin = Integer.parseInt(dlgGestArticulos.txtStockMin.getText().trim());
        String prodActivo;
        if (dlgGestArticulos.rActivo.isSelected()) {
            prodActivo = "SI";
        } else {
            prodActivo = "NO";
        }
        String VM;
        int CM;
        int PM;
        if (dlgGestArticulos.ckHabilitar.isSelected()) {
            VM = "S";
            CM = Integer.parseInt(dlgGestArticulos.txtCantM.getText().trim());
            PM = Integer.parseInt(dlgGestArticulos.txtPrecioVentaML.getText().trim());
        } else {
            VM = "N";
            CM = Integer.parseInt(dlgGestArticulos.txtCantM.getText().trim());
            PM = Integer.parseInt(dlgGestArticulos.txtPrecioVentaML.getText().trim());
        }
        String usuario = Login.getUsuarioLogueado();
        art = new Articulo(codA, codFam, codLab, codProv, codBar, nomb, princ, accion, Pcosto, ivaC, ivaG, stock, stockMin, fechas,
                Gan, des, Ppublico, Pventa, venta, tipo, prodActivo, VM, CM, PM, usuario);
        return art;
    }

    public static String addArticulo() {
        String msg;
        Articulo art = capturarCampos();
        msg = GestionarArticulos.addArticulo(art);
        if (msg == null) {
            Mensajes.informacion("Artículo Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actArticulo() {
        String msg;
        Articulo art = capturarCampos();
        msg = GestionarArticulos.actArticulo(art);
        if (msg == null) {
            Mensajes.informacion("Artículo Modifcado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static Articulo busArticulo(String cod) {
        Articulo art;
        art = GestionarArticulos.busArticulo(cod);
        return art;
    }

    public static String delArticulo() {
        int x = dlgArticulos.tbProductos.getSelectedRow();
        String msg;
        String cod = dlgArticulos.tbProductos.getValueAt(x, 0).toString();
        String usuario = Login.getUsuarioLogueado();
        msg = GestionarArticulos.delArticulo(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Artículo Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listArticulo(JTable tabla, String cod) {
        List lista;
        lista = GestionarArticulos.listArticulo(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void listArticuloActivo(JTable tabla, String cod) {
        List lista;
        lista = GestionarArticulos.listArticuloActivo(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filtrarGral(JTable tabla, String cod) {
        String C = cod;
        List lista1;
        lista1 = GestionarArticulos.filtrarGral(cod);
        if (lista1 != null) {
            for (int i = 1; i < lista1.size(); i++) {
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                Object[] fila = (Object[]) lista1.get(i);
                tb.addRow(fila);
            }
        }
    }

    public static void filtrarDescripcion(JTable tabla, String cod) {
        List lista;
        lista = GestionarArticulos.filtrarDescripcion(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filtrarDescripcionActivo(JTable tabla, String cod) {
        List lista;
        lista = GestionarArticulos.filtrarDescripcionActivo(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            //fila[0].toString();
            //fila[1].toString();
            tb.addRow(fila);
        }
    }

    public static void filrarPrincipioActivo(JTable tabla, String pr) {
        List lista;
        lista = GestionarArticulos.filtrarPrincipioActivo(pr);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filtrarCodBarra(JTable tabla, String rb) {
        List lista;
        lista = GestionarArticulos.filtrarCodBarra(rb);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filtrarCodBarraActivo(JTable tabla, String rb) {
        List lista;
        lista = GestionarArticulos.filtrarCodBarraActivo(rb);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

}
