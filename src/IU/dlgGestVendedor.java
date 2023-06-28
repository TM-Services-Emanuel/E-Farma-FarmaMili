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
    static String UsuarioL="";

    public dlgGestVendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarIcono();
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);    
        txtNombre.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtComision = new javax.swing.JTextField();
        c2 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaS = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNuev = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel1.setText("ID Vendedor");

        lblCodV.setBackground(new java.awt.Color(255, 255, 204));
        lblCodV.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblCodV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCodV.setOpaque(true);

        jLabel4.setText("Nombre y Apellido");

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel5.setText("Dirección");

        txtDireccion.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel7.setText("Teléfono");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel8.setText("Celular");

        txtCelular.setBackground(new java.awt.Color(255, 255, 204));
        txtCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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

        jLabel9.setText("Sueldo");

        jLabel10.setText("% Comisión");

        txtComision.setBackground(new java.awt.Color(255, 255, 204));
        txtComision.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtComision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtComision.setText("0");
        txtComision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComisionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComisionKeyReleased(evt);
            }
        });

        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        txtSueldo.setBackground(new java.awt.Color(255, 255, 204));
        txtSueldo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtSueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSueldo.setText("0");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCodV, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre)
                    .addComponent(txtDireccion)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c1)
                    .addComponent(c2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(c3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos", jPanel1);

        txaS.setBackground(new java.awt.Color(255, 255, 204));
        txaS.setColumns(20);
        txaS.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txaS.setRows(5);
        txaS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaSKeyPressed(evt);
            }
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Observaciones", jPanel2);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 9));

        btnNuev.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnNuev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuev.setText("Nuevo-F1");
        btnNuev.setToolTipText("Nuevo - F3");
        btnNuev.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuev.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuev);

        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit30.png"))); // NOI18N
        btnModificar.setText("Modif-F5");
        btnModificar.setToolTipText("Modificar - F5");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar-F6");
        btnGuardar.setToolTipText("Guardar - F6");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancel-Esc");
        btnCancelar.setToolTipText("Cancelar - Esc");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelar);

        lbm.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N

        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setText("Opciones");
        menuOpciones.setFocusable(false);
        menuOpciones.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        menuOpciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuOpciones.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        itemModificar.setText("Guardar Modificación");
        itemModificar.setEnabled(false);
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemModificar);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        itemGuardar.setText("Guardar Nuevo");
        itemGuardar.setEnabled(false);
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemGuardar);

        itemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        itemCancelar.setText("Cancelar");
        itemCancelar.setEnabled(false);
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemCancelar);
        menuOpciones.add(jSeparator1);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("Salir");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            actualizartablaEmpleados();
            this.dispose();
        }
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtComisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtComision);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!btnGuardar.isEnabled()) {
                btnModificar.doClick();
            } else {
                btnGuardar.doClick();
            }
        }
    }//GEN-LAST:event_txtComisionKeyPressed

    private void txtSueldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtSueldo);
        int limite=8;
        if (txtSueldo.getText().length()== limite)
        {
            evt.consume();
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtComision.requestFocus();
        }
    }//GEN-LAST:event_txtSueldoKeyPressed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCelular);
        validarCampos.cantCaracteres(txtCelular, 10);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtSueldo.requestFocus();
        }
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtTelefono);
        validarCampos.cantCaracteres(txtTelefono, 10);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtCelular.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 49);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtNombre);
        validarCampos.cantCaracteres(txtNombre, 49);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void btnNuevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        String cod = GestionarVendedor.getCodigo();
        lblCodV.setText(cod);
        btnNuev.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txtSueldo.setEnabled(true);
        txtComision.setEnabled(true);
        txtNombre.requestFocus();
        System.out.println(UsuarioL=Login.getUsuarioLogueado());
    }//GEN-LAST:event_btnNuevActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        if (validarCampos.estaVacio(txtNombre) && validarCampos.estaVacio(txtSueldo) && validarCampos.estaVacio(txtCelular) && validarCampos.estaVacio(txtComision)) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    controlVendedor.actVendedor();
                    actualizartablaEmpleados();
                    this.dispose();
                }
            }catch(Exception ee){
            System.out.println(ee.getMessage());}       
        } else {
            lbm.setText("Campo Obligatorio");
            if(txtNombre.getText().trim().equals("")){
                txtNombre.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
            }else if(txtCelular.getText().trim().equals("")){
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
            }else if (txtSueldo.getText().trim().equals("")){
                txtSueldo.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
            }else if(txtComision.getText().trim().equals("")){
                txtComision.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
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
        if (validarCampos.estaVacio(txtNombre) && validarCampos.estaVacio(txtSueldo) && validarCampos.estaVacio(txtCelular) && validarCampos.estaVacio(txtComision)) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    String cod = GestionarVendedor.getCodigo();
                    lblCodV.setText(cod);
                    controlVendedor.addVendedor();
                    actualizartablaEmpleados();
                    btnCancelarActionPerformed(null);
                }
                
            }catch(HeadlessException ee){}    
        } else {
            lbm.setText("Campo Obligatorio");
            if(txtNombre.getText().trim().equals("")){
                txtNombre.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
            }else if(txtCelular.getText().trim().equals("")){
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
            }else if (txtSueldo.getText().trim().equals("")){
                txtSueldo.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
            }else if(txtComision.getText().trim().equals("")){
                txtComision.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnNuev.setEnabled(true);
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtSueldo.setEnabled(false);
        txtComision.setEnabled(false);
        txaS.setEnabled(false);
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        limpiarCampos();
        btnNuev.requestFocus();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnNuevActionPerformed(null);
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

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtNombre.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtDireccion.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=15;
        if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              System.out.println("Ingresa Solo Numeros");
        }
        if (txtCelular.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=15;
        if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              System.out.println("Ingresa Solo Numeros");
        }
        if (txtTelefono.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txaSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txaS.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txaSKeyTyped

    private void txtSueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyReleased
        // TODO add your handling code here:
        try{
            if(Integer.parseInt(txtSueldo.getText()) < 0){
            txtSueldo.setText("0");
        }
        }catch(NumberFormatException e){}
        DecimalFormat df = new DecimalFormat("#,###");
 
        if (txtSueldo.getText().trim().length() >= 1) {
 
            txtSueldo.setText( df.format(Integer.valueOf(txtSueldo.getText().trim().replace(".", "").replace(",", ""))) );
        }
        
    }//GEN-LAST:event_txtSueldoKeyReleased

    private void txtComisionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComisionKeyReleased
        // TODO add your handling code here:
        try{
            if(Integer.parseInt(txtComision.getText()) < 0){
            txtComision.setText("0");
        }
        }catch(NumberFormatException e){}
        
    }//GEN-LAST:event_txtComisionKeyReleased

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
        /*DecimalFormat df = new DecimalFormat("#,###");
 
        if (txtSueldo.getText().trim().length() >= 1) {
 
            txtSueldo.setText( df.format(Integer.valueOf(txtSueldo.getText().trim().replace(".", "").replace(",", ""))) );
        }*/
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void txaSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaSKeyPressed

    void limpiarCampos() {
        lblCodV.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtSueldo.setText("");
        txtCelular.setText("");
        txtComision.setText("0");
        txtSueldo.setText("0");
        txaS.setText("");
    }
    
     void actualizartablaEmpleados(){
         CabecerasTablas cabe = new CabecerasTablas();
         cabe.vendedor(dlgVendedor.tablaEmpleados);
         CabecerasTablas.limpiarTablas(dlgVendedor.tablaEmpleados);
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
    private javax.swing.JMenuBar barMenu;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuev;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    public static javax.swing.JMenuItem itemCancelar;
    public static javax.swing.JMenuItem itemGuardar;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblCodV;
    private javax.swing.JLabel lbm;
    private javax.swing.JMenu menuOpciones;
    public static javax.swing.JTextArea txaS;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtComision;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtSueldo;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
