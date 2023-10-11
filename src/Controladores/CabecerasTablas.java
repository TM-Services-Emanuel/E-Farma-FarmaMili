package Controladores;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CabecerasTablas {

    private static final String puntoEmision[] = {"ID", "IDT", "TIMBRADO", "EST.", "P.E.", "DIRECCIÓN", "F.INICIO", "F.FIN", "F.ACTUAL", "TIPO", "DIR. IP", "ESTADO", "IMPRESORA PREDETERMINADA"};
    private static final String timbrado[] = {"ID", "TIMBRADO", "DESDE", "HASTA", "ESTADO"};
    String articulos[] = {"CODIGO", "CODBARRA", "FAMILIA", "LABORATORIO", "PROVEEDOR", "NOMBRE COMERCIAL", "PRINCIPIO ACTIVO", "ACCION TERAPEUTICA",
        "STOCK", "ST.MIN", "COSTO", "IVA", "COST.IVA", "P.PUBLICO", "% DESC", "P.VENTA", "% FLIA", "% LUCRO", "VENTA", "ACT"};
    String familia[] = {"ID", "FAMILIA", "%", "I.V.A."};
    String laboratorio[] = {"ID", "LABORATORIO"};
    String empresa[] = {"ID", "RAZÓN SOCIAL", "R.U.C.", "DIRECCIÓN", "TELÉFONO", "CELULAR", "ACTIVO"};
    String vendedores[] = {"ID", "NOMBRE Y APELLIDO", "DIRECCIÓN", "TELÉFONO", "CELULAR", "SUELDO", "% COM", "OBSERVACIÓN"};
    String clientes[] = {"ID", "NOMBRE Y APELLIDO | RAZÓN SOCIAL", "C.I. | R.U.C.", "TELÉFONO", "CONTACTO", "CELULAR", "VTA.CONT.", "VTA.CRED.", "LMTE.CTA.", "CIUDAD", "DIRECCIÓN", "OBSERVACIÓN"};
    String provedores[] = {"ID", "RAZÓN SOCIAL", "R.U.C.", "TELÉFONO", "CONTACTO", "CELULAR", "CIUDAD", "DIRECCIÓN", "OBSERVACIÓN"};
    String tablaStock[] = {"Código", "Marca", "Descripción", "Stock"};
    String tablaAuxiliarArticulo[] = {"Codigo", "Rubro", "Descripcion", "Marca", "Precio"};
    String ciudad[] = {"ID", "CIUDAD"};
    String sucursal[] = {"ID", "DESCRIPCIÓN SUCURSAL", " ", "MI_SUC", "ID_EMP", "DE LA EMPRESA", "IP SERVIDOR"};
    String zona[] = {"CODIGO", "ZONA"};
    String detalleGasto[] = {"ID", "DESCRIPCIÓN"};
    String motivo[] = {"ID", "MOTIVOS"};
    String salidas[] = {"CODART", "NOMBRE COMERCIAL", "CODMOTIVO", "MOTIVO SALIDA", "CANT", "COSTO", "MONTO"};
    String conSalidas[] = {"OP. N°", "PROVEEDOR", "FECHA", "HORA", "COS.TOTAL", "OBSERVACION", "INDICADOR"};
    String detalleSalida[] = {"CODART", "MOTIVO SALIDA", "CANT", "OP. N°", "NOMBRE COMERCIAL", "COSTO", "MONTO"};
    String compras[] = {"COD", "CODBARRA", "NOMBRE COMERCIAL", "CANT", "CANTf", "PRECIO ", "PRECIOF", "IVA", "EXENTA", "EXENTAf", "IVA 5%", "IVA5f", "IVA 10%", "IVA10f", "MONTO", "MONTOf", "PC", "GA", "DE"};
    private static final String facturas[] = {"COD", "CODBARRA", "NOMBRE COMERCIAL", "CANT", "P.PUBL.", "%DES", "PRECIO", "EXENTA", "IVA 5%", "IVA 10%", "SUB-TOTAL", "DESC", "PPtot"};
    private static final String transferencias[] = {"COD", "CODBARRA", "NOMBRE COMERCIAL", "CANT", "PRECIO", "EXENTA", "IVA 5%", "IVA 10%", "SUB-TOTAL","GANANCIA","DESCUENTO","ORDEN","COSTOIVA"};
    String categoria[] = {"CODIGO", "CATEGORIA"};
    //String factura[] = {"Cant.", "Cod.", "Descripción", "Precio", "Total", "sActual"};
    String presupuestos[] = {"Cant.", "Cod.", "Descripción", "Precio", "Total"};
    String conFactura[] = {"OPERACIÓN", "RAZÓN SOCIAL", "FECHA", "HORA", "COD CLI", "MOV.CAJA", "FACTURA N°", "CONDICION", "PAGO", "TOTAL", "CODVENDE", "ESTADO"};
    String conTransferencia[] = {"ID","OPERACIÓN", "MOV.CAJA", "FECHA HORA", "TIPO", "ORIGEN", "DESTINO", "TOTAL", "ESTADO"};
    String detalleFactura[] = {"CANT", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "PRECIO", "SUB-TOTAL"};
    String detalleTransferencia[] = {"CANT", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "PRECIO", "SUB-TOTAL"};
    String consPresupuesto[] = {"N°", "Fecha", "Razon Social", "Cód. Clie", "Desc", "Total"};
    String detallePresupuestoF[] = {"Cant.", "Código", "Descripción", "Precio", "Total"};
    String busEmpleado[] = {"Cód", "Empleado", "Observación"};
    String consNotaCredito[] = {"N°", "Fecha", "Razon Social", "Cod. Clie", "Total", "Desc", "Fac"};
    String detalleNotaCredito[] = {"Cant.", "Cód", "Descripción", "Precio", "Total"};
    String usuario[] = {"ID", "PERFIL ASIG.", "EMPLEADO", "USUARIO", "PASSWORD", "INDICADOR", "IP", "CODPERFIL", "CODVENDE"};
    String comisiones[] = {"FECHA", "FACT.", "CLIENTE", "TOTAL", "%COM.", "COMISION"};
    String consCompras[] = {"OPER. N°", "MOV.CAJ.N°", "FECHA", "HORA", "R.U.C.", "PROVEEDOR", "CONDICIÓN", "FACTURA N°", "Cod. Prov", "TOTAL", "ESTADO"};
    String consDetalleCompras[] = {"OPER. N°", "ID", "CÓD. BARRA", "NOMBRE COMERCIAL", "CANT", "COSTO", "MONTO"};
    static String datos[][] = {};
    static String datosPE[][] = {};
    private static DefaultTableModel modelo;
    private static DefaultTableModel modeloPE;
    private static DefaultTableModel modeloT;
    private static DefaultTableModel modeloVenta;
    private static DefaultTableModel modeloTransferencia;
    private static TableColumn colum = null;

    public static void limpiarTablas(JTable tabla) {
        tabla.setModel(modelo);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }

    public static void limpiarTablasPE(JTable tabla) {
        tabla.setModel(modeloPE);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloPE.removeRow(0);
        }
    }

    public static void limpiarTablasT(JTable tabla) {
        tabla.setModel(modeloT);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloT.removeRow(0);
        }
    }

    public static void limpiarTablasVentas(JTable tabla) {
        tabla.setModel(modeloVenta);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVenta.removeRow(0);
        }
    }
    
    public static void limpiarTablasTransferencias(JTable tabla) {
        tabla.setModel(modeloTransferencia);
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTransferencia.removeRow(0);
        }
    }

    public void Timbrado(JTable tabla) {
        modeloT = new DefaultTableModel(datos, timbrado);
        tabla.setModel(modeloT);
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

    public void PuntoEmision(JTable tabla) {
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

    public void consCompras(JTable tabla) {
        modelo = new DefaultTableModel(datos, consCompras);
        tabla.setModel(modelo);
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

    public void consDetalleCompras(JTable tabla) {
        modelo = new DefaultTableModel(datos, consDetalleCompras);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(70);
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

    public void usuario(JTable tabla) {
        modelo = new DefaultTableModel(datos, usuario);
        tabla.setModel(modelo);
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

    public void comision(JTable tabla) {
        modelo = new DefaultTableModel(datos, comisiones);
        tabla.setModel(modelo);
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

    public void busEmpleado(JTable tabla) {
        modelo = new DefaultTableModel(datos, busEmpleado);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(200);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(200);
    }

    public void consNotaCredito(JTable tabla) {
        modelo = new DefaultTableModel(datos, consNotaCredito);
        tabla.setModel(modelo);
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

    public void detalleNotasCredito(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleNotaCredito);
        tabla.setModel(modelo);
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

    public void consFacturasNotas(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
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

    public void detallePresupuesto(JTable tabla) {
        modelo = new DefaultTableModel(datos, detallePresupuestoF);
        tabla.setModel(modelo);
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

    public void consPresupuesto(JTable tabla) {
        modelo = new DefaultTableModel(datos, consPresupuesto);
        tabla.setModel(modelo);
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

    public void consFacturas(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
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
    }
    
    public void consTransferencias(JTable tabla) {
        modelo = new DefaultTableModel(datos, conTransferencia);
        tabla.setModel(modelo);
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

    public void consFacturasCreditos(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
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

    public void consFacturasA(JTable tabla) {
        modelo = new DefaultTableModel(datos, conFactura);
        tabla.setModel(modelo);
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

    public void detalleFactura(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleFactura);
        tabla.setModel(modelo);
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
    
    public void detalleTransferencia(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleTransferencia);
        tabla.setModel(modelo);
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

    public void detalleFacturaA(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleFactura);
        tabla.setModel(modelo);
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

    public void presupuesto(JTable tabla) {
        modelo = new DefaultTableModel(datos, presupuestos);
        tabla.setModel(modelo);
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

    public void factura(JTable tabla) {
        modelo = new DefaultTableModel(datos, facturas);
        tabla.setModel(modelo);
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

    public void buscarCliente(JTable tabla) {
        modelo = new DefaultTableModel(datos, clientes);
        tabla.setModel(modelo);
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

    public void categoria(JTable tabla) {
        modelo = new DefaultTableModel(datos, categoria);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(50);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(150);
    }

    public void busProveedor(JTable tabla) {
        modelo = new DefaultTableModel(datos, provedores);
        tabla.setModel(modelo);
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
        modeloVenta = new DefaultTableModel(datos, facturas);
        tabla.setModel(modeloVenta);
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
        modeloTransferencia = new DefaultTableModel(datos, transferencias);
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

    public void compras(JTable tabla) {
        modelo = new DefaultTableModel(datos, compras);
        tabla.setModel(modelo);
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

    public void detalleSalidas(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleSalida);
        tabla.setModel(modelo);
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

    public void consultaSalidas(JTable tabla) {
        modelo = new DefaultTableModel(datos, conSalidas);
        tabla.setModel(modelo);
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

    public void tablaArticuloAuxiliar(JTable tabla) {
        modelo = new DefaultTableModel(datos, articulos){
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelo);
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
        /*colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);*/
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(70);
        //colum.setMaxWidth(0);
        //colum.setMinWidth(0);
        //colum.setPreferredWidth(0);
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
    
    public void tablaArticuloAuxiliarTransferencia(JTable tabla) {
        modelo = new DefaultTableModel(datos, articulos){
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelo);
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
        colum.setPreferredWidth(520);
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

    public void salidas(JTable tabla) {
        modelo = new DefaultTableModel(datos, salidas);
        tabla.setModel(modelo);
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

    public void motivo(JTable tabla) {
        modelo = new DefaultTableModel(datos, motivo);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(390);
    }

    public void ciudad(JTable tabla) {
        modelo = new DefaultTableModel(datos, ciudad);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(390);
    }

    public void sucursal(JTable tabla) {
        modelo = new DefaultTableModel(datos, sucursal);
        tabla.setModel(modelo);
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
    public void detalleGasto(JTable tabla) {
        modelo = new DefaultTableModel(datos, detalleGasto);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(380);
    }

    public void ajusteStock(JTable tabla) {
        modelo = new DefaultTableModel(datos, articulos);
        tabla.setModel(modelo);
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

    public void Articulos(JTable tabla) {
        modelo = new DefaultTableModel(datos, articulos);
        tabla.setModel(modelo);
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
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(13);
        colum.setPreferredWidth(70);
        colum = tabla.getColumnModel().getColumn(14);
        colum.setPreferredWidth(60);
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

    public void familia(JTable tabla) {
        modelo = new DefaultTableModel(datos, familia);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(65);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(230);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(80);
    }

    public void laboratorio(JTable tabla) {
        modelo = new DefaultTableModel(datos, laboratorio);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(80);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(350);
    }

    public void empresa(JTable tabla) {
        modelo = new DefaultTableModel(datos, empresa);
        tabla.setModel(modelo);
        colum = tabla.getColumnModel().getColumn(0);
        colum.setPreferredWidth(60);
        colum.setMaxWidth(0);
        colum.setMinWidth(0);
        colum.setPreferredWidth(0);
        colum = tabla.getColumnModel().getColumn(1);
        colum.setPreferredWidth(180);
        colum = tabla.getColumnModel().getColumn(2);
        colum.setPreferredWidth(85);
        colum = tabla.getColumnModel().getColumn(3);
        colum.setPreferredWidth(260);
        colum = tabla.getColumnModel().getColumn(4);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(5);
        colum.setPreferredWidth(90);
        colum = tabla.getColumnModel().getColumn(6);
        colum.setPreferredWidth(60);
    }

    public void proveedor(JTable tabla) {
        modelo = new DefaultTableModel(datos, provedores);
        tabla.setModel(modelo);
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

    public void vendedor(JTable tabla) {
        modelo = new DefaultTableModel(datos, vendedores) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelo);
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

    public void cliente(JTable tabla) {
        modelo = new DefaultTableModel(datos, clientes) {
            boolean[] canEdit = new boolean[]{
                false, true, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tabla.setModel(modelo);
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
