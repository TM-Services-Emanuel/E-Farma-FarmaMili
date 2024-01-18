package Datos;

import Componentes.Operacion;
import Componentes.generarCodigos;
import Modelo.Articulo;
import java.io.FileInputStream;
import java.util.List;

public class GestionarArticulos {

    static FileInputStream fis;

    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("select MAX(art_codigo) from articulo");
        return cod;
    }

    public static String addArticulo(Articulo art) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO articulo VALUES (");
        sql.append(art.getCodArticulo()).append(", ").append(art.getCodFam()).append(", ").append(art.getCodLab()).append(", ").append(art.getCodProv());
        sql.append(", '").append(art.getCodBarra()).append("', '").append(art.getDescripcion()).append("', '").append(art.getPrincipio()).append("','");
        sql.append(art.getAccion()).append("', ").append(art.getCosto()).append(", ").append(art.getCostoiva()).append(", ").append(art.getIva()).append(", ");
        sql.append(art.getStock()).append(", ").append(art.getStockMin()).append(", '").append(art.getVencimiento()).append("', ");
        sql.append(art.getGanancia()).append(", ").append(art.getDescuento()).append(", ").append(art.getPpublico()).append(", ");
        sql.append(art.getPventa()).append(", '").append(art.getVenta()).append("', '").append(art.getTipo()).append("', '");
        sql.append(art.getProdActivo()).append("', 'S', '").append(art.getVM()).append("', ").append(art.getCM()).append(", ").append(art.getPM());
        sql.append(", '").append(art.getUsu()).append("')");
        msg = Operacion.exeOperacion(sql.toString());
        /*msg = Operacion.exeOperacion("INSERT INTO articulo VALUES (" + art.getCodArticulo() + ",'" + art.getDescripcion() + "',"
         + art.getCodMarca() + "," + art.getCodProveedor() + "," + art.getEfectivo() + "," + art.getMontoCalculado() + ","
         + art.getTarjeta() + "," + art.getCosto() + ",'" + art.getFecha() + "'," + art.getCodUnidad() + "," + art.getCodRubro() + ","
         + art.getStock() + ",'S')");*/
        return msg;
    }


    public static String actArticulo(Articulo art) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET familia_fam_codigo=").append(art.getCodFam()).append(", laboratorio_lab_codigo=");
        sql.append(art.getCodLab()).append(", proveedor_pro_codigo=").append(art.getCodProv()).append(", art_codbarra='");
        sql.append(art.getCodBarra()).append("', art_descripcion='").append(art.getDescripcion()).append("', art_principio='").append(art.getPrincipio()).append("', art_accion='");
        sql.append(art.getAccion()).append("', art_costo=").append(art.getCosto()).append(", art_costoiva=").append(art.getCostoiva()).append(", art_iva=");
        sql.append(art.getIva()).append(", art_stock=").append(art.getStock()).append(", art_stockminimo=").append(art.getStockMin()).append(", art_vencimiento='");
        sql.append(art.getVencimiento()).append("', art_ganancia=").append(art.getGanancia()).append(", art_descuento=").append(art.getDescuento()).append(", art_preciopublico=");
        sql.append(art.getPpublico()).append(", art_precioventa=").append(art.getPventa()).append(", art_tipoventa='").append(art.getVenta()).append("', art_tipodesc='");
        sql.append(art.getTipo()).append("', art_activo='").append(art.getProdActivo()).append("', art_ventaM='").append(art.getVM());
        sql.append("', art_cantM=").append(art.getCM()).append(", art_precioventaM=").append(art.getPM()).append(", usu='").append(art.getUsu()).append("' ");
        sql.append("WHERE art_codigo=").append(art.getCodArticulo()).append("");
        msg = Operacion.exeOperacion(sql.toString());
        /*msg = Operacion.exeOperacion("UPDATE articulo SET art_descripcion='" + art.getDescripcion() +
         "',art_marca=" + art.getCodMarca() +
         ",art_proveedor=" + art.getCodProveedor() +
         ",art_efectivo=" + art.getEfectivo() +
         ",art_montoCalculado=" + art.getMontoCalculado() +
         ",art_tarjeta=" + art.getTarjeta() +
         ",art_costo=" + art.getCosto() +
         ",art_fechaCompra='" + art.getFecha() +
         "',art_unidad=" + art.getCodUnidad() +
         ",art_rubro=" + art.getCodRubro() + 
         ",art_stock=" + art.getStock() +
         " WHERE art_codigo=" + art.getCodArticulo() + "");*/
        return msg;
    }
    public static String actStock(Articulo art) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_stock=");
        sql.append(art.getStock());
        sql.append(" WHERE art_codigo=");
        sql.append(art.getCodArticulo());
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        //msg = Operacion.exeOperacion("UPDATE articulo SET art_stock=" + art.getStock() + " WHERE art_codigo=" + art.getCodArticulo() + "");
        return msg;
    }

    public static String actStockMENOS(Articulo art) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_stock=art_stock-");
        sql.append(art.getStock());
        sql.append(" WHERE art_codigo=");
        sql.append(art.getCodArticulo());
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }
    public static String actStockMAS(Articulo art) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_stock=art_stock+");
        sql.append(art.getStock());
        sql.append(" WHERE art_codigo=");
        sql.append(art.getCodArticulo());
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }
    
    public static String InactivarArticulo(String cod) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_activo = 'N' WHERE art_codigo = ");
        sql.append(cod);
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }
    public static String ActivarArticulo(String cod) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_activo = 'S' WHERE art_codigo = ");
        sql.append(cod);
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static String delArticulo(String cod, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE articulo SET art_indicador = 'N', usu='");
        sql.append(usuario);
        sql.append("' WHERE art_codigo =");
        sql.append(cod);
        sql.append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static Articulo busArticulo(String cod) {
        Articulo ar = null;
        StringBuilder s = new StringBuilder("SELECT * FROM articulo WHERE art_codigo = ");
        s.append(cod);
        s.append("");
        Object[] filaObt = Operacion.getFila(s.toString());
        if (filaObt != null) {
            ar = new Articulo();
            ar.setCodArticulo(Integer.parseInt(filaObt[0].toString()));
            ar.setCodFam(Integer.parseInt(filaObt[1].toString()));
            ar.setCodLab(Integer.parseInt(filaObt[2].toString()));
            ar.setCodProv(Integer.parseInt(filaObt[3].toString()));
            ar.setCodBarra((filaObt[4].toString()));
            ar.setDescripcion(filaObt[5].toString());
            ar.setPrincipio(filaObt[6].toString());
            ar.setAccion(filaObt[7].toString());
            ar.setCosto(Integer.parseInt(filaObt[8].toString()));
            ar.setCostoiva(Double.parseDouble(filaObt[9].toString()));
            ar.setIva(Integer.parseInt(filaObt[10].toString()));
            ar.setStock(Integer.parseInt(filaObt[11].toString()));
            ar.setStockMin(Integer.parseInt(filaObt[12].toString()));
            ar.setVencimiento(filaObt[13].toString());
            ar.setGanancia(Double.parseDouble(filaObt[14].toString()));
            ar.setDescuento(Double.parseDouble(filaObt[15].toString()));
            ar.setPpublico(Integer.parseInt(filaObt[16].toString()));
            ar.setPventa(Integer.parseInt(filaObt[17].toString()));
            ar.setVenta(filaObt[18].toString());
            ar.setTipo(filaObt[19].toString());
            ar.setProdActivo(filaObt[20].toString());
            ar.setVM(filaObt[22].toString());
            ar.setCM(Integer.parseInt(filaObt[23].toString()));
            ar.setPM(Integer.parseInt(filaObt[24].toString()));
            System.out.println("Encontrado");
        } else {
            System.out.println("No encontrado");
        }
        return ar;
    }
    
    public static List listArticulo(String cod) {
                String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva,")
                .append(" ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo")
                //.append(" WHERE ")
                //.append("ind= 'S'")
                .append(" ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }
    

    public static List filtrarDescripcion(String cad) {
                String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva, ")
                .append("ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo ")
                .append("WHERE descripcion LIKE '%")
                .append(cad)
                .append("%' AND ind='S' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }
    public static List filtrarDescripcionActivo(String cad) {
        String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva, ")
                .append("ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo ")
                .append("WHERE descripcion LIKE '%")
                .append(cad)
                .append("%' AND ind='S' AND activo='SI' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }

    public static List filtrarPrincipioActivo(String cad) {
        String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva, ")
                .append("ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo ")
                .append("WHERE principio LIKE '%")
                .append(cad)
                .append("%' AND ind='S' AND activo='SI' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }

    public static List filtrarCodBarra(String cad) {
        String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva, ")
                .append("ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo ")
                .append("WHERE barra LIKE '%")
                .append(cad)
                .append("%' AND ind= 'S' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }
    public static List listArticuloActivo(String cod) {
                String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva,")
                .append(" ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo_activo ORDER BY fam")
                //.append(" WHERE activo='SI' AND ind= 'S'")
                //.append(" ORDER BY fam")
               // .append(cod)
                .toString();
        return Operacion.getTabla(sql);
    }
    public static List filtrarCodBarraActivo(String cad) {
                String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, ppublico, des, costo, iva, costoiva,")
                .append(" pventa,ganstandar, gan, venta, activo FROM v_articulo_activo")
                //.append(" WHERE activo='SI' AND ind= 'S'")
                .append(" WHERE barra LIKE '%")
                .append(cad)
                .append("%' OR descripcion LIKE '%")
                .append(cad)
                .append("%' OR principio LIKE '%")
                .append(cad)
                .append("%' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }
    
    public static List filtrarGral(String cad) {
                String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, ppublico, des, costo, iva, costoiva,")
                .append(" pventa,ganstandar, gan, venta, activo FROM v_articulo")
                .append(" WHERE barra LIKE '%")
                .append(cad)
                .append("%' OR principio LIKE '%")
                .append(cad)
                .append("%' OR descripcion LIKE '%")
                .append(cad)
                .append("%' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }
    /*public static List filtrarCodBarraActivo(String cad) {
        String sql = new StringBuffer("SELECT cod, barra, fam, lab, prov, descripcion, principio, accion, stock, stockmin, costo, iva, costoiva, ")
                .append("ppublico, des, pventa,ganstandar, gan, venta, activo FROM v_articulo ")
                .append("WHERE barra LIKE '%")
                .append(cad)
                .append("%' OR descripcion LIKE '%")
                .append(cad)
                .append("%' OR principio LIKE '%")
                .append(cad)
                .append("%' AND activo='SI' AND ind= 'S' ORDER BY fam")
                .toString();
        return Operacion.getTabla(sql);
    }*/

}
