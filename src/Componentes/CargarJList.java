package Componentes;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class CargarJList {

    static DataSourceService dss = new DataSourceService();
    static DefaultComboBoxModel modeloCombo;

    public static void cargar(JList cb, String sql) {
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

    public static String getCodidgo(JList cb) {
        Combo c = (Combo) cb.getSelectedValue();
        int id = c.getCodigo();
        System.out.println("getCodigo: " + id);
        return String.valueOf(id);
    }
}
