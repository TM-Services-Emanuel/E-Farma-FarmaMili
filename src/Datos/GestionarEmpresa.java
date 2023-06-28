package Datos;

import Componentes.Operacion;
import Componentes.generarCodigos;
//import Modelo.Familia;
import Modelo.Empresa;
import java.util.List;

public class GestionarEmpresa {

    public static String getCodigo() {
        String cod = generarCodigos.getCodigo("SELECT MAX(em_codigo) FROM empresa");
        return cod;
    }

    public static String addEmpresa(Empresa e) {
        String msg;
        StringBuilder sql = new StringBuilder("INSERT INTO empresa VALUES (");
        sql.append(e.getCodEmpresa());
        sql.append(",'");
        sql.append(e.getEmpresa());
        sql.append("','");
        sql.append(e.getRuc());
        sql.append("','");
        sql.append(e.getDireccion());
        sql.append("','");
        sql.append(e.getTelefono());
        sql.append("','");
        sql.append(e.getCelular());
        sql.append("','");
        sql.append(e.getVisual());
        sql.append("','S','");
        sql.append(e.getUsuario());
        sql.append("')");
        msg = Operacion.exeOperacion(sql.toString());
//        msg = Operacion.exeOperacion("INSERT INTO unidad VALUES ("+u.getCodUnidad()+",'"+u.getUnidad()+"','S')");
        return msg;
    }

    public static Empresa busEmpresa(String cod) {
        Empresa e = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM empresa WHERE em_codigo = '");
                sql.append(cod);
                sql.append("'");
//        String sql = "SELECT * FROM unidad WHERE uni_codigo = '"+cod+"'";
        Object[] filaObt = Operacion.getFila(sql.toString());
        if (filaObt != null) {
            e = new Empresa();
            e.setCodEmpresa(Integer.parseInt(filaObt[0].toString()));
            e.setEmpresa(filaObt[1].toString());
        } else {
        }
        return e;
    }

    public static List listEmpresa() {
        String sql = "select * from empresa WHERE em_indicador='S'";
        return Operacion.getTabla(sql);
    }

    public static String actEmpresa(Empresa e) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE empresa SET em_razonsocial = '").append(e.getEmpresa());
        sql.append("',em_ruc='").append(e.getRuc());
        sql.append("',em_direccion='").append(e.getDireccion());
        sql.append("',em_telefono='").append(e.getTelefono());
        sql.append("',em_celular='").append(e.getCelular());
        sql.append("',em_visualizar='").append(e.getVisual());
        sql.append("',usu='").append(e.getUsuario());
        sql.append("' WHERE em_codigo=").append(e.getCodEmpresa()).append("");
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

    public static String delEmpresa(String cod, String usuario) {
        String msg;
        StringBuilder sql = new StringBuilder("UPDATE empresa SET em_indicador='N', ");
                sql.append("usu='").append(usuario);
                sql.append("' WHERE em_codigo = ");
                sql.append(cod);
                sql.append("");
//        String sql = "UPDATE unidad SET uni_indicador='N' WHERE uni_codigo = "+cod+"";
        msg = Operacion.exeOperacion(sql.toString());
        return msg;
    }

}
