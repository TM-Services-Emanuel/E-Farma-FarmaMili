package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.ControlLogeo;
import Controladores.controlSucursal;
import Datos.GestionalSucursal;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class dlgSucursal extends javax.swing.JDialog {

    static DataSourceService dss = new DataSourceService();
    private int ban;

    public dlgSucursal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();

        CabecerasTablas.sucursal(tbSucursal);
        controlSucursal.listSucursal(tbSucursal);
        cargarComboBox.cargar(cboEmpresa, "SELECT * FROM empresa WHERE em_visualizar='SI' and em_indicador='S'");
        tbSucursal.getTableHeader().setReorderingAllowed(false);
        lbCod.setVisible(false);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar sucursal");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar sucursal");
        }
    }

    private void Cancelar() {
        CabecerasTablas.limpiarTablaSucursal(tbSucursal);
        controlSucursal.listSucursal(tbSucursal);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSalir.setEnabled(true);
        txtSucursal.setEnabled(false);
        txtIPSucursal.setEnabled(false);
        cboEmpresa.setEnabled(false);
        rMiSuc.setEnabled(false);
        limpiarCampos();
        tbSucursal.clearSelection();
        tbSucursal.setEnabled(true);
        btnNuevo.requestFocus();
        ban = 0;
    }

    public void modcbEmpresa(int id) {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        String sqlEmps = "SELECT * FROM empresa WHERE em_visualizar='SI' and em_indicador='S'";
        String sqlEmpEsp = "SELECT em_nombrefantasia FROM empresa WHERE em_codigo=" + id;
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlEmps); ResultSet rss = st.executeQuery(sqlEmpEsp)) {
            ml.addElement("SELEC. UNA OPCIÓN");
            while (rs.next()) {
                ml.addElement(rs.getString(2));
            }
            rss.first();
            Object descripcion = (Object) rss.getString(1);
            cboEmpresa.setModel(ml);
            cboEmpresa.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            st.close();
            cn.close();
        } catch (SQLException ew) {
            System.out.println("Error combomod empresa: " + ew.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        lbCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cboEmpresa = new RSMaterialComponent.RSComboBox();
        jLabel4 = new javax.swing.JLabel();
        rMiSuc = new rojerusan.RSCheckBox();
        txtIPSucursal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(17, 35, 46));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel4.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

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

        jPanel4.add(PnlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

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

        jPanel4.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

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

        jPanel4.add(PnlCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, 100));

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

        jPanel4.add(PnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 3, 100, 100));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 110));

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
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 1, 20, 20));
        jPanel3.add(lbCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 75, 20, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 703, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel3.setText("ID Sucursal:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, -1, 23));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 33, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("Sucursal: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 23));

        txtSucursal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtSucursal.setEnabled(false);
        txtSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSucursalActionPerformed(evt);
            }
        });
        txtSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSucursalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSucursalKeyTyped(evt);
            }
        });
        jPanel2.add(txtSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 241, 23));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbSucursal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbSucursal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSucursal.setGridColor(new java.awt.Color(204, 204, 204));
        tbSucursal.setRowHeight(20);
        tbSucursal.setShowGrid(true);
        tbSucursal.setShowVerticalLines(false);
        tbSucursal.getTableHeader().setResizingAllowed(false);
        tbSucursal.getTableHeader().setReorderingAllowed(false);
        tbSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSucursalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbSucursalMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbSucursal);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 180, 702, 230));

        cboEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        cboEmpresa.setColorArrow(new java.awt.Color(17, 35, 46));
        cboEmpresa.setColorBorde(new java.awt.Color(204, 204, 204));
        cboEmpresa.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        cboEmpresa.setColorFondo(new java.awt.Color(255, 255, 255));
        cboEmpresa.setConBorde(true);
        cboEmpresa.setEnabled(false);
        cboEmpresa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cboEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpresaActionPerformed(evt);
            }
        });
        jPanel2.add(cboEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 120, 200, 23));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("Empresa:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, 23));

        rMiSuc.setForeground(new java.awt.Color(0, 0, 0));
        rMiSuc.setText("Esta es mi sucursal");
        rMiSuc.setColorCheck(new java.awt.Color(255, 102, 0));
        rMiSuc.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rMiSuc.setEnabled(false);
        rMiSuc.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        rMiSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rMiSucActionPerformed(evt);
            }
        });
        jPanel2.add(rMiSuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 150, 140, 23));

        txtIPSucursal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtIPSucursal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIPSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtIPSucursal.setEnabled(false);
        txtIPSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPSucursalActionPerformed(evt);
            }
        });
        txtIPSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIPSucursalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIPSucursalKeyTyped(evt);
            }
        });
        jPanel2.add(txtIPSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 150, 200, 23));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel5.setText("IP servidor:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 150, 60, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void tbSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSucursalMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tbSucursalMouseClicked

    private void txtSucursalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSucursalKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSucursalKeyPressed

    private void txtSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSucursalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtSucursalKeyTyped

    private void txtSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucursalActionPerformed
        // TODO add your handling code here:
        if (btnGuardar.isEnabled()) {
            btnGuardar.doClick();
        } else {
            btnModificar.doClick();
        }
    }//GEN-LAST:event_txtSucursalActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        ban = 1;
        cargarComboBox.cargar(cboEmpresa, "SELECT * FROM empresa WHERE em_visualizar='SI' and em_indicador='S'");
        String cod = GestionalSucursal.getCodigo();
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        txtSucursal.setEnabled(true);
        txtIPSucursal.setEnabled(true);
        cboEmpresa.setEnabled(true);
        rMiSuc.setEnabled(true);
        tbSucursal.setEnabled(false);
        txtSucursal.requestFocus();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txtSucursal.getText().isEmpty()) {
            Mensajes.Sistema("No es posible insertar el registro.\nEl campo Sucursal se encuentra vacío.Por favor, complete este campo y vuelva a intentarlo.");
            txtSucursal.requestFocus();
        } else if (cboEmpresa.getSelectedIndex() == 0) {
            Mensajes.Sistema("No es posible insertar el registro.\nLa Empresa no ha sido especificada.Por favor, seleccione la opción correcta y vuelva a intentarlo.");
            cboEmpresa.setPopupVisible(true);
            cboEmpresa.requestFocus();
        } else if (txtIPSucursal.getText().isEmpty()) {
            Mensajes.Sistema("No es posible insertar el registro.\nEl campo Dirección IP se encuentra vacío.Por favor, complete este campo y vuelva a intentarlo.");
            txtIPSucursal.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlSucursal.actSucursal();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
                System.out.println(ee.getMessage());
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtSucursal.getText().isEmpty()) {
            Mensajes.Sistema("No es posible insertar el registro.\nEl campo Sucursal se encuentra vacío.Por favor, complete este campo y vuelva a intentarlo.");
            txtSucursal.requestFocus();
        } else if (cboEmpresa.getSelectedIndex() == 0) {
            Mensajes.Sistema("No es posible insertar el registro.\nLa Empresa no ha sido especificada.Por favor, seleccione la opción correcta y vuelva a intentarlo.");
            cboEmpresa.setPopupVisible(true);
            cboEmpresa.requestFocus();
        } else if (txtIPSucursal.getText().isEmpty()) {
            Mensajes.Sistema("No es posible insertar el registro.\nEl campo Dirección IP se encuentra vacío.Por favor, complete este campo y vuelva a intentarlo.");
            txtIPSucursal.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionalSucursal.getCodigo();
                    txtCod.setText(cod);
                    controlSucursal.addSucursal();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
                System.out.println("Error en Guardar: " + ee.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here
        int rpta = Mensajes.confirmar("¿Seguro que desea cancelar esta operación?");
        if (rpta == 0) {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tbSucursal.getSelectedRow() < 0) {
            Notif.NotifyFail("Notificación del sistema", "No es posible procesar la eliminación.\r\nSeleccione en la tabla la Sucursal que desea eliminar.");
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlSucursal.delSucursal();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            ControlLogeo.Empresa();
            frmPrincipal.informacionGral();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rMiSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rMiSucActionPerformed
        // TODO add your handling code here:
        if (rMiSuc.isSelected()) {
            Mensajes.Sistema("Dato importante a tener en cuenta:\nNo puede haber mas de dos sucursales tildados como \"Esta es mi sucursal\", ya que esto ocacionaria conflictos a la hora de procesar operaciones transaccionales.\nPor favor, tén esto siempre en cuenta.");
        }
    }//GEN-LAST:event_rMiSucActionPerformed

    private void cboEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpresaActionPerformed
        // TODO add your handling code here:
        if (cboEmpresa.getSelectedIndex() != 0) {
            String sqlEmp = "Select em_codigo from empresa where em_nombrefantasia='" + String.valueOf(cboEmpresa.getSelectedItem()) + "'and em_visualizar='SI' and em_indicador='S'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlEmp)) {
                rs.first();
                if (rs.getRow() != 0) {
                    lbCod.setText(rs.getString("em_codigo"));
                    rs.close();
                    st.close();
                    cn.close();
                } else {
                    System.out.println("Consulta sin resultados.");
                }

            } catch (SQLException ex) {
                Mensajes.error("Error obteniendo ID familia:" + ex.getMessage());
            }
        } else {
            lbCod.setText("");
        }

    }//GEN-LAST:event_cboEmpresaActionPerformed

    private void txtIPSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIPSucursalActionPerformed

    private void txtIPSucursalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPSucursalKeyPressed
        // TODO add your handling code here:
        if (!txtIPSucursal.getText().trim().isEmpty()) {
            validarCampos.soloDecimales(txtIPSucursal);
            validarCampos.cantCaracteres(txtIPSucursal, 15);
        }
    }//GEN-LAST:event_txtIPSucursalKeyPressed

    private void txtIPSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPSucursalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIPSucursalKeyTyped

    private void tbSucursalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSucursalMousePressed
        // TODO add your handling code here:
        if (ban == 0) {
            btnNuevo.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtSucursal.setEnabled(true);
            txtIPSucursal.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);
            btnSalir.setEnabled(false);
            cboEmpresa.setEnabled(true);
            rMiSuc.setEnabled(true);

            int fila = tbSucursal.getSelectedRow();
            String codSuc = tbSucursal.getValueAt(fila, 0).toString();
            String nomSuc = tbSucursal.getValueAt(fila, 1).toString();
            String miSuc = tbSucursal.getValueAt(fila, 3).toString();
            String idEmp = tbSucursal.getValueAt(fila, 4).toString();
            String IP = tbSucursal.getValueAt(fila, 6).toString();
            lbCod.setText(idEmp);
            txtCod.setText(codSuc);
            txtSucursal.setText(nomSuc);
            if (miSuc.equals("S")) {
                rMiSuc.setSelected(true);
            } else {
                rMiSuc.setSelected(false);
            }
            txtIPSucursal.setText(IP);
            modcbEmpresa(Integer.parseInt(idEmp));
            txtSucursal.requestFocus();
        }
    }//GEN-LAST:event_tbSucursalMousePressed

    void limpiarCampos() {
        txtCod.setText("");
        txtSucursal.setText("");
        lbCod.setText("");
        cboEmpresa.setSelectedIndex(0);
        rMiSuc.setSelected(false);
        txtIPSucursal.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgMotivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgSucursal dialog = new dlgSucursal(new javax.swing.JFrame(), true);
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
    private RSMaterialComponent.RSComboBox cboEmpresa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField lbCod;
    public static rojerusan.RSCheckBox rMiSuc;
    private static final javax.swing.JTable tbSucursal = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtIPSucursal;
    public static javax.swing.JTextField txtSucursal;
    // End of variables declaration//GEN-END:variables
}
