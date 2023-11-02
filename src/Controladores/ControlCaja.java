package Controladores;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Notif;
import Datos.GestionarCaja;
import IU.dlgCaja;
import IU.dlgCajaDia;
import Modelo.Caja;

public class ControlCaja {
static String UsuarioL="";
    public static String addCaja() {
        String msg;
        String caFechaI = dlgCaja.lbFecha.getText();
        String caHoraI= dlgCaja.lbHora.getText();
        String caUsuI= dlgCaja.lbUsuario.getText();
        String caUsuF=" ";
        int caInicial = Integer.parseInt(dlgCaja.txtCaInicial.getText().replace(".", "").replace(",", ""));

        Caja caja = new Caja(caFechaI, caHoraI, caInicial,0, 0, 0, caUsuI);
        msg = GestionarCaja.addCaja(caja);
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "MOVIMIENTO DIARIO:\r\nLa caja base de día fue establecida exitosamente.\r\n\nPuede comenzar a registrar operaciones con total normalidad.");
            //Mensajes.informacion("MOVIMIENTO DIARIO:\nLa caja base de día fue establecida exitosamente.\nPuede comenzar a registrar operaciones.");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actCaja() {
        String msg;
        int caId=Integer.parseInt(dlgCajaDia.lbNCaja.getText());
        int caFinal = Integer.parseInt(dlgCajaDia.lblEntregar.getText().trim().replace(".", "").replace(",", ""));
        int caEntregado = Integer.parseInt(dlgCajaDia.txtEntregado.getText().trim().replace(".", "").replace(",", ""));
        int caDif = Integer.parseInt(dlgCajaDia.lblDiferencia.getText().replace(".", "").replace(",", ""));

        Caja caja = new Caja(caId, caFinal, caEntregado , caDif);
        msg = GestionarCaja.actCaja(caja);
        if (msg == null) {
            Notif.NotifySuccess("Notificación del sistema", "MOVIMIENTO DIARIO:\r\nLos valores fueron actualizados satisfactoriamente.");
           // Mensajes.informacion("MOVIMIENTO DIARIO:\r\nLos valores fueron actualizados satisfactoriamente.");
        } else {
            //Mensajes.informacion("Caja del día actualizada");
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String delCaja() {
        String msg;
        int caId=Integer.parseInt(dlgCajaDia.lbNCaja.getText());
        String caFechaF = Fecha.fechaCorrecta();
        String caHoraF = Fecha.darHora();
        int caFinal = Integer.parseInt(dlgCajaDia.lblEntregar.getText().trim().replace(".", "").replace(",", ""));
        int caEntregado = Integer.parseInt(dlgCajaDia.txtEntregado.getText().trim().replace(".", "").replace(",", ""));
        int caDif = Integer.parseInt(dlgCajaDia.lblDiferencia.getText().replace(".", "").replace(",", ""));
        String caUsuF=UsuarioL=Login.getUsuarioLogueado();

        Caja caja = new Caja(caId, caFechaF, caHoraF, caFinal, caEntregado, caDif, caUsuF);
        msg = GestionarCaja.delCaja(caja);
        if (msg == null) {
            //Mensajes.informacion("MOVIMIENTO DIARIO:\nLa caja del día y su Operaciones fueron finalizados exitosamente.");
            Notif.NotifySuccess("Notificación del sistema", "MOVIMIENTO DIARIO:\r\nLa caja del día y su Operaciones fueron finalizados exitosamente.");
            dlgCajaDia.lbEstado.setText("CERRADO");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

}
