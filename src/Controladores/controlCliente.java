package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Notif;
import Datos.GestionarCliente;
import IU.dlgClientes;
import IU.dlgGestClientes;
import Modelo.Cliente;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlCliente {

    public static void aModificar() {
        int x = dlgClientes.tablaClientes.getSelectedRow();
        String cod = dlgClientes.tablaClientes.getValueAt(x, 0).toString();
        Cliente c = GestionarCliente.busCliente(cod);
        DecimalFormat df = new DecimalFormat("#,###");
        dlgGestClientes.lblCodC.setText(String.valueOf(c.getCodCliente()));
        dlgGestClientes.cbCiudad.setSelectedIndex(c.getCodCiudad());
        dlgGestClientes.txtRazonS.setText(c.getRazonSocial());
        dlgGestClientes.txtRuc.setText(c.getRuc());
        dlgGestClientes.txtTelefono.setText(c.getTelefon());
        dlgGestClientes.txtContacto.setText(c.getContacto());
        dlgGestClientes.txtCelular.setText(c.getCelu());
        dlgGestClientes.txtDireccion.setText(c.getDireccion());
        dlgGestClientes.txaS.setText(c.getOsb());
        if (c.getContado().equals("SI")) {
            dlgGestClientes.chbContado.setSelected(true);
        } else {
            dlgGestClientes.chbContado.setSelected(false);
        }
        if (c.getCredito().equals("SI")) {
            dlgGestClientes.chbCredito.setSelected(true);
            dlgGestClientes.txtLimite.setEnabled(true);
        } else {
            dlgGestClientes.chbCredito.setSelected(false);
            dlgGestClientes.txtLimite.setEnabled(false);
        }
        dlgGestClientes.txtLimite.setText(df.format(Integer.valueOf(c.getLimCuenta())));
    }

    public static Cliente capturarCampos() {
        Cliente c;
        String contac;
        String telf;
        String cont;
        String cred;
        String obs;
        int codC = Integer.parseInt(dlgGestClientes.lblCodC.getText());
        int codCi = Integer.parseInt(dlgGestClientes.lbCiudad.getText());
        String razonS = dlgGestClientes.txtRazonS.getText().toUpperCase();
        String ruc = dlgGestClientes.txtRuc.getText().toUpperCase();
        if (dlgGestClientes.txtContacto.getText().toUpperCase().isEmpty()) {
            contac = "' '";
        } else {
            contac = dlgGestClientes.txtContacto.getText().toUpperCase();
        }
        String celu = dlgGestClientes.txtCelular.getText();
        if (dlgGestClientes.txtTelefono.getText().isEmpty()) {
            telf = "' '";
        } else {
            telf = dlgGestClientes.txtTelefono.getText();
        }
        String direc = dlgGestClientes.txtDireccion.getText().toUpperCase();
        if (dlgGestClientes.txaS.getText().isEmpty()) {
            obs = "' '";
        } else {
            obs = dlgGestClientes.txaS.getText().toUpperCase();
        }
        if (dlgGestClientes.chbContado.isSelected()) {
            cont = "SI";
        } else {
            cont = "NO";
        }
        if (dlgGestClientes.chbCredito.isSelected()) {
            cred = "SI";
        } else {
            cred = "NO";
        }
        int limCta = Integer.parseInt(dlgGestClientes.txtLimite.getText().trim().replace(".", "").replace(",", ""));
        c = new Cliente(codC, codCi, razonS, ruc, contac, celu, telf, direc, obs, cont, cred, limCta, Login.getUsuarioLogueado());
        return c;
    }

    public static String addCliente() {
        String msg;
        Cliente c = capturarCampos();
        msg = GestionarCliente.addCliente(c);
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "Cliente Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actCliente() {
        String msg;
        Cliente c = capturarCampos();
        msg = GestionarCliente.actCliente(c);
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "Cliente Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String delCliente() {
        int x = dlgClientes.tablaClientes.getSelectedRow();
        String msg;
        String cod = dlgClientes.tablaClientes.getValueAt(x, 0).toString();
        msg = GestionarCliente.delCliente(cod, Login.getUsuarioLogueado());
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "Cliente Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listClientes(JTable tabla, String cod) {
        List lista;
        lista = GestionarCliente.listClientes(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filtClientes(JTable tabla, String cad) {
        List lista;
        lista = GestionarCliente.filRazonS(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filtRuc(JTable tabla, String cad) {
        List lista;
        lista = GestionarCliente.filRuc(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }
}
