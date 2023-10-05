package Componentes;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class cargarComboBox {

    static DefaultComboBoxModel modeloCombo;
    static DataSourceService dss = new DataSourceService();

    public static void cargar(JComboBox cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement("SELEC. UNA OPCIÓN");
                while (rs.next()) {
                    modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2)));
                }
                cb.setModel(modeloCombo);
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarCaja(JComboBox cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement("SELEC.");
                while (rs.next()) {
                    modeloCombo.addElement(rs.getString(1));
                }
                cb.setModel(modeloCombo);
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarCliente(JComboBox cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement("SELECCIONE UN CLIENTE");
                while (rs.next()) {
                    modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(4) + " - " + rs.getString(3)));
                }
                cb.setModel(modeloCombo);
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarList(JList cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                cb.setModel(modeloCombo);
                while (rs.next()) {
                    modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2)));
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarListVendedores(JList cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                cb.setModel(modeloCombo);
                while (rs.next()) {
                    modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(9)), rs.getString(3)));
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarProv(JComboBox cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                cb.setModel(modeloCombo);
                while (rs.next()) {
                    modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(2) + " -- RUC: " + rs.getString(3)));
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static void cargarCli(JComboBox cb, String sql) {
        try {
            try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement("SELEC. UNA OPCIÓN");
                cb.setModel(modeloCombo);
                while (rs.next()) {
                    modeloCombo.addElement(new Combo(Integer.parseInt(rs.getString(1)), rs.getString(3) + " -- RUC/C.I.: " + rs.getString(4)));
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Algunos formularios no estan activos, para actualizarse, o no hay conexión");
        }
    }

    public static String getCodidgo(JComboBox cb) {
        Combo c = (Combo) cb.getSelectedItem();
        int id = c.getCodigo();
        return String.valueOf(id);
    }

    public static String getDesc(JComboBox cb) {
        Combo c = (Combo) cb.getSelectedItem();
        String id = c.getDesc();
        return (id);
    }

    public static String getCodidgoL(JList cb) {
        Combo c = (Combo) cb.getSelectedValue();
        int id = c.getCodigo();
        return String.valueOf(id);
    }

    public static String getDescList(JList cb) {
        Combo c = (Combo) cb.getSelectedValue();
        String des = c.getDesc();
        return String.valueOf(des);
    }

}
