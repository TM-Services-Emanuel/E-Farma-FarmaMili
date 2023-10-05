package Componentes;

import java.sql.*;

public class generarCodigos {

    static DataSourceService dss = new DataSourceService();

    public static String getCodigo(String sql) {
        String codgen = "";
        try (Connection con = dss.getDataSource().getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql);) {
            rs.first();
            codgen = String.valueOf(rs.getInt(1) + 1);
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Tabla vacía getCodigo: " + e.getMessage());
        }
        return codgen;
    }

    public static String ObtenerCodigo(String sql) {
        String codgen = "";
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {
            rs.first();
            codgen = String.valueOf(rs.getInt(1));
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Tabla vacía ObtenerCodigo: " + e.getMessage());
        }
        return codgen;
    }

    public static String getCantidad(String sql) {
        String codgen;
        String CodMaximo = "";
        int contador = 0;
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {
            ResultSetMetaData rmeta = rs.getMetaData();
            int numColumnas = rmeta.getColumnCount();
            while (rs.next()) {
                for (int j = 1; j <= numColumnas; j++) {
                    CodMaximo = rs.getString(j);
                }
                contador++;
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Tabla vacía getCantidad: " + e.getMessage());
        }
        if (contador == 0) {
            codgen = "1";
        } else {
            int mayor = Integer.parseInt(CodMaximo.substring(0));
            codgen = String.valueOf(mayor);
        }
        return codgen;
    }

    public static String getDecimales(String sql) {
        String codgen;
        String CodMaximo = "";
        int contador = 0;
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {

            ResultSetMetaData rmeta = rs.getMetaData();
            int numColumnas = rmeta.getColumnCount();
            while (rs.next()) {
                for (int j = 1; j <= numColumnas; j++) {
                    CodMaximo = rs.getString(j);
                }
                contador++;
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println(0.0);
        }
        if (contador == 0) {
            codgen = "1";
        } else {
            int mayor = Integer.parseInt(CodMaximo.substring(0));
            codgen = String.valueOf(mayor);
        }
        return codgen;
    }

    public static String getFecha(String sql) {
        String codgen;
        String CodMaximo = "";
        int contador = 0;
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {
            ResultSetMetaData rmeta = rs.getMetaData();
            int numColumnas = rmeta.getColumnCount();
            while (rs.next()) {
                for (int j = 1; j <= numColumnas; j++) {
                    CodMaximo = rs.getString(j);
                }
                contador++;
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Tabla vacía - getFecha: " + e.getMessage());
        }
        if (contador == 0) {
            codgen = "1";
        } else {
            String mayor = String.valueOf(CodMaximo.substring(0));
            codgen = String.valueOf(mayor);
        }
        return codgen;
    }

}
