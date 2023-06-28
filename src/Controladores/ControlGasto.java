package Controladores;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionarGasto;
import IU.dlgGastos;
import Modelo.Gasto;

public class ControlGasto {
    static String UsuarioL="";

    public static String addGasto() {
        String msg;
        int caj = Integer.parseInt(dlgGastos.txtCaja.getText());
        String fecha = dlgGastos.dcFecha.getText();
        String gaFecha = Fecha.formatoFecha(fecha);
        System.out.println(gaFecha);
        int gaDescripcion = Integer.parseInt(dlgGastos.lblCodDetalle.getText());
        String gaNombre = dlgGastos.txtNombre.getText().toUpperCase().trim();
        int gaImporte = Integer.parseInt(dlgGastos.txtImporteL.getText());
        String gaObservacion = dlgGastos.txtObservacion.getText().toUpperCase().trim();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        Gasto gasto = new Gasto(caj, gaFecha, gaDescripcion, gaNombre, gaImporte, gaObservacion, usuario);

        msg = GestionarGasto.addGasto(gasto);

        if (msg == null) {
            Mensajes.informacion("Registrado");
        } else {
            Mensajes.error("No se pudo guardar");
        }

        return "";

    }

}
