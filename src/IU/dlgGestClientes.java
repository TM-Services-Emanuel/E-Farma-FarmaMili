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
    }

    public void nuevo() {
        limpiarCampos();
        cargarComboBox.cargar(cbCiudad, "SELECT * FROM ciudad WHERE ciu_indicador='S'");
        String cod = GestionarCliente.getCodigo();
        lblCodC.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
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
    }

    void cancelar() {
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
        txtLimite.setEnabled(false);
        chbContado.setEnabled(false);
        chbCredito.setEnabled(false);
        chbCredito.setSelected(false);
        btnNuevo.requestFocus();
        actualizartablaClientes();
        this.dispose();
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
        lblCodC = new rojeru_san.rsfield.RSTextMaterial();
        cbCiudad = new RSMaterialComponent.RSComboBoxMaterial();
        txtRazonS = new rojeru_san.rsfield.RSTextMaterial();
        txtRuc = new rojeru_san.rsfield.RSTextMaterial();
        txtDireccion = new rojeru_san.rsfield.RSTextMaterial();
        txtTelefono = new rojeru_san.rsfield.RSTextMaterial();
        txtCelular = new rojeru_san.rsfield.RSTextMaterial();
        txtContacto = new rojeru_san.rsfield.RSTextMaterial();
        btnEntrar = new RSMaterialComponent.RSButtonIconUno();
        pnFacturacion = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        chbCredito = new rojerusan.RSCheckBox();
        chbContado = new rojerusan.RSCheckBox();
        txtLimite = new rojeru_san.rsfield.RSTextMaterial();
        pnObservacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaS = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
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
        lbCiudad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setForeground(new java.awt.Color(0, 153, 204));
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
        pnDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("ID CLIENTE");
        pnDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 90, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("RAZÓN SOCIAL");
        pnDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 45, 90, 23));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("CONTACTO");
        pnDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 181, 90, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("DIRECCIÓN");
        pnDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 111, 90, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("CIUDAD");
        pnDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 16, -1, 22));

        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.setFocusPainted(false);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });
        pnDatos.add(btnCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 16, 30, 22));
        btnCiudad.getAccessibleContext().setAccessibleDescription("");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("CELULAR");
        pnDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 60, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("TELÉFONO");
        pnDatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 147, 90, 23));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("C.I o R.U.C.   ");
        pnDatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 78, 90, 23));

        lblCodC.setEditable(false);
        lblCodC.setBackground(new java.awt.Color(255, 255, 255));
        lblCodC.setForeground(new java.awt.Color(0, 0, 0));
        lblCodC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblCodC.setColorMaterial(new java.awt.Color(255, 102, 0));
        lblCodC.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        lblCodC.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblCodC.setPlaceholder("");
        lblCodC.setSelectionColor(new java.awt.Color(86, 86, 86));
        lblCodC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCodCActionPerformed(evt);
            }
        });
        pnDatos.add(lblCodC, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 16, 75, 23));

        cbCiudad.setBorder(null);
        cbCiudad.setColorMaterial(new java.awt.Color(255, 102, 0));
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
        pnDatos.add(cbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 16, 250, 23));

        txtRazonS.setForeground(new java.awt.Color(0, 0, 0));
        txtRazonS.setColorMaterial(new java.awt.Color(255, 102, 0));
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
        pnDatos.add(txtRazonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 45, 410, 23));

        txtRuc.setForeground(new java.awt.Color(0, 0, 0));
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setColorMaterial(new java.awt.Color(255, 102, 0));
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
        pnDatos.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 78, 150, 23));

        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccion.setColorMaterial(new java.awt.Color(255, 102, 0));
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
        pnDatos.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 111, 410, 23));

        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setColorMaterial(new java.awt.Color(255, 102, 0));
        txtTelefono.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtTelefono.setPlaceholder("05XX - XX XX XX");
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
        pnDatos.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 147, 150, 23));

        txtCelular.setForeground(new java.awt.Color(0, 0, 0));
        txtCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCelular.setColorMaterial(new java.awt.Color(255, 102, 0));
        txtCelular.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtCelular.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCelular.setPlaceholder("09XX - XXX XXX");
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
        pnDatos.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 147, 150, 23));

        txtContacto.setForeground(new java.awt.Color(0, 0, 0));
        txtContacto.setColorMaterial(new java.awt.Color(255, 102, 0));
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
        pnDatos.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 180, 410, 23));

        btnEntrar.setBackground(new java.awt.Color(0, 153, 204));
        btnEntrar.setBackgroundHover(new java.awt.Color(255, 102, 0));
        btnEntrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnEntrar.setRippleColor(java.awt.Color.white);
        btnEntrar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        pnDatos.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 78, 23, 23));

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
        pnFacturacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel8.setText("MONTO DISPONIBLE");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 32, -1, 23));

        chbCredito.setForeground(new java.awt.Color(0, 0, 0));
        chbCredito.setText("HABILITADO PARA VENTA CRÉDITO");
        chbCredito.setColorCheck(new java.awt.Color(255, 102, 0));
        chbCredito.setColorUnCheck(new java.awt.Color(102, 102, 102));
        chbCredito.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        chbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCreditoActionPerformed(evt);
            }
        });
        jPanel4.add(chbCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 32, 227, 23));

        chbContado.setForeground(new java.awt.Color(0, 0, 0));
        chbContado.setSelected(true);
        chbContado.setText("HABILITADO PARA VENTA CONTADO");
        chbContado.setColorCheck(new java.awt.Color(255, 102, 0));
        chbContado.setColorUnCheck(new java.awt.Color(102, 102, 102));
        chbContado.setEnabled(false);
        chbContado.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
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
        jPanel4.add(txtLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 33, 130, 23));

        pnFacturacion.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, 549, 63));

        contenedor.addTab("CONFIGURAR OPCIÓN DE FACTURACIÓN", pnFacturacion);

        pnObservacion.setBackground(new java.awt.Color(255, 255, 255));
        pnObservacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnObservacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txaS.setColumns(20);
        txaS.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txaS.setRows(5);
        txaS.setBorder(null);
        txaS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaSKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaS);

        pnObservacion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 572, 210));

        contenedor.addTab("OBSERVACIONES", pnObservacion);

        jPanel2.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 580, 242));
        contenedor.getAccessibleContext().setAccessibleName("");

        jPanel5.setBackground(new java.awt.Color(17, 35, 46));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(lbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 24, 22));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 597, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

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
                    controlCliente.actCliente();
                    cancelar();
                }
            } catch (HeadlessException ee) {
                System.out.println("Error modificando cliente: " + ee.getMessage());
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
                    String cod = GestionarCliente.getCodigo();
                    lblCodC.setText(cod);
                    controlCliente.addCliente();
                    cancelar();
                }

            } catch (HeadlessException ee) {
                System.out.println("Error guardando cliente: " + ee.getMessage());
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cancelar y salir el formulario ABM?");
        if (rpta == 0) {
            cancelar();
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        if (txtRuc.getText().trim().isEmpty()) {
            txtRuc.requestFocus();
        } else {
            BuscarRUC2();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    public void limpiarCampos() {
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
        CabecerasTablas.cliente(dlgClientes.tablaClientes);
        CabecerasTablas.limpiarTablaCliente(dlgClientes.tablaClientes);
        controlCliente.listClientes(dlgClientes.tablaClientes, "clientes.cli_codigo");
        dlgClientes.Renders();
        dlgClientes.txtBuscar.setText("");
        dlgClientes.txtBuscar.requestFocus();
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
    private RSMaterialComponent.RSButtonIconUno btnEntrar;
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    public static RSMaterialComponent.RSButtonIconUno btnModificar;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    public static RSMaterialComponent.RSComboBoxMaterial cbCiudad;
    public static rojerusan.RSCheckBox chbContado;
    public static rojerusan.RSCheckBox chbCredito;
    public static javax.swing.JTabbedPane contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbCiudad;
    public static rojeru_san.rsfield.RSTextMaterial lblCodC;
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
