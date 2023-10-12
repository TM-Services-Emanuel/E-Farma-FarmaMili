package Controladores;

import IU.frmPrincipal;

public class controlPerfil {

    public static void perfil() {
        String perf = ControlLogeo.perfil();
        if (perf.equalsIgnoreCase("ALMACEN"))
        {
            frmPrincipal.panelClientes.setVisible(false);
            frmPrincipal.panelProveedores.setVisible(false);
            frmPrincipal.panelCompras.setVisible(false);
            frmPrincipal.panelVentas.setVisible(false);
            frmPrincipal.mnCompras.setVisible(false);
            frmPrincipal.mnVentas.setVisible(false);
            frmPrincipal.mnMantenimiento.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.mnReportes.setVisible(false);
            frmPrincipal.rpVentas.setVisible(false);
            frmPrincipal.rpCompras.setVisible(false);
            frmPrincipal.rpDevoluciones.setVisible(false);
            frmPrincipal.rpPresupuestos.setVisible(false);
            frmPrincipal.rpClientes.setVisible(false);
            frmPrincipal.rpProveedores.setVisible(false);
            frmPrincipal.rpVendedores.setVisible(false);
            frmPrincipal.mnNCProveedor.setVisible(false);
            frmPrincipal.mnPagoProveedor.setVisible(false);
            frmPrincipal.mnNCVenta.setVisible(false);
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.panelGestTicket.setVisible(false);
            frmPrincipal.panelGestionarCompras.setVisible(false);
            frmPrincipal.divisor4.setVisible(false);
            frmPrincipal.divisor5.setVisible(false);
            frmPrincipal.panelGestFacturas.setVisible(false);
        } else if (perf.equalsIgnoreCase("COMPRA"))
        {
            frmPrincipal.panelProductos.setVisible(false);
            frmPrincipal.panelVentas.setVisible(false);
            frmPrincipal.panelClientes.setVisible(false);
            frmPrincipal.mnArticulos.setVisible(false);
            frmPrincipal.mnVentas.setVisible(false);
            frmPrincipal.mnClientes.setVisible(false);
            frmPrincipal.mnInformacion.setVisible(false);
            frmPrincipal.mnEmpleados.setVisible(false);
            frmPrincipal.mnSeguridad.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.mnReportes.setVisible(false);
            frmPrincipal.rpVentas.setVisible(false);
            frmPrincipal.rpArticulos.setVisible(false);
            frmPrincipal.rpDevoluciones.setVisible(false);
            frmPrincipal.rpPresupuestos.setVisible(false);
            frmPrincipal.rpClientes.setVisible(false);
            frmPrincipal.rpVendedores.setVisible(false);
            frmPrincipal.rpProveedores.setVisible(false);
            frmPrincipal.mnNCProveedor.setVisible(false);
            frmPrincipal.mnPagoProveedor.setVisible(false);
            frmPrincipal.mnNCVenta.setVisible(false);
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.panelGestTicket.setVisible(false);
            frmPrincipal.divisor4.setVisible(false);
            frmPrincipal.divisor5.setVisible(false);
            frmPrincipal.panelGestFacturas.setVisible(false);
            frmPrincipal.Separator13.setVisible(false);
            frmPrincipal.Separator11.setVisible(false);
            frmPrincipal.panelTransferencias.setVisible(false);
            frmPrincipal.panelGestTransferencias.setVisible(false);
            frmPrincipal.mnTransferencias.setVisible(false);
        } else if (perf.equalsIgnoreCase("VENTA"))
        {
            frmPrincipal.panelProductos.setVisible(false);
            frmPrincipal.panelProveedores.setVisible(false);
            frmPrincipal.panelCompras.setVisible(false);
            frmPrincipal.mnInformacion.setVisible(false);
            frmPrincipal.mnEmpleados.setVisible(false);
            frmPrincipal.mnProveedores.setVisible(false);
            frmPrincipal.mnSeguridad.setVisible(false);
            frmPrincipal.mnArticulos.setVisible(false);
            frmPrincipal.mnCompras.setVisible(false);
            frmPrincipal.mnReportes.setVisible(false);
            frmPrincipal.rpCompras.setVisible(false);
            frmPrincipal.rpArticulos.setVisible(false);
            frmPrincipal.rpDevoluciones.setVisible(false);
            frmPrincipal.rpPresupuestos.setVisible(false);
            frmPrincipal.rpClientes.setVisible(false);
            frmPrincipal.rpVendedores.setVisible(false);
            frmPrincipal.rpProveedores.setVisible(false);
            frmPrincipal.mnNCProveedor.setVisible(false);
            frmPrincipal.mnPagoProveedor.setVisible(false);
            frmPrincipal.mnNCVenta.setVisible(false);
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
            frmPrincipal.panelGestionarCompras.setVisible(false);
            frmPrincipal.mnGVE.setVisible(false);
            frmPrincipal.divisor5.setVisible(false);
            frmPrincipal.Separator13.setVisible(false);
            frmPrincipal.Separator11.setVisible(false);
            frmPrincipal.panelTransferencias.setVisible(false);
            frmPrincipal.panelGestTransferencias.setVisible(false);
            frmPrincipal.mnTransferencias.setVisible(false);
            
        } else if (perf.equalsIgnoreCase("ADMINISTRADOR")) {
            frmPrincipal.btnArticulos.setVisible(true);
            frmPrincipal.btnProveedores.setVisible(true);
            frmPrincipal.btnCompras.setVisible(true);
            frmPrincipal.btnClientes.setVisible(true);
            frmPrincipal.btnVentas.setVisible(true);
            frmPrincipal.mnMantenimiento.setVisible(true);
            frmPrincipal.mnArticulos.setVisible(true);
            frmPrincipal.mnCompras.setVisible(true);
            frmPrincipal.mnVentas.setVisible(true);
            frmPrincipal.mnCaja.setVisible(true);
            frmPrincipal.mnReportes.setVisible(true);
            frmPrincipal.mnNCProveedor.setVisible(false);
            frmPrincipal.mnPagoProveedor.setVisible(false);
            frmPrincipal.mnNCVenta.setVisible(false);
            frmPrincipal.mnGNCVenta.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
        } else if (perf.equalsIgnoreCase("DESARROLLADOR")) {
            frmPrincipal.btnArticulos.setVisible(true);
            frmPrincipal.btnProveedores.setVisible(true);
            frmPrincipal.btnCompras.setVisible(true);
            frmPrincipal.btnClientes.setVisible(true);
            frmPrincipal.btnVentas.setVisible(true);
            frmPrincipal.mnMantenimiento.setVisible(true);
            frmPrincipal.mnArticulos.setVisible(true);
            frmPrincipal.mnCompras.setVisible(true);
            frmPrincipal.mnVentas.setVisible(true);
            frmPrincipal.mnCaja.setVisible(true);
            frmPrincipal.mnReportes.setVisible(true);
            frmPrincipal.mnComision.setVisible(true);
            frmPrincipal.mnConfiguracion.setVisible(true);
        }else {
            frmPrincipal.btnArticulos.setVisible(false);
            frmPrincipal.btnProveedores.setVisible(false);
            frmPrincipal.btnCompras.setVisible(false);
            frmPrincipal.btnClientes.setVisible(false);
            frmPrincipal.btnVentas.setVisible(false);
            frmPrincipal.mnMantenimiento.setVisible(false);
            frmPrincipal.mnArticulos.setVisible(false);
            frmPrincipal.mnCompras.setVisible(false);
            frmPrincipal.mnVentas.setVisible(false);
            frmPrincipal.mnCaja.setVisible(false);
            frmPrincipal.mnReportes.setVisible(false);
            frmPrincipal.mnComision.setVisible(false);
            frmPrincipal.mnConfiguracion.setVisible(false);
            frmPrincipal.smModUsuariosD.setVisible(false);
        }
    }

}
