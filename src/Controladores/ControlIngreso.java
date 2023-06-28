package Controladores;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionarFactura;
import Datos.GestionarIngreso;
import IU.dlgConsultarCreditos;
import IU.dlgConsultarCreditosFacturas;
import IU.dlgIngreso;
import Modelo.Ingreso;

public class ControlIngreso {
    static String UsuarioL="";
    public static String addIngreso() {
        String msg;
        String fecha = dlgIngreso.dFecha.getText();
        String ingFecha = Fecha.formatoFecha(fecha);
        System.out.println(ingFecha);
        int ingCa = Integer.parseInt(dlgIngreso.txtCaja.getText());
        int ingDescripcion = Integer.parseInt(dlgIngreso.lblCodDetallIngreso.getText());
        int ingCliente = Integer.parseInt(dlgIngreso.lblCodCliente.getText());
        int ingImporte = Integer.parseInt(dlgIngreso.txtImporteL.getText());
        String ingObserv = dlgIngreso.txtObservacion.getText();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        Ingreso ingreso = new Ingreso(ingCa, ingFecha, ingCliente, ingDescripcion, ingImporte, ingObserv, usuario);

        msg = GestionarIngreso.addIngreso(ingreso);

        if (msg == null) {
            Mensajes.informacion("Registrado");
        } else {
            Mensajes.error("No se pudo registrar");
        }

        return msg;
    }
    public static String addPago() {
        String msg;
        String fecha = dlgConsultarCreditos.dFecha.getText();
        String ingFecha = Fecha.formatoFecha(fecha);
        System.out.println(ingFecha);
        int ingCod = Integer.parseInt(dlgConsultarCreditos.txtCodIngreso.getText());
        int ingCa = Integer.parseInt(dlgConsultarCreditos.txtCaja.getText());
        int ingDescripcion = Integer.parseInt(dlgConsultarCreditos.lblCodDetallIngreso.getText());
        int ingCliente = Integer.parseInt(dlgConsultarCreditos.lblCodCliente.getText());
        int ingImporte = Integer.parseInt(dlgConsultarCreditos.txtImporteL.getText());
        String ingObserv = dlgConsultarCreditos.txtObservacion.getText();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        Ingreso ingreso = new Ingreso(ingCod, ingCa, ingFecha, ingCliente, ingDescripcion, ingImporte, ingObserv, usuario);

        msg = GestionarIngreso.addIngresoPago(ingreso);

        if (msg == null) {
            Mensajes.informacion("Pago registrado");
            int codVenta=Integer.parseInt(dlgConsultarCreditos.lbCodVenta.getText());
            pagarFactura(codVenta);
        } else {
            Mensajes.error("No se pudo registrar");
        }

        return msg;
    }
    
    public static String addPagoF() {
        String msg;
        String fecha = dlgConsultarCreditosFacturas.dFecha.getText();
        String ingFecha = Fecha.formatoFecha(fecha);
        System.out.println(ingFecha);
        int ingCod = Integer.parseInt(dlgConsultarCreditosFacturas.txtCodIngreso.getText());
        int ingCa = Integer.parseInt(dlgConsultarCreditosFacturas.txtCaja.getText());
        int ingDescripcion = Integer.parseInt(dlgConsultarCreditosFacturas.lblCodDetallIngreso.getText());
        int ingCliente = Integer.parseInt(dlgConsultarCreditosFacturas.lblCodCliente.getText());
        int ingImporte = Integer.parseInt(dlgConsultarCreditosFacturas.txtImporteL.getText());
        String ingObserv = dlgConsultarCreditosFacturas.txtObservacion.getText();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        Ingreso ingreso = new Ingreso(ingCod, ingCa, ingFecha, ingCliente, ingDescripcion, ingImporte, ingObserv, usuario);

        msg = GestionarIngreso.addIngresoPago(ingreso);

        if (msg == null) {
            Mensajes.informacion("Pago registrado");
            int codVenta=Integer.parseInt(dlgConsultarCreditosFacturas.lbCodVenta.getText());
            pagarFacturaL(codVenta);
        } else {
            Mensajes.error("No se pudo registrar");
        }

        return msg;
    }
    
    public static String pagarFactura(int cod)//Metodo para cambiar estado de facturas
    {
        String msg;
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarFactura.actPendiente_a_Pagado(String.valueOf(cod), usuario);
        if (msg == null) {
            Mensajes.informacion("Estado actualizado a ABONADO");
            dlgConsultarCreditos.imprimirTicket_Pago();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String pagarFacturaL(int cod)//Metodo para cambiar estado de facturas
    {
        String msg;
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarFactura.actPendiente_a_Pagado2(String.valueOf(cod), usuario);
        if (msg == null) {
            Mensajes.informacion("Estado actualizado a ABONADO");
            dlgConsultarCreditosFacturas.imprimirTicket_Pago();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

}
