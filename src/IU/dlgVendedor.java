package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlVendedor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public final class dlgVendedor extends javax.swing.JDialog {
    clsExportarExcel Export;

    public dlgVendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        CabecerasTablas.vendedor(tablaEmpleados);
        controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
        tablaEmpleados.getTableHeader().setReorderingAllowed(false);
        cargarIcono();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar empleados");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar empleados");
        }
    }
    
    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_DELETE ->
                btnEliminar.doClick();
            case KeyEvent.VK_F5 ->
                btnModificar.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            default -> {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemPModificarE = new javax.swing.JMenuItem();
        itemPEliminarE = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        PnlNuevo1 = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador5 = new javax.swing.JSeparator();
        LabelTitulo5 = new javax.swing.JLabel();
        PnlModificar1 = new rojeru_san.rspanel.RSPanelImage();
        btnModificar = new RSMaterialComponent.RSButtonIconUno();
        Separador6 = new javax.swing.JSeparator();
        LabelTitulo6 = new javax.swing.JLabel();
        PnlActualizar = new rojeru_san.rspanel.RSPanelImage();
        btn6 = new RSMaterialComponent.RSButtonIconUno();
        Separador7 = new javax.swing.JSeparator();
        LabelTitulo7 = new javax.swing.JLabel();
        PnlEliminarG = new rojeru_san.rspanel.RSPanelImage();
        btnEliminar = new RSMaterialComponent.RSButtonIconUno();
        Separador8 = new javax.swing.JSeparator();
        LabelTitulo8 = new javax.swing.JLabel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jScrollPane1 = new javax.swing.JScrollPane();

        jPopupMenu1.setLabel("Opciones");

        itemPModificarE.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editUser15.png"))); // NOI18N
        itemPModificarE.setText("     Modificar");
        itemPModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPModificarEActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPModificarE);

        itemPEliminarE.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteUser15 (2).png"))); // NOI18N
        itemPEliminarE.setText("     Eliminar");
        itemPEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPEliminarEActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPEliminarE);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));

        jPanel4.setBackground(new java.awt.Color(17, 35, 46));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

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

        Separador5.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo5.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo5.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo5.setText("NUEVO");

        javax.swing.GroupLayout PnlNuevo1Layout = new javax.swing.GroupLayout(PnlNuevo1);
        PnlNuevo1.setLayout(PnlNuevo1Layout);
        PnlNuevo1Layout.setHorizontalGroup(
            PnlNuevo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlNuevo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador5)
                    .addComponent(LabelTitulo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlNuevo1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlNuevo1Layout.setVerticalGroup(
            PnlNuevo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(PnlNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, -1));

        PnlModificar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btnModificar.setBackground(new java.awt.Color(255, 102, 0));
        btnModificar.setToolTipText("F5");
        btnModificar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnModificar.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setRippleColor(java.awt.Color.white);
        btnModificar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        Separador6.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo6.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo6.setText("MODIFICAR");

        javax.swing.GroupLayout PnlModificar1Layout = new javax.swing.GroupLayout(PnlModificar1);
        PnlModificar1.setLayout(PnlModificar1Layout);
        PnlModificar1Layout.setHorizontalGroup(
            PnlModificar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlModificar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlModificar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador6)
                    .addComponent(LabelTitulo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlModificar1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        PnlModificar1Layout.setVerticalGroup(
            PnlModificar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlModificar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador6, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(PnlModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, -1));

        PnlActualizar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btn6.setBackground(new java.awt.Color(0, 153, 255));
        btn6.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn6.setForegroundHover(new java.awt.Color(0, 153, 255));
        btn6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btn6.setRippleColor(java.awt.Color.white);
        btn6.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        btn6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn6KeyPressed(evt);
            }
        });

        Separador7.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo7.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo7.setText("ACTUALIZAR");

        javax.swing.GroupLayout PnlActualizarLayout = new javax.swing.GroupLayout(PnlActualizar);
        PnlActualizar.setLayout(PnlActualizarLayout);
        PnlActualizarLayout.setHorizontalGroup(
            PnlActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador7)
                    .addComponent(LabelTitulo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlActualizarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlActualizarLayout.setVerticalGroup(
            PnlActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(PnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, -1));

        PnlEliminarG.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setToolTipText("DELETE");
        btnEliminar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnEliminar.setForegroundHover(new java.awt.Color(255, 0, 0));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminar.setRippleColor(java.awt.Color.white);
        btnEliminar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });

        Separador8.setForeground(new java.awt.Color(204, 204, 204));

        LabelTitulo8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo8.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo8.setText("ELIMINAR");

        javax.swing.GroupLayout PnlEliminarGLayout = new javax.swing.GroupLayout(PnlEliminarG);
        PnlEliminarG.setLayout(PnlEliminarGLayout);
        PnlEliminarGLayout.setHorizontalGroup(
            PnlEliminarGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEliminarGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlEliminarGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador8)
                    .addComponent(LabelTitulo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PnlEliminarGLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        PnlEliminarGLayout.setVerticalGroup(
            PnlEliminarGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEliminarGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Separador8, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelTitulo8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(PnlEliminarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, -1));

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setToolTipText("F12");
        btnSalir.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorIcon(new java.awt.Color(17, 35, 46));
        txtBuscar.setColorMaterial(new java.awt.Color(17, 35, 46));
        txtBuscar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtBuscar.setPhColor(new java.awt.Color(102, 102, 102));
        txtBuscar.setPlaceholder("Buscador de Empleado");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        tablaEmpleados.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEmpleados.setComponentPopupMenu(jPopupMenu1);
        tablaEmpleados.setGridColor(new java.awt.Color(204, 204, 204));
        tablaEmpleados.setRowHeight(20);
        tablaEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaEmpleados.setShowGrid(true);
        tablaEmpleados.setShowVerticalLines(false);
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMousePressed(evt);
            }
        });
        tablaEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaEmpleadosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemPModificarEActionPerformed

    private void itemPEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarActionPerformed(null);
    }//GEN-LAST:event_itemPEliminarEActionPerformed

    private void tablaEmpleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int number = tablaEmpleados.rowAtPoint(p);
            ListSelectionModel modelos = tablaEmpleados.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tablaEmpleadosMousePressed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                dlgGestVendedor ven = new dlgGestVendedor(null, true);
                ven.setLocationRelativeTo(null);
                controlVendedor.aModificar();
                ven.setTitle("Modificación de Empleado");
                dlgGestVendedor.btnModificar.setEnabled(true);
                dlgGestVendedor.btnGuardar.setEnabled(false);
                dlgGestVendedor.btnNuev.setEnabled(false);
                dlgGestVendedor.btnCancelar.setEnabled(true);
                ven.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("No se pudo cargar información del vendedor");
            }
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void tablaEmpleadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaEmpleadosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                dlgGestVendedor ven = new dlgGestVendedor(null, true);
                ven.setLocationRelativeTo(null);
                controlVendedor.aModificar();
                ven.setTitle("Modificación de Empleado");
                dlgGestVendedor.btnModificar.setEnabled(true);
                dlgGestVendedor.btnGuardar.setEnabled(false);
                dlgGestVendedor.btnNuev.setEnabled(false);
                dlgGestVendedor.btnCancelar.setEnabled(true);
                ven.setVisible(true);
            } catch (Exception e) {
                Mensajes.error("No se pudo cagar informacion del Producto" + e.getMessage());

            }
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tablaEmpleadosKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        dlgGestVendedor vend = new dlgGestVendedor(null, true);
        vend.setLocationRelativeTo(null);
        vend.setTitle("Agregar Empleado");
        dlgGestVendedor.btnNuev.doClick();
        vend.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestVendedor ven = new dlgGestVendedor(null, true);
            ven.setLocationRelativeTo(null);
            controlVendedor.aModificar();
            ven.setTitle("Modificación de Empleado");
            dlgGestVendedor.btnModificar.setEnabled(true);
            dlgGestVendedor.btnGuardar.setEnabled(false);
            dlgGestVendedor.btnNuev.setEnabled(false);
            dlgGestVendedor.btnCancelar.setEnabled(true);
            ven.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        txtBuscar.setText("");
        CabecerasTablas.limpiarTablaVendedor(tablaEmpleados);
        controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tablaEmpleados.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlVendedor.delVendedor();
                    CabecerasTablas.limpiarTablaVendedor(tablaEmpleados);
                    controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
                }
            } catch (Exception e) {
                //Mensajes.informacion("Seleccione un fila de la tabla");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        System.out.println(txtBuscar.getText().length());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaEmpleados.requestFocus();
            tablaEmpleados.changeSelection(0, 5, false, false);
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String cod = txtBuscar.getText();
        CabecerasTablas.limpiarTablaVendedor(tablaEmpleados);
        controlVendedor.filNombre(tablaEmpleados, cod);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtBuscar.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cerrar este formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btn6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn6KeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btn6KeyPressed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed


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
            java.util.logging.Logger.getLogger(dlgVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgVendedor dialog = new dlgVendedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitulo5;
    private javax.swing.JLabel LabelTitulo6;
    private javax.swing.JLabel LabelTitulo7;
    private javax.swing.JLabel LabelTitulo8;
    private rojeru_san.rspanel.RSPanelImage PnlActualizar;
    private rojeru_san.rspanel.RSPanelImage PnlEliminarG;
    private rojeru_san.rspanel.RSPanelImage PnlModificar1;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo1;
    private javax.swing.JSeparator Separador5;
    private javax.swing.JSeparator Separador6;
    private javax.swing.JSeparator Separador7;
    private javax.swing.JSeparator Separador8;
    private RSMaterialComponent.RSButtonIconUno btn6;
    private RSMaterialComponent.RSButtonIconUno btnEliminar;
    private RSMaterialComponent.RSButtonIconUno btnModificar;
    private RSMaterialComponent.RSButtonIconUno btnNuevo;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JMenuItem itemPEliminarE;
    private javax.swing.JMenuItem itemPModificarE;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable tablaEmpleados = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static RSMaterialComponent.RSTextFieldMaterialIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
