package Controladores;

import Componentes.DataSourceService;
import Componentes.Empresa;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Tickets;
import Componentes.Timbrado;
import Componentes.traerIP;
import Datos.Logeo;
import IU.frmAcceso;
import IU.frmPrincipal;
import Modelo.Usuario;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class ControlLogeo {

    static Timer timer;
    int cont;
    public static final int ONE_SECOND=2;
    
    static Usuario u;
    static String user;
    static String pass;
    public static String UsuarioL = "";
    
    static DataSourceService dss = new DataSourceService();

    public static String logear() {
        user = frmAcceso.txtUsuario.getText().trim();
        //pass = Encript.getStringMessageDigest(frmAcceso.psPasword.getText(), Encript.MD5);
        pass = String.valueOf(frmAcceso.psPasword.getPassword());
        u = Logeo.logear(user, pass);
        
        if (u.getPefil().equalsIgnoreCase("ADMINISTRADOR")) {
            //ip=u.getIp();
            //System.out.println(u.getIp()+" vs "+ traerIP.getIP() );
            //if (ip.equals(traerIP.getIP())) {
                String msg = Logeo.acceso(u);
                abrirPrincipal();
                frmPrincipal.lblUsuario.setText(u.getNomUsuario());
                frmPrincipal.lbUsuario.setText(u.getUsuario());
                UsuarioL=u.getUsuario();
                Login.setUsuarioLogueado(UsuarioL);
                Login.setPasswordLogeado(u.getPassword());
                Login.setIdLogueado(String.valueOf(u.getCodUsuario()));
                frmPrincipal.lbPerfil.setText(u.getPefil());
            //} else {
            //    frmAcceso.lblMensaje.setText("Dirección IP no autorizada para la conexión, verifique la Configuración.");
            //}
        }else if (u.getPefil().equalsIgnoreCase("VENTA")) {
            //ip=u.getIp();
            //if (ip.equals(traerIP.getIP())) {
                String msg = Logeo.acceso(u);
                abrirPrincipal();
                frmPrincipal.lblUsuario.setText(u.getNomUsuario());
                frmPrincipal.lbUsuario.setText(u.getUsuario());
                UsuarioL=u.getUsuario();
                Login.setUsuarioLogueado(UsuarioL);
                Login.setPasswordLogeado(u.getPassword());
                Login.setIdLogueado(String.valueOf(u.getCodUsuario()));
                frmPrincipal.lbPerfil.setText(u.getPefil());
            //} else {
            //    frmAcceso.lblMensaje.setText("Dirección IP no autorizada para la conexión, verifique la Configuración.");
            //}
        }else if (u.getPefil().equalsIgnoreCase("COMPRA")) {
            //ip=u.getIp();
            //if (ip.equals(traerIP.getIP())) {
                String msg = Logeo.acceso(u);
                abrirPrincipal();
                frmPrincipal.lblUsuario.setText(u.getNomUsuario());
                frmPrincipal.lbUsuario.setText(u.getUsuario());
                UsuarioL=u.getUsuario();
                Login.setUsuarioLogueado(UsuarioL);
                Login.setPasswordLogeado(u.getPassword());
                Login.setIdLogueado(String.valueOf(u.getCodUsuario()));
                frmPrincipal.lbPerfil.setText(u.getPefil());
            //} else {
            //    frmAcceso.lblMensaje.setText("Dirección IP no autorizada para la conexión, verifique la Configuración.");
            //}
        }else if (u.getPefil().equalsIgnoreCase("ALMACEN")) {
            //ip=u.getIp();
            //if (ip.equals(traerIP.getIP())) {
                String msg = Logeo.acceso(u);
                abrirPrincipal();
                frmPrincipal.lblUsuario.setText(u.getNomUsuario());
                frmPrincipal.lbUsuario.setText(u.getUsuario());
                UsuarioL=u.getUsuario();
                Login.setUsuarioLogueado(UsuarioL);
                Login.setPasswordLogeado(u.getPassword());
                Login.setIdLogueado(String.valueOf(u.getCodUsuario()));
                frmPrincipal.lbPerfil.setText(u.getPefil());
            //} else {
            //    frmAcceso.lblMensaje.setText("Dirección IP no autorizada para la conexión, verifique la Configuración.");
            //}
        }
        else if (u.getPefil().equalsIgnoreCase("DESARROLLADOR")) {
            //ip=u.getIp();
            //if (ip.equals(traerIP.getIP())) {
                String msg = Logeo.acceso(u);
                abrirPrincipal();
                frmPrincipal.lblUsuario.setText(u.getNomUsuario());
                frmPrincipal.lbUsuario.setText(u.getUsuario());
                UsuarioL=u.getUsuario();
                Login.setUsuarioLogueado(UsuarioL);
                Login.setPasswordLogeado(u.getPassword());
                Login.setIdLogueado(String.valueOf(u.getCodUsuario()));
                frmPrincipal.lbPerfil.setText(u.getPefil());
            //} else {
            //    frmAcceso.lblMensaje.setText("Dirección IP no autorizada para la conexión, verifique la Configuración.");
            //}
        }
        return String.valueOf(u.getNomUsuario());
    }

    public static String perfil() {
        return String.valueOf(u.getPefil());
    }

    public static String desLogeo() {
        String msg = null;
        msg = Logeo.salida(u);
        if (msg == null) {
            System.out.println("Se inserto Salida");
        } else {
            System.out.println("No se inserto salida");
        }
        return msg;
    }

    public static void abrirPrincipal() {
        try {
            frmPrincipal p = new frmPrincipal();
            p.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
            p.setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Error levantando formulario principal: "+ex.getMessage());
        }
    }
    
    public static void Timbrado_Ticket() {
        try {
            String sql = "SELECT * FROM v_puntoemision3 WHERE ip='" + traerIP.getIP() + "' AND tipo='L' AND estado='Activo'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {
                rs.last();
                if (rs.getRow() != 0) {
                    Timbrado.setIdEmision(rs.getInt(1));
                    System.out.println("ID EMISION FACTURA LEGAL: " + Timbrado.getIdEmision());
                    Timbrado.setIdTimbrado(rs.getInt(2));
                    System.out.println("ID TIMBRADO: " + Timbrado.getIdTimbrado());
                    Timbrado.setTimbrado(rs.getString(3));
                    System.out.println("TIMBRADO: " + Timbrado.getTimbrado());
                    Timbrado.setDesde(rs.getString(4));
                    System.out.println("VALIDEZ DESDE: " + Timbrado.getDesde());
                    Timbrado.setHasta(rs.getString(5));
                    System.out.println("VALIDEZ HASTA: " + Timbrado.getHasta());
                    Timbrado.setEstablecimiento(rs.getString(6));
                    System.out.println("ESTABLECIMIENTO: " + Timbrado.getEstablecimiento());
                    Timbrado.setPuntoExpedicion(rs.getString(7));
                    System.out.println("PUNTO DE EXPEDICIÓN: " + Timbrado.getPuntoExpedicion());
                    Timbrado.setFacturaFin(rs.getInt(10));
                    System.out.println("FACTURAR HASTA NRO.: " + Timbrado.getFacturaFin());
                    //Timbrado.setIdBoca(rs.getInt(17));
                    //System.out.println("ID BOCA: " + Timbrado.getIdBoca());
                    Timbrado.setImpresora(rs.getString(15));
                    System.out.println("IMPRESORA: " + Timbrado.getImpresora());
                    Timbrado.setHabilitado("SI");
                    System.out.println("FACTURA LEGAL HABILITADO: " + Timbrado.getHabilitado());
                    System.out.println("-------------------------------------------------------");
                    try {
                        SimpleDateFormat fe = new SimpleDateFormat("dd/MM/yyyy");
                        Date FechaA = fe.parse(Fecha.fechaFormulario());
                        Date FechaT = fe.parse(Timbrado.getHasta());
                        if (FechaA.equals(FechaT)) {
                            Timbrado.setValidado("SI");
                        } else if (FechaA.after(FechaT)) {
                            Timbrado.setValidado("NO");
                            Mensajes.Sistema("EMISIÓN DE FACTURA LEGAL NO HABILITADO:\nEl Timbrado actual ha expirado.\nPara retomar las facturaciones legales sera necesario configurar un nuevo Timbrado.");
                        } else if (FechaA.before(FechaT)) {
                            Timbrado.setValidado("SI");
                        }
                    } catch (ParseException es) {
                        System.out.println("Error comparando validez de timbrado: " + es.getMessage());
                    }

                } else {
                    Mensajes.Sistema("EMISIÓN DE FACTURA LEGAL NO HABILITADO:\nNo se encuentra Punto de expedición para la emisión de facturas legales.");
                    Timbrado.setHabilitado("NO");
                    System.out.println("FACTURA LEGAL HABILITADO: " + Timbrado.getHabilitado());
                    System.out.println("-------------------------------------------------------");
                }
                rs.close();
                st.close();
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo Timbrado: " + e.getMessage());
        }

        try {
            String sql = "SELECT * FROM v_puntoemision3 WHERE ip='" + traerIP.getIP() + "' AND tipo='T' AND estado='Activo'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {
                rs.last();
                if (rs.getRow() != 0) {
                    Tickets.setIdEmision(rs.getInt(1));
                    System.out.println("ID EMISION TICKET: " + Tickets.getIdEmision());
                    Tickets.setEstablecimiento(rs.getString(6));
                    System.out.println("ESTABLECIMIENTO TICKET: " + Tickets.getEstablecimiento());
                    Tickets.setPuntoExpedicion(rs.getString(7));
                    System.out.println("PUNTO EXPEDICION TICKET: " + Tickets.getPuntoExpedicion());
                    Tickets.setTicketFin(rs.getInt(10));
                    System.out.println("TICKET FIN: " + Tickets.getTicketFin());
                    Tickets.setImpresora(rs.getString(15));
                    System.out.println("IMPRESORA: " + Tickets.getImpresora());
                    Tickets.setHabilitado("SI");
                    System.out.println("TICKET HABILITADO: " + Tickets.getHabilitado());
                    System.out.println("-------------------------------------------------------");
                } else {
                    Mensajes.Sistema("EMISIÓN DE TICKET NO HABILITADO:\nNo se encuentra un Punto de expedición para emisión de tickets.");
                    Tickets.setHabilitado("NO");
                    System.out.println("TICKET HABILITADO: " + Tickets.getHabilitado());
                    System.out.println("-------------------------------------------------------");
                }
                rs.close();
                st.close();
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo Ticket: " + e.getMessage());
        }
    }
    
    public static void Empresa(){
        try {
            String sql = "select * from v_sucursal where suc_indicador='S'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql);) {
                rs.last();
                if (rs.getRow() != 0) {
                    Empresa.setEmpresa(rs.getString(3));
                    System.out.println("NOMBRE FANTASIA: " + Empresa.getEmpresa());
                    Empresa.setRazonSocial(rs.getString(4));
                    System.out.println("RAZON SOCIAL: " + Empresa.getRazonSocial());
                    Empresa.setRUC(rs.getString(5));
                    System.out.println("RUC: " + Empresa.getRUC());
                    Empresa.setSucursal(rs.getString(2));
                    System.out.println("SUCURSAL: " + Empresa.getSucursal());
                    Empresa.setCelular(rs.getString(8)+" "+rs.getString(9));
                    System.out.println("CELULAR: " + Empresa.getCelular());
                    Empresa.setDireccion(rs.getString(10));
                    System.out.println("DIRECCION: " + Empresa.getDireccion());
                    Empresa.setHabilitado("SI");
                    System.out.println("EMPRESA HABILITADA: " + Empresa.getHabilitado());
                    System.out.println("-------------------------------------------------------");
                } else {
                    System.out.println("EMPRESA HABILITADO: "+Empresa.getHabilitado());
                    System.out.println("-------------------------------------------------------");
                }
                rs.close();
                st.close();
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo Empresa: " + e.getMessage());
        }
    }

}
