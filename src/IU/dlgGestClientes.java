package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlCliente;
import Datos.GestionarCliente;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public final class dlgGestClientes extends javax.swing.JDialog {

    static DataSourceService dss = new DataSourceService();

    public dlgGestClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboBox.cargar(cbCiudad, "SELECT * FROM ciudad WHERE ciu_indicador='S'");
        cargarIcono();
        lbCiudad.setVisible(false);
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        btnNuevo.doClick();
    }

    public static void BuscarRUC() {
        String ruc = dlgClientes.txtBuscar.getText().trim();
        if (!ruc.isEmpty()) {
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM clientesbd WHERE cedula Like '" + ruc + "%'")) {
                rs.last();
                dlgGestClientes.txtRazonS.setText(rs.getString("nombre"));
                dlgGestClientes.txtRuc.setText(rs.getString("cedula"));
                dlgGestClientes.txtDireccion.setText("SIN ESPECIFICAR");
                dlgGestClientes.txtTelefono.setText("0");
                dlgGestClientes.txtCelular.setText("0");
                dlgGestClientes.txtContacto.setText("SIN ESPECIFICAR");
                dlgGestClientes.cbCiudad.setSelectedIndex(1);
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                Mensajes.informacion("OBSERVACIÓN:\nLamentablemete no se ha encontrado coincidencia en el registro externo de clientes.");
                dlgGestClientes.txtRuc.setText(ruc);
                dlgGestClientes.txtDireccion.setText("SIN ESPECIFICAR");
                dlgGestClientes.txtTelefono.setText("0");
                dlgGestClientes.txtCelular.setText("0");
                dlgGestClientes.txtContacto.setText("SIN ESPECIFICAR");
                dlgGestClientes.cbCiudad.setSelectedIndex(1);
            }
        }
    }

    public static void BuscarRUC2() {
        String ruc = txtRuc.getText().trim();
        if (!ruc.isEmpty()) {
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM clientesbd WHERE cedula Like '" + ruc + "%'")) {
                rs.last();
                dlgGestClientes.txtRazonS.setText(rs.getString("nombre"));
                dlgGestClientes.txtRuc.setText(rs.getString("cedula"));
                dlgGestClientes.txtDireccion.setText("SIN ESPECIFICAR");
                dlgGestClientes.txtTelefono.setText("0");
                dlgGestClientes.txtCelular.setText("0");
                dlgGestClientes.txtContacto.setText("SIN ESPECIFICAR");
                dlgGestClientes.cbCiudad.setSelectedIndex(1);
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                Mensajes.informacion("OBSERVACIÓN:\nLamentablemete no se ha encontrado coincidencia en el registro externo de clientes.");
                dlgGestClientes.txtRuc.setText(ruc);
                dlgGestClientes.txtDireccion.setText("SIN ESPECIFICAR");
                dlgGestClientes.txtTelefono.setText("0");
                dlgGestClientes.txtCelular.setText("0");
                dlgGestClientes.txtContacto.setText("SIN ESPECIFICAR");
                dlgGestClientes.cbCiudad.setSelectedIndex(1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        lbCiudad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        contenedor = new javax.swing.JTabbedPane();
        pnDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCiudad = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        lblCodC = new rojeru_san.rsfield.RSTextMaterial();
        cbCiudad = new RSMaterialComponent.RSComboBoxMaterial();
        txtRazonS = new rojeru_san.rsfield.RSTextMaterial();
        txtRuc = new rojeru_san.rsfield.RSTextMaterial();
        txtDireccion = new rojeru_san.rsfield.RSTextMaterial();
        txtTelefono = new rojeru_san.rsfield.RSTextMaterial();
        txtCelular = new rojeru_san.rsfield.RSTextMaterial();
        txtContacto = new rojeru_san.rsfield.RSTextMaterial();
        btnEntrar1 = new newscomponents.RSButtonGradientIcon_new();
        pnFacturacion = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        chbCredito = new rojerusan.RSCheckBox();
        chbContado = new rojerusan.RSCheckBox();
        txtLimite = new rojeru_san.rsfield.RSTextMaterial();
        c5 = new javax.swing.JLabel();
        pnObservacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaS = new javax.swing.JTextArea();
        lbm = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new java.awt.GridLayout(1, 5));

        btnNuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevo.setBorder(null);
        btnNuevo.setText("NUEVO");
        btnNuevo.setBgHover(new java.awt.Color(57, 57, 57));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevo.setPixels(0);
        btnNuevo.setSizeIcon(50.0F);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(102, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("MODIFICAR");
        btnModificar.setBgHover(new java.awt.Color(57, 57, 57));
        btnModificar.setEnabled(false);
        btnModificar.setFocusPainted(false);
        btnModificar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnModificar.setIconTextGap(0);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setPixels(0);
        btnModificar.setSizeIcon(50.0F);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBgHover(new java.awt.Color(57, 57, 57));
        btnGuardar.setEnabled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setPixels(0);
        btnGuardar.setSizeIcon(50.0F);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setBorder(null);
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBgHover(new java.awt.Color(57, 57, 57));
        btnCancelar.setEnabled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setPixels(0);
        btnCancelar.setSizeIcon(50.0F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setBorder(null);
        btnSalir.setText("SALIR");
        btnSalir.setBgHover(new java.awt.Color(57, 57, 57));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir.setIconTextGap(0);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnSalir.setPixels(0);
        btnSalir.setSizeIcon(50.0F);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);

        lbCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        contenedor.setForeground(new java.awt.Color(17, 35, 46));
        contenedor.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        contenedor.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        pnDatos.setBackground(new java.awt.Color(255, 255, 255));
        pnDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnDatos.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        pnDatos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnDatosFocusGained(evt);
            }
        });

        jLabel1.setText("ID CLIENTE");

        jLabel2.setText("RAZÓN SOCIAL");

        jLabel3.setText("CONTACTO");

        jLabel4.setText("DIRECCIÓN");

        jLabel5.setText("Ciudad");

        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnCiudad.setToolTipText("Gestionar Ciudad");
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });

        jLabel6.setText("CELULAR");

        jLabel7.setText("TELÉFONO");

        jLabel11.setText("C.I o R.U.C.   ");

        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_warning_black_18.png"))); // NOI18N

        c2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_warning_black_18.png"))); // NOI18N

        c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_warning_black_18.png"))); // NOI18N

        c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_warning_black_18.png"))); // NOI18N

        lblCodC.setEditable(false);
        lblCodC.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC.setForeground(new java.awt.Color(0, 0, 0));
        lblCodC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblCodC.setColorMaterial(new java.awt.Color(102, 102, 102));
        lblCodC.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        lblCodC.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblCodC.setPlaceholder("");
        lblCodC.setSelectionColor(new java.awt.Color(86, 86, 86));
        lblCodC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCodCActionPerformed(evt);
            }
        });

        cbCiudad.setBorder(null);
        cbCiudad.setColorMaterial(new java.awt.Color(102, 102, 102));
        cbCiudad.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
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

        txtRazonS.setForeground(new java.awt.Color(0, 0, 0));
        txtRazonS.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtRazonS.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtRazonS.setPlaceholder("ESCRIBE AQUI ...");
        txtRazonS.setSelectionColor(new java.awt.Color(86, 86, 86));
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

        txtRuc.setForeground(new java.awt.Color(0, 0, 0));
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtRuc.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtRuc.setPlaceholder("ESCRIBE AQUI ...");
        txtRuc.setSelectionColor(new java.awt.Color(86, 86, 86));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccion.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtDireccion.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("ESCRIBE AQUI ...");
        txtDireccion.setSelectionColor(new java.awt.Color(86, 86, 86));
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

        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtTelefono.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtTelefono.setPlaceholder("ESCRIBE AQUI ...");
        txtTelefono.setSelectionColor(new java.awt.Color(86, 86, 86));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtCelular.setForeground(new java.awt.Color(0, 0, 0));
        txtCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCelular.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtCelular.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtCelular.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCelular.setPlaceholder("ESCRIBE AQUI ...");
        txtCelular.setSelectionColor(new java.awt.Color(86, 86, 86));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        txtContacto.setForeground(new java.awt.Color(0, 0, 0));
        txtContacto.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtContacto.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtContacto.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtContacto.setPlaceholder("ESCRIBE AQUI ...");
        txtContacto.setSelectionColor(new java.awt.Color(86, 86, 86));
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

        btnEntrar1.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar1.setText("BUSCAR COINCIDENCIA EN BD");
        btnEntrar1.setColorPrimario(new java.awt.Color(17, 35, 46));
        btnEntrar1.setColorPrimarioHover(new java.awt.Color(63, 74, 80));
        btnEntrar1.setColorSecundario(new java.awt.Color(63, 74, 80));
        btnEntrar1.setColorSecundarioHover(new java.awt.Color(17, 35, 46));
        btnEntrar1.setFocusPainted(false);
        btnEntrar1.setFont(new java.awt.Font("Roboto Bold", 1, 11)); // NOI18N
        btnEntrar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnEntrar1.setPreferredSize(new java.awt.Dimension(200, 35));
        btnEntrar1.setRequestFocusEnabled(false);
        btnEntrar1.setSizeIcon(20.0F);
        btnEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDatosLayout = new javax.swing.GroupLayout(pnDatos);
        pnDatos.setLayout(pnDatosLayout);
        pnDatosLayout.setHorizontalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnDatosLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEntrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnDatosLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(lblCodC, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5)
                                .addGap(14, 14, 14)
                                .addComponent(cbCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnDatosLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtRazonS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnDatosLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnDatosLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        pnDatosLayout.setVerticalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(lblCodC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(c2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addComponent(btnEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnCiudad.getAccessibleContext().setAccessibleDescription("");

        contenedor.addTab("DATOS PERSONALES", pnDatos);

        pnFacturacion.setBackground(new java.awt.Color(255, 255, 255));
        pnFacturacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnFacturacionMouseClicked(evt);
            }
        });
        pnFacturacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnFacturacionKeyPressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 11)); // NOI18N
        jLabel8.setText("MONTO DISPONIBLE");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 32, -1, 24));

        chbCredito.setForeground(new java.awt.Color(0, 0, 0));
        chbCredito.setText("HABILITADO PARA VENTA CRÉDITO");
        chbCredito.setColorCheck(new java.awt.Color(204, 0, 0));
        chbCredito.setColorUnCheck(new java.awt.Color(102, 102, 102));
        chbCredito.setFont(new java.awt.Font("Roboto Black", 0, 11)); // NOI18N
        chbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCreditoActionPerformed(evt);
            }
        });
        jPanel4.add(chbCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 32, 227, 24));

        chbContado.setForeground(new java.awt.Color(0, 0, 0));
        chbContado.setSelected(true);
        chbContado.setText("HABILITADO PARA VENTA CONTADO");
        chbContado.setColorCheck(new java.awt.Color(204, 0, 0));
        chbContado.setColorUnCheck(new java.awt.Color(102, 102, 102));
        chbContado.setEnabled(false);
        chbContado.setFont(new java.awt.Font("Roboto Black", 0, 11)); // NOI18N
        jPanel4.add(chbContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 227, 23));

        txtLimite.setForeground(new java.awt.Color(0, 0, 0));
        txtLimite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimite.setText("0");
        txtLimite.setColorMaterial(new java.awt.Color(102, 102, 102));
        txtLimite.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtLimite.setEnabled(false);
        txtLimite.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtLimite.setPlaceholder("ESCRIBE AQUI ...");
        txtLimite.setSelectionColor(new java.awt.Color(86, 86, 86));
        txtLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimiteActionPerformed(evt);
            }
        });
        txtLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLimiteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLimiteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLimiteKeyTyped(evt);
            }
        });
        jPanel4.add(txtLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 33, 103, 22));

        c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_warning_black_18.png"))); // NOI18N
        jPanel4.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 32, -1, 24));

        javax.swing.GroupLayout pnFacturacionLayout = new javax.swing.GroupLayout(pnFacturacion);
        pnFacturacion.setLayout(pnFacturacionLayout);
        pnFacturacionLayout.setHorizontalGroup(
            pnFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnFacturacionLayout.setVerticalGroup(
            pnFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        contenedor.addTab("CONFIGURAR OPCIÓN DE FACTURACIÓN", pnFacturacion);

        pnObservacion.setBackground(new java.awt.Color(255, 255, 255));
        pnObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txaS.setColumns(20);
        txaS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txaS.setRows(5);
        txaS.setBorder(null);
        txaS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaSKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaS);

        javax.swing.GroupLayout pnObservacionLayout = new javax.swing.GroupLayout(pnObservacion);
        pnObservacion.setLayout(pnObservacionLayout);
        pnObservacionLayout.setHorizontalGroup(
            pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnObservacionLayout.setVerticalGroup(
            pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        contenedor.addTab("OBSERVACIONES", pnObservacion);

        lbm.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contenedor)
                    .addComponent(lbm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        contenedor.getAccessibleContext().setAccessibleName("DATOS");

        barMenu.setBackground(new java.awt.Color(255, 255, 255));
        barMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setBackground(new java.awt.Color(255, 255, 255));
        menuOpciones.setBorder(null);
        menuOpciones.setText("OPCIONES");
        menuOpciones.setFocusable(false);
        menuOpciones.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        menuOpciones.setOpaque(true);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setBackground(new java.awt.Color(255, 255, 255));
        itemNuevo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_box_black_24.png"))); // NOI18N
        itemNuevo.setText("NUEVO                                                                      ");
        itemNuevo.setBorder(null);
        itemNuevo.setOpaque(true);
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuOpciones.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setBackground(new java.awt.Color(255, 255, 255));
        itemModificar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_black_24.png"))); // NOI18N
        itemModificar.setText("MODIFICAR");
        itemModificar.setBorder(null);
        itemModificar.setEnabled(false);
        itemModificar.setOpaque(true);
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemModificar);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setBackground(new java.awt.Color(255, 255, 255));
        itemGuardar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_save_black_24.png"))); // NOI18N
        itemGuardar.setText("GUARDAR");
        itemGuardar.setBorder(null);
        itemGuardar.setEnabled(false);
        itemGuardar.setOpaque(true);
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemGuardar);

        itemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelar.setBackground(new java.awt.Color(255, 255, 255));
        itemCancelar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_cancel_black_24.png"))); // NOI18N
        itemCancelar.setText("CANCELAR");
        itemCancelar.setBorder(null);
        itemCancelar.setEnabled(false);
        itemCancelar.setOpaque(true);
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemCancelar);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOpaque(true);
        menuOpciones.add(jSeparator1);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setBackground(new java.awt.Color(255, 255, 255));
        itemSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_exit_to_app_black_24.png"))); // NOI18N
        itemSalir.setText("SALIR");
        itemSalir.setBorder(null);
        itemSalir.setOpaque(true);
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(itemSalir);

        barMenu.add(menuOpciones);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        btnGuardarActionPerformed(null);
    }//GEN-LAST:event_itemGuardarActionPerformed

    private void itemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_itemCancelarActionPerformed

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

    private void pnFacturacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnFacturacionKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_pnFacturacionKeyPressed

    private void pnFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnFacturacionMouseClicked
        // TODO add your handling code here:
        System.out.println(evt.getButton());
    }//GEN-LAST:event_pnFacturacionMouseClicked

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        // TODO add your handling code here:
        dlgCiudad pro = new dlgCiudad(null, true);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);
    }//GEN-LAST:event_btnCiudadActionPerformed

    private void pnDatosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnDatosFocusGained
        // TODO add your handling code here:
        txtRazonS.requestFocus();
    }//GEN-LAST:event_pnDatosFocusGained

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        cargarComboBox.cargar(cbCiudad, "SELECT * FROM ciudad WHERE ciu_indicador='S'");
        String cod = GestionarCliente.getCodigo();
        lblCodC.setText(cod);
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        btnCiudad.setEnabled(true);
        txtRazonS.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtContacto.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txaS.setEnabled(true);
        cbCiudad.setEnabled(true);
        //chbContado.setEnabled(true);
        chbCredito.setEnabled(true);
        contenedor.setSelectedIndex(0);
        cbCiudad.requestFocus();
        BuscarRUC();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        if (validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(txtRuc) && validarCampos.estaVacio(txtDireccion) && validarCampos.estaVacio(txtCelular)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlCliente.actCliente();
                    actualizartablaClientes();
                    this.dispose();
                }
            } catch (Exception ee) {
            }
        } else {
            lbm.setText("Campo Obligatorio");
            if (txtRazonS.getText().equals("")) {
                txtRazonS.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtRuc.getText().equals("")) {
                txtRuc.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtDireccion.getText().trim() == null) {
                txtDireccion.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtCelular.getText().trim() == null) {
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
                c5.setVisible(false);
            } else if (txtLimite.getText().trim() == null) {
                contenedor.setSelectedIndex(1);
                txtLimite.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        if (cbCiudad.getSelectedIndex() == 0) {
            lbm.setText("Seleccion Obligatoria");
            cbCiudad.requestFocus();
        } else if (validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(txtRuc) && validarCampos.estaVacio(txtDireccion) && validarCampos.estaVacio(txtCelular) && validarCampos.estaVacio(txtLimite)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarCliente.getCodigo();
                    lblCodC.setText(cod);
                    controlCliente.addCliente();
                    actualizartablaClientes();
                    btnCancelarActionPerformed(null);
                }

            } catch (HeadlessException ee) {
            }

        } else {
            lbm.setText("Campo Obligatorio");
            if (txtRazonS.getText().equals("")) {
                txtRazonS.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtRuc.getText().equals("")) {
                txtRuc.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtDireccion.getText().equals("")) {
                txtDireccion.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
                c5.setVisible(false);
            } else if (txtCelular.getText().equals("")) {
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
                c5.setVisible(false);
            } else if (txtLimite.getText().equals("")) {
                txtLimite.requestFocus();
                contenedor.setSelectedComponent(pnFacturacion);
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            actualizartablaClientes();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        btnNuevo.setEnabled(true);
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        btnCiudad.setEnabled(false);
        txtRazonS.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtContacto.setEnabled(false);
        cbCiudad.setEnabled(false);
        txtRuc.setEnabled(false);
        txaS.setEnabled(false);
        txtLimite.setEnabled(false);
        chbContado.setEnabled(false);
        chbCredito.setEnabled(false);
        chbCredito.setSelected(false);
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        btnNuevo.requestFocus();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lblCodCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCodCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCodCActionPerformed

    private void cbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiudadActionPerformed
        // TODO add your handling code here:
        if (cbCiudad.getSelectedIndex() > 0) {
            String id = cargarComboBox.getCodidgo(cbCiudad);
            lbCiudad.setText(id);
        } else {
            lbCiudad.setText("");
        }

    }//GEN-LAST:event_cbCiudadActionPerformed

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

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtRazonS);
        validarCampos.cantCaracteres(txtRazonS, 50);
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

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

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 50);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtCelular.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

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
        txtContacto.requestFocus();
    }//GEN-LAST:event_txtCelularActionPerformed

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

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
        contenedor.setSelectedComponent(pnFacturacion);
        chbCredito.requestFocus();
    }//GEN-LAST:event_txtContactoActionPerformed

    private void txtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtContacto);
        validarCampos.cantCaracteres(txtContacto, 30);
    }//GEN-LAST:event_txtContactoKeyPressed

    private void txtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtContactoKeyTyped

    private void chbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCreditoActionPerformed
        // TODO add your handling code here:
        if (chbCredito.isSelected()) {
            txtLimite.setEnabled(true);
            txtLimite.requestFocus();
        } else {
            txtLimite.setEnabled(false);
        }
    }//GEN-LAST:event_chbCreditoActionPerformed

    private void txtLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLimiteActionPerformed

    private void txtLimiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLimiteKeyTyped

    private void txtLimiteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtLimite);
        int limite = 8;
        if (txtLimite.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLimiteKeyPressed

    private void txtLimiteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyReleased
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtLimite.getText()) < 0) {
                txtLimite.setText("0");
            }
        } catch (NumberFormatException e) {
        }

        DecimalFormat df = new DecimalFormat("#,###");

        if (txtLimite.getText().trim().length() >= 1) {

            txtLimite.setText(df.format(Integer.valueOf(txtLimite.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtLimiteKeyReleased

    private void btnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrar1ActionPerformed
        // TODO add your handling code here:
        if (txtRuc.getText().trim().isEmpty()) {
            txtRuc.requestFocus();
        } else {
            BuscarRUC2();
        }
    }//GEN-LAST:event_btnEntrar1ActionPerformed

    void limpiarCampos() {
        lblCodC.setText("");
        lbCiudad.setText("");
        txtRazonS.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtContacto.setText("");
        txtCelular.setText("");
        txtTelefono.setText("");
        cbCiudad.list();
        txaS.setText("");
        txtLimite.setText("0");
    }

    void actualizartablaClientes() {
        CabecerasTablas cabe = new CabecerasTablas();
        cabe.cliente(dlgClientes.tablaClientes);
        CabecerasTablas.limpiarTablas(dlgClientes.tablaClientes);
        controlCliente.listClientes(dlgClientes.tablaClientes, "clientes.cli_codigo");
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
            java.util.logging.Logger.getLogger(dlgGestClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestClientes dialog = new dlgGestClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenuBar barMenu;
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    private javax.swing.JButton btnCiudad;
    public static newscomponents.RSButtonGradientIcon_new btnEntrar1;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    private newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    public static RSMaterialComponent.RSComboBoxMaterial cbCiudad;
    public static rojerusan.RSCheckBox chbContado;
    public static rojerusan.RSCheckBox chbCredito;
    private javax.swing.JTabbedPane contenedor;
    public static javax.swing.JMenuItem itemCancelar;
    public static javax.swing.JMenuItem itemGuardar;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public static javax.swing.JLabel lbCiudad;
    public static rojeru_san.rsfield.RSTextMaterial lblCodC;
    private javax.swing.JLabel lbm;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JPanel pnDatos;
    private javax.swing.JPanel pnFacturacion;
    private javax.swing.JPanel pnObservacion;
    public static javax.swing.JTextArea txaS;
    public static rojeru_san.rsfield.RSTextMaterial txtCelular;
    public static rojeru_san.rsfield.RSTextMaterial txtContacto;
    public static rojeru_san.rsfield.RSTextMaterial txtDireccion;
    public static rojeru_san.rsfield.RSTextMaterial txtLimite;
    public static rojeru_san.rsfield.RSTextMaterial txtRazonS;
    public static rojeru_san.rsfield.RSTextMaterial txtRuc;
    public static rojeru_san.rsfield.RSTextMaterial txtTelefono;
    // End of variables declaration//GEN-END:variables
}
