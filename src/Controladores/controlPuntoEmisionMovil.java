package Controladores;

import Componentes.Mensajes;
import Componentes.cargarComboBox;
import Datos.GestionarPuntoEmisionMovil;
import IU.dlgPuntoEmisionMovil;
import Modelo.PuntoEmisionMovil;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlPuntoEmisionMovil {
    public static String addPuntoEmision()
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        int idTimbrado = Integer.parseInt(cargarComboBox.getCodidgo(dlgPuntoEmisionMovil.cboTimbrado));
        String establecimiento = dlgPuntoEmisionMovil.txtEstablecimiento.getText().trim();
        String puntoEmision = dlgPuntoEmisionMovil.txtEmision.getText().trim();
        String direccion = dlgPuntoEmisionMovil.txtDireccion.getText().trim();
        int facturainicio= Integer.parseInt(dlgPuntoEmisionMovil.txtFInicio.getText().trim());
        int facturafin= Integer.parseInt(dlgPuntoEmisionMovil.txtFFin.getText().trim());
        int facturaactual= Integer.parseInt(dlgPuntoEmisionMovil.txtFActual.getText().trim());
        String tipo;
        String ip;
        if(dlgPuntoEmisionMovil.cbTickeet.isSelected()){
            tipo="T";
            ip=dlgPuntoEmisionMovil.txtIP.getText().trim();
        }else{
            tipo="L";
            ip=dlgPuntoEmisionMovil.txtIP.getText().trim();
        }
        String estado;
        if(dlgPuntoEmisionMovil.rbActivo.isSelected()){
            estado="Activo";
        }else{
            estado="Inactivo";
        }
        String impPred= dlgPuntoEmisionMovil.txtImpresora.getText().replace("\\", "\\\\").replace("\"", "\\");
        
        PuntoEmisionMovil pm = new PuntoEmisionMovil(cod, idTimbrado, establecimiento,puntoEmision,direccion, facturainicio, facturafin, facturaactual, tipo, ip, estado, impPred);
        msg = GestionarPuntoEmisionMovil.addPuntoEmision(pm);
        if(msg==null)
        {
            Mensajes.informacion("Punto de Emisión Registrado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actPuntoEmision()
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        String establecimiento = dlgPuntoEmisionMovil.txtEstablecimiento.getText().trim();
        String puntoEmision = dlgPuntoEmisionMovil.txtEmision.getText().trim();
        String direccion = dlgPuntoEmisionMovil.txtDireccion.getText().trim();
        int facturainicio= Integer.parseInt(dlgPuntoEmisionMovil.txtFInicio.getText().trim());
        int facturafin= Integer.parseInt(dlgPuntoEmisionMovil.txtFFin.getText().trim());
        int facturaactual= Integer.parseInt(dlgPuntoEmisionMovil.txtFActual.getText().trim());
        String tipo;
        String ip;
        if(dlgPuntoEmisionMovil.cbTickeet.isSelected()){
            tipo="T";
            ip=dlgPuntoEmisionMovil.txtIP.getText().trim();
        }else{
            tipo="L";
            ip=dlgPuntoEmisionMovil.txtIP.getText().trim();
        }
        String estado;
        if(dlgPuntoEmisionMovil.rbActivo.isSelected()){
            estado="Activo";
        }else{
            estado="Inactivo";
        }
        String impPred= dlgPuntoEmisionMovil.txtImpresora.getText().replace("\\", "\\\\").replace("\"", "\\");
        
        PuntoEmisionMovil pm = new PuntoEmisionMovil(cod, establecimiento,puntoEmision,direccion, facturainicio, facturafin, facturaactual, tipo, ip, estado, impPred);
        msg = GestionarPuntoEmisionMovil.actPuntoEmision(pm);
        if(msg==null)
        {
            Mensajes.informacion("Punto de Emisión Actualizado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String delPuntoEmision()    
    {
        String msg;
        int cod = Integer.parseInt(dlgPuntoEmisionMovil.txtCod.getText().trim());
        msg = GestionarPuntoEmisionMovil.delPuntoEmision(cod);
        if(msg==null)
        {
            Mensajes.informacion("Punto de Emisión eliminado");
        }
        else{
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static void listPuntoEmision(JTable tabla)
    {
        List lista;
        lista = GestionarPuntoEmisionMovil.listPuntoEmision();
        for(int i=1;i<lista.size();i++)
        {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
}