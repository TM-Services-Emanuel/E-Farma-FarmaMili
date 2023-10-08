package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionalSucursal;
import IU.dlgSucursal;
import Modelo.Sucursal;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlSucursal {
    public static String addSucursal()
    {
        String msg;
        int cod = Integer.parseInt(dlgSucursal.txtCod.getText());
        String sucur = dlgSucursal.txtSucursal.getText().toUpperCase();
        int emp = Integer.parseInt(dlgSucursal.lbCod.getText());
        String sucurIP = dlgSucursal.txtIPSucursal.getText().toUpperCase();
        String miSuc;
        if(dlgSucursal.rMiSuc.isSelected()){
            miSuc = "S";
        }else{
            miSuc = "N";
        }
        Sucursal s = new Sucursal(cod, sucur, emp, Login.getUsuarioLogueado(),miSuc, sucurIP);
        msg = GestionalSucursal.addSucursal(s);
        if(msg==null)
        {
            Mensajes.informacion("Sucursal registrado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actSucursal()
    {
        String msg;
        int cod = Integer.parseInt(dlgSucursal.txtCod.getText());
        String sucur = dlgSucursal.txtSucursal.getText().toUpperCase();
        int emp= Integer.parseInt(dlgSucursal.lbCod.getText());
        String sucurIP = dlgSucursal.txtIPSucursal.getText().toUpperCase();
        String miSuc;
        if(dlgSucursal.rMiSuc.isSelected()){
            miSuc = "S";
        }else{
            miSuc = "N";
        }
        Sucursal s = new Sucursal(cod,sucur, emp, Login.getUsuarioLogueado(), miSuc, sucurIP);
        msg = GestionalSucursal.actSucursal(s);
        if(msg==null)
        {
            Mensajes.informacion("Sucursal Actualizado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String delSucursal()
    {
        String msg;
        String cod = dlgSucursal.txtCod.getText();
        msg = GestionalSucursal.delSucursal(cod, Login.getUsuarioLogueado());
        if(msg==null)
        {
            Mensajes.informacion("Sucursal Eliminado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static void listSucursal(JTable tabla)
    {
        List lista;
        lista = GestionalSucursal.listSucursal();
        for(int i=1;i<lista.size();i++)
        {
            String filas[] = new String[7];
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            filas[0] = fila[0].toString();
            filas[1] = fila[1].toString();
            if(fila[12].toString().equals("S")){
                filas[2] ="Esta es mi sucursal";
            }else{
                filas[2] ="";
            }
            filas[3]=fila[12].toString();
            filas[4]=fila[10].toString();
            filas[5]=fila[2].toString();
            filas[6]=fila[13].toString();
            tb.addRow(filas);
        }
    }
    
}
