package Datos;

import Componentes.Operacion;
import Componentes.generarCodigos;
import Modelo.Proveedor;
import java.util.List;

public class GestionarProveedor {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("SELECT MAX(pro_codigo) FROM proveedor");
        return cod;
    }

    public static String addProveedor(Proveedor p) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO proveedor  VALUES (");
        sql.append(p.getCodP()).append(",");
        sql.append(p.getCodCiudad()).append(",'");
        sql.append(p.getRazoS()).append("','");
        sql.append(p.getRuc()).append("','");
        sql.append(p.getContac()).append("','");
        sql.append(p.getCelu()).append("','");
        sql.append(p.getTelef()).append("','");
        sql.append(p.getDireccion()).append("','");
        sql.append(p.getObs()).append("','S','");
        sql.append(p.getUsuario()).append("')");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static String actProveedor(Proveedor p) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE proveedor SET ciudad_ciu_codigo='").append(p.getCodCiudad());
        sql.append("',pro_razonsocial='").append(p.getRazoS());
        sql.append("',pro_ruc='").append(p.getRuc());
        sql.append("',pro_contacto='").append(p.getContac());
        sql.append("',pro_celular='").append(p.getCelu());
        sql.append("',pro_telefono='").append(p.getTelef());
        sql.append("',pro_direccion='").append(p.getDireccion());
        sql.append("',pro_observacion='").append(p.getObs());
        sql.append("',usu='").append(p.getUsuario());
        sql.append("' WHERE pro_codigo=").append(p.getCodP()).append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static Proveedor busProveedor(String cod) {
        Proveedor p = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM proveedor WHERE pro_codigo = ");
        sql.append(cod).append("");
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            p = new Proveedor();
            p.setCodP(Integer.parseInt(filaObt[0].toString()));
            p.setCodCiudad(Integer.parseInt(filaObt[1].toString()));
            p.setRazoS(filaObt[2].toString());
            p.setRuc(filaObt[3].toString());
            p.setContac(filaObt[4].toString());
            p.setCelu(filaObt[5].toString());
            p.setTelef(filaObt[6].toString());
            p.setDireccion(filaObt[7].toString());
            p.setObs(filaObt[8].toString());
        } else {
            System.out.println("No encontrado");
        }
        return p;
    }

    public static List listProveedor(String cod) {
        StringBuilder sql = new StringBuilder(" SELECT proveedor.pro_codigo, ");
        //sql.append("proveedor.ciudad_ciu_codigo, ");
        sql.append("proveedor.pro_razonsocial, ");
        sql.append("proveedor.pro_ruc, ");
        sql.append("proveedor.pro_telefono, ");
        sql.append("proveedor.pro_contacto, ");
        sql.append("proveedor.pro_celular, ");
        sql.append("ciudad.ciu_nombre, ");
        sql.append("proveedor.pro_direccion, ");
        sql.append("proveedor.pro_observacion ");
        sql.append("FROM proveedor ");
        sql.append("JOIN ciudad ON proveedor.ciudad_ciu_codigo = ciudad.ciu_codigo ");
        sql.append("WHERE proveedor.pro_indicador = 'S' ");
        sql.append("  ORDER BY ").append(cod).append("");
        return Operacion.getTabla(sql.toString());
    }

    public static String delProveedor(String cod, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE proveedor SET pro_indicador='N', usu='");
        sql.append(usuario).append("' WHERE pro_codigo =");
        sql.append(cod).append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static List filRazonS(String cod) {
        StringBuilder sql = new StringBuilder("SELECT proveedor.pro_codigo, ");
        sql.append("proveedor.pro_razonsocial, ");
        sql.append("proveedor.pro_ruc, ");
        sql.append("proveedor.pro_telefono, ");
        sql.append("proveedor.pro_contacto, ");
        sql.append("proveedor.pro_celular, ");
        sql.append("ciudad.ciu_nombre, ");
        sql.append("proveedor.pro_direccion, ");
        sql.append("proveedor.pro_observacion ");
        sql.append("FROM proveedor ");
        sql.append("JOIN ciudad ON proveedor.ciudad_ciu_codigo = ciudad.ciu_codigo ");
        sql.append("WHERE proveedor.pro_indicador = 'S' AND proveedor.pro_razonsocial LIKE '%").append(cod).append("%'");
        sql.append(" OR proveedor.pro_codigo LIKE '%").append(cod).append("%'");
        sql.append(" OR proveedor.pro_ruc LIKE '%").append(cod).append("%'");
        return Operacion.getTabla(sql.toString());
    }

    public static List filID(String cod) {
        StringBuilder sql = new StringBuilder("SELECT proveedor.pro_codigo, ");
        sql.append("proveedor.pro_razonsocial, ");
        sql.append("proveedor.pro_ruc, ");
        sql.append("proveedor.pro_telefono, ");
        sql.append("proveedor.pro_contacto, ");
        sql.append("proveedor.pro_celular, ");
        sql.append("ciudad.ciu_nombre, ");
        sql.append("proveedor.pro_direccion, ");
        sql.append("proveedor.pro_observacion ");
        sql.append("FROM proveedor ");
        sql.append("JOIN ciudad ON proveedor.ciudad_ciu_codigo = ciudad.ciu_codigo ");

        return Operacion.getTabla(sql.toString());
    }

    public static List filRuc(String cod) {
        StringBuilder sql = new StringBuilder("SELECT proveedor.pro_codigo, ");
        sql.append("proveedor.pro_razonsocial, ");
        sql.append("proveedor.pro_ruc, ");
        sql.append("proveedor.pro_telefono, ");
        sql.append("proveedor.pro_contacto, ");
        sql.append("proveedor.pro_celular, ");
        sql.append("ciudad.ciu_nombre, ");
        sql.append("proveedor.pro_direccion, ");
        sql.append("proveedor.pro_observacion ");
        sql.append("FROM proveedor ");
        sql.append("JOIN ciudad ON proveedor.ciudad_ciu_codigo = ciudad.ciu_codigo ");
        sql.append("WHERE proveedor.pro_indicador ='S' AND proveedor.pro_ruc LIKE '%").append(cod).append("%'");
        return Operacion.getTabla(sql.toString());
    }
}
