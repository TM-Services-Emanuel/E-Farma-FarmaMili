package IU;

import Componentes.Empresa;
import Componentes.Fecha;
import Componentes.ReporteF;
import Componentes.Mensajes;
import Componentes.Reloj;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.traerIP;
import Controladores.ControlLogeo;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class frmPrincipal extends javax.swing.JFrame {

    public ReporteF jasper;

    public frmPrincipal() throws SQLException {
        ControlLogeo.Empresa();
        initComponents();
        informacionGral();
        ControlLogeo.Timbrado_Ticket();
        jasper = new ReporteF();
        this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        titulo();
        Iniciar();
        cargarIcono();
        invisible();
    }

    private void invisible() {
        mnNCProveedor.setVisible(false);
        mnPagoProveedor.setVisible(false);
        mnNCVenta.setVisible(false);
        mnGNCVenta.setVisible(false);
    }

    void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Ventana principal");
        } else {
            this.setTitle("Ventana principal del sistema " + Software.getSoftware() + " - " + Software.getDescripcion());
        }
        if (Software.getVersion().equals("null")) {
            lbversion.setText("Versión del Software: No disponible");
        } else {
            lbversion.setText("Versión del Software: " + Software.getVersion() + Fecha.soloAnho() + " - TM•SERVICES, Todos los derechos reservados.");
        }
    }

    private void Iniciar() {
        Reloj hilo = new Reloj(lblFecha);
        hilo.start();
    }

    void ubicacion() {
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(ancho, alto);
        setLocationRelativeTo(null);
    }

    /*public void informacionGral() {
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("select * from v_sucursal where em_visualizar='SI' and em_indicador='S'")) {
            rs.first();
            try {
                if (rs.getRow() != 0) {
                    lbSucursal.setText(rs.getString(2));
                    lbEmpresa.setText(rs.getString(3));
                } else {
                    System.out.println("No se puede cargar Información Gral.");
                    frmPrincipal.lbEmpresa.setText("NOMBRE FARMACIA");
                    frmPrincipal.lbSucursal.setText("NOMBRE SUCURSAL");
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    public static void informacionGral() {
        try {
            if (Empresa.getHabilitado().equals("SI")) {
                lbSucursal.setText(Empresa.getSucursal());
                lbNombreFantasia.setText(Empresa.getEmpresa());
                lbEmpresa.setText(Empresa.getRazonSocial());
                lbRUC.setText(Empresa.getRUC());
            } else if (Empresa.getHabilitado().equals("NO")) {
                lbSucursal.setText("");
                lbNombreFantasia.setText("");
                lbEmpresa.setText("");
                lbRUC.setText("");
            }
        } catch (Exception e) {
            System.out.println("Informacion Gral: " + e.getMessage());
        }
        lbDIP.setText("HOST IP : " + traerIP.getIP());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CONTENEDOR = new rojeru_san.rspanel.RSPanelImage();
        CONTENEDOR_EMPRESA = new rojeru_san.rspanel.RSPanelImage();
        encabezado_1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        iconoEmpresa = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSucursal = new javax.swing.JLabel();
        lbRUC = new javax.swing.JLabel();
        lbEmpresa = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbNombreFantasia = new javax.swing.JLabel();
        CONTENEDOR_ACCESO = new rojeru_san.rspanel.RSPanelImage();
        encabezado_2 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        btnCerrarSesion = new RSMaterialComponent.RSButtonIconUno();
        jPanel2 = new javax.swing.JPanel();
        rSPanelImage3 = new rojeru_san.rspanel.RSPanelImage();
        btnArticulos = new RSMaterialComponent.RSButtonIconUno();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        rSPanelImage1 = new rojeru_san.rspanel.RSPanelImage();
        btnClientes = new RSMaterialComponent.RSButtonIconUno();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        rSPanelImage2 = new rojeru_san.rspanel.RSPanelImage();
        btnProveedores = new RSMaterialComponent.RSButtonIconUno();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        rSPanelImage4 = new rojeru_san.rspanel.RSPanelImage();
        btnVentas = new RSMaterialComponent.RSButtonIconUno();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        rSPanelImage5 = new rojeru_san.rspanel.RSPanelImage();
        btnCompras = new RSMaterialComponent.RSButtonIconUno();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        rSPanelImage6 = new rojeru_san.rspanel.RSPanelImage();
        btnGV = new RSMaterialComponent.RSButtonIconUno();
        jSeparator32 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        rSPanelImage7 = new rojeru_san.rspanel.RSPanelImage();
        btnGFL = new RSMaterialComponent.RSButtonIconUno();
        jSeparator33 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        rSPanelImage8 = new rojeru_san.rspanel.RSPanelImage();
        btnGC = new RSMaterialComponent.RSButtonIconUno();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel13 = new javax.swing.JLabel();
        lbversion = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        jLabel15 = new javax.swing.JLabel();
        lbDIP = new javax.swing.JLabel();
        mbBarraMenu = new javax.swing.JMenuBar();
        mnSistema = new javax.swing.JMenu();
        itemFondo = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        mnModPass = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jMenuItem52 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnCerrarSistema = new javax.swing.JMenuItem();
        mnConfiguracion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnMantenimiento = new javax.swing.JMenu();
        mnInformacion = new javax.swing.JMenu();
        itemEmpresa = new javax.swing.JMenuItem();
        itemSucursal = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        mnGTimbradoM = new javax.swing.JMenuItem();
        mnGPuntoEmisionM = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemFamilia = new javax.swing.JMenuItem();
        itemLaboratorio = new javax.swing.JMenuItem();
        itemCiudades = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        Separator13 = new javax.swing.JPopupMenu.Separator();
        mnEmpleados = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnComision = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnProveedores = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnClientes = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        Separator11 = new javax.swing.JPopupMenu.Separator();
        mnSeguridad = new javax.swing.JMenu();
        smModUsuarios = new javax.swing.JMenuItem();
        smModUsuariosD = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        itemImportar = new javax.swing.JMenuItem();
        divisor3 = new javax.swing.JMenu();
        mnCaja = new javax.swing.JMenu();
        mnIniciarCaja = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        mnIngresosVarios = new javax.swing.JMenuItem();
        mnGastosVarios = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        mnCierredeCaja = new javax.swing.JMenuItem();
        divisor4 = new javax.swing.JMenu();
        mnArticulos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnCompras = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        mnNCProveedor = new javax.swing.JMenuItem();
        mnPagoProveedor = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnGC = new javax.swing.JMenuItem();
        mnVentas = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        mnNCVenta = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        TICKETS = new javax.swing.JMenu();
        mnGV = new javax.swing.JMenuItem();
        jSeparator26 = new javax.swing.JPopupMenu.Separator();
        mnGVE = new javax.swing.JMenuItem();
        jSeparator24 = new javax.swing.JPopupMenu.Separator();
        FACTURAS = new javax.swing.JMenu();
        mnGFL = new javax.swing.JMenuItem();
        jSeparator25 = new javax.swing.JPopupMenu.Separator();
        mnGVE1 = new javax.swing.JMenuItem();
        jSeparator23 = new javax.swing.JPopupMenu.Separator();
        mnGNCVenta = new javax.swing.JMenuItem();
        mnGPE = new javax.swing.JMenuItem();
        divisor5 = new javax.swing.JMenu();
        mnReportes = new javax.swing.JMenu();
        rpVentas = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        rpCompras = new javax.swing.JMenu();
        rpDevoluciones = new javax.swing.JMenu();
        rpPresupuestos = new javax.swing.JMenu();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        rpArticulos = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        rpClientes = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        rpProveedores = new javax.swing.JMenu();
        rpVendedores = new javax.swing.JMenu();
        jMenuItem48 = new javax.swing.JMenuItem();
        divisor6 = new javax.swing.JMenu();
        mnAyuda = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setResizable(false);

        panelImage1.setBackground(new java.awt.Color(102, 102, 102));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pharmacist.jpg"))); // NOI18N
        panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel1.setBackground(new java.awt.Color(210, 229, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CONTENEDOR.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco - copia.png"))); // NOI18N

        CONTENEDOR_EMPRESA.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR1.png"))); // NOI18N
        CONTENEDOR_EMPRESA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encabezado_1.setBackground(new java.awt.Color(255, 255, 255));
        encabezado_1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        encabezado_1.setForeground(new java.awt.Color(0, 153, 204));
        encabezado_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encabezado_1.setText("INFORMACIÓN DE LA EMPRESA");
        encabezado_1.setOpaque(true);
        CONTENEDOR_EMPRESA.add(encabezado_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 26, 210, 20));

        jSeparator13.setForeground(new java.awt.Color(204, 204, 204));
        CONTENEDOR_EMPRESA.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 59, 340, 4));

        iconoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_FM - copia.png"))); // NOI18N
        CONTENEDOR_EMPRESA.add(iconoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 70, -1, 90));

        jSeparator11.setForeground(new java.awt.Color(204, 204, 204));
        CONTENEDOR_EMPRESA.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 173, 340, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(17, 35, 46));
        jLabel3.setText("RAZÓN SOCIAL:");
        CONTENEDOR_EMPRESA.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 204, 105, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(17, 35, 46));
        jLabel16.setText("R.U.C.:");
        CONTENEDOR_EMPRESA.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 226, 105, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(17, 35, 46));
        jLabel6.setText("SUCURSAL:");
        CONTENEDOR_EMPRESA.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 248, 105, -1));

        lbSucursal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbSucursal.setForeground(new java.awt.Color(0, 153, 204));
        lbSucursal.setText("NOMBRE SUCURSAL");
        CONTENEDOR_EMPRESA.add(lbSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 248, 237, -1));

        lbRUC.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbRUC.setForeground(new java.awt.Color(0, 153, 204));
        lbRUC.setText("RUC FARMACIA");
        CONTENEDOR_EMPRESA.add(lbRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 226, 237, -1));

        lbEmpresa.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbEmpresa.setForeground(new java.awt.Color(0, 153, 204));
        lbEmpresa.setText("NOMBRE FARMACIA");
        CONTENEDOR_EMPRESA.add(lbEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 204, 237, -1));

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(17, 35, 46));
        jLabel24.setText("NOMBRE FANTASÍA:");
        CONTENEDOR_EMPRESA.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 182, 105, -1));

        lbNombreFantasia.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbNombreFantasia.setForeground(new java.awt.Color(0, 153, 204));
        lbNombreFantasia.setText("NOMBRE FANTASÍA");
        CONTENEDOR_EMPRESA.add(lbNombreFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 182, 237, -1));

        CONTENEDOR_ACCESO.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR1.png"))); // NOI18N

        encabezado_2.setBackground(new java.awt.Color(255, 255, 255));
        encabezado_2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        encabezado_2.setForeground(new java.awt.Color(0, 153, 204));
        encabezado_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encabezado_2.setText("ACCESO AL SISTEMA");
        encabezado_2.setOpaque(true);

        jSeparator17.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(17, 35, 46));
        jLabel2.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 35, 46));
        jLabel4.setText("USUARIO:");

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(17, 35, 46));
        jLabel7.setText("PERFIL:");

        lbPerfil.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbPerfil.setForeground(new java.awt.Color(0, 153, 204));
        lbPerfil.setText("PERFIL");

        lbUsuario.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(0, 153, 204));
        lbUsuario.setText("USUARIO");

        lblUsuario.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 153, 204));
        lblUsuario.setText("FUNCIONARIO");

        jSeparator27.setForeground(new java.awt.Color(204, 204, 204));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setToolTipText("Cerrar el Sistema");
        btnSalir.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnSalir.setForegroundHover(new java.awt.Color(255, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.POWER_SETTINGS_NEW);
        btnSalir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(17, 35, 46));
        btnCerrarSesion.setToolTipText("Cerrar Sesión");
        btnCerrarSesion.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setForegroundHover(new java.awt.Color(17, 35, 46));
        btnCerrarSesion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WRAP_TEXT);
        btnCerrarSesion.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CONTENEDOR_ACCESOLayout = new javax.swing.GroupLayout(CONTENEDOR_ACCESO);
        CONTENEDOR_ACCESO.setLayout(CONTENEDOR_ACCESOLayout);
        CONTENEDOR_ACCESOLayout.setHorizontalGroup(
            CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(encabezado_2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        CONTENEDOR_ACCESOLayout.setVerticalGroup(
            CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENEDOR_ACCESOLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(encabezado_2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lbPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(CONTENEDOR_ACCESOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CONTENEDORLayout = new javax.swing.GroupLayout(CONTENEDOR);
        CONTENEDOR.setLayout(CONTENEDORLayout);
        CONTENEDORLayout.setHorizontalGroup(
            CONTENEDORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENEDORLayout.createSequentialGroup()
                .addGroup(CONTENEDORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CONTENEDOR_EMPRESA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CONTENEDOR_ACCESO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        CONTENEDORLayout.setVerticalGroup(
            CONTENEDORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTENEDORLayout.createSequentialGroup()
                .addComponent(CONTENEDOR_EMPRESA, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CONTENEDOR_ACCESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        rSPanelImage3.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnArticulos.setBackground(new java.awt.Color(0, 153, 204));
        btnArticulos.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnArticulos.setForegroundHover(new java.awt.Color(0, 153, 204));
        btnArticulos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCAL_HOSPITAL);
        btnArticulos.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });
        rSPanelImage3.add(btnArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator29.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage3.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(17, 35, 46));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Gestionar Productos");
        rSPanelImage3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClientes.setBackground(new java.awt.Color(255, 102, 102));
        btnClientes.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnClientes.setForegroundHover(new java.awt.Color(255, 102, 102));
        btnClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTACTS);
        btnClientes.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        rSPanelImage1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator10.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(17, 35, 46));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Gestionar clientes");
        rSPanelImage1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProveedores.setBackground(new java.awt.Color(51, 51, 255));
        btnProveedores.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnProveedores.setForegroundHover(new java.awt.Color(51, 51, 255));
        btnProveedores.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTACT_MAIL);
        btnProveedores.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });
        rSPanelImage2.add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator28.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage2.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(17, 35, 46));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Gestionar Proveedores");
        rSPanelImage2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, -1));

        rSPanelImage4.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVentas.setBackground(new java.awt.Color(0, 102, 0));
        btnVentas.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnVentas.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnVentas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_CART);
        btnVentas.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        rSPanelImage4.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator30.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage4.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(17, 35, 46));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Realizar Ventas");
        rSPanelImage4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        rSPanelImage5.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCompras.setBackground(new java.awt.Color(255, 102, 255));
        btnCompras.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCompras.setForegroundHover(new java.awt.Color(255, 102, 255));
        btnCompras.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_BASKET);
        btnCompras.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        rSPanelImage5.add(btnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator31.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage5.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(17, 35, 46));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Registrar Compras");
        rSPanelImage5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        rSPanelImage6.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGV.setBackground(new java.awt.Color(0, 51, 51));
        btnGV.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGV.setForegroundHover(new java.awt.Color(0, 51, 51));
        btnGV.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);
        btnGV.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGVActionPerformed(evt);
            }
        });
        rSPanelImage6.add(btnGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator32.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage6.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(17, 35, 46));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Tickets Emitidos");
        rSPanelImage6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        rSPanelImage7.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGFL.setBackground(new java.awt.Color(0, 102, 102));
        btnGFL.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGFL.setForegroundHover(new java.awt.Color(0, 102, 102));
        btnGFL.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);
        btnGFL.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGFL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGFLActionPerformed(evt);
            }
        });
        rSPanelImage7.add(btnGFL, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator33.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage7.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(17, 35, 46));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Facturas Emitidas");
        rSPanelImage7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        rSPanelImage8.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        rSPanelImage8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGC.setBackground(new java.awt.Color(153, 0, 153));
        btnGC.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGC.setForegroundHover(new java.awt.Color(153, 0, 153));
        btnGC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIST);
        btnGC.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGCActionPerformed(evt);
            }
        });
        rSPanelImage8.add(btnGC, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 60, 60));

        jSeparator34.setForeground(new java.awt.Color(204, 204, 204));
        rSPanelImage8.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, -1));

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(17, 35, 46));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Gestionar Compras");
        rSPanelImage8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rSPanelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(rSPanelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rSPanelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(rSPanelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(rSPanelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSPanelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSPanelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSPanelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSPanelImage8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPanelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSPanelImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPanelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPanelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(CONTENEDOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1323, Short.MAX_VALUE))))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CONTENEDOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jToolBar1.setBackground(new java.awt.Color(17, 35, 46));
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(0, 153, 204));
        jToolBar1.setBorderPainted(false);
        jToolBar1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel5.setText("    ");
        jToolBar1.add(jLabel5);

        lblFecha.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha: ");
        jToolBar1.add(lblFecha);

        jLabel9.setText("   ");
        jToolBar1.add(jLabel9);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.add(jSeparator3);

        jLabel13.setText("   ");
        jToolBar1.add(jLabel13);

        lbversion.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbversion.setForeground(new java.awt.Color(255, 255, 255));
        lbversion.setText("Versión del Software:");
        jToolBar1.add(lbversion);

        jLabel14.setText("   ");
        jToolBar1.add(jLabel14);

        jSeparator22.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.add(jSeparator22);

        jLabel15.setText("   ");
        jToolBar1.add(jLabel15);

        lbDIP.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDIP.setForeground(new java.awt.Color(255, 255, 255));
        lbDIP.setText("IP:");
        jToolBar1.add(lbDIP);

        mbBarraMenu.setBackground(new java.awt.Color(255, 255, 255));
        mbBarraMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        mnSistema.setBackground(new java.awt.Color(255, 255, 255));
        mnSistema.setBorder(null);
        mnSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menubuttonofthreelines_79781.png"))); // NOI18N
        mnSistema.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        mnSistema.setIconTextGap(10);

        itemFondo.setBackground(new java.awt.Color(255, 255, 255));
        itemFondo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15.png"))); // NOI18N
        itemFondo.setText("CAMBIAR FONDO DE PANTALLA DEL SISTEMA");
        itemFondo.setBorder(null);
        itemFondo.setOpaque(true);
        itemFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFondoActionPerformed(evt);
            }
        });
        mnSistema.add(itemFondo);

        jSeparator21.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator21.setOpaque(true);
        mnSistema.add(jSeparator21);

        mnModPass.setBackground(new java.awt.Color(255, 255, 255));
        mnModPass.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnModPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        mnModPass.setText("CAMBIAR CONTRASEÑA DE ACCESO");
        mnModPass.setBorder(null);
        mnModPass.setOpaque(true);
        mnModPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnModPassActionPerformed(evt);
            }
        });
        mnSistema.add(mnModPass);

        jSeparator20.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator20.setOpaque(true);
        mnSistema.add(jSeparator20);

        jMenuItem52.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem52.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/datalook15.png"))); // NOI18N
        jMenuItem52.setText("CERRAR SESIÓN");
        jMenuItem52.setBorder(null);
        jMenuItem52.setOpaque(true);
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        mnSistema.add(jMenuItem52);

        jSeparator12.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator12.setOpaque(true);
        mnSistema.add(jSeparator12);

        mnCerrarSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnCerrarSistema.setBackground(new java.awt.Color(255, 255, 255));
        mnCerrarSistema.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnCerrarSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_exit_to_app_black_24.png"))); // NOI18N
        mnCerrarSistema.setText("CERRAR SISTEMA");
        mnCerrarSistema.setBorder(null);
        mnCerrarSistema.setOpaque(true);
        mnCerrarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCerrarSistemaActionPerformed(evt);
            }
        });
        mnSistema.add(mnCerrarSistema);

        mbBarraMenu.add(mnSistema);

        mnConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        mnConfiguracion.setBorder(null);
        mnConfiguracion.setText("Configuración");
        mnConfiguracion.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnConfiguracion.setIconTextGap(10);

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        jMenuItem1.setText("BUSCAR Y ESTABLECER IMPRESORA PREDETERMINADA");
        jMenuItem1.setBorder(null);
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnConfiguracion.add(jMenuItem1);

        jMenuItem9.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/datalook15.png"))); // NOI18N
        jMenuItem9.setText("MANEJAR INFORMACIÓN DEL SOFTWARE");
        jMenuItem9.setBorder(null);
        jMenuItem9.setOpaque(true);
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnConfiguracion.add(jMenuItem9);

        mbBarraMenu.add(mnConfiguracion);

        mnMantenimiento.setBackground(new java.awt.Color(255, 255, 255));
        mnMantenimiento.setBorder(null);
        mnMantenimiento.setText("Mantenimiento");
        mnMantenimiento.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnMantenimiento.setIconTextGap(10);

        mnInformacion.setBackground(new java.awt.Color(255, 255, 255));
        mnInformacion.setBorder(null);
        mnInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15.png"))); // NOI18N
        mnInformacion.setText("INFORMACIONES GENERALES Y AUXILIARES DEL SISTEMA");
        mnInformacion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnInformacion.setOpaque(true);

        itemEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        itemEmpresa.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        itemEmpresa.setText("GESTIONAR INFORMACIÓN DE LA EMPRESA");
        itemEmpresa.setBorder(null);
        itemEmpresa.setOpaque(true);
        itemEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpresaActionPerformed(evt);
            }
        });
        mnInformacion.add(itemEmpresa);

        itemSucursal.setBackground(new java.awt.Color(255, 255, 255));
        itemSucursal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        itemSucursal.setText("GESTIONAR INFORMACIÓN DE LA SUCURSAL/ES");
        itemSucursal.setBorder(null);
        itemSucursal.setOpaque(true);
        itemSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSucursalActionPerformed(evt);
            }
        });
        mnInformacion.add(itemSucursal);

        jSeparator14.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator14.setOpaque(true);
        mnInformacion.add(jSeparator14);

        mnGTimbradoM.setBackground(new java.awt.Color(255, 255, 255));
        mnGTimbradoM.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGTimbradoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        mnGTimbradoM.setText("GESTIONAR TIMBRADO");
        mnGTimbradoM.setBorder(null);
        mnGTimbradoM.setOpaque(true);
        mnGTimbradoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGTimbradoMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGTimbradoM);

        mnGPuntoEmisionM.setBackground(new java.awt.Color(255, 255, 255));
        mnGPuntoEmisionM.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGPuntoEmisionM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        mnGPuntoEmisionM.setText("GESTIONAR PUNTO DE EMISIÓN");
        mnGPuntoEmisionM.setBorder(null);
        mnGPuntoEmisionM.setOpaque(true);
        mnGPuntoEmisionM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGPuntoEmisionMActionPerformed(evt);
            }
        });
        mnInformacion.add(mnGPuntoEmisionM);

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setOpaque(true);
        mnInformacion.add(jSeparator4);

        itemFamilia.setBackground(new java.awt.Color(255, 255, 255));
        itemFamilia.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        itemFamilia.setText("GESTIONAR FAMILIAS");
        itemFamilia.setBorder(null);
        itemFamilia.setOpaque(true);
        itemFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFamiliaActionPerformed(evt);
            }
        });
        mnInformacion.add(itemFamilia);

        itemLaboratorio.setBackground(new java.awt.Color(255, 255, 255));
        itemLaboratorio.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        itemLaboratorio.setText("GESTIONAR LABORATORIOS");
        itemLaboratorio.setBorder(null);
        itemLaboratorio.setOpaque(true);
        itemLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLaboratorioActionPerformed(evt);
            }
        });
        mnInformacion.add(itemLaboratorio);

        itemCiudades.setBackground(new java.awt.Color(255, 255, 255));
        itemCiudades.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemCiudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        itemCiudades.setText("GESTIONAR CIUDADES");
        itemCiudades.setBorder(null);
        itemCiudades.setOpaque(true);
        itemCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCiudadesActionPerformed(evt);
            }
        });
        mnInformacion.add(itemCiudades);

        jMenuItem35.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem35.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem35.setText("GESTIONAR MOTIVOS");
        jMenuItem35.setBorder(null);
        jMenuItem35.setOpaque(true);
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem35);

        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator9.setOpaque(true);
        mnInformacion.add(jSeparator9);

        jMenuItem51.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem51.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem51.setText("GESTIONAR MOTIVOS DE PAGOS/INGRESOS DE EFECTIVO");
        jMenuItem51.setBorder(null);
        jMenuItem51.setOpaque(true);
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem51);

        jMenuItem53.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem53.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem53.setText("GESTIONAR MOTIVOS DE GASTOS/SALIDAS DE EFECTIVOS");
        jMenuItem53.setBorder(null);
        jMenuItem53.setOpaque(true);
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem53);

        mnMantenimiento.add(mnInformacion);

        Separator13.setForeground(new java.awt.Color(204, 204, 204));
        Separator13.setOpaque(true);
        mnMantenimiento.add(Separator13);

        mnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        mnEmpleados.setBorder(null);
        mnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person15.png"))); // NOI18N
        mnEmpleados.setText("RECURSO HUMANO");
        mnEmpleados.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnEmpleados.setOpaque(true);

        jMenuItem8.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem8.setText("GESTIONAR INFORMACIÓN DE FUNCIONARIOS");
        jMenuItem8.setBorder(null);
        jMenuItem8.setOpaque(true);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnEmpleados.add(jMenuItem8);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOpaque(true);
        mnEmpleados.add(jSeparator2);

        mnComision.setBackground(new java.awt.Color(255, 255, 255));
        mnComision.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnComision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        mnComision.setText("COMISIONES");
        mnComision.setBorder(null);
        mnComision.setOpaque(true);
        mnComision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnComisionActionPerformed(evt);
            }
        });
        mnEmpleados.add(mnComision);

        jMenuItem10.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem10.setText("REPORTE DE VENTAS");
        jMenuItem10.setBorder(null);
        jMenuItem10.setOpaque(true);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        mnEmpleados.add(jMenuItem10);

        mnMantenimiento.add(mnEmpleados);

        mnProveedores.setBackground(new java.awt.Color(255, 255, 255));
        mnProveedores.setBorder(null);
        mnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person15.png"))); // NOI18N
        mnProveedores.setText("PROVEEDORES");
        mnProveedores.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnProveedores.setOpaque(true);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem7.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        jMenuItem7.setText("GESTIONAR INFORMACIÓN DE PROVEEDORES");
        jMenuItem7.setBorder(null);
        jMenuItem7.setOpaque(true);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnProveedores.add(jMenuItem7);

        mnMantenimiento.add(mnProveedores);

        mnClientes.setBackground(new java.awt.Color(255, 255, 255));
        mnClientes.setBorder(null);
        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person15.png"))); // NOI18N
        mnClientes.setText("CLIENTES");
        mnClientes.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnClientes.setOpaque(true);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem6.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        jMenuItem6.setText("GESTIONAR INFORMACIÓN DE CLIENTES");
        jMenuItem6.setBorder(null);
        jMenuItem6.setOpaque(true);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnClientes.add(jMenuItem6);

        mnMantenimiento.add(mnClientes);

        Separator11.setForeground(new java.awt.Color(204, 204, 204));
        Separator11.setOpaque(true);
        mnMantenimiento.add(Separator11);

        mnSeguridad.setBackground(new java.awt.Color(255, 255, 255));
        mnSeguridad.setBorder(null);
        mnSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/security15.png"))); // NOI18N
        mnSeguridad.setText("SEGURIDAD Y RESPALDO");
        mnSeguridad.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnSeguridad.setOpaque(true);

        smModUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        smModUsuarios.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        smModUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/securityOk15.png"))); // NOI18N
        smModUsuarios.setText("GESTIONAR INFORMACIÓN DE USUARIOS");
        smModUsuarios.setBorder(null);
        smModUsuarios.setOpaque(true);
        smModUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smModUsuariosActionPerformed(evt);
            }
        });
        mnSeguridad.add(smModUsuarios);

        smModUsuariosD.setBackground(new java.awt.Color(255, 255, 255));
        smModUsuariosD.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        smModUsuariosD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/securityOk15.png"))); // NOI18N
        smModUsuariosD.setText("GESTIONAR INFORMACIÓN DE USUARIOS - MODO DESARROLLADOR");
        smModUsuariosD.setBorder(null);
        smModUsuariosD.setOpaque(true);
        smModUsuariosD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smModUsuariosDActionPerformed(evt);
            }
        });
        mnSeguridad.add(smModUsuariosD);

        jSeparator16.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator16.setOpaque(true);
        mnSeguridad.add(jSeparator16);

        itemExportar.setBackground(new java.awt.Color(255, 255, 255));
        itemExportar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/export15.png"))); // NOI18N
        itemExportar.setText("GENERAR RESPALDO DE DATOS - BACKUP");
        itemExportar.setBorder(null);
        itemExportar.setOpaque(true);
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        mnSeguridad.add(itemExportar);

        itemImportar.setBackground(new java.awt.Color(255, 255, 255));
        itemImportar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/import15.png"))); // NOI18N
        itemImportar.setText("RESTABLECER DATOS DEL SISTEMA VÍA BACKUP - DATA IMPORT");
        itemImportar.setBorder(null);
        itemImportar.setOpaque(true);
        itemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemImportarActionPerformed(evt);
            }
        });
        mnSeguridad.add(itemImportar);

        mnMantenimiento.add(mnSeguridad);

        mbBarraMenu.add(mnMantenimiento);

        divisor3.setText("|");
        divisor3.setEnabled(false);
        divisor3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor3);

        mnCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnCaja.setBorder(null);
        mnCaja.setText("Movimiento Diario");
        mnCaja.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnCaja.setIconTextGap(10);

        mnIniciarCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnIniciarCaja.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnIniciarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/abrircaja.png"))); // NOI18N
        mnIniciarCaja.setText("HABILITAR MOVIMIENTO DIARIO DE CAJA - INICIALIZACIÓN DE CAJA BASE");
        mnIniciarCaja.setBorder(null);
        mnIniciarCaja.setOpaque(true);
        mnIniciarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIniciarCajaActionPerformed(evt);
            }
        });
        mnCaja.add(mnIniciarCaja);

        jSeparator15.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator15.setOpaque(true);
        mnCaja.add(jSeparator15);

        mnIngresosVarios.setBackground(new java.awt.Color(255, 255, 255));
        mnIngresosVarios.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnIngresosVarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cajasumar.png"))); // NOI18N
        mnIngresosVarios.setText("REGISTRAR INGRESOS Y COBRANZAS");
        mnIngresosVarios.setBorder(null);
        mnIngresosVarios.setOpaque(true);
        mnIngresosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIngresosVariosActionPerformed(evt);
            }
        });
        mnCaja.add(mnIngresosVarios);

        mnGastosVarios.setBackground(new java.awt.Color(255, 255, 255));
        mnGastosVarios.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGastosVarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cajarestar.png"))); // NOI18N
        mnGastosVarios.setText("REGISTRAR GASTOS Y RETIROS");
        mnGastosVarios.setBorder(null);
        mnGastosVarios.setOpaque(true);
        mnGastosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGastosVariosActionPerformed(evt);
            }
        });
        mnCaja.add(mnGastosVarios);

        jSeparator19.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator19.setOpaque(true);
        mnCaja.add(jSeparator19);

        mnCierredeCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnCierredeCaja.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnCierredeCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cajacerrar.png"))); // NOI18N
        mnCierredeCaja.setText("FINALIZAR MOVIMIENTO DIARIO - CIERRE Y ARQUEO DE VALORES");
        mnCierredeCaja.setBorder(null);
        mnCierredeCaja.setOpaque(true);
        mnCierredeCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCierredeCajaActionPerformed(evt);
            }
        });
        mnCaja.add(mnCierredeCaja);

        mbBarraMenu.add(mnCaja);

        divisor4.setText("|");
        divisor4.setEnabled(false);
        divisor4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor4);

        mnArticulos.setBackground(new java.awt.Color(255, 255, 255));
        mnArticulos.setBorder(null);
        mnArticulos.setText("Artículos");
        mnArticulos.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnArticulos.setIconTextGap(10);
        mnArticulos.setOpaque(true);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorax40 - copia.png"))); // NOI18N
        jMenuItem2.setText("GESTIONAR INFORMACIÓN DE TODOS LOS ARTÍCULOS");
        jMenuItem2.setBorder(null);
        jMenuItem2.setOpaque(true);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildoraajustex45 - copia.png"))); // NOI18N
        jMenuItem3.setText("AJUSTAR STOCK DE ARTÍCULOS");
        jMenuItem3.setBorder(null);
        jMenuItem3.setOpaque(true);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem3);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        mnArticulos.add(jSeparator1);

        jMenuItem4.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorasalidazx45 - copia.png"))); // NOI18N
        jMenuItem4.setText("APLICAR SALIDAS DE ARTÍCULOS");
        jMenuItem4.setBorder(null);
        jMenuItem4.setOpaque(true);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorasalidazx45 - copia.png"))); // NOI18N
        jMenuItem5.setText("VISOR DE SALIDAS APLICADAS A ARTÍCULOS");
        jMenuItem5.setBorder(null);
        jMenuItem5.setOpaque(true);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem5);

        mbBarraMenu.add(mnArticulos);

        mnCompras.setBackground(new java.awt.Color(255, 255, 255));
        mnCompras.setBorder(null);
        mnCompras.setText("Compras");
        mnCompras.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnCompras.setIconTextGap(10);

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem30.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem30.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/comprax40 - copia.png"))); // NOI18N
        jMenuItem30.setText("REGISTRAR COMPRAS DEL DÍA");
        jMenuItem30.setBorder(null);
        jMenuItem30.setOpaque(true);
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        mnCompras.add(jMenuItem30);

        mnNCProveedor.setBackground(new java.awt.Color(255, 255, 255));
        mnNCProveedor.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnNCProveedor.setText("REGISTRAR NOTAS DE CRÉDITOS DEL PROVEEDOR");
        mnNCProveedor.setBorder(null);
        mnNCProveedor.setOpaque(true);
        mnNCProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNCProveedorActionPerformed(evt);
            }
        });
        mnCompras.add(mnNCProveedor);

        mnPagoProveedor.setBackground(new java.awt.Color(255, 255, 255));
        mnPagoProveedor.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnPagoProveedor.setText("REGISTRAR PAGOS A PROVEEDORES");
        mnPagoProveedor.setBorder(null);
        mnPagoProveedor.setOpaque(true);
        mnPagoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPagoProveedorActionPerformed(evt);
            }
        });
        mnCompras.add(mnPagoProveedor);

        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator6.setOpaque(true);
        mnCompras.add(jSeparator6);

        mnGC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        mnGC.setBackground(new java.awt.Color(255, 255, 255));
        mnGC.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        mnGC.setText("GESTIONAR TODAS LAS COMPRAS REALIZADAS.");
        mnGC.setBorder(null);
        mnGC.setOpaque(true);
        mnGC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGCActionPerformed(evt);
            }
        });
        mnCompras.add(mnGC);

        mbBarraMenu.add(mnCompras);

        mnVentas.setBackground(new java.awt.Color(255, 255, 255));
        mnVentas.setBorder(null);
        mnVentas.setText("Ventas");
        mnVentas.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnVentas.setIconTextGap(10);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem23.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem23.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventax40 - copia.png"))); // NOI18N
        jMenuItem23.setText("REGISTRAR VENTAS DEL DÍA");
        jMenuItem23.setBorder(null);
        jMenuItem23.setOpaque(true);
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        mnVentas.add(jMenuItem23);

        jMenuItem24.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem24.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventapresupuestox40 - copia.png"))); // NOI18N
        jMenuItem24.setText("GENERAR PRESUPUESTOS");
        jMenuItem24.setBorder(null);
        jMenuItem24.setOpaque(true);
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        mnVentas.add(jMenuItem24);

        mnNCVenta.setBackground(new java.awt.Color(255, 255, 255));
        mnNCVenta.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnNCVenta.setText("GENERAR NOTAS DE CRÉDITOS");
        mnNCVenta.setBorder(null);
        mnNCVenta.setOpaque(true);
        mnNCVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNCVentaActionPerformed(evt);
            }
        });
        mnVentas.add(mnNCVenta);

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator5.setOpaque(true);
        mnVentas.add(jSeparator5);

        TICKETS.setBackground(new java.awt.Color(255, 255, 255));
        TICKETS.setBorder(null);
        TICKETS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TICK_30 - copia.png"))); // NOI18N
        TICKETS.setText("TICKETS");
        TICKETS.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        TICKETS.setOpaque(true);

        mnGV.setBackground(new java.awt.Color(255, 255, 255));
        mnGV.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TICK_30 - copia.png"))); // NOI18N
        mnGV.setText("GESTIONAR TICKETS EMITIDOS");
        mnGV.setBorder(null);
        mnGV.setOpaque(true);
        mnGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVActionPerformed(evt);
            }
        });
        TICKETS.add(mnGV);

        jSeparator26.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator26.setOpaque(true);
        TICKETS.add(jSeparator26);

        mnGVE.setBackground(new java.awt.Color(255, 255, 255));
        mnGVE.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/TICK_pag.png"))); // NOI18N
        mnGVE.setText("GESTIONAR CUENTAS PENDIENTES - TICKETS CRÉDITOS");
        mnGVE.setBorder(null);
        mnGVE.setOpaque(true);
        mnGVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVEActionPerformed(evt);
            }
        });
        TICKETS.add(mnGVE);

        mnVentas.add(TICKETS);

        jSeparator24.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator24.setOpaque(true);
        mnVentas.add(jSeparator24);

        FACTURAS.setBackground(new java.awt.Color(255, 255, 255));
        FACTURAS.setBorder(null);
        FACTURAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/FACT_30 - copia.png"))); // NOI18N
        FACTURAS.setText("FACTURAS LEGALES");
        FACTURAS.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        FACTURAS.setOpaque(true);

        mnGFL.setBackground(new java.awt.Color(255, 255, 255));
        mnGFL.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGFL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/FACT_30 - copia.png"))); // NOI18N
        mnGFL.setText("GESTIONAR FACTUAS LEGALES EMITIDOS");
        mnGFL.setBorder(null);
        mnGFL.setOpaque(true);
        mnGFL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGFLActionPerformed(evt);
            }
        });
        FACTURAS.add(mnGFL);

        jSeparator25.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator25.setOpaque(true);
        FACTURAS.add(jSeparator25);

        mnGVE1.setBackground(new java.awt.Color(255, 255, 255));
        mnGVE1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGVE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/FACT_pag.png"))); // NOI18N
        mnGVE1.setText("GESTIONAR CUENTAS PENDIENTES - FACTURAS LEGALES CRÉDITOS");
        mnGVE1.setBorder(null);
        mnGVE1.setOpaque(true);
        mnGVE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVE1ActionPerformed(evt);
            }
        });
        FACTURAS.add(mnGVE1);

        mnVentas.add(FACTURAS);

        jSeparator23.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator23.setOpaque(true);
        mnVentas.add(jSeparator23);

        mnGNCVenta.setBackground(new java.awt.Color(255, 255, 255));
        mnGNCVenta.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGNCVenta.setText("VISOR DE NOTAS DE CRÉDITOS EMITIDOS");
        mnGNCVenta.setBorder(null);
        mnGNCVenta.setOpaque(true);
        mnGNCVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVentaActionPerformed(evt);
            }
        });
        mnVentas.add(mnGNCVenta);

        mnGPE.setBackground(new java.awt.Color(255, 255, 255));
        mnGPE.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        mnGPE.setText("VISOR DE PRESUPUESTOS ELABORADOS");
        mnGPE.setBorder(null);
        mnGPE.setOpaque(true);
        mnGPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGPEActionPerformed(evt);
            }
        });
        mnVentas.add(mnGPE);

        mbBarraMenu.add(mnVentas);

        divisor5.setText("|");
        divisor5.setEnabled(false);
        divisor5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor5);

        mnReportes.setBackground(new java.awt.Color(255, 255, 255));
        mnReportes.setBorder(null);
        mnReportes.setText("Generar Reportes");
        mnReportes.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnReportes.setIconTextGap(10);

        rpVentas.setBackground(new java.awt.Color(255, 255, 255));
        rpVentas.setBorder(null);
        rpVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpVentas.setText("VENTAS");
        rpVentas.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpVentas.setOpaque(true);

        jMenuItem26.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem26.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem26.setText("RESUMEN DE CAJA");
        jMenuItem26.setBorder(null);
        jMenuItem26.setOpaque(true);
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem26);

        jMenuItem66.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem66.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem66.setText("TOTAL DE VENTAS - REPORTE VALORIZADO");
        jMenuItem66.setBorder(null);
        jMenuItem66.setOpaque(true);
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem66);

        jMenuItem65.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem65.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem65.setText("RANKING DE VENTAS");
        jMenuItem65.setBorder(null);
        jMenuItem65.setOpaque(true);
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem65);

        jMenuItem67.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem67.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem67.setText("VENTAS POR LABORATORIO");
        jMenuItem67.setBorder(null);
        jMenuItem67.setOpaque(true);
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem67);

        mnReportes.add(rpVentas);

        rpCompras.setBackground(new java.awt.Color(255, 255, 255));
        rpCompras.setBorder(null);
        rpCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpCompras.setText("COMPRAS");
        rpCompras.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpCompras.setOpaque(true);
        mnReportes.add(rpCompras);

        rpDevoluciones.setBackground(new java.awt.Color(255, 255, 255));
        rpDevoluciones.setBorder(null);
        rpDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpDevoluciones.setText("DEVOLUCIONES");
        rpDevoluciones.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpDevoluciones.setOpaque(true);
        mnReportes.add(rpDevoluciones);

        rpPresupuestos.setBackground(new java.awt.Color(255, 255, 255));
        rpPresupuestos.setBorder(null);
        rpPresupuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpPresupuestos.setText("PRESUPUESTOS");
        rpPresupuestos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpPresupuestos.setOpaque(true);
        mnReportes.add(rpPresupuestos);

        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator7.setOpaque(true);
        mnReportes.add(jSeparator7);

        rpArticulos.setBackground(new java.awt.Color(255, 255, 255));
        rpArticulos.setBorder(null);
        rpArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpArticulos.setText("ARTÍCULOS");
        rpArticulos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpArticulos.setOpaque(true);

        jMenuItem36.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem36.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem36.setText("LISTADO E INVENTARIO DE ARTÍCULOS");
        jMenuItem36.setBorder(null);
        jMenuItem36.setOpaque(true);
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem36);

        jMenuItem38.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem38.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem38.setText("STOCK VALORIZADO");
        jMenuItem38.setBorder(null);
        jMenuItem38.setOpaque(true);
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem38);

        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator8.setOpaque(true);
        rpArticulos.add(jSeparator8);

        jMenuItem40.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem40.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem40.setText("SALIDAS DE ARTÍCULOS");
        jMenuItem40.setBorder(null);
        jMenuItem40.setOpaque(true);
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem40);

        jMenuItem41.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem41.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem41.setText("SALIDAS POR MOTIVOS");
        jMenuItem41.setBorder(null);
        jMenuItem41.setOpaque(true);
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem41);

        mnReportes.add(rpArticulos);

        rpClientes.setBackground(new java.awt.Color(255, 255, 255));
        rpClientes.setBorder(null);
        rpClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpClientes.setText("CLIENTES");
        rpClientes.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpClientes.setOpaque(true);

        jMenuItem42.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem42.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem42.setText("LISTADO DE CLIENTES");
        jMenuItem42.setBorder(null);
        jMenuItem42.setOpaque(true);
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        rpClientes.add(jMenuItem42);

        jMenuItem43.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem43.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem43.setText("ARTÍCULOS COMPRADOS POR CLIENTES");
        jMenuItem43.setBorder(null);
        jMenuItem43.setOpaque(true);
        rpClientes.add(jMenuItem43);

        jMenuItem44.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem44.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem44.setText("TOTAL DE VENTAS POR CLIENTE");
        jMenuItem44.setBorder(null);
        jMenuItem44.setOpaque(true);
        rpClientes.add(jMenuItem44);

        mnReportes.add(rpClientes);

        rpProveedores.setBackground(new java.awt.Color(255, 255, 255));
        rpProveedores.setBorder(null);
        rpProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpProveedores.setText("PROVEEDORES");
        rpProveedores.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpProveedores.setOpaque(true);
        mnReportes.add(rpProveedores);

        rpVendedores.setBackground(new java.awt.Color(255, 255, 255));
        rpVendedores.setBorder(null);
        rpVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ic_menu_128_28650 - copia.png"))); // NOI18N
        rpVendedores.setText("FUNCIONARIOS");
        rpVendedores.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rpVendedores.setOpaque(true);

        jMenuItem48.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem48.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem48.setText("COMISIONES GENERADOS");
        jMenuItem48.setBorder(null);
        jMenuItem48.setOpaque(true);
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        rpVendedores.add(jMenuItem48);

        mnReportes.add(rpVendedores);

        mbBarraMenu.add(mnReportes);

        divisor6.setText("|");
        divisor6.setEnabled(false);
        divisor6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor6);

        mnAyuda.setBackground(new java.awt.Color(255, 255, 255));
        mnAyuda.setBorder(null);
        mnAyuda.setText("Sistema");
        mnAyuda.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        mnAyuda.setIconTextGap(10);

        jMenuItem17.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Copyright 25.png"))); // NOI18N
        jMenuItem17.setText("ACERCA DE...                                                      ");
        jMenuItem17.setActionCommand("ACERCA DE...                                            ");
        jMenuItem17.setBorder(null);
        jMenuItem17.setOpaque(true);
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        mnAyuda.add(jMenuItem17);

        mbBarraMenu.add(mnAyuda);

        setJMenuBar(mbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 2207, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            dlgAjusteStock ajuste = new dlgAjusteStock(this, true);
            ajuste.setLocationRelativeTo(null);
            ajuste.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            dlgSalidaMercaderia salida = new dlgSalidaMercaderia(this, true);
            salida.setLocationRelativeTo(null);
            salida.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            dlgConSalidas conSalidas = new dlgConSalidas(this, true);
            conSalidas.setLocationRelativeTo(null);
            conSalidas.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        abrirClientes();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        abrirArticulos();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnCerrarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCerrarSistemaActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_mnCerrarSistemaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        abrirProveedor();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void itemLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLaboratorioActionPerformed
        // TODO add your handling code here:
        try {
            dlgLaboratorio laboratorio = new dlgLaboratorio(this, true);
            laboratorio.setLocationRelativeTo(null);
            laboratorio.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemLaboratorioActionPerformed

    private void itemCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCiudadesActionPerformed
        // TODO add your handling code here:
        try {
            dlgCiudad ciu = new dlgCiudad(this, true);
            ciu.setLocationRelativeTo(null);
            ciu.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemCiudadesActionPerformed

    private void itemFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFamiliaActionPerformed
        // TODO add your handling code here:
        try {
            dlgFamilia familia = new dlgFamilia(this, true);
            familia.setLocationRelativeTo(null);
            familia.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemFamiliaActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            dlgVendedor vend = new dlgVendedor(this, true);
            //vend.setSize(1100, 490);
            vend.setLocationRelativeTo(null);
            vend.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        btnComprasActionPerformed(null);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        try {
            dlgMotivo motivo = new dlgMotivo(this, true);
            motivo.setLocationRelativeTo(null);
            motivo.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        btnVentasActionPerformed(null);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        /*   dlgPresupuestos presupuesto = new dlgPresupuestos(this, false);
        presupuesto.setLocationRelativeTo(null);
        presupuesto.setVisible(true);*/
        Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void mnGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarFacturas cf = new dlgConsultarFacturas(this, false);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGVActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteArticulos rsc = new dlgReporteArticulos(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        try {
            // TODO add your handling code here:
            ReporteF nr;
            nr = new ReporteF();
            nr.cerrar();
        } catch (SQLException ex) {
            System.out.println("Error levantando reporte: " + ex.getMessage());
        }
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void mnGPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGPEActionPerformed
        // TODO add your handling code here:
        /*  try {
            dlgConsultarPresupuesto cp = new dlgConsultarPresupuesto(this, false);
            cp.setLocationRelativeTo(null);
            cp.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/
        Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGPEActionPerformed

    private void mnGNCVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVentaActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsNotaCredito cnc = new dlgConsNotaCredito(this, false);
            cnc.setLocationRelativeTo(null);
            cnc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGNCVentaActionPerformed

    private void mnNCVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNCVentaActionPerformed
        // TODO add your handling code here:
        dlgNotasCredito nc = new dlgNotasCredito(this, true);
        nc.setLocationRelativeTo(null);
        nc.setVisible(true);
    }//GEN-LAST:event_mnNCVentaActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        // TODO add your handling code here:
        CerrarCesion();


    }//GEN-LAST:event_jMenuItem52ActionPerformed

    public void salir() {
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del sistema?");
        if (rpta == 0) {
            String msg = ControlLogeo.desLogeo();
            System.exit(0);
        }
    }

    public void CerrarCesion() {
        int rpta = Mensajes.confirmar("¿Seguro que desea Cerrar Sesión?");
        if (rpta == 0) {
            String msg = ControlLogeo.desLogeo();
            //System.exit(0);
            this.dispose();
            frmAcceso ac = new frmAcceso();
            ac.setLocationRelativeTo(null);
            ac.setVisible(true);

        }
    }

    void abrirImpresoras() {
        try {
            dlgImpresoras impre = new dlgImpresoras(this, true);
            impre.setLocationRelativeTo(null);
            impre.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirFactura() {
        try {
            dlgVentas factura = new dlgVentas(null, true);
            factura.requestFocus();
            factura.setLocationRelativeTo(null);
            factura.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirCompras() {
        try {
            dlgCompras compras = new dlgCompras(this, false);
            compras.setLocationRelativeTo(null);
            compras.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirClientes() {
        try {
            dlgClientes clientes = new dlgClientes(this, true);
            //clientes.setSize(1000, 540);
            clientes.setLocationRelativeTo(null);
            clientes.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirArticulos() {
        try {
            dlgArticulos articulo = new dlgArticulos(this, true);
            articulo.setLocationRelativeTo(null);
            articulo.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirTimbradoMovil() {
        try {
            dlgTimbradoMovil TimbradoM = new dlgTimbradoMovil(this, true);
            TimbradoM.setLocationRelativeTo(null);
            TimbradoM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirPuntoEmisionMovil() {
        try {
            dlgPuntoEmisionMovil PPM = new dlgPuntoEmisionMovil(this, true);
            PPM.setLocationRelativeTo(null);
            PPM.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    private void smModUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smModUsuariosActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestUsuario gu = new dlgGestUsuario(this, true);
            gu.setLocationRelativeTo(null);
            gu.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_smModUsuariosActionPerformed

    private void mnComisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnComisionActionPerformed
        // TODO add your handling code here:
        /*dlgComisionEmpleado ce = new dlgComisionEmpleado(this, true);
        ce.setLocationRelativeTo(null);
        ce.setVisible(true);*/
        Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnComisionActionPerformed

    private void mnGCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGCActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarCompras consCompras = new dlgConsultarCompras(this, true);
            consCompras.setLocationRelativeTo(null);
            consCompras.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGCActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteResumenCaja rsc = new dlgReporteResumenCaja(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void mnCierredeCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCierredeCajaActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja ya fue cerrada.\n\nPodra acceder a este formulario para visualizar los movimientos en la siguiente apertura de caja.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgCajaDia cajaDia = new dlgCajaDia(this, true);
                cajaDia.setLocationRelativeTo(null);
                cajaDia.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTA SIENDO DESARROLLADO ACTUALMENTE");
    }//GEN-LAST:event_mnCierredeCajaActionPerformed

    private void mnGastosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGastosVariosActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara registrar pagos de servicios u otros egresos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgGastos gastos = new dlgGastos(this, true);
                gastos.setLocationRelativeTo(null);
                gastos.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGastosVariosActionPerformed

    private void mnIngresosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIngresosVariosActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara registrar cobranzas u otros ingresos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgIngreso ingreso = new dlgIngreso(this, true);
                ingreso.setLocationRelativeTo(null);
                ingreso.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnIngresosVariosActionPerformed

    private void itemFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFondoActionPerformed
        // TODO add your handling code here:
        try {
            dlgFondo fondo = new dlgFondo(this, true);
            fondo.setLocationRelativeTo(null);
            fondo.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemFondoActionPerformed

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteRankingFecha rsc = new dlgReporteRankingFecha(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteTotalVentas rsc = new dlgReporteTotalVentas(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void itemEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpresaActionPerformed
        // TODO add your handling code here:
        try {
            dlgEmpresa empresa = new dlgEmpresa(this, true);
            empresa.setLocationRelativeTo(null);
            empresa.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemEmpresaActionPerformed

    private void itemSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSucursalActionPerformed
        // TODO add your handling code here:
        try {
            dlgSucursal sucursal = new dlgSucursal(this, true);
            sucursal.setLocationRelativeTo(null);
            sucursal.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemSucursalActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed
        // TODO add your handling code here:
        Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImportarActionPerformed
        // TODO add your handling code here:
        Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_itemImportarActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        dlgAyuda a = new dlgAyuda(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Mensajes.informacion("ESTE REPORTE ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void mnPagoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPagoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnPagoProveedorActionPerformed

    private void mnNCProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNCProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnNCProveedorActionPerformed

    private void mnIniciarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIniciarCajaActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja WHERE ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                dlgCaja caja = new dlgCaja(this, true);
                caja.setLocationRelativeTo(null);
                caja.setVisible(true);
            } else {
                Mensajes.informacion("La caja ya fue inicializada.\n\nPuede comenzar a registrar compras o realizar ventas\nsin ningún inconveniente.");
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnIniciarCajaActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
        try {
            dlgDetalleIngreso detalleI = new dlgDetalleIngreso(this, true);
            detalleI.setLocationRelativeTo(null);
            detalleI.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        try {
            dlgDetalleGasto detalleG = new dlgDetalleGasto(this, true);
            detalleG.setLocationRelativeTo(null);
            detalleG.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        abrirImpresoras();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnGVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVEActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarCreditos cc = new dlgConsultarCreditos(this, true);
            cc.setLocationRelativeTo(null);
            cc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGVEActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        dlgSoftware a = new dlgSoftware(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void smModUsuariosDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smModUsuariosDActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestUsuarioD gud = new dlgGestUsuarioD(this, true);
            gud.setLocationRelativeTo(null);
            gud.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_smModUsuariosDActionPerformed

    private void mnModPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnModPassActionPerformed
        // TODO add your handling code here:
        try {
            dlgActualizarContra ap = new dlgActualizarContra(this, true);
            ap.setLocationRelativeTo(null);
            ap.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnModPassActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteStockValorizado rsc = new dlgReporteStockValorizado(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        /* try {
            dlgReporteComisionesGenerados rsc = new dlgReporteComisionesGenerados(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteLaboratorioFecha rsc = new dlgReporteLaboratorioFecha(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem67ActionPerformed

    private void mnGTimbradoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGTimbradoMActionPerformed
        // TODO add your handling code here:
        abrirTimbradoMovil();
    }//GEN-LAST:event_mnGTimbradoMActionPerformed

    private void mnGPuntoEmisionMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGPuntoEmisionMActionPerformed
        // TODO add your handling code here:
        abrirPuntoEmisionMovil();
    }//GEN-LAST:event_mnGPuntoEmisionMActionPerformed

    private void mnGFLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGFLActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarFacturasLegal cf = new dlgConsultarFacturasLegal(this, true);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGFLActionPerformed

    private void mnGVE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVE1ActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarCreditosFacturas cc = new dlgConsultarCreditosFacturas(this, true);
            cc.setLocationRelativeTo(null);
            cc.setVisible(true);
        } catch (SQLException e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGVE1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        CerrarCesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed
        // TODO add your handling code here:
        abrirArticulos();
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        abrirClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        // TODO add your handling code here:
        abrirProveedor();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
        if (!fe.equals(Fecha.fechaCorrecta())) {
            Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a vender sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
        } else {
            abrirFactura();
        }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:
        String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
        if (!fe.equals(Fecha.fechaCorrecta())) {
            Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar las compras a proveedores sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
        } else {
            abrirCompras();
        }
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGVActionPerformed
        // TODO add your handling code here:
        mnGVActionPerformed(null);
    }//GEN-LAST:event_btnGVActionPerformed

    private void btnGFLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGFLActionPerformed
        // TODO add your handling code here:
        mnGFLActionPerformed(null);
    }//GEN-LAST:event_btnGFLActionPerformed

    private void btnGCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGCActionPerformed
        // TODO add your handling code here:
        mnGCActionPerformed(null);
    }//GEN-LAST:event_btnGCActionPerformed
    void abrirProveedor() {
        try {
            dlgProveedores proveedor = new dlgProveedores(this, true);
            proveedor.setSize(1200, 540);
            proveedor.setLocationRelativeTo(null);
            proveedor.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
            setVisible(true);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo el icono del sistema.");
        }
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new frmPrincipal().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rspanel.RSPanelImage CONTENEDOR;
    private rojeru_san.rspanel.RSPanelImage CONTENEDOR_ACCESO;
    private rojeru_san.rspanel.RSPanelImage CONTENEDOR_EMPRESA;
    private javax.swing.JMenu FACTURAS;
    public static javax.swing.JPopupMenu.Separator Separator11;
    public static javax.swing.JPopupMenu.Separator Separator13;
    private javax.swing.JMenu TICKETS;
    public static RSMaterialComponent.RSButtonIconUno btnArticulos;
    public static RSMaterialComponent.RSButtonIconUno btnCerrarSesion;
    public static RSMaterialComponent.RSButtonIconUno btnClientes;
    public static RSMaterialComponent.RSButtonIconUno btnCompras;
    public static RSMaterialComponent.RSButtonIconUno btnGC;
    public static RSMaterialComponent.RSButtonIconUno btnGFL;
    public static RSMaterialComponent.RSButtonIconUno btnGV;
    public static RSMaterialComponent.RSButtonIconUno btnProveedores;
    public static RSMaterialComponent.RSButtonIconUno btnSalir;
    public static RSMaterialComponent.RSButtonIconUno btnVentas;
    public static javax.swing.JMenu divisor3;
    public static javax.swing.JMenu divisor4;
    public static javax.swing.JMenu divisor5;
    public static javax.swing.JMenu divisor6;
    private javax.swing.JLabel encabezado_1;
    private javax.swing.JLabel encabezado_2;
    private javax.swing.JLabel iconoEmpresa;
    private javax.swing.JMenuItem itemCiudades;
    private javax.swing.JMenuItem itemEmpresa;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemFamilia;
    public static javax.swing.JMenuItem itemFondo;
    private javax.swing.JMenuItem itemImportar;
    private javax.swing.JMenuItem itemLaboratorio;
    private javax.swing.JMenuItem itemSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem23;
    public static javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem38;
    public static javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator23;
    private javax.swing.JPopupMenu.Separator jSeparator24;
    private javax.swing.JPopupMenu.Separator jSeparator25;
    private javax.swing.JPopupMenu.Separator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private static javax.swing.JLabel lbDIP;
    public static javax.swing.JLabel lbEmpresa;
    public static javax.swing.JLabel lbNombreFantasia;
    public static javax.swing.JLabel lbPerfil;
    public static javax.swing.JLabel lbRUC;
    public static javax.swing.JLabel lbSucursal;
    public static javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbversion;
    private javax.swing.JMenuBar mbBarraMenu;
    public static javax.swing.JMenu mnArticulos;
    public static javax.swing.JMenu mnAyuda;
    public static javax.swing.JMenu mnCaja;
    private javax.swing.JMenuItem mnCerrarSistema;
    private javax.swing.JMenuItem mnCierredeCaja;
    public static javax.swing.JMenu mnClientes;
    public static javax.swing.JMenuItem mnComision;
    public static javax.swing.JMenu mnCompras;
    public static javax.swing.JMenu mnConfiguracion;
    public static javax.swing.JMenu mnEmpleados;
    private javax.swing.JMenuItem mnGC;
    private javax.swing.JMenuItem mnGFL;
    public static javax.swing.JMenuItem mnGNCVenta;
    private javax.swing.JMenuItem mnGPE;
    private javax.swing.JMenuItem mnGPuntoEmisionM;
    private javax.swing.JMenuItem mnGTimbradoM;
    private javax.swing.JMenuItem mnGV;
    public static javax.swing.JMenuItem mnGVE;
    public static javax.swing.JMenuItem mnGVE1;
    private javax.swing.JMenuItem mnGastosVarios;
    public static javax.swing.JMenu mnInformacion;
    private javax.swing.JMenuItem mnIngresosVarios;
    private javax.swing.JMenuItem mnIniciarCaja;
    public static javax.swing.JMenu mnMantenimiento;
    private javax.swing.JMenuItem mnModPass;
    public static javax.swing.JMenuItem mnNCProveedor;
    public static javax.swing.JMenuItem mnNCVenta;
    public static javax.swing.JMenuItem mnPagoProveedor;
    public static javax.swing.JMenu mnProveedores;
    public static javax.swing.JMenu mnReportes;
    public static javax.swing.JMenu mnSeguridad;
    public static javax.swing.JMenu mnSistema;
    public static javax.swing.JMenu mnVentas;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage1;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage2;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage3;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage4;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage5;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage6;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage7;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage8;
    public static javax.swing.JMenu rpArticulos;
    public static javax.swing.JMenu rpClientes;
    public static javax.swing.JMenu rpCompras;
    public static javax.swing.JMenu rpDevoluciones;
    public static javax.swing.JMenu rpPresupuestos;
    public static javax.swing.JMenu rpProveedores;
    public static javax.swing.JMenu rpVendedores;
    public static javax.swing.JMenu rpVentas;
    private javax.swing.JMenuItem smModUsuarios;
    public static javax.swing.JMenuItem smModUsuariosD;
    // End of variables declaration//GEN-END:variables
}
