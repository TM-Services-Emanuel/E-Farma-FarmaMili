package Controladores;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CabecerasTablas {

    private static final String puntoEmision[] = {"ID", "IDT", "TIMBRADO", "EST.", "P.E.", "DIRECCIÓN", "F.INICIO", "F.FIN", "F.ACTUAL", "TIPO", "DIR. IP", "ESTADO", "IMPRESORA PREDETERMINADA"};
    private static final String timbrado[] = {"ID", "TIMBRADO", "DESDE", "HASTA", "ESTADO"};
    private static final String articulos[] = {"CODIGO", "CODBARRA", "FAMILIA", "LABORATORIO", "PROVEEDOR", "NOMBRE COMERCIAL", "PRINCIPIO ACTIVO", "ACCION TERAPEUTICA",
        "STOCK", "ST.MIN", "P.PUBLICO", "% DESC", "COSTO", "IVA", "COST.IVA", "P.VENTA", "% FLIA", "% LUCRO", "VENTA", "ACT"};
    private static final String familia[] = {"ID", "FAMILIA", "%", "I.V.A."};
    private static final String laboratorio[] = {"ID", "LABORATORIO"};
    private static final String empresa[] = {"ID", "NOMBRE FANTASÍA", "RAZÓN SOCIAL", "R.U.C.", "DIRECCIÓN", "TELÉFONO", "CELULAR", "ACTIVO"};
    private static final String vendedores[] = {"ID", "NOMBRE Y APELLIDO", "DIRECCIÓN", "TELÉFONO", "CELULAR", "SUELDO", "% COM", "OBSERVACIÓN"};
    private static final String clientes[] = {"ID", "NOMBRE Y APELLIDO | RAZÓN SOCIAL", "C.I. | R.U.C.", "TELÉFONO", "CONTACTO", "CELULAR", "VTA.CONT.", "VTA.CRED.", "LMTE.CTA.", "CIUDAD", "DIRECCIÓN", "OBSERVACIÓN"};
    private static final String provedores[] = {"ID", "RAZÓN SOCIAL", "R.U.C.", "TELÉFONO", "CONTACTO", "CELULAR", "CIUDAD", "DIRECCIÓN", "OBSERVACIÓN"};
    private static final String tablaStock[] = {"Código", "Marca", "Descripción", "Stock"};
    private static final String tablaAuxiliarArticulo[] = {"Codigo", "Rubro", "Descripcion", "Marca", "Precio"};
    private static final String ciudad[] = {"ID", "CIUDAD"};
    private static final String sucursal[] = {"ID", "DESCRIPCIÓN SUCURSAL", " ", "MI_SUC", "ID_EMP", "DE LA EMPRESA", "IP SERVIDOR"};
    private static final String zona[] = {"CODIGO", "ZONA"};
    private static final String detalleGasto[] = {"ID", "DESCRIPCIÓN"};
    private static final String motivo[] = {"ID", "MOTIVOS"};
    private static final String salidas[] = {"CODART", "NOMBRE COMERCIAL", "CODMOTIVO", "MOTIVO SALIDA", "CANT", "COSTO", "MONTO"};
    private static final String conSalidas[] = {"OP. N°", "PROVEEDOR", "FECHA", "HORA", "COS.TOTAL", "OBSERVACION", "INDICADOR"};
    private static final String detalleSalida[] = {"CODART", "MOTIVO SALIDA", "CANT", "OP. N°", "NOMBRE COMERCIAL", "COSTO", "MONTO"};
    private static final String compras[] = {"COD", "CODBARRA", "NOMBRE COMERCIAL", "CANT", "CANTf", "PRECIO ", "PRECIOF", "IVA", "EXENTA", "EXENTAf", "IVA 5%", "IVA5f", "IVA 10%", "IVA10f", "MONTO", "MONTOf", "PC", "GA", "DE"};
    private static final String facturas[] = {"COD", "CODBARRA", "NOMBRE COMERCIAL", "CANT", "P.PUBL.", "%DES", "PRECIO", "EXENTA", "IVA 5%", "IVA 10%", "SUB-TOTAL", "DESC", "PPtot","idIVA"};
    private static final String transferencias[] = {"COD", "CODBARRA", "NOMBRE COMERCIAL", "CANT", "PRECIO", "EXENTA", "IVA 5%", "IVA 10%", "SUB-TOTAL", "GANANCIA", "DESCUENTO", "ORDEN", "COSTOIVA"};
    private static final String categoria[] = {"CODIGO", "CATEGORIA"};
    //String factura[] = {"Cant.", "Cod.", "Descripción", "Precio", "Total", "sActual"};
    private static final String presupuestos[] = {"Cant.", "Cod.", "Descripción", "Precio", "Total"};
    private static final String conFactura[] = {"OPERACIÓN", "RAZÓN SOCIAL", "FECHA", "HORA", "COD CLI", "MOV.CAJA", "FACTURA N°", "CONDICION", "PAGO", "TOTAL", "CODVENDE", "ESTADO","E","5","10"};
    private static final String conTransferencia[] = {"ID", "OPERACIÓN", "MOV.CAJA", "FECHA HORA", "TIPO", "ORIGEN", "DESTINO", "TOTAL", "ESTADO"};
    private static final String detalleFactura[] = {"CANT", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "PRECIO", "SUB-TOTAL","IVA","E","5","10"};
    private static final String detalleTransferencia[] = {"CANT", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "PRECIO", "SUB-TOTAL"};
    private static final String consPresupuesto[] = {"N°", "Fecha", "Razon Social", "Cód. Clie", "Desc", "Total"};
    private static final String detallePresupuestoF[] = {"Cant.", "Código", "Descripción", "Precio", "Total"};
    private static final String busEmpleado[] = {"Cód", "Empleado", "Observación"};
    private static final String consNotaCredito[] = {"N°", "Fecha", "Razon Social", "Cod. Clie", "Total", "Desc", "Fac"};
    private static final String detalleNotaCredito[] = {"Cant.", "Cód", "Descripción", "Precio", "Total"};
    private static final String usuario[] = {"ID", "PERFIL ASIG.", "EMPLEADO", "USUARIO", "PASSWORD", "INDICADOR", "IP", "CODPERFIL", "CODVENDE"};
    private static final String comisiones[] = {"FECHA", "FACT.", "CLIENTE", "TOTAL", "%COM.", "COMISION"};
    private static final String consCompras[] = {"OPER. N°", "MOV.CAJ.N°", "FECHA", "HORA", "R.U.C.", "PROVEEDOR", "CONDICIÓN", "FACTURA N°", "Cod. Prov", "TOTAL", "ESTADO"};
    private static final String consDetalleCompras[] = {"OPER. N°", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "CANT", "COSTO", "MONTO"};
    //private static final String datos[][] = {};
    static String datosConsCompras[][] = {};
    static String datosPE[][] = {};
    static String datosTimbrado[][] = {};
    static String datosVentas[][] = {};
    static String datosTransferencia[][] = {};
    static String datosConsDetalleCompras[][] = {};
    static String datosUsuario[][] = {};
    static String datosComision[][] = {};
    static String datosBusEmpleado[][] = {};
    static String datosConsNotaCredito[][] = {};
    static String datosDetalleNotasCredito[][] = {};
    static String datosConsFacturasNotas[][] = {};
    static String datosDetallePresupuesto[][] = {};
    static String datosConsPresupuesto[][] = {};
    static String datosConsFacturas[][] = {};
    static String datosConsTransferencias[][] = {};
    static String datosConsFacturasCreditos[][] = {};
    static String datosConsFacturasA[][] = {};
    static String datosDetalleFactura[][] = {};
    static String datosDetalleTransferencia[][] = {};
    static String datosDetalleFacturaA[][] = {};
    static String datosPresupuesto[][] = {};
    static String datosFactura[][] = {};
    static String datosBuscarCliente[][] = {};
    static String datosCategoria[][] = {};
    static String datosBusProveedor[][] = {};
    static String datosCompras[][] = {};
    static String datosDetalleSalidas[][] = {};
    static String datosConsultaSalidas[][] = {};
    static String datosTablaArticuloAuxiliar[][] = {};
    static String datosTablaArticuloAuxiliarCompra[][] = {};
    static String datosTablaArticuloAuxiliarTransferencia[][] = {};
    static String datosSalidas[][] = {};
    static String datosMotivo[][] = {};
    static String datosCiudad[][] = {};
    static String datosSucursal[][] = {};
    static String datosDetalleGasto[][] = {};
    static String datosAjusteStock[][] = {};
    static String datosArticulos[][] = {};
    static String datosFamilia[][] = {};
    static String datosLaboratorio[][] = {};
    static String datosEmpresa[][] = {};
    static String datosProveedor[][] = {};
    static String datosVendedor[][] = {};
    static String datosCliente[][] = {};
    //private static DefaultTableModel modelo;
    private static DefaultTableModel modeloConsCompras;
    private static DefaultTableModel modeloPE;
    private static DefaultTableModel modeloTimbrado;
    private static DefaultTableModel modeloVentas;
    private static DefaultTableModel modeloTransferencia;
    private static DefaultTableModel modeloConsDetalleCompras;
    private static DefaultTableModel modeloUsuario;
    private static DefaultTableModel modeloComision;
    private static DefaultTableModel modeloBusEmpleado;
    private static DefaultTableModel modeloConsNotaCredito;
    private static DefaultTableModel modeloDetalleNotasCredito;
    private static DefaultTableModel modeloConsFacturasNotas;
    private static DefaultTableModel modeloDetallePresupuesto;
    private static DefaultTableModel modeloConsPresupuesto;
    private static DefaultTableModel modeloConsFacturas;
    private static DefaultTableModel modeloConsTransferencias;
    private static DefaultTableModel modeloConsFacturasCreditos;
    private static DefaultTableModel modeloConsFacturasA;
    private static DefaultTableModel modeloDetalleFactura;
    private static DefaultTableModel modeloDetalleTransferencia;
    private static DefaultTableModel modeloDetalleFacturaA;
    private static DefaultTableModel modeloPresupuesto;
    private static DefaultTableModel modeloFactura;
    private static DefaultTableModel modeloBuscarCliente;
    private static DefaultTableModel modeloCategoria;
    private static DefaultTableModel modeloBusProveedor;
    private static DefaultTableModel modeloCompras;
    private static DefaultTableModel modeloDetalleSalidas;
    private static DefaultTableModel modeloConsultaSalidas;
    private static DefaultTableModel modeloTablaArticuloAuxiliar;
    private static DefaultTableModel modeloTablaArticuloAuxiliarCompra;
    private static DefaultTableModel modeloTablaArticuloAuxiliarTransferencia;
    private static DefaultTableModel modeloSalidas;
    private static DefaultTableModel modeloMotivo;
    private static DefaultTableModel modeloCiudad;
    private static DefaultTableModel modeloSucursal;
    private static DefaultTableModel modeloDetalleGasto;
    private static DefaultTableModel modeloAjusteStock;
    private static DefaultTableModel modeloArticulos;
    private static DefaultTableModel modeloFamilia;
    private static DefaultTableModel modeloLaboratorio;
    private static DefaultTableModel modeloEmpresa;
    private static DefaultTableModel modeloProveedor;
    private static DefaultTableModel modeloVendedor;
    private static DefaultTableModel modeloCliente;
    
    private static TableColumn colum = null;

    /*public static void limpiarTabla(JTable tabla) {
        tabla.setModel(modelo);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }*/
    public static final void limpiarTablaPE(JTable tabla) {
        tabla.setModel(modeloPE);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloPE.removeRow(0);
        }
    }

    public static final void limpiarTablaTimbrado(JTable tabla) {
        tabla.setModel(modeloTimbrado);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTimbrado.removeRow(0);
        }
    }

    public static final void limpiarTablaVentas(JTable tabla) {
        tabla.setModel(modeloVentas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVentas.removeRow(0);
        }
    }

    public static final void limpiarTablaTransferencias(JTable tabla) {
        tabla.setModel(modeloTransferencia);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTransferencia.removeRow(0);
        }
    }

    public static final void limpiarTablaConsCompras(JTable tabla) {
        tabla.setModel(modeloConsCompras);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsCompras.removeRow(0);
        }
    }

    public static final void limpiarTablaConsDetalleCompras(JTable tabla) {
        tabla.setModel(modeloConsDetalleCompras);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsDetalleCompras.removeRow(0);
        }
    }

    public static void limpiarTablaUsuario(JTable tabla) {
        tabla.setModel(modeloUsuario);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloUsuario.removeRow(0);
        }
    }

    public static void limpiarTablaComision(JTable tabla) {
        tabla.setModel(modeloComision);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloComision.removeRow(0);
        }
    }

    public static void limpiarTablaBusEmpleado(JTable tabla) {
        tabla.setModel(modeloBusEmpleado);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloBusEmpleado.removeRow(0);
        }
    }

    public static void limpiarTablaConsNotaCredito(JTable tabla) {
        tabla.setModel(modeloConsNotaCredito);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsNotaCredito.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetalleNotasCredito(JTable tabla) {
        tabla.setModel(modeloDetalleNotasCredito);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleNotasCredito.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsFacturasNotas(JTable tabla) {
        tabla.setModel(modeloConsFacturasNotas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsFacturasNotas.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetallePresupuesto(JTable tabla) {
        tabla.setModel(modeloDetallePresupuesto);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetallePresupuesto.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsPresupuesto(JTable tabla) {
        tabla.setModel(modeloConsPresupuesto);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsPresupuesto.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsFacturas(JTable tabla) {
        tabla.setModel(modeloConsFacturas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsFacturas.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsTransferencias(JTable tabla) {
        tabla.setModel(modeloConsTransferencias);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsTransferencias.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsFacturasCreditos(JTable tabla) {
        tabla.setModel(modeloConsFacturasCreditos);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsFacturasCreditos.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsFacturasA(JTable tabla) {
        tabla.setModel(modeloConsFacturasA);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsFacturasA.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetalleFactura(JTable tabla) {
        tabla.setModel(modeloDetalleFactura);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleFactura.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetalleTransferencia(JTable tabla) {
        tabla.setModel(modeloDetalleTransferencia);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleTransferencia.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetalleFacturaA(JTable tabla) {
        tabla.setModel(modeloDetalleFacturaA);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleFacturaA.removeRow(0);
        }
    }
    
    public static void limpiarTablaPresupuesto(JTable tabla) {
        tabla.setModel(modeloPresupuesto);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloPresupuesto.removeRow(0);
        }
    }
    
    public static void limpiarTablaFactura(JTable tabla) {
        tabla.setModel(modeloFactura);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloFactura.removeRow(0);
        }
    }
    
    public static void limpiarTablaBuscarCliente(JTable tabla) {
        tabla.setModel(modeloBuscarCliente);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloBuscarCliente.removeRow(0);
        }
    }

    public static void limpiarTablaCategoria(JTable tabla) {
        tabla.setModel(modeloCategoria);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloCategoria.removeRow(0);
        }
    }
    
    public static void limpiarTablaBusProveedor(JTable tabla) {
        tabla.setModel(modeloBusProveedor);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloBusProveedor.removeRow(0);
        }
    }
    
    public static void limpiarTablaCompras(JTable tabla) {
        tabla.setModel(modeloCompras);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloCompras.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetalleSalidas(JTable tabla) {
        tabla.setModel(modeloDetalleSalidas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleSalidas.removeRow(0);
        }
    }
    
    public static void limpiarTablaConsultaSalidas(JTable tabla) {
        tabla.setModel(modeloConsultaSalidas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloConsultaSalidas.removeRow(0);
        }
    }
    
    public static void limpiarTablaTablaArticuloAuxiliar(JTable tabla) {
        tabla.setModel(modeloTablaArticuloAuxiliar);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTablaArticuloAuxiliar.removeRow(0);
        }
    }
    
    public static void limpiarTablaTablaArticuloAuxiliarCompra(JTable tabla) {
        tabla.setModel(modeloTablaArticuloAuxiliarCompra);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTablaArticuloAuxiliarCompra.removeRow(0);
        }
    }
    
    public static void limpiarTablaTablaArticuloAuxiliarTransferencia(JTable tabla) {
        tabla.setModel(modeloTablaArticuloAuxiliarTransferencia);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTablaArticuloAuxiliarTransferencia.removeRow(0);
        }
    }
    
    public static void limpiarTablaSalidas(JTable tabla) {
        tabla.setModel(modeloSalidas);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloSalidas.removeRow(0);
        }
    }
    
    public static void limpiarTablaMotivo(JTable tabla) {
        tabla.setModel(modeloMotivo);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloMotivo.removeRow(0);
        }
    }
    
    public static void limpiarTablaCiudad(JTable tabla) {
        tabla.setModel(modeloCiudad);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloCiudad.removeRow(0);
        }
    }
    
    public static void limpiarTablaSucursal(JTable tabla) {
        tabla.setModel(modeloSucursal);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloSucursal.removeRow(0);
        }
    }
    
    public static void limpiarTablaDetalleGasto(JTable tabla) {
        tabla.setModel(modeloDetalleGasto);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloDetalleGasto.removeRow(0);
        }
    }
    
    public static void limpiarTablaAjusteStock(JTable tabla) {
        tabla.setModel(modeloAjusteStock);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloAjusteStock.removeRow(0);
        }
    }
    
    public static void limpiarTablaArticulos(JTable tabla) {
        tabla.setModel(modeloArticulos);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloArticulos.removeRow(0);
        }
    }
    
    public static void limpiarTablaFamilia(JTable tabla) {
        tabla.setModel(modeloFamilia);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloFamilia.removeRow(0);
        }
    }
    
    public static void limpiarTablaLaboratorio(JTable tabla) {
        tabla.setModel(modeloLaboratorio);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloLaboratorio.removeRow(0);
        }
    }
    
    public static void limpiarTablaEmpresa(JTable tabla) {
        tabla.setModel(modeloEmpresa);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloEmpresa.removeRow(0);
        }
    }
    
    public static void limpiarTablaProveedor(JTable tabla) {
        tabla.setModel(modeloProveedor);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloProveedor.removeRow(0);
        }
    }
    
    public static void limpiarTablaVendedor(JTable tabla) {
        tabla.setModel(modeloVendedor);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVendedor.removeRow(0);
        }
    }
    
    public static void limpiarTablaCliente(JTable tabla) {
        tabla.setModel(modeloCliente);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloCliente.removeRow(0);
        }
    }
    
    public final static void Timbrado(JTable tabla) {
        modeloTimbrado = new DefaultTableModel(datosTimbrado, timbrado);
        tabla.setModel(modeloTimbrado);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(135);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(110);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
    }

    public static final void PuntoEmision(JTable tabla) {
        modeloPE = new DefaultTableModel(datosPE, puntoEmision);
        tabla.setModel(modeloPE);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(35);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(35);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(200);
    }

    public static final void consCompras(JTable tabla) {
        modeloConsCompras = new DefaultTableModel(datosConsCompras, consCompras);
        tabla.setModel(modeloConsCompras);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(75);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(95);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(75);

    }

    public static final void consDetalleCompras(JTable tabla) {
        modeloConsDetalleCompras = new DefaultTableModel(datosConsDetalleCompras, consDetalleCompras);
        tabla.setModel(modeloConsDetalleCompras);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(350);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
    }

    public static final void usuario(JTable tabla) {
        modeloUsuario = new DefaultTableModel(datosUsuario, usuario);
        tabla.setModel(modeloUsuario);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void comision(JTable tabla) {
        modeloComision = new DefaultTableModel(datosComision, comisiones);
        tabla.setModel(modeloComision);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
    }

    public static final void busEmpleado(JTable tabla) {
        modeloBusEmpleado = new DefaultTableModel(datosBusEmpleado, busEmpleado);
        tabla.setModel(modeloBusEmpleado);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
    }

    public static final void consNotaCredito(JTable tabla) {
        modeloConsNotaCredito = new DefaultTableModel(datosConsNotaCredito, consNotaCredito);
        tabla.setModel(modeloConsNotaCredito);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void detalleNotasCredito(JTable tabla) {
        modeloDetalleNotasCredito = new DefaultTableModel(datosDetalleNotasCredito, detalleNotaCredito);
        tabla.setModel(modeloDetalleNotasCredito);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public static final void consFacturasNotas(JTable tabla) {
        modeloConsFacturasNotas = new DefaultTableModel(datosConsFacturasNotas, conFactura);
        tabla.setModel(modeloConsFacturasNotas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void detallePresupuesto(JTable tabla) {
        modeloDetallePresupuesto = new DefaultTableModel(datosDetallePresupuesto, detallePresupuestoF);
        tabla.setModel(modeloDetallePresupuesto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public static final void consPresupuesto(JTable tabla) {
        modeloConsPresupuesto = new DefaultTableModel(datosConsPresupuesto, consPresupuesto);
        tabla.setModel(modeloConsPresupuesto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void consFacturas(JTable tabla) {
        modeloConsFacturas = new DefaultTableModel(datosConsFacturas, conFactura);
        tabla.setModel(modeloConsFacturas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(100);

        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void consTransferencias(JTable tabla) {
        modeloConsTransferencias = new DefaultTableModel(datosConsTransferencias, conTransferencia);
        tabla.setModel(modeloConsTransferencias);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(170);
    }

    public static final void consFacturasCreditos(JTable tabla) {
        modeloConsFacturasCreditos = new DefaultTableModel(datosConsFacturasCreditos, conFactura);
        tabla.setModel(modeloConsFacturasCreditos);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
    }

    public static final void consFacturasA(JTable tabla) {
        modeloConsFacturasA = new DefaultTableModel(datosConsFacturasA, conFactura);
        tabla.setModel(modeloConsFacturasA);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void detalleFactura(JTable tabla) {
        modeloDetalleFactura = new DefaultTableModel(datosDetalleFactura, detalleFactura);
        tabla.setModel(modeloDetalleFactura);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(480);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void detalleTransferencia(JTable tabla) {
        modeloDetalleTransferencia = new DefaultTableModel(datosDetalleTransferencia, detalleTransferencia);
        tabla.setModel(modeloDetalleTransferencia);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(480);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
    }

    public static final void detalleFacturaA(JTable tabla) {
        modeloDetalleFacturaA = new DefaultTableModel(datosDetalleFacturaA, detalleFactura);
        tabla.setModel(modeloDetalleFacturaA);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(280);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
    }

    public static final void presupuesto(JTable tabla) {
        modeloPresupuesto = new DefaultTableModel(datosPresupuesto, presupuestos);
        tabla.setModel(modeloPresupuesto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(220);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(70);
    }

    public static final void factura(JTable tabla) {
        modeloFactura = new DefaultTableModel(datosFactura, facturas);
        tabla.setModel(modeloFactura);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(220);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
    }

    public static final void buscarCliente(JTable tabla) {
        modeloBuscarCliente = new DefaultTableModel(datosBuscarCliente, clientes);
        tabla.setModel(modeloBuscarCliente);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(130);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(150);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(100);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(100);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(100);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(100);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void categoria(JTable tabla) {
        modeloCategoria = new DefaultTableModel(datosCategoria, categoria);
        tabla.setModel(modeloCategoria);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(150);
    }

    public static final void busProveedor(JTable tabla) {
        modeloBusProveedor = new DefaultTableModel(datosBusProveedor, provedores);
        tabla.setModel(modeloBusProveedor);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void ventas(JTable tabla) {
        modeloVentas = new DefaultTableModel(datosVentas, facturas);
        tabla.setModel(modeloVentas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(335);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);

        /*colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(335);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(60);*/
    }

    public static final void Transferencias(JTable tabla) {
        modeloTransferencia = new DefaultTableModel(datosTransferencia, transferencias);
        tabla.setModel(modeloTransferencia);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(335);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void compras(JTable tabla) {
        modeloCompras = new DefaultTableModel(datosCompras, compras);
        tabla.setModel(modeloCompras);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(355);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);

        /*tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(355);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(70);    */
    }

    public static final void detalleSalidas(JTable tabla) {
        modeloDetalleSalidas = new DefaultTableModel(datosDetalleSalidas, detalleSalida);
        tabla.setModel(modeloDetalleSalidas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(170);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(320);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);

    }

    public static final void consultaSalidas(JTable tabla) {
        modeloConsultaSalidas = new DefaultTableModel(datosConsultaSalidas, conSalidas);
        tabla.setModel(modeloConsultaSalidas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(500);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void tablaArticuloAuxiliar(JTable tabla) {
        modeloTablaArticuloAuxiliar = new DefaultTableModel(datosTablaArticuloAuxiliar, articulos) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloTablaArticuloAuxiliar);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(320);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        // colum.setMaxWidth(0);
        //colum.setMinWidth(0);
        //colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(20);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void tablaArticuloAuxiliarCompra(JTable tabla) {
        modeloTablaArticuloAuxiliarCompra = new DefaultTableModel(datosTablaArticuloAuxiliarCompra, articulos) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloTablaArticuloAuxiliarCompra);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(320);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void tablaArticuloAuxiliarTransferencia(JTable tabla) {
        modeloTablaArticuloAuxiliarTransferencia = new DefaultTableModel(datosTablaArticuloAuxiliarTransferencia, articulos) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloTablaArticuloAuxiliarTransferencia);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(320);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void salidas(JTable tabla) {
        modeloSalidas = new DefaultTableModel(datosSalidas, salidas);
        tabla.setModel(modeloSalidas);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(340);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
    }

    public static final void motivo(JTable tabla) {
        modeloMotivo = new DefaultTableModel(datosMotivo, motivo);
        tabla.setModel(modeloMotivo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(390);
    }

    public static final void ciudad(JTable tabla) {
        modeloCiudad = new DefaultTableModel(datosCiudad, ciudad);
        tabla.setModel(modeloCiudad);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(390);
    }

    public static final void sucursal(JTable tabla) {
        modeloSucursal = new DefaultTableModel(datosSucursal, sucursal);
        tabla.setModel(modeloSucursal);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(100);
    }

    /*public void zona(JTable tabla) {
        modelo = new DefaultTableModel(datos, zona);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(150);
    }*/
    public static final void detalleGasto(JTable tabla) {
        modeloDetalleGasto = new DefaultTableModel(datosDetalleGasto, detalleGasto);
        tabla.setModel(modeloDetalleGasto);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(380);
    }

    public static final void ajusteStock(JTable tabla) {
        modeloAjusteStock = new DefaultTableModel(datosAjusteStock, articulos);
        tabla.setModel(modeloAjusteStock);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(150);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(300);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(20);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void Articulos(JTable tabla) {
        modeloArticulos = new DefaultTableModel(datosArticulos, articulos);
        tabla.setModel(modeloArticulos);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(160);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(460);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(40);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(20);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(30);
    }
    
    public static final void ArticulosCruceVenta(JTable tabla) {
        modeloArticulos = new DefaultTableModel(datosArticulos, articulos);
        tabla.setModel(modeloArticulos);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(160);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(120);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(460);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(50);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(40);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(12);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(15);
        colum.setPreferredWidth(60);
        colum = tabla.getColumnModel().getColumn(16);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(17);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(18);
        colum.setPreferredWidth(20);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(19);
        colum.setPreferredWidth(30);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void familia(JTable tabla) {
        modeloFamilia = new DefaultTableModel(datosFamilia, familia);
        tabla.setModel(modeloFamilia);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
    }

    public static final void laboratorio(JTable tabla) {
        modeloLaboratorio = new DefaultTableModel(datosLaboratorio, laboratorio);
        tabla.setModel(modeloLaboratorio);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(350);
    }

    public static final void empresa(JTable tabla) {
        modeloEmpresa = new DefaultTableModel(datosEmpresa, empresa);
        tabla.setModel(modeloEmpresa);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(260);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(60);
    }

    public static final void proveedor(JTable tabla) {
        modeloProveedor = new DefaultTableModel(datosProveedor, provedores);
        tabla.setModel(modeloProveedor);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(190);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(150);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(270);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(270);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }

    public static final void vendedor(JTable tabla) {
        modeloVendedor = new DefaultTableModel(datosVendedor, vendedores) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloVendedor);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(250);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(80);
        //colum.setMaxWidth(0);
        //colum.setMinWidth(0);
        //colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(70);
        //colum.setMaxWidth(0);
        //colum.setMinWidth(0);
        //colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(250);
        /*colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);*/
    }

    public static final void cliente(JTable tabla) {
        modeloCliente = new DefaultTableModel(datosCliente, clientes) {
            boolean[] canEdit = new boolean[]{
                false, true, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modeloCliente);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(100);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(7);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(8);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(9);
        colum.setPreferredWidth(130);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(10);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(11);
        colum.setPreferredWidth(200);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
    }
}
