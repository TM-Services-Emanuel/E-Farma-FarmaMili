package Datos;

import Componentes.DataSourceService;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Operacion;
import Componentes.SeleccionarImagen;
import Componentes.generarCodigos;
import IU.dlgVentas;
import Modelo.Vendedor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GestionarVendedor {

    static DataSourceService dss = new DataSourceService();

    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("SELECT MAX(ven_codigo) FROM vendedor");
        return cod;
    }

    public static String addVendedor(Vendedor v, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO vendedor VALUES (");
        sql.append(getCodigo());
        sql.append(",");
        sql.append(v.getCi());
        sql.append(",'");
        sql.append(v.getNombreV());
        sql.append("','");
        sql.append(v.getDireccion());
        sql.append("','");
        sql.append(v.getTelefono());
        sql.append("','");
        sql.append(v.getCelular());
        sql.append("','");
        sql.append(v.getFech_ingreso());
        sql.append("',");
        sql.append(v.getSueldo());
        sql.append(",");
        sql.append(v.getPer_pago());
        sql.append(",'");
        sql.append(v.getFuncon());
        sql.append("','");
        sql.append(v.getPer_adelanto());
        sql.append("',");
        sql.append(v.getFrecuencia());
        sql.append(",");
        sql.append(v.getMonto_adelanto());
        sql.append(",'S','");
        sql.append(usuario);
        sql.append("')");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static void addImagen(String cod) {
        String sql = "INSERT INTO imagenVendedor (img_vendedor, img_imagen) VALUES (?, ?)";
        try (Connection cn = dss.getDataSource().getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(cod));
            ps.setBinaryStream(2, SeleccionarImagen.fis, SeleccionarImagen.longitudBytes);
            ps.execute();
            ps.close();
            System.out.println("Imagen Guardada");
        } catch (SQLException e) {
            Mensajes.error("No se pudo guardarImagen " + e.toString());
        }
    }

    public static void actImagen(String cod) {
        String sql = "UPDATE imagenVendedor SET img_imagen=? WHERE img_vendedor=?";
        try (Connection cn = dss.getDataSource().getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(2, Integer.parseInt(cod));
            ps.setBinaryStream(1, SeleccionarImagen.fis, SeleccionarImagen.longitudBytes);
            ps.executeUpdate();
            ps.close();
            System.out.println("Imagen actualizada");
        } catch (SQLException e) {
            Mensajes.error("No se pudo actualizar imagen " + e.getMessage());
        }
    }

    public static void busImagen(String cod, JLabel lblImagen) {
        String sql = new StringBuffer("SELECT img_imagen FROM imagenVendedor WHERE img_vendedor = ")
                .append(cod).toString();
        ImageIcon foto;
        InputStream is;
        try (Connection cn = dss.getDataSource().getConnection(); PreparedStatement sentencia = cn.prepareStatement(sql); ResultSet rs = sentencia.executeQuery()) {
            while (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                lblImagen.setIcon(newicon);
            }
        } catch (Exception ex) {
            System.out.println("No se pudo cargar imagen " + ex.toString());
        }
    }

    public static String actVendedor(Vendedor v, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE vendedor SET ven_ci=");
        sql.append(v.getCi());
        sql.append(",'");
        sql.append(v.getNombreV());
        sql.append("',ven_direccion='");
        sql.append(v.getDireccion());
        sql.append("',ven_telefono='");
        sql.append(v.getTelefono());
        sql.append("',ven_celular='");
        sql.append(v.getCelular());
        sql.append("',fecha_ingreso='");
        sql.append(v.getFech_ingreso());
        sql.append("',ven_sueldo=");
        sql.append(v.getSueldo());
        sql.append(",periodo_pago=");
        sql.append(v.getPer_pago());
        sql.append(",funcion='");
        sql.append(v.getFuncon());
        sql.append("',per_adelanto='");
        sql.append(v.getPer_adelanto());
        sql.append("',frecuencia=");
        sql.append(v.getFrecuencia());
        sql.append(",monto_adelanto=");
        sql.append(v.getMonto_adelanto());
        sql.append(",usu='");
        sql.append(usuario);
        sql.append("' WHERE ven_codigo = ");
        sql.append(v.getCodVe());
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static Vendedor busVendedor(String cod) {
        Vendedor v = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM vendedor WHERE ven_codigo=");
        sql.append(cod);
        sql.append("");
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            v = new Vendedor();
            v.setCodVe(Integer.parseInt(filaObt[0].toString()));
            v.setCi(Integer.parseInt(filaObt[1].toString()));
            v.setNombreV(filaObt[2].toString());
            v.setDireccion(filaObt[3].toString());
            v.setTelefono(filaObt[4].toString());
            v.setCelular(filaObt[5].toString());
            v.setFech_ingreso(filaObt[6].toString());
            v.setSueldo(Integer.parseInt(filaObt[7].toString()));
            v.setPer_pago(Integer.parseInt(filaObt[8].toString()));
            v.setFuncon(filaObt[9].toString());
            v.setPer_adelanto(filaObt[10].toString());
            v.setFrecuencia(Integer.parseInt(filaObt[11].toString()));
            v.setMonto_adelanto(Integer.parseInt(filaObt[12].toString()));
        } else {
            System.out.println("No encontrado");
        }
        return v;
    }

    public static Vendedor busVendedor2(String cod) {
        Vendedor v = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM vendedor WHERE ven_codigo =");
        sql.append(cod);
        sql.append("");
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            v = new Vendedor();
            v.setCodVe(Integer.parseInt(filaObt[0].toString()));
            System.out.println(Integer.parseInt(filaObt[0].toString()));
            v.setNombreV(filaObt[1].toString());
            System.out.println((filaObt[1].toString()));
        } else {
            System.out.println("No encontrado");
        }
        return v;
    }

    public static Vendedor busVendedorFactura(String cod) {
        Vendedor v = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM v_usuario WHERE CodVend =");
        sql.append(cod);
        sql.append(" And CodPerfil=2");
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            v = new Vendedor();
            v.setNombreV(filaObt[2].toString());
            dlgVentas.btnConfirmarFactura.setEnabled(true);
            dlgVentas.txtAbonoF.setEditable(true);
            dlgVentas.txtAbonoF.requestFocus();
            dlgVentas.txtAbonoF.selectAll();
        } else {
            System.out.println("No encontrado");
            Mensajes.error("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
            dlgVentas.btnConfirmarFactura.setEnabled(false);
            dlgVentas.txtAbonoF.setEditable(false);
            dlgVentas.txtCodVendedorF.requestFocus();
            dlgVentas.txtCodVendedorF.selectAll();
        }
        return v;
    }

    public static Vendedor busVendedorTicket(String cod) {
        Vendedor v = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM v_usuario WHERE CodVend =");
        sql.append(cod);
        sql.append(" And CodPerfil=2");
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            v = new Vendedor();
            v.setNombreV(filaObt[2].toString());
            dlgVentas.btnConfirmarTicket.setEnabled(true);
            dlgVentas.txtAbonoT.setEditable(true);
            dlgVentas.txtAbonoT.requestFocus();
            dlgVentas.txtAbonoT.selectAll();

        } else {
            System.out.println("No encontrado");
            Mensajes.error("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
            dlgVentas.btnConfirmarTicket.setEnabled(false);
            dlgVentas.txtAbonoT.setEditable(false);
            dlgVentas.txtCodVendedorT.requestFocus();
            dlgVentas.txtCodVendedorT.selectAll();
        }
        return v;
    }

    public static String delVendedor(String cod, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE vendedor SET ven_indicador='N', usu='");
        sql.append(usuario);
        sql.append("' WHERE ven_codigo =");
        sql.append(cod);
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static List listVendedor(String cad) {
        StringBuilder sql = new StringBuilder("SELECT * FROM vendedor WHERE ven_indicador='S' ORDER BY ");
        sql.append(cad);
        sql.append("");
        return Operacion.getTabla(sql.toString());
    }

    public static List filNombre(String cad) {
        StringBuilder sql = new StringBuilder("SELECT * FROM vendedor WHERE ven_indicador='S' AND ven_nombre LIKE '%");
        sql.append(cad);
        sql.append("%'");
        return Operacion.getTabla(sql.toString());
    }

    public static List filDireccion(String cad) {
        StringBuilder sql = new StringBuilder("SELECT * FROM vendedor WHERE ven_indicador='S' AND ven_direccion LIKE '");
        sql.append(cad);
        sql.append("%'");
        return Operacion.getTabla(sql.toString());
    }

    public static List filTelefono(String cad) {
        StringBuilder sql = new StringBuilder("SELECT * FROM vendedor WHERE ven_indicador='S' AND ven_telefono LIKE '");
        sql.append(cad);
        sql.append("%'");
        return Operacion.getTabla(sql.toString());
    }
}
