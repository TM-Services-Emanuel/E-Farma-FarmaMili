package Datos;

import Componentes.Fecha;
import Componentes.Operacion;
import Componentes.generarCodigos;
import Modelo.Compra;
import Modelo.DetalleCompra;
import java.util.List;

public class GestionarCompra {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("SELECT MAX(com_codigo) from compra");
        return cod;
    }
    
    public static String addCompra(Compra c) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO compra VALUES (");
        sql.append(c.getCodCompra()).append(",");
        sql.append(c.getCodProveedor()).append(",'");
        sql.append(c.getCondPago()).append("','");
        sql.append(c.getFact()).append("','");
        sql.append(c.getFecha()).append("','");
        sql.append(Fecha.darHora()).append("',");
        sql.append(c.getTotal()).append(",");
        sql.append(c.getExenta()).append(",");
        sql.append(c.getIVA5()).append(",");
        sql.append(c.getIVA10()).append(",'S')");
        msg = Operacion.exeOperacion(sql.toString());

        return msg;
    }


    public static String actCompra(Compra c) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE compras SET com_codigo=");
        sql.append(c.getCodCompra()).append(",com_proveedor=");
        sql.append(c.getCodProveedor()).append(",com_condPago='");
        sql.append(c.getCondPago()).append("',com_fecha='");
        sql.append(c.getFecha()).append("',com_total=");
        sql.append(c.getTotal()).append(",com_indicador='N' WHERE com_codigo=");
        sql.append(c.getCodCompra()).append("");
        msg = Operacion.exeOperacion(sql.toString());
//        msg = Operacion.exeOperacion("UPDATE compras SET com_codigo=" 
//                + c.getCodCompra() + ",com_proveedor=" 
//                + c.getCodProveedor() + ",com_condPago='" 
//                + c.getCondPago() + "',com_fecha='" 
//                + c.getFecha() + "',com_total=" 
//                + c.getTotal() + ",com_indicador='N' WHERE com_codigo=" 
//                + c.getCodCompra() + "");
        return msg;
    }

    public static String addDetalleCompra(DetalleCompra dc) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO detalle_compra VALUES (");
        sql.append(dc.getCodCompra()).append(",");
        sql.append(dc.getCodArticulo()).append(",");
        sql.append(dc.getCant()).append(",");
        sql.append(dc.getPrecio()).append(",");
        sql.append(dc.getMonto()).append(")");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static String delCompra(String cod, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE compra SET com_indicador='N', usu='"+usuario+"' WHERE com_codigo=");
        sql.append(cod);
//        String sql = "UPDATE compras SET com_indicador='N' WHERE com_codigo = " + cod + "";
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

     public static List listarCompras(String busc) {
        StringBuilder sql = new StringBuilder("SELECT * from v_compras1");
        /*sql.append("compra.caja_ca_id,");
        sql.append(" compra.com_fecha,");
        sql.append(" compra.com_hora,");
        sql.append(" proveedor.pro_ruc,");
        sql.append(" proveedor.pro_razonsocial,");
        sql.append(" compra.com_condpago,");
        sql.append(" compra.com_factura,");
        sql.append(" proveedor.pro_codigo,");
        sql.append(" compra.com_total,");
        sql.append(" compra.com_indicador");
        sql.append(" FROM compra ");
        sql.append(" JOIN proveedor ON compra.proveedor_pro_codigo = proveedor.pro_codigo");*/
        sql.append(" WHERE pro_ruc LIKE '%").append(busc).append("%' OR pro_razonsocial LIKE '%").append(busc).append("%' OR com_factura LIKE '%").append(busc).append("%'");
        return Operacion.getTabla(sql.toString());
    }

    public static List listarDetalleCompras(String cod) {
        StringBuilder sql = new StringBuilder("SELECT detalle_compra.compra_com_codigo,");
        sql.append("articulo.art_codigo,");
        sql.append("articulo.art_codbarra,");
        sql.append("articulo.art_descripcion,");
        sql.append("detalle_compra.com_cantidad,");
        sql.append("detalle_compra.com_costo,");
        sql.append("detalle_compra.com_total");
        sql.append(" FROM compra");
        sql.append(" JOIN detalle_compra ON detalle_compra.compra_com_codigo = compra.com_codigo");
        sql.append(" JOIN articulo ON detalle_compra.articulo_art_codigo = articulo.art_codigo");
        sql.append(" WHERE compra.com_codigo =").append(cod);
        return Operacion.getTabla(sql.toString());
    }

}
