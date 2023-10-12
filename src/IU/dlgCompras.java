package IU;

import Componentes.DataSourceService;
import Componentes.DecimalFormatRenderer;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.ReporteF;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Controladores.controlCompra;
import Datos.GestionarCompra;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import Modelo.Articulo;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class dlgCompras extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    public static int PrecioVenta;
    public static double costoiva;
    public static int descuento;
    public static int ganancia;
    public static Articulo ar;
    public static int Pcosto;
    public ReporteF jasper;
    static DataSourceService dss = new DataSourceService();

    public dlgCompras(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        titulo();
        jasper = new ReporteF();
        cabe.compras(tbDetalle);
        Cancelar();
        pintarCondicion();
        Renders();
        Invisible();

    }

    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_F6 ->
                btnGuardar.doClick();
            case KeyEvent.VK_ESCAPE ->
                btnCancelar.doClick();
            case KeyEvent.VK_DELETE ->
                btnRestar.doClick();
            case KeyEvent.VK_F9 ->
                btnBuscarArticulo.doClick();
            case KeyEvent.VK_F3 ->
                btnProveedor.doClick();
            default -> {
            }
        }
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Registrar compras de proveedores");
        } else {
            this.setTitle(Software.getSoftware() + " - Registrar compras de proveedores");
        }
    }

    public void Cancelar() {
        limpiarCampos();
        dcFecha.setEnabled(false);
        txtFactura.setEnabled(false);
        btnProveedor.setEnabled(false);
        rContado.setEnabled(false);
        rCredito.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCosto.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnHistorial.setEnabled(false);
        cant();
    }

    public void Renders() {
        dlgCompras.tbDetalle.getColumnModel().getColumn(3).setCellRenderer(new DecimalFormatRenderer());
        dlgCompras.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new DecimalFormatRenderer());
        dlgCompras.tbDetalle.getColumnModel().getColumn(8).setCellRenderer(new DecimalFormatRenderer());
        dlgCompras.tbDetalle.getColumnModel().getColumn(10).setCellRenderer(new DecimalFormatRenderer());
        dlgCompras.tbDetalle.getColumnModel().getColumn(12).setCellRenderer(new DecimalFormatRenderer());
        dlgCompras.tbDetalle.getColumnModel().getColumn(14).setCellRenderer(new DecimalFormatRenderer());
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCond.setVisible(false);
        txtCodProv.setVisible(false);
        txtCodA.setVisible(false);
        btnCantidad.setVisible(false);
        btnPrecio.setVisible(false);
    }

    public void cant() {
        int total = tbDetalle.getRowCount();
        etiCant.setText("ITEM A REGISTRAR: " + String.valueOf(total));
    }

    private void pintarCondicion() {
        if (rContado.isSelected()) {
            rContado.setFont(new java.awt.Font("Tahoma", 1, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 51));
            rCredito.setFont(new java.awt.Font("Tahoma", 0, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 0));
            lbCond.setText("CONTADO");
        } else {
            rContado.setFont(new java.awt.Font("Tahoma", 0, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 0));
            rCredito.setFont(new java.awt.Font("Tahoma", 1, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 51));
            lbCond.setText("CREDITO");
        }
    }

    private void limpiarCampos() {
        txtCod.setText("");
        txtFecha.setText("");
        txtCaja.setText("");
        txtFactura.setText("");
        txtCodProv.setText("");
        txtRuc.setText("");
        txtRazonS.setText("");
        rContado.isSelected();
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtCosto.setText("");
        txtExenta.setText("0");
        txt5.setText("0");
        txt10.setText("0");
        lbCond.setText("");
        lbtotal.setText("");
        rContado.setSelected(true);
        controlCompra.array.vaciar();
        cabe.compras(tbDetalle);
        CabecerasTablas.limpiarTablas(tbDetalle);

    }

    public static void habilitarCANTCOSTO() {
        if (txtArt.getText().isEmpty()) {
            txtCant.setEnabled(false);
            txtCosto.setEnabled(false);
            btnHistorial.setEnabled(false);
        } else {
            txtCant.setEnabled(true);
            txtCosto.setEnabled(true);
            btnHistorial.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menuEmergente = new javax.swing.JPopupMenu();
        itmCantidad = new javax.swing.JMenuItem();
        itmPrecio = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itmHistorial = new javax.swing.JMenuItem();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel20 = new javax.swing.JPanel();
        PnlNuevo2 = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador9 = new javax.swing.JSeparator();
        LabelTitulo9 = new javax.swing.JLabel();
        PnlGuardar1 = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador11 = new javax.swing.JSeparator();
        LabelTitulo11 = new javax.swing.JLabel();
        PnlCancelar1 = new rojeru_san.rspanel.RSPanelImage();
        btnCancelar = new RSMaterialComponent.RSButtonIconUno();
        Separador12 = new javax.swing.JSeparator();
        LabelTitulo12 = new javax.swing.JLabel();
        btnCantidad = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        lbCond = new javax.swing.JLabel();
        btnPrecio = new javax.swing.JButton();
        txtCodA = new javax.swing.JTextField();
        txtCodProv = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel12 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtRazonS = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        rContado = new javax.swing.JRadioButton();
        rCredito = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtTotal = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtArt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        txtCant = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnBuscarArticulo = new rojeru_san.rsbutton.RSButtonGradiente();
        lbtotal = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        etiCant = new javax.swing.JLabel();

        itmCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itmCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        itmCantidad.setText("Modificar Cantidad");
        itmCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCantidadActionPerformed(evt);
            }
        });
        menuEmergente.add(itmCantidad);

        itmPrecio.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itmPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        itmPrecio.setText("Modificar Costo");
        itmPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmPrecioActionPerformed(evt);
            }
        });
        menuEmergente.add(itmPrecio);
        menuEmergente.add(jSeparator2);

        itmHistorial.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itmHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itmHistorial.setText("Consultar Historial de Compra");
        itmHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmHistorialActionPerformed(evt);
            }
        });
        menuEmergente.add(itmHistorial);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(14, 35, 46));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setToolTipText("ALT+F4");
        btnSalir.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setRippleColor(java.awt.Color.white);
        btnSalir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        jPanel10.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 3, 20, 20));

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 102, 0));
        btnNuevo.setToolTipText("F1");
        btnNuevo.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnNuevo.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setRippleColor(java.awt.Color.white);
        btnNuevo.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        PnlNuevo2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador9.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo2.add(Separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo9.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo9.setText("NUEVO");
        PnlNuevo2.add(LabelTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel20.add(PnlNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlGuardar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setToolTipText("F6");
        btnGuardar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRippleColor(java.awt.Color.white);
        btnGuardar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        PnlGuardar1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador11.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar1.add(Separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo11.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo11.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo11.setText("REGISTRAR");
        PnlGuardar1.add(LabelTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel20.add(PnlGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlCancelar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlCancelar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setToolTipText("ESCAPE");
        btnCancelar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCancelar.setForegroundHover(new java.awt.Color(153, 0, 51));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setRippleColor(java.awt.Color.white);
        btnCancelar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        PnlCancelar1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador12.setForeground(new java.awt.Color(204, 204, 204));
        PnlCancelar1.add(Separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo12.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo12.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo12.setText("CANCELAR");
        PnlCancelar1.add(LabelTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel20.add(PnlCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        jPanel10.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 110));

        btnCantidad.setText("Act. Cant");
        btnCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadActionPerformed(evt);
            }
        });
        jPanel10.add(btnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 89, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel10.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        jPanel10.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 65, -1));

        lbCond.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCond.setForeground(new java.awt.Color(255, 255, 255));
        lbCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel10.add(lbCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 81, 25));

        btnPrecio.setText("Act. Precio");
        btnPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecioActionPerformed(evt);
            }
        });
        jPanel10.add(btnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 89, -1));
        jPanel10.add(txtCodA, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 63, -1));

        txtCodProv.setEditable(false);
        txtCodProv.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtCodProv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(txtCodProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 60, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 977, 102));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Operación N°");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 40, 78, 23));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
        });
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 40, 128, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 70, 78, 23));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaKeyPressed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 70, 105, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("COMPROBANTE N°");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, 110, 23));

        txtFactura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });
        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaKeyTyped(evt);
            }
        });
        jPanel1.add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 10, 150, 23));

        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });
        jPanel1.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 69, 25, 25));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("Mov. Caja N°");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, 78, 23));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCajaActionPerformed(evt);
            }
        });
        txtCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCajaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCajaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 10, 128, 23));

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRazonS.setEditable(false);
        txtRazonS.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSKeyPressed(evt);
            }
        });
        jPanel5.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 7, 310, 23));

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
        });
        jPanel5.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 7, 95, 23));

        btnProveedor.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(213, 51, 0));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        btnProveedor.setText("F3-Proveedores");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.setFocusPainted(false);
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        btnProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProveedorKeyPressed(evt);
            }
        });
        jPanel5.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 7, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 550, 37));

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rContado);
        rContado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rContado.setSelected(true);
        rContado.setText("CONTADO");
        rContado.setOpaque(false);
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });
        rContado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rContadoKeyPressed(evt);
            }
        });
        jPanel6.add(rContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 83, 14));

        buttonGroup1.add(rCredito);
        rCredito.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rCredito.setText("CREDITO");
        rCredito.setOpaque(false);
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });
        rCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rCreditoKeyPressed(evt);
            }
        });
        jPanel6.add(rCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 83, 13));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 40, 100, 50));

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 105, 560, 145));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COMPRA TOTAL");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 6, 374, 23));

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtTotal.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel7.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 35, 374, 30));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXENTA");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 86, -1));

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExenta.setText("0");
        txtExenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtExenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExentaKeyPressed(evt);
            }
        });
        jPanel8.add(txtExenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 22, 86, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 7, 86, -1));

        txt5.setEditable(false);
        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setText("0");
        txt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt5KeyPressed(evt);
            }
        });
        jPanel8.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 22, 86, 20));

        txt10.setEditable(false);
        txt10.setBackground(new java.awt.Color(255, 255, 255));
        txt10.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10.setText("0");
        txt10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt10KeyPressed(evt);
            }
        });
        jPanel8.add(txt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 22, 86, 20));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 7, 86, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 85, 300, 50));

        jPanel9.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 105, 400, 145));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtArt.setEditable(false);
        txtArt.setBackground(new java.awt.Color(255, 255, 255));
        txtArt.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtArt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtArt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtActionPerformed(evt);
            }
        });
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArtKeyReleased(evt);
            }
        });
        jPanel2.add(txtArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 34, 492, 23));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(20);
        tbDetalle.setShowGrid(true);
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        tbDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDetalleMousePressed(evt);
            }
        });
        tbDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 65, 977, 315));

        txtCant.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantMouseClicked(evt);
            }
        });
        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantKeyPressed(evt);
            }
        });
        jPanel2.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 34, 40, 23));

        txtCosto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
        });
        jPanel2.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 34, 80, 23));

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CANT");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 20, 40, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("COSTO");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 80, -1));

        btnBuscarArticulo.setText("CARGAR ARTICULOS - F9");
        btnBuscarArticulo.setToolTipText("F9");
        btnBuscarArticulo.setColorPrimario(new java.awt.Color(255, 102, 0));
        btnBuscarArticulo.setColorPrimarioHover(new java.awt.Color(255, 137, 2));
        btnBuscarArticulo.setColorSecundario(new java.awt.Color(255, 137, 2));
        btnBuscarArticulo.setColorSecundarioHover(new java.awt.Color(255, 102, 0));
        btnBuscarArticulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });
        btnBuscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarArticuloKeyPressed(evt);
            }
        });
        jPanel2.add(btnBuscarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 180, 23));

        lbtotal.setBackground(new java.awt.Color(255, 102, 0));
        lbtotal.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbtotal.setForeground(new java.awt.Color(255, 255, 255));
        lbtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtotal.setOpaque(true);
        lbtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbtotalKeyPressed(evt);
            }
        });
        jPanel2.add(lbtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 34, 310, 23));

        btnHistorial.setBackground(new java.awt.Color(255, 255, 255));
        btnHistorial.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(0, 153, 204));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        btnHistorial.setBorderPainted(false);
        btnHistorial.setFocusPainted(false);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        btnHistorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnHistorialKeyPressed(evt);
            }
        });
        jPanel2.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 34, 23, 23));

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 250, 977, 380));

        etiCant.setBackground(new java.awt.Color(17, 35, 46));
        etiCant.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        etiCant.setForeground(new java.awt.Color(255, 255, 255));
        etiCant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiCant.setText("Artículos registrados:");
        etiCant.setOpaque(true);
        jPanel9.add(etiCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 632, 977, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlCompra.addTabla(tbDetalle, txtCodA.getText());
        cant();
        txtArt.setText("");
        txtCant.setText("");
        txtCosto.setText("");
        txtCodA.setText("");
        lbtotal.setText("");
        habilitarCANTCOSTO();
        btnBuscarArticuloActionPerformed(null);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlCompra.delRenglon(tbDetalle);
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCant);
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCantKeyPressed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarProveedor dbp = new dlgBuscarProveedor(null, true);
            dbp.setLocationRelativeTo(null);
            dbp.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }

    }//GEN-LAST:event_btnProveedorActionPerformed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        txtFecha.setText(Fecha.formatoFecha(dcFecha.getText()));
    }//GEN-LAST:event_dcFechaOnCommit

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        // TODO add your handling code here:
        pintarCondicion();
    }//GEN-LAST:event_rCreditoActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
        if (txtCosto.getText().isEmpty()) {
            txtCosto.requestFocus();
        } else if (txtCosto.getText().equals("0")) {
            txtCosto.requestFocus();
        } else {
            int cant = Integer.parseInt(txtCant.getText());
            int costo = Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""));
            int total = (int) (cant * costo);
            DecimalFormat df = new DecimalFormat("#,###");
            lbtotal.setText("Total: " + df.format(total));
            lbtotal.requestFocus();
            //btnAddActionPerformed(null);
        }
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
        if (txtCant.getText().isEmpty()) {
            txtCant.requestFocus();
        } else if (txtCant.getText().equals("0")) {
            txtCant.requestFocus();
        } else {
            int cant = Integer.parseInt(txtCant.getText());
            int costo = Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""));
            int total = (int) (cant * costo);
            DecimalFormat df = new DecimalFormat("#,###");
            lbtotal.setText("Total: " + df.format(total));
            txtCosto.requestFocus();
        }


    }//GEN-LAST:event_txtCantActionPerformed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCosto);
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            txtCosto.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
        } catch (NumberFormatException e) {
        }

    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtActionPerformed

    private void txtArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtFacturaKeyPressed

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        int limite = 15;
        if (txtFactura.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFacturaKeyTyped

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
        if (txtFactura.getText().isEmpty()) {
            txtFactura.requestFocus();
            txtFactura.selectAll();
        } else {
            String sql = "SELECT * FROM compra WHERE com_factura='" + txtFactura.getText() + "' AND proveedor_pro_codigo=" + txtCodProv.getText() + " AND com_indicador='S'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                if (rs.next()) {
                    Mensajes.informacion("Esta compra ya fue registrada");
                } else {
                    btnBuscarArticulo.doClick();
                }
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void txtCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaActionPerformed

    private void txtCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCajaKeyPressed

    private void txtCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCajaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajaKeyTyped

    private void txtCantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantMouseClicked
        // TODO add your handling code here:
        txtCant.selectAll();
    }//GEN-LAST:event_txtCantMouseClicked

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
        // TODO add your handling code here:
        txtCosto.selectAll();
    }//GEN-LAST:event_txtCostoMouseClicked

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        if (!txtCodA.getText().isEmpty()) {
            int cod = Integer.parseInt(txtCodA.getText());
            try {
                jasper.Historial_de_compras("\\Reports\\compras\\comprasxart.jasper", "art", cod);
                txtCosto.requestFocus();
            } catch (Exception e) {
                Mensajes.informacion("Artículo sin Historial de Compras");
                txtCosto.requestFocus();
            }
        }

    }//GEN-LAST:event_btnHistorialActionPerformed

    private void lbtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbtotalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnAddActionPerformed(null);
        }
    }//GEN-LAST:event_lbtotalKeyPressed

    private void btnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlCompra.actCantidad(tbDetalle);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnCantidadActionPerformed

    private void btnPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecioActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlCompra.actPrecio(tbDetalle);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnPrecioActionPerformed

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleMousePressed

    private void itmCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCantidadActionPerformed
        // TODO add your handling code here:
        btnCantidadActionPerformed(null);
    }//GEN-LAST:event_itmCantidadActionPerformed

    private void itmPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmPrecioActionPerformed
        // TODO add your handling code here:
        btnPrecioActionPerformed(null);
    }//GEN-LAST:event_itmPrecioActionPerformed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            if (evt.getClickCount() == 2) {
                menuEmergente.show(tbDetalle, evt.getX(), evt.getY());
            }

        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void itmHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmHistorialActionPerformed
        // TODO add your handling code here:
        int fila = tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(tbDetalle.getValueAt(fila, 0).toString());
        //int cod = Integer.parseInt(txtCodA.getText());
        try {
            jasper.Historial_de_compras("\\Reports\\compras\\comprasxart.jasper", "art", cod);
        } catch (Exception e) {
            Mensajes.informacion("Artículo sin Historial de Compras");
            txtCosto.requestFocus();
        }
    }//GEN-LAST:event_itmHistorialActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarCompra.getCodigo();
        txtCod.setText(cod);
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.ObtenerCodigo("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pintarCondicion();
        txtFecha.setText(Fecha.fechaCorrecta());
        //txtFecha.setEnabled(true);
        dcFecha.setEnabled(true);
        txtFactura.setEnabled(true);
        btnProveedor.setEnabled(true);
        btnProveedor.doClick();
        rContado.setEnabled(true);
        rCredito.setEnabled(true);
        btnBuscarArticulo.setEnabled(true);
        txtCosto.setEnabled(true);
        txtCant.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        habilitarCANTCOSTO();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String cod = GestionarCompra.getCodigo();
        txtCod.setText(cod);
        if (txtFecha.getText().isEmpty()) {
            Mensajes.error("Seleccione una Fecha");
            txtFecha.requestFocus();
        } else if (txtFactura.getText().isEmpty()) {
            Mensajes.error("Ingrese la Factura de Compra");
            txtFactura.requestFocus();
        } else if (txtCodProv.getText().isEmpty()) {
            Mensajes.error("Seleccione el Proveedor");
            btnProveedor.doClick();
        } else if (tbDetalle.getRowCount() <= 0) {
            Mensajes.error("El detalle de la compra esta vacia");
            btnBuscarArticulo.doClick();
        } else {
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement()) {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    try {
                        cn.setAutoCommit(false);
                        String sql = "insert into compra values(" + txtCod.getText() + "," + txtCaja.getText() + "," + txtCodProv.getText() + ",'" + lbCond.getText() + "','" + txtFactura.getText() + "','"
                                + txtFecha.getText() + "','" + Fecha.darHora() + "'," + txtTotal.getText().replace(".", "").replace(",", "") + "," + txtExenta.getText().replace(".", "").replace(",", "") + "," + txt5.getText().replace(".", "").replace(",", "") + "," + txt10.getText().replace(".", "").replace(",", "") + ",'S','" + Login.getUsuarioLogueado() + "')";
                        st.executeUpdate(sql);
                        int fila = tbDetalle.getRowCount();
                        for (int j = 0; j < fila; j++) {
                            String filas[] = {tbDetalle.getValueAt(j, 0).toString(), tbDetalle.getValueAt(j, 4).toString(), tbDetalle.getValueAt(j, 6).toString(), tbDetalle.getValueAt(j, 15).toString(), tbDetalle.getValueAt(j, 16).toString(), tbDetalle.getValueAt(j, 17).toString(), tbDetalle.getValueAt(j, 18).toString(), tbDetalle.getValueAt(j, 7).toString()};
                            sql = "insert into detalle_compra values(" + txtCod.getText() + "," + filas[0] + "," + filas[1] + "," + filas[2] + "," + filas[3] + "," + filas[7] + ")";
                            String sql2 = "UPDATE articulo SET art_costo=" + filas[2] + ", art_costoiva=" + filas[4] + ", art_stock=art_stock+" + filas[1] + ", art_ganancia=" + filas[5] + ", art_descuento=" + filas[6] + " WHERE  art_codigo=" + filas[0];
                            st.executeUpdate(sql);
                            st.executeUpdate(sql2);
                        }
                        cn.commit();
                        st.close();
                        cn.close();
                        Mensajes.Sistema("LA COMPRA HA SIDO REGISTRADA EXITOSAMENTE");
                    } catch (SQLException e) {
                        try {
                            cn.rollback();
                            st.close();
                            cn.close();
                            Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage().toUpperCase());
                        } catch (SQLException se) {
                            Mensajes.error(se.getMessage());
                        }
                    }
                    Cancelar();
                    cant();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlCompra.canCelar();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloCompra bac = new dlgBuscarArticuloCompra(null, true);
            //bac.setLocationRelativeTo(null);
            bac.setLocation(230, 250);
            bac.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void btnBuscarArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticuloKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnBuscarArticuloKeyPressed

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtFechaKeyPressed

    private void rContadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rContadoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rContadoKeyPressed

    private void rCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rCreditoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_rCreditoKeyPressed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtRucKeyPressed

    private void btnProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProveedorKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnProveedorKeyPressed

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void txtExentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExentaKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtExentaKeyPressed

    private void txt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txt5KeyPressed

    private void txt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt10KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txt10KeyPressed

    private void txtArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtArtKeyPressed

    private void btnHistorialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHistorialKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnHistorialKeyPressed

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
       AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbDetalleKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgCompras dialog = new dlgCompras(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgCompras.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo11;
    private javax.swing.JLabel LabelTitulo12;
    private javax.swing.JLabel LabelTitulo9;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar1;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar1;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo2;
    private javax.swing.JSeparator Separador11;
    private javax.swing.JSeparator Separador12;
    private javax.swing.JSeparator Separador9;
    private javax.swing.JButton btnAdd;
    private rojeru_san.rsbutton.RSButtonGradiente btnBuscarArticulo;
    public static RSMaterialComponent.RSButtonIconUno btnCancelar;
    private javax.swing.JButton btnCantidad;
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    public static javax.swing.JButton btnHistorial;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    private javax.swing.JButton btnPrecio;
    public static javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRestar;
    public static RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    public static datechooser.beans.DateChooserCombo dcFecha;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itmCantidad;
    private javax.swing.JMenuItem itmHistorial;
    private javax.swing.JMenuItem itmPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JLabel lbCond;
    private javax.swing.JLabel lbtotal;
    private javax.swing.JPopupMenu menuEmergente;
    public static javax.swing.JRadioButton rContado;
    private javax.swing.JRadioButton rCredito;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt5;
    public static javax.swing.JTextField txtArt;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCodA;
    public static javax.swing.JTextField txtCodProv;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtFactura;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
