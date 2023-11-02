package IU;

import Componentes.Login;
import Componentes.Mensajes;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlVendedor;
import Datos.GestionarVendedor;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public final class dlgGestVendedor extends javax.swing.JDialog {

    public dlgGestVendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarIcono();
        txtNombre.requestFocus();
    }

    private void SueldoFinal() {
        DecimalFormat df = new DecimalFormat("#,###");
        switch (cbPeriodo.getSelectedIndex()) {

            case 0 ->
                txtSueldoFinal.setText("0");
            case 1 -> {

                int sueldo = Integer.parseInt(txtSueldo.getText().replace(".", "").replace(",", "")) * 4;
                txtSueldoFinal.setText(String.valueOf(df.format(sueldo)));
            }
            case 2 -> {
                int sueldo = Integer.parseInt(txtSueldo.getText().replace(".", "").replace(",", "")) * 2;
                txtSueldoFinal.setText(String.valueOf(df.format(sueldo)));
            }
            case 3 -> {
                int sueldo = Integer.parseInt(txtSueldo.getText().replace(".", "").replace(",", "")) * 1;
                txtSueldoFinal.setText(String.valueOf(df.format(sueldo)));
            }
            default -> {
            }
        }
    }
    
    private void HabilitarAdelantos(){
        if(cbAdelantos.isSelected()){
            cbFrecuencia.setEnabled(true);
            txtAdelanto.setEnabled(true);
        }else{
            cbFrecuencia.setSelectedIndex(0);
            cbFrecuencia.setEnabled(false);
            txtAdelanto.setEnabled(false);
            txtAdelanto.setText("0");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        PnlNuevo = new rojeru_san.rspanel.RSPanelImage();
        btnNuev = new RSMaterialComponent.RSButtonIconUno();
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
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCI = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rSDateChooser1 = new rojeru_san.rsdate.RSDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        cbPeriodo = new RSMaterialComponent.RSComboBox();
        txtSueldoFinal = new javax.swing.JTextField();
        cbAdelantos = new rojerusan.RSCheckBox();
        txtAdelanto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFuncion = new javax.swing.JTextField();
        cbFrecuencia = new RSMaterialComponent.RSComboBox();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        jPanel4.setBackground(new java.awt.Color(17, 35, 46));

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btnNuev.setBackground(new java.awt.Color(0, 102, 0));
        btnNuev.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnNuev.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnNuev.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuev.setRippleColor(java.awt.Color.white);
        btnNuev.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnNuev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevActionPerformed(evt);
            }
        });

        Separador1.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("NUEVO");

        javax.swing.GroupLayout PnlNuevoLayout = new javax.swing.GroupLayout(PnlNuevo);
        PnlNuevo.setLayout(PnlNuevoLayout);
        PnlNuevoLayout.setHorizontalGroup(
            PnlNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador1)
                    .addComponent(LabelTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlNuevoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnNuev, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlNuevoLayout.setVerticalGroup(
            PnlNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuev, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, -1));

        PnlModificar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

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

        Separador2.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo2.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo2.setText("MODIFICAR");

        javax.swing.GroupLayout PnlModificarLayout = new javax.swing.GroupLayout(PnlModificar);
        PnlModificar.setLayout(PnlModificarLayout);
        PnlModificarLayout.setHorizontalGroup(
            PnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador2)
                    .addComponent(LabelTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlModificarLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        PnlModificarLayout.setVerticalGroup(
            PnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(PnlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, -1));

        PnlGuardar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(0, 102, 0));
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

        Separador3.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("REGISTRAR");

        javax.swing.GroupLayout PnlGuardarLayout = new javax.swing.GroupLayout(PnlGuardar);
        PnlGuardar.setLayout(PnlGuardarLayout);
        PnlGuardarLayout.setHorizontalGroup(
            PnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador3)
                    .addComponent(LabelTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlGuardarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlGuardarLayout.setVerticalGroup(
            PnlGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, -1));

        PnlCancelar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

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

        Separador4.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo4.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo4.setText("CANCELAR");

        javax.swing.GroupLayout PnlCancelarLayout = new javax.swing.GroupLayout(PnlCancelar);
        PnlCancelar.setLayout(PnlCancelarLayout);
        PnlCancelarLayout.setHorizontalGroup(
            PnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador4)
                    .addComponent(LabelTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlCancelarLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        PnlCancelarLayout.setVerticalGroup(
            PnlCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(PnlCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, -1));

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "DATOS PERSONALES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 11), new java.awt.Color(17, 35, 46))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel1.setText("ID VENDEDOR:");

        lblCodV.setBackground(new java.awt.Color(255, 255, 255));
        lblCodV.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblCodV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblCodV.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("NOMBRE Y APELLIDO:");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel5.setText("DIRECCIÓN:");

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel7.setText("TELÉFONO:");

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setText("0986-540423");
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

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel8.setText("CELULAR:");

        txtCelular.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel6.setText("C.I. NRO:");

        txtCI.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCI.setText("4744832");
        txtCI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCIActionPerformed(evt);
            }
        });
        txtCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCIKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblCodV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(232, 232, 232)))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "DATOS COMPLEMENTARIOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 11), new java.awt.Color(17, 35, 46))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel11.setText("FECHA DE INGRESO:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 30, 148, 23));

        rSDateChooser1.setColorBackground(new java.awt.Color(204, 204, 204));
        rSDateChooser1.setColorButtonHover(new java.awt.Color(17, 35, 46));
        rSDateChooser1.setColorDiaActual(new java.awt.Color(204, 102, 0));
        rSDateChooser1.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rSDateChooser1.setFormatoFecha("dd/MM/yyyy");
        rSDateChooser1.setFuente(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rSDateChooser1.setPlaceholder("");
        jPanel2.add(rSDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 137, 23));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel9.setText("SUELDO A PERCIBIR:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 60, 148, 23));

        txtSueldo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtSueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSueldo.setText("0");
        txtSueldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSueldoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoKeyReleased(evt);
            }
        });
        jPanel2.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 100, 23));

        cbPeriodo.setForeground(new java.awt.Color(0, 0, 0));
        cbPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PERIODO DE PAGO", "PAGO SEMANAL", "PAGO QUINCENAL", "PAGO MENSUAL" }));
        cbPeriodo.setColorArrow(new java.awt.Color(17, 35, 46));
        cbPeriodo.setColorBorde(new java.awt.Color(204, 204, 204));
        cbPeriodo.setColorFondo(new java.awt.Color(255, 255, 255));
        cbPeriodo.setConBorde(true);
        cbPeriodo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        cbPeriodo.setItemHeight(23);
        cbPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPeriodoActionPerformed(evt);
            }
        });
        jPanel2.add(cbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 60, 155, 23));

        txtSueldoFinal.setEditable(false);
        txtSueldoFinal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtSueldoFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSueldoFinal.setText("0");
        txtSueldoFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtSueldoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoFinalActionPerformed(evt);
            }
        });
        txtSueldoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSueldoFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoFinalKeyReleased(evt);
            }
        });
        jPanel2.add(txtSueldoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 100, 23));

        cbAdelantos.setForeground(new java.awt.Color(0, 0, 0));
        cbAdelantos.setText("PERMITIR ADELANTOS");
        cbAdelantos.setColorCheck(new java.awt.Color(0, 102, 0));
        cbAdelantos.setColorUnCheck(new java.awt.Color(0, 0, 0));
        cbAdelantos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        cbAdelantos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbAdelantosStateChanged(evt);
            }
        });
        cbAdelantos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdelantosActionPerformed(evt);
            }
        });
        jPanel2.add(cbAdelantos, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 156, 160, 23));

        txtAdelanto.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtAdelanto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAdelanto.setText("0");
        txtAdelanto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtAdelanto.setEnabled(false);
        txtAdelanto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdelantoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdelantoKeyReleased(evt);
            }
        });
        jPanel2.add(txtAdelanto, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 184, 100, 23));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel10.setText("FUNCION A DESEMPEÑAR:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 120, 148, 23));

        txtFuncion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtFuncion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFuncion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFuncionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFuncionKeyTyped(evt);
            }
        });
        jPanel2.add(txtFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 262, 23));

        cbFrecuencia.setForeground(new java.awt.Color(0, 0, 0));
        cbFrecuencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FRECUENCIA DE RETIRO", "UNA VEZ", "DOS VECES", "TRES VECES", "SIN LIMITES" }));
        cbFrecuencia.setColorArrow(new java.awt.Color(17, 35, 46));
        cbFrecuencia.setColorBorde(new java.awt.Color(204, 204, 204));
        cbFrecuencia.setColorFondo(new java.awt.Color(255, 255, 255));
        cbFrecuencia.setConBorde(true);
        cbFrecuencia.setEnabled(false);
        cbFrecuencia.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        cbFrecuencia.setItemHeight(23);
        jPanel2.add(cbFrecuencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 184, 160, 23));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel13.setText("SUELDO FINAL:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 90, 148, 23));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        String cod = GestionarVendedor.getCodigo();
        lblCodV.setText(cod);
        btnNuev.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txtSueldo.setEnabled(true);
        txtAdelanto.setEnabled(true);
        txtNombre.requestFocus();
        System.out.println(Login.getUsuarioLogueado());
    }//GEN-LAST:event_btnNuevActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtNombre) && validarCampos.estaVacio(txtSueldo) && validarCampos.estaVacio(txtCelular) && validarCampos.estaVacio(txtAdelanto)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlVendedor.actVendedor();
                    actualizartablaEmpleados();
                    this.dispose();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        } else {
            if (txtNombre.getText().trim().equals("")) {
                txtNombre.requestFocus();
            } else if (txtCelular.getText().trim().equals("")) {
                txtCelular.requestFocus();
            } else if (txtSueldo.getText().trim().equals("")) {
                txtSueldo.requestFocus();
            } else if (txtAdelanto.getText().trim().equals("")) {
                txtAdelanto.requestFocus();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtNombre) && validarCampos.estaVacio(txtSueldo) && validarCampos.estaVacio(txtCelular) && validarCampos.estaVacio(txtAdelanto)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarVendedor.getCodigo();
                    lblCodV.setText(cod);
                    controlVendedor.addVendedor();
                    actualizartablaEmpleados();
                    btnCancelarActionPerformed(null);
                }

            } catch (HeadlessException ee) {
            }
        } else {
            if (txtNombre.getText().trim().equals("")) {
                txtNombre.requestFocus();
            } else if (txtCelular.getText().trim().equals("")) {
                txtCelular.requestFocus();
            } else if (txtSueldo.getText().trim().equals("")) {
                txtSueldo.requestFocus();
            } else if (txtAdelanto.getText().trim().equals("")) {
                txtAdelanto.requestFocus();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnNuev.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtSueldo.setEnabled(false);
        txtAdelanto.setEnabled(false);
        limpiarCampos();
        btnNuev.requestFocus();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            try {
                actualizartablaEmpleados();
            } catch (Exception e) {
                System.out.println("actualizartablaEmpleados: " + e.getMessage());
            }

            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtSueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyReleased
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtSueldo.getText()) < 0) {
                txtSueldo.setText("0");
            }
        } catch (NumberFormatException e) {
        }
        DecimalFormat df = new DecimalFormat("#,###");

        if (txtSueldo.getText().trim().length() >= 1) {

            txtSueldo.setText(df.format(Integer.valueOf(txtSueldo.getText().trim().replace(".", "").replace(",", ""))));
        }
        SueldoFinal();
    }//GEN-LAST:event_txtSueldoKeyReleased

    private void txtSueldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtSueldo);
        int limite = 8;
        if (txtSueldo.getText().length() == limite) {
            evt.consume();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFuncion.requestFocus();
        }
    }//GEN-LAST:event_txtSueldoKeyPressed

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
        /*DecimalFormat df = new DecimalFormat("#,###");

        if (txtSueldo.getText().trim().length() >= 1) {

            txtSueldo.setText( df.format(Integer.valueOf(txtSueldo.getText().trim().replace(".", "").replace(",", ""))) );
        }*/
    }//GEN-LAST:event_txtSueldoActionPerformed

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

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCelular);
        validarCampos.cantCaracteres(txtCelular, 10);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSueldo.requestFocus();
        }
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

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

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtTelefono);
        validarCampos.cantCaracteres(txtTelefono, 10);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCelular.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

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

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 49);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtNombre.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtNombre);
        validarCampos.cantCaracteres(txtNombre, 49);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtCIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCIKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCI);
        validarCampos.cantCaracteres(txtCI, 10);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_txtCIKeyPressed

    private void txtCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCIKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIKeyTyped

    private void txtSueldoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoFinalActionPerformed

    private void txtSueldoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoFinalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoFinalKeyPressed

    private void txtSueldoFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoFinalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoFinalKeyReleased

    private void txtCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtFuncionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFuncionKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtFuncion);
        validarCampos.cantCaracteres(txtFuncion, 49);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbAdelantos.requestFocus();
        }
    }//GEN-LAST:event_txtFuncionKeyPressed

    private void txtFuncionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFuncionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncionKeyTyped

    private void txtAdelantoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdelantoKeyReleased
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtAdelanto.getText()) < 0) {
                txtAdelanto.setText("0");
            }
        } catch (NumberFormatException e) {
        }
        DecimalFormat df = new DecimalFormat("#,###");

        if (txtAdelanto.getText().trim().length() >= 1) {

            txtAdelanto.setText(df.format(Integer.valueOf(txtAdelanto.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtAdelantoKeyReleased

    private void txtAdelantoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdelantoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtAdelanto);
        int limite = 8;
        if (txtAdelanto.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAdelantoKeyPressed

    private void cbAdelantosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdelantosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAdelantosActionPerformed

    private void cbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPeriodoActionPerformed
        // TODO add your handling code here:
        SueldoFinal();
    }//GEN-LAST:event_cbPeriodoActionPerformed

    private void cbAdelantosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbAdelantosStateChanged
        // TODO add your handling code here:
        HabilitarAdelantos();
    }//GEN-LAST:event_cbAdelantosStateChanged

    void limpiarCampos() {
        lblCodV.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtSueldo.setText("");
        txtCelular.setText("");
        txtAdelanto.setText("0");
        txtSueldo.setText("0");
    }

    void actualizartablaEmpleados() {
        CabecerasTablas.vendedor(dlgVendedor.tablaEmpleados);
        CabecerasTablas.limpiarTablaVendedor(dlgVendedor.tablaEmpleados);
        controlVendedor.listVendedor(dlgVendedor.tablaEmpleados, "vendedor.ven_codigo");
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
            java.util.logging.Logger.getLogger(dlgGestVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestVendedor dialog = new dlgGestVendedor(new javax.swing.JFrame(), true);
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
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    public static RSMaterialComponent.RSButtonIconUno btnModificar;
    public static RSMaterialComponent.RSButtonIconUno btnNuev;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private rojerusan.RSCheckBox cbAdelantos;
    private RSMaterialComponent.RSComboBox cbFrecuencia;
    private RSMaterialComponent.RSComboBox cbPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JLabel lblCodV;
    private rojeru_san.rsdate.RSDateChooser rSDateChooser1;
    private javax.swing.JTextField txtAdelanto;
    public static javax.swing.JTextField txtCI;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtFuncion;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtSueldo;
    public static javax.swing.JTextField txtSueldoFinal;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
