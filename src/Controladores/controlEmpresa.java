package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionarEmpresa;
import IU.dlgEmpresa;
import Modelo.Empresa;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlEmpresa {
    static String UsuarioL="";
    public static String addEmpresa()
    {
        String msg;
        int cod = Integer.parseInt(dlgEmpresa.txtCod.getText());
        String nombre = dlgEmpresa.txtNombre.getText().toUpperCase();
        String ruc = dlgEmpresa.txtRuc.getText().toUpperCase();
        String direccion = dlgEmpresa.txtDireccion.getText().toUpperCase();
        String telefono = dlgEmpresa.txtTelefono.getText().toUpperCase();
        String celular = dlgEmpresa.txtCelular.getText().toUpperCase();
        String visual = dlgEmpresa.lbvisual.getText().toUpperCase();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        Empresa e = new Empresa(cod, nombre, ruc, direccion, telefono, celular, visual,usuario);
        msg = GestionarEmpresa.addEmpresa(e);
        if(msg==null)
        {
            Mensajes.informacion("Empresa Registrada");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actEmpresa()
    {
        String msg;
        int cod = Integer.parseInt(dlgEmpresa.txtCod.getText());
        String nombre = dlgEmpresa.txtNombre.getText().toUpperCase();
        String ruc = dlgEmpresa.txtRuc.getText().toUpperCase();
        String direccion = dlgEmpresa.txtDireccion.getText().toUpperCase();
        String telefono = dlgEmpresa.txtTelefono.getText().toUpperCase();
        String celular = dlgEmpresa.txtCelular.getText().toUpperCase();
        String visual = dlgEmpresa.lbvisual.getText().toUpperCase();
        System.out.println(visual);
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        Empresa e = new Empresa(cod, nombre, ruc, direccion, telefono, celular, visual, usuario);
        msg = GestionarEmpresa.actEmpresa(e);
        if(msg==null)
        {
            Mensajes.informacion("Empresa Actualizada");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String delEmpresa()
    {
        String msg;
        String cod = dlgEmpresa.txtCod.getText();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        msg = GestionarEmpresa.delEmpresa(cod, usuario);
        if(msg==null)
        {
            Mensajes.informacion("Empresa Eliminada");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    
    public static void lisEmpresa(JTable tabla)
    {
        List lista;
        lista = GestionarEmpresa.listEmpresa();
        for(int i=1;i<lista.size();i++)
        {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            String[] filas = new String[8];
            Object[]fila = (Object[])lista.get(i);
            filas[0] = fila[0].toString();
            filas[1] = fila[1].toString();
            filas[2] = fila[2].toString();
            filas[3] = fila[3].toString();
            filas[4] = fila[4].toString();
            filas[5] = fila[5].toString();
            filas[6] = fila[6].toString();
            filas[7] = fila[7].toString();
            tb.addRow(filas);
        }
    }
    
    
}
