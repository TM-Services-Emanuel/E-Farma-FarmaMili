package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlProveedor;
import Datos.GestionarProveedor;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.*;

public final class dlgGestProveedor extends javax.swing.JDialog {

    static DataSourceService dss = new DataSourceService();

    public dlgGestProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarIcono();
        lbCiudad.setVisible(false);
    }

    public void Nuevo() {
        btnNuevoActionPerformed(null);
    }

    private void Cancelar() {
        limpiarCampos();
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCiudad.setEnabled(false);
        txtRazonS.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtContacto.setEnabled(false);
        cbCiudad.setEnabled(false);
        txtRuc.setEnabled(false);
        txaS.setEnabled(false);
        btnNuevo.requestFocus();
        actualizartablaProveedores();
        this.dispose();
    }

    public void modcbCiudad() {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        String sqlLabs = "SELECT * FROM ciudad WHERE ciu_indicador='S'";
        String sqlLabEsp = "SELECT * FROM ciudad WHERE ciu_codigo=" + lbCiudad.getText().trim();
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlLabs); ResultSet rss = st.executeQuery(sqlLabEsp)) {
            ml.addElement("SELEC. UNA OPCIÓN");
            while (rs.next()) {
                ml.addElement(rs.getString("ciu_nombre"));
            }
            rss.first();
            Object descripcion = (Object) rss.getString("ciu_nombre");
            dlgGestProveedor.cbCiudad.setModel(ml);
            dlgGestProveedor.cbCiudad.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            st.close();
            cn.close();
        } catch (SQLException ew) {
            System.out.println("Error combomod ciudad: " + ew.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        PnlNuevo = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PnlModificar = new rojeru_san.rspanel.RSPanelImage();
        btnModificar = new RSMaterialComponent.RSButtonIconUno();
        Separador2 = new javax.swing.JSeparator();
        LabelTitulo2 = new javax.swing.JLabel();
        PnlGuardar = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        PnlCancelar = new rojeru_san.rspanel.RSPanelImage();
        btnCancelar = new RSMaterialComponent.RSButtonIconUno();
        Separador4 = new javax.swing.JSeparator();
        LabelTitulo4 = new javax.swing.JLabel();
        lbCiudad = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox();
        btnCiudad = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaS = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(17, 35, 46));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 102, 0));
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
        PnlNuevo.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador1.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("NUEVO");
        PnlNuevo.add(LabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel6.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlModificar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setBackground(new java.awt.Color(255, 102, 0));
        btnModificar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnModificar.setEnabled(false);
        btnModificar.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setRippleColor(java.awt.Color.white);
        btnModificar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        PnlModificar.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador2.setForeground(new java.awt.Color(204, 204, 204));
        PnlModificar.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo2.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo2.setText("MODIFICAR");
        PnlModificar.add(LabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel6.add(PnlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlGuardar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setEnabled(false);
        btnGuardar.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRippleColor(java.awt.Color.white);
        btnGuardar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PnlGuardar.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador3.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("REGISTRAR");
        PnlGuardar.add(LabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel6.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        PnlCancelar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCancelar.setEnabled(false);
        btnCancelar.setForegroundHover(new java.awt.Color(153, 0, 51));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setRippleColor(java.awt.Color.white);
        btnCancelar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        PnlCancelar.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador4.setForeground(new java.awt.Color(204, 204, 204));
        PnlCancelar.add(Separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo4.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo4.setText("CANCELAR");
        PnlCancelar.add(LabelTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel6.add(PnlCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, 100));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));
        jPanel4.add(lbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 39, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 597, 105));

        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 204));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("ID PROVEEDOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 90, 23));

        lblCodP.setBackground(new java.awt.Color(255, 255, 255));
        lblCodP.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblCodP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblCodP.setOpaque(true);
        jPanel1.add(lblCodP, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 16, 75, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("RAZÓN SOCIAL");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 90, 23));

        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSKeyTyped(evt);
            }
        });
        jPanel1.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 45, 410, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("CONTACTO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 181, 90, 23));

        txtContacto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        txtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactoKeyTyped(evt);
            }
        });
        jPanel1.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 180, 410, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("DIRECCIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 111, 90, 23));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 111, 410, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Ciudad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 16, -1, 22));

        cbCiudad.setBackground(new java.awt.Color(255, 255, 204));
        cbCiudad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        cbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiudadActionPerformed(evt);
            }
        });
        cbCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCiudadKeyPressed(evt);
            }
        });
        jPanel1.add(cbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 16, 250, 23));

        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnCiudad.setToolTipText("Gestionar Ciudad");
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(btnCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 16, 30, 22));
        btnCiudad.getAccessibleContext().setAccessibleDescription("");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CELULAR");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 60, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("TELÉFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 147, 90, 23));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("C.I o R.U.C.   ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 90, 23));

        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 78, 120, 23));

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 147, 150, 23));

        txtCelular.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 147, 150, 23));

        jTabbedPane1.addTab("DATOS DEL PROVEEDOR", jPanel1);

        txaS.setColumns(20);
        txaS.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txaS.setRows(5);
        txaS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaSKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("OBSERVACIONES", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 580, 242));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        // TODO add your handling code here:
        dlgCiudad pro = new dlgCiudad(null, true);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);
    }//GEN-LAST:event_btnCiudadActionPerformed

    private void txtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtContacto);
        validarCampos.cantCaracteres(txtContacto, 29);
    }//GEN-LAST:event_txtContactoKeyPressed

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtRazonS);
        validarCampos.cantCaracteres(txtRazonS, 49);
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void cbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiudadActionPerformed
        // TODO add your handling code here:
        /*if (cbCiudad.getSelectedIndex() == 0) {
            lbCiudad.setText("");
        } else {
            String id = cargarComboBox.getCodidgo(cbCiudad);
            lbCiudad.setText(id);
        }*/
    }//GEN-LAST:event_cbCiudadActionPerformed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 49);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtRazonS.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtDireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 49;
        if (txtContacto.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContactoKeyTyped

    private void txaSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txaS.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txaSKeyTyped

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 11;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtRuc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtContacto.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 15;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtTelefono.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
        if (!btnGuardar.isEnabled()) {
            btnModificar.doClick();
        } else {
            btnGuardar.doClick();
        }
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 15;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtCelular.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void cbCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCiudadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRazonS.requestFocus();
        }
    }//GEN-LAST:event_cbCiudadKeyPressed

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
        txtRuc.requestFocus();
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
        txtCelular.requestFocus();
    }//GEN-LAST:event_txtContactoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        cargarComboBox.cargar(cbCiudad, "SELECT * FROM ciudad WHERE ciu_indicador='S'");
        limpiarCampos();
        String cod = GestionarProveedor.getCodigo();
        lblCodP.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnCiudad.setEnabled(true);
        txtRazonS.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtContacto.setEnabled(true);
        txtCelular.setEnabled(true);
        txaS.setEnabled(true);
        cbCiudad.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (cbCiudad.getSelectedIndex() == 0) {
            Mensajes.Sistema("La ciudad no ha sido seleccionado.");
            cbCiudad.setPopupVisible(true);
            cbCiudad.requestFocus();
        } else if (txtRazonS.getText().isEmpty()) {
            Mensajes.Sistema("El campo Razón Social se encuentra vacio.\nComplete esta información para continuar con el proceso de modificación.");
            txtRazonS.requestFocus();
        } else if (txtRuc.getText().isEmpty()) {
            Mensajes.Sistema("El campo RUC se encuentra vacio.\nComplete esta información para continuar con el proceso de modificación.");
            txtRuc.requestFocus();
        } else if (txtDireccion.getText().isEmpty()) {
            Mensajes.Sistema("El campo Dirección se encuentra vacio.\nComplete esta información para continuar con el proceso de modificación.");
            txtDireccion.requestFocus();
        } else if (txtTelefono.getText().isEmpty()) {
            Mensajes.Sistema("El campo Teléfono se encuentra vacio.\nComplete esta información para continuar con el proceso de modificación.");
            txtTelefono.requestFocus();
        } else if (txtCelular.getText().isEmpty()) {
            Mensajes.Sistema("El campo Celular se encuentra vacio.\nComplete esta información para continuar con el proceso de modificación.");
            txtCelular.requestFocus();
        } else if (txtContacto.getText().isEmpty()) {
            Mensajes.Sistema("El campo Contacto se encuentra vacio.\nComplete esta información para continuar con el proceso de modificación.");
            txtContacto.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlProveedor.actProveedor();
                    Cancelar();
                    this.dispose();
                }
            } catch (Exception ee) {
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (cbCiudad.getSelectedIndex() == 0) {
            Mensajes.Sistema("La ciudad no ha sido seleccionado.");
            cbCiudad.setPopupVisible(true);
            cbCiudad.requestFocus();
        } else if (txtRazonS.getText().isEmpty()) {
            Mensajes.Sistema("El campo Razón Social se encuentra vacio.\nComplete esta información para continuar con el proceso de registro.");
            txtRazonS.requestFocus();
        } else if (txtRuc.getText().isEmpty()) {
            Mensajes.Sistema("El campo RUC se encuentra vacio.\nComplete esta información para continuar con el proceso de registro.");
            txtRuc.requestFocus();
        } else if (txtDireccion.getText().isEmpty()) {
            Mensajes.Sistema("El campo Dirección se encuentra vacio.\nComplete esta información para continuar con el proceso de registro.");
            txtDireccion.requestFocus();
        } else if (txtTelefono.getText().isEmpty()) {
            Mensajes.Sistema("El campo Teléfono se encuentra vacio.\nComplete esta información para continuar con el proceso de registro.");
            txtTelefono.requestFocus();
        } else if (txtCelular.getText().isEmpty()) {
            Mensajes.Sistema("El campo Celular se encuentra vacio.\nComplete esta información para continuar con el proceso de registro.");
            txtCelular.requestFocus();
        } else if (txtContacto.getText().isEmpty()) {
            Mensajes.Sistema("El campo Contacto se encuentra vacio.\nComplete esta información para continuar con el proceso de registro.");
            txtContacto.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarProveedor.getCodigo();
                    lblCodP.setText(cod);
                    controlProveedor.addProveedor();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cancelar y salir el formulario ABM?");
        if (rpta == 0) {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    void limpiarCampos() {
        lblCodP.setText("");
        lbCiudad.setText("");
        txtRazonS.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtContacto.setText("");
        txtCelular.setText("");
        txtTelefono.setText("");
        cbCiudad.setSelectedIndex(0);
        txaS.setText("");
    }

    void actualizartablaProveedores() {
        CabecerasTablas.proveedor(dlgProveedores.tablaProveedores);
        CabecerasTablas.limpiarTablaProveedor(dlgProveedores.tablaProveedores);
        controlProveedor.listProveedor(dlgProveedores.tablaProveedores, "proveedor.pro_codigo");
        dlgProveedores.txtBuscar.setText("");
        dlgProveedores.txtBuscar.requestFocus();
    }

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }

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
            java.util.logging.Logger.getLogger(dlgGestProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestProveedor dialog = new dlgGestProveedor(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo2;
    private javax.swing.JLabel LabelTitulo3;
    private javax.swing.JLabel LabelTitulo4;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar;
    private rojeru_san.rspanel.RSPanelImage PnlModificar;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JSeparator Separador3;
    private javax.swing.JSeparator Separador4;
    public static RSMaterialComponent.RSButtonIconUno btnCancelar;
    public static javax.swing.JButton btnCiudad;
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    public static RSMaterialComponent.RSButtonIconUno btnModificar;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    public static javax.swing.JComboBox cbCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField lbCiudad;
    public static javax.swing.JLabel lblCodP;
    public static javax.swing.JTextArea txaS;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtContacto;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
