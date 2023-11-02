package IU;

import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlEmpresa;
import Datos.GestionarEmpresa;
import Componentes.validarCampos;
import Controladores.ControlLogeo;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public final class dlgEmpresa extends javax.swing.JDialog {
    private String visual = null;
    private int ban;

    public dlgEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        CabecerasTablas.empresa(tbEmpresa);
        controlEmpresa.lisEmpresa(tbEmpresa);
        tbEmpresa.getTableHeader().setReorderingAllowed(false);
        Visual();
        lbvisual.setVisible(false);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar empresa");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar empresa");
        }
    }

    private void Cancelar() {
        ban = 0;
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSalir.setEnabled(true);
        txtNFantasia.setEnabled(false);
        txtNombre.setEnabled(false);
        txtRuc.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        rbSi.setEnabled(false);
        rbNo.setEnabled(false);
        limpiarCampos();
        tbEmpresa.clearSelection();
        tbEmpresa.setEnabled(true);
        btnNuevo.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpVisual = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
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
        PnlEliminar = new rojeru_san.rspanel.RSPanelImage();
        btnEliminar = new RSMaterialComponent.RSButtonIconUno();
        Separador = new javax.swing.JSeparator();
        LabelTitulo = new javax.swing.JLabel();
        lbvisual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbRuc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbNombre1 = new javax.swing.JLabel();
        txtNFantasia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbSi = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(17, 35, 46));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setRippleColor(java.awt.Color.white);
        btnSalir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 3, 20, 20));

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

        PnlEliminar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnEliminar.setEnabled(false);
        btnEliminar.setForegroundHover(new java.awt.Color(255, 0, 0));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminar.setRippleColor(java.awt.Color.white);
        btnEliminar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PnlEliminar.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador.setForeground(new java.awt.Color(204, 204, 204));
        PnlEliminar.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("ELIMINAR");
        PnlEliminar.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel6.add(PnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 3, 100, 100));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 100));

        lbvisual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(lbvisual, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 25, 18));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 831, 105));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("ID Empresa");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, -1, 23));

        lbNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbNombre.setText("Razón Social");
        jPanel4.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, -1, 23));

        lbRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbRuc.setText("R.U.C.");
        jPanel4.add(lbRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 210, -1, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Dirección");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 240, -1, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Teléfono");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, -1, 23));

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtTelefono.setEnabled(false);
        txtTelefono.setOpaque(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 270, 137, 23));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDireccion.setEnabled(false);
        txtDireccion.setOpaque(false);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 240, 330, 23));

        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRuc.setEnabled(false);
        txtRuc.setOpaque(false);
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
        jPanel4.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 210, 136, 23));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtNombre.setEnabled(false);
        txtNombre.setOpaque(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel4.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 180, 330, 23));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 120, 64, 23));

        txtCelular.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCelular.setEnabled(false);
        txtCelular.setOpaque(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel4.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 270, 132, 23));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Celular");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 270, -1, 23));

        lbNombre1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbNombre1.setText("Nombre Fantasía");
        jPanel4.add(lbNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, -1, 23));

        txtNFantasia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNFantasia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtNFantasia.setEnabled(false);
        txtNFantasia.setOpaque(false);
        txtNFantasia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNFantasiaActionPerformed(evt);
            }
        });
        txtNFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNFantasiaKeyTyped(evt);
            }
        });
        jPanel4.add(txtNFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 150, 330, 23));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "ESTADO DE LA EMPRESA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 10), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbSi.setBackground(new java.awt.Color(255, 255, 255));
        gpVisual.add(rbSi);
        rbSi.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbSi.setSelected(true);
        rbSi.setText("Activo");
        rbSi.setEnabled(false);
        rbSi.setFocusPainted(false);
        rbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiActionPerformed(evt);
            }
        });
        jPanel2.add(rbSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 30, -1, 15));

        rbNo.setBackground(new java.awt.Color(255, 255, 255));
        gpVisual.add(rbNo);
        rbNo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rbNo.setText("Inactivo");
        rbNo.setEnabled(false);
        rbNo.setFocusPainted(false);
        rbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoActionPerformed(evt);
            }
        });
        jPanel2.add(rbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 30, -1, 15));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 160, 170, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "IMPORTANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 11), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel3.setEnabled(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Asegurese que solo una EMPRESA este activa en la tabla,");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 22, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("en el caso de que tenga insertado mas de un registro.");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 41, -1, 14));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 226, 350, 70));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbEmpresa.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbEmpresa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEmpresa.setGridColor(new java.awt.Color(204, 204, 204));
        tbEmpresa.setRowHeight(20);
        tbEmpresa.setShowGrid(true);
        tbEmpresa.setShowVerticalLines(false);
        tbEmpresa.getTableHeader().setResizingAllowed(false);
        tbEmpresa.getTableHeader().setReorderingAllowed(false);
        tbEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpresaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbEmpresaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbEmpresaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpresa);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 305, 829, 178));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpresaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbEmpresaMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 39;
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        if (txtNombre.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 10;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtRuc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 39;
        if (txtDireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtRucKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 12;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtTelefono.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 12;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtCelular.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void rbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiActionPerformed
        // TODO add your handling code here:
        Visual();
    }//GEN-LAST:event_rbSiActionPerformed

    private void rbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoActionPerformed
        // TODO add your handling code here:
        Visual();
    }//GEN-LAST:event_rbNoActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            ControlLogeo.Empresa();
            frmPrincipal.informacionGral();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        ban = 1;
        String cod = GestionarEmpresa.getCodigo();
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        txtNFantasia.setEnabled(true);
        txtNombre.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        rbSi.setEnabled(true);
        rbNo.setEnabled(true);
        limpiarCampos();
        Visual();
        tbEmpresa.setEnabled(false);
        txtNFantasia.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtNombre) && validarCampos.estaVacio(txtRuc)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlEmpresa.actEmpresa();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }

        } else {
            Mensajes.informacion("Debe llenar obligatoriamente los campos con *");
            if (txtNombre.getText().equals("")) {
                txtNombre.requestFocus();
            } else if (txtRuc.getText().equals("")) {
                txtRuc.requestFocus();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtNombre) && validarCampos.estaVacio(txtRuc)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarEmpresa.getCodigo();
                    txtCod.setText(cod);
                    controlEmpresa.addEmpresa();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        } else {
            Mensajes.informacion("Debe llenar obligatoriamente los campos con resaltados");
            if (txtNombre.getText().equals("")) {
                txtNombre.requestFocus();
            } else if (txtRuc.getText().equals("")) {
                txtRuc.requestFocus();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cancelar esta operación?");
        if (rpta == 0) {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(tbEmpresa.getSelectedRow() < 0 ){
            Notif.NotifyFail("Notificación del sistema", "No es posible procesar la eliminación\r\nSeleccione en la tabla la Empresa que desea eliminar.");
        }else{
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlEmpresa.delEmpresa();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNFantasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNFantasiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNFantasiaActionPerformed

    private void txtNFantasiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNFantasiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNFantasiaKeyTyped

    private void tbEmpresaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpresaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbEmpresaMouseReleased

    private void tbEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpresaMousePressed
        // TODO add your handling code here:
        if (ban == 0) {
            btnNuevo.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtNFantasia.setEnabled(true);
            txtNombre.setEnabled(true);
            txtRuc.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtTelefono.setEnabled(true);
            txtCelular.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);
            btnSalir.setEnabled(false);
            rbSi.setEnabled(true);
            rbNo.setEnabled(true);

            int fila = tbEmpresa.getSelectedRow();
            String cod = tbEmpresa.getValueAt(fila, 0).toString();
            String nomF = tbEmpresa.getValueAt(fila, 1).toString();
            String nom = tbEmpresa.getValueAt(fila, 2).toString();
            String ruc = tbEmpresa.getValueAt(fila, 3).toString();
            String direccion = tbEmpresa.getValueAt(fila, 4).toString();
            String telefono = tbEmpresa.getValueAt(fila, 5).toString();
            String celular = tbEmpresa.getValueAt(fila, 6).toString();
            visual = tbEmpresa.getValueAt(fila, 7).toString();

            txtCod.setText(cod);
            txtNFantasia.setText(nomF);
            txtNombre.setText(nom);
            txtRuc.setText(ruc);
            txtDireccion.setText(direccion);
            txtTelefono.setText(telefono);
            txtCelular.setText(celular);
            if (visual.equals("SI")) {
                rbSi.setSelected(true);
            } else {
                rbNo.setSelected(true);
            }
            Visual();
        }
    }//GEN-LAST:event_tbEmpresaMousePressed
    void limpiarCampos() {
        txtCod.setText("");
        txtNFantasia.setText("");
        txtNombre.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        CabecerasTablas.limpiarTablaEmpresa(tbEmpresa);
        controlEmpresa.lisEmpresa(tbEmpresa);
    }

    void Visual() {
        if (rbSi.isSelected()) {
            lbvisual.setText("SI");
        } else {
            lbvisual.setText("NO");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
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
            java.util.logging.Logger.getLogger(dlgEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(() -> {
            dlgEmpresa dialog = new dlgEmpresa(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo2;
    private javax.swing.JLabel LabelTitulo3;
    private javax.swing.JLabel LabelTitulo4;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar;
    private rojeru_san.rspanel.RSPanelImage PnlEliminar;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar;
    private rojeru_san.rspanel.RSPanelImage PnlModificar;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo;
    private javax.swing.JSeparator Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JSeparator Separador3;
    private javax.swing.JSeparator Separador4;
    private RSMaterialComponent.RSButtonIconUno btnCancelar;
    private RSMaterialComponent.RSButtonIconUno btnEliminar;
    private RSMaterialComponent.RSButtonIconUno btnGuardar;
    private RSMaterialComponent.RSButtonIconUno btnModificar;
    private RSMaterialComponent.RSButtonIconUno btnNuevo;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    public static javax.swing.ButtonGroup gpVisual;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbNombre;
    public static javax.swing.JLabel lbNombre1;
    public static javax.swing.JLabel lbRuc;
    public static javax.swing.JLabel lbvisual;
    public static javax.swing.JRadioButton rbNo;
    public static javax.swing.JRadioButton rbSi;
    private static final javax.swing.JTable tbEmpresa = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNFantasia;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
